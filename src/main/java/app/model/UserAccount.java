package main.java.app.model;

public class UserAccount {

	private String id;
	private String status;
	private String edition;
	
	public UserAccount(String id, String status, String edition) {
		super();
		this.id = id;
		this.status = status;
		this.edition = edition;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
}
