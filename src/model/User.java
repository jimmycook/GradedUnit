package model;

public class User {
	
	private int personID;
	private String username;
	private String password;
	private int coachOf;
	private boolean isAdmin;
	
	public User(){
		
	}
	
	public User(Person p, String username, String password){
		this.username = username;
		this.password = password;
		personID = p.getID();
	}

	/**
	 * @return the personID
	 */
	public int getPersonID() {
		return personID;
	}

	/**
	 * @param personID the personID to set
	 */
	public void setPersonID(int personID) {
		this.personID = personID;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the coachOf
	 */
	public int getCoachOf() {
		return coachOf;
	}

	/**
	 * @param coachOf the coachOf to set
	 */
	public void setCoachOf(int coachOf) {
		this.coachOf = coachOf;
	}

	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}