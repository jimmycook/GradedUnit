package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Doctor extends Person {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Integer> doctorFor = new ArrayList<Integer>();
	
	public Doctor(String fname, String sname, String gender, Date dob) {
		super(fname, sname, gender, dob);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Adds a player using the add person method and creates a link between this object and 
	 * the player that has just been added
	 * @param Player p
	 * @return boolean
	 */
	public boolean addPlayer(Player p){
		if(p.getDoctor() == null){
			if(!addPerson(p)){
				return false;
			}
			p.setDoctor(this);
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
			doctorFor.add(person.getID());
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
			doctorFor.remove(index);
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
		Iterator<Integer> it = doctorFor.iterator();
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
	 * @return the doctorFor
	 */
	public ArrayList<Integer> getDoctorFor() {
		return doctorFor;
	}

	/**
	 * @param doctorFor the doctorFor to set
	 */
	public void setDoctorFor(ArrayList<Integer> doctorFor) {
		this.doctorFor = doctorFor;
	}

	

}
