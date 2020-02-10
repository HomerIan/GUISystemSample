package guiSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;


public class OnlineBookstore extends JFrame {

	private JPanel contentPane;
	private JTextField firstNametextField;
	private JTextField lastNametextField;
	private JButton loginbtn; 

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {		
					OnlineBookstore frame = new OnlineBookstore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OnlineBookstore() {
		
		Connection conn = null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		
		String userName = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/guisystem?useSSL=false";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(30, 59, 82, 14);
		panel.add(firstNameLabel);
		
		firstNametextField = new JTextField();
		firstNametextField.setBounds(122, 56, 96, 20);
		panel.add(firstNametextField);
		firstNametextField.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(30, 84, 82, 14);
		panel.add(lastNameLabel);
		
		lastNametextField = new JTextField();
		lastNametextField.setBounds(122, 81, 96, 20);
		panel.add(lastNametextField);
		lastNametextField.setColumns(10);
		
		JButton loginbtn = new JButton("login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(url, userName, password);
					String sql ="INSERT INTO customer(firstName, lastName) VALUES (?,?)";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setString(1, firstNametextField.getText());
					pst.setString(2, lastNametextField.getText());
					pst.executeUpdate();
				}catch(Exception ex) {
					System.out.print(ex);
				}
			}
		});
		loginbtn.setBounds(111, 154, 89, 23);
		panel.add(loginbtn);
		
	}
}
