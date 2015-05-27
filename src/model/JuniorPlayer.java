package model;

import java.util.Date;

public class JuniorPlayer extends Player {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Guardian guardianOne = null;
	private Guardian guardianTwo = null;
	
	public JuniorPlayer(){
		super();
	}
	
	public JuniorPlayer(String fname, String sname, String gender, Date dob) {
		super(fname, sname, gender, dob);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the guardianOne
	 */
	public Guardian getGuardianOne() {
		return guardianOne;
	}

	/**
	 * @param guardianOne the guardianOne to set
	 */
	public void setGuardianOne(Guardian guardianOne) {
		this.guardianOne = guardianOne;
	}

	/**
	 * @return the guardianTwo
	 */
	public Guardian getGuardianTwo() {
		return guardianTwo;
	}

	/**
	 * @param guardianTwo the guardianTwo to set
	 */
	public void setGuardianTwo(Guardian guardianTwo) {
		this.guardianTwo = guardianTwo;
	}

	 
}
