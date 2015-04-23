package br.com.cepconsumer.rest.client;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class RestClient {

	private ResteasyClient client;

	@PostConstruct
	public void initialize() {
		client = new ResteasyClientBuilder().build();
	}

	public JsonObject getJsonFromService(UriBuilder uri) {
		ResteasyWebTarget target = client.target(uri);
		Response response = target.request().get();

		return new Gson().fromJson(response.readEntity(String.class),
				JsonElement.class).getAsJsonObject();
	}
}