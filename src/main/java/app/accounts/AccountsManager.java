package main.java.app.accounts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import main.java.app.model.UserAccount;

/*
 * Really the fastest mock persistence I could create. Only lasts while the program runs... 
 * */
@Component
public class AccountsManager {
	
	private ArrayList<UserAccount> accounts = new ArrayList<UserAccount>();
	
	public void addAccount(UserAccount account) {
		accounts.add(account);
	}
	
	public List<UserAccount> getAccounts() {
		return accounts;
	}
	

}
