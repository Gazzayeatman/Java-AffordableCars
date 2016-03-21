import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class MainForm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	private JComboBox comboBox = new JComboBox();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		loadTestData();	
		initialize();	
	}
	
	public void loadTestData(){
		Business.addYard("Wellington Central", "12 Courtenay Place", "04 559 5857");
		Business.addYard("Karori", "123 Chaytor Street", "04 434 4556");
		Yard central = Business.getYardByName("Wellington Central");
		Yard karori = Business.getYardByName("Karori");
		
		//Central
		central.addCar("Honda", "Accord Euro R", 2004, 140000, "Blue", 145000);
		central.addCar("Subaru", "Legacy B4", 2006, 200000, "Black", 15000);
		central.addCar("Toyota", "Altezza", 2000, 250000, "Silver", 7000);
		central.addCar("Honda", "Jazz", 2001, 12000, "Red", 4500);
		//Karori
		karori.addCar("Suzuki", "Swift", 2004, 12000, "Blue", 10000);
		karori.addCar("BMW", "318i", 2000, 300000, "Silver", 2000);
		karori.addCar("Honda", "Oddyssey", 1990, 340000, "White", 1000);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				refreshComboBox(comboBox,frame);
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		frame.setBounds(100, 100, 536, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Affordable Cars");
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblTitle.setBounds(6, 6, 426, 16);
		frame.getContentPane().add(lblTitle);
		
		JButton btnAddANewSite = new JButton("Add a new Site");
		btnAddANewSite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmAddNewSite s = new frmAddNewSite();
				s.setVisible(true);
			}
		});
		btnAddANewSite.setBounds(6, 72, 136, 29);
		frame.getContentPane().add(btnAddANewSite);
		
		JButton btnAddANewCar = new JButton("Add a new Car");
		btnAddANewCar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmAddCar c = new frmAddCar();
				c.setVisible(true);
			}
		});
		btnAddANewCar.setBounds(6, 97, 136, 29);
		frame.getContentPane().add(btnAddANewCar);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(413, 280, 117, 29);
		frame.getContentPane().add(btnExit);
		
		
		JButton btnSelectSite = new JButton("Select Site");
		btnSelectSite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String item = (String) comboBox.getSelectedItem();
				Yard yard = Business.getYardByName(item);
				View.say(yard.getName());
				frmSite site = new frmSite(yard);
				site.setVisible(true);
			}
		});
		btnSelectSite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelectSite.setBounds(154, 280, 117, 29);
		frame.getContentPane().add(btnSelectSite);
		
		refreshComboBox(comboBox, frame);
		
		JList list = new JList();
		list.setForeground(Color.WHITE);
		list.setBounds(518, 72, -355, 189);
		frame.getContentPane().add(list);
	}
	public static void refreshComboBox(JComboBox box, JFrame frame){
		box.removeAllItems();
		box.setBounds(6, 281, 136, 27);
		populateComboBox(box);
		frame.getContentPane().add(box);
	}
	public static void populateComboBox(JComboBox box){
		for(Yard y : Business.myYards){
			box.addItem(y.getName());
		}
	}
}
