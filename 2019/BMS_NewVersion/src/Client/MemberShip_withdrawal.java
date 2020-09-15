package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Default.DBManager;
import Default.Default_BMS_main;
import Default.JoinUs;
import Default.Login;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MemberShip_withdrawal extends JFrame {

	private JPanel Withdrawal_contentPane;
	private JTextField Id_JTextField;
	private JTextField Password_JTextField;
	Connection conn;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MemberShip_withdrawal() {
		
		conn = DBManager.getConnection();
		
		setTitle("\uD68C\uC6D0\uD0C8\uD1F4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		Withdrawal_contentPane = new JPanel();
		Withdrawal_contentPane.setBackground(SystemColor.desktop);
		Withdrawal_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Withdrawal_contentPane);
		Withdrawal_contentPane.setLayout(null);
		
		JLabel Withdrawal_JLabel = new JLabel("\uD68C\uC6D0\uD0C8\uD1F4");
		Withdrawal_JLabel.setFont(new Font("굴림", Font.BOLD, 30));
		Withdrawal_JLabel.setBounds(60, 61, 129, 58);
		Withdrawal_contentPane.add(Withdrawal_JLabel);
		
		JLabel Id_JLabel = new JLabel("\uC544\uC774\uB514");
		Id_JLabel.setFont(new Font("굴림", Font.BOLD, 25));
		Id_JLabel.setBounds(138, 139, 108, 50);
		Withdrawal_contentPane.add(Id_JLabel);
		
		Id_JTextField = new JTextField();
		Id_JTextField.setFont(new Font("굴림", Font.PLAIN, 20));
		Id_JTextField.setColumns(10);
		Id_JTextField.setBounds(138, 199, 460, 50);
		Withdrawal_contentPane.add(Id_JTextField);
		
		JLabel Password_JLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		Password_JLabel.setFont(new Font("굴림", Font.BOLD, 25));
		Password_JLabel.setBounds(138, 271, 108, 50);
		Withdrawal_contentPane.add(Password_JLabel);
		
		Password_JTextField = new JTextField();
		Password_JTextField.setFont(new Font("굴림", Font.PLAIN, 20));
		Password_JTextField.setColumns(10);
		Password_JTextField.setBounds(138, 334, 460, 50);
		Withdrawal_contentPane.add(Password_JTextField);
		
		JButton back_JButton = new JButton("\u261C");
		back_JButton.setFont(new Font("굴림", Font.BOLD, 40));
		back_JButton.setBackground(SystemColor.inactiveCaption);
		back_JButton.setBounds(642, 26, 87, 58);
		Withdrawal_contentPane.add(back_JButton);
		
		back_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 뒤로가기 버튼을 누르면 
							Login frame = new Login(); //로그인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		JButton withdraw_JButton = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		withdraw_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		withdraw_JButton.setBounds(271, 461, 216, 50);
		Withdrawal_contentPane.add(withdraw_JButton);
		
		withdraw_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = Id_JTextField.getText(); // 입력받은 값 변수에 저장
				String pw = Password_JTextField.getText(); // 입력받은 값 변수에 저장
				
				try {
					deleteCheck(id,pw); //회원정보 삭제 
					Login frame = new Login();
					frame.setVisible(true); //LogIn 화면으로  이동
					dispose();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					
				}
				
			}
		});
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.setBounds(32, 20, 161, 32);
		Withdrawal_contentPane.add(icon_JButton);
		
		icon_JButton.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try { //로고 버튼을 누르면
							Default_BMS_main frame = new Default_BMS_main(); //메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
						} catch (Exception e) {
							e.printStackTrace(); //실패시 오류메세지 출력
							
						}
					} //end of run
				});
				
			}
		});	
		
	}
	
	private void deleteCheck(String id, String password) throws SQLException { //회원정보 삭제 메서드
		
		PreparedStatement pstmt = null; 
			String sql = "";
			ResultSet rs = null;
			
			sql = "SELECT password FROM client WHERE id = ?"; //client에서 password와 id의 값을 가져옴
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); //물음표의 값지정
			rs=(ResultSet) pstmt.executeQuery();
			
		try {
			if(rs.next()) {
				rs.getString(1);
				if(password.contentEquals(password)) {
					sql="DELETE FROM client WHERE id =?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id); //물음표의 값지정
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "정상적으로 회.원.탈.퇴. 되었습니다 ^^.");
					dispose();
					Default_BMS_main frame = new Default_BMS_main();
					frame.setVisible(true);	 //회원가입 화면으로 이동 
				}else { //비밀번호가 틀렸을 경우
					JOptionPane.showMessageDialog(null, "비밀번호 틀림");
				}
			}else { //해당 id가 없을 경우
				JOptionPane.showMessageDialog(null, "id가 없습니다");
			}
		
			}catch(Exception e) {
				
				System.out.println("회원삭제오류");
				e.printStackTrace();
				
			}finally {
				
				   if(rs!=null)try{rs.close();}catch(SQLException ex){}
				   if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
				   if(conn!=null)try{conn.close();}catch(SQLException ex){}
				   
			}
}//end of deleteCheck
	

}
