package br.com.cepserver.rest.exception;

public class CepServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public CepServiceException(final String message) {
		super(message);
	}
}
