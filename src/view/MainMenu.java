package view;

import javax.swing.JPanel;

import controller.*;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class MainMenu extends JPanel {

	App app;
	
	/**
	 * Create the panel.
	 */
	public MainMenu(App a) {
		setLayout(null);
		
		app = a;
		this.setPreferredSize(new Dimension(600,300));
		
		JButton btnManagePlayers = new JButton("Manage Players");
		btnManagePlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.setContentPane(new ManagePlayers(app));
			}
		});
		btnManagePlayers.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnManagePlayers.setBounds(6, 31, 588, 40);
		add(btnManagePlayers);
		
		JButton btnManageTrainingSessions = new JButton("Manage Training Sessions");
		btnManageTrainingSessions.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnManageTrainingSessions.setBounds(6, 135, 588, 40);
		add(btnManageTrainingSessions);
		
		JLabel lblWelcome = new JLabel("Welcome to Simply Rugby");
		lblWelcome.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblWelcome.setBounds(6, 6, 170, 16);
		add(lblWelcome);
		
		JLabel lblDisclaimer = new JLabel("Disclaimer: Some features are not available in this prototype.");
		lblDisclaimer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisclaimer.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblDisclaimer.setBounds(6, 278, 588, 16);
		add(lblDisclaimer);
		
		JButton btnManageMembers = new JButton("Manage Members");
		btnManageMembers.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnManageMembers.setEnabled(false);
		btnManageMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageMembers.setBounds(6, 83, 588, 40);
		add(btnManageMembers);
		
		JButton btnManageGames = new JButton("Manage Games");
		btnManageGames.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnManageGames.setEnabled(false);
		btnManageGames.setBounds(6, 187, 588, 40);
		add(btnManageGames);
		
		JLabel lblLoggedInAs = new JLabel("Logged in as: ");
		lblLoggedInAs.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblLoggedInAs.setBounds(379, 6, 88, 16);
		add(lblLoggedInAs);
		
		JLabel lblUsername = new JLabel(app.getUser().getUsername());
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblUsername.setBounds(469, 6, 125, 16);
		add(lblUsername);
		
	    setOpaque(true);
	    
	    JButton btnNewButton = new JButton("Log out");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		app.getLoginCont().logout();
	    	}
	    });
	    btnNewButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
	    btnNewButton.setBounds(6, 236, 294, 40);
	    add(btnNewButton);
	    
	    JButton btnEditAccount = new JButton("Edit Account");
	    btnEditAccount.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
	    btnEditAccount.setBounds(300, 236, 294, 40);
	    add(btnEditAccount);

	}
}
