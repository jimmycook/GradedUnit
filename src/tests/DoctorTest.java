package tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import model.*;

/**
 * Unit tests for the Doctor model class within the Simply Rugby system
 * @author jimmycook
 *
 */
public class DoctorTest {
	
	/**
	 * Testing the remove person method
	 */
	@Test
	public void removePerson() {
		Doctor d = new Doctor("John", "Doe", "Male", new Date());
		Person p = new Member("Test", "Person", "Other", new Date());

		d.addPerson(p);
		assertEquals(true, d.removePerson(p));
	}
	 
	/**
	 * Testing adding multiple people to one doctors collection
	 */
	@Test
	public void addMultiples(){
		Doctor d = new Doctor("John", "Doe", "Male", new Date());

		d.addPerson(new Member());
		d.addPerson(new Member());
		d.addPerson(new Member());
		d.addPerson(new Member());
	}
	
	/**
	 * Testing the add player method
	 */
	@Test
	public void addPlayer(){
		Doctor d = new Doctor("John", "Doe", "Male", new Date());
		Player p = new Player("Test", "Person", "Other", new Date());
		
		assertEquals(true, d.addPlayer(p));
		assertEquals(false, d.addPlayer(p));
		assertEquals(d, p.getDoctor());
	}
	
	/**
	 * Testing that trying to add duplicates with the addPerson 
	 * method results in them not being added
	 */
	@Test
	public void noDuplicates() {
		Doctor d = new Doctor("John", "Doe", "Male", new Date());
		Person p = new Member("Test", "Person", "Other", new Date());

		d.addPerson(p);
		assertEquals(false, d.addPerson(p));
	}

}
