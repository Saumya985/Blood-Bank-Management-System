import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JTable;
import java.sql.*;
import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

public class stockDetails extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JComboBox comboBoxBlood;
	private JComboBox comboBoxIncDec;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stockDetails frame = new stockDetails();
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
	public stockDetails() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1568, 968);
		contentPane = new JPanel();
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					Connection con= ConnectionProvider.getCon();
					Statement st= con.createStatement();
					ResultSet rs= st.executeQuery("SELECT * FROM stock");
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					model.setRowCount(0);

				    while (rs.next()) {
				        String bloodGroup = rs.getString("blood_group");
				        int unit = rs.getInt("unit");

				        Object[] row = {bloodGroup, unit};
				        model.addRow(row); // Only adds data rows
				    }
					
					table.getColumnModel().getColumn(0).setPreferredWidth(130);
					table.getColumnModel().getColumn(1).setPreferredWidth(130);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Something went wrong");
				}
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStockdetals = new JLabel("stock");
		lblStockdetals.setFont(new Font("Algerian", Font.BOLD, 36));
		lblStockdetals.setBounds(705, 22, 153, 48);
		contentPane.add(lblStockdetals);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 68, 1455, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		scrollPane.setBounds(90, 153, 1353, 553);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		String[] columnNames = {"Blood Group", "Units Of Blood"};
		model = new DefaultTableModel(columnNames, 0); // 0 rows initially
		table.setModel(model);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		for (int i = 0; i < table.getColumnCount(); i++) {
		    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		scrollPane.setViewportView(table);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(50, 716, 1455, 2);
		contentPane.add(separator_1_1);
		
		JButton btnPrint = new JButton("");
		btnPrint.setIcon(new ImageIcon(stockDetails.class.getResource("/Images/save.png")));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setDialogTitle("Save CSV");

		        int userSelection = fileChooser.showSaveDialog(null);
		        if (userSelection == JFileChooser.APPROVE_OPTION) {
		            File fileToSave = fileChooser.getSelectedFile(); //It will get the folder that we selected

		            try (FileWriter fw = new FileWriter(fileToSave + ".csv")) { //It wil start writing in that folder and add .csv extension
		                // Get model from your JTable
		                TableModel model = table.getModel();

		                // Write column headers
		                for (int i = 0; i < model.getColumnCount(); i++) {
		                    fw.write(model.getColumnName(i) + ",");
		                }
		                fw.write("\n");

		                // Write rows
		                for (int i = 0; i < model.getRowCount(); i++) {
		                    for (int j = 0; j < model.getColumnCount(); j++) {
		                        fw.write(model.getValueAt(i, j).toString() + ",");
		                    }
		                    fw.write("\n");
		                }

		                fw.flush(); //Ensures everything is written to disk
		                JOptionPane.showMessageDialog(null, "Data exported successfully!");
		            } catch (Exception ex) {
		                JOptionPane.showMessageDialog(null, "Error exporting data: " + ex.getMessage());
		            }
		        }

			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPrint.setBounds(1390, 80, 62, 43);
		contentPane.add(btnPrint);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setIcon(new ImageIcon(stockDetails.class.getResource("/Images/Exit application.png")));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(693, 768, 107, 40);
		contentPane.add(btnClose);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(50, 133, 1455, 2);
		contentPane.add(separator_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bloodGroup= (String) comboBoxBlood.getSelectedItem();
				String operation= (String) comboBoxIncDec.getSelectedItem();
				String unit= textField.getText();
				int unit1= Integer.parseInt(unit);
				try {
					Connection con= ConnectionProvider.getCon();
					Statement st= con.createStatement();
					if(operation == "Increase") {
						st.executeUpdate("UPDATE stock SET unit= unit+ '"+unit1+"' WHERE blood_group= '"+bloodGroup+"' ");
						setVisible(false);
						new stockDetails().setVisible(true);
					}else {
						st.executeUpdate("UPDATE stock SET unit= unit- '"+unit1+"' WHERE blood_group= '"+bloodGroup+"' ");
						setVisible(false);
						new stockDetails().setVisible(true);
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Something went wrong...Can't update");
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(921, 78, 113, 41);
		contentPane.add(btnUpdate);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBounds(686, 78, 129, 41);
		contentPane.add(textField);
		
		JLabel lblUnits = new JLabel("Units");
		lblUnits.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUnits.setBounds(562, 89, 89, 30);
		contentPane.add(lblUnits);
		
		comboBoxBlood = new JComboBox();
		comboBoxBlood.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		comboBoxBlood.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBoxBlood.setBounds(230, 78, 67, 40);
		contentPane.add(comboBoxBlood);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBloodGroup.setBounds(84, 83, 113, 30);
		contentPane.add(lblBloodGroup);
		
		comboBoxIncDec = new JComboBox();
		comboBoxIncDec.setModel(new DefaultComboBoxModel(new String[] {"Increase", "Decrease"}));
		comboBoxIncDec.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBoxIncDec.setBounds(378, 80, 129, 40);
		contentPane.add(comboBoxIncDec);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 77, 77));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(0, 0, 1568, 968);
		contentPane.add(lblNewLabel_1);
	}
}
