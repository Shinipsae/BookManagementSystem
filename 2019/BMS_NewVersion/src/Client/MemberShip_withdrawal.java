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
		Withdrawal_JLabel.setFont(new Font("����", Font.BOLD, 30));
		Withdrawal_JLabel.setBounds(60, 61, 129, 58);
		Withdrawal_contentPane.add(Withdrawal_JLabel);
		
		JLabel Id_JLabel = new JLabel("\uC544\uC774\uB514");
		Id_JLabel.setFont(new Font("����", Font.BOLD, 25));
		Id_JLabel.setBounds(138, 139, 108, 50);
		Withdrawal_contentPane.add(Id_JLabel);
		
		Id_JTextField = new JTextField();
		Id_JTextField.setFont(new Font("����", Font.PLAIN, 20));
		Id_JTextField.setColumns(10);
		Id_JTextField.setBounds(138, 199, 460, 50);
		Withdrawal_contentPane.add(Id_JTextField);
		
		JLabel Password_JLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		Password_JLabel.setFont(new Font("����", Font.BOLD, 25));
		Password_JLabel.setBounds(138, 271, 108, 50);
		Withdrawal_contentPane.add(Password_JLabel);
		
		Password_JTextField = new JTextField();
		Password_JTextField.setFont(new Font("����", Font.PLAIN, 20));
		Password_JTextField.setColumns(10);
		Password_JTextField.setBounds(138, 334, 460, 50);
		Withdrawal_contentPane.add(Password_JTextField);
		
		JButton back_JButton = new JButton("\u261C");
		back_JButton.setFont(new Font("����", Font.BOLD, 40));
		back_JButton.setBackground(SystemColor.inactiveCaption);
		back_JButton.setBounds(642, 26, 87, 58);
		Withdrawal_contentPane.add(back_JButton);
		
		back_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// �ڷΰ��� ��ư�� ������ 
							Login frame = new Login(); //�α��� â���� �̵�
							frame.setVisible(true);
							dispose(); //�� â�� ������
							
						} catch (Exception e) {
							e.printStackTrace(); // ���н� �����޼��� ���
							
						}
					} //end of run
				});
			}
		});
		
		JButton withdraw_JButton = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		withdraw_JButton.setFont(new Font("����", Font.BOLD, 20));
		withdraw_JButton.setBounds(271, 461, 216, 50);
		Withdrawal_contentPane.add(withdraw_JButton);
		
		withdraw_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = Id_JTextField.getText(); // �Է¹��� �� ������ ����
				String pw = Password_JTextField.getText(); // �Է¹��� �� ������ ����
				
				try {
					deleteCheck(id,pw); //ȸ������ ���� 
					Login frame = new Login();
					frame.setVisible(true); //LogIn ȭ������  �̵�
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
						try { //�ΰ� ��ư�� ������
							Default_BMS_main frame = new Default_BMS_main(); //���� â���� �̵�
							frame.setVisible(true);
							dispose(); //�� â�� ������
						} catch (Exception e) {
							e.printStackTrace(); //���н� �����޼��� ���
							
						}
					} //end of run
				});
				
			}
		});	
		
	}
	
	private void deleteCheck(String id, String password) throws SQLException { //ȸ������ ���� �޼���
		
		PreparedStatement pstmt = null; 
			String sql = "";
			ResultSet rs = null;
			
			sql = "SELECT password FROM client WHERE id = ?"; //client���� password�� id�� ���� ������
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); //����ǥ�� ������
			rs=(ResultSet) pstmt.executeQuery();
			
		try {
			if(rs.next()) {
				rs.getString(1);
				if(password.contentEquals(password)) {
					sql="DELETE FROM client WHERE id =?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id); //����ǥ�� ������
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "���������� ȸ.��.Ż.��. �Ǿ����ϴ� ^^.");
					dispose();
					Default_BMS_main frame = new Default_BMS_main();
					frame.setVisible(true);	 //ȸ������ ȭ������ �̵� 
				}else { //��й�ȣ�� Ʋ���� ���
					JOptionPane.showMessageDialog(null, "��й�ȣ Ʋ��");
				}
			}else { //�ش� id�� ���� ���
				JOptionPane.showMessageDialog(null, "id�� �����ϴ�");
			}
		
			}catch(Exception e) {
				
				System.out.println("ȸ����������");
				e.printStackTrace();
				
			}finally {
				
				   if(rs!=null)try{rs.close();}catch(SQLException ex){}
				   if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
				   if(conn!=null)try{conn.close();}catch(SQLException ex){}
				   
			}
}//end of deleteCheck
	

}
