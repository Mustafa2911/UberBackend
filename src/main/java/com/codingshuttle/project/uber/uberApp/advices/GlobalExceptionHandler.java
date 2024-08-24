package com.codingshuttle.project.uber.uberApp.advices;

import com.codingshuttle.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.codingshuttle.project.uber.uberApp.exceptions.RuntimeConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ResourceNotFoundException exception){
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
        return   buildErrorResponseEntity(apiError);
    }
    @ExceptionHandler(RuntimeConflictException.class)
    public ResponseEntity<ApiResponse<?>> handleRuntimeConflictException(RuntimeConflictException exception){
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.CONFLICT)
                .message(exception.getMessage())
                .build();
        return   buildErrorResponseEntity(apiError);
    }

    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception exception){
        ApiError apiError= ApiError.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(exception.getMessage()).build();
        return  buildErrorResponseEntity(apiError);
    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiResponse<?>> handleInputError(MethodArgumentNotValidException exception){
//        List<String> errors= exception
//                .getBindingResult()
//                .getAllErrors()
//                .stream()
//                .map(objectError -> objectError.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        ApiError apiError= ApiError.builder().status(HttpStatus.BAD_REQUEST).message("Validation Failed").subError(errors).build();
//        return  buildErrorResponseEntity(apiError);
//    }
//    @ExceptionHandler(BadCredentialsException.class)
//    ResponseEntity<ApiResponse<?>> handleBadCredentailsException(BadCredentialsException e){
//        ApiError apiError=ApiError.builder().status(HttpStatus.BAD_REQUEST).message(e.getMEssage()).build();
//        return new ResponseEntity<>(new ApiResponse<>(apiError),HttpStatus.BAD_REQUEST);
//    }
}
