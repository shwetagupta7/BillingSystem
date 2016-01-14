package modules;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mainframe extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public Mainframe() {
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
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 112, 829, 28);
		contentPane.add(panel_2);
		
		JMenuBar menuBar = new JMenuBar();
		panel_2.add(menuBar);
		
		JMenu mnProducts = new JMenu("Products");
		menuBar.add(mnProducts);
		
		JMenuItem mntmUpdate_1 = new JMenuItem("Update");
		mntmUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new Mainframe().setVisible(false);
				dispose();
				new updateproducts().setVisible(true);
			}
		});
		mnProducts.add(mntmUpdate_1);
		
		JMenuItem mntmAdd = new JMenuItem("Add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new Mainframe().setVisible(false);
				dispose();
				new addProduct().setVisible(true);
				
			}
		});
		mnProducts.add(mntmAdd);
		
		JMenu mnBill = new JMenu("Sales");
		menuBar.add(mnBill);
		
		JMenuItem mntmCreate_1 = new JMenuItem("Open");
		mntmCreate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Sales().setVisible(true);
			}
			
		});
		mnBill.add(mntmCreate_1);
		
		JMenu mnInvoice = new JMenu("Invoice");
		mnInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ViewOrder().setVisible(true);
			}
		});
		menuBar.add(mnInvoice);
		
		JMenuItem mntmCreate = new JMenuItem("Create");
		mntmCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new createinvoice().setVisible(true);
			}
		});
		mnInvoice.add(mntmCreate);
		
		JMenuItem mntmView_1 = new JMenuItem("View");
		mntmView_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ViewOrder().setVisible(true);
			}
		});
		mnInvoice.add(mntmView_1);
		
		JMenu mnOrders = new JMenu("Orders");
		menuBar.add(mnOrders);
		
		JMenuItem mntmView = new JMenuItem("View");
		mntmView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ViewOrder().setVisible(true);
			}
		});
		mnOrders.add(mntmView);
		
		JMenuItem mntmPlaceOrder = new JMenuItem("Place order");
		mntmPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new Mainframe().setVisible(false);
				new newOrder().setVisible(true);
				dispose();
				
			}
		});
		mnOrders.add(mntmPlaceOrder);
		
		JMenu mnEmployees = new JMenu("Employees");
		menuBar.add(mnEmployees);
		
		JMenuItem mntmAddNewEmployee = new JMenuItem("Add");
		mntmAddNewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AddEmp().setVisible(true);
			}
		});
		mnEmployees.add(mntmAddNewEmployee);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Update");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new UpdateEmp().setVisible(true);
			}
		});
		mnEmployees.add(mntmNewMenuItem_1);
		
		
	}
}
