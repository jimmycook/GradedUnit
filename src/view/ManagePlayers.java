package view;

import javax.swing.*;

import model.Doctor;
import model.Guardian;
import model.JuniorPlayer;
import model.Player;
import model.Squad;
import controller.App;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManagePlayers extends JPanel {

	private App app;
	private ArrayList<Player> players;
	private Player selected;
	private JList listPlayers;
	private JTabbedPane tabbedPane;
	private JPanel details;
	private JTextField txtFirstName;
	private JTextField txtSurname;
	private JLabel lblFirstName;
	private Squad selectedS;
	private JLabel lblSurname;
	private JTextField txtTelNo;
	private JLabel lblPhone;
	private JLabel lblMobileNo;
	private JTextField txtMobNo;
	private JPanel viewDetails;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JLabel lblGender;
	private JComboBox<?> cmbGender;
	private JLabel lblDateOfBirth;
	private JTextField txtDateOfBirth;
	private JLabel lblAddress;
	private JLabel lblLineOne;
	private JTextField txtLineone;
	private JTextField txtLinetwo;
	private JLabel lblLineTwo;
	private JLabel lblPostcode;
	private JTextField txtPostcode;
	private JLabel lblTown;
	private JTextField txtTown;
	private JLabel lblSruId;
	private JTextField txtSruid;
	private JLabel lblAllFieldsRequired;
	private JPanel medical;
	private JLabel lblDoctor;
	private JLabel lblFirstName_1;
	private JTextField txtDFirstName;
	private JTextField txtDsurname;
	private JTextField txtDTelNo;
	private JTextField txtDEmail;
	private JTextField txtDLineOne;
	private JTextField txtDLineTwo;
	private JTextField txtDTown;
	private JTextField txtDPostcode;
	private JEditorPane editorIssues;
	private JPanel guardianOne;
	private JTextField txtG1FirstName;
	private JTextField txtG1surname;
	private JTextField txtG1TelNo;
	private JTextField txtG1Email;
	private JTextField txtG1LineOne;
	private JTextField txtG1LineTwo;
	private JTextField txtG1Town;
	private JTextField txtG1Postcode;
	private JComboBox<?> comboG1Relation;
	private JLabel lblFirstName_2;
	private JLabel lblSurname_2;
	private JLabel lblTelNo_2;
	private JLabel lblEmail_2;
	private JLabel lblAddress_2;
	private JLabel lblLineOne_2;
	private JLabel lblLineTwo_2;
	private JLabel lblTown_2;
	private JLabel lblPostcode_2;
	private JLabel lblRelation_1;
	private JComboBox comboG1Gender;	
	private JTextField txtG1DateOfBirth;
	private JLabel lblGender_1;
	private JLabel lblDateOfBirth_1;
	private JPanel guardianTwo;
	private JTextField txtG2FirstName;
	private JTextField txtG2surname;
	private JTextField txtG2TelNo;
	private JTextField txtG2Email;
	private JTextField txtG2LineOne;
	private JTextField txtG2LineTwo;
	private JTextField txtG2Town;
	private JTextField txtG2Postcode;
	private JComboBox comboG2Relation;
	private JLabel lblFirstName_3;
	private JLabel lblSurname_3;
	private JLabel lblTelNo_3;
	private JLabel lblEmail_3;
	private JLabel lblAddress_3;
	private JLabel lblLineOne_3;
	private JLabel lblLineTwo_3;
	private JLabel lblTown_3;
	private JLabel lblPostcode_3;
	private JLabel lblRelation_3;
	private JComboBox comboG2Gender;	
	private JTextField txtG2DateOfBirth;
	private JLabel lblGender_3;
	private JLabel lblGender_3_1;
	private JLabel lblDateOfBirth_3;
	private JLabel lblGuardian;
	private JLabel lblGuardian_1;
	private JLabel lblPosition;
	private JComboBox cmbPosition;
	private JButton btnRevertChanges;
	private JButton btnDelete;
	private JLabel lblExceptFrom;
	private JLabel lblKnownMedicalIssues;
	private JLabel lblAddressLineTwo;
	private JButton btnSave;
	private boolean creating;
	private JComboBox cmbSquad;
	private JLabel lblSquad;
	
	/**
	 * Create the panel.
	 */
	public ManagePlayers(App a) {
		this.setPreferredSize(new Dimension(630, 515));
		app = a;
		init();
		refresh();
	}
	
	
	/**
	 * Sets up the panel
	 */
	private void init(){
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		players = app.getPersonCont().returnPlayers();
		Iterator<Player> it = players.iterator();
		DefaultListModel listModel = new DefaultListModel();

		while(it.hasNext()){
			Player cur = it.next();
			listModel.addElement(cur.getFirstName() + " " + cur.getSurname());
		}
		
		

		JButton btnMainMenu = new JButton("Main Menu");
		springLayout.putConstraint(SpringLayout.EAST, btnMainMenu, -22, SpringLayout.EAST, this);
		btnMainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				app.setContentPane(new MainMenu(app));
			}
		});
		add(btnMainMenu);
		SpringLayout sl_viewPlayer = new SpringLayout();

		JLabel lblManagePlayers = new JLabel("Manage Players");
		springLayout.putConstraint(SpringLayout.WEST, lblManagePlayers, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblManagePlayers, -496, SpringLayout.SOUTH, this);
		add(lblManagePlayers);
		
		viewDetails = new JPanel();
		SpringLayout sl_viewDetails = new SpringLayout();
		viewDetails.setLayout(sl_viewDetails);
		
		JLabel lblName = new JLabel("Name");
		sl_viewDetails.putConstraint(SpringLayout.NORTH, lblName, 10, SpringLayout.NORTH, viewDetails);
		sl_viewDetails.putConstraint(SpringLayout.WEST, lblName, 10, SpringLayout.WEST, viewDetails);
		viewDetails.add(lblName);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.WEST, btnMainMenu, 314, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 486, SpringLayout.SOUTH, lblManagePlayers);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -477, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblManagePlayers);
		add(scrollPane);
		
		listPlayers = new JList(listModel);
		listPlayers.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				selected = getSelectedPlayer(listPlayers);
				selectedS = app.getSquadCont().getPlayerSquad(selected);
				creating = false;
				update();
			}
		});
		scrollPane.setViewportView(listPlayers);
		springLayout.putConstraint(SpringLayout.WEST, listPlayers, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, listPlayers, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, listPlayers, 145, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, listPlayers, 241, SpringLayout.SOUTH, lblManagePlayers);
		
		tabbedPane = new JTabbedPane(SwingConstants.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 3, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 6, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, -10, SpringLayout.EAST, this);
		add(tabbedPane);
		
		details = new JPanel();
		tabbedPane.addTab("Details", null, details, null);
		tabbedPane.setEnabledAt(0, true);
		SpringLayout sl_details = new SpringLayout();
		details.setLayout(sl_details);
		
		txtFirstName = new JTextField();
		details.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtSurname = new JTextField();
		sl_details.putConstraint(SpringLayout.EAST, txtFirstName, 0, SpringLayout.EAST, txtSurname);
		sl_details.putConstraint(SpringLayout.NORTH, txtSurname, 44, SpringLayout.NORTH, details);
		sl_details.putConstraint(SpringLayout.WEST, txtSurname, 82, SpringLayout.WEST, details);
		details.add(txtSurname);
		txtSurname.setColumns(10);
		
		lblFirstName = new JLabel("First Name");
		sl_details.putConstraint(SpringLayout.NORTH, lblFirstName, 16, SpringLayout.NORTH, details);
		sl_details.putConstraint(SpringLayout.EAST, lblFirstName, -4, SpringLayout.WEST, txtFirstName);
		sl_details.putConstraint(SpringLayout.NORTH, txtFirstName, -6, SpringLayout.NORTH, lblFirstName);
		details.add(lblFirstName);
		
		lblSurname = new JLabel("Surname");
		sl_details.putConstraint(SpringLayout.NORTH, lblSurname, 6, SpringLayout.NORTH, txtSurname);
		sl_details.putConstraint(SpringLayout.WEST, lblSurname, 0, SpringLayout.WEST, lblFirstName);
		details.add(lblSurname);
		
		txtTelNo = new JTextField();
		sl_details.putConstraint(SpringLayout.EAST, txtTelNo, -10, SpringLayout.EAST, details);
		details.add(txtTelNo);
		txtTelNo.setColumns(10);
		
		lblPhone = new JLabel("Phone No.");
		sl_details.putConstraint(SpringLayout.NORTH, lblPhone, 0, SpringLayout.NORTH, lblFirstName);
		sl_details.putConstraint(SpringLayout.WEST, lblPhone, 6, SpringLayout.EAST, txtFirstName);
		details.add(lblPhone);
		
		lblMobileNo = new JLabel("Mobile No.");
		sl_details.putConstraint(SpringLayout.WEST, lblMobileNo, 6, SpringLayout.EAST, txtSurname);
		sl_details.putConstraint(SpringLayout.SOUTH, lblMobileNo, 0, SpringLayout.SOUTH, lblSurname);
		details.add(lblMobileNo);
		
		txtMobNo = new JTextField();
		sl_details.putConstraint(SpringLayout.SOUTH, txtTelNo, -6, SpringLayout.NORTH, txtMobNo);
		sl_details.putConstraint(SpringLayout.NORTH, txtMobNo, 0, SpringLayout.NORTH, txtSurname);
		sl_details.putConstraint(SpringLayout.WEST, txtMobNo, 0, SpringLayout.WEST, txtTelNo);
		details.add(txtMobNo);
		txtMobNo.setColumns(10);
		
		txtEmail = new JTextField();
		sl_details.putConstraint(SpringLayout.NORTH, txtEmail, 6, SpringLayout.SOUTH, txtMobNo);
		sl_details.putConstraint(SpringLayout.EAST, txtEmail, 0, SpringLayout.EAST, txtTelNo);
		details.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblEmail = new JLabel("Email");
		sl_details.putConstraint(SpringLayout.NORTH, lblEmail, 18, SpringLayout.SOUTH, lblMobileNo);
		details.add(lblEmail);
		
		lblGender = new JLabel("Gender");
		sl_details.putConstraint(SpringLayout.NORTH, lblGender, 18, SpringLayout.SOUTH, lblSurname);
		sl_details.putConstraint(SpringLayout.WEST, lblEmail, 168, SpringLayout.EAST, lblGender);
		sl_details.putConstraint(SpringLayout.WEST, lblGender, 0, SpringLayout.WEST, lblFirstName);
		details.add(lblGender);
		
		lblDateOfBirth = new JLabel("Date Of Birth - in format DD/MM/YYYY");
		sl_details.putConstraint(SpringLayout.WEST, lblDateOfBirth, 0, SpringLayout.WEST, lblFirstName);
		sl_details.putConstraint(SpringLayout.EAST, lblDateOfBirth, 0, SpringLayout.EAST, lblPhone);
		details.add(lblDateOfBirth);
		
		txtDateOfBirth = new JTextField();
		sl_details.putConstraint(SpringLayout.NORTH, txtDateOfBirth, -6, SpringLayout.NORTH, lblDateOfBirth);
		sl_details.putConstraint(SpringLayout.WEST, txtDateOfBirth, 0, SpringLayout.WEST, txtTelNo);
		details.add(txtDateOfBirth);
		txtDateOfBirth.setColumns(10);
		
		lblAddress = new JLabel("Address");
		sl_details.putConstraint(SpringLayout.SOUTH, lblDateOfBirth, -6, SpringLayout.NORTH, lblAddress);
		sl_details.putConstraint(SpringLayout.WEST, lblAddress, 0, SpringLayout.WEST, lblFirstName);
		details.add(lblAddress);
		
		lblLineOne = new JLabel("Line One");
		sl_details.putConstraint(SpringLayout.NORTH, lblLineOne, 187, SpringLayout.NORTH, details);
		sl_details.putConstraint(SpringLayout.SOUTH, lblAddress, -6, SpringLayout.NORTH, lblLineOne);
		sl_details.putConstraint(SpringLayout.WEST, lblLineOne, 0, SpringLayout.WEST, lblFirstName);
		details.add(lblLineOne);
		
		txtLineone = new JTextField();
		sl_details.putConstraint(SpringLayout.NORTH, txtLineone, -6, SpringLayout.NORTH, lblLineOne);
		sl_details.putConstraint(SpringLayout.WEST, txtLineone, 17, SpringLayout.EAST, lblLineOne);
		details.add(txtLineone);
		txtLineone.setColumns(10);
		
		txtLinetwo = new JTextField();
		sl_details.putConstraint(SpringLayout.NORTH, txtLinetwo, 6, SpringLayout.SOUTH, txtLineone);
		details.add(txtLinetwo);
		txtLinetwo.setColumns(10);
		
		lblLineTwo = new JLabel("Line Two");
		sl_details.putConstraint(SpringLayout.NORTH, lblLineTwo, 6, SpringLayout.NORTH, txtLinetwo);
		sl_details.putConstraint(SpringLayout.WEST, lblLineTwo, 0, SpringLayout.WEST, lblFirstName);
		details.add(lblLineTwo);
		
		lblPostcode = new JLabel("Postcode");
		sl_details.putConstraint(SpringLayout.EAST, txtLinetwo, -6, SpringLayout.WEST, lblPostcode);
		sl_details.putConstraint(SpringLayout.NORTH, lblPostcode, 6, SpringLayout.NORTH, txtLinetwo);
		sl_details.putConstraint(SpringLayout.WEST, lblPostcode, 0, SpringLayout.WEST, lblPhone);
		details.add(lblPostcode);
		
		txtPostcode = new JTextField();
		sl_details.putConstraint(SpringLayout.NORTH, txtPostcode, 0, SpringLayout.NORTH, txtLinetwo);
		sl_details.putConstraint(SpringLayout.EAST, txtPostcode, 0, SpringLayout.EAST, txtTelNo);
		details.add(txtPostcode);
		txtPostcode.setColumns(10);
		
		lblTown = new JLabel("Town");
		sl_details.putConstraint(SpringLayout.NORTH, lblTown, 0, SpringLayout.NORTH, lblLineOne);
		sl_details.putConstraint(SpringLayout.WEST, lblTown, 0, SpringLayout.WEST, lblPhone);
		details.add(lblTown);
		
		txtTown = new JTextField();
		sl_details.putConstraint(SpringLayout.NORTH, txtTown, -6, SpringLayout.NORTH, lblLineOne);
		sl_details.putConstraint(SpringLayout.WEST, txtTown, 0, SpringLayout.WEST, txtTelNo);
		details.add(txtTown);
		txtTown.setColumns(10);
		
		lblSruId = new JLabel("SRU ID");
		sl_details.putConstraint(SpringLayout.WEST, lblSruId, 0, SpringLayout.WEST, lblFirstName);
		sl_details.putConstraint(SpringLayout.SOUTH, lblSruId, -9, SpringLayout.NORTH, lblDateOfBirth);
		details.add(lblSruId);
		
		txtSruid = new JTextField();
		sl_details.putConstraint(SpringLayout.WEST, txtSruid, 30, SpringLayout.EAST, lblSruId);
		sl_details.putConstraint(SpringLayout.SOUTH, txtSruid, -6, SpringLayout.NORTH, lblDateOfBirth);
		details.add(txtSruid);
		txtSruid.setColumns(10);
		
		cmbGender = new JComboBox();
		sl_details.putConstraint(SpringLayout.NORTH, cmbGender, 2, SpringLayout.NORTH, txtEmail);
		sl_details.putConstraint(SpringLayout.WEST, cmbGender, 27, SpringLayout.EAST, lblGender);
		sl_details.putConstraint(SpringLayout.EAST, cmbGender, -6, SpringLayout.WEST, lblEmail);
		details.add(cmbGender);
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		
		lblPosition = new JLabel("Position");
		sl_details.putConstraint(SpringLayout.NORTH, lblPosition, 0, SpringLayout.NORTH, lblSruId);
		sl_details.putConstraint(SpringLayout.WEST, lblPosition, 0, SpringLayout.WEST, lblPhone);
		details.add(lblPosition);
		
		cmbPosition = new JComboBox();
		cmbPosition.setModel(new DefaultComboBoxModel(new String[] {"Player"}));
		sl_details.putConstraint(SpringLayout.WEST, cmbPosition, 0, SpringLayout.WEST, txtTelNo);
		sl_details.putConstraint(SpringLayout.SOUTH, cmbPosition, 0, SpringLayout.NORTH, txtDateOfBirth);
		sl_details.putConstraint(SpringLayout.EAST, cmbPosition, 0, SpringLayout.EAST, txtTelNo);
		details.add(cmbPosition);
		
		ArrayList<Squad> squads = app.getSquadCont().getSquads();
		
		DefaultComboBoxModel l = new DefaultComboBoxModel();
		if(squads != null){
			Iterator<Squad> i = squads.iterator();

			while(i.hasNext()){
				Squad squad = i.next();
				l.addElement(squad.getName());
			}
		}
		cmbSquad = new JComboBox(l);
		
		sl_details.putConstraint(SpringLayout.NORTH, cmbSquad, 3, SpringLayout.SOUTH, txtLinetwo);
		sl_details.putConstraint(SpringLayout.WEST, cmbSquad, 0, SpringLayout.WEST, txtFirstName);
		sl_details.putConstraint(SpringLayout.EAST, cmbSquad, 0, SpringLayout.EAST, txtFirstName);
		details.add(cmbSquad);
		
		lblSquad = new JLabel("Squad");
		sl_details.putConstraint(SpringLayout.NORTH, lblSquad, 4, SpringLayout.NORTH, cmbSquad);
		sl_details.putConstraint(SpringLayout.WEST, lblSquad, 0, SpringLayout.WEST, lblFirstName);
		details.add(lblSquad);
		
		medical = new JPanel();
		tabbedPane.addTab("Medical", null, medical, null);
		tabbedPane.setEnabledAt(1, true);
		SpringLayout sl_medical = new SpringLayout();
		medical.setLayout(sl_medical);
		
		lblDoctor = new JLabel("Doctor");
		sl_medical.putConstraint(SpringLayout.NORTH, lblDoctor, 10, SpringLayout.NORTH, medical);
		sl_medical.putConstraint(SpringLayout.WEST, lblDoctor, 10, SpringLayout.WEST, medical);
		medical.add(lblDoctor);
		
		lblFirstName_1 = new JLabel("First Name");
		sl_medical.putConstraint(SpringLayout.NORTH, lblFirstName_1, 6, SpringLayout.SOUTH, lblDoctor);
		sl_medical.putConstraint(SpringLayout.WEST, lblFirstName_1, 0, SpringLayout.WEST, lblDoctor);
		medical.add(lblFirstName_1);
		
		txtDFirstName = new JTextField();
		sl_medical.putConstraint(SpringLayout.NORTH, txtDFirstName, -6, SpringLayout.NORTH, lblFirstName_1);
		medical.add(txtDFirstName);
		txtDFirstName.setColumns(10);
		
		txtDsurname = new JTextField();
		sl_medical.putConstraint(SpringLayout.NORTH, txtDsurname, 6, SpringLayout.SOUTH, txtDFirstName);
		sl_medical.putConstraint(SpringLayout.EAST, txtDFirstName, 0, SpringLayout.EAST, txtDsurname);
		medical.add(txtDsurname);
		
		JLabel lblSurname_1 = new JLabel("Surname");
		sl_medical.putConstraint(SpringLayout.WEST, txtDsurname, 18, SpringLayout.EAST, lblSurname_1);
		sl_medical.putConstraint(SpringLayout.NORTH, lblSurname_1, 6, SpringLayout.NORTH, txtDsurname);
		sl_medical.putConstraint(SpringLayout.WEST, lblSurname_1, 0, SpringLayout.WEST, lblDoctor);
		medical.add(lblSurname_1);
		
		txtDTelNo = new JTextField();
		sl_medical.putConstraint(SpringLayout.NORTH, txtDTelNo, -6, SpringLayout.NORTH, lblFirstName_1);
		sl_medical.putConstraint(SpringLayout.EAST, txtDTelNo, -10, SpringLayout.EAST, medical);
		medical.add(txtDTelNo);
		txtDTelNo.setColumns(10);
		
		txtDEmail = new JTextField();
		sl_medical.putConstraint(SpringLayout.EAST, txtDsurname, -80, SpringLayout.WEST, txtDEmail);
		sl_medical.putConstraint(SpringLayout.NORTH, txtDEmail, 0, SpringLayout.NORTH, txtDsurname);
		sl_medical.putConstraint(SpringLayout.WEST, txtDEmail, 0, SpringLayout.WEST, txtDTelNo);
		medical.add(txtDEmail);
		txtDEmail.setColumns(10);
		
		txtDLineOne = new JTextField();
		sl_medical.putConstraint(SpringLayout.WEST, txtDLineOne, 0, SpringLayout.WEST, txtDFirstName);
		medical.add(txtDLineOne);
		txtDLineOne.setColumns(10);
		
		txtDLineTwo = new JTextField();
		sl_medical.putConstraint(SpringLayout.SOUTH, txtDLineOne, -6, SpringLayout.NORTH, txtDLineTwo);
		sl_medical.putConstraint(SpringLayout.NORTH, txtDLineTwo, 142, SpringLayout.NORTH, medical);
		medical.add(txtDLineTwo);
		txtDLineTwo.setColumns(10);
		
		JLabel lblAddress_1 = new JLabel("Address");
		sl_medical.putConstraint(SpringLayout.NORTH, lblAddress_1, 6, SpringLayout.SOUTH, lblSurname_1);
		sl_medical.putConstraint(SpringLayout.WEST, lblAddress_1, 0, SpringLayout.WEST, lblDoctor);
		medical.add(lblAddress_1);
		
		JLabel lblLineOne_1 = new JLabel("Line One");
		sl_medical.putConstraint(SpringLayout.NORTH, lblLineOne_1, 10, SpringLayout.SOUTH, lblAddress_1);
		sl_medical.putConstraint(SpringLayout.WEST, lblLineOne_1, 0, SpringLayout.WEST, lblDoctor);
		medical.add(lblLineOne_1);
		
		JLabel lblLinetwo = new JLabel("LineTwo");
		sl_medical.putConstraint(SpringLayout.WEST, txtDLineTwo, 20, SpringLayout.EAST, lblLinetwo);
		sl_medical.putConstraint(SpringLayout.NORTH, lblLinetwo, 6, SpringLayout.NORTH, txtDLineTwo);
		sl_medical.putConstraint(SpringLayout.WEST, lblLinetwo, 0, SpringLayout.WEST, lblDoctor);
		medical.add(lblLinetwo);
		
		txtDTown = new JTextField();
		sl_medical.putConstraint(SpringLayout.WEST, txtDTown, 0, SpringLayout.WEST, txtDTelNo);
		medical.add(txtDTown);
		txtDTown.setColumns(10);
		
		txtDPostcode = new JTextField();
		sl_medical.putConstraint(SpringLayout.SOUTH, txtDTown, -6, SpringLayout.NORTH, txtDPostcode);
		sl_medical.putConstraint(SpringLayout.NORTH, txtDPostcode, 0, SpringLayout.NORTH, txtDLineTwo);
		sl_medical.putConstraint(SpringLayout.WEST, txtDPostcode, 0, SpringLayout.WEST, txtDTelNo);
		medical.add(txtDPostcode);
		txtDPostcode.setColumns(10);
		
		editorIssues = new JEditorPane();
		sl_medical.putConstraint(SpringLayout.NORTH, editorIssues, 33, SpringLayout.SOUTH, txtDLineTwo);
		sl_medical.putConstraint(SpringLayout.WEST, editorIssues, 10, SpringLayout.WEST, medical);
		sl_medical.putConstraint(SpringLayout.SOUTH, editorIssues, -10, SpringLayout.SOUTH, medical);
		sl_medical.putConstraint(SpringLayout.EAST, editorIssues, 430, SpringLayout.WEST, medical);
		medical.add(editorIssues);
		
		JLabel lblIssues = new JLabel("Known Medical Issues");
		sl_medical.putConstraint(SpringLayout.WEST, lblIssues, 0, SpringLayout.WEST, lblDoctor);
		sl_medical.putConstraint(SpringLayout.SOUTH, lblIssues, -6, SpringLayout.NORTH, editorIssues);
		medical.add(lblIssues);
		
		lblAllFieldsRequired = new JLabel("All Fields Required");
		springLayout.putConstraint(SpringLayout.NORTH, lblAllFieldsRequired, 6, SpringLayout.SOUTH, tabbedPane);
		springLayout.putConstraint(SpringLayout.WEST, lblAllFieldsRequired, 6, SpringLayout.EAST, scrollPane);
		add(lblAllFieldsRequired);
		
		guardianOne = new JPanel();
		tabbedPane.addTab("Guardian One", null, guardianOne, null);
		tabbedPane.setEnabledAt(2, true);
		tabbedPane.setDisabledIconAt(2, null);
		SpringLayout sl_guardianOne = new SpringLayout();
		guardianOne.setLayout(sl_guardianOne);
		
		txtG1FirstName = new JTextField();
		guardianOne.add(txtG1FirstName);
		txtG1FirstName.setColumns(10);
		
		txtG1surname = new JTextField();
		sl_guardianOne.putConstraint(SpringLayout.WEST, txtG1surname, 0, SpringLayout.WEST, txtG1FirstName);
		sl_guardianOne.putConstraint(SpringLayout.EAST, txtG1surname, -221, SpringLayout.EAST, guardianOne);
		guardianOne.add(txtG1surname);
		
		txtG1TelNo = new JTextField();
		sl_guardianOne.putConstraint(SpringLayout.NORTH, txtG1TelNo, 0, SpringLayout.NORTH, txtG1FirstName);
		sl_guardianOne.putConstraint(SpringLayout.EAST, txtG1TelNo, -10, SpringLayout.EAST, guardianOne);
		guardianOne.add(txtG1TelNo);
		txtG1TelNo.setColumns(10);
		
		txtG1Email = new JTextField();
		sl_guardianOne.putConstraint(SpringLayout.NORTH, txtG1surname, 0, SpringLayout.NORTH, txtG1Email);
		sl_guardianOne.putConstraint(SpringLayout.NORTH, txtG1Email, 6, SpringLayout.SOUTH, txtG1TelNo);
		sl_guardianOne.putConstraint(SpringLayout.WEST, txtG1Email, 0, SpringLayout.WEST, txtG1TelNo);
		guardianOne.add(txtG1Email);
		txtG1Email.setColumns(10);
		
		txtG1LineOne = new JTextField();
		sl_guardianOne.putConstraint(SpringLayout.WEST, txtG1LineOne, 0, SpringLayout.WEST, txtG1FirstName);
		guardianOne.add(txtG1LineOne);
		txtG1LineOne.setColumns(10);
		
		txtG1LineTwo = new JTextField();
		sl_guardianOne.putConstraint(SpringLayout.EAST, txtG1LineTwo, 0, SpringLayout.EAST, txtG1TelNo);
		guardianOne.add(txtG1LineTwo);
		txtG1LineTwo.setColumns(10);
		sl_guardianOne.putConstraint(SpringLayout.NORTH, lblLinetwo, 6, SpringLayout.NORTH, txtG1LineTwo);
		sl_guardianOne.putConstraint(SpringLayout.WEST, lblLinetwo, 0, SpringLayout.WEST, lblDoctor);
		
		txtG1Town = new JTextField();
		sl_guardianOne.putConstraint(SpringLayout.NORTH, txtG1LineOne, 0, SpringLayout.NORTH, txtG1Town);
		sl_guardianOne.putConstraint(SpringLayout.NORTH, txtG1LineTwo, 6, SpringLayout.SOUTH, txtG1Town);
		sl_guardianOne.putConstraint(SpringLayout.WEST, txtG1Town, 0, SpringLayout.WEST, txtG1TelNo);
		guardianOne.add(txtG1Town);
		txtG1Town.setColumns(10);
		
		txtG1Postcode = new JTextField();
		sl_guardianOne.putConstraint(SpringLayout.NORTH, txtG1Postcode, 0, SpringLayout.NORTH, txtG1LineTwo);
		sl_guardianOne.putConstraint(SpringLayout.EAST, txtG1Postcode, 0, SpringLayout.EAST, txtG1FirstName);
		guardianOne.add(txtG1Postcode);
		txtG1Postcode.setColumns(10);
		
		lblFirstName_2 = new JLabel("First Name");
		sl_guardianOne.putConstraint(SpringLayout.WEST, lblFirstName_2, 10, SpringLayout.WEST, guardianOne);
		sl_guardianOne.putConstraint(SpringLayout.NORTH, txtG1FirstName, -6, SpringLayout.NORTH, lblFirstName_2);
		guardianOne.add(lblFirstName_2);
		
		lblSurname_2 = new JLabel("Surname");
		sl_guardianOne.putConstraint(SpringLayout.NORTH, lblSurname_2, 6, SpringLayout.NORTH, txtG1surname);
		sl_guardianOne.putConstraint(SpringLayout.WEST, lblSurname_2, 0, SpringLayout.WEST, lblFirstName_2);
		guardianOne.add(lblSurname_2);
		
		lblTelNo_2 = new JLabel("Tel No.");
		sl_guardianOne.putConstraint(SpringLayout.WEST, lblTelNo_2, 225, SpringLayout.WEST, guardianOne);
		sl_guardianOne.putConstraint(SpringLayout.EAST, txtG1FirstName, -6, SpringLayout.WEST, lblTelNo_2);
		sl_guardianOne.putConstraint(SpringLayout.NORTH, lblTelNo_2, 6, SpringLayout.NORTH, txtG1FirstName);
		guardianOne.add(lblTelNo_2);
		
		lblEmail_2 = new JLabel("Email");
		sl_guardianOne.putConstraint(SpringLayout.NORTH, lblEmail_2, 6, SpringLayout.NORTH, txtG1Email);
		sl_guardianOne.putConstraint(SpringLayout.WEST, lblEmail_2, 0, SpringLayout.WEST, lblTelNo_2);
		guardianOne.add(lblEmail_2);
		
		lblAddress_2 = new JLabel("Address");
		sl_guardianOne.putConstraint(SpringLayout.WEST, lblAddress_2, 0, SpringLayout.WEST, lblFirstName_2);
		guardianOne.add(lblAddress_2);
		
		lblLineOne_2 = new JLabel("Line One");
		sl_guardianOne.putConstraint(SpringLayout.SOUTH, lblAddress_2, -6, SpringLayout.NORTH, lblLineOne_2);
		sl_guardianOne.putConstraint(SpringLayout.NORTH, lblLineOne_2, 6, SpringLayout.NORTH, txtG1Town);
		sl_guardianOne.putConstraint(SpringLayout.EAST, lblLineOne_2, 0, SpringLayout.EAST, lblSurname_2);
		guardianOne.add(lblLineOne_2);
		
		lblLineTwo_2 = new JLabel("Line Two");
		sl_guardianOne.putConstraint(SpringLayout.NORTH, lblLineTwo_2, 6, SpringLayout.NORTH, txtG1LineTwo);
		sl_guardianOne.putConstraint(SpringLayout.WEST, lblLineTwo_2, 0, SpringLayout.WEST, lblFirstName_2);
		guardianOne.add(lblLineTwo_2);
		
		lblTown_2 = new JLabel("Town");
		sl_guardianOne.putConstraint(SpringLayout.NORTH, lblTown_2, 6, SpringLayout.NORTH, txtG1Town);
		sl_guardianOne.putConstraint(SpringLayout.WEST, lblTown_2, 0, SpringLayout.WEST, lblTelNo_2);
		guardianOne.add(lblTown_2);
		
		lblPostcode_2 = new JLabel("Postcode");
		sl_guardianOne.putConstraint(SpringLayout.NORTH, lblPostcode_2, 6, SpringLayout.NORTH, txtG1LineTwo);
		sl_guardianOne.putConstraint(SpringLayout.WEST, lblPostcode_2, 6, SpringLayout.EAST, txtG1Postcode);
		guardianOne.add(lblPostcode_2);
		
		comboG1Relation = new JComboBox();
		sl_guardianOne.putConstraint(SpringLayout.NORTH, comboG1Relation, 6, SpringLayout.SOUTH, txtG1Email);
		sl_guardianOne.putConstraint(SpringLayout.WEST, comboG1Relation, 0, SpringLayout.WEST, txtG1TelNo);
		sl_guardianOne.putConstraint(SpringLayout.EAST, comboG1Relation, -10, SpringLayout.EAST, guardianOne);
		comboG1Relation.setModel(new DefaultComboBoxModel(new String[] {"Mother", "Father", "Carer", "Other"}));
		guardianOne.add(comboG1Relation);
		
		lblRelation_1 = new JLabel("Relation");
		sl_guardianOne.putConstraint(SpringLayout.NORTH, lblRelation_1, 4, SpringLayout.NORTH, comboG1Relation);
		sl_guardianOne.putConstraint(SpringLayout.WEST, lblRelation_1, 0, SpringLayout.WEST, lblTelNo_2);
		guardianOne.add(lblRelation_1);
		
		comboG1Gender = new JComboBox();
		sl_guardianOne.putConstraint(SpringLayout.NORTH, comboG1Gender, 0, SpringLayout.NORTH, comboG1Relation);
		sl_guardianOne.putConstraint(SpringLayout.EAST, comboG1Gender, -77, SpringLayout.WEST, comboG1Relation);
		comboG1Gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		guardianOne.add(comboG1Gender);
		
		lblGender_3 = new JLabel("Gender");
		sl_guardianOne.putConstraint(SpringLayout.WEST, comboG1Gender, 31, SpringLayout.EAST, lblGender_3);
		sl_guardianOne.putConstraint(SpringLayout.NORTH, lblGender_3, 4, SpringLayout.NORTH, comboG1Relation);
		sl_guardianOne.putConstraint(SpringLayout.WEST, lblGender_3, 10, SpringLayout.WEST, guardianOne);
		guardianOne.add(lblGender_3);
		
		txtG1DateOfBirth = new JTextField();
		sl_guardianOne.putConstraint(SpringLayout.NORTH, txtG1Town, 40, SpringLayout.SOUTH, txtG1DateOfBirth);
		sl_guardianOne.putConstraint(SpringLayout.NORTH, txtG1DateOfBirth, 6, SpringLayout.SOUTH, comboG1Relation);
		sl_guardianOne.putConstraint(SpringLayout.EAST, txtG1DateOfBirth, 0, SpringLayout.EAST, txtG1TelNo);
		guardianOne.add(txtG1DateOfBirth);
		txtG1DateOfBirth.setColumns(10);
		
		lblDateOfBirth_1 = new JLabel("Date Of Birth - in format DD/MM/YYYY");
		sl_guardianOne.putConstraint(SpringLayout.NORTH, lblDateOfBirth_1, 6, SpringLayout.NORTH, txtG1DateOfBirth);
		sl_guardianOne.putConstraint(SpringLayout.WEST, lblDateOfBirth_1, 0, SpringLayout.WEST, lblFirstName_2);
		guardianOne.add(lblDateOfBirth_1);
		
		lblGuardian = new JLabel("Guardian");
		sl_guardianOne.putConstraint(SpringLayout.NORTH, lblFirstName_2, 6, SpringLayout.SOUTH, lblGuardian);
		sl_guardianOne.putConstraint(SpringLayout.NORTH, lblGuardian, 10, SpringLayout.NORTH, guardianOne);
		sl_guardianOne.putConstraint(SpringLayout.WEST, lblGuardian, 10, SpringLayout.WEST, guardianOne);
		guardianOne.add(lblGuardian);
		
		guardianTwo = new JPanel();
		tabbedPane.addTab("Guardian Two", null, guardianTwo, null);
		tabbedPane.setDisabledIconAt(3, null);
		SpringLayout sl_guardianTwo = new SpringLayout();
		guardianTwo.setLayout(sl_guardianTwo);

		txtG2FirstName = new JTextField();
		guardianTwo.add(txtG2FirstName);
		txtG2FirstName.setColumns(10);

		txtG2surname = new JTextField();
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, txtG2surname, 6, SpringLayout.SOUTH, txtG2FirstName);
		guardianTwo.add(txtG2surname);

		txtG2TelNo = new JTextField();
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, txtG2TelNo, 0, SpringLayout.NORTH, txtG2FirstName);
		sl_guardianTwo.putConstraint(SpringLayout.EAST, txtG2TelNo, -10, SpringLayout.EAST, guardianTwo);
		guardianTwo.add(txtG2TelNo);
		txtG2TelNo.setColumns(10);

		txtG2Email = new JTextField();
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, txtG2Email, 0, SpringLayout.NORTH, txtG2surname);
		sl_guardianTwo.putConstraint(SpringLayout.WEST, txtG2Email, 0, SpringLayout.WEST, txtG2TelNo);
		guardianTwo.add(txtG2Email);
		txtG2Email.setColumns(10);

		txtG2LineOne = new JTextField();
		sl_guardianTwo.putConstraint(SpringLayout.WEST, txtG2LineOne, 0, SpringLayout.WEST, txtG2FirstName);
		guardianTwo.add(txtG2LineOne);
		txtG2LineOne.setColumns(10);

		txtG2LineTwo = new JTextField();
		sl_guardianTwo.putConstraint(SpringLayout.SOUTH, txtG2LineOne, -6, SpringLayout.NORTH, txtG2LineTwo);
		sl_guardianTwo.putConstraint(SpringLayout.WEST, txtG2LineTwo, 0, SpringLayout.WEST, txtG2FirstName);
		guardianTwo.add(txtG2LineTwo);
		txtG2LineTwo.setColumns(10);
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, lblLinetwo, 6, SpringLayout.NORTH, txtG2LineTwo);
		sl_guardianTwo.putConstraint(SpringLayout.WEST, lblLinetwo, 0, SpringLayout.WEST, lblDoctor);
		
		JLabel lblTelNo = new JLabel("Tel No.");
		sl_medical.putConstraint(SpringLayout.WEST, lblTelNo, 6, SpringLayout.EAST, txtDFirstName);
		sl_medical.putConstraint(SpringLayout.SOUTH, lblTelNo, 0, SpringLayout.SOUTH, lblFirstName_1);
		medical.add(lblTelNo);
		
		JLabel lblEmail_1 = new JLabel("Email");
		sl_medical.putConstraint(SpringLayout.NORTH, lblEmail_1, 6, SpringLayout.NORTH, txtDsurname);
		sl_medical.putConstraint(SpringLayout.WEST, lblEmail_1, 6, SpringLayout.EAST, txtDsurname);
		medical.add(lblEmail_1);
		
		JLabel lblTown_1 = new JLabel("Town");
		sl_medical.putConstraint(SpringLayout.WEST, lblTown_1, 6, SpringLayout.EAST, txtDLineOne);
		sl_medical.putConstraint(SpringLayout.SOUTH, lblTown_1, 0, SpringLayout.SOUTH, lblLineOne_1);
		medical.add(lblTown_1);
		
		JLabel lblPostcode_1 = new JLabel("Postcode");
		sl_medical.putConstraint(SpringLayout.WEST, lblPostcode_1, 6, SpringLayout.EAST, txtDLineTwo);
		sl_medical.putConstraint(SpringLayout.SOUTH, lblPostcode_1, 0, SpringLayout.SOUTH, lblLinetwo);
		medical.add(lblPostcode_1);

		txtG2Town = new JTextField();
		sl_guardianTwo.putConstraint(SpringLayout.EAST, txtG2Town, 0, SpringLayout.EAST, txtG2TelNo);
		guardianTwo.add(txtG2Town);
		txtG2Town.setColumns(10);

		txtG2Postcode = new JTextField();
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, txtG2LineTwo, 0, SpringLayout.NORTH, txtG2Postcode);
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, txtG2Postcode, 6, SpringLayout.SOUTH, txtG2Town);
		sl_guardianTwo.putConstraint(SpringLayout.EAST, txtG2Postcode, 0, SpringLayout.EAST, txtG2TelNo);
		guardianTwo.add(txtG2Postcode);
		txtG2Postcode.setColumns(10);

		lblFirstName_3 = new JLabel("First Name");
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, txtG2FirstName, -6, SpringLayout.NORTH, lblFirstName_3);
		sl_guardianTwo.putConstraint(SpringLayout.WEST, txtG2FirstName, 7, SpringLayout.EAST, lblFirstName_3);
		sl_guardianTwo.putConstraint(SpringLayout.WEST, lblFirstName_3, 10, SpringLayout.WEST, guardianTwo);
		guardianTwo.add(lblFirstName_3);

		lblSurname_3 = new JLabel("Surname");
		sl_guardianTwo.putConstraint(SpringLayout.WEST, txtG2surname, 21, SpringLayout.EAST, lblSurname_3);
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, lblSurname_3, 6, SpringLayout.NORTH, txtG2surname);
		sl_guardianTwo.putConstraint(SpringLayout.WEST, lblSurname_3, 0, SpringLayout.WEST, lblFirstName_3);
		guardianTwo.add(lblSurname_3);

		lblTelNo_3 = new JLabel("Tel No.");
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, lblTelNo_3, 6, SpringLayout.NORTH, txtG2FirstName);
		sl_guardianTwo.putConstraint(SpringLayout.WEST, lblTelNo_3, 6, SpringLayout.EAST, txtG2FirstName);
		guardianTwo.add(lblTelNo_3);

		lblEmail_3 = new JLabel("Email");
		sl_guardianTwo.putConstraint(SpringLayout.WEST, lblEmail_3, 225, SpringLayout.WEST, guardianTwo);
		sl_guardianTwo.putConstraint(SpringLayout.EAST, txtG2surname, -6, SpringLayout.WEST, lblEmail_3);
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, lblEmail_3, 6, SpringLayout.NORTH, txtG2surname);
		sl_guardianTwo.putConstraint(SpringLayout.EAST, lblEmail_3, 259, SpringLayout.WEST, guardianTwo);
		guardianTwo.add(lblEmail_3);

		lblAddress_3 = new JLabel("Address");
		sl_guardianTwo.putConstraint(SpringLayout.WEST, lblAddress_3, 0, SpringLayout.WEST, lblFirstName_3);
		guardianTwo.add(lblAddress_3);

		lblLineOne_3 = new JLabel("Line One");
		sl_guardianTwo.putConstraint(SpringLayout.SOUTH, lblAddress_3, -6, SpringLayout.NORTH, lblLineOne_3);
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, lblLineOne_3, 6, SpringLayout.NORTH, txtG2Town);
		sl_guardianTwo.putConstraint(SpringLayout.WEST, lblLineOne_3, 0, SpringLayout.WEST, lblFirstName_3);
		guardianTwo.add(lblLineOne_3);

		lblLineTwo_3 = new JLabel("Line Two");
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, lblLineTwo_3, 6, SpringLayout.NORTH, txtG2LineTwo);
		sl_guardianTwo.putConstraint(SpringLayout.EAST, lblLineTwo_3, 0, SpringLayout.EAST, lblSurname_3);
		guardianTwo.add(lblLineTwo_3);

		lblTown_3 = new JLabel("Town");
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, lblTown_3, 6, SpringLayout.NORTH, txtG2Town);
		sl_guardianTwo.putConstraint(SpringLayout.WEST, lblTown_3, 0, SpringLayout.WEST, lblTelNo_3);
		guardianTwo.add(lblTown_3);

		lblPostcode_3 = new JLabel("Postcode");
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, lblPostcode_3, 6, SpringLayout.NORTH, txtG2LineTwo);
		sl_guardianTwo.putConstraint(SpringLayout.WEST, lblPostcode_3, 6, SpringLayout.EAST, txtG2LineTwo);
		guardianTwo.add(lblPostcode_3);

		comboG2Relation = new JComboBox();
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, comboG2Relation, 6, SpringLayout.SOUTH, txtG2Email);
		sl_guardianTwo.putConstraint(SpringLayout.WEST, comboG2Relation, 0, SpringLayout.WEST, txtG2TelNo);
		sl_guardianTwo.putConstraint(SpringLayout.EAST, comboG2Relation, -10, SpringLayout.EAST, guardianTwo);
		comboG2Relation.setModel(new DefaultComboBoxModel(new String[] {"Mother", "Father", "Carer", "Other"}));
		guardianTwo.add(comboG2Relation);

		lblRelation_3 = new JLabel("Relation");
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, lblRelation_3, 4, SpringLayout.NORTH, comboG2Relation);
		sl_guardianTwo.putConstraint(SpringLayout.WEST, lblRelation_3, 0, SpringLayout.WEST, lblTelNo_3);
		guardianTwo.add(lblRelation_3);

		comboG2Gender = new JComboBox();
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, comboG2Gender, 6, SpringLayout.SOUTH, txtG2surname);
		sl_guardianTwo.putConstraint(SpringLayout.EAST, comboG2Gender, -6, SpringLayout.WEST, lblRelation_3);
		comboG2Gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		guardianTwo.add(comboG2Gender);

		lblGender_3_1 = new JLabel("Gender");
		sl_guardianTwo.putConstraint(SpringLayout.WEST, comboG2Gender, 31, SpringLayout.EAST, lblGender_3_1);
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, lblGender_3_1, 4, SpringLayout.NORTH, comboG2Relation);
		sl_guardianTwo.putConstraint(SpringLayout.WEST, lblGender_3_1, 0, SpringLayout.WEST, lblFirstName_3);
		guardianTwo.add(lblGender_3_1);

		txtG2DateOfBirth = new JTextField();
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, txtG2Town, 39, SpringLayout.SOUTH, txtG2DateOfBirth);
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, txtG2DateOfBirth, 6, SpringLayout.SOUTH, comboG2Relation);
		sl_guardianTwo.putConstraint(SpringLayout.EAST, txtG2DateOfBirth, 0, SpringLayout.EAST, txtG2TelNo);
		guardianTwo.add(txtG2DateOfBirth);
		txtG2DateOfBirth.setColumns(10);

		lblDateOfBirth_3 = new JLabel("Date Of Birth - in format DD/MM/YYYY");
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, lblDateOfBirth_3, 6, SpringLayout.NORTH, txtG2DateOfBirth);
		sl_guardianTwo.putConstraint(SpringLayout.WEST, lblDateOfBirth_3, 0, SpringLayout.WEST, lblFirstName_3);
		guardianTwo.add(lblDateOfBirth_3);
		
		lblGuardian_1 = new JLabel("Guardian");
		sl_guardianTwo.putConstraint(SpringLayout.WEST, lblGuardian_1, 10, SpringLayout.WEST, guardianTwo);
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, lblFirstName_3, 6, SpringLayout.SOUTH, lblGuardian_1);
		sl_guardianTwo.putConstraint(SpringLayout.NORTH, lblGuardian_1, 10, SpringLayout.NORTH, guardianTwo);
		guardianTwo.add(lblGuardian_1);
		
		btnSave = new JButton("Save Changes");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				save();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, -1, SpringLayout.NORTH, btnSave);
		springLayout.putConstraint(SpringLayout.NORTH, btnSave, 406, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 467, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnSave, -22, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, btnMainMenu, 41, SpringLayout.SOUTH, btnSave);
		add(btnSave);
		
		JButton btnNewPlayer = new JButton("New Player");
		btnNewPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createPlayer();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewPlayer, 164, SpringLayout.EAST, scrollPane);
		add(btnNewPlayer);
		
		JButton btnNewJunior = new JButton("New Junior");
		btnNewJunior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createJunior();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewPlayer, 0, SpringLayout.NORTH, btnNewJunior);
		springLayout.putConstraint(SpringLayout.EAST, btnNewPlayer, -6, SpringLayout.WEST, btnNewJunior);
		springLayout.putConstraint(SpringLayout.WEST, btnNewJunior, 0, SpringLayout.WEST, btnMainMenu);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewJunior, -6, SpringLayout.NORTH, btnMainMenu);
		springLayout.putConstraint(SpringLayout.EAST, btnNewJunior, 0, SpringLayout.EAST, btnMainMenu);
		add(btnNewJunior);
		
		btnRevertChanges = new JButton("Revert Changes");
		btnRevertChanges.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnRevertChanges, 0, SpringLayout.NORTH, btnSave);
		springLayout.putConstraint(SpringLayout.WEST, btnRevertChanges, 0, SpringLayout.WEST, btnNewPlayer);
		springLayout.putConstraint(SpringLayout.EAST, btnRevertChanges, -6, SpringLayout.WEST, btnSave);
		add(btnRevertChanges);
		
		btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteSelected();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnDelete, 6, SpringLayout.SOUTH, btnNewPlayer);
		springLayout.putConstraint(SpringLayout.WEST, btnDelete, 0, SpringLayout.WEST, btnNewPlayer);
		springLayout.putConstraint(SpringLayout.EAST, btnDelete, -6, SpringLayout.WEST, btnMainMenu);
		add(btnDelete);
		
		lblExceptFrom = new JLabel("Except:");
		springLayout.putConstraint(SpringLayout.NORTH, lblExceptFrom, 6, SpringLayout.SOUTH, lblAllFieldsRequired);
		springLayout.putConstraint(SpringLayout.WEST, lblExceptFrom, 6, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, lblExceptFrom, 86, SpringLayout.EAST, scrollPane);
		add(lblExceptFrom);
		
		lblKnownMedicalIssues = new JLabel("Known Medical Issues");
		springLayout.putConstraint(SpringLayout.WEST, lblKnownMedicalIssues, 6, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, lblKnownMedicalIssues, 0, SpringLayout.SOUTH, btnNewPlayer);
		add(lblKnownMedicalIssues);
		
		lblAddressLineTwo = new JLabel("Address Line Two");
		springLayout.putConstraint(SpringLayout.NORTH, lblAddressLineTwo, 0, SpringLayout.NORTH, btnMainMenu);
		springLayout.putConstraint(SpringLayout.WEST, lblAddressLineTwo, 6, SpringLayout.EAST, scrollPane);
		add(lblAddressLineTwo);
		
	}
	
	/**
	 * Saves the changes that have been made
	 */
	private void save() {
		//Run validation
		if(!check()){
			JOptionPane.showMessageDialog(new JFrame(),
				    "There are invalid inputs, please correct this and try again.",
				    "Invalid Inputs",
				    JOptionPane.ERROR_MESSAGE);
		}
		else if(check()){
			System.out.println("Validation passed");
			
			selected.setFirstName(txtFirstName.getText());
			selected.setSurname(txtSurname.getText());
			selected.setGender((String) cmbGender.getSelectedItem());
			selected.setTelNo(txtTelNo.getText());
			selected.setMobNo(txtMobNo.getText());
			selected.setEmail(txtEmail.getText());
			selected.setScottishRugbyUnionID(txtSruid.getText());
			selected.setLineOne(txtLineone.getText());
			selected.setLineTwo(txtLinetwo.getText());
			selected.setTown(txtTown.getText());
			selected.setPostcode(txtPostcode.getText());
			selected.setDateOfBirth(parseDate(txtDateOfBirth.getText()));
			selected.setPosition((String) cmbPosition.getSelectedItem());
			
			Doctor d = new Doctor(txtDFirstName.getText(), txtDsurname.getText(), "", new Date());
			d.setTelNo(txtDTelNo.getText());
			d.setEmail(txtDEmail.getText());
			d.setLineOne(txtDLineOne.getText());
			d.setLineTwo(txtDLineTwo.getText());
			d.setTown(txtDTown.getText());
			d.setPostcode(txtDPostcode.getText());
			selected.setDoctor(d);
			selected.setKnownIssues(editorIssues.getText());
			
			if(selected instanceof JuniorPlayer){
				JuniorPlayer junior = (JuniorPlayer) selected;
				Guardian g = new Guardian(txtG1FirstName.getText(), txtG1surname.getText(), 
						(String) comboG1Gender.getSelectedItem(), parseDate(txtG1DateOfBirth.getText()));
				g.setTelNo(txtG1TelNo.getText());
				g.setEmail(txtG1Email.getText());
				g.setLineOne(txtG1LineOne.getText());
				g.setLineTwo(txtG1LineTwo.getText());
				g.setTown(txtG1Town.getText());
				g.setPostcode(txtG1Postcode.getText());
				g.setRelation((String) comboG1Relation.getSelectedItem()); 

				junior.setGuardianOne(g);
				
				g = new Guardian(txtG2FirstName.getText(), txtG2surname.getText(), 
						(String) comboG2Gender.getSelectedItem(), parseDate(txtG2DateOfBirth.getText()));
				g.setTelNo(txtG2TelNo.getText());
				g.setEmail(txtG2Email.getText());
				g.setLineOne(txtG2LineOne.getText());
				g.setLineTwo(txtG2LineTwo.getText());
				g.setTown(txtG2Town.getText());
				g.setPostcode(txtG2Postcode.getText());
				g.setRelation((String) comboG2Relation.getSelectedItem()); 
				junior.setGuardianTwo(g);
			}
				
			if(creating){
				app.getPersonCont().addPerson(selected);
				
				selectedS.addPlayer(selected);
				refresh();
			}
			else{
				selectedS.removePlayer(selected);
				ArrayList<Squad> all = app.getSquadCont().getSquads();
				Iterator<Squad> it = all.iterator();
				
				while(it.hasNext()){
					Squad cur = it.next();
					if(cur.getName() == cmbSquad.getSelectedItem()){
						selectedS = cur;
					}
				}
				
				selectedS.addPlayer(selected);
				update();
			}
			
		}
	}
	
	/**
	 * Validates user input the forms 
	 * @return the result of the validation
	 */
	private boolean check(){
		boolean fail = false;
		
		//Details fields
		if(txtFirstName.getText().equals(""))
		{
			fail = true;
		}
		if(txtSurname.getText().equals(""))
		{
			fail = true;
		}
		if(cmbGender.getSelectedIndex() == -1)
		{
			fail = true;
		}
		if(txtTelNo.getText().equals(""))
		{
			fail = true;
		}
		if(txtMobNo.getText().equals(""))
		{
			fail = true;
		}
		if(txtEmail.getText().equals(""))
		{
			fail = true;
		}
		if(txtSruid.getText().equals(""))
		{
			fail = true;
		}
		if(txtLineone.getText().equals(""))
		{
			fail = true;
		}
		if(txtLinetwo.getText().equals(""))
		{
			fail = true;
		}
		if(txtTown.getText().equals(""))
		{
			fail = true;
		}
		if(txtPostcode.getText().equals(""))
		{
			fail = true;
		}
		if(parseDate(txtDateOfBirth.getText()) == null)
		{
			System.out.println("Date failed");
			fail = true;
		}
		if(cmbPosition.getSelectedIndex() == -1)
		{
			fail = true;
		}
		if(cmbSquad.getSelectedIndex() == -1)
		{
			fail = true;
		}

		//Medical fields
		if(txtDFirstName.getText().equals(""))
		{
			fail = true;
		}
		if(txtDsurname.getText().equals(""))
		{
			fail = true;
		}
		if(txtDTelNo.getText().equals(""))
		{
			fail = true;
		}
		if(txtDEmail.getText().equals(""))
		{
			fail = true;
		}
		if(txtDLineOne.getText().equals(""))
		{
			fail = true;
		}

		if(txtDTown.getText().equals(""))
		{
			fail = true;
		}
		if(txtDPostcode.getText().equals(""))
		{
			fail = true;
		}

		//Guardian fields
		if(selected instanceof JuniorPlayer)
		{
			if(txtG1FirstName.getText().equals(""))
			{
				fail = true;
			}
			if(txtG1surname.getText().equals(""))
			{
				fail = true;
			}
			if(comboG1Gender.getSelectedIndex() == -1)
			{
				fail = true;
			}
			if(comboG1Relation.getSelectedIndex() == -1)
			{
				fail = true;
			}
			if(parseDate(txtG1DateOfBirth.getText()) == null)
			{
				fail = true;
			}

			if(txtG1TelNo.getText().equals(""))
			{
				fail = true;
			}
			if(txtG1Email.getText().equals(""))
			{
				fail = true;
			}
			if(txtG1LineOne.getText().equals(""))
			{
				fail = true;
			}
			if(txtG1LineTwo.getText().equals(""))
			{
				fail = true;
			}
			if(txtG1Town.getText().equals(""))
			{
				fail = true;
			}
			if(txtG1Postcode.getText().equals(""))
			{
				fail = true;
			}

			if(txtG2FirstName.getText().equals(""))
			{
				fail = true;
			}
			if(txtG2surname.getText().equals(""))
			{
				fail = true;
			}
			if(comboG2Gender.getSelectedIndex() == -1)
			{
				fail = true;
			}
			if(parseDate(txtG2DateOfBirth.getText()) == null)
			{
				fail = true;
			}

			if(txtG2TelNo.getText().equals(""))
			{
				fail = true;
			}
			if(txtG2Email.getText().equals(""))
			{
				fail = true;
			}
			if(comboG2Relation.getSelectedIndex() == -1)
			{
				fail = true;
			}

			if(txtG2LineOne.getText().equals(""))
			{
				fail = true;
			}
			if(txtG2LineTwo.getText().equals(""))
			{
				fail = true;
			}
			if(txtG2Town.getText().equals(""))
			{
				fail = true;
			}
			if(txtG2Postcode.getText().equals(""))
			{
				fail = true;
			}
		}
		return !fail;
	}
	
	/**
	 * Deletes the player currently selected in the list from the system
	 */
	private void deleteSelected() {
		try{
			app.getPersonCont().removePerson(getSelectedPlayer(listPlayers));
			app.getSquadCont().getPlayerSquad(getSelectedPlayer(listPlayers)).
			removePlayer(getSelectedPlayer(listPlayers));
			selected = null;
			selectedS = null;
		}
		catch (Exception e){
			
		}
		update();
	}
	
	/**
	 * Updates the view based on the selected 
	 */
	private void update(){

		refresh();
		
		if(selected == null){
			return;
		}
		
		if(selected.getFirstName() == null){
			return;
		}
		
		//Details fields
		txtFirstName.setText(selected.getFirstName());
		txtSurname.setText(selected.getSurname());
		cmbGender.setSelectedItem(selected.getGender());
		txtTelNo.setText(selected.getTelNo());
		txtMobNo.setText(selected.getMobNo());
		txtEmail.setText(selected.getEmail());
		txtSruid.setText(selected.getScottishRugbyUnionID());
		txtLineone.setText(selected.getLineOne());
		txtLinetwo.setText(selected.getLineTwo());
		txtTown.setText(selected.getTown());
		txtPostcode.setText(selected.getPostcode());
		txtDateOfBirth.setText(formatDate(selected.getDateOfBirth()));
		cmbPosition.setSelectedItem(selected.getPosition());
		
		//Medical fields
		txtDFirstName.setText(selected.getDoctor().getFirstName());
		txtDsurname.setText(selected.getDoctor().getSurname());
		txtDTelNo.setText(selected.getDoctor().getTelNo());
		txtDEmail.setText(selected.getDoctor().getEmail());
		txtDLineOne.setText(selected.getDoctor().getLineOne());
		txtDLineTwo.setText(selected.getDoctor().getLineTwo());
		txtDTown.setText(selected.getDoctor().getTown());
		txtDPostcode.setText(selected.getDoctor().getPostcode());
		editorIssues.setText(selected.getKnownIssues());
		//Guardian fields
		if(selected instanceof JuniorPlayer)
		{
			JuniorPlayer junior = (JuniorPlayer) selected;
			Guardian g = junior.getGuardianOne();
			Guardian g2 = junior.getGuardianTwo();
			
			if(g != null){
				txtG1FirstName.setText(g.getFirstName());
				txtG1surname.setText(g.getSurname());
				comboG1Gender.setSelectedItem(g.getGender());
				comboG1Relation.setSelectedItem(g.getRelation());
				txtG1DateOfBirth.setText(formatDate(g.getDateOfBirth()));
	
				txtG1TelNo.setText(g.getTelNo());
				txtG1Email.setText(g.getEmail());
				txtG1LineOne.setText(g.getLineOne());
				txtG1LineTwo.setText(g.getLineTwo());
				txtG1Town.setText(g.getTown());
				txtG1Postcode.setText(g.getPostcode());
			}
			
			
			if(g2 != null){
				txtG2FirstName.setText(g2.getFirstName());
				txtG2surname.setText(g2.getSurname());
				comboG2Gender.setSelectedItem(g2.getGender());
				txtG2DateOfBirth.setText(formatDate(g2.getDateOfBirth()));

				txtG2TelNo.setText(g2.getTelNo());
				txtG2Email.setText(g2.getEmail());
				comboG2Relation.setSelectedItem(g2.getRelation());

				txtG2LineOne.setText(g2.getLineOne());
				txtG2LineTwo.setText(g2.getLineTwo());
				txtG2Town.setText(g2.getTown());
				txtG2Postcode.setText(g2.getPostcode());
			}
			
		}
		String squadName = app.getSquadCont().getPlayerSquad(selected).getName();
		cmbSquad.setSelectedItem(squadName);
		repaint();
	}
	
	/**
	 * Sets up the form enabled states and sets all the values back to their default state
	 */
	private void refresh() {
		
		int slIndex = listPlayers.getSelectedIndex();
		updateList();
		listPlayers.setSelectedIndex(slIndex);
		
		//save button
		if(creating){
			btnSave.setText("Save New Player");
		}
		else{
			btnSave.setText("Save Changes");
		}
		
		if(selected == null){
			btnSave.setEnabled(false);
		}
		else{
			btnSave.setEnabled(true);
		}
		
		//Set default (empty form)
		//Details fields
		txtFirstName.setText("");
		txtSurname.setText("");
		cmbGender.setSelectedIndex(-1);
		txtTelNo.setText("");
		txtMobNo.setText("");
		txtEmail.setText("");
		txtSruid.setText("");
		txtLineone.setText("");
		txtLinetwo.setText("");
		txtTown.setText("");
		txtPostcode.setText("");
		txtDateOfBirth.setText("");
		cmbPosition.setSelectedIndex(-1);
		cmbSquad.setSelectedIndex(-1);
		
		//Medical fields
		txtDFirstName.setText("");
		txtDsurname.setText("");
		txtDTelNo.setText("");
		txtDEmail.setText("");
		txtDLineOne.setText("");
		txtDLineTwo.setText("");
		txtDTown.setText("");
		txtDPostcode.setText("");
		editorIssues.setText("");

		//Guardian fields
		txtG1FirstName.setText("");
		txtG1surname.setText("");
		comboG1Gender.setSelectedIndex(-1);
		comboG1Relation.setSelectedIndex(-1);
		txtG1DateOfBirth.setText("");

		txtG1TelNo.setText("");
		txtG1Email.setText("");
		txtG1LineOne.setText("");
		txtG1LineTwo.setText("");
		txtG1Town.setText("");
		txtG1Postcode.setText("");

		txtG2FirstName.setText("");
		txtG2surname.setText("");
		comboG2Gender.setSelectedIndex(-1);
		txtG2DateOfBirth.setText("");

		txtG2TelNo.setText("");
		txtG2Email.setText("");
		comboG2Relation.setSelectedIndex(-1);

		txtG2LineOne.setText("");
		txtG2LineTwo.setText("");
		txtG2Town.setText("");
		txtG2Postcode.setText("");
		
		//Enable/Disable the guardian forms	
		if(selected == null){
			
			//Details fields
			txtFirstName.setEnabled(false);
			txtSurname.setEnabled(false);
			cmbGender.setEnabled(false);
			txtTelNo.setEnabled(false);
			txtMobNo.setEnabled(false);
			txtEmail.setEnabled(false);
			txtSruid.setEnabled(false);
			txtLineone.setEnabled(false);
			txtLinetwo.setEnabled(false);
			txtTown.setEnabled(false);
			txtPostcode.setEnabled(false);
			txtDateOfBirth.setEnabled(false);
			cmbPosition.setEnabled(false);
			cmbSquad.setEnabled(false);

			//Medical fields
			txtDFirstName.setEnabled(false);
			txtDsurname.setEnabled(false);
			txtDTelNo.setEnabled(false);
			txtDEmail.setEnabled(false);
			txtDLineOne.setEnabled(false);
			txtDLineTwo.setEnabled(false);
			txtDTown.setEnabled(false);
			txtDPostcode.setEnabled(false);
			editorIssues.setEnabled(false);
			
			txtG1FirstName.setEnabled(false);
			txtG1surname.setEnabled(false);
			comboG1Gender.setEnabled(false);
			comboG1Relation.setEnabled(false);
			txtG1DateOfBirth.setEnabled(false);
			txtG1TelNo.setEnabled(false);
			txtG1Email.setEnabled(false);
			txtG1LineOne.setEnabled(false);
			txtG1LineTwo.setEnabled(false);
			txtG1Town.setEnabled(false);
			txtG1Postcode.setEnabled(false);

			txtG2FirstName.setEnabled(false);
			txtG2surname.setEnabled(false);
			comboG2Gender.setEnabled(false);
			txtG2DateOfBirth.setEnabled(false);
			txtG2TelNo.setEnabled(false);
			txtG2Email.setEnabled(false);
			comboG2Relation.setEnabled(false);
			txtG2LineOne.setEnabled(false);
			txtG2LineTwo.setEnabled(false);
			txtG2Town.setEnabled(false);
			txtG2Postcode.setEnabled(false);
		}
		if(selected != null){
			
			//Details fields
			txtFirstName.setEnabled(true);
			txtSurname.setEnabled(true);
			cmbGender.setEnabled(true);
			txtTelNo.setEnabled(true);
			txtMobNo.setEnabled(true);
			txtEmail.setEnabled(true);
			txtSruid.setEnabled(true);
			txtLineone.setEnabled(true);
			txtLinetwo.setEnabled(true);
			txtTown.setEnabled(true);
			txtPostcode.setEnabled(true);
			txtDateOfBirth.setEnabled(true);
			cmbPosition.setEnabled(true);
			cmbSquad.setEnabled(true);

			//Medical fields
			txtDFirstName.setEnabled(true);
			txtDsurname.setEnabled(true);
			txtDTelNo.setEnabled(true);
			txtDEmail.setEnabled(true);
			txtDLineOne.setEnabled(true);
			txtDLineTwo.setEnabled(true);
			txtDTown.setEnabled(true);
			txtDPostcode.setEnabled(true);
			editorIssues.setEnabled(true);
			
			if(selected instanceof JuniorPlayer){
				txtG1FirstName.setEnabled(true);
				txtG1surname.setEnabled(true);
				comboG1Gender.setEnabled(true);
				comboG1Relation.setEnabled(true);
				txtG1DateOfBirth.setEnabled(true);
				txtG1TelNo.setEnabled(true);
				txtG1Email.setEnabled(true);
				txtG1LineOne.setEnabled(true);
				txtG1LineTwo.setEnabled(true);
				txtG1Town.setEnabled(true);
				txtG1Postcode.setEnabled(true);

				txtG2FirstName.setEnabled(true);
				txtG2surname.setEnabled(true);
				comboG2Gender.setEnabled(true);
				txtG2DateOfBirth.setEnabled(true);
				txtG2TelNo.setEnabled(true);
				txtG2Email.setEnabled(true);
				comboG2Relation.setEnabled(true);
				txtG2LineOne.setEnabled(true);
				txtG2LineTwo.setEnabled(true);
				txtG2Town.setEnabled(true);
				txtG2Postcode.setEnabled(true);
			}
			else{
				txtG1FirstName.setEnabled(false);
				txtG1surname.setEnabled(false);
				comboG1Gender.setEnabled(false);
				comboG1Relation.setEnabled(false);
				txtG1DateOfBirth.setEnabled(false);
				txtG1TelNo.setEnabled(false);
				txtG1Email.setEnabled(false);
				txtG1LineOne.setEnabled(false);
				txtG1LineTwo.setEnabled(false);
				txtG1Town.setEnabled(false);
				txtG1Postcode.setEnabled(false);

				txtG2FirstName.setEnabled(false);
				txtG2surname.setEnabled(false);
				comboG2Gender.setEnabled(false);
				txtG2DateOfBirth.setEnabled(false);
				txtG2TelNo.setEnabled(false);
				txtG2Email.setEnabled(false);
				comboG2Relation.setEnabled(false);
				txtG2LineOne.setEnabled(false);
				txtG2LineTwo.setEnabled(false);
				txtG2Town.setEnabled(false);
				txtG2Postcode.setEnabled(false);
			}
		}
		
		repaint();
	}

	/**
	 * initializes the form for a new standard player
	 */
	private void createPlayer(){
		selected = new Player();
		creating = true;
		refresh();
	}
	
	/**
	 * initializes the form for a new junior player
	 */
	private void createJunior(){
		selected = new JuniorPlayer();
		creating = true;
		refresh();
	}
	
	/**
	 * Returns the player currently selected in the JList
	 * 
	 * @param l
	 * @return
	 */
	private Player getSelectedPlayer(JList l){
		if(selectionMade(l)){
			Player p = players.get(l.getSelectedIndex());
			return p;
		}
		else{
			JOptionPane.showMessageDialog(new JFrame(), "No player was selected.", "Warning",
			        JOptionPane.WARNING_MESSAGE);
		}
				
		return null;
	}

	/**
	 * Checks if a selection has been made on the JList
	 * 
	 * @param l
	 * @return
	 */
	private boolean selectionMade(JList l){
		if(l.getSelectedIndex() == -1){
			return false;
		}
		return true;
	}
	
	/**
	 * Updates the list model
	 */
	private void updateList(){
		players = app.getPersonCont().returnPlayers();
		Iterator<Player> it = players.iterator();
		DefaultListModel listModel = new DefaultListModel();

		while(it.hasNext()){
			Player cur = it.next();
			listModel.addElement(cur.getFirstName() + " " + cur.getSurname());
		}
		
		listPlayers.setModel(listModel);
	}
	
	/**
	 * Converts a string of DD/MM/YYYY into a Date object
	 * @param string 
	 * @return java.util.Date object
	 */
	private Date parseDate(String string){
		try{
			Date temp = new SimpleDateFormat("dd/MM/yy")
			.parse(string);
			return temp;
		}
		catch(Exception e){
			return null;
		}
	}
	
	/**
	 * Formats a date to a string for the GUI
	 * @param d
	 * @return
	 */
	private String formatDate(Date d){
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return String.valueOf(c.get(Calendar.DAY_OF_MONTH)) + "/" +
		String.valueOf(c.get(Calendar.MONTH) + 1) + "/" + String.valueOf(c.get(Calendar.YEAR));
	}
}