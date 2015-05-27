package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JFrame;

import model.*;
import view.*;

public class PersonController {
	
	private App app; 
	private JFrame frame;
	private ArrayList<Person> people;
	
	/**
	 * Constructor 
	 * @param App application 
	 */
	public PersonController(App a){
		app = a;
		frame = app.getFrame();
		
		populatePeople();
		returnPlayers();
	}
	
	/**
	 * Populates the people collection
	 */
	public void populatePeople(){
		people = new ArrayList<Person>();
		
		JuniorPlayer test1 = new JuniorPlayer("John", "Doe", "Male", new Date());
		test1.setScottishRugbyUnionID("123456789");
		test1.setMobNo("07123456789");
		test1.setTelNo("01234567890");
		test1.setEmail("test@test.com");
		test1.setLineOne("1 Test Street");
		test1.setLineTwo("Fancy");
		test1.setTown("Town");
		test1.setPostcode("ABC DEF");
		test1.setDoctor(new Doctor("Frank", "Frank", "Female", new Date()));
		test1.getDoctor().setTelNo("01234567890");
		test1.getDoctor().setEmail("frankfrank@doctor.com");
		test1.getDoctor().setLineOne("Doctor 1");
		test1.getDoctor().setLineTwo("Test Street");
		test1.getDoctor().setTown("Naw");
		test1.getDoctor().setPostcode("ABC DEF");
		test1.setPosition("Player");
		test1.setGuardianOne(new Guardian("Test", "Test", "Male", new Date()));
		test1.getGuardianOne().setTelNo("01234567890");
		test1.getGuardianOne().setEmail("testtest@parent.com");
		test1.getGuardianOne().setLineOne("Parent 1");
		test1.getGuardianOne().setLineTwo("Test Street");
		test1.getGuardianOne().setTown("Naw");
		test1.getGuardianOne().setPostcode("ABC DEF");
		test1.getGuardianOne().setRelation("Father");
		test1.setGuardianTwo(new Guardian("Nah", "Nah", "Female", new Date()));
		test1.getGuardianTwo().setTelNo("01234567890");
		test1.getGuardianTwo().setEmail("testtest@parent.com");
		test1.getGuardianTwo().setLineOne("Parent 1");
		test1.getGuardianTwo().setLineTwo("Test Street");
		test1.getGuardianTwo().setTown("Naw");
		test1.getGuardianTwo().setPostcode("ABC DEF");
		test1.getGuardianTwo().setRelation("Mother");
		people.add(test1);
		app.getSquadCont().getSquads().get(1).addPlayer(test1);
	}
	
	/**
	 * Puts references to all the player objects in the system into a players collection
	 * @return ArrayList<Player>
	 */
	public ArrayList<Player> returnPlayers(){
		ArrayList<Player> players = new ArrayList<Player>();
		Iterator<Person> it = people.iterator();
		
		while(it.hasNext()){
			Person cur = it.next();
			if(cur instanceof Player){
				players.add((Player) cur);
			}
		}
		return players;
		
	}
	
	/**
	 * Adds a person object to the people collection
	 * @param p
	 */
	public void addPerson(Person p){
		people.add(p);
	}
	
	/**
	 * Removes a person object from the collection based on a Person object reference 
	 * @param Person p
	 */
	public void removePerson(Person p){
		Iterator<Person> it = people.iterator();
		while(it.hasNext()){
			Person cur = it.next();
			if(cur.equals(p)){
				it.remove();
			}
	
		}
	}
	
	/**
	 * Removes a person object from the collection based on ID
	 * 
	 * @param id
	 */
	public void removePerson(int id){
		Iterator<Person> it = people.iterator();
		
		while(it.hasNext()){
			Person cur = it.next();
			if(cur.getID() == id){
				it.remove();
			}
	
		}
	}
	
	/**
	 * Gets reference to a person object from the collection based on an ID (submitted as an integer)
	 * @param int id
	 * @return Person if found, null if not found in collection
	 */
	public Person getPersonByID(int id){
		Iterator<Person> it = people.iterator();
		
		while(it.hasNext()){
			Person cur = it.next();
			if(cur.getID() == id){
				return cur;
			}
		}
		return null;
	}
	
	public void managePeople() {
		app.getFrame().setContentPane(new ManagePlayers(app));
		app.getFrame().setVisible(true);
	}
	
	/** 
	 * Returns the collection of people
	 * @return ArrayList<Person> all people in the system
	 */
	public ArrayList<Person> getPeople(){
		return people;
	}
}
