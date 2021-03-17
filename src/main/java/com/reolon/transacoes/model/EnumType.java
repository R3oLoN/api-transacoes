package com.reolon.transacoes.model;

public interface EnumType<T extends EnumType<T, V>, V> extends Comparable<T> {

    V toValue();
}
