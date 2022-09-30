package com.pokebattle.pokebattleapi.exceptions.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.swagger.v3.oas.annotations.Hidden;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Hidden
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationExceptionDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ValidationExceptionDto> exceptionDtoList = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(error -> {
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            ValidationExceptionDto exceptionDto = new ValidationExceptionDto(error.getField(), message);

            exceptionDtoList.add(exceptionDto);
        });

        return exceptionDtoList;
    }

    @Hidden
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    protected List<ValidationExceptionDto> handleConstraintViolationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

        System.out.println(ex);

        List<ValidationExceptionDto> exceptionDtoList = new ArrayList<>();
        constraintViolations.forEach(error -> {
            System.out.println(error);

            String message = error.getMessage();

            ValidationExceptionDto exceptionDto = new ValidationExceptionDto(error.getPropertyPath().toString(), message);

            exceptionDtoList.add(exceptionDto);
        });

        return exceptionDtoList;
    }

}
