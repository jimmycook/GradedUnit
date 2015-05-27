package model;

import java.io.Serializable;
import java.util.Date;

public abstract class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static int nextID = 1001;
	
	private int id;
	private String firstName;
	private String surname;
	private String gender;
	private Date dateOfBirth;
		
	private String lineOne;
	private String lineTwo;
	private String town;
	private String postcode;
	
	private String telNo;
	private String mobNo;
	private String email;
	
	public Person(String fname, String sname, String gender, Date dob){
		id = assignID();
		firstName = fname;
		surname = sname;
		this.gender = gender; 
		this.dateOfBirth = dob;
	}
	
	public Person(){
		id = assignID();
	}
	
	public int assignID(){
		return nextID++;
	}

	/**
	 * @return the nextID
	 */
	public static int getNextID() {
		return nextID;
	}

	/**
	 * @param nextID the nextID to set
	 */
	public static void setNextID(int nextID) {
		Person.nextID = nextID;
	}

	/**
	 * @return the id
	 */
	public int getID() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the lineOne
	 */
	public String getLineOne() {
		return lineOne;
	}

	/**
	 * @param lineOne the lineOne to set
	 */
	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}

	/**
	 * @return the lineTwo
	 */
	public String getLineTwo() {
		return lineTwo;
	}

	/**
	 * @param lineTwo the lineTwo to set
	 */
	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}

	/**
	 * @return the town
	 */
	public String getTown() {
		return town;
	}

	/**
	 * @param town the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the telNo
	 */
	public String getTelNo() {
		return telNo;
	}

	/**
	 * @param telNo the telNo to set
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	/**
	 * @return the mobNo
	 */
	public String getMobNo() {
		return mobNo;
	}

	/**
	 * @param mobNo the mobNo to set
	 */
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
