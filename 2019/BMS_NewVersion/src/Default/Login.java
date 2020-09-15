package Default;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Default.DBManager;
import Client.Client_BMS_main;
import Client.MemberShip_withdrawal;
import Default.JoinUs;
import Manager.Login_manager;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel Login_contentPane;
	String thisLocation;
	private JTextField Id_JTextField;
	private JTextField Password_JTextField;
	Connection conn;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Login() {
		
		conn = DBManager.getConnection();
		
		setTitle("\uB85C\uADF8\uC778");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		Login_contentPane = new JPanel();
		Login_contentPane.setBackground(SystemColor.desktop);
		Login_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Login_contentPane);
		Login_contentPane.setLayout(null);
		
		JLabel Login_JLabel = new JLabel("\uB85C\uADF8\uC778");
		Login_JLabel.setFont(new Font("����", Font.BOLD, 30));
		Login_JLabel.setBounds(64, 63, 129, 58);
		Login_contentPane.add(Login_JLabel);
		
		JLabel Id_JLabel = new JLabel("\uC544\uC774\uB514");
		Id_JLabel.setFont(new Font("����", Font.BOLD, 25));
		Id_JLabel.setBounds(130, 142, 108, 50);
		Login_contentPane.add(Id_JLabel);
		
		Id_JTextField = new JTextField();
		Id_JTextField.setFont(new Font("����", Font.PLAIN, 20));
		Id_JTextField.setBounds(130, 202, 415, 50);
		Login_contentPane.add(Id_JTextField);
		Id_JTextField.setColumns(10);
		
		JLabel Password_JLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		Password_JLabel.setFont(new Font("����", Font.BOLD, 25));
		Password_JLabel.setBounds(130, 274, 108, 50);
		Login_contentPane.add(Password_JLabel);
		
		Password_JTextField = new JTextField();
		Password_JTextField.setFont(new Font("����", Font.PLAIN, 20));
		Password_JTextField.setColumns(10);
		Password_JTextField.setBounds(130, 337, 415, 50);
		Login_contentPane.add(Password_JTextField);
		
		JButton back_JButton = new JButton("\u261C");
		back_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		back_JButton.setBackground(SystemColor.inactiveCaption);
		back_JButton.setFont(new Font("����", Font.BOLD, 40));
		back_JButton.setBounds(636, 31, 87, 58);
		Login_contentPane.add(back_JButton);
		
		back_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Default_BMS_main frame = new Default_BMS_main();
							frame.setVisible(true);
							dispose(); //�� â�� ������
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton Login_JButton = new JButton("\uB85C\uADF8\uC778");
		Login_JButton.setFont(new Font("����", Font.BOLD, 20));
		Login_JButton.setBounds(572, 156, 97, 232);
		Login_contentPane.add(Login_JButton);
		
		Login_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = Id_JTextField.getText();
				String password = Password_JTextField.getText();
				
				try {
					loginCheck(id,password); //���̵� ��й�ȣ Ȯ��
					Client.Client_BMS_main.currentUser = id;
					dispose(); //���� â ������
					
				} catch (SQLException e1) {
					e1.printStackTrace(); //���н� �����޼��� ���
				}
				
			}
		}); 
		
		JButton JoinUs_JButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		JoinUs_JButton.setFont(new Font("����", Font.BOLD, 20));
		JoinUs_JButton.setBounds(446, 461, 129, 43);
		Login_contentPane.add(JoinUs_JButton);
		
		JoinUs_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	//Join Us ��ư�� ������ 
							JoinUs frame = new JoinUs(); //ȸ������ â���� �̵�
							frame.setVisible(true);
							dispose(); //�� â�� ������
							
						} catch (Exception e) {
							e.printStackTrace(); // ���н� �����޼��� ���
							
						}
					} //end of run
				});
			}
		});
		
		JButton Withdrawal_JButton = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		Withdrawal_JButton.setFont(new Font("����", Font.BOLD, 20));
		Withdrawal_JButton.setBounds(612, 461, 129, 43);
		Login_contentPane.add(Withdrawal_JButton);
		
		Withdrawal_JButton.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try { //ȸ��Ż�� ��ư�� ������
							MemberShip_withdrawal frame = new MemberShip_withdrawal(); //ȸ�� Ż�� â���� �̵�
							frame.setVisible(true);
							dispose(); //�� â�� ������
						} catch (Exception e) {
							e.printStackTrace(); //���н� �����޼��� ���
							
						}
					} //end of run
				});
				
			}
		});		
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.setBounds(32, 20, 161, 32);
		Login_contentPane.add(icon_JButton);
		
		icon_JButton.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try { //�ΰ� ��ư�� ������
							Login_manager frame = new Login_manager(); //���� â���� �̵�
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
	
	private void loginCheck(String id, String password) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	     String sjoinID = id;
		 String sjoinPS = password;
		 
		 String SQL = "SELECT * FROM client WHERE id=? and password=?"; //client DB�����Ͽ� ���̵�� ��й�ȣ Ȯ��
		 pstmt = conn.prepareStatement(SQL);
		 
		 pstmt.setString(1, sjoinID);
		 pstmt.setString(2, sjoinPS);
		 rs = pstmt.executeQuery();
		 
		 if(rs.next()) {
			 clearText(); // ���̵�� ��й�ȣ�� ��ġ�� ���
			 JOptionPane.showMessageDialog(null, "���������� �α��� �Ǿ����ϴ�."); //�Ϸ� â ���
		     Client_BMS_main frame = new Client_BMS_main();
			 frame.setVisible(true);
		 } else { //���̵�� ��й�ȣ�� ��ġ���� ���� ���
			 clearText();
			 JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� �ٽ� Ȯ�����ּ���."); 
			 Login frame = new Login();
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
