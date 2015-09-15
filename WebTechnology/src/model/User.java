package model;
/**
 * Class which contains a username and password.
 * @author chris
 *
 */
public abstract class User {

	private String username;
	private String password;
	
	/**
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

 
	
	
	
	
	
	
}
