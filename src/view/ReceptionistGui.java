package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.Controller;

public class ReceptionistGui extends JFrame implements IReceptionistGui {
	private JFrame receptionist;
	private JButton makeReservation, findReservation, deleteReservation,
			showAllResevations, backFromDelete, backFromFind, backFromShowAll, delete,find, backFromFounded;
	private Controller controller;
	private ButtonHandlerRec handler;
	private JTextArea showAll, showFoundRes;
	private JScrollPane scrolltxt, scrolltxtFind;
	private JPanel contentPaneBeginning, contentPaneFind, contentPaneDelete, contentPaneShowAll, contentPaneFoundRes;
	private JLabel findL , deleteL;
	private JTextField findTF, deleteTF;

	public ReceptionistGui() {
		super("Receptionist");

		receptionist = new JFrame();
		createComponents();
		initializeComponents();
		addComponentsToFrame();

	}
	public static void main(String[] args) {
		ReceptionistGui view = new ReceptionistGui();
		Controller controller = new Controller(view);
		view.start(controller);
		view.setVisible(true);
	}
	@Override
	public void showFoundRes(String value) {
		showFoundRes.setText(value);
		
	}
	@Override
	public void start(Controller controller) {
		this.controller = controller;
		this.handler = new ButtonHandlerRec(this.controller, this);
		registerEventHandlers();
		setVisible(true);
	}

	@Override
	public void show(String value) {
		showAll.setText(value);
	}

	@Override
	public String get(String what) {
		String input = JOptionPane.showInputDialog("" + what);
		return input;
	}

	private void createComponents() {
		setSize(1500, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private void initializeComponents() {
		findL = new JLabel("Råservation ¹:");
		deleteL =  new JLabel("Råservation ¹:");
		findTF = new JTextField(15);
		deleteTF  = new JTextField(15);
		makeReservation = new JButton("Make a Reservation");
		findReservation = new JButton("Find a Reservation");
		deleteReservation = new JButton("Delete a Reservation");
		showAllResevations = new JButton("Show all Reservations");
		showFoundRes = new JTextArea(25,50);
		showFoundRes.setWrapStyleWord(true);
		scrolltxtFind = new JScrollPane(showFoundRes);
		showAll = new JTextArea(25, 50);
		showAll.setWrapStyleWord(true);
		scrolltxt = new JScrollPane(showAll);
		backFromDelete = new JButton("Back");
		backFromFind = new JButton("Back");
		backFromShowAll = new JButton("Back");
		delete = new JButton("Delete");
		find = new JButton("Find");
		backFromFounded = new JButton("Back");
	}

	private void registerEventHandlers() {
		showAllResevations.addActionListener(handler);
		backFromDelete.addActionListener(handler);
		backFromFind.addActionListener(handler);
		backFromShowAll.addActionListener(handler);
		makeReservation.addActionListener(handler);
		deleteReservation.addActionListener(handler);
		findReservation.addActionListener(handler);
		delete.addActionListener(handler);
		find.addActionListener(handler);
		backFromFounded.addActionListener(handler);
	}

	private void addComponentsToFrame() {
		
		// Panel Beginning start
		
		contentPaneBeginning = new JPanel(new GridLayout(0,1));
		contentPaneBeginning.add(makeReservation);
		contentPaneBeginning.add(showAllResevations);
		contentPaneBeginning.add(findReservation);
		contentPaneBeginning.add(deleteReservation);
		
		// Panel Beginning end
		
		// Panel Find reservation start
			
		JPanel panelReservationFinder = new JPanel();
		panelReservationFinder.add(findL);
		panelReservationFinder.add(findTF);
		
		JPanel panelInnerButtonsFinder = new JPanel(new BorderLayout());
		panelInnerButtonsFinder.add(backFromFind, BorderLayout.WEST);
		panelInnerButtonsFinder.add(find, BorderLayout.EAST);

		JPanel panelOuterButtonsFinder = new JPanel(new BorderLayout());
		panelOuterButtonsFinder
				.add(panelInnerButtonsFinder, BorderLayout.SOUTH);
		
		contentPaneFind = new JPanel(new GridLayout(0,1));
		contentPaneFind.add(panelReservationFinder);
		contentPaneFind.add(panelOuterButtonsFinder);
		
		// Panel Find reservation End
		
		// Panel Found Res start 
		
			JPanel panelFoundReservation = new JPanel();
			panelFoundReservation.add(scrolltxtFind);
			
			JPanel panelInnerButtonsFound = new JPanel(new BorderLayout());
			panelInnerButtonsFound.add(backFromFounded, BorderLayout.WEST);

			JPanel panelOuterButtonsFound = new JPanel(new BorderLayout());
			panelOuterButtonsFound
					.add(panelInnerButtonsFound, BorderLayout.SOUTH);
			
			contentPaneFoundRes = new JPanel(new GridLayout(0,1));
			contentPaneFoundRes.add(panelFoundReservation);
			contentPaneFoundRes.add(panelOuterButtonsFound);
		
		// Panel Found Res end
		
		// Panel Show all start 
		
		JPanel panelShowAll = new JPanel();
		panelShowAll.add(scrolltxt);
		
		JPanel panelInnerButtonsReservation = new JPanel(new BorderLayout());
		panelInnerButtonsReservation.add(backFromShowAll, BorderLayout.WEST);

		JPanel panelOuterButtonsReservation = new JPanel(new BorderLayout());
		panelOuterButtonsReservation
				.add(panelInnerButtonsReservation, BorderLayout.SOUTH);
		
		contentPaneShowAll = new JPanel(new GridLayout(0,1));
		contentPaneShowAll.add(panelShowAll);
		contentPaneShowAll.add(panelOuterButtonsReservation);
		
		
		// Panel Show all end
		
		// Panel Delete reservation start
		
		JPanel panelDeleteReservation = new JPanel();
		panelDeleteReservation.add(deleteL);
		panelDeleteReservation.add(deleteTF);
		
		JPanel panelInnerButtonsDelete = new JPanel(new BorderLayout());
		panelInnerButtonsDelete.add(backFromDelete, BorderLayout.WEST);
		panelInnerButtonsDelete.add(delete, BorderLayout.EAST);


		JPanel panelOuterButtonsDelete = new JPanel(new BorderLayout());
		panelOuterButtonsDelete
				.add(panelInnerButtonsDelete, BorderLayout.SOUTH);
		
		contentPaneDelete = new JPanel(new GridLayout(0,1));
		contentPaneDelete.add(panelDeleteReservation);
		contentPaneDelete.add(panelOuterButtonsDelete);
		
		// Panel Delete reservation end
		
		setContentPane(contentPaneBeginning);
	}

	private class ButtonHandlerRec implements ActionListener {
		private Controller controller;
		private ReceptionistGui gui;

		public ButtonHandlerRec(Controller controller, ReceptionistGui gui) {
			this.controller = controller;
			this.gui = gui;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == showAllResevations)
			{
				setContentPane(contentPaneShowAll);
				controller.execute("AllReservations", null);
				revalidate();
			}
			else if(e.getSource() == backFromShowAll)
			{
				setContentPane(contentPaneBeginning);
				revalidate();
			}
			else if(e.getSource() == backFromDelete)
			{
				setContentPane(contentPaneBeginning);
				revalidate();
			}
			else if(e.getSource() == backFromFind)
			{
				setContentPane(contentPaneBeginning);
				revalidate();
			}
			else if (e.getSource() == makeReservation)
			{
				CustomerGui view = new CustomerGui();
				Controller controller = new Controller(view);
				view.start(controller);
			}
			else if(e.getSource() == backFromFounded)
			{
				setContentPane(contentPaneBeginning);
				revalidate();
			}
			else if(e.getSource() == findReservation)
			{
				setContentPane(contentPaneFind);
				revalidate();
			}
			else if(e.getSource() == find)
			{
				setContentPane(contentPaneFoundRes);
				String[] objects = new String[1];
				objects[0] = findTF.getText().toString();
				controller.execute("FindReservation", objects);
				revalidate();
			}
			else if(e.getSource() == deleteReservation)
			{
				setContentPane(contentPaneDelete);
				revalidate();
			}
			else if(e.getSource() == delete)
			{
				String[] objects = new String[1];
				objects[0] = deleteTF.getText().toString();
				controller.execute("DeleteReservation", objects);
				setContentPane(contentPaneBeginning);
				revalidate();	
			}
		}

	}
}
