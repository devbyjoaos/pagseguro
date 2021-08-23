package br.com.devbyjoaos.pagseguro.bank.account.utils;

import br.com.devbyjoaos.pagseguro.bank.account.model.OverdraftEnum;

import javax.persistence.AttributeConverter;
import java.util.Objects;

public abstract class EnumWithIdConverter <E extends OverdraftEnum> implements AttributeConverter<E, Integer> {

    private E[] values;

    protected EnumWithIdConverter(E[] values) {
        this.values = values;
    }

    @Override
    public Integer convertToDatabaseColumn(E attribute) {
        if (Objects.isNull(attribute))
            return null;
        return attribute.getId();
    }

    @Override
    public E convertToEntityAttribute(Integer data) {
        if (Objects.isNull(data))
            return null;

        for (E value : values) {
            if (value.getId() == data.intValue())
                return value;
        }

        return null;
    }

}

