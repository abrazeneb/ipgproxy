package com.sepacyber.ipgproxy.api.rest.errorhandler;

import com.sepacyber.ipgproxy.shared.exception.IpgVendorIntegrationException;
import com.sepacyber.ipgproxy.shared.exception.OrganizationAdditionalDataNotFoundException;
import com.sepacyber.ipgproxy.shared.exception.OrganizationNotFoundException;
import com.sepacyber.ipgproxy.shared.exception.error.ErrorCode;
import com.sepacyber.ipgproxy.shared.exception.error.ErrorDto;
import com.sepacyber.ipgproxy.shared.exception.error.ErrorWithFieldErrorsDto;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
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

    //TODO: can be refined: for instance handling RetryableException for timeout
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Object> handleFeignException(FeignException ex) {

       var detailError = new ErrorDto.DetailError(ErrorCode.FEIGN_CLIENT_EXCEPTION, ex.getMessage());

       var error = ErrorDto.builder()
               .code(ex.status())
               .message("Api client exception")
               .path(ex.request().url())
               .detailError(detailError)
               .build();

        return new ResponseEntity<Object>(error,  HttpStatus.valueOf(ex.status()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {

        var detailError = new ErrorDto.DetailError(ErrorCode.RUNTIME_ERROR, ex.getMessage());

        var error = ErrorDto.builder()
                .code(ErrorCode.RUNTIME_ERROR)
                .message("Internal server error")
                .detailError(detailError)
                .build();

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler({OptimisticLockingFailureException.class, DataIntegrityViolationException.class})
    public ResponseEntity<ErrorDto> handleConflictException(Exception ex) {

        var error = ErrorDto.builder()
                .code(ErrorCode.RUNTIME_ERROR)
                .message(ex.getMessage())
                .build();


        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {

        var error = ErrorDto.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Method argument type mismatch")
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var result = ex.getBindingResult();

        var error = ErrorWithFieldErrorsDto.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(String.join(" ","Field Error", LocaleContextHolder.getLocale().toString()))
                .build();

        var fieldErrors = new ArrayList<ErrorWithFieldErrorsDto.FieldError>();

        result.getFieldErrors()
                .forEach(err -> fieldErrors.add(new ErrorWithFieldErrorsDto.FieldError(err.getField(),
                        String.join("", err.getDefaultMessage(), "Validator error for field: ", err.getField(), LocaleContextHolder.getLocale().toString()))));

        error.setFieldErrors(fieldErrors);

        return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);
    }

}
