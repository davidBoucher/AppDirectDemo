package main.java.app.accounts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.app.model.Event;
import main.java.app.model.UserAccount;

public class AccountsAdapter {

	private static final Logger logger = LoggerFactory
			.getLogger(AccountsAdapter.class);
	
	public static UserAccount CreateAccount(Event event) {
		
		logger.info("Parsing event information to create a new account.");
		
		// This is kept simple, any null value would break this...
		String id = event.getPayload().getAccount().getAccountIdentifier();
		String status = event.getPayload().getAccount().getStatus();
		String edition = event.getPayload().getOrder().getEditionCode();
		
		return new UserAccount(id, status, edition);
	}
	
}
