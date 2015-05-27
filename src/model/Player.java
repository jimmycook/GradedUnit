package model;

import java.util.Date;

public class Player extends Member {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Doctor doctor = null;
	private String position;
	private String knownIssues;

	public Player(){
		super();
	}
	
	public Player(String fname, String sname, String gender, Date dob) {
		super(fname, sname, gender, dob);
	}

	/**
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the knownIssues
	 */
	public String getKnownIssues() {
		return knownIssues;
	}

	/**
	 * @param knownIssues the knownIssues to set
	 */
	public void setKnownIssues(String knownIssues) {
		this.knownIssues = knownIssues;
	}	

}
