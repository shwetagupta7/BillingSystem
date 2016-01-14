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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEmp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public AddEmp() {
		
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
		
		JLabel lblAddEmployee = new JLabel("ADD EMPLOYEE");
		lblAddEmployee.setForeground(Color.WHITE);
		lblAddEmployee.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblAddEmployee.setBounds(30, 49, 214, 50);
		panel.add(lblAddEmployee);
		
		
		
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
		
		JLabel lblNewLabel = new JLabel("Enter Employee  Username");
		lblNewLabel.setBounds(102, 165, 153, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(288, 162, 128, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setBounds(102, 196, 128, 14);
		contentPane.add(lblEnterPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(288, 193, 128, 20);
		contentPane.add(passwordField);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(102, 232, 87, 14);
		contentPane.add(lblCategory);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(288, 229, 128, 20);
		contentPane.add(comboBox);
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
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(  !passwordField.getPassword().equals("") && !textField.getText().equals("")){
					String pwd=new String(passwordField.getPassword());
					String usr=textField.getText();
					String ct=(String)comboBox.getSelectedItem();
					  try {
							Connection con = DriverManager.getConnection(url, username, password);
							Statement S=con.createStatement();
					        String q="insert into users( username,password, category) values('"+usr+"','"+pwd+"','"+ct+"')";
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
				else{
					JOptionPane.showMessageDialog(null, " Error!!Passwords do not match..");
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegister.setBounds(219, 315, 89, 23);
		contentPane.add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Mainframe().setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(660, 376, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AddEmp().setVisible(true);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(531, 376, 89, 23);
		contentPane.add(btnReset);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			
				comboBox.addItem("admin");
				comboBox.addItem("Employee");
			}
		});
		
	}
}
