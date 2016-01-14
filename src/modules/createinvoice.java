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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
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
import javax.swing.JTable;
import javax.swing.JTextArea;

public class createinvoice extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	Double st=0.0,t=0.0,dis=0.0;
	int index;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public createinvoice() {
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
		
		JLabel lblPlaceYourOrder = new JLabel("Generate  INVOICE");
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
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 204, 153));
		panel_2.setBounds(0, 114, 823, 304);
		contentPane.add(panel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 22, 86, 17);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(106, 21, 86, 20);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(314, 21, 86, 20);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(424, 21, 75, 20);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(531, 21, 62, 20);
		panel_2.add(textField_4);
		
		final JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setBounds(613, 21, 62, 20);
		panel_2.add(comboBox);
		
		JLabel label = new JLabel("Barcode ID");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 0, 86, 14);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Product_ID");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(106, 5, 86, 9);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Product");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(331, 0, 46, 14);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Price");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(433, 0, 46, 14);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Discount");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(521, 0, 46, 14);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Quantity");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(629, 0, 46, 14);
		panel_2.add(label_5);
		
		JButton button = new JButton("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int qty=(Integer)comboBox.getSelectedItem();
				int p_id=Integer.parseInt(textField_1.getText());
				String p_name=textField_2.getText();
				Double price=Double.parseDouble(textField_3.getText());
				Double discount=Double.parseDouble(textField_4.getText());
				Double p=price*(100-discount)/100;
				Object[] row={p_id,p_name,p,qty,p*qty};
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				m.addRow(row);
				st+=p*qty;
				if(!textField_7.getText().equals("")){
					dis=Double.parseDouble(textField_8.getText());
				}
				t=st*(100-dis)/100;
				textField_6.setText(""+st);
				textField_8.setText(""+t);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(697, 11, 89, 24);
		panel_2.add(button);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(220, 220, 220));
		panel_3.setBounds(10, 50, 182, 223);
		panel_2.add(panel_3);
		
		JLabel label_6 = new JLabel("Search by product name");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_6.setBounds(10, 11, 163, 14);
		panel_3.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(10, 33, 102, 20);
		panel_3.add(textField_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 161, 146);
		panel_3.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton button_1 = new JButton("GO");
		
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(122, 32, 51, 23);
		panel_3.add(button_1);
		
		JButton button_2 = new JButton("Remove");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m=(DefaultTableModel)table.getModel();
				
				try{
					
					if(table.getSelectedRow()>=0){
						st-=Double.parseDouble(""+m.getValueAt(table.getSelectedRow(), 4));
						t=st*(100-dis)/100;
						textField_6.setText(""+st);
						textField_8.setText(""+t);
						m.removeRow(table.getSelectedRow());
					}
				}
				
				catch(ArrayIndexOutOfBoundsException e1){
					e1.printStackTrace();
					
				}
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(212, 52, 502, 187);
		panel_2.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setRowSelectionAllowed(true);
		table.setFocusable(false);
		table.setEnabled(true);
		table.setColumnSelectionAllowed(false);
		
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"P_ID","Product", "Price", "Qty", "Total"
				}
			));
		
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_2.setBounds(465, 250, 89, 17);
		panel_2.add(button_2);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPrint.setBounds(577, 250, 123, 17);
		panel_2.add(btnPrint);
		
		JLabel label_7 = new JLabel("Sub Total");
		label_7.setBounds(726, 48, 46, 14);
		panel_2.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(727, 64, 86, 20);
		panel_2.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(726, 118, 86, 20);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(727, 172, 86, 20);
		panel_2.add(textField_8);
		
		JLabel label_8 = new JLabel("Discount");
		label_8.setBounds(726, 95, 46, 27);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Total");
		label_9.setBounds(726, 154, 60, 17);
		panel_2.add(label_9);
		
		JButton button_4 = new JButton("Reset");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new createinvoice().setVisible(true);
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_4.setBounds(237, 250, 89, 17);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("Back");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Mainframe().setVisible(true);
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_5.setBounds(349, 250, 89, 17);
		panel_2.add(button_5);
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


		
		JButton button_6 = new JButton("Go");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String b_id=textField.getText();
				comboBox.removeAllItems();
				int p_id=Integer.parseInt(textField_1.getText());
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
		            textField.setText(""+r.getString("b_id"));
		            textField_1.setText(""+r.getInt("p_id"));
		            textField_2.setText(""+r.getString("p_name"));
		            textField_3.setText(""+r.getDouble("price"));
		            textField_4.setText(""+r.getDouble("discount"));
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
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p_name=textField_5.getText();
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
		});
		button_6.setHorizontalAlignment(SwingConstants.LEFT);
		button_6.setBounds(212, 23, 62, 17);
		panel_2.add(button_6);

	}

}
