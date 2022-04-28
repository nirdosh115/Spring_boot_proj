package com.example.demo.exceptions;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.entity.ErrorObject;

@ControllerAdvice
public class globalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorObject> handleExpenseNotFound(ResourceNotFoundException ex, WebRequest request){
		ErrorObject err=new ErrorObject();
		err.setStatusCode(HttpStatus.NOT_FOUND.value());
		err.setMessage(ex.getMessage());
		err.setTimestamp( new Date());
		return new ResponseEntity<ErrorObject>(err,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorObject> handleArgumentMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request){
		ErrorObject err=new ErrorObject();
		err.setStatusCode(HttpStatus.BAD_REQUEST.value());
		err.setMessage(ex.getMessage());
		err.setTimestamp( new Date());
		return new ResponseEntity<ErrorObject>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorObject> handleGeneralException(Exception ex, WebRequest request){
		ErrorObject err=new ErrorObject();
		err.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		err.setMessage(ex.getMessage());
		err.setTimestamp( new Date());
		return new ResponseEntity<ErrorObject>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(itemAlreadyExistsException.class)
	public ResponseEntity<ErrorObject> handleItemExistException(itemAlreadyExistsException ex, WebRequest request){
		ErrorObject err=new ErrorObject();
		err.setStatusCode(HttpStatus.CONFLICT.value());
		err.setMessage(ex.getMessage());
		err.setTimestamp( new Date());
		return new ResponseEntity<ErrorObject>(err,HttpStatus.CONFLICT) 	;
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
				
		
		Map<String,Object>  body= new HashMap<String,Object>();
		body.put("timestamp", new Date());
		body.put("statusCode", HttpStatus.BAD_REQUEST.value());
		List<String> err_message=ex.getBindingResult().getFieldErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.toList());
		
		body.put("message",err_message);
		
		return new ResponseEntity<Object> (body,HttpStatus.BAD_REQUEST);
	}
	
	
}
