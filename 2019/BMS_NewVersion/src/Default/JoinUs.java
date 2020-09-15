package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Default.Main;
import Default.Login;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

public class JoinUs extends JFrame {

	private JPanel JoinUs_contentPane;
	private JTextField Name_JTextField;
	private JTextField Id_JTextField;
	private JTextField Password_JTextField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JoinUs() {
		setTitle("JoinUs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		JoinUs_contentPane = new JPanel();
		JoinUs_contentPane.setBackground(SystemColor.desktop);
		JoinUs_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JoinUs_contentPane);
		JoinUs_contentPane.setLayout(null);
		
		JLabel JoinUs_JLabel = new JLabel("\uD68C\uC6D0\uC815\uBCF4\uB97C \uC785\uB825\uD558\uC138\uC694.");
		JoinUs_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		JoinUs_JLabel.setBounds(62, 68, 363, 59);
		JoinUs_contentPane.add(JoinUs_JLabel);
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.setBounds(32, 20, 161, 32);
		JoinUs_contentPane.add(icon_JButton);
		
		JLabel Name_JLabel = new JLabel("\uC774\uB984");
		Name_JLabel.setFont(new Font("굴림", Font.BOLD, 30));
		Name_JLabel.setBounds(73, 177, 90, 59);
		JoinUs_contentPane.add(Name_JLabel);
		
		JLabel Id_JLabel = new JLabel("\uC544\uC774\uB514");
		Id_JLabel.setFont(new Font("굴림", Font.BOLD, 30));
		Id_JLabel.setBounds(73, 259, 120, 59);
		JoinUs_contentPane.add(Id_JLabel);
		
		JLabel Password_JLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		Password_JLabel.setFont(new Font("굴림", Font.BOLD, 30));
		Password_JLabel.setBounds(74, 347, 143, 59);
		JoinUs_contentPane.add(Password_JLabel);
		
		Name_JTextField = new JTextField();
		Name_JTextField.setBounds(229, 177, 390, 59);
		JoinUs_contentPane.add(Name_JTextField);
		Name_JTextField.setColumns(10);
		
		Id_JTextField = new JTextField();
		Id_JTextField.setColumns(10);
		Id_JTextField.setBounds(228, 265, 391, 59);
		JoinUs_contentPane.add(Id_JTextField);
		
		Password_JTextField = new JTextField();
		Password_JTextField.setColumns(10);
		Password_JTextField.setBounds(229, 353, 390, 59);
		JoinUs_contentPane.add(Password_JTextField);
		
		JButton JoinUs_JButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		JoinUs_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		JoinUs_JButton.setBounds(259, 462, 216, 50);
		JoinUs_contentPane.add(JoinUs_JButton);
		
		JoinUs_JButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {				
					String sql = "INSERT INTO client ( name , id , password ) VALUES ( ? , ? , ? )"; //client에 이름, 아이디, 비밀번호 값을 넣음
					Connection conn = DriverManager.getConnection(Main.url, Main.user, Main.password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, Name_JTextField.getText()); //이름
					pstmt.setString(2, Id_JTextField.getText()); //아이디
					pstmt.setString(3, Password_JTextField.getText()); //비밀번호					
					pstmt.executeUpdate();		
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다. \n 로그인 후 서비스 이용 가능합니다."); //회원가입 완료시
					dispose();
					Login frame = new Login();
					frame.setVisible(true);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "아이디가 중복되었습니다. \n 다른 아이디로 다시 시도해주세요."); //회원가입 완료시
					dispose();
					JoinUs frame = new JoinUs();
					frame.setVisible(true);
				}
			} //end of actionPerformed

		});
		
		JButton back_JButton = new JButton("\u261C");
		back_JButton.setFont(new Font("굴림", Font.BOLD, 40));
		back_JButton.setBackground(SystemColor.inactiveCaption);
		back_JButton.setBounds(634, 45, 87, 58);
		JoinUs_contentPane.add(back_JButton);
		
		back_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Default_BMS_main frame = new Default_BMS_main();
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
