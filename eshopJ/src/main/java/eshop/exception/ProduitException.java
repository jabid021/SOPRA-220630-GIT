package eshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProduitException extends RuntimeException {
	public ProduitException() {
		super();
	}

	public ProduitException(String message) {
		super(message);
	}

}
