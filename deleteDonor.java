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
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.sql.*;
import Project.ConnectionProvider;

public class deleteDonor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDonorId;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteDonor frame = new deleteDonor();
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
	public deleteDonor() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 130, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Donor Details");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 36));
		lblNewLabel.setBounds(128, 10, 433, 48);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 680, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabelID = new JLabel("Donor ID");
		lblNewLabelID.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabelID.setBounds(138, 67, 87, 31);
		contentPane.add(lblNewLabelID);
		
		textFieldDonorId = new JTextField();
		textFieldDonorId.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDonorId.setColumns(10);
		textFieldDonorId.setBounds(273, 68, 107, 30);
		contentPane.add(textFieldDonorId);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String donorId= textFieldDonorId.getText();
				try {
					Connection con= ConnectionProvider.getCon();
					Statement st= con.createStatement();
					ResultSet rs= st.executeQuery("SELECT * FROM donor WHERE donorID= '"+donorId+"'");
					if (rs.next()) {
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
						textFieldDonorId.setEditable(false);
					}else {
						JOptionPane.showMessageDialog(null, "DonorID does not exist");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(430, 68, 118, 30);
		contentPane.add(btnSearch);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 108, 680, 2);
		contentPane.add(separator_1);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFullName.setBounds(38, 120, 87, 31);
		contentPane.add(lblFullName);
		
		textFieldFullName = new JTextField();
		textFieldFullName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldFullName.setColumns(10);
		textFieldFullName.setBounds(170, 120, 146, 30);
		contentPane.add(textFieldFullName);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFatherName.setBounds(38, 161, 107, 31);
		contentPane.add(lblFatherName);
		
		textFieldFatherName = new JTextField();
		textFieldFatherName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldFatherName.setColumns(10);
		textFieldFatherName.setBounds(170, 162, 146, 30);
		contentPane.add(textFieldFatherName);
		
		JLabel lblMotherName = new JLabel("Mother Name");
		lblMotherName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMotherName.setBounds(38, 202, 107, 31);
		contentPane.add(lblMotherName);
		
		textFieldMotherName = new JTextField();
		textFieldMotherName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldMotherName.setColumns(10);
		textFieldMotherName.setBounds(170, 202, 146, 30);
		contentPane.add(textFieldMotherName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOfBirth.setBounds(38, 243, 107, 31);
		contentPane.add(lblDateOfBirth);
		
		textFieldDateOfBirth = new JTextField();
		textFieldDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDateOfBirth.setColumns(10);
		textFieldDateOfBirth.setBounds(170, 244, 146, 30);
		contentPane.add(textFieldDateOfBirth);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobileNo.setBounds(38, 284, 107, 31);
		contentPane.add(lblMobileNo);
		
		textFieldMobileNo = new JTextField();
		textFieldMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldMobileNo.setColumns(10);
		textFieldMobileNo.setBounds(170, 285, 146, 30);
		contentPane.add(textFieldMobileNo);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(38, 325, 107, 31);
		contentPane.add(lblGender);
		
		textFieldGender = new JTextField();
		textFieldGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldGender.setColumns(10);
		textFieldGender.setBounds(170, 325, 146, 30);
		contentPane.add(textFieldGender);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(376, 120, 87, 31);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(508, 120, 146, 30);
		contentPane.add(textFieldEmail);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBloodGroup.setBounds(376, 161, 107, 31);
		contentPane.add(lblBloodGroup);
		
		textFieldBloodGroup = new JTextField();
		textFieldBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldBloodGroup.setColumns(10);
		textFieldBloodGroup.setBounds(508, 162, 146, 30);
		contentPane.add(textFieldBloodGroup);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCity.setBounds(376, 202, 107, 31);
		contentPane.add(lblCity);
		
		textFieldCity = new JTextField();
		textFieldCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(508, 202, 146, 30);
		contentPane.add(textFieldCity);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(376, 243, 107, 31);
		contentPane.add(lblAddress);
		
		textAreaAddress = new JTextArea();
		textAreaAddress.setFont(new Font("Monospaced", Font.BOLD, 14));
		textAreaAddress.setBounds(508, 254, 146, 78);
		contentPane.add(textAreaAddress);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 391, 666, 2);
		contentPane.add(separator_2);
		
		JButton btnReset_1 = new JButton("Delete");
		btnReset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String donorID= textFieldDonorId.getText();
				try {
					Connection con= ConnectionProvider.getCon();
					Statement st= con.createStatement();
					st.executeUpdate("DELETE FROM donor WHERE donorID= '"+donorID+"'"); //'"+donorID+"' it is used to concatinate sql query with java variable
					JOptionPane.showMessageDialog(null, "Successfully Deleted");
					setVisible(false);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnReset_1.setIcon(new ImageIcon(deleteDonor.class.getResource("/Images/delete.png")));
		btnReset_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset_1.setBounds(97, 422, 118, 31);
		contentPane.add(btnReset_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new deleteDonor().setVisible(true);
			}
		});
		btnReset.setIcon(new ImageIcon(deleteDonor.class.getResource("/Images/Update details.png")));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(279, 422, 118, 31);
		contentPane.add(btnReset);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setIcon(new ImageIcon(deleteDonor.class.getResource("/Images/Exit application.png")));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(463, 422, 118, 31);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(255, 77, 77));
		lblNewLabel_1.setBounds(0, 0, 700, 500);
		contentPane.add(lblNewLabel_1);
	}

}
