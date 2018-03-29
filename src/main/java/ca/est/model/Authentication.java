package ca.est.model;
/**
 * 
 * @author Estevam Meneses
 */
public class Authentication {
	
	private String username;
	private String password;
	
	public Authentication() {
		setUsername("admin");
		setPassword("admin");
	}

	private void setUsername(String username) {
		this.username = username;
	}
	
	private String getUsername(){
		return this.username;
	}

	private void setPassword(String password) {
		this.password = password;
	}
	
	private String getPassword(){
		return this.password;
	}
	
	public Boolean authenticate(String username, String password){
		if(username.equals(getUsername()) && password.equals(getPassword())){
			return true;
		}
		return false;
	}

}
