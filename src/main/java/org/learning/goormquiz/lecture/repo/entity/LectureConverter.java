package org.learning.goormquiz.lecture.repo.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;

@Converter
public class LectureConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return "";
        } else {
            return String.join("|", strings);
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String s) {
        if (s == null || s.isEmpty()) {
            return List.of();
        } else {
            return List.of(s.split("\\|"));
        }

    }
}
