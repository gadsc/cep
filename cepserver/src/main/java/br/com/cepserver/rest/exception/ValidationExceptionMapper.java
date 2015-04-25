package br.com.cepserver.rest.exception;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.api.validation.ResteasyConstraintViolation;
import org.jboss.resteasy.api.validation.ResteasyViolationException;

@Provider
public class ValidationExceptionMapper implements
		ExceptionMapper<ValidationException> {
	@Override
	public Response toResponse(ValidationException exception) {
		if (exception instanceof ResteasyViolationException) {
			ResteasyViolationException restEasyException = (ResteasyViolationException) exception;
			ResteasyConstraintViolation violation = (ResteasyConstraintViolation) restEasyException
					.getParameterViolations().iterator().next();

			return Response.status(Status.BAD_REQUEST)
					.entity(violation.getMessage()).build();
		}

		return Response.status(Status.BAD_REQUEST).entity(exception.getMessage())
				.build();
	}
}