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

import com.example.demo.entity.generic_exc_obj;

@ControllerAdvice
public class globalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(genericException.class)
	private ResponseEntity<generic_exc_obj> genericExceptionHandler(genericException ex, WebRequest req){
		
		generic_exc_obj err_obj= new generic_exc_obj();
		err_obj.setResponse_Code(HttpStatus.NOT_FOUND.value());
		err_obj.setMessage(ex.getMessage());
		err_obj.setDate(new Date());
		
		return new ResponseEntity<generic_exc_obj> (err_obj , HttpStatus.NOT_FOUND);	
		
		
	}
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<generic_exc_obj> handleArgumentMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request){
		generic_exc_obj err=new generic_exc_obj();
		err.setResponse_Code(HttpStatus.BAD_REQUEST.value());
		err.setMessage(ex.getMessage());
		err.setDate( new Date());
		return new ResponseEntity<generic_exc_obj>(err,HttpStatus.BAD_REQUEST);
		
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
	@ExceptionHandler(Exception.class)
	public ResponseEntity<generic_exc_obj> handleGeneralException(Exception ex, WebRequest request){
		generic_exc_obj err=new generic_exc_obj();
		err.setResponse_Code(HttpStatus.INTERNAL_SERVER_ERROR.value());
		err.setMessage(ex.getMessage());
		err.setDate( new Date());
		return new ResponseEntity<generic_exc_obj>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
