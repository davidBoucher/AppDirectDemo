package main.java.app.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")  
public class Response {

	private boolean success;
	private String message;
	private String accountIdentifier; // optional
	
	public enum ERROR_CODE {
		USER_ALREADY_EXISTS,
		USER_NOT_FOUND,
		ACCOUNT_NOT_FOUND,
		MAX_USERS_REACHED,
		UNAUTHORIZED,
		OPERATION_CANCELED,
		CONFIGURATION_ERROR,
		INVALID_RESPONSE,
		UNKNOWN_ERROR
	}
	
	public Response() {
		// default constructor, needed by Spring
	}
	
	/**
	 * Create a response XML to send back to AppDirect
	 * @param success, true if the operation succeeded.
	 * @param message, if the operation failed, the message should be one an ERROR_CODE.
	 * @param accountIdentifier, optional, the account identifier.
	 */
	public Response(boolean success, String message, String accountIdentifier) {
		this.success = success;
		this.message = message;
		this.accountIdentifier = accountIdentifier;
	}
	
	/**
	 * Create an error response XML to send back to AppDirect
	 * @param message, an ERROR_CODE for this error response.
	 */
	public Response(ERROR_CODE message) {
		this.success = false;
		this.message = message.name();
	}


	@XmlElement
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	@XmlElement
	public void setMessage(String message) {
		this.message = message;
	} 

	@XmlElement  
	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
	
	public boolean getSuccess() {
		return success;
	}
	
	public String getMessage() {
		return message;
	} 

	public String getAccountIdentifier() {
		return accountIdentifier;
	}
}
