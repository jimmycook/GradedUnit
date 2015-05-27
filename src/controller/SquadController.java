package controller;

import java.util.ArrayList;
import java.util.Iterator;

import model.*;

public class SquadController {
	
	private App app;
	private ArrayList<Squad> squads;  
	
	/**
	 * Constructor with app variable 
	 * @param app
	 */
	public SquadController(App app){
		this.app = app;		
		populateSquads();
	}
	
	/**
	 * Populates the squads collection
	 */
	public void populateSquads(){
		squads = new ArrayList<Squad>();	
		Squad s = new Squad();
		s.setName("Midi");
		squads.add(s);
		s = new Squad();
		s.setName("Mini");
		squads.add(s);
		
	}

	/**
	 * Returns the squad that the player belongs to
	 * @return
	 */
	public Squad getPlayerSquad(Player p){
		Iterator<Squad> it = squads.iterator();
		
		while(it.hasNext()){
			Squad cur = it.next();
			if(cur.hasPlayer(p)){
				return cur;
			}
		}
		return null;
	}

	/**
	 * @return the squads
	 */
	public ArrayList<Squad> getSquads() {
		return squads;
	}

	/**
	 * @param squads the squads to set
	 */
	public void setSquads(ArrayList<Squad> squads) {
		this.squads = squads;
	}
}
