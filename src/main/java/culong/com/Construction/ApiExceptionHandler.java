package culong.com.Construction;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
	

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage handleAllException(Exception ex, WebRequest request) {
		return new ErrorMessage(10001, ex.getLocalizedMessage());

		
	}

	
	
	@ExceptionHandler({ ServiceException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage TodoException(ServiceException ex, WebRequest request) {
		return new ErrorMessage(ex.getStatusCode(), ex.getMessage());
	}
	

}
