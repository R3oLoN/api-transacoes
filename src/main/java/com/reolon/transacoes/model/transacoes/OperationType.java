package com.reolon.transacoes.model.transacoes;

import com.reolon.transacoes.model.EnumType;
import java.util.stream.Stream;

import java.util.Objects;

public enum OperationType implements EnumType<OperationType, String>{
    COMPRA_A_VISTA("CA"),
    COMPRA_PARCELADA("CP"),
    SAQUE("SQ"),
    PAGMENTO("PG");

    private String value;

    OperationType(final String value) {
        this.value = value;
    }

    @Override
    public String toValue() {
        return value;
    }

    public static OperationType fromValue(String value) {
        return Stream.of(OperationType.values())
            .filter(ot -> Objects.equals(ot.toValue(), value))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
