package com.icds.abertura_conta.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.icds.abertura_conta.model.dto.ApiErrorDTO;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ApiException.class })
	public ResponseEntity<ApiErrorDTO> handleApiException(ApiException ex, WebRequest request) {
		String error = "Erro no sistema";
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler({ EntityNotFoundException.class })
	public ResponseEntity<ApiErrorDTO> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
		String error = "Recurso não encontrado";
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	@ExceptionHandler( { EntityAlreadyExistsException.class } )
	public ResponseEntity<ApiErrorDTO> handleEntityAlreadyExistsException(EntityAlreadyExistsException ex, WebRequest request){
		String error = "Recurso já existe";
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.CONFLICT);
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
	}

}
