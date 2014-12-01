package main.java.app.controllers;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.app.accounts.AccountsManager;
import main.java.app.model.UserAccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class Accounts implements Controller {
	
	private static final Logger logger = LoggerFactory
			.getLogger(Accounts.class);

	@Resource(name = "accountsManager")
	private AccountsManager accountsManager;
//
//	@ModelAttribute("UserAccounts")
//	public List<UserAccount> getAccounts() {
//		return accountsManager.getAccounts();
//	}

//	@RequestMapping(value = "accounts", method = RequestMethod.GET)
//	public String displayAccounts(HttpServletRequest request) {
//		logger.info("Request to list all accounts received.");
//		
//		return "test";
////		return new ModelAndView("stuff.jsp", "UserAccounts", accountsManager);
//	}
//	
//	@RequestMapping("/greeting")
//    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "stuff";
//    }
//
//	@Override
//	public Class<? extends Annotation> annotationType() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String value() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return new ModelAndView("stuff");
	}

}
