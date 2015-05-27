package controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import model.*;
import view.*;

	
public class LoginController {
	ArrayList<User> users;
	App app;	
	
	/**
	 * Constructor 
	 * @param a application object
	 */
	LoginController(App a){
		app = a;
		importUsers();
	}
	
	/**
	 * Logs the user out
	 */
	public void logout(){
		app.setUser(null);
		app.getFrame().setContentPane(new Login(app));
		app.getFrame().setVisible(true);
	}
	
	/**
	 * Logs the user in
	 * @param u username
	 * @param p password
	 */
	public void login(String u, String p){
		System.out.println("Attempting login");
		Iterator<User> it = users.iterator();
		boolean found = false;
		while(it.hasNext() && !found){
			User cur = (User) it.next();
			
			if(cur.getUsername().equals(u)){
				found = true;
				
				if(cur.getPassword().equals(p)){
					app.setUser(cur);
					app.setContentPane(new MainMenu(app));					
				}
			}
		}
		if(app.getFrame().getContentPane() instanceof Login){
			Login l = (Login) app.getFrame().getContentPane();
			l.setError("Login failed, please change your details and try again.");
		}
	}
	
	/**
	 * Imports the system's userbase
	 */
	public void importUsers(){
		User u = new User();
		users = new ArrayList<User>();
		u.setUsername("test");
		u.setPassword("test");
		
		User r = new User();
		r.setUsername("Ruthie");
		r.setPassword("lilshit");
		users.add(u);
		users.add(r);
	}
}
