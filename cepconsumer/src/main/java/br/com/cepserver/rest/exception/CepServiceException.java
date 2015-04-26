package br.com.cepserver.rest.exception;

/**
 * Exception customizada para ser lançada ao consumir o serviço de buscar cep
 * 
 * @author Gabz
 *
 */
public class CepServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public CepServiceException(final String message) {
		super(message);
	}
}
