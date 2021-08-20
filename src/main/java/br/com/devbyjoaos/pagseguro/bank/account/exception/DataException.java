package br.com.devbyjoaos.pagseguro.bank.account.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class DataException extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;

    public DataException(String message, HttpStatus httpStatus){
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
