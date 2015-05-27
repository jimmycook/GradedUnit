package tests;

import static org.junit.Assert.*;

import java.util.Date;

import model.Guardian;
import model.JuniorPlayer;
import model.Member;
import model.Person;

import org.junit.Test;

public class GuardianTest {
	/**
	 * Testing the remove person method
	 */
	@Test
	public void removePerson() {
		Guardian g = new Guardian("John", "Doe", "Male", new Date());
		Person p = new Member("Test", "Person", "Other", new Date());

		g.addPerson(p);
		assertEquals(true, g.removePerson(p));
	}
	
	/**
	 * Testing the add person method
	 */
	@Test
	public void addPerson() {
		Guardian g = new Guardian("John", "Doe", "Male", new Date());
		Person p = new Member("Test", "Person", "Other", new Date());
		g.addPerson(new Member());
		g.addPerson(new Member());
		g.addPerson(new Member());
		g.addPerson(new Member());
		
		g.addPerson(p);
		assertEquals(false, g.addPerson(p));
	}
	
	/**
	 * Testing the add player method
	 */
	@Test
	public void addPlayer() {
		Guardian g = new Guardian("John", "Doe", "Male", new Date());
		Guardian g2 = new Guardian("Jo", "Doe", "Female", new Date());
		JuniorPlayer p = new JuniorPlayer("Test", "Person", "Other", new Date());
		
		assertEquals(true, g.addPlayer(p));
		assertEquals(true, g2.addPlayer(p));
		assertEquals(false,g2.addPlayer(p));
		assertEquals(g, p.getGuardianOne());
		assertEquals(g2, p.getGuardianTwo());

	}
}
