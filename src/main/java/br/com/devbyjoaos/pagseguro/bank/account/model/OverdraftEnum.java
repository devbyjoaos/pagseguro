package br.com.devbyjoaos.pagseguro.bank.account.model;

public enum OverdraftEnum {

    HAVE(1, "Liberado"),
    DONT_HAVE(0, "Não liberado");

    private int id;
    private String name;

    OverdraftEnum(int id, String name){
        this.id = id;
        this.name = name;
    }


}
