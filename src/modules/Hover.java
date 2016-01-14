package modules;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class Hover extends JFrame implements ActionListener
{

	private JPanel contentPane;

	Timer t=new Timer(3000, this);
	
	
	/**
	 * Create the frame.
	 */
	public Hover() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel background=new JLabel(new ImageIcon(Hover.class.getResource("/img1.jpg")));
		background.setBounds(0, 0, 845, 488);
	    getContentPane().add(background);
	    background.setLayout(new FlowLayout());

	    contentPane.add(background);
		t.start();
		
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		this.dispose();
		new Mainframe().setVisible(true);
		t.stop();
		}


}
