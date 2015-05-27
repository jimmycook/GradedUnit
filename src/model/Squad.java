package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Squad {

	private String name;
	private ArrayList<Integer> playerIDs;
	private ArrayList<Integer> coachIDs;
	private ArrayList<TrainingSession> trainingSessions;
	private boolean isJunior;
	
	public Squad(){
		playerIDs = new ArrayList<Integer>();
		coachIDs = new ArrayList<Integer>();
		trainingSessions = new ArrayList<TrainingSession>();
		isJunior = false;
	}
	
	/**
	 * Adds a player to the squad
	 * @param p
	 */
	public void addPlayer(Player p){
		if(!hasPlayer(p)){
			playerIDs.add(p.getID());
		}
	}
	
	/**
	 * Adds a player to the squad
	 * @param m
	 */
	public void addCoach(Member c){
		if(!hasCoach(c)){
			coachIDs.add(c.getID());
		}
	}
	
	/**
	 * Adds a training session to the squad
	 * @param t
	 */
	public void addTrainingSession(TrainingSession t){
		trainingSessions.add(t);
	}
	
	/**
	 * Removes a coach from the squad
	 * @param m
	 */
	public void removePlayer(Player p){
		if(hasPlayer(p)){
			Integer i = p.getID();
			playerIDs.remove(i);
		}
	}
	
	/**
	 * Removes a coach from the squad
	 * @param m
	 */
	public void removeCoach(Member c){
		if(hasCoach(c)){
			Integer i = c.getID();
			coachIDs.remove(i);
		}
	}
	
	
	/**
	 * Checks to see if a player is on this squad
	 * @param p
	 * @return
	 */
	public boolean hasPlayer(Player p){
		Iterator<Integer> it = playerIDs.iterator();
		while(it.hasNext()){
			Integer cur = it.next();
			if(p.getID() == cur){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks to see if a member is a coach of this squad
	 * @param c
	 * @return
	 */
	public boolean hasCoach(Member c){
		Iterator<Integer> it = coachIDs.iterator();
		while(it.hasNext()){
			Integer cur = it.next();
			if(c.getID() == cur){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return the playerIDs
	 */
	public ArrayList<Integer> getPlayerIDs() {
		return playerIDs;
	}

	/**
	 * @param playerIDs the playerIDs to set
	 */
	public void setPlayerIDs(ArrayList<Integer> playerIDs) {
		this.playerIDs = playerIDs;
	}

	/**
	 * @return the coachIDs
	 */
	public ArrayList<Integer> getCoachIDs() {
		return coachIDs;
	}

	/**
	 * @param coachIDs the coachIDs to set
	 */
	public void setCoachIDs(ArrayList<Integer> coachIDs) {
		this.coachIDs = coachIDs;
	}

	/**
	 * @return the trainingSessions
	 */
	public ArrayList<TrainingSession> getTrainingSessions() {
		return trainingSessions;
	}

	/**
	 * @param trainingSessions the trainingSessions to set
	 */
	public void setTrainingSessions(ArrayList<TrainingSession> trainingSessions) {
		this.trainingSessions = trainingSessions;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isJunior
	 */
	public boolean isJunior() {
		return isJunior;
	}

	/**
	 * @param isJunior the isJunior to set
	 */
	public void setJunior(boolean isJunior) {
		this.isJunior = isJunior;
	}
}
