import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmAddCar extends JFrame {

	private JPanel contentPane;
	private JTextField txtMake;
	private JTextField txtModel;
	private JTextField txtYear;
	private JTextField txtKms;
	private JTextField txtColour;
	private JTextField txtPrice;
	private JComboBox comboBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAddCar frame = new frmAddCar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmAddCar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Affordable Cars - Add a new car");
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTitle.setBounds(6, 6, 438, 16);
		contentPane.add(lblTitle);
		
		txtMake = new JTextField();
		txtMake.setBounds(191, 34, 134, 28);
		contentPane.add(txtMake);
		txtMake.setColumns(10);
		
		txtModel = new JTextField();
		txtModel.setBounds(191, 69, 134, 28);
		contentPane.add(txtModel);
		txtModel.setColumns(10);
		
		txtYear = new JTextField();
		txtYear.setBounds(191, 104, 134, 28);
		contentPane.add(txtYear);
		txtYear.setColumns(10);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setVisible(false);
				frmAddCar.this.setVisible(false);
			}
		});
		btnExit.setBounds(327, 243, 117, 29);
		contentPane.add(btnExit);
		
		txtKms = new JTextField();
		txtKms.setBounds(191, 139, 134, 28);
		contentPane.add(txtKms);
		txtKms.setColumns(10);
		
		txtColour = new JTextField();
		txtColour.setBounds(191, 174, 134, 28);
		contentPane.add(txtColour);
		txtColour.setColumns(10);
		
		comboBox.setBounds(191, 244, 134, 27);
		for(Yard y : Business.myYards){
			comboBox.addItem(y.getName());
		}
		contentPane.add(comboBox);
		
		JLabel lblMake = new JLabel("Make:");
		lblMake.setBounds(16, 40, 61, 16);
		contentPane.add(lblMake);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(16, 75, 61, 16);
		contentPane.add(lblModel);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(16, 110, 61, 16);
		contentPane.add(lblYear);
		
		JLabel lblMileage = new JLabel("Mileage:");
		lblMileage.setBounds(16, 145, 61, 16);
		contentPane.add(lblMileage);
		
		JLabel lblColour = new JLabel("Colour:");
		lblColour.setBounds(16, 180, 61, 16);
		contentPane.add(lblColour);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(191, 209, 134, 28);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(16, 215, 61, 16);
		contentPane.add(lblPrice);
		
		JLabel lblCurrentCarYard = new JLabel("Current Car Yard:");
		lblCurrentCarYard.setBounds(16, 248, 134, 16);
		contentPane.add(lblCurrentCarYard);
		
		JButton btnAddNewCar = new JButton("Add New Car");
		btnAddNewCar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Yard y = Business.getYardByName(comboBox.getSelectedItem().toString());
				y.addCar(txtMake.getText(), txtModel.getText(), Integer.parseInt(txtYear.getText()),Integer.parseInt(txtKms.getText()), txtColour.getText(), Integer.parseInt(txtPrice.getText()));
				frmAddCar.this.dispose();
				Business.printAllCars();
			}
		});
		btnAddNewCar.setBounds(327, 210, 117, 29);
		contentPane.add(btnAddNewCar);
	}
}
