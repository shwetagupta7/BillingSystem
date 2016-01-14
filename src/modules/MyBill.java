package modules;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyBill extends JFrame {

	private JPanel contentPane;

	int o_id,c_id;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	private int flag;

	/**
	 * Create the frame.
	 */
	public MyBill() {
		
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
		panel.setBounds(0, 0, 829, 90);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPlaceYourOrder = new JLabel("INVOICE");
		lblPlaceYourOrder.setForeground(Color.WHITE);
		lblPlaceYourOrder.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblPlaceYourOrder.setBounds(10, 30, 312, 35);
		panel.add(lblPlaceYourOrder);
		

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
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 93, 823, 328);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCustomer = new JLabel("To");
		lblCustomer.setBounds(10, 67, 89, 26);
		panel_2.add(lblCustomer);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 104, 244, 51);
		panel_2.add(scrollPane_1);
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane_1.setViewportView(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 166, 304, 133);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setColumnSelectionAllowed(false);
		//table.setFocusable(false);
		table.setRowSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product", "Price", "Qty", "Total"
			}
		));
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPrint.setBounds(687, 121, 109, 23);
		panel_2.add(btnPrint);
		
		JButton btnNewOrder = new JButton("New Order");
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new newOrder().setVisible(true);
			}
		});
		btnNewOrder.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewOrder.setBounds(687, 69, 109, 23);
		panel_2.add(btnNewOrder);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Mainframe().setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(687, 180, 109, 23);
		panel_2.add(btnBack);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(452, 33, 86, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(383, 36, 46, 14);
		panel_2.add(lblTotal);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setBounds(383, 73, 46, 14);
		panel_2.add(lblTax);
		
		JLabel lblNetTotal = new JLabel("Net Total");
		lblNetTotal.setBounds(351, 109, 78, 14);
		panel_2.add(lblNetTotal);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(452, 70, 86, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(452, 106, 86, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		
		comboBox.setBounds(452, 160, 86, 20);
		panel_2.add(comboBox);
		
		final JLabel lblModeOfPayment = new JLabel("Mode of Payment");
		lblModeOfPayment.setBounds(351, 163, 91, 20);
		panel_2.add(lblModeOfPayment);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 11, 193, 56);
		panel_2.add(textArea_1);
		
		final JLabel lblAmountReceived = new JLabel("Amount Received");
		lblAmountReceived.setBounds(351, 206, 91, 14);
		panel_2.add(lblAmountReceived);
		
		textField_3 = new JTextField();
		textField_3.setBounds(452, 203, 86, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(452, 245, 86, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		final JLabel lblBalance = new JLabel("Balance");
		lblBalance.setBounds(351, 248, 46, 14);
		panel_2.add(lblBalance);
		
		final JButton btnNewButton = new JButton("Save");
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(687, 32, 109, 23);
		panel_2.add(btnNewButton);
		
		final JLabel lblPaymentId = new JLabel("Payment ID");
		lblPaymentId.setVisible(false);
		lblPaymentId.setBounds(324, 223, 83, 14);
		panel_2.add(lblPaymentId);
		
		textField_5 = new JTextField();
		textField_5.setVisible(false);
		textField_5.setBounds(452, 220, 86, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
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
		   
		   addWindowListener(new WindowAdapter() {
				@Override
				public void windowOpened(WindowEvent arg0) {
					double tax=0.0;
					try {
						comboBox.addItem("Cash");
						comboBox.addItem("card");
						Connection con = DriverManager.getConnection(url, username, password);
						Statement S=con.createStatement();
				        String q="select cname,owner,tax from settings ";
				        String sql="select * from customers where c_id="+c_id;
				        String sql1="select o.o_id,od.p_id,od.qty,od.t_price,o.amt,o.o_date,o.o_time from orders o,order_details od where o.o_id=od.o_id and o.o_id="+o_id;
				        
				        ///Company Details
				        ResultSet r= S.executeQuery(q);
			            if(!r.isBeforeFirst()){
			            	 JOptionPane.showMessageDialog(null,"Error ");
			            }
			            else{
			            r.next();
			            textArea_1.setText(r.getString("owner")+"\n"+r.getString("cname"));
			            tax=r.getDouble("tax");
			            textField_1.setText(""+r.getDouble("tax"));
			            }
			            
			            
			            
			            ///Customer Details
			            r= S.executeQuery(sql);
			            if(!r.isBeforeFirst()){
			            	 JOptionPane.showMessageDialog(null,"Error ");
			            }
			            else{
			            r.next();
			            textArea.setText(r.getString("c_name")+"\n"+r.getString("email")+"\n"+r.getLong("contact"));
			            }
			            
			            
			            ///Fill Table
			            r= S.executeQuery(sql1);
			            if(!r.isBeforeFirst()){
			            	 JOptionPane.showMessageDialog(null,"Error ");
			            }
			            else{

							DefaultTableModel m=(DefaultTableModel)table.getModel();
							r.next();
							textField.setText(""+r.getDouble("amt"));
							double tot=r.getDouble("amt")*(100+tax)/100;
							textField_2.setText(""+tot);
							
			            do{
			            	int p_id=r.getInt("p_id");
			            	Double price=r.getDouble("t_price");
			            	int qty=r.getInt("qty");
			            	price/=qty;
			            	try{
			            		Connection con1 = DriverManager.getConnection(url, username, password);
								Statement S1=con.createStatement();
			            	sql="select p_name from products where p_id="+p_id;
			            	ResultSet res=S1.executeQuery(sql);
			            	res.next();
			            	String p_name=res.getString("p_name");
			            	
			            	Object[] row={p_name,price,qty,price*qty};
							m.addRow(row);
							 S1.close();
					            con1.close();
							}
			            	catch(SQLException sq){
			            		sq.printStackTrace();
			            	}
			            }while(r.next());
			            }
			            S.close();
			            con.close();
					} catch (SQLException s) {
						// TODO Auto-generated catch block
						s.printStackTrace();
				        JOptionPane.showMessageDialog(null, s.getMessage());
					}
					if(flag==0){
						textField_3.setVisible(false);
						textField_4.setVisible(false);
						lblAmountReceived.setVisible(false);
						lblBalance.setVisible(false);
						lblPaymentId.setVisible(false);
						textField_5.setVisible(false);
						btnNewButton.setVisible(false);
						lblModeOfPayment.setVisible(false);
						comboBox.setVisible(false);
					}
					
				}
			});
		   
		   
		   
		   //ComboBOX
		   
		   comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(comboBox.getSelectedItem().equals("Cash")){
						textField_3.setVisible(true);
						textField_4.setVisible(true);
						lblAmountReceived.setVisible(true);
						lblBalance.setVisible(true);
						lblPaymentId.setVisible(false);
						textField_5.setVisible(false);
						
					}
					else{
						textField_3.setVisible(false);
						textField_4.setVisible(false);
						lblAmountReceived.setVisible(false);
						lblBalance.setVisible(false);
						lblPaymentId.setVisible(true);
						textField_5.setVisible(true);
					}
				}
			});
		   
		   
		   btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comboBox.getSelectedItem().equals("Cash")){
						textField_4.setText(""+(Double.parseDouble(textField_3.getText())-Double.parseDouble(textField_2.getText())));
					}
					else{
						String pay_id=textField_5.getText();
						if(flag==1){
						try {
							Connection con = DriverManager.getConnection(url, username, password);
							Statement S=con.createStatement();
					        String q="update orders set pay_id='"+pay_id+"' where o_id="+o_id;
					        int x= S.executeUpdate(q);
					        if(x==1)
					            JOptionPane.showMessageDialog(null, "Saved");
					        else             JOptionPane.showMessageDialog(null, "Error! Record not Saved");
					        S.close();
					        con.close();

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
					        JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}
					}
				}
			});

	}

	public void setOrder(int o_id) {
		// TODO Auto-generated method stub
		this.o_id=o_id;
	}

	public void setCust(int c_id) {
		// TODO Auto-generated method stub
		this.c_id=c_id;
	}
	
	public void setFlag(int flag) {
		// TODO Auto-generated method stub
		this.flag=flag;
	}
}
