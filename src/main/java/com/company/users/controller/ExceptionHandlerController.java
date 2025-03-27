package com.company.users.controller;


import com.company.users.dto.ErrorDto;
import com.company.users.dto.ErrorResponseDto;
import com.company.users.exception.UserNotFoundException;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

  @ExceptionHandler({AccessDeniedException.class})
  public ResponseEntity<ErrorResponseDto> handle(AccessDeniedException ex) {
    log.info("AccessDenied: {}", ex.getLocalizedMessage());
    ErrorResponseDto errorsDto = new ErrorResponseDto();
    ErrorDto errorDto = new ErrorDto();
    errorDto.setTimeStamp(LocalDateTime.now().toString());
    errorDto.setCode(403);
    errorDto.setDetail("Access denied");
    errorsDto.getError().add(errorDto);
    return new ResponseEntity<>(errorsDto, HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponseDto> handle(UserNotFoundException ex) {
    log.info("User not found: {}", ex.getLocalizedMessage());
    ErrorResponseDto errorsDto = new ErrorResponseDto();
    ErrorDto errorDto = new ErrorDto();
    errorDto.setTimeStamp(LocalDateTime.now().toString());
    errorDto.setCode(404);
    errorDto.setDetail("User not found");
    errorsDto.getError().add(errorDto);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorsDto);
  }


  @ExceptionHandler({MethodArgumentNotValidException.class})
  public ResponseEntity<ErrorResponseDto> handle(MethodArgumentNotValidException ex) {
    log.info("Invalid input data");
    ErrorResponseDto errorsDto = new ErrorResponseDto();
    ErrorDto errorDto = new ErrorDto();
    errorDto.setTimeStamp(LocalDateTime.now().toString());
    errorDto.setCode(400);
    errorDto.setDetail("Invalid input data");
    errorsDto.getError().add(errorDto);
    return new ResponseEntity<>(errorsDto, HttpStatus.BAD_REQUEST);
  }
}
