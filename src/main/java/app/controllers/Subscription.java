package main.java.app.controllers;

import main.java.app.Authenticator.IAuthenticator;
import main.java.app.accounts.AccountsAdapter;
import main.java.app.accounts.AccountsManager;
import main.java.app.model.Event;
import main.java.app.model.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Subscription {

	private static final Logger logger = LoggerFactory
			.getLogger(Subscription.class);
	private IAuthenticator authenticator;
	private AccountsManager accountsManager;

	@Autowired
	public Subscription(IAuthenticator authenticator, AccountsManager accountsManager) {
		this.authenticator = authenticator;
		this.accountsManager = accountsManager;
	}

	@RequestMapping("/create")
	public @ResponseBody Response create(@RequestHeader HttpHeaders headers) {

		logger.info("New 'order' received from AppDirect.");

		if (authenticator.validate(headers)) {

			Event event = authenticator.getDetails();
			
			if(event == null)
				return new Response(Response.ERROR_CODE.UNKNOWN_ERROR);
			
			accountsManager.addAccount(AccountsAdapter.CreateAccount(event));
			
			
		} else {
			// Unauthorized request
			logger.info("UNAUTHORIZED request.");
			return new Response(Response.ERROR_CODE.UNAUTHORIZED);
		}

		return new Response(true, "order: test ok", "YO");
	}

	@RequestMapping("/change")
	public void change(@RequestHeader HttpHeaders headers) {

		logger.info("New 'change' received from AppDirect.");

	}

	@RequestMapping("/cancel")
	public void cancel(@RequestHeader HttpHeaders headers) {

		logger.info("New 'cancel' received from AppDirect.");

	}

	@RequestMapping("/notice")
	public void notice(@RequestHeader HttpHeaders headers) {

		logger.info("New 'notice' received from AppDirect.");

	}

}