package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

public class Guardian extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Integer> guardianOf = new ArrayList<Integer>();
	private String relation; 
	
	public Guardian(String fname, String sname, String gender, Date dob) {
		super(fname, sname, gender, dob);
		
	}
	
	public Guardian() {
		super();
	}

	/**
	 * Adds the id of the junior player passed in the collection of IDs, and sets the
	 * guardian relationship up in the junior player class
	 * @param JuniorPlayer p
	 * @return boolean
	 */
	public boolean addPlayer(JuniorPlayer p){
		if(p.getGuardianOne() == null || p.getGuardianTwo() == null){
			if(!addPerson(p)){
				return false;
			}
			if(p.getGuardianOne() == null){
				p.setGuardianOne(this);
			}
			else{
				p.setGuardianTwo(this);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Adds the ID of the person passed in into the doctor for collection
	 * If there is a duplicate the value false is returned
	 * @param person
	 * @return boolean 
	 */
	public boolean addPerson(Person person){
		int found = find(person.getID());
		if(found == -1){
			guardianOf.add(person.getID());
			return true;
		}
		return false;
	}
	
	/**
	 * Remove person a person from the doctor for collection 
	 * 
	 * @param person
	 * @return boolean status
	 */
	public boolean removePerson(Person p){
		Integer index = find(p.getID());
		if(index != -1){
			guardianOf.remove(index);
			return true;
		}
		return false;
	}
	
	/**
	 * Finds a person by their ID in the collection of people.
	 * @param int id
	 * @return Integer, index of the object if it's found, value -1 if not
	 */
	private Integer find(int id){
		Iterator<Integer> it = guardianOf.iterator();
		boolean found = false;
		int current = 0;
		while(it.hasNext() && !found){
			if(it.next().equals(id)){
				return current;
			}
			current++;
		}
		return -1;
	}

	/**
	 * @return the guardianOf
	 */
	public ArrayList<Integer> getGuardianOf() {
		return guardianOf;
	}

	public void setGuardianOf(ArrayList<Integer> guardianOf) {
		this.guardianOf = guardianOf;
	}

	/**
	 * @return the relation
	 */
	public String getRelation() {
		return relation;
	}

	/**
	 * @param relation the relation to set
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}



}
