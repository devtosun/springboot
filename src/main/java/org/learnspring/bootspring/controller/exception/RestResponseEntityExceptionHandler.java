package org.learnspring.bootspring.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // @ExceptionHandler(value = {IllegalArgumentException.class,
    // IllegalStateException.class})
    // protected ResponseEntity<Object> handleConflict(RuntimeException ex,
    // WebRequest request){
    // String body =
    // "org.learnspring.bootspring.controller.exception.RestResponseEntityExceptionHandler";
    // return handleExceptionInternal(ex, body, new HttpHeaders(),
    // HttpStatus.CONFLICT, request);
    // }

    /*
     * @ExceptionHandler notasyonu ile istedigimiz Exception'lari handle ediyoruz
     */
    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<ErrorDiscription> handleConflict(RuntimeException ex, WebRequest request) {
        ErrorDiscription bodyOfResponse = new ErrorDiscription();
        bodyOfResponse.setCode(1200);
        bodyOfResponse.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorDiscription>(bodyOfResponse, HttpStatus.CONFLICT); // Conflict 409
    }

    /*
     * Handle edilmeyen butun exceptionlar buraya dusecek
     */
    @ExceptionHandler(value = Exception.class) // (value = Exception.class)
    protected ResponseEntity<ErrorDiscription> handleMyException(Exception ex, WebRequest request) {
        ErrorDiscription bodyOfResponse = new ErrorDiscription();
        bodyOfResponse.setCode(1000);
        bodyOfResponse.setMessage(ex.getMessage());
        ex.printStackTrace();
        return new ResponseEntity<ErrorDiscription>(bodyOfResponse, HttpStatus.CONFLICT); // Conflict 409
    }

}