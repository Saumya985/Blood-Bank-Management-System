import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1568, 968);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Username = new JLabel("Username");
		Username.setFont(new Font("Tahoma", Font.BOLD, 14));
		Username.setHorizontalAlignment(SwingConstants.CENTER);
		Username.setBounds(557, 328, 140, 35);
		contentPane.add(Username);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(254, 120, 120));
		textField.setBounds(719, 330, 300, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(557, 390, 140, 35);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBackground(new Color(254, 120, 120));
		passwordField.setBounds(719, 392, 300, 35);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("BloodBank") && passwordField.getText().equals("admin")) {
					setVisible(false);
					new home().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(login.class.getResource("/Images/login.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(738, 454, 105, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a= JOptionPane.showConfirmDialog(null, "Do you really want to close","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					System.exit(0);
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(login.class.getResource("/Images/Exit application.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(900, 454, 105, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 142, 142));
		lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/Images/Login page 2.png")));
		lblNewLabel_1.setBounds(15, -29, 1810, 850);
		contentPane.add(lblNewLabel_1);
	}
}
