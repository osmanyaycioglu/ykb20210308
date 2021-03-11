package com.training.micro.error;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.training.micro.error.client.RestClientException;

@RestControllerAdvice
public class ErrorAdvice {

    @Autowired
    private ErrorConfig errConf;

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleError(final IllegalArgumentException exp) {
        return this.errConf.createBaseError()
                           .setDesc("Error : " + exp.getMessage())
                           .setCause(100);
    }

    @ExceptionHandler(RestClientException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorObject handleError(final RestClientException exp) {
        return this.errConf.createBaseError()
                           .setDesc("Error while calling another MS ")
                           .setCause(300)
                           .addSubErrorObject(exp.getErrorObject());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleError(final MethodArgumentNotValidException exp) {
        ErrorObject errLoc = this.errConf.createBaseError()
                                         .setDesc("Validation Error")
                                         .setCause(1000);
        List<ObjectError> allErrorsLoc = exp.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            errLoc.addSubErrorObject(this.errConf.createBaseError()
                                                 .setDesc(objectErrorLoc.toString())
                                                 .setCause(1001));
        }
        return errLoc;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleError(final ConstraintViolationException exp) {
        ErrorObject errLoc = this.errConf.createBaseError()
                                         .setDesc("Validation Error")
                                         .setCause(1000);
        Set<ConstraintViolation<?>> allErrorsLoc = exp.getConstraintViolations();
        for (ConstraintViolation objectErrorLoc : allErrorsLoc) {
            errLoc.addSubErrorObject(this.errConf.createBaseError()
                                                 .setDesc(objectErrorLoc.toString())
                                                 .setCause(1001));
        }
        return errLoc;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleError(final Exception exp) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(this.errConf.createBaseError()
                                               .setDesc("Error : " + exp.getMessage())
                                               .setCause(100));

    }


}
