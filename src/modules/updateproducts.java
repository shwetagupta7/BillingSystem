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
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class updateproducts extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	int flag=0;
	

	/**
	 * Create the frame.
	 */
	public updateproducts() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				flag=0;
			}
		});
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
		
		JLabel lblPlaceYourOrder = new JLabel("Update Product Details");
		lblPlaceYourOrder.setForeground(Color.WHITE);
		lblPlaceYourOrder.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblPlaceYourOrder.setBounds(26, 57, 312, 42);
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
		
		Panel panel_2 = new Panel();
		panel_2.setLayout(null);
		panel_2.setBounds(76, 189, 619, 159);
		contentPane.add(panel_2);
		
		JLabel label = new JLabel("Product ID");
		label.setBounds(10, 11, 66, 14);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Product Name");
		label_1.setBounds(10, 49, 83, 14);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Category");
		label_2.setBounds(10, 88, 66, 14);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Price");
		label_3.setBounds(337, 11, 46, 14);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Discount");
		label_4.setBounds(337, 49, 46, 14);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Quantity");
		label_5.setBounds(337, 88, 46, 14);
		panel_2.add(label_5);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(142, 8, 116, 20);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(142, 46, 116, 20);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(419, 8, 109, 20);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(419, 46, 109, 20);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(419, 85, 109, 20);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(139, 85, 119, 20);
		panel_2.add(textField_5);
		
		JButton button = new JButton("RESET");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
	            textField_1.setText("");
	            textField_2.setText("");
	            textField_3.setText("");
	            textField_4.setText("");
	            textField_5.setText("");
				flag=0;
			}
		});
		button.setBounds(195, 357, 89, 23);
		contentPane.add(button);
		
		JButton btnUpdate = new JButton("Update");
		
		btnUpdate.setBounds(294, 357, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton button_2 = new JButton("BACK");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Mainframe().setVisible(true);
			}
		});
		button_2.setBounds(487, 357, 89, 23);
		contentPane.add(button_2);
		
		JButton btnDelete = new JButton("Delete");
		
		btnDelete.setBounds(393, 357, 89, 23);
		contentPane.add(btnDelete);
		
		textField_6 = new JTextField();
		textField_6.setBounds(294, 137, 155, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblEnterBarcodeId = new JLabel("Enter Barcode ID or Product ID");
		lblEnterBarcodeId.setBounds(94, 140, 168, 14);
		contentPane.add(lblEnterBarcodeId);
		
		JButton btnViewDetails = new JButton("View Details");
		
		
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
		   
		   //View details
		btnViewDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int p_id=Integer.parseInt(textField_6.getText());
				try {
					Connection con = DriverManager.getConnection(url, username, password);
					Statement S=con.createStatement();
			        String q="select * from products where p_id="+p_id;
			        ResultSet r= S.executeQuery(q);
		            if(!r.isBeforeFirst()){
		            	 JOptionPane.showMessageDialog(null,"No Products Found ");
		            }
		            else{
		            r.next();
		            flag=1;
		            textField.setText(""+r.getInt("p_id"));
		            textField_1.setText(""+r.getString("p_name"));
		            textField_2.setText(""+r.getDouble("price"));
		            textField_3.setText(""+r.getDouble("discount"));
		            textField_4.setText(""+r.getInt("qty"));
		            textField_5.setText(""+r.getString("category"));
		            }
		            
		            S.close();
		            con.close();
				} catch (SQLException s) {
					// TODO Auto-generated catch block
			        JOptionPane.showMessageDialog(null, s.getMessage());
				}
			}
		});
		btnViewDetails.setBounds(502, 136, 124, 23);
		contentPane.add(btnViewDetails);
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==1){
					try {
						Connection con = DriverManager.getConnection(url, username, password);
						Statement S=con.createStatement();
						String q="delete from products where p_id="+Integer.parseInt(textField_6.getText());
				        int x= S.executeUpdate(q);
				        if(x==1)
				            JOptionPane.showMessageDialog(null, "Record Deleted");
				        else             JOptionPane.showMessageDialog(null, "Error! Record not Deleted");
				        S.close();
				        con.close();
					} 
					catch (SQLException s) {
						// TODO Auto-generated catch block
				        JOptionPane.showMessageDialog(null, s.getMessage());
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"No product Specified");
				}
			}
		});

		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==1){
					int p_id=Integer.parseInt(textField.getText());
					String name=textField_1.getText();
					double price=Double.parseDouble(textField_2.getText());
					double discount=Double.parseDouble(textField_3.getText());
					int qty=Integer.parseInt(textField_4.getText());
					String category=textField_5.getText();
					
					try {
						Connection con = DriverManager.getConnection(url, username, password);
						Statement S=con.createStatement();
						String q="update products set p_name='"+name+"',category='"+category+"',price="+price+",discount="+discount+",qty="+qty+" where p_id="+p_id+"";
				        int x= S.executeUpdate(q);
				        if(x==1)
				            JOptionPane.showMessageDialog(null, "Record Updated");
				        else             JOptionPane.showMessageDialog(null, "Error! Record not Updated");
				        S.close();
				        con.close();
					} 
					catch (SQLException s) {
						// TODO Auto-generated catch block
						s.printStackTrace();
				        JOptionPane.showMessageDialog(null, s.getMessage());
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"No product Specified");
				}
			}
		});
		
	}
}
