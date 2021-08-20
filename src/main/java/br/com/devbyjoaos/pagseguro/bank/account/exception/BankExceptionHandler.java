package br.com.devbyjoaos.pagseguro.bank.account.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Locale;
import java.util.Objects;

@ControllerAdvice
@Slf4j
public class BankExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataException.class)
    protected ResponseEntity<Object> handleConflict(DataException ex, WebRequest request){
        return this.handleExceptionInternal(ex, null, new HttpHeaders(), ex.getHttpStatus(), request);
    }


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request){
        DataExceptionDto dataException = new DataExceptionDto(
                new Date(),
                ex.getMessage(),
                Objects.requireNonNullElse(status, HttpStatus.INTERNAL_SERVER_ERROR).value(),
                Objects.requireNonNullElse(status, HttpStatus.INTERNAL_SERVER_ERROR).getReasonPhrase(),
                request.getDescription(false));

        return  new ResponseEntity(dataException,
                headers,
                Objects.requireNonNullElse(status, HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
