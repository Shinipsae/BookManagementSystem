package Client;

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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Mypage extends JFrame {

	private JPanel Mypage_contentPane;
	private JTable Content_JTable;
	private JTextField Name_JTextField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Mypage() {
		setTitle("Mypage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		Mypage_contentPane = new JPanel();
		Mypage_contentPane.setBackground(SystemColor.desktop);
		Mypage_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Mypage_contentPane);
		Mypage_contentPane.setLayout(null);
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.setBounds(36, 29, 161, 32);
		Mypage_contentPane.add(icon_JButton);
		
		icon_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Client_BMS_main frame = new Client_BMS_main();
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JLabel Mypage_JLabel = new JLabel("\uB9C8\uC774\uD398\uC774\uC9C0");
		Mypage_JLabel.setFont(new Font("굴림", Font.BOLD, 22));
		Mypage_JLabel.setBounds(67, 111, 147, 32);
		Mypage_contentPane.add(Mypage_JLabel);
		
		JLabel Client_JLabel = new JLabel("\uD68C\uC6D0\uB2D8");
		Client_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Client_JLabel.setBounds(423, 111, 100, 32);
		Mypage_contentPane.add(Client_JLabel);
		
		JButton Logout_JButton = new JButton("\uB85C\uADF8\uC544\uC6C3");
		Logout_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Logout_JButton.setBounds(497, 29, 129, 43);
		Mypage_contentPane.add(Logout_JButton);
		
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
		
		Content_JTable = new JTable();
		Content_JTable.setBounds(99, 226, 566, 265);
		Mypage_contentPane.add(Content_JTable);
		
		JButton back_JButton = new JButton("\u261C");
		back_JButton.setFont(new Font("굴림", Font.BOLD, 40));
		back_JButton.setBackground(SystemColor.inactiveCaption);
		back_JButton.setBounds(641, 91, 87, 58);
		Mypage_contentPane.add(back_JButton);
		
		try {
			Connection conn = DriverManager.getConnection(Main.url, Main.user, Main.password);
			
			String sql1 = "SELECT name FROM client WHERE id = ?";
			
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, Client.Client_BMS_main.currentUser);

			ResultSet rs = pstmt1.executeQuery();
			
			if(rs.next())
			{
				Name_JTextField = new JTextField();
				Name_JTextField.setEditable(false);
				Name_JTextField.setText(rs.getString(1));
				Name_JTextField.setBounds(280, 108, 131, 35);
				Mypage_contentPane.add(Name_JTextField);
				Name_JTextField.setColumns(10);
			}
			
			pstmt1.close();
			conn.close();
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
		
		back_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Client_BMS_main frame = new Client_BMS_main();
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}

}
