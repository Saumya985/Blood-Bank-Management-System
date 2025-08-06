import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.sql.*;
import Project.ConnectionProvider;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class EditDonor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldFullName;
	private JTextField textFieldFatherName;
	private JTextField textFieldMotherName;
	private JTextField textFieldDateOfBirth;
	private JTextField textFieldMobileNo;
	private JTextField textFieldGender;
	private JTextField textFieldEmail;
	private JTextField textFieldBloodGroup;
	private JTextField textFieldCity;
	private JTextArea textAreaAddress;
	private static int donorId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditDonor frame = new EditDonor(donorId);
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
	public EditDonor(int donorId) {
		this.donorId= donorId;
		//setTitle(EditDonor);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1568, 968);
		contentPane = new JPanel();
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				//int donorID= donorId;
				try {
					Connection con= ConnectionProvider.getCon();
					Statement st= con.createStatement();
					ResultSet rs= st.executeQuery("Select * from donor where donorID= '"+donorId+"'");
					if(rs.next()) {//At start the pointer is above the first row so bringing it to 1st row. It returns a boolean value(true/false)
						textFieldID.setText(rs.getString(1));
						textFieldFullName.setText(rs.getString(2));
						textFieldFatherName.setText(rs.getString(3));
						textFieldMotherName.setText(rs.getString(4));
						textFieldDateOfBirth.setText(rs.getString(5));
						textFieldMobileNo.setText(rs.getString(6));
						textFieldGender.setText(rs.getString(7));
						textFieldEmail.setText(rs.getString(8));
						textFieldBloodGroup.setText(rs.getString(9));
						textFieldCity.setText(rs.getString(10));
						textAreaAddress.setText(rs.getString(11));
						textFieldID.setEditable(false);
					}else {
						JOptionPane.showMessageDialog(null, "Something went wrong");
					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Donor");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 36));
		lblNewLabel.setBounds(635, 10, 251, 48);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 56, 1455, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabelID = new JLabel("Donor ID");
		lblNewLabelID.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelID.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabelID.setBounds(138, 67, 87, 40);
		contentPane.add(lblNewLabelID);
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldID.setBounds(273, 68, 107, 40);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(50, 123, 1455, 2);
		contentPane.add(separator_1);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFullName.setBounds(162, 166, 120, 40);
		contentPane.add(lblFullName);
		
		textFieldFullName = new JTextField();
		textFieldFullName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldFullName.setColumns(10);
		textFieldFullName.setBounds(383, 168, 300, 40);
		contentPane.add(textFieldFullName);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFatherName.setBounds(162, 250, 120, 40);
		contentPane.add(lblFatherName);
		
		textFieldFatherName = new JTextField();
		textFieldFatherName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldFatherName.setColumns(10);
		textFieldFatherName.setBounds(383, 252, 300, 40);
		contentPane.add(textFieldFatherName);
		
		JLabel lblMotherName = new JLabel("Mother Name");
		lblMotherName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMotherName.setBounds(162, 344, 107, 40);
		contentPane.add(lblMotherName);
		
		textFieldMotherName = new JTextField();
		textFieldMotherName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldMotherName.setColumns(10);
		textFieldMotherName.setBounds(383, 345, 300, 40);
		contentPane.add(textFieldMotherName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDateOfBirth.setBounds(162, 441, 107, 40);
		contentPane.add(lblDateOfBirth);
		
		textFieldDateOfBirth = new JTextField();
		textFieldDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDateOfBirth.setColumns(10);
		textFieldDateOfBirth.setBounds(383, 442, 300, 40);
		contentPane.add(textFieldDateOfBirth);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMobileNo.setBounds(162, 540, 107, 40);
		contentPane.add(lblMobileNo);
		
		textFieldMobileNo = new JTextField();
		textFieldMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldMobileNo.setColumns(10);
		textFieldMobileNo.setBounds(383, 541, 300, 40);
		contentPane.add(textFieldMobileNo);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGender.setBounds(162, 638, 107, 40);
		contentPane.add(lblGender);
		
		textFieldGender = new JTextField();
		textFieldGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldGender.setColumns(10);
		textFieldGender.setBounds(383, 639, 300, 40);
		contentPane.add(textFieldGender);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(862, 166, 100, 40);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(1088, 168, 300, 40);
		contentPane.add(textFieldEmail);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBloodGroup.setBounds(862, 283, 100, 40);
		contentPane.add(lblBloodGroup);
		
		textFieldBloodGroup = new JTextField();
		textFieldBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldBloodGroup.setColumns(10);
		textFieldBloodGroup.setBounds(1088, 284, 300, 40);
		contentPane.add(textFieldBloodGroup);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCity.setBounds(862, 400, 100, 40);
		contentPane.add(lblCity);
		
		textFieldCity = new JTextField();
		textFieldCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(1088, 402, 300, 40);
		contentPane.add(textFieldCity);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(862, 521, 100, 40);
		contentPane.add(lblAddress);
		
		textAreaAddress = new JTextArea();
		textAreaAddress.setFont(new Font("Monospaced", Font.BOLD, 14));
		textAreaAddress.setBounds(1088, 521, 300, 157);
		contentPane.add(textAreaAddress);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(50, 716, 1455, 2);
		contentPane.add(separator_2);
		
		JButton btnNewButtonUpdate = new JButton("Save");
		btnNewButtonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String donorId= textFieldID.getText();
				String name= textFieldFullName.getText();
				String father_name= textFieldFatherName.getText();
				String mother_name= textFieldMotherName.getText();
				String dob= textFieldDateOfBirth.getText();
				String mobileNo= textFieldMobileNo.getText();
				String gender= textFieldGender.getText();
				String email= textFieldEmail.getText();
				String blood_group= textFieldBloodGroup.getText();
				String city= textFieldCity.getText();
				String address= textAreaAddress.getText();
				
				try {
					Connection con= ConnectionProvider.getCon();
					Statement st= con.createStatement();
					st.executeUpdate("UPDATE donor SET name='"+name+"',father_name= '"+father_name+"',mother_name= '"+mother_name+"',dob= '"+dob+"',mobileNo= '"+mobileNo+"',gender= '"+gender+"',email= '"+email+"',blood_group= '"+blood_group+"',city= '"+city+"',address= '"+address+"' WHERE donorID='"+donorId+"'");
					JOptionPane.showMessageDialog(null, "Updated Successfully!!");
					setVisible(false);
					new home().setVisible(true);
					//new updateDetailsDonor().setVisible(true);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Oops!!...Something Went Wrong");
				}
			}
		});
		btnNewButtonUpdate.setIcon(new ImageIcon(EditDonor.class.getResource("/Images/save.png")));
		btnNewButtonUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButtonUpdate.setBounds(357, 764, 100, 30);
		contentPane.add(btnNewButtonUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnReset.setIcon(new ImageIcon(EditDonor.class.getResource("/Images/Update details.png")));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(744, 764, 100, 30);
		contentPane.add(btnReset);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setIcon(new ImageIcon(EditDonor.class.getResource("/Images/Exit application.png")));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(1098, 764, 100, 30);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 77, 77));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(0, 0, 1558, 987);
		contentPane.add(lblNewLabel_1);
	}
	
	private void clearForm() {
		textFieldFullName.setText("");
		textFieldFatherName.setText("");
		textFieldMotherName.setText("");
		textFieldDateOfBirth.setText("");
		textFieldMobileNo.setText("");
		textFieldGender.setText("");
		textFieldEmail.setText("");
		textFieldBloodGroup.setText("");
		textFieldCity.setText("");
		textAreaAddress.setText("");
    }
}
