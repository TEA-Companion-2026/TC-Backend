package com.teacompanion.TEACompanion_API.Config;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LocalTimeStringConverter implements AttributeConverter<LocalTime, String> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public String convertToDatabaseColumn(LocalTime localTime) {
        return (localTime != null) ? localTime.format(FORMATTER) : null;
    }

    @Override
    public LocalTime convertToEntityAttribute(String dbData) {
        return (dbData != null && !dbData.isBlank()) ? LocalTime.parse(dbData, FORMATTER) : null;
    }
}
