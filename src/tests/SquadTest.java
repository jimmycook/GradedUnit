package tests;

import static org.junit.Assert.*;
import model.Player;
import model.Squad;

import org.junit.Test;

public class SquadTest {
	
	@Test
	public void removePlayer() {
		Squad s = new Squad();
		Player p = new Player("Test", "Test", "Male", new java.util.Date());
		try{
			s.addPlayer(p);
			
			s.removePlayer(p);			
		}
		catch(Exception e){
			fail();
		}
	}

}
