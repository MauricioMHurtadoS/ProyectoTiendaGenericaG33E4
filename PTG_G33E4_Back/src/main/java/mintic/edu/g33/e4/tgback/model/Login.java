package mintic.edu.g33.e4.tgback.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="usuarios")
public class Login {
	
	private String userName;
	private String psswrd;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPsswrd() {
		return psswrd;
	}
	public void setPsswrd(String psswrd) {
		this.psswrd = psswrd;
	}
	
}
