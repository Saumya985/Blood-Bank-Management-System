import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JTable;
import java.sql.*;
import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class searchDonorLocation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldAddress;
	private JTable tableDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchDonorLocation frame = new searchDonorLocation();
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
	public searchDonorLocation() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 130, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("search blood donor (address)");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 36));
		lblNewLabel.setBounds(53, 10, 619, 48);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 68, 680, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabelAddress = new JLabel("Address");
		lblNewLabelAddress.setIcon(new ImageIcon(searchDonorLocation.class.getResource("/Images/Location.png")));
		lblNewLabelAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabelAddress.setBounds(138, 80, 123, 30);
		contentPane.add(lblNewLabelAddress);
		
		textFieldAddress = new JTextField();
		textFieldAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String location= textFieldAddress.getText();
				try {
					Connection con= ConnectionProvider.getCon();
					Statement st= con.createStatement();
					ResultSet rs= st.executeQuery("SELECT * FROM donor WHERE city LIKE '%"+location+"%' OR address LIKE '%"+location+"%'");
					tableDetails.setAutoResizeMode(tableDetails.AUTO_RESIZE_OFF);
					tableDetails.setModel(DbUtils.resultSetToTableModel(rs));
					
					tableDetails.getColumnModel().getColumn(0).setPreferredWidth(50);
					tableDetails.getColumnModel().getColumn(1).setPreferredWidth(150);
					tableDetails.getColumnModel().getColumn(2).setPreferredWidth(150);
					tableDetails.getColumnModel().getColumn(3).setPreferredWidth(150);
					tableDetails.getColumnModel().getColumn(4).setPreferredWidth(100);
					tableDetails.getColumnModel().getColumn(5).setPreferredWidth(100);
					tableDetails.getColumnModel().getColumn(6).setPreferredWidth(100);
					tableDetails.getColumnModel().getColumn(7).setPreferredWidth(200);
					tableDetails.getColumnModel().getColumn(8).setPreferredWidth(100);
					tableDetails.getColumnModel().getColumn(9).setPreferredWidth(100);
					tableDetails.getColumnModel().getColumn(10).setPreferredWidth(300);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		textFieldAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(341, 80, 250, 30);
		contentPane.add(textFieldAddress);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 121, 680, 2);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		tableDetails = new JTable();
		
		scrollPane.setViewportView(tableDetails);
		tableDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableDetails.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		
		scrollPane.setBounds(20, 129, 656, 295);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 434, 666, 2);
		contentPane.add(separator_1_1);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setIcon(new ImageIcon(searchDonorLocation.class.getResource("/Images/print.png")));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tableDetails.print(JTable.PrintMode.NORMAL);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPrint.setBounds(63, 446, 96, 29);
		contentPane.add(btnPrint);
		
		JButton btnClose = new JButton("Close");
		btnClose.setIcon(new ImageIcon(searchDonorLocation.class.getResource("/Images/Exit application.png")));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(516, 446, 96, 29);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 77, 77));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(0, 0, 700, 500);
		contentPane.add(lblNewLabel_1);
	}
}
