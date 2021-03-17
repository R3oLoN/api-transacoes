package com.reolon.transacoes.hibernate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.reolon.transacoes.model.transacoes.OperationType;

import static java.util.Objects.isNull;

@Converter(autoApply = true)
public class OperationTypeConverter implements AttributeConverter<OperationType, String>{
    @Override
    public String convertToDatabaseColumn(OperationType enumType) {
        if (isNull(enumType)) {
            return null;
        }
        return enumType.toValue();
    }

    @Override
    public OperationType convertToEntityAttribute(String value) {
        if (isNull(value)) {
            return null;
        }
        return OperationType.fromValue(value);
    }
}
