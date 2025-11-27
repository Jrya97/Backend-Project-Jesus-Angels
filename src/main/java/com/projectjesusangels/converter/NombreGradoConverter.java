package com.projectjesusangels.converter;

import com.projectjesusangels.enums.NombreGrado;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class NombreGradoConverter implements AttributeConverter<NombreGrado, String> {

    @Override
    public String convertToDatabaseColumn(NombreGrado nombreGrado) {
        if (nombreGrado == null) {
            return null;
        }
        return nombreGrado.getDisplayName();
    }

    @Override
    public NombreGrado convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(NombreGrado.values())
                .filter(c -> c.getDisplayName().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No enum constant for value: " + code));
    }
}
