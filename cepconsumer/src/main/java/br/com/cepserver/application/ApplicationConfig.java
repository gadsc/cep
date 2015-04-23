package br.com.cepserver.application;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.cepserver.rest.exception.ValidationExceptionMapper;
import br.com.cepserver.rest.service.EnderecoCrudService;

@ApplicationPath("/")
public class ApplicationConfig extends Application {
	private final Set<Class<?>> classes;

	public ApplicationConfig() {
		Set<Class<?>> c = new HashSet<>();
		c.add(EnderecoCrudService.class);
		c.add(ValidationExceptionMapper.class);

		classes = Collections.unmodifiableSet(c);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
}
