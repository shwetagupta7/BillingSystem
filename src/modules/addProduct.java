package modules;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class addProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtAddYourOwn;
	private JTextField textField_5;
	
	
	

	

	/**
	 * Create the frame.
	 */
	public addProduct() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 492);
		getContentPane().setLayout(new BorderLayout());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 0, 829, 449);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 421, 829, 28);
		panel_5.add(panel_1);
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setLayout(null);
		
		JLabel lblPoweredByCodeace = new JLabel("Powered by CodeAce");
		lblPoweredByCodeace.setForeground(Color.WHITE);
		lblPoweredByCodeace.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPoweredByCodeace.setBounds(544, 0, 236, 25);
		panel_1.add(lblPoweredByCodeace);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(48, 151, 742, 229);
		panel_5.add(panel_3);
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);
		

		Panel panel_2 = new Panel();
		panel_2.setBounds(10, 33, 619, 151);
		panel_3.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setBounds(10, 11, 66, 14);
		panel_2.add(lblProductId);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(10, 49, 83, 14);
		panel_2.add(lblProductName);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(10, 88, 66, 14);
		panel_2.add(lblCategory);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(337, 11, 46, 14);
		panel_2.add(lblPrice);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setBackground(Color.WHITE);
		lblDiscount.setBounds(337, 49, 46, 14);
		panel_2.add(lblDiscount);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(337, 88, 46, 14);
		panel_2.add(lblQuantity);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(89, 8, 116, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(89, 46, 116, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		final JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(86, 85, 119, 20);
		panel_2.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(419, 8, 109, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(419, 46, 109, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(419, 85, 109, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		txtAddYourOwn = new JTextField();
		txtAddYourOwn.setText("add your own category");
		txtAddYourOwn.setBounds(83, 116, 145, 20);
		panel_2.add(txtAddYourOwn);
		txtAddYourOwn.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(249, 206, 89, 23);
		panel_3.add(btnAdd);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setBounds(95, 206, 89, 23);
		panel_3.add(btnReset);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(442, 206, 89, 23);
		panel_3.add(btnBack);
		
		JLabel lblBarcodeId = new JLabel("Barcode ID");
		lblBarcodeId.setBounds(129, 13, 111, 14);
		panel_3.add(lblBarcodeId);
		
		
		textField_5 = new JTextField();
		textField_5.setBounds(295, 7, 157, 20);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 829, 110);
		panel_5.add(panel);
		panel.setBackground(new Color(0, 0, 128));
		panel.setLayout(null);
		
		
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

		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.setForeground(Color.WHITE);
		lblAddProduct.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblAddProduct.setBounds(25, 57, 312, 42);
		panel.add(lblAddProduct);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Mainframe().setVisible(true);
				//new addProduct().setVisible(false);
				dispose();
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int p_id=1;
				 comboBox.removeAllItems();
				 try {
						Connection con = DriverManager.getConnection(url, username, password);
						Statement S=con.createStatement();
				        String q="select distinct(category) from products";
				        String sql="select max(p_id) as p_id from products";
				        ResultSet r= S.executeQuery(q);
			            if(!r.isBeforeFirst()){
			            	 JOptionPane.showMessageDialog(null,"No Categories Found ");
			            }
			            else{
			            while(r.next()){
			            String c=r.getString("category");
			            comboBox.addItem(c);
			            }
			            }
			            r=S.executeQuery(sql);
			            if(!r.isBeforeFirst()){
			            	 p_id=1;
			            }
			            else{
			            r.next();
			            p_id=r.getInt("p_id")+1;
			            }
			            S.close();
			            con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						
				        JOptionPane.showMessageDialog(null, e.getMessage());
					}
		            textField.setText(""+p_id);
		            textField_1.setText("");
		            textField_2.setText("");
		            textField_3.setText("");
		            textField_4.setText("");

			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name=textField_1.getText();
				String category=null;
				Double price=Double.parseDouble(textField_2.getText());
				Double discount=Double.parseDouble(textField_3.getText());
				int qty=Integer.parseInt(textField_4.getText());
				if(txtAddYourOwn.getText().equals("add your own category")){
					category=(String)comboBox.getSelectedItem();
				}
				else {
					category=txtAddYourOwn.getText();
				}
				

				

				   try {
					Connection con = DriverManager.getConnection(url, username, password);
					Statement S=con.createStatement();
			        String q="insert into products( category,p_name, price,discount,qty) values('"+category+"','"+name+"',"+price+","+discount+","+qty+")";
			        int x= S.executeUpdate(q);
			        if(x==1)
			            JOptionPane.showMessageDialog(null, "Record Added");
			        else             JOptionPane.showMessageDialog(null, "Error! Record not added");
			        S.close();
			        con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
			        JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				
			}
		});
		
		
				
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				//panel_5.setVisible(false);
				//panel_4.setVisible(true);
		
				
				int p_id=1;
				 comboBox.removeAllItems();
				 try {
						Connection con = DriverManager.getConnection(url, username, password);
						Statement S=con.createStatement();
				        String q="select distinct(category) from products";
				        String sql="select max(p_id) as p_id from products";
				        ResultSet r= S.executeQuery(q);
			            if(!r.isBeforeFirst()){
			            	 JOptionPane.showMessageDialog(null,"No Categories Found ");
			            }
			            else{
			            while(r.next()){
			            String c=r.getString("category");
			            comboBox.addItem(c);
			            }
			            }
			            r=S.executeQuery(sql);
			            if(!r.isBeforeFirst()){
			            	 p_id=1;
			            }
			            else{
			            r.next();
			            p_id=r.getInt("p_id")+1;
			            }
			            S.close();
			            con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						
				        JOptionPane.showMessageDialog(null, e.getMessage());
					}
		            textField.setText(""+p_id);
		            textField_2.setText("");
		            textField_3.setText("");
		            textField_4.setText("");


			}
		});
	}
	}
