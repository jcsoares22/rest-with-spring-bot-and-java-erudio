package br.com.systec.exeptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.systec.exeptions.ExceptionResponse;
import br.com.systec.exeptions.ResouceNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse excetionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity<>(excetionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResouceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(Exception ex, WebRequest request) {
		ExceptionResponse excetionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(), 
				request.getDescription(false));
		return new ResponseEntity<>(excetionResponse, HttpStatus.NOT_FOUND);
	}
	
}
