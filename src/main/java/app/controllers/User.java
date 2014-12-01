package main.java.app.controllers;

import main.java.app.model.Response;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {

	@RequestMapping("/assign")
    public Response assign() {
		return null;
	}
	
	@RequestMapping("/unassign")
    public Response unassign() {
		return null;
	}
}
