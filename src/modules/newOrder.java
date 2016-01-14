package modules;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

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
import java.sql.Time;
import java.time.LocalTime;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import javax.swing.ListSelectionModel;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class newOrder extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField txtCustomerName;
	private JTextField textField_10;
	Double st=0.0,t=0.0,dis=0.0;
	int index;

	
	/**
	 * Create the frame.
	 */
	public newOrder() {
		
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
		
		JLabel lblPlaceYourOrder = new JLabel("Place your Order");
		lblPlaceYourOrder.setForeground(Color.WHITE);
		lblPlaceYourOrder.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblPlaceYourOrder.setBounds(10, 30, 312, 35);
		panel.add(lblPlaceYourOrder);
		
		JLabel lblOrderNo = new JLabel("Order No.");
		lblOrderNo.setForeground(Color.WHITE);
		lblOrderNo.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblOrderNo.setBounds(634, 65, 88, 14);
		panel.add(lblOrderNo);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setBounds(732, 62, 86, 20);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		
		
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
		
		final JLabel lblDate = new JLabel("date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDate.setBounds(10, 0, 230, 22);
		panel_1.add(lblDate);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 102, 153));
		panel_2.setBounds(0, 92, 823, 40);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer's Contact :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 122, 14);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(135, 8, 122, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnCheck = new JButton("Check");
		
		btnCheck.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCheck.setForeground(new Color(0, 0, 0));
		btnCheck.setBackground(new Color(255, 255, 255));
		btnCheck.setBounds(267, 9, 88, 18);
		panel_2.add(btnCheck);
		
		txtName = new JTextField();
		txtName.setText("Enter Name");
		txtName.setBounds(461, 8, 99, 20);
		panel_2.add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("Enter Email");
		txtEmail.setBounds(570, 8, 86, 20);
		panel_2.add(txtEmail);
		txtEmail.setColumns(10);
		
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

		JButton btnGo = new JButton("Add Customer");
		
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGo.setBounds(679, 7, 134, 23);
		panel_2.add(btnGo);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setEditable(false);
		txtCustomerName.setText("Customer ID");
		txtCustomerName.setBounds(365, 8, 86, 20);
		panel_2.add(txtCustomerName);
		txtCustomerName.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 204, 153));
		panel_3.setBounds(0, 135, 823, 284);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 22, 86, 17);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 21, 86, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(314, 21, 86, 20);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(424, 21, 75, 20);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(531, 21, 62, 20);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		final JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setBounds(613, 21, 62, 20);
		panel_3.add(comboBox);
		
		JLabel lblBarcodeId = new JLabel("Barcode ID");
		lblBarcodeId.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarcodeId.setBounds(10, 0, 86, 14);
		panel_3.add(lblBarcodeId);
		
		JLabel lblProductid = new JLabel("Product_ID");
		lblProductid.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductid.setBounds(106, 5, 86, 9);
		panel_3.add(lblProductid);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduct.setBounds(331, 0, 46, 14);
		panel_3.add(lblProduct);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(433, 0, 46, 14);
		panel_3.add(lblPrice);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscount.setBounds(521, 0, 46, 14);
		panel_3.add(lblDiscount);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(629, 0, 46, 14);
		panel_3.add(lblQuantity);
		
		JButton btnAdd = new JButton("ADD");
		
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBounds(697, 11, 89, 24);
		panel_3.add(btnAdd);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(220, 220, 220));
		panel_4.setBounds(10, 50, 182, 223);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblSearchByProduct = new JLabel("Search by product name");
		lblSearchByProduct.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSearchByProduct.setHorizontalAlignment(SwingConstants.LEFT);
		lblSearchByProduct.setBounds(10, 11, 163, 14);
		panel_4.add(lblSearchByProduct);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(255, 255, 255));
		textField_6.setBounds(10, 33, 102, 20);
		panel_4.add(textField_6);
		textField_6.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 64, 163, 148);
		panel_4.add(scrollPane_1);
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		
		JButton btnGo_1 = new JButton("GO");
		
		btnGo_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGo_1.setBounds(122, 32, 51, 23);
		panel_4.add(btnGo_1);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(212, 52, 504, 187);
		panel_3.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEnabled(true);
		table.setColumnSelectionAllowed(false);
		table.setFocusable(false);
		table.setRowSelectionAllowed(true);
		//table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		/*table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (table.getSelectedRow() > -1) {
		            // print first column value from selected row
		            System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
		        }
		    }
		});
*/

		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"P_ID","Product", "Price", "Qty", "Total"
			}
		));
		
		JButton btnNewButton = new JButton("Remove");
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(465, 250, 89, 17);
		panel_3.add(btnNewButton);
		
		JButton btnGenerateBill = new JButton("Generate Bill");
		
		btnGenerateBill.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGenerateBill.setBounds(577, 250, 123, 17);
		panel_3.add(btnGenerateBill);
		
		JLabel lblSubTotal = new JLabel("Sub Total");
		lblSubTotal.setBounds(726, 48, 46, 14);
		panel_3.add(lblSubTotal);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(727, 64, 86, 20);
		panel_3.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(726, 118, 86, 20);
		panel_3.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setBounds(727, 172, 86, 20);
		panel_3.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblDiscount_1 = new JLabel("Discount");
		lblDiscount_1.setBounds(726, 95, 46, 27);
		panel_3.add(lblDiscount_1);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(726, 154, 60, 17);
		panel_3.add(lblTotal);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new newOrder().setVisible(true);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(237, 250, 89, 17);
		panel_3.add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Mainframe().setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(349, 250, 89, 17);
		panel_3.add(btnBack);
		
		JButton btnGo_2 = new JButton("Go");
		
		btnGo_2.setBounds(212, 23, 62, 17);
		panel_3.add(btnGo_2);
		btnGo_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		//CHECK
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().equals("")){
				long contact=Long.parseLong(textField.getText());
				if(contact>1000000){
					try {
						Connection con = DriverManager.getConnection(url, username, password);
						Statement S=con.createStatement();
				        String q="select * from customers where contact="+contact;
				        ResultSet r= S.executeQuery(q);
			            if(!r.isBeforeFirst()){
			            	 JOptionPane.showMessageDialog(null,"Not Found ");
			            }
			            else{
			            r.next();
			            txtCustomerName.setText(""+r.getLong("c_id"));
			            txtName.setText(""+r.getString("c_name"));
			            txtEmail.setText(""+r.getString("email"));
			            }
			            
			            S.close();
			            con.close();
					} catch (SQLException s) {
						// TODO Auto-generated catch block
				        JOptionPane.showMessageDialog(null, s.getMessage());
					}
				}
				else {
					 JOptionPane.showMessageDialog(null, "Enter Valid Number");
				}
				
			}
				else{
					 JOptionPane.showMessageDialog(null, "Enter Contact Number First..");
				}
			}
		});
		
		//ADD CUSTOMER
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textField.getText().equals("") ||  txtName.getText().equals("Enter Name") || txtEmail.getText().equals("Enter Email"))){
				long contact=Long.parseLong(textField.getText());
				String name=txtName.getText();
				String email=txtEmail.getText();
				 try {
						Connection con = DriverManager.getConnection(url, username, password);
						Statement S=con.createStatement();
				        String q="insert into customers( c_name,contact,email) values('"+name+"',"+contact+",'"+email+"')";
				        int x= S.executeUpdate(q);
				        if(x==1)
				            JOptionPane.showMessageDialog(null, "Record Added");
				        else             JOptionPane.showMessageDialog(null, "Error! Record not added");
				        S.close();
				        con.close();

					} catch (SQLException s) {
						// TODO Auto-generated catch block
				        JOptionPane.showMessageDialog(null, s.getMessage());
					}
			}
				else{
			        JOptionPane.showMessageDialog(null, "Enter Complete Details...");
				}
			}
		});
		
		
		//Fetch Product Details
		
		btnGo_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textField_1.getText().equals("") && textField_2.getText().equals(""))){
				String b_id=textField_1.getText();
				comboBox.removeAllItems();
				int p_id=Integer.parseInt(textField_2.getText());
				try {
					Connection con = DriverManager.getConnection(url, username, password);
					Statement S=con.createStatement();
			        String q="Select * from products where b_id='"+b_id+"' or p_id="+p_id;
			        ResultSet r= S.executeQuery(q);
		            if(!r.isBeforeFirst()){
		            	 JOptionPane.showMessageDialog(null,"No Product Found ");
		            }
		            else{
		            r.next();
		            textField_1.setText(""+r.getString("b_id"));
		            textField_2.setText(""+r.getInt("p_id"));
		            textField_3.setText(""+r.getString("p_name"));
		            textField_4.setText(""+r.getDouble("price"));
		            textField_5.setText(""+r.getDouble("discount"));
		            int j=r.getInt("qty");
		            int i=1;
		            while(i<=j){
		            	comboBox.addItem(i++);
		            }
		            }
		            S.close();
			        con.close();

				} catch (SQLException s) {
					// TODO Auto-generated catch block
			        JOptionPane.showMessageDialog(null, s.getMessage());
				}
			}
			}
		});
		
		//Search Product
		btnGo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_6.getText().equals("")){
				String p_name=textField_6.getText();
				try {
					Connection con = DriverManager.getConnection(url, username, password);
					Statement S=con.createStatement();
			        String q="Select * from products where p_name='"+p_name+"'";
			        ResultSet r= S.executeQuery(q);
		            if(!r.isBeforeFirst()){
		            	 JOptionPane.showMessageDialog(null,"No Product Found ");
		            }
		            else{
		            	textArea.setText("");
		            while(r.next()){
			            textArea.append("\nProduct ID:"+r.getInt("p_id")+" Barcode ID:"+r.getString("b_id"));
		            }
		            }
		            S.close();
			        con.close();

				} catch (SQLException s) {
					// TODO Auto-generated catch block
			        JOptionPane.showMessageDialog(null, s.getMessage());
				}

				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_3.getText().equals("")){
				int qty=(Integer)comboBox.getSelectedItem();
				int p_id=Integer.parseInt(textField_2.getText());
				String p_name=textField_3.getText();
				Double price=Double.parseDouble(textField_4.getText());
				Double discount=Double.parseDouble(textField_5.getText());
				Double p=price*(100-discount)/100;
				Object[] row={p_id,p_name,p,qty,p*qty};
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				m.addRow(row);
				st+=p*qty;
				if(!textField_8.getText().equals("")){
					dis=Double.parseDouble(textField_8.getText());
				}
				t=st*(100-dis)/100;
				textField_7.setText(""+st);
				textField_9.setText(""+t);
				//table.setModel(m);
				
				//table.setModel(m);
				
				}	
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				try{
					
					if(table.getSelectedRow()>=0){
						st-=Double.parseDouble(""+m.getValueAt(table.getSelectedRow(), 4));
						t=st*(100-dis)/100;
						textField_7.setText(""+st);
						textField_9.setText(""+t);
						m.removeRow(table.getSelectedRow());
					}
				}
				
				catch(ArrayIndexOutOfBoundsException e){
					e.printStackTrace();
					
				}
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				int o_id;
				lblDate.setText(""+new java.sql.Date(System.currentTimeMillis()));
				 try {
					 
						Connection con = DriverManager.getConnection(url, username, password);
						Statement S=con.createStatement();
				        String q="select max(o_id) as o_id from orders";
				        ResultSet r= S.executeQuery(q);
			            if(!r.isBeforeFirst()){
			            	 o_id=1;
			            }
			            else{
			            r.next();
			            o_id=r.getInt("o_id")+1;
			            }
			            textField_10.setText(""+o_id);
			            S.close();
			            con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
				        JOptionPane.showMessageDialog(null, e.getMessage());
					}
			}
		});
		
		
		btnGenerateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				if(!(textField_10.getText().equals("") || txtCustomerName.getText().equals("") || textField_9.getText().equals("") || m.getRowCount()==0)){
				int o_id=Integer.parseInt(textField_10.getText());
				int c_id=Integer.parseInt(txtCustomerName.getText());
				double amt=Double.parseDouble(textField_9.getText());
				Date o_date=new java.sql.Date(System.currentTimeMillis());

				
				int rows=m.getRowCount();
				try {
					Connection con = DriverManager.getConnection(url, username, password);
					Statement S=con.createStatement();
					Statement S1=con.createStatement();
			        String q="insert into orders( o_id,c_id, amt,o_date,o_time) values("+o_id+","+c_id+","+amt+",'"+o_date+"','"+LocalTime.now()+"')";
			        int x= S.executeUpdate(q);
			        if(x==1){
			        	int p_id,qty;
			        	double price;
			        	int i=0;
			        	for(;i<rows;i++){
			        		p_id=Integer.parseInt( m.getValueAt(i, 0).toString());
			        		qty=Integer.parseInt(  m.getValueAt(i, 3).toString());
			        		price=(Double)m.getValueAt(i, 4);
							String sql="insert into order_details( o_id,p_id, qty,t_price) values("+o_id+","+p_id+","+qty+","+price+")";
							String abc="update products set qty=qty-"+qty+" where p_id="+p_id;
							S1.executeUpdate(abc);
							x=S.executeUpdate(sql);
							
						}
			        	if(i==rows){
							dispose();
							MyBill obj=new MyBill();
							obj.setOrder(o_id);
							obj.setCust(c_id);
							obj.setFlag(1);
							obj.setVisible(true);
						}
						else{
				        	JOptionPane.showMessageDialog(null, "Error! Order can't be processed");
						}
			        	
			        }
			        else         
			        	JOptionPane.showMessageDialog(null, "Error! Order can't be processed");
			        
			        S1.close();
			        S.close();
			        con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
			        JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				}
				else{
			        JOptionPane.showMessageDialog(null, "Enter Complete Details...");
				}
			}
		});
	}
}
