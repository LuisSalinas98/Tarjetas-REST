package com.ibm.academia.restapi.tarjetas.excepciones.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.academia.restapi.tarjetas.excepciones.BadRequestException;
import com.ibm.academia.restapi.tarjetas.excepciones.NotFoundException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ApiUniversidadMException {

	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<Object> noExisteException(NotFoundException exception){
		
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("error", exception.getMessage());
		
		return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<Object> parametrosIncompletosException(MissingServletRequestParameterException exception){

		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("error", "Faltan parametros");

		return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> valorParametrosException(MethodArgumentTypeMismatchException exception){

		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("error", "Uno de los parametros es invalido");

		return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<Object> formatoInvalidoException(BadRequestException exception){
		
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("error", exception.getMessage());
		
		return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
	}
}
