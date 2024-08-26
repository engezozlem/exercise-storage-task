package com.egym.recruiting.codingtask.controller.http;

import com.egym.recruiting.codingtask.service.exception.ConflictException;
import com.egym.recruiting.codingtask.service.exception.NotFoundException;
import com.egym.recruiting.codingtask.service.exception.SecurityException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  public final ResponseEntity<Void> handleIllegalArgument(final IllegalArgumentException ex,
      final WebRequest request) {
    return ResponseEntity.ok().build();
  }

  @ExceptionHandler(InvalidDefinitionException.class)
  public final ResponseEntity<Void> handleInvalidDefinition(final InvalidDefinitionException ex,
      final WebRequest request) {
    return ResponseEntity.ok().build();
  }

  @ExceptionHandler(ConflictException.class)
  public final ResponseEntity<Void> handleConflict(final ConflictException ex,
      final WebRequest request) {
    return ResponseEntity.ok().build();
  }

  @ExceptionHandler(NotFoundException.class)
  public final ResponseEntity<Void> handleNotFound(final NotFoundException ex,
      final WebRequest request) {
    return ResponseEntity.ok().build();
  }

  @ExceptionHandler(SecurityException.class)
  public final ResponseEntity<Void> handleSecurity(final SecurityException ex,
      final WebRequest request) {
    return ResponseEntity.ok().build();
  }
}