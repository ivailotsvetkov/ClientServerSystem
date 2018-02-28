package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuiTestForCalendar extends JFrame {
	private JFrame customer;
	private JLabel calendar, day, month, year;
	private JComboBox<String> dayCB, monthCB, yearCB;
	private String[] years = { "2017", "2018", "2019", "2020" };
	private String[] months = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12" };

	public GuiTestForCalendar() {
		super("Customer");

		customer = new JFrame();
		createComponents();
		initializeComponents();
		registerEventHandlers();
		addComponentsToFrame();

	}

	private void createComponents() {
		calendar = new JLabel("Calendar: ");
		day = new JLabel("Day: ");
		month = new JLabel("Month: ");
		year = new JLabel("Year: ");
		yearCB = new JComboBox<String>(years);
		monthCB = new JComboBox<String>(months);
		dayCB = new JComboBox<String>();
	}

	private void initializeComponents() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void registerEventHandlers() {
		ButtonHandler handler = new ButtonHandler();
		dayCB.addMouseListener(handler);
	}

	private void addComponentsToFrame() {
		JPanel panel = new JPanel();
		panel.add(calendar);
		panel.add(year);
		panel.add(yearCB);
		panel.add(month);
		panel.add(monthCB);
		panel.add(day);
		panel.add(dayCB);

		setContentPane(panel);
	}

	public static void main(String[] args) {
		GuiTestForCalendar view = new GuiTestForCalendar();
		view.setVisible(true);
	}

	private class ButtonHandler implements ActionListener, MouseListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == dayCB) {
				dayCB.removeAllItems();
				int selectedYear = Integer.parseInt((String) yearCB
						.getSelectedItem());
				int selectedMonth = Integer.parseInt((String) monthCB
						.getSelectedItem());
				if (selectedYear % 4 == 0 && selectedMonth == 2) {
					for (int i = 1; i <= 29; i++) {
						dayCB.addItem("" + i);
					}
				} else if (selectedMonth == 1 || selectedMonth == 3
						|| selectedMonth == 5 || selectedMonth == 7
						|| selectedMonth == 8 || selectedMonth == 10
						|| selectedMonth == 12) {
					for (int i = 1; i <= 31; i++) {
						dayCB.addItem("" + i);
					}
				} else if (selectedMonth == 4 || selectedMonth == 6
						|| selectedMonth == 9 || selectedMonth == 11) {
					for (int i = 1; i <= 30; i++) {
						dayCB.addItem("" + i);
					}
				} else {
					for (int i = 1; i <= 28; i++) {
						dayCB.addItem("" + i);
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
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
