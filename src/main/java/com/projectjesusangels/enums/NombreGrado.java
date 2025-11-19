package com.projectjesusangels.enums;

public enum NombreGrado {
    CUATRO_AÑOS("4 AÑOS"),
    CINCO_AÑOS("5 AÑOS"),
    PRIMER_GRADO("1 GRADO"),
    SEGUNDO_GRADO("2 GRADO"),
    TERCER_GRADO("3 GRADO"),
    CUARTO_GRADO("4 GRADO"),
    QUINTO_GRADO("5 GRADO"),
    SEXTO_GRADO("6 GRADO");

    private final String displayName;

    NombreGrado(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
