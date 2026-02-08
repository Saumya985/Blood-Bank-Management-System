import java.awt.EventQueue;
import java.sql.*; 
import java.text.SimpleDateFormat; 
import Project.ConnectionProvider; 

import javax.swing.*; 
import javax.swing.border.EmptyBorder; 
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font; 
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;

import com.toedter.calendar.JDateChooser;

public class addNewDonor extends JFrame { 

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_2_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_2;
	private JDateChooser dateChooser;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//EventQueue.invokeLater(() -> {
				try {
					addNewDonor frame = new addNewDonor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	//	});
	}

	/**
	 * Create the frame.
	 */
	public addNewDonor() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1568, 968);
		contentPane = new JPanel(); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Add New Donor");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 36));
		lblNewLabel.setBounds(598, 31, 400, 48); 
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 78, 1455, 4);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("New Donor ID");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setBounds(102, 105, 120, 40);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2.setBounds(244, 105, 120, 40);
		contentPane.add(lblNewLabel_2); 
		
		JLabel lblNewLabel_3 = new JLabel("Full Name");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3.setBounds(162, 166, 120, 40);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Father's Name");
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(162, 250, 120, 40);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Mother's Name");
		lblNewLabel_3_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(162, 343, 120, 40);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Date Of Birth");
		lblNewLabel_3_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3_3.setBounds(162, 442, 120, 40);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Mobile No.");
		lblNewLabel_3_4.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3_4.setBounds(162, 539, 120, 40);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Gender");
		lblNewLabel_3_5.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3_5.setBounds(162, 638, 120, 40);
		contentPane.add(lblNewLabel_3_5);
		
		textField = new JTextField(); //Full name
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(383, 168, 300, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(); //father
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(383, 252, 300, 40);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField(); //mother
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(383, 345, 300, 40);
		contentPane.add(textField_2);
		
		textField_2_1 = new JTextField(); //mobile
		textField_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2_1.setColumns(10);
		textField_2_1.setBounds(383, 541, 300, 40);
		contentPane.add(textField_2_1);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female ", "Others"}));
		comboBox.setBounds(383, 639, 300, 40);
		contentPane.add(comboBox);
		
		dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Tahoma", Font.BOLD, 14));
		dateChooser.setBounds(383, 442, 300, 40);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_3_6 = new JLabel("Email");
		lblNewLabel_3_6.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3_6.setBounds(862, 166, 100, 40);
		contentPane.add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_7 = new JLabel("Blood Group");
		lblNewLabel_3_7.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3_7.setBounds(862, 283, 150, 40);
		contentPane.add(lblNewLabel_3_7);
		
		JLabel lblNewLabel_3_8 = new JLabel("City");
		lblNewLabel_3_8.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3_8.setBounds(862, 400, 120, 40);
		contentPane.add(lblNewLabel_3_8);
		
		JLabel lblNewLabel_3_9 = new JLabel("Address");
		lblNewLabel_3_9.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3_9.setBounds(862, 521, 120, 40);
		contentPane.add(lblNewLabel_3_9);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(1088, 168, 300, 40);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(1088, 402, 300, 40);
		contentPane.add(textField_4);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 14));
		textArea.setBounds(1088, 521, 300, 157);
		contentPane.add(textArea);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_1.setBounds(1088, 284, 300, 40);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String donorID= lblNewLabel_2.getText();
				String name= textField.getText();
				String father_name= textField_1.getText();
				String mother_name= textField_2.getText();
				java.util.Date dobDate= dateChooser.getDate();
				String mobileNo= textField_2_1.getText();
				String gender= (String)comboBox.getSelectedItem();
				String email= textField_3.getText();
				String blood_group= (String)comboBox_1.getSelectedItem();
				String city= textField_4.getText();
				String address= textArea.getText();
				
				if (name.isEmpty() || father_name.isEmpty() || mobileNo.isEmpty() || dobDate == null) {
                    JOptionPane.showMessageDialog(null, "Please fill all required fields.");
                    return;
                }

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                String dob = df.format(dobDate);
				
				try {
					Connection con= ConnectionProvider.getCon();
					String query = "INSERT INTO donor VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, donorID);
                    ps.setString(2, name);
                    ps.setString(3, father_name);
                    ps.setString(4, mother_name);
                    ps.setString(5, dob);
                    ps.setString(6, mobileNo);
                    ps.setString(7, gender);
                    ps.setString(8, email);
                    ps.setString(9, blood_group);
                    ps.setString(10, city);
                    ps.setString(11, address);

                    ps.executeUpdate();
                    
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					clearForm();
					loadNextDonorID();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(addNewDonor.class.getResource("/Images/save.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(357, 764, 100, 30);
		contentPane.add(btnNewButton);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(50, 716, 1455, 2);
		contentPane.add(separator_2);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});

		btnReset.setHorizontalAlignment(SwingConstants.LEFT);
		btnReset.setIcon(new ImageIcon(addNewDonor.class.getResource("/Images/Update details.png")));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(744, 764, 110, 30);
		contentPane.add(btnReset);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new home().setVisible(true);
			}
		});
		btnClose.setIcon(new ImageIcon(addNewDonor.class.getResource("/Images/Exit application.png")));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(1098, 764, 100, 30);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(255, 77, 77));
		lblNewLabel_4.setBounds(0, 0, 1568, 968);
		contentPane.add(lblNewLabel_4);
		
		loadNextDonorID();
	}


	private void loadNextDonorID(){
		try {
			Connection con= ConnectionProvider.getCon();
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery("Select max(donorID) from donor");
			if(rs.next()) {
				int id= rs.getInt(1) + 1;
				lblNewLabel_2.setText(String.valueOf(id));
			}else {
				lblNewLabel_2.setText("1");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	private void clearForm() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		dateChooser.setDate(null);
		textField_2_1.setText("");
		comboBox.setSelectedIndex(0);
		textField_3.setText("");
		comboBox_1 .setSelectedIndex(0);
		textField_4.setText("");
		textArea .setText("");
    }
}

