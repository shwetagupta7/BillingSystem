package modules;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class Sales extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtYyyymmdd;
	private JTextField txtYyyymmdd_1;

	

	/**
	 * Create the frame.
	 */
	public Sales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 492);
		getContentPane().setLayout(new BorderLayout());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 829, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSales = new JLabel("SALES");
		lblSales.setForeground(Color.WHITE);
		lblSales.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblSales.setBounds(25, 52, 190, 36);
		panel.add(lblSales);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 421, 829, 28);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPoweredByCodeace = new JLabel("Powered by CodeAce");
		lblPoweredByCodeace.setForeground(Color.WHITE);
		lblPoweredByCodeace.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPoweredByCodeace.setBounds(544, 0, 236, 25);
		panel_1.add(lblPoweredByCodeace);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 204, 153));
		panel_2.setBounds(-10, 112, 823, 306);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search By : ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(33, 23, 121, 17);
		panel_2.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 90, 474, 154);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEnabled(true);
		table.setColumnSelectionAllowed(false);
		table.setFocusable(false);
		table.setRowSelectionAllowed(true);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"P_ID", "Price", "Qty", "Total"
				}
			));

		
		final JRadioButton rdbtnProductbarcodeId = new JRadioButton("Product/Barcode ID");
		
		rdbtnProductbarcodeId.setBounds(183, 21, 157, 23);
		panel_2.add(rdbtnProductbarcodeId);
		
		final JRadioButton rdbtnCustomerId = new JRadioButton("Customer ID");
		
		rdbtnCustomerId.setBounds(363, 21, 129, 23);
		panel_2.add(rdbtnCustomerId);
		
		final JRadioButton rdbtnTime = new JRadioButton("Time");
		
		rdbtnTime.setBounds(522, 21, 145, 23);
		panel_2.add(rdbtnTime);
		
		ButtonGroup grp=new ButtonGroup();
		grp.add(rdbtnProductbarcodeId);
		grp.add(rdbtnTime);
		grp.add(rdbtnCustomerId);
		JLabel lblTotalSales = new JLabel("Total Sales");
		lblTotalSales.setBounds(96, 255, 100, 27);
		panel_2.add(lblTotalSales);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(206, 258, 150, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Mainframe().setVisible(true);
			}
		});
		btnBack.setBounds(679, 257, 89, 23);
		panel_2.add(btnBack);
		
		textField_1 = new JTextField();
		textField_1.setVisible(false);
		textField_1.setBounds(187, 59, 86, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Sales().setVisible(true);
			}
		});
		btnReset.setBounds(679, 221, 89, 23);
		panel_2.add(btnReset);
		
		// Connection code starts here
		 Properties props = new Properties();
		//   FileInputStream in = null;
		/*try {
			in = new FileInputStream("src/db_connect.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
	        JOptionPane.showMessageDialog(null, e.getMessage());
		}
		  */ try {
			props.load(ViewOrder.class.getResourceAsStream("/db_connect.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
	        JOptionPane.showMessageDialog(null, e.getMessage());
		}
		   String driver = props.getProperty("driver");
		   if (driver != null) {
		       try {
				Class.forName(driver) ;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
		        JOptionPane.showMessageDialog(null, e.getMessage());
			}
		   }

		   final String url = props.getProperty("url");
		   final String username = props.getProperty("username");
		   final String password = props.getProperty("password");
		   
		   /// connection code ends here
		
		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				m.setRowCount(0);
				if(rdbtnCustomerId.isSelected()){
					int c_id=Integer.parseInt(textField_1.getText());
					if(!textField_1.getText().equals("")){
					double total=0;
					try {
						Connection con = DriverManager.getConnection(url, username, password);
						Statement S=con.createStatement();
				        String q="select o_id,amt from orders where c_id="+c_id;
				        ResultSet r= S.executeQuery(q);
			            if(!r.isBeforeFirst()){
			            	 JOptionPane.showMessageDialog(null,"No Record Found ");
			            }
			            else{
			            while(r.next()){
			            	total+=r.getDouble("amt");
			            	addtotab(r.getInt("o_id"));
			            }
			            textField.setText(""+total);
			            }
			            
			            S.close();
			            con.close();
					} catch (SQLException s) {
						// TODO Auto-generated catch block
				        JOptionPane.showMessageDialog(null, s.getMessage());
					}
					}
					else{
						JOptionPane.showMessageDialog(null, "Enter Customer ID..");
					}
					
				}
				else if(rdbtnProductbarcodeId.isSelected()){
					
					if(!textField_1.getText().equals("")){
					int p_id=Integer.parseInt(textField_1.getText());
					double total=0;
					try {
						Connection con = DriverManager.getConnection(url, username, password);
						Statement S=con.createStatement();
				        String q="select qty,t_price from order_details where p_id="+p_id;
				        ResultSet r= S.executeQuery(q);
			            if(!r.isBeforeFirst()){
			            	 JOptionPane.showMessageDialog(null,"No Record Found ");
			            }
			            else{
			            	
							 m=(DefaultTableModel)table.getModel();
			            while(r.next()){
			            	total+=r.getDouble("t_price");
			            	Object[] row={p_id,r.getDouble("t_price")/r.getInt("qty"),r.getInt("qty"),r.getDouble("t_price")};
			            	m.addRow(row);
			            	
			            }
			            textField.setText(""+total);
			            }
			            
			            S.close();
			            con.close();
					} catch (SQLException s) {
						// TODO Auto-generated catch block
				        JOptionPane.showMessageDialog(null, s.getMessage());
					}
				}
					else{
						JOptionPane.showMessageDialog(null, "Enter Product ID..");
					}
				}
				else if(rdbtnTime.isSelected()){
					
					
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					
					java.util.Date jdate=null;
					java.sql.Date sdate=null;
					java.sql.Date edate=null;
					try {
						jdate=(java.util.Date)df.parse(txtYyyymmdd.getText());
						if(jdate!=null){
						sdate = new Date(jdate.getTime());
						jdate=(java.util.Date)df.parse(txtYyyymmdd_1.getText());
						if(jdate!=null){
						edate = new Date(jdate.getTime());
						double total=0.0;
						try {
							Connection con = DriverManager.getConnection(url, username, password);
							Statement S=con.createStatement();
					        String q="select o_id,amt from orders where o_date<='"+edate+"' and o_date>='"+sdate+"'";
					        ResultSet r= S.executeQuery(q);
				            if(!r.isBeforeFirst()){
				            	 JOptionPane.showMessageDialog(null,"No Record Found ");
				            }
				            else{
				            while(r.next()){
				            	total+=r.getDouble("amt");
				            	addtotab(r.getInt("o_id"));
				            }
				            textField.setText(""+total);
				            }
				            
				            S.close();
				            con.close();
						} catch (SQLException s) {
							// TODO Auto-generated catch block
					        JOptionPane.showMessageDialog(null, s.getMessage());
						}
						}}

					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Invalid Format");
					}
					
					
				}
			}

			private void addtotab(int o_id) {
				// TODO Auto-generated method stub
				
				
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				
				try {
					Connection con = DriverManager.getConnection(url, username, password);
					Statement S=con.createStatement();
			        String q="select p_id,qty,t_price from order_details where o_id="+o_id;
			        ResultSet r= S.executeQuery(q);
		            if(!r.isBeforeFirst()){
		            	 JOptionPane.showMessageDialog(null,"Not Found ");
		            }
		            else{
		            while(r.next()){
		            	int p_id=r.getInt("p_id");
		            	int qty=r.getInt("qty");
		            	double price=r.getDouble("t_price");
		            
		            	Object[] row={p_id,price/qty,qty,price};
		            	m.addRow(row);
		            }
		            }
		            
		            S.close();
		            con.close();
				} catch (SQLException s) {
					// TODO Auto-generated catch block
			        JOptionPane.showMessageDialog(null, s.getMessage());
				}
				
			}
		});
		btnGo.setBounds(679, 187, 89, 23);
		panel_2.add(btnGo);
		
		txtYyyymmdd = new JTextField();
		txtYyyymmdd.setVisible(false);
		txtYyyymmdd.setText("yyyy-mm-dd");
		txtYyyymmdd.setBounds(480, 59, 100, 20);
		panel_2.add(txtYyyymmdd);
		txtYyyymmdd.setColumns(10);
		
		final JLabel lblEnterDateIn = new JLabel("Enter date in specified format");
		lblEnterDateIn.setVisible(false);
		lblEnterDateIn.setBounds(309, 65, 183, 14);
		panel_2.add(lblEnterDateIn);
		
		txtYyyymmdd_1 = new JTextField();
		txtYyyymmdd_1.setVisible(false);
		txtYyyymmdd_1.setText("yyyy-mm-dd");
		txtYyyymmdd_1.setBounds(640, 59, 86, 20);
		panel_2.add(txtYyyymmdd_1);
		txtYyyymmdd_1.setColumns(10);
		
		final JLabel lblTo = new JLabel("To");
		lblTo.setVisible(false);
		lblTo.setBounds(597, 62, 46, 14);
		panel_2.add(lblTo);
		
		
		rdbtnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtYyyymmdd.setVisible(true);
				txtYyyymmdd_1.setVisible(true);
				lblEnterDateIn.setVisible(true);
				lblTo.setVisible(true);
				textField_1.setVisible(false);
			}
		});
		
		
		
		rdbtnProductbarcodeId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtYyyymmdd.setVisible(false);
				txtYyyymmdd_1.setVisible(false);
				lblEnterDateIn.setVisible(false);
				lblTo.setVisible(false);
				textField_1.setVisible(true);
			}
		});
		
		
		rdbtnCustomerId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtYyyymmdd.setVisible(false);
				txtYyyymmdd_1.setVisible(false);
				lblEnterDateIn.setVisible(false);
				lblTo.setVisible(false);
				textField_1.setVisible(true);
			}
		});
		
	}
}
