package view;

import javax.swing.JPanel;
import controller.*;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
public class AddPlayer extends JPanel {
	App app;
	private JTextField textField;
	private JTextField txtFirstName;
	private JTextField txtSurname;
	private JTextField txtLineone;
	private JTextField txtLineTwo;
	private JTextField txtTown;
	private JTextField txtPostcode;
	private JTextField txtEmail;
	private JTextField txtMob;
	private JTextField txtTel;
	private JTextField txtSRU;
	/**
	 * Create the panel.
	 */
	public AddPlayer(App a) {
		setLayout(null);
		
		JLabel lblName = new JLabel("Add a player");
		lblName.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblName.setBounds(6, 6, 162, 16);
		add(lblName);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblFirstName.setBounds(6, 34, 83, 16);
		add(lblFirstName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblSurname.setBounds(6, 62, 83, 16);
		add(lblSurname);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblAddress.setBounds(6, 90, 61, 16);
		add(lblAddress);
		
		JLabel lblLineOne = new JLabel("Line One");
		lblLineOne.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblLineOne.setBounds(6, 118, 61, 16);
		add(lblLineOne);
		
		JLabel lblLineTwo = new JLabel("Line Two");
		lblLineTwo.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblLineTwo.setBounds(6, 146, 61, 16);
		add(lblLineTwo);
		
		JLabel lblTown = new JLabel("Town");
		lblTown.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblTown.setBounds(6, 174, 61, 16);
		add(lblTown);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblPostcode.setBounds(6, 202, 61, 16);
		add(lblPostcode);
		
		JLabel lblEmail = new JLabel("Email Address");
		lblEmail.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblEmail.setBounds(281, 90, 101, 16);
		add(lblEmail);
		
		JLabel lblMobile = new JLabel("Mobile No.");
		lblMobile.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblMobile.setBounds(281, 34, 83, 16);
		add(lblMobile);
		
		JLabel lblTelephone = new JLabel("Telephone No.");
		lblTelephone.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblTelephone.setBounds(281, 62, 101, 16);
		add(lblTelephone);
		
		JLabel lblError = new JLabel("");
		lblError.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblError.setBounds(6, 278, 376, 16);
		add(lblError);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		txtFirstName.setEnabled(false);
		txtFirstName.setBounds(79, 28, 186, 28);
		add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		txtSurname.setBounds(79, 56, 186, 28);
		add(txtSurname);
		txtSurname.setColumns(10);
		
		txtLineone = new JTextField();
		txtLineone.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		txtLineone.setBounds(79, 112, 186, 28);
		add(txtLineone);
		txtLineone.setColumns(10);
		
		txtLineTwo = new JTextField();
		txtLineTwo.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		txtLineTwo.setBounds(79, 140, 186, 28);
		add(txtLineTwo);
		txtLineTwo.setColumns(10);
		
		txtTown = new JTextField();
		txtTown.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		txtTown.setBounds(79, 168, 186, 28);
		add(txtTown);
		txtTown.setColumns(10);
		
		txtPostcode = new JTextField();
		txtPostcode.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		txtPostcode.setBounds(79, 196, 186, 28);
		add(txtPostcode);
		txtPostcode.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		txtEmail.setBounds(376, 84, 186, 28);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		txtMob = new JTextField();
		txtMob.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		txtMob.setBounds(376, 28, 186, 28);
		add(txtMob);
		txtMob.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		txtTel.setBounds(376, 56, 186, 28);
		add(txtTel);
		txtTel.setColumns(10);
		
		JLabel lblSRU = new JLabel("SRU ID");
		lblSRU.setBounds(277, 196, 61, 16);
		lblSRU.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		add(lblSRU);
		
		txtSRU = new JTextField();
		txtSRU.setBounds(372, 190, 186, 28);
		txtSRU.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		add(txtSRU);
		txtSRU.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblGender.setBounds(281, 118, 61, 16);
		add(lblGender);
		
		JComboBox cmbGender = new JComboBox();
		cmbGender.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		cmbGender.setBounds(376, 114, 186, 27);
		cmbGender.addItem("Male");
		cmbGender.addItem("Female");
		cmbGender.addItem("Other");
		add(cmbGender);
		
		
		app = a;
		
		
	}
}
