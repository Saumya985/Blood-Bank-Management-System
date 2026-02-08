import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;

public class home extends JFrame {
	private JPanel contentPanel;  // for switching panels
	private CardLayout cardLayout; //

	private static final long serialVersionUID = 1L;
	private JTable tableDetails;
	private JLabel lblNewLabelEdit;
	private JTextField textField;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 * JFrame = Main window of your application (with menu bar, window controls, etc.)
	 * JPanel = Used inside the JFrame to hold individual pages or views (like forms, tables, etc.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					Connection con= ConnectionProvider.getCon();
					Statement st= con.createStatement();
					ResultSet rs= st.executeQuery("SELECT * FROM donor");
					tableDetails.setAutoResizeMode(tableDetails.AUTO_RESIZE_OFF);
					//tableDetails.setModel(DbUtils.resultSetToTableModel(rs));
					model.setRowCount(0);
					while(rs.next()) {
						String id= rs.getString("donorID");
						String name = rs.getString("name");
						String fatherName = rs.getString("father_name");
						String motherName = rs.getString("mother_name");
						String dob = rs.getString("dob");
						Long mobileNo= rs.getLong("mobileNo");
						String gender = rs.getString("gender");
						String email= rs.getString("email");
						String bloodGroup = rs.getString("blood_group");
				        String city = rs.getString("city");
				        String address = rs.getString("address");

				        Object[] row = {id, name, fatherName, motherName, dob, mobileNo, gender, email, bloodGroup, city, address};
				        model.addRow(row);
					}
					
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
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1568, 968);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Donor");
		mnNewMenu.setIcon(new ImageIcon(home.class.getResource("/Images/Donor.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add New");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addNewDonor().setVisible(true);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(home.class.getResource("/Images/Add new.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("Stock");
		mnNewMenu_2.setIcon(new ImageIcon(home.class.getResource("/Images/stock.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Details");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new stockDetails().setVisible(true);
			}
		});
		mntmNewMenuItem_7.setIcon(new ImageIcon(home.class.getResource("/Images/Details.png")));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_4 = new JMenu("Exit");
		mnNewMenu_4.setIcon(new ImageIcon(home.class.getResource("/Images/exit.png")));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Logout");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a= JOptionPane.showConfirmDialog(null, "Do you really want to Logout","Select", JOptionPane.YES_NO_OPTION);
				if(a==0) {
					setVisible(false);
					new login().setVisible(true);
				}
			}
		});
		mntmNewMenuItem_9.setIcon(new ImageIcon(home.class.getResource("/Images/Logout.png")));
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Exit Application");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a= JOptionPane.showConfirmDialog(null, "Do you really want to Close","Select", JOptionPane.YES_NO_OPTION);
				if(a==0) {
					System.exit(0);
				}
			}
		});
		
		JSeparator separator_8 = new JSeparator();
		mnNewMenu_4.add(separator_8);
		mntmNewMenuItem_10.setIcon(new ImageIcon(home.class.getResource("/Images/Exit application.png")));
		mnNewMenu_4.add(mntmNewMenuItem_10);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Donor's List");
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD, 36));
		lblNewLabel.setBounds(124, 10, 269, 48);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		scrollPane.setBounds(10, 92, 1514, 704);
		getContentPane().add(scrollPane);
		
		tableDetails = new JTable();
		tableDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		String [] columnNames=  {"ID", "Name", "Father's Name", "Mother's Name", "BirthDate", 
				"Mobile No", "Gender", "Email", "Blood Group", "City", "Address"};
				model= new DefaultTableModel(columnNames, 0);
				tableDetails.setModel(model);
				tableDetails.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
		scrollPane.setViewportView(tableDetails);

		JLabel lblNewLabel_2_1;
		lblNewLabelEdit = new JLabel("");
		lblNewLabelEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow= tableDetails.getSelectedRow();
				if(selectedRow != -1) {
					int donorId= (int) tableDetails.getValueAt(selectedRow, 0);
					new EditDonor(donorId).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Please select a donorId");
				}
			}
		});
		lblNewLabelEdit.setIcon(new ImageIcon(home.class.getResource("/Images/edit-icon.png")));
		lblNewLabelEdit.setBounds(1358, 48, 31, 34);
		getContentPane().add(lblNewLabelEdit);

		JLabel lblNewLabelDelete = new JLabel("");
		lblNewLabelDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow= tableDetails.getSelectedRow();
				if(selectedRow != -1) {
					int donorId= (int) tableDetails.getValueAt(selectedRow, 0);
					int confirm= JOptionPane.showConfirmDialog(null, "Do you really want to delete","Select",JOptionPane.YES_NO_OPTION);
					if(confirm == 0) {
						try {
							Connection con= ConnectionProvider.getCon();
							Statement st= con.createStatement();
							st.executeUpdate("DELETE FROM donor WHERE donorID= '"+donorId+"'");
							JOptionPane.showMessageDialog(null, "Successfully Deleted");
							new home().setVisible(true);
							
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Error deleting donor");
						}
					}
				}
			}
		});
		lblNewLabelDelete.setIcon(new ImageIcon(home.class.getResource("/Images/delete-icon.png")));
		lblNewLabelDelete.setBounds(1405, 48, 31, 34);
		getContentPane().add(lblNewLabelDelete);
		
		JLabel lblNewLabelSearch = new JLabel("");
		lblNewLabelSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabelSearch.setOpaque(true);
		lblNewLabelSearch.setBackground(new Color(230, 230, 230));
		lblNewLabelSearch.setIcon(new ImageIcon(home.class.getResource("/Images/search1.png")));
		lblNewLabelSearch.setBounds(1099, 48, 232, 29);
		getContentPane().add(lblNewLabelSearch);
		
		textField = new JTextField(); //search
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String search= textField.getText();
				try {
					Connection con= ConnectionProvider.getCon();
					Statement st= con.createStatement();
					ResultSet rs= st.executeQuery("SELECT * FROM donor WHERE blood_group LIKE '%"+search+"%' OR name LIKE '%"+search+"%' ");
					
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
					tableDetails.getColumnModel().getColumn(10).setPreferredWidth(350);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		textField.setBounds(1099, 48, 209, 29);
		getContentPane().add(textField);
		textField.setColumns(10);

		
		JButton btnPrint = new JButton("");
		btnPrint.setIcon(new ImageIcon(home.class.getResource("/Images/save.png")));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser= new JFileChooser(); //created a constructor for choosing a file
				fileChooser.setDialogTitle("Save CSV");
				
				int userSelection= fileChooser.showSaveDialog(null); //the file chooser waits for the user to select folder and click Save or Cancel.
				if(userSelection == fileChooser.APPROVE_OPTION) { //If user clicks Save, code proceeds.
					File fileToSave= fileChooser.getSelectedFile();
					try {
						FileWriter fw= new FileWriter(fileToSave +".csv"); //Creates a FileWriter to start writing to that file.
						TableModel model= tableDetails.getModel(); //Grabs the TableModel from your JTable (tableDetails)
						
						for (int i=0; i< model.getColumnCount(); i++) { //writing header
							fw.write(model.getColumnName(i) +",");
						}
						fw.write("\n");
						
						for(int i=0; i<model.getRowCount(); i++) { // writing data values
							for(int j=0; j<model.getColumnCount(); j++) {
								fw.write(model.getValueAt(i, j).toString() +","); //converts it to string
							}
							fw.write("\n");
						}
						fw.flush(); //ensures everything is written to disk
						JOptionPane.showMessageDialog(null, "Data Exported Successfully");
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Error Exporting data: " +ex.getMessage());
					}
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPrint.setBounds(1467, 42, 40, 40);
		getContentPane().add(btnPrint);		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(255, 77, 77));
		lblNewLabel_1.setBounds(0, 0, 1568, 968);
		getContentPane().add(lblNewLabel_1);

		
//		cardLayout= new CardLayout();
//		contentPanel= new JPanel(cardLayout);
//		contentPanel.setBounds(0, 0, 1568, 968);
//		getContentPane().add(contentPanel);
//
//		allDonorDetails allDonorPanel = new allDonorDetails(); //this creates an object of addNewDonor and this must be inside JPanel and not JFrame
//		contentPanel.add(allDonorPanel, "AllDonor"); //"AddDonor" is a unique name (called a card name). It is used to tell CardLayout which panel to show.
		

	}
}
