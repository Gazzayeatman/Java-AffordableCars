import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmAddNewSite extends JFrame {

	private JPanel contentPane;
	private JTextField tbxName;
	private JTextField tbxAddress;
	private JTextField tbxPhoneNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAddNewSite frame = new frmAddNewSite();
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
	public frmAddNewSite() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Affordable Cars - Add a new site");
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTitle.setBounds(6, 6, 438, 16);
		contentPane.add(lblTitle);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setVisible(false);
				frmAddNewSite.this.setVisible(false);
			}
		});
		
		btnExit.setBounds(422, 243, 117, 29);
		contentPane.add(btnExit);
		
		tbxName = new JTextField();
		tbxName.setBounds(205, 63, 134, 28);
		contentPane.add(tbxName);
		tbxName.setColumns(10);
		
		tbxAddress = new JTextField();
		tbxAddress.setBounds(205, 103, 134, 28);
		contentPane.add(tbxAddress);
		tbxAddress.setColumns(10);
		
		tbxPhoneNumber = new JTextField();
		tbxPhoneNumber.setBounds(205, 143, 134, 28);
		contentPane.add(tbxPhoneNumber);
		tbxPhoneNumber.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(16, 69, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(16, 109, 61, 16);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number: ");
		lblPhoneNumber.setBounds(16, 149, 177, 16);
		contentPane.add(lblPhoneNumber);
		
		JTextPane txtpnAff = new JTextPane();
		txtpnAff.setEditable(false);
		txtpnAff.setVisible(false);
		txtpnAff.setText("Errors:");
		txtpnAff.setBounds(353, 63, 177, 108);
		contentPane.add(txtpnAff);
		
		JButton btnAddSite = new JButton("Add New Site");
		btnAddSite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Business.addYard(tbxName.getText(), tbxAddress.getText(), tbxPhoneNumber.getText());
				View.say(tbxName.getText() + " added");
				for (Yard y : Business.myYards){
					View.say(y.getName());
				}
				contentPane.setVisible(false);
				frmAddNewSite.this.setVisible(false);
			}
		});
		btnAddSite.setBounds(205, 182, 134, 29);
		contentPane.add(btnAddSite);
	}

}
