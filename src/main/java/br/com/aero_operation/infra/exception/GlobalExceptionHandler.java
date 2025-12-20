package br.com.aero_operation.infra.exception;

import br.com.aero_operation.dtos.ErrorResponseDto;
import org.apache.coyote.BadRequestException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDto> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDto(ex));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> badRequestException(MethodArgumentNotValidException exception){
        var error = exception.getFieldErrors(); /* -> Rewtorna uma lista de erros */

        /* Esta sendo convertido para um dto com o campo e a message de erro */
        return ResponseEntity.badRequest().body(error.stream().map(DataValidationException::new).toList());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDto> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDto(ex));
    }

    @ExceptionHandler(InvalidArrivalTimeException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidArrivalTimeException(InvalidArrivalTimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDto(ex));
    }

    @ExceptionHandler(InvalidPriceException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidPriceException(InvalidPriceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDto(ex));
    }

    private record DataValidationException(String field, String message){

        public DataValidationException(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }

    }


}