package br.com.devbyjoaos.pagseguro.bank.account.model;


import br.com.devbyjoaos.pagseguro.bank.account.utils.EnumWithId;
import br.com.devbyjoaos.pagseguro.bank.account.utils.EnumWithIdConverter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum OverdraftEnum implements EnumWithId {

    DONT_HAVE(0, "Não liberado"),
    HAVE(1, "Liberado");

    private Integer id;
    private String name;

    public static OverdraftEnum fromId(Integer id) {
        if (id == null)
            return null;
        for (OverdraftEnum enumValue : OverdraftEnum.values()) {
            if (enumValue.id == (id)) {
                return enumValue;
            }
        }
        throw new IllegalArgumentException();
    }

    public static class OverdraftEnumConverter extends EnumWithIdConverter<OverdraftEnum> {

        protected  OverdraftEnumConverter(){
            super(OverdraftEnum.values());
        }

    }


}
