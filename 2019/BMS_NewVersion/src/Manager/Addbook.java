package Manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Default.Default_BMS_main;
import Default.Main;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Addbook extends JFrame {

	private JPanel Addbook_contentPane;
	private JTable Bookphoto_JTable;
	private JTextField Title_JTextField;
	private JTextField Author_JTextField;
	private JTextField Plot_JTextField;
	private JTextField Content_JTextField;
	private JTextField Name_JTextField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Addbook() {
		setTitle("Addbook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		Addbook_contentPane = new JPanel();
		Addbook_contentPane.setBackground(SystemColor.desktop);
		Addbook_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Addbook_contentPane);
		Addbook_contentPane.setLayout(null);
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.setBounds(32, 20, 161, 32);
		Addbook_contentPane.add(icon_JButton);
		
		icon_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Manager_BMS_main frame = new Manager_BMS_main(); //서브메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		JLabel Management_ver_JLabel = new JLabel("(Management Version)");
		Management_ver_JLabel.setFont(new Font("굴림", Font.BOLD, 15));
		Management_ver_JLabel.setBounds(205, 20, 185, 32);
		Addbook_contentPane.add(Management_ver_JLabel);
		
		JLabel Managerpage_JLabel = new JLabel("\uAD00\uB9AC\uC790\uD398\uC774\uC9C0");
		Managerpage_JLabel.setFont(new Font("굴림", Font.BOLD, 22));
		Managerpage_JLabel.setBounds(62, 94, 147, 32);
		Addbook_contentPane.add(Managerpage_JLabel);
		
		JLabel Manager_JLabel = new JLabel("\uAD00\uB9AC\uC790\uB2D8");
		Manager_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Manager_JLabel.setBounds(418, 94, 100, 32);
		Addbook_contentPane.add(Manager_JLabel);
		
		JButton Logout_JButton = new JButton("\uB85C\uADF8\uC544\uC6C3");
		Logout_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Logout_JButton.setBounds(571, 54, 129, 43);
		Addbook_contentPane.add(Logout_JButton);
		
		Logout_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							JOptionPane.showMessageDialog(null, "정상적으로 로그아웃 되었습니다."); //완료 창 띄움
							Default_BMS_main frame = new Default_BMS_main(); //메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		JButton Clientlist_JButton = new JButton("\uD68C\uC6D0\uBAA9\uB85D");
		Clientlist_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Clientlist_JButton.setBounds(43, 237, 129, 43);
		Addbook_contentPane.add(Clientlist_JButton);
		
		Clientlist_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Manager_BMS_main frame = new Manager_BMS_main(); //서브메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		JButton Addbook_JButton = new JButton("\uB3C4\uC11C\uCD94\uAC00");
		Addbook_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Addbook_JButton.setBounds(43, 340, 129, 43);
		Addbook_contentPane.add(Addbook_JButton);
		
		JButton Deletebook_JButton = new JButton("\uB3C4\uC11C\uC0AD\uC81C");
		Deletebook_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Deletebook_JButton.setBounds(43, 443, 129, 43);
		Addbook_contentPane.add(Deletebook_JButton);
		
		Deletebook_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Deletebook frame = new Deletebook(); //서브메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		JPanel Content_JPanel = new JPanel();
		Content_JPanel.setBounds(229, 208, 451, 297);
		Addbook_contentPane.add(Content_JPanel);
		Content_JPanel.setLayout(null);
		
		Bookphoto_JTable = new JTable();
		Bookphoto_JTable.setBounds(42, 40, 150, 164);
		Content_JPanel.add(Bookphoto_JTable);
		
		JButton Add_JButton = new JButton("\uCD94\uAC00\uD558\uAE30");
		Add_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Add_JButton.setBounds(54, 235, 129, 26);
		Content_JPanel.add(Add_JButton);
		
		JLabel Title_JLabel = new JLabel("\uC81C\uBAA9");
		Title_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Title_JLabel.setBounds(221, 40, 218, 32);
		Content_JPanel.add(Title_JLabel);
		
		JLabel Author_JLabel = new JLabel("\uC800\uC790");
		Author_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Author_JLabel.setBounds(221, 92, 218, 32);
		Content_JPanel.add(Author_JLabel);
		
		JLabel Plot_JLabel = new JLabel("\uC904\uAC70\uB9AC");
		Plot_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Plot_JLabel.setBounds(204, 151, 218, 32);
		Content_JPanel.add(Plot_JLabel);
		
		JLabel Content_JLabel = new JLabel("\uB0B4\uC6A9");
		Content_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Content_JLabel.setBounds(221, 208, 218, 32);
		Content_JPanel.add(Content_JLabel);
		
		Title_JTextField = new JTextField();
		Title_JTextField.setBounds(276, 40, 129, 32);
		Content_JPanel.add(Title_JTextField);
		Title_JTextField.setColumns(10);
		
		Author_JTextField = new JTextField();
		Author_JTextField.setColumns(10);
		Author_JTextField.setBounds(276, 92, 129, 32);
		Content_JPanel.add(Author_JTextField);
		
		Plot_JTextField = new JTextField();
		Plot_JTextField.setColumns(10);
		Plot_JTextField.setBounds(276, 151, 129, 32);
		Content_JPanel.add(Plot_JTextField);
		
		Content_JTextField = new JTextField();
		Content_JTextField.setColumns(10);
		Content_JTextField.setBounds(276, 208, 129, 32);
		Content_JPanel.add(Content_JTextField);
		
		try {
			Connection conn = DriverManager.getConnection(Main.url, Main.user, Main.password);
			
			String sql1 = "SELECT name FROM manager WHERE id = ?";
			
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, Manager.Manager_BMS_main.currentManager);

			ResultSet rs = pstmt1.executeQuery();
			
			if(rs.next()) {
				
				Name_JTextField = new JTextField();
				Name_JTextField.setEditable(false);
				Name_JTextField.setText(rs.getString(1));
				Name_JTextField.setBounds(282, 95, 129, 32);
				Addbook_contentPane.add(Name_JTextField);
				Name_JTextField.setColumns(10);
			}
			
			pstmt1.close();
			conn.close();
			
		}
		
		 catch (SQLException e1) {
				e1.printStackTrace();
			}	
		
	}
}
