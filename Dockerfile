# Estágio 1: Build da aplicação usando Maven e Temurin Java 25
FROM maven:3.9.6-eclipse-temurin-25 AS build
WORKDIR /app

# Copia o pom.xml e baixa as dependências (otimiza o cache do Docker)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código fonte e realiza o build do JAR executável
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Ambiente de execução leve com Temurin Java 25 e suporte a SQLite
FROM eclipse-temurin:25-jre-jammy
WORKDIR /app

# Instala o utilitário do sqlite3 necessário para ler o banco se precisar de debug no container
RUN apt-get update && apt-get install -y sqlite3 && rm -rf /var/lib/apt/lists/*

# CRUCIAL: Cria o diretório onde o volume persistente do Render será montado
RUN mkdir -p /data && chmod 777 /data

# Copia o JAR gerado no estágio anterior
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão
EXPOSE 8080

# Define variáveis de ambiente padrão para o Spring
ENV PORT=8080
ENV SPRING_DATASOURCE_URL=jdbc:sqlite:/data/mydb.db

# Comando para iniciar a aplicação apontando para a porta dinâmica do Render
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]