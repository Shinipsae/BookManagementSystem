package Manager;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.Client_BMS_main;
import Default.DBManager;
import Default.Default_BMS_main;
import Default.JoinUs;
import Default.Login;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class Login_manager extends JFrame {

	private JPanel Login_contentPane;
	String thisLocation;
	private JTextField Id_JTextField;
	private JTextField Password_JTextField;
	private JTextField Attributenum_JTextField;
	Connection conn;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Login_manager() {
		
		conn = DBManager.getConnection();
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		Login_contentPane = new JPanel();
		Login_contentPane.setBackground(SystemColor.desktop);
		Login_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Login_contentPane);
		Login_contentPane.setLayout(null);
		
		JLabel Login_JLabel = new JLabel("\uB85C\uADF8\uC778");
		Login_JLabel.setFont(new Font("굴림", Font.BOLD, 30));
		Login_JLabel.setBounds(64, 63, 129, 58);
		Login_contentPane.add(Login_JLabel);
		
		JLabel Id_JLabel = new JLabel("\uC544\uC774\uB514");
		Id_JLabel.setFont(new Font("굴림", Font.BOLD, 25));
		Id_JLabel.setBounds(39, 277, 108, 50);
		Login_contentPane.add(Id_JLabel);
		
		Id_JTextField = new JTextField();
		Id_JTextField.setFont(new Font("굴림", Font.PLAIN, 20));
		Id_JTextField.setBounds(145, 279, 415, 50);
		Login_contentPane.add(Id_JTextField);
		Id_JTextField.setColumns(10);
		
		JLabel Password_JLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		Password_JLabel.setFont(new Font("굴림", Font.BOLD, 25));
		Password_JLabel.setBounds(27, 384, 108, 50);
		Login_contentPane.add(Password_JLabel);
		
		Password_JTextField = new JTextField();
		Password_JTextField.setFont(new Font("굴림", Font.PLAIN, 20));
		Password_JTextField.setColumns(10);
		Password_JTextField.setBounds(145, 386, 415, 50);
		Login_contentPane.add(Password_JTextField);
		
		JButton back_JButton = new JButton("\u261C");
		back_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		back_JButton.setBackground(SystemColor.inactiveCaption);
		back_JButton.setFont(new Font("굴림", Font.BOLD, 40));
		back_JButton.setBounds(636, 31, 87, 58);
		Login_contentPane.add(back_JButton);
		
		back_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	//back 버튼을 누르면 
							Login frame = new Login(); 
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		JButton Login_JButton = new JButton("\uB85C\uADF8\uC778");
		Login_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Login_JButton.setBounds(591, 150, 97, 309);
		Login_contentPane.add(Login_JButton);
		
		Login_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = Id_JTextField.getText();
				String password = Password_JTextField.getText();
				
				try {
					loginCheck(id,password); //아이디 비밀번호 확인
					Manager.Manager_BMS_main.currentManager = id;
					dispose(); //이전 창 없어짐
					
				} catch (SQLException e1) {
					e1.printStackTrace(); //실패시 오류메세지 출력
				}
				
			}
		}); 
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.setBounds(32, 20, 161, 32);
		Login_contentPane.add(icon_JButton);
		
		icon_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	//back 버튼을 누르면 
							Default_BMS_main frame = new Default_BMS_main(); 
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		JLabel Attributenum_JLabel = new JLabel("\uACE0\uC720\uBC88\uD638");
		Attributenum_JLabel.setFont(new Font("굴림", Font.BOLD, 25));
		Attributenum_JLabel.setBounds(27, 172, 108, 50);
		Login_contentPane.add(Attributenum_JLabel);
		
		Attributenum_JTextField = new JTextField();
		Attributenum_JTextField.setFont(new Font("굴림", Font.PLAIN, 20));
		Attributenum_JTextField.setColumns(10);
		Attributenum_JTextField.setBounds(145, 174, 415, 50);
		Login_contentPane.add(Attributenum_JTextField);
		
		JLabel lblNewLabel = new JLabel("(Management Version)");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(217, 20, 185, 32);
		Login_contentPane.add(lblNewLabel);
		
	}
	
	private void loginCheck(String id, String password) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	     String sjoinID = id;
		 String sjoinPS = password;
		 String attributenum;
		 
		 String SQL = "SELECT * FROM manager WHERE id=? and password= ?"; //client DB연결하여 아이디와 비밀번호 확인
		 pstmt = conn.prepareStatement(SQL);
		 
		 pstmt.setString(1, sjoinID);
		 pstmt.setString(2, sjoinPS);
		 rs = pstmt.executeQuery();
		 
		 if(rs.next()) {
			 clearText(); // 아이디와 비밀번호가 일치할 경우
			 if(Attributenum_JTextField.getText().equals("asdf")) {
				 JOptionPane.showMessageDialog(null, "정상적으로 로그인 되었습니다."); //완료 창 띄움
			     Manager_BMS_main frame = new  Manager_BMS_main();
				 frame.setVisible(true);
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "고유번호를 다시 확인해주세요."); 
				 Login_manager frame = new Login_manager();
				 frame.setVisible(true);
			 }
		 } else { //아이디와 비밀번호가 일치하지 않을 경우
			 clearText();
			 JOptionPane.showMessageDialog(null, "아이디, 비밀번호를 다시 확인해주세요."); 
			 Login_manager frame = new Login_manager();
			 frame.setVisible(true);
		 }
		 
		 pstmt.close();
		 rs.close();
		 conn.close();
		 
	} //end of loginCheck

	private void clearText() {
		Id_JTextField.setText("");
		Password_JTextField.setText("");
	} //end of clearText


}
