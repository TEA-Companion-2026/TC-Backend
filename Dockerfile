# Estágio 1: Build da aplicação usando a imagem que você encontrou + instalação do Maven
FROM openjdk:25-ea-21-jdk-slim AS build
WORKDIR /app

# Instala o Maven manualmente (leve e direto dos repositórios oficiais)
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Copia as configurações do projeto para baixar as dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código fonte e gera o JAR
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Ambiente de execução leve com o mesmo JDK 25
FROM openjdk:25-ea-21-jdk-slim
WORKDIR /app

# Instala o utilitário do sqlite3 para a persistência e diagnósticos se necessário
RUN apt-get update && apt-get install -y sqlite3 && rm -rf /var/lib/apt/lists/*

# Cria a pasta do volume do Render onde o SQLite salvará os dados com segurança
RUN mkdir -p /data && chmod 777 /data

# Copia o JAR do estágio de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENV PORT=8080
ENV SPRING_DATASOURCE_URL=jdbc:sqlite:/data/mydb.db

ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]