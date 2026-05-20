package com.teacompanion.TEACompanion_API.Config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.LocalDateTime;

@Converter(autoApply = true)
public class LocalDateTimeStringConverter implements AttributeConverter<LocalDateTime, String> {

    @Override
    public String convertToDatabaseColumn(LocalDateTime dataDoJava) {
        if (dataDoJava == null) {
            return null;
        }
        return dataDoJava.toString(); 
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String dataDoBanco) {
        if (dataDoBanco == null || dataDoBanco.trim().isEmpty()) {
            return null;
        }
        return LocalDateTime.parse(dataDoBanco);
    }
}
