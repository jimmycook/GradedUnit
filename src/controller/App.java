package controller;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.*;
import view.*;

public class App {
	
	private LoginController loginCont;
	private PersonController personCont;
	private SquadController squadCont;
	private User user;
	private JFrame frame;
	
	public App(){
		init();

	}
	
	public static void main(String[] args) {
		
		new App().start();
		
	}
	
	private void start(){
		System.out.println("Starting the application");
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 600, 322);
		frame.setTitle("Simply Rugby");
		setContentPane(new Login(this));

	}

	
	
	/**
	 * Sets up the controllers. 
	 */
	public void init(){
		loginCont = new LoginController(this);		
		squadCont = new SquadController(this);
		personCont = new PersonController(this);
	}
	
	/**
	 * Sets the content pane to the container c, sets the preferred size for the 
	 * frame if to that of the content pane if the content pane has a preferred size, packs 
	 * the frame and sets it to visible 
	 * 
	 * Note: this is destructive and will remove the current panel from the frame, without another reference to it that
	 * content pane will be lost.
	 * 
	 * @param c
	 */
	public void setContentPane(Container c){
		frame.remove(frame.getContentPane());
		
		frame.setContentPane(c);
		Dimension size = c.getPreferredSize();
		
		// Making sure the window doesn't get hidden
		if(size.getHeight() == 0 || size.getWidth() == 0){
			c.setPreferredSize(new Dimension(600, 300));
		}
		
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Exits the program
	 */
	public void exit(){
		frame.dispose();
	}
	
	/**
	 * @return the loginCont
	 */
	public LoginController getLoginCont() {
		return loginCont;
	}

	/**
	 * @param loginCont the loginCont to set
	 */
	public void setLoginCont(LoginController loginCont) {
		this.loginCont = loginCont;
	}

	/**
	 * @return the personCont
	 */
	public PersonController getPersonCont() {
		return personCont;
	}

	/**
	 * @param personCont the personCont to set
	 */
	public void setPersonCont(PersonController personCont) {
		this.personCont = personCont;
	}

	/**
	 * @return the squadCont
	 */
	public SquadController getSquadCont() {
		return squadCont;
	}

	/**
	 * @param squadCont the squadCont to set
	 */
	public void setSquadCont(SquadController squadCont) {
		this.squadCont = squadCont;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
}
