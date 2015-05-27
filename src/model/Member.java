package model;

import java.util.Date;

public class Member extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String scottishRugbyUnionID = "";
	public Member(String fname, String sname, String gender, Date dob) {
		super(fname, sname, gender, dob);
	}
	
	public Member(){
		super();
	}

	/**
	 * @return the scottishRugbyUnionID
	 */
	public String getScottishRugbyUnionID() {
		return scottishRugbyUnionID;
	}

	/**
	 * @param scottishRugbyUnionID the scottishRugbyUnionID to set
	 */
	public void setScottishRugbyUnionID(String scottishRugbyUnionID) {
		this.scottishRugbyUnionID = scottishRugbyUnionID;
	}

	
}
