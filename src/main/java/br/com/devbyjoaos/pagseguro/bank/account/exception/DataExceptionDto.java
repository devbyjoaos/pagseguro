package br.com.devbyjoaos.pagseguro.bank.account.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataExceptionDto {

    private Date timestamp;
    private String message;
    private int status;
    private String error;
    private String path;
}
