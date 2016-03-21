import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class frmSite extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Yard yard = null;
					frmSite frame = new frmSite(yard);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JList listCars = new JList();
	/**
	 * Create the frame.
	 */
	public frmSite(Yard yard) {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				updateListCars(yard);
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Affordable Cars - Site: "+ yard.getName());
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTitle.setBounds(6, 6, 438, 16);
		contentPane.add(lblTitle);
		
		JButton btnExit = new JButton("Back");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setVisible(false);
				frmSite.this.setVisible(false);
			}
		});
		btnExit.setBounds(630, 290, 117, 29);
		contentPane.add(btnExit);
		
		JButton btnEditDetails = new JButton("Edit Details");
		btnEditDetails.setBounds(16, 34, 133, 29);
		contentPane.add(btnEditDetails);
		
		
		JLabel lblCars = new JLabel("Cars");
		lblCars.setBounds(6, 64, 61, 16);
		contentPane.add(lblCars);
		
		JLabel lblEmployees = new JLabel("Employees");
		lblEmployees.setBounds(378, 64, 88, 16);
		contentPane.add(lblEmployees);
		
		JList listEmployees = new JList();
		listEmployees.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEmployees.setBounds(378, 92, 350, 150);
		contentPane.add(listEmployees);
		
		JButton btnCarAdd = new JButton("Add");
		btnCarAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmAddCar frmCar = new frmAddCar();
					frmCar.setVisible(true);
				}
			});
		btnCarAdd.setBounds(26, 255, 105, 29);
		contentPane.add(btnCarAdd);
		
		JButton btnCarEdit = new JButton("Edit");
		btnCarEdit.setBounds(126, 255, 105, 29);
		contentPane.add(btnCarEdit);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(388, 255, 105, 29);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(492, 255, 105, 29);
		contentPane.add(btnEdit);
		
		DefaultListModel cars = populateCarList(yard);
		listCars.setModel(cars);
		listCars.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCars.setBounds(16, 92, 350, 150);
		contentPane.add(listCars);
	}
	
	public static DefaultListModel populateCarList(Yard yard){
		DefaultListModel listModel = new DefaultListModel();
		if (yard != null){
			for(Car c : yard.myCars){
				listModel.addElement(c.get());
			}
		}
		return listModel;
	}
	public void updateListCars(Yard yard){
		DefaultListModel listModel = new DefaultListModel();
		listModel = populateCarList(yard);
		listCars.setModel(listModel);
		contentPane.add(listCars);
	}
	
}
