package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.PersonList;
import controller.Controller;

public class CustomerGui extends JFrame implements ICustomerGui {

	private static final long serialVersionUID = 1L;
	private JFrame customer;

	private JButton save, english, danish, backToLanguage, nextToDateinterval,
			backToCustomerInfo, nextToChooseRoom, backToDateinterval,
			backToChooseRoom, addPerson, nextToShowRes, backToPersonAdder;
	private JLabel customerFirstName, customerLastName, customerCPR,
			customerBirthday, customerEmail, customerAddress, bDay, bMonth,
			bYear, chooseARoom, dateinterval, startingDate, endingDate,
			startDay, startMonth, startYear, endingDay, endingMonth,
			endingYear, roomType, totalReservation, logoImage, personName,
			personBirthday, personBday, personBmonth, personByear, floor1,
			floor2, floor3, peopleAdded, personFName;
	private JTextField customerFirstNameTF, customerLastNameTF, customerCPRTF,
			customerEmailTF, customerAddressTF, personNameTF, personFNameTF;
	private String[] typeOfRooms = { "Single", "Double", "Apartment" };
	private JComboBox<String> roomTypeCB, bDayCB, bMonthCB, bYearCB,
			startDayCB, startMonthCB, startYearCB, endDayCB, endMonthCB,
			endYearCB, pBday, pBmonth, pBYear;
	private File file = new File("buses.dat");
	private JPanel contentPaneLanguage, contentPanePersonInfo,
			contentPaneDateIntervalRoomType, contentPanePickRoom,
			contentPanePeopleAdder, contentPaneShowReservation;
	private String[] years = { "2017", "2018", "2019", "2020" };
	private String[] bYears = {"2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006", "2005", "2004", "2003",
			"2002","2001","2000","1999","1998","1997","1996", "1995"};
	private String[] months = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12" };
	private JButton r101, r102, r103, r104, r105, r106, r107, r108, r109;
	private Controller controller;
	private ButtonHandler handler;
	private int maxPeopleInRoom;
	private JTextArea showReservation;

	public CustomerGui() {
		super("Customer");

		customer = new JFrame();
		createComponents();
		initializeComponents();
		addComponentsToFrame();

	}

	public int getPeopleMax() {
		return maxPeopleInRoom;
	}

	@Override
	public void start(Controller controller) {
		this.controller = controller;
		this.handler = new ButtonHandler(this.controller, this);
		registerEventHandlers();
		setVisible(true);
	}

	@Override
	public void show(String value) {
		showReservation.setText(value);
	}

	public void showMaxPeople(int peopleInTheMoment) {
		peopleAdded.setText("      People added: " + peopleInTheMoment
				+ "     Max: " + maxPeopleInRoom);
	}

	@Override
	public String get(String what) {
		String input = JOptionPane.showInputDialog("" + what);
		return input;
	}

	private void createComponents() {
		setSize(1500, 1000);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	private void initializeComponents() {
		save = new JButton("Save");
		personFName = new JLabel("Last name");
		personFNameTF = new JTextField(15);
		pBday = new JComboBox<>();
		backToPersonAdder = new JButton("Back");
		addPerson = new JButton("Add");
		pBmonth = new JComboBox<>(months);
		pBYear = new JComboBox<>(bYears);
		nextToShowRes = new JButton("Next");
		showReservation = new JTextArea(20, 50);
		showReservation.setEditable(false);
		showReservation.setFont(new Font("Calibri", Font.PLAIN, 34));
		r101 = new JButton("Room 101");
		r102 = new JButton("Room 102");
		r103 = new JButton("Room 103");
		r104 = new JButton("Room 104");
		r105 = new JButton("Room 105");
		r106 = new JButton("Room 106");
		r107 = new JButton("Room 107");
		r108 = new JButton("Room 108");
		r109 = new JButton("Room 109");
		peopleAdded = new JLabel("      People added: " + "     Max: "
				+ maxPeopleInRoom);
		customerFirstName = new JLabel("First name: ");
		customerFirstName.setFont(new Font("Calibri", Font.PLAIN, 34));

		customerLastName = new JLabel("Last name: ");
		customerLastName.setFont(new Font("Calibri", Font.PLAIN, 34));
		customerCPR = new JLabel("CPR: ");
		customerBirthday = new JLabel("Birthday: ");
		customerEmail = new JLabel("Email: ");
		customerAddress = new JLabel("Address: ");
		bDay = new JLabel("Day: ");
		bMonth = new JLabel("Month: ");
		bYear = new JLabel("Year: ");
		chooseARoom = new JLabel(
				"                                         Choose room: ");
		chooseARoom.setFont(new Font("Calibri", Font.PLAIN, 34));

		dateinterval = new JLabel("Date interval: ");
		startingDate = new JLabel("Starting date: ");
		endingDate = new JLabel("Ending date: ");
		startDay = new JLabel("Day: ");
		startMonth = new JLabel("Month: ");
		startYear = new JLabel("Year: ");
		endingDay = new JLabel("Day: ");
		endingMonth = new JLabel("Month: ");
		endingYear = new JLabel("Year: ");
		roomType = new JLabel("Room type: ");
		totalReservation = new JLabel("Resevation: ");
		roomTypeCB = new JComboBox<String>(typeOfRooms);
		Image imgEnglish = null;
		Image imgDanish = null;
		Image imgLogo = null;
		save = new JButton("Save");
		backToLanguage = new JButton("Back");
		nextToDateinterval = new JButton("Next");
		backToCustomerInfo = new JButton("Back");
		nextToChooseRoom = new JButton("Next");
		backToDateinterval = new JButton("Back");
		backToChooseRoom = new JButton("Back");
		personName = new JLabel("Person:     First name: ");
		personNameTF = new JTextField(15);
		personBirthday = new JLabel("Person Birthday: ");
		personBday = new JLabel("Day: ");
		personBmonth = new JLabel("Month: ");
		personByear = new JLabel("Year: ");
		try {
			imgEnglish = ImageIO.read(getClass().getResource("english.png"));

			imgLogo = ImageIO.read(getClass().getResource("logo.png"));

			imgDanish = ImageIO.read(getClass().getResource("danish.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		logoImage = new JLabel(new ImageIcon(imgLogo));
		english = new JButton();
		danish = new JButton();
		english.setIcon(new ImageIcon(imgEnglish));
		danish.setIcon(new ImageIcon(imgDanish));
		// to remote the spacing between the image and button's borders
		english.setMargin(new Insets(0, 0, 0, 0));
		danish.setMargin(new Insets(0, 0, 0, 0));
		// to remove the border
		english.setBorder(null);
		danish.setBorder(null);
		customerFirstNameTF = new JTextField(15);
		customerFirstNameTF.setFont(new Font("Calibri", Font.PLAIN, 24));
		customerLastNameTF = new JTextField(15);
		customerLastNameTF.setFont(new Font("Calibri", Font.PLAIN, 24));
		customerCPRTF = new JTextField(20);
		customerEmailTF = new JTextField(20);
		customerAddressTF = new JTextField(20);
		bDayCB = new JComboBox<>();
		bMonthCB = new JComboBox<>(months);
		bYearCB = new JComboBox<>(bYears);
		startDayCB = new JComboBox<>();
		startMonthCB = new JComboBox<>(months);
		startYearCB = new JComboBox<>(years);
		endDayCB = new JComboBox<>();
		endMonthCB = new JComboBox<>();
		endYearCB = new JComboBox<>();
		floor1 = new JLabel("         1st Floor: ");
		floor2 = new JLabel("         2nd Floor: ");
		floor3 = new JLabel("         3rd Floor: ");
		peopleAdded.setFont(new Font("Calibri", Font.PLAIN, 34));

	}

	private void registerEventHandlers() {
		save.addActionListener(handler);
		english.addActionListener(handler);
		danish.addActionListener(handler);
		bDayCB.addMouseListener(handler);
		startDayCB.addMouseListener(handler);
		nextToDateinterval.addActionListener(handler);
		endMonthCB.addMouseListener(handler);
		endYearCB.addMouseListener(handler);
		endDayCB.addMouseListener(handler);
		nextToChooseRoom.addActionListener(handler);
		backToCustomerInfo.addActionListener(handler);
		backToDateinterval.addActionListener(handler);
		r101.addActionListener(handler);
		r102.addActionListener(handler);
		r103.addActionListener(handler);
		r104.addActionListener(handler);
		r105.addActionListener(handler);
		r106.addActionListener(handler);
		r107.addActionListener(handler);
		r108.addActionListener(handler);
		r109.addActionListener(handler);
		pBday.addMouseListener(handler);
		nextToShowRes.addActionListener(handler);
		backToPersonAdder.addActionListener(handler);
		backToLanguage.addActionListener(handler);
		backToChooseRoom.addActionListener(handler);
		addPerson.addActionListener(handler);

	}

	private void addComponentsToFrame() {
		// Panel Language starts
		JPanel panelLogo = new JPanel();
		panelLogo.add(logoImage);

		JPanel panelLangIcon = new JPanel();
		panelLangIcon.add(english);
		panelLangIcon.add(danish);

		contentPaneLanguage = new JPanel(new GridLayout(0, 1));
		contentPaneLanguage.add(panelLogo);
		contentPaneLanguage.add(panelLangIcon);
		// Panel Language ends

		// Panel Person Info starts
		JPanel panelFirstName = new JPanel();
		panelFirstName.add(customerFirstName);
		panelFirstName.add(customerFirstNameTF);

		JPanel panelLastName = new JPanel();
		panelFirstName.add(customerLastName);
		panelFirstName.add(customerLastNameTF);

		JPanel panelCPR = new JPanel();
		panelCPR.add(customerCPR);
		panelCPR.add(customerCPRTF);

		JPanel panelBirthday = new JPanel();
		panelBirthday.add(customerBirthday);
		panelBirthday.add(bYear);
		panelBirthday.add(bYearCB);
		panelBirthday.add(bMonth);
		panelBirthday.add(bMonthCB);
		panelBirthday.add(bDay);
		panelBirthday.add(bDayCB);

		JPanel panelEmail = new JPanel();
		panelEmail.add(customerEmail);
		panelEmail.add(customerEmailTF);

		JPanel panelAddress = new JPanel();
		panelAddress.add(customerAddress);
		panelAddress.add(customerAddressTF);

		JPanel panelInnerButtonsPersonInfo = new JPanel(new BorderLayout());
		panelInnerButtonsPersonInfo.add(backToLanguage, BorderLayout.WEST);
		panelInnerButtonsPersonInfo.add(nextToDateinterval, BorderLayout.EAST);

		JPanel panelOuterButtonsPersonInfo = new JPanel(new BorderLayout());
		panelOuterButtonsPersonInfo.add(panelInnerButtonsPersonInfo,
				BorderLayout.SOUTH);

		contentPanePersonInfo = new JPanel(new GridLayout(0, 1));
		contentPanePersonInfo.add(panelFirstName);
		contentPanePersonInfo.add(panelLastName);
		contentPanePersonInfo.add(panelCPR);
		contentPanePersonInfo.add(panelBirthday);
		contentPanePersonInfo.add(panelEmail);
		contentPanePersonInfo.add(panelAddress);
		contentPanePersonInfo.add(panelOuterButtonsPersonInfo);

		// Panel Person Info ends

		// Panel Date interval and Room type starts

		JPanel panelStartDate = new JPanel();
		panelStartDate.add(startingDate);
		panelStartDate.add(startYear);
		panelStartDate.add(startYearCB);
		panelStartDate.add(startMonth);
		panelStartDate.add(startMonthCB);
		panelStartDate.add(startDay);
		panelStartDate.add(startDayCB);

		JPanel panelEndDate = new JPanel();
		panelEndDate.add(endingDate);
		panelEndDate.add(endingYear);
		panelEndDate.add(endYearCB);
		panelEndDate.add(endingMonth);
		panelEndDate.add(endMonthCB);
		panelEndDate.add(endingDay);
		panelEndDate.add(endDayCB);

		JPanel panelRoomType = new JPanel();
		panelRoomType.add(roomType);
		panelRoomType.add(roomTypeCB);

		JPanel panelInnerButtonsDate = new JPanel(new BorderLayout());
		panelInnerButtonsDate.add(backToCustomerInfo, BorderLayout.WEST);
		panelInnerButtonsDate.add(nextToChooseRoom, BorderLayout.EAST);

		JPanel panelOuterButtonsDate = new JPanel(new BorderLayout());
		panelOuterButtonsDate.add(panelInnerButtonsDate, BorderLayout.SOUTH);

		contentPaneDateIntervalRoomType = new JPanel(new GridLayout(0, 1));
		contentPaneDateIntervalRoomType.add(dateinterval);
		contentPaneDateIntervalRoomType.add(panelStartDate);
		contentPaneDateIntervalRoomType.add(panelEndDate);
		contentPaneDateIntervalRoomType.add(panelRoomType);
		contentPaneDateIntervalRoomType.add(panelOuterButtonsDate);

		// Panel Room type and Date interval ends

		// Panel Room pick start
		JPanel panelRoomButtons = new JPanel(new GridLayout(0, 4));
		panelRoomButtons.add(floor1);
		panelRoomButtons.add(r101);
		panelRoomButtons.add(r102);
		panelRoomButtons.add(r103);
		panelRoomButtons.add(floor2);
		panelRoomButtons.add(r104);
		panelRoomButtons.add(r105);
		panelRoomButtons.add(r106);
		panelRoomButtons.add(floor3);
		panelRoomButtons.add(r107);
		panelRoomButtons.add(r108);
		panelRoomButtons.add(r109);

		JPanel panelInnerButtonsPickRoom = new JPanel(new BorderLayout());
		panelInnerButtonsPickRoom.add(backToDateinterval, BorderLayout.WEST);

		JPanel panelOuterButtonsPickRoom = new JPanel(new BorderLayout());
		panelOuterButtonsPickRoom.add(panelInnerButtonsPickRoom,
				BorderLayout.SOUTH);

		contentPanePickRoom = new JPanel(new GridLayout(0, 1));
		contentPanePickRoom.add(chooseARoom);
		contentPanePickRoom.add(panelRoomButtons);
		contentPanePickRoom.add(panelOuterButtonsPickRoom);

		// Panel Room pick end

		// Panel Add Person start

		JPanel panelPersonName = new JPanel();
		panelPersonName.add(personName);
		panelPersonName.add(personNameTF);
		panelPersonName.add(personFName);
		panelPersonName.add(personFNameTF);

		JPanel panelPersonBDay = new JPanel();
		panelPersonBDay.add(personBirthday);
		panelPersonBDay.add(personByear);
		panelPersonBDay.add(pBYear);
		panelPersonBDay.add(personBmonth);
		panelPersonBDay.add(pBmonth);
		panelPersonBDay.add(personBday);
		panelPersonBDay.add(pBday);

		JPanel panelAddButton = new JPanel();
		panelAddButton.add(addPerson);

		JPanel panelInnerButtonsPeople = new JPanel(new BorderLayout());
		panelInnerButtonsPeople.add(backToChooseRoom, BorderLayout.WEST);
		panelInnerButtonsPeople.add(nextToShowRes, BorderLayout.EAST);

		JPanel panelOuterButtonsPeople = new JPanel(new BorderLayout());
		panelOuterButtonsPeople
				.add(panelInnerButtonsPeople, BorderLayout.SOUTH);

		contentPanePeopleAdder = new JPanel(new GridLayout(0, 1));
		contentPanePeopleAdder.add(peopleAdded);
		contentPanePeopleAdder.add(panelPersonName);
		contentPanePeopleAdder.add(panelPersonBDay);
		contentPanePeopleAdder.add(panelAddButton);
		contentPanePeopleAdder.add(panelOuterButtonsPeople);

		// Panel Add Person end

		// Panel Show Reservation start

		JPanel panelInnerButtonsShowRes = new JPanel(new BorderLayout());
		panelInnerButtonsShowRes.add(backToPersonAdder, BorderLayout.WEST);
		panelInnerButtonsShowRes.add(save, BorderLayout.EAST);

		JPanel panelOuterButtonsShowRes = new JPanel(new BorderLayout());
		panelOuterButtonsShowRes.add(panelInnerButtonsShowRes,
				BorderLayout.SOUTH);

		contentPaneShowReservation = new JPanel(new GridLayout(0, 1));
		contentPaneShowReservation.add(showReservation);
		contentPaneShowReservation.add(panelOuterButtonsShowRes);

		// Panel Show Reservation end

		setContentPane(contentPaneLanguage);
	}

	public static void main(String[] args) {
		CustomerGui view = new CustomerGui();
		Controller controller = new Controller(view);
		view.start(controller);
		// view.setVisible(true);

	}

	public class ButtonHandler implements ActionListener, MouseListener {
		private Controller controller;
		private CustomerGui guiTest;

		public ButtonHandler(Controller controller, CustomerGui guiTest) {
			this.controller = controller;
			this.guiTest = guiTest;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String busTypeSet = "";
			if (e.getSource() == english) {
				setContentPane(contentPanePersonInfo);

				controller.execute("NewPersonList", null);

				// Setting Language start
				save.setText("Save");
				personFName.setText("Last name");
				backToPersonAdder.setText("Back");
				addPerson.setText("Add");
				nextToShowRes.setText("Next");
				customerFirstName.setText("First name: ");

				customerLastName.setText("Last name: ");
				customerBirthday.setText("Birthday: ");
				customerAddress.setText("Address: ");
				bDay.setText("Day: ");
				bMonth.setText("Month: ");
				bYear.setText("Year: ");
				chooseARoom
						.setText("                                         Choose room: ");

				dateinterval.setText("Date interval: ");
				startingDate.setText("Starting date: ");
				endingDate.setText("Ending date: ");
				startDay.setText("Day: ");
				startMonth.setText("Month: ");
				startYear.setText("Year: ");
				endingDay.setText("Day: ");
				endingMonth.setText("Month: ");
				endingYear.setText("Year: ");
				roomType.setText("Room type: ");
				totalReservation.setText("Resevation: ");
				save.setText("Save");
				backToLanguage.setText("Back");
				nextToDateinterval.setText("Next");
				backToCustomerInfo.setText("Back");
				nextToChooseRoom.setText("Next");
				backToDateinterval.setText("Back");
				backToChooseRoom.setText("Back");
				personName.setText("Person:     First name: ");
				personBirthday.setText("Person Birthday: ");
				personBday.setText("Day: ");
				personBmonth.setText("Month: ");
				personByear.setText("Year: ");
				floor1.setText("         1st Floor: ");
				floor2.setText("         2nd Floor: ");
				floor3.setText("         3rd Floor: ");
				// Setting Language end
				revalidate();

			}
			if (e.getSource() == danish) {
				setContentPane(contentPanePersonInfo);

				controller.execute("NewPersonList", null);

				// Setting Language start
				save.setText("Gemme");
				personFName.setText("Efternavn");
				backToPersonAdder.setText("Tilbage");
				addPerson.setText("Tilføje");
				nextToShowRes.setText("Næste");
				customerFirstName.setText("Fornavn: ");

				customerLastName.setText("Efternavn: ");
				customerBirthday.setText("Fødselsdag: ");
				customerAddress.setText("Address: ");
				bDay.setText("Dag: ");
				bMonth.setText("Måned: ");
				bYear.setText("År: ");
				chooseARoom
						.setText("                                         Vælg værelse: ");

				dateinterval.setText("Datointerval: ");
				startingDate.setText("Start dato: ");
				endingDate.setText("Slutdato: ");
				startDay.setText("Dag: ");
				startMonth.setText("Måned: ");
				startYear.setText("År: ");
				endingDay.setText("Dag: ");
				endingMonth.setText("Måned: ");
				endingYear.setText("År: ");
				roomType.setText("Værelses type: ");
				totalReservation.setText("Reservationer: ");
				backToLanguage.setText("Tilbage");
				nextToDateinterval.setText("Næste");
				backToCustomerInfo.setText("Tilbage");
				nextToChooseRoom.setText("Næste");
				backToDateinterval.setText("Tilbage");
				backToChooseRoom.setText("Tilbage");
				personName.setText("Person:     Fornavn: ");
				personBirthday.setText("Person: Fødselsdag: ");
				personBday.setText("Dag: ");
				personBmonth.setText("Måned: ");
				personByear.setText("År: ");
				floor1.setText("         1. sal: ");
				floor2.setText("         2. sal: ");
				floor3.setText("         3. sal: ");
				// Setting Language end
				revalidate();
			}
			if (e.getSource() == backToLanguage) {
				setContentPane(contentPaneLanguage);
				revalidate();
			}

			if (e.getSource() == nextToDateinterval) {
				setContentPane(contentPaneDateIntervalRoomType);
				revalidate();
				String[] objects = new String[8];
				objects[0] = customerFirstNameTF.getText();
				objects[1] = customerLastNameTF.getText();
				objects[2] = customerCPRTF.getText();
				objects[3] = (String) bDayCB.getSelectedItem();
				objects[4] = (String) bMonthCB.getSelectedItem();
				objects[5] = (String) bYearCB.getSelectedItem();
				objects[6] = customerEmailTF.getText();
				objects[7] = customerAddressTF.getText();
				controller.execute("Customer", objects);

			}
			if (e.getSource() == nextToChooseRoom) {
				setContentPane(contentPanePickRoom);
				if (("Single").equalsIgnoreCase((String) roomTypeCB
						.getSelectedItem())) {
					maxPeopleInRoom = 0;
					r101.setEnabled(true);
					r101.setBackground(Color.green);
					r102.setEnabled(true);
					r102.setBackground(Color.green);
					r103.setEnabled(true);
					r103.setBackground(Color.green);
					r104.setEnabled(false);
					r104.setBackground(Color.red);
					r105.setEnabled(false);
					r105.setBackground(Color.red);
					r106.setEnabled(false);
					r106.setBackground(Color.red);
					r107.setEnabled(false);
					r107.setBackground(Color.red);
					r108.setEnabled(false);
					r108.setBackground(Color.red);
					r109.setEnabled(false);
					r109.setBackground(Color.red);
				} else if (("Double").equalsIgnoreCase((String) roomTypeCB
						.getSelectedItem())) {
					maxPeopleInRoom = 1;
					r101.setEnabled(false);
					r102.setEnabled(false);
					r103.setEnabled(false);
					r104.setEnabled(true);
					r105.setEnabled(true);
					r106.setEnabled(true);
					r107.setEnabled(false);
					r108.setEnabled(false);
					r109.setEnabled(false);
					r101.setBackground(Color.red);
					r102.setBackground(Color.red);
					r103.setBackground(Color.red);
					r107.setBackground(Color.red);
					r108.setBackground(Color.red);
					r109.setBackground(Color.red);
					r104.setBackground(Color.green);
					r105.setBackground(Color.green);
					r106.setBackground(Color.green);
				} else if (("Apartment").equalsIgnoreCase((String) roomTypeCB
						.getSelectedItem())) {
					maxPeopleInRoom = 3;
					r101.setEnabled(false);
					r102.setEnabled(false);
					r103.setEnabled(false);
					r104.setEnabled(false);
					r105.setEnabled(false);
					r106.setEnabled(false);
					r107.setEnabled(true);
					r108.setEnabled(true);
					r109.setEnabled(true);
					r101.setBackground(Color.red);
					r102.setBackground(Color.red);
					r103.setBackground(Color.red);
					r104.setBackground(Color.red);
					r105.setBackground(Color.red);
					r106.setBackground(Color.red);
					r107.setBackground(Color.green);
					r108.setBackground(Color.green);
					r109.setBackground(Color.green);
				}
				peopleAdded.setText("      People added: " + "     Max: "
						+ maxPeopleInRoom);

				revalidate();
				String[] objects = new String[6];
				objects[0] = (String) startDayCB.getSelectedItem();
				objects[1] = (String) startMonthCB.getSelectedItem();
				objects[2] = (String) startYearCB.getSelectedItem();
				objects[3] = (String) endDayCB.getSelectedItem();
				objects[4] = (String) endMonthCB.getSelectedItem();
				objects[5] = (String) endYearCB.getSelectedItem();

				controller.execute("DateInterval", objects);
			}
			if (e.getSource() == backToDateinterval) {
				setContentPane(contentPaneDateIntervalRoomType);
				revalidate();
			}
			if (e.getSource() == backToCustomerInfo) {
				setContentPane(contentPanePersonInfo);
				revalidate();
			}
			if (e.getSource() == backToChooseRoom) {
				setContentPane(contentPanePickRoom);
				revalidate();
			}
			if (e.getSource() == nextToShowRes) {
				setContentPane(contentPaneShowReservation);
				revalidate();
			}
			if (e.getSource() == r101) {
				setContentPane(contentPanePeopleAdder);
				revalidate();
				String[] objects = new String[2];
				objects[0] = "" + 101;
				objects[1] = (String) roomTypeCB.getSelectedItem();
				controller.execute("Room", objects);
			}
			if (e.getSource() == r102) {
				setContentPane(contentPanePeopleAdder);
				revalidate();
				String[] objects = new String[2];
				objects[0] = "" + 102;
				objects[1] = (String) roomTypeCB.getSelectedItem();
				controller.execute("Room", objects);
			}
			if (e.getSource() == r103) {
				setContentPane(contentPanePeopleAdder);
				revalidate();
				String[] objects = new String[2];
				objects[0] = "" + 103;
				objects[1] = (String) roomTypeCB.getSelectedItem();
				controller.execute("Room", objects);
			}
			if (e.getSource() == r104) {
				setContentPane(contentPanePeopleAdder);
				revalidate();
				String[] objects = new String[2];
				objects[0] = "" + 104;
				objects[1] = (String) roomTypeCB.getSelectedItem();
				controller.execute("Room", objects);
			}
			if (e.getSource() == r105) {
				setContentPane(contentPanePeopleAdder);
				revalidate();
				String[] objects = new String[2];
				objects[0] = "" + 105;
				objects[1] = (String) roomTypeCB.getSelectedItem();
				controller.execute("Room", objects);
			}
			if (e.getSource() == r106) {
				setContentPane(contentPanePeopleAdder);
				revalidate();
				String[] objects = new String[2];
				objects[0] = "" + 106;
				objects[1] = (String) roomTypeCB.getSelectedItem();
				controller.execute("Room", objects);
			}
			if (e.getSource() == r107) {
				setContentPane(contentPanePeopleAdder);
				revalidate();
				String[] objects = new String[2];
				objects[0] = "" + 107;
				objects[1] = (String) roomTypeCB.getSelectedItem();
				controller.execute("Room", objects);
			}
			if (e.getSource() == r108) {
				setContentPane(contentPanePeopleAdder);
				revalidate();
				String[] objects = new String[2];
				objects[0] = "" + 108;
				objects[1] = (String) roomTypeCB.getSelectedItem();
				controller.execute("Room", objects);
			}
			if (e.getSource() == r109) {
				setContentPane(contentPanePeopleAdder);
				revalidate();
				String[] objects = new String[2];
				objects[0] = "" + 109;
				objects[1] = (String) roomTypeCB.getSelectedItem();
				controller.execute("Room", objects);
			}
			if (e.getSource() == backToChooseRoom) {
				setContentPane(contentPanePickRoom);
				revalidate();
			}

			if (e.getSource() == nextToShowRes) {
				setContentPane(contentPaneShowReservation);
				revalidate();
				controller.execute("ShowReservation", null);
			}
			if (e.getSource() == backToPersonAdder) {
				setContentPane(contentPanePeopleAdder);
				revalidate();
			}
			if (e.getSource() == addPerson) {
				String[] objects = new String[6];
				objects[0] = personNameTF.getText().toString();
				objects[1] = personFNameTF.getText().toString();
				objects[2] = (String) pBday.getSelectedItem().toString();
				objects[3] = (String) pBmonth.getSelectedItem().toString();
				objects[4] = (String) pBYear.getSelectedItem().toString();
				objects[5] = "" + maxPeopleInRoom;
				controller.execute("AddPerson", objects);

			}
			if (e.getSource() == save) {
				setContentPane(contentPaneLanguage);
				revalidate();
				controller.execute("SaveReservation", null);
			}

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == bDayCB) {
				bDayCB.removeAllItems();
				int selectedYear = Integer.parseInt((String) bYearCB
						.getSelectedItem());
				int selectedMonth = Integer.parseInt((String) bMonthCB
						.getSelectedItem());
				if (selectedYear % 4 == 0 && selectedMonth == 2) {
					for (int i = 1; i <= 29; i++) {
						bDayCB.addItem("" + i);
					}
				} else if (selectedMonth == 1 || selectedMonth == 3
						|| selectedMonth == 5 || selectedMonth == 7
						|| selectedMonth == 8 || selectedMonth == 10
						|| selectedMonth == 12) {
					for (int i = 1; i <= 31; i++) {
						bDayCB.addItem("" + i);
					}
				} else if (selectedMonth == 4 || selectedMonth == 6
						|| selectedMonth == 9 || selectedMonth == 11) {
					for (int i = 1; i <= 30; i++) {
						bDayCB.addItem("" + i);
					}
				} else {
					for (int i = 1; i <= 28; i++) {
						bDayCB.addItem("" + i);
					}
				}
			}

			if (e.getSource() == pBday) {
				pBday.removeAllItems();
				int selectedYear = Integer.parseInt((String) pBYear
						.getSelectedItem());
				int selectedMonth = Integer.parseInt((String) pBmonth
						.getSelectedItem());
				if (selectedYear % 4 == 0 && selectedMonth == 2) {
					for (int i = 1; i <= 29; i++) {
						pBday.addItem("" + i);
					}
				} else if (selectedMonth == 1 || selectedMonth == 3
						|| selectedMonth == 5 || selectedMonth == 7
						|| selectedMonth == 8 || selectedMonth == 10
						|| selectedMonth == 12) {
					for (int i = 1; i <= 31; i++) {
						pBday.addItem("" + i);
					}
				} else if (selectedMonth == 4 || selectedMonth == 6
						|| selectedMonth == 9 || selectedMonth == 11) {
					for (int i = 1; i <= 30; i++) {
						pBday.addItem("" + i);
					}
				} else {
					for (int i = 1; i <= 28; i++) {
						pBday.addItem("" + i);
					}
				}
			}

			if (e.getSource() == startDayCB) {
				startDayCB.removeAllItems();
				int selectedYear = Integer.parseInt((String) startYearCB
						.getSelectedItem());
				int selectedMonth = Integer.parseInt((String) startMonthCB
						.getSelectedItem());
				if (selectedYear % 4 == 0 && selectedMonth == 2) {
					for (int i = 1; i <= 29; i++) {
						startDayCB.addItem("" + i);
					}
				} else if (selectedMonth == 1 || selectedMonth == 3
						|| selectedMonth == 5 || selectedMonth == 7
						|| selectedMonth == 8 || selectedMonth == 10
						|| selectedMonth == 12) {
					for (int i = 1; i <= 31; i++) {
						startDayCB.addItem("" + i);
					}
				} else if (selectedMonth == 4 || selectedMonth == 6
						|| selectedMonth == 9 || selectedMonth == 11) {
					for (int i = 1; i <= 30; i++) {
						startDayCB.addItem("" + i);
					}
				} else {
					for (int i = 1; i <= 28; i++) {
						startDayCB.addItem("" + i);
					}
				}
			}

			if (e.getSource() == endYearCB) {
				endYearCB.removeAllItems();
				int startingYearInt = Integer.parseInt((String) startYearCB
						.getSelectedItem());
				for (int i = startingYearInt; i < 2022; i++) {
					endYearCB.addItem("" + i);
				}
			}
			if (e.getSource() == endMonthCB) {
				endMonthCB.removeAllItems();
				int startYearInt = Integer.parseInt((String) startYearCB
						.getSelectedItem());
				int endYearInt = Integer.parseInt((String) endYearCB
						.getSelectedItem());
				if (startYearInt == endYearInt) {
					int getMonth = Integer.parseInt((String) startMonthCB
							.getSelectedItem());
					for (int i = getMonth; i <= 12; i++) {
						endMonthCB.addItem("" + i);
					}
				}
			}
			if (e.getSource() == endDayCB) {
				endDayCB.removeAllItems();
				int getStartDayInt = Integer.parseInt((String) startDayCB
						.getSelectedItem());
				int selectedYear = Integer.parseInt((String) endYearCB
						.getSelectedItem());
				int selectedMonth = Integer.parseInt((String) endMonthCB
						.getSelectedItem());
				int startYearInt = Integer.parseInt(startYearCB
						.getSelectedItem().toString());
				int startMonthInt = Integer.parseInt(startMonthCB
						.getSelectedItem().toString());

				if (selectedYear == startYearInt
						&& selectedMonth == startMonthInt) {
					if (selectedYear % 4 == 0 && selectedMonth == 2) {

						for (int i = getStartDayInt; i <= 29; i++) {
							endDayCB.addItem("" + i);
						}
					} else if (selectedMonth == 1 || selectedMonth == 3
							|| selectedMonth == 5 || selectedMonth == 7
							|| selectedMonth == 8 || selectedMonth == 10
							|| selectedMonth == 12) {
						for (int i = getStartDayInt; i <= 31; i++) {
							endDayCB.addItem("" + i);
						}
					} else if (selectedMonth == 4 || selectedMonth == 6
							|| selectedMonth == 9 || selectedMonth == 11) {
						for (int i = getStartDayInt; i <= 30; i++) {
							endDayCB.addItem("" + i);
						}
					} else {
						for (int i = getStartDayInt; i <= 28; i++) {
							endDayCB.addItem("" + i);
						}
					}
				} else {
					if (selectedYear % 4 == 0 && selectedMonth == 2) {

						for (int i = 1; i <= 29; i++) {
							endDayCB.addItem("" + i);
						}
					} else if (selectedMonth == 1 || selectedMonth == 3
							|| selectedMonth == 5 || selectedMonth == 7
							|| selectedMonth == 8 || selectedMonth == 10
							|| selectedMonth == 12) {
						for (int i = 1; i <= 31; i++) {
							endDayCB.addItem("" + i);
						}
					} else if (selectedMonth == 4 || selectedMonth == 6
							|| selectedMonth == 9 || selectedMonth == 11) {
						for (int i = 1; i <= 30; i++) {
							endDayCB.addItem("" + i);
						}
					} else {
						for (int i = 1; i <= 28; i++) {
							endDayCB.addItem("" + i);
						}
					}
				}

			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
