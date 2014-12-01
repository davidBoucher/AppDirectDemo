package main.java.app.Authenticator;

import main.java.app.model.Event;

import org.springframework.http.HttpHeaders;

public interface IAuthenticator {

	public boolean validate(HttpHeaders headers);
	
	public Event getDetails();
	
}
