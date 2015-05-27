package view;



import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import controller.*;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	private App app;
	
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JButton btnLogin;
	private JLabel lblError;

	/**
	 * Create the panel.
	 */
	public Login(App a) {
		this.app = a;
		
		setLayout(null);
		setVisible(true);
		
		JLabel label = new JLabel("Login to Simply Rugby");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		label.setBounds(6, 40, 588, 42);
		add(label);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		txtUsername.setColumns(10);
		txtUsername.setBounds(183, 109, 244, 29);
		add(txtUsername);
		
		JLabel label_1 = new JLabel("Username:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		label_1.setBounds(82, 115, 89, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("Password:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		label_2.setBounds(88, 144, 83, 16);
		add(label_2);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(pwdPassword.getPassword());
				app.getLoginCont().login(txtUsername.getText(), password);
			}
		});

		btnLogin.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnLogin.setBounds(183, 169, 244, 34);
		add(btnLogin);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(183, 138, 244, 28);
		add(pwdPassword);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.LEFT);
		lblError.setVerticalAlignment(SwingConstants.TOP);
		lblError.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));
		lblError.setBounds(183, 215, 346, 79);
		add(lblError);
		
	}
	
	public void setError(String s){
		lblError.setText(s);
	}
}
