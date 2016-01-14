package modules;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
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

public class ViewOrder extends JFrame {

	private JTable table;
	private JPanel contentPane;
	private JTextField textField;

	
	/**
	 * Create the frame.
	 */
	public ViewOrder() {
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
		
		JLabel lblPlaceYourOrder = new JLabel("View Order");
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(-10, 121, 823, 309);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(221, 65, 169, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterOrderId = new JLabel("Enter Order ID");
		lblEnterOrderId.setBounds(60, 57, 125, 36);
		panel_2.add(lblEnterOrderId);
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
				int o_id=Integer.parseInt(textField.getText());
				int cid=0;
				try {
					Connection con = DriverManager.getConnection(url, username, password);
					Statement S=con.createStatement();
			        String q="select c_id from orders where o_id="+o_id;
			        ResultSet r= S.executeQuery(q);
		            if(!r.isBeforeFirst()){
		            	 JOptionPane.showMessageDialog(null,"Not Found ");
		            }
		            else{
		            r.next();
		            cid=r.getInt("c_id");
		            }
		            
		            S.close();
		            con.close();
				} catch (SQLException s) {
					// TODO Auto-generated catch block
			        JOptionPane.showMessageDialog(null, s.getMessage());
				}
				dispose();
				MyBill obj=new MyBill();
				obj.setCust(cid);
				obj.setOrder(o_id);
				obj.setFlag(0);
				obj.setVisible(true);
			}
		});
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGo.setBounds(498, 64, 89, 23);
		panel_2.add(btnGo);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Mainframe().setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(691, 253, 89, 23);
		panel_2.add(btnBack);
		
		
		

	}

}
