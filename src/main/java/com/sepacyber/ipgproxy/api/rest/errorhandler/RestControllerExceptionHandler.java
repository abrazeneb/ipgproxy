package com.sepacyber.ipgproxy.api.rest.errorhandler;

import com.sepacyber.ipgproxy.shared.exception.IpgVendorIntegrationException;
import com.sepacyber.ipgproxy.shared.exception.OrganizationAdditionalDataNotFoundException;
import com.sepacyber.ipgproxy.shared.exception.OrganizationNotFoundException;
import com.sepacyber.ipgproxy.shared.exception.error.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;

@RestControllerAdvice
@Slf4j
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

   @ExceptionHandler(OrganizationNotFoundException.class)
    public ResponseEntity<Object> handleOrganizationNotFoundException(OrganizationNotFoundException ex) {
        return new ResponseEntity<>(ex.getError(), HttpStatus.NOT_FOUND);
   }

    @ExceptionHandler(OrganizationAdditionalDataNotFoundException.class)
    public ResponseEntity<ErrorDto> handleOrganizationConfigurationException(OrganizationAdditionalDataNotFoundException ex) {
        return new ResponseEntity<>(ex.getError(), HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler(IpgVendorIntegrationException.class)
    public ResponseEntity<ErrorDto> handleIpgVendorIntegrationException(IpgVendorIntegrationException ex) {
        return new ResponseEntity<>(ex.getError(), HttpStatus.BAD_REQUEST);
    }
   

    @Override
    public  ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var result = ex.getBindingResult();

        var errorResponse = ErrorDto.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(String.join(" ","Field Error", LocaleContextHolder.getLocale().toString()))
                .build();

        var fieldErrors = new ArrayList<ErrorDto.FieldError>();

        result.getFieldErrors()
                .forEach(error -> fieldErrors.add(new ErrorDto.FieldError(error.getField(),
                        String.join("", error.getDefaultMessage(), "Validator error for field: ", error.getField(), LocaleContextHolder.getLocale().toString()))));

        errorResponse.setFieldErrors(fieldErrors);

        return new ResponseEntity<>(errorResponse, headers, HttpStatus.BAD_REQUEST);
    }

}
