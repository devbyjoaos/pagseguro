package br.com.devbyjoaos.pagseguro.bank.account.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.util.Objects.isNull;

public class Numbers {


    public static String formatAgencyAndAccount(Long agency, Long accountNumber){
        StringBuilder agencyAndAccount = new StringBuilder();
        agencyAndAccount.append(agency);
        agencyAndAccount.append('/');
        agencyAndAccount.append(formatAccount(accountNumber.toString()));
        return agencyAndAccount.toString();
    }

    private static String formatAccount(String account) {
        if (isNull(account))
            return "";

        StringBuilder buffer = new StringBuilder(account);
        for (int i = 0; i < account.length(); i++) {
            if (i == (account.length()-1))
                buffer.insert(i, "-");

        }
        return buffer.toString();
    }

    public static String formatMoney(String prefix, BigDecimal value) {
        value = nullToZero(value);

        return prefix.concat(
                ptBR_Format(
                        value.setScale(2, RoundingMode.HALF_DOWN).toString()
                )
        );
    }

    public static String formatMoney(BigDecimal value) {
        value = nullToZero(value);

        return ptBR_Format(
                value.setScale(2, RoundingMode.HALF_DOWN).toString()
        );
    }

    private static String ptBR_Format(String value) {

        value = nullToEmpty(value);

        String[] parts = value.split("\\.");
        String fractionPart = parts.length == 2 ? parts[1] : "";

        if (fractionPart.isEmpty()) {
            fractionPart = "00";
        }
        else if (fractionPart.length() == 1) {
            fractionPart = "0".concat(fractionPart);
        }

        return formatThousandPosition(parts[0])
                .concat(",")
                .concat(fractionPart);
    }

    private static String formatThousandPosition(String integerPart) {
        String signal = "";
        if (integerPart.contains("-")) {
            integerPart = integerPart.replaceAll("-", "");
            signal = "-";
        }
        if (integerPart.isBlank()) {
            return "0";
        }

        if (integerPart.length() < 4) {
            return signal + integerPart;
        }

        int index = 0;
        int point = integerPart.length() % 3;

        if (point == 0) {
            point = 3;
        }

        StringBuilder value = new StringBuilder();

        for (; point < integerPart.length(); point += 3) {
            value.append(integerPart.subSequence(index, point)).append(".");
            index = point;
        }

        value.append(integerPart.subSequence(index, point));

        value.insert(0, signal);

        return value.toString();
    }

    private static String nullToEmpty(String value) {
        if(isNull(value))
            value = "";

        return value;
    }

    private static BigDecimal nullToZero(BigDecimal value) {
        if(isNull(value))
            return BigDecimal.ZERO;

        return value;
    }
}
