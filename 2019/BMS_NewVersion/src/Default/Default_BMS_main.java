package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Default_BMS_main extends JFrame {
	
	private JPanel BMS_main_contentPane;
	private JTextField Search_JTextField;
	private JButton Joinus_JButton;

	private JLabel Title1_JLabel;
	private JLabel Title2_JLabel;
	private JLabel Title3_JLabel;
	private JLabel Author1_JLabel;
	private JLabel Author2_JLabel;
	private JLabel Author3_JLabel;
	
	private JTextField Title1_JTextField;
	private JTextField Title2_JTextField;
	private JTextField Title3_JTextField;
	private JTextField Author1_JTextField;
	private JTextField Author2_JTextField;
	private JTextField Author3_JTextField;
	
	private JButton Novel_JButton;
	private JButton Poem_JButton;
	private JButton Humanity_JButton;
	private JButton Comic_JButton;
	private JButton Search_JButton;
	private JButton Login_JButton;
	private JButton Image2_JButton;
	private JButton Image1_JButton;
	private JButton Image3_JButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Default_BMS_main frame = new Default_BMS_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Default_BMS_main() {
		setTitle("BMS_main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		BMS_main_contentPane = new JPanel();
		BMS_main_contentPane.setBackground(SystemColor.desktop);
		BMS_main_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BMS_main_contentPane);
		BMS_main_contentPane.setLayout(null);
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		icon_JButton.setBounds(32, 20, 161, 32);
		BMS_main_contentPane.add(icon_JButton);
		
		Search_JTextField = new JTextField();
		Search_JTextField.setBounds(213, 30, 218, 32);
		BMS_main_contentPane.add(Search_JTextField);
		Search_JTextField.setColumns(10);
		
		Joinus_JButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		Joinus_JButton.setFont(new Font("굴림", Font.BOLD, 13));
		Joinus_JButton.setBounds(512, 29, 106, 32);
		BMS_main_contentPane.add(Joinus_JButton);
		
		Joinus_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	//Join Us 버튼을 누르면 
							JoinUs frame = new JoinUs(); //회원가입 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		JLabel BestSeller_JLabel = new JLabel("\uC624\uB298\uC758 \uBCA0\uC2A4\uD2B8\uC140\uB7EC");
		BestSeller_JLabel.setFont(new Font("굴림", Font.BOLD, 25));
		BestSeller_JLabel.setBounds(285, 148, 226, 50);
		BMS_main_contentPane.add(BestSeller_JLabel);
		
		JLabel Best1_JLabel = new JLabel("Best 1");
		Best1_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Best1_JLabel.setBounds(357, 200, 86, 32);
		BMS_main_contentPane.add(Best1_JLabel);
		
		JLabel Best2_JLabel = new JLabel("Best 2");
		Best2_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Best2_JLabel.setBounds(141, 200, 86, 32);
		BMS_main_contentPane.add(Best2_JLabel);
		
		JLabel Best3_JLabel = new JLabel("Best 3");
		Best3_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Best3_JLabel.setBounds(577, 200, 86, 32);
		BMS_main_contentPane.add(Best3_JLabel);


		try {
			Connection conn = DriverManager.getConnection(Main.url, Main.user, Main.password);

			String sql1 = "SELECT title, author, image FROM book WHERE ISBN = 1";
			
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);

			ResultSet rs = pstmt1.executeQuery();
			
			if(rs.next())
			{
				Title1_JTextField = new JTextField(rs.getNString(1));
				Title1_JTextField.setEditable(false);
				Title1_JTextField.setBounds(341, 425, 147, 32);
				BMS_main_contentPane.add(Title1_JTextField);
				
				Author1_JTextField = new JTextField(rs.getNString(2));
				Author1_JTextField.setEditable(false);
				Author1_JTextField.setBounds(341, 470, 147, 32);
				BMS_main_contentPane.add(Author1_JTextField);
			}
			
			String sql2 = "SELECT title, author FROM book WHERE ISBN = 2";
			
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			
			rs = pstmt2.executeQuery();
			if(rs.next())
			{
				Title2_JTextField = new JTextField(rs.getNString(1));
				Title2_JTextField.setEditable(false);
				Title2_JTextField.setBounds(110, 425, 147, 32);
				BMS_main_contentPane.add(Title2_JTextField);
				
				Author2_JTextField = new JTextField(rs.getNString(2));
				Author2_JTextField.setEditable(false);
				Author2_JTextField.setBounds(110, 470, 147, 32);
				BMS_main_contentPane.add(Author2_JTextField);
			}
			
			
			String sql3 = "SELECT title, author FROM book WHERE ISBN = 3";
			
			PreparedStatement pstmt3 = conn.prepareStatement(sql3);
			rs = pstmt3.executeQuery();
			
			if(rs.next())
			{
				Title3_JTextField = new JTextField(rs.getNString(1));
				Title3_JTextField.setEditable(false);
				Title3_JTextField.setBounds(555, 425, 147, 32);
				BMS_main_contentPane.add(Title3_JTextField);
				
				Author3_JTextField = new JTextField(rs.getNString(2));
				Author3_JTextField.setEditable(false);
				Author3_JTextField.setBounds(555, 470, 147, 32);
				BMS_main_contentPane.add(Author3_JTextField);
			}
			
			pstmt1.close();
			pstmt2.close();
			pstmt3.close();
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
		
		Title1_JLabel = new JLabel("\uC81C\uBAA9");
		Title1_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Title1_JLabel.setBounds(285, 425, 218, 32);
		BMS_main_contentPane.add(Title1_JLabel);
		
		Title2_JLabel = new JLabel("\uC81C\uBAA9");
		Title2_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Title2_JLabel.setBounds(39, 425, 218, 32);
		BMS_main_contentPane.add(Title2_JLabel);
		
		Title3_JLabel = new JLabel("\uC81C\uBAA9");
		Title3_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Title3_JLabel.setBounds(502, 425, 218, 32);
		BMS_main_contentPane.add(Title3_JLabel);
		
		Author1_JLabel = new JLabel("\uC800\uC790");
		Author1_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Author1_JLabel.setBounds(285, 470, 218, 32);
		BMS_main_contentPane.add(Author1_JLabel);
		
		Author2_JLabel = new JLabel("\uC800\uC790");
		Author2_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Author2_JLabel.setBounds(39, 470, 218, 32);
		BMS_main_contentPane.add(Author2_JLabel);
		
		Author3_JLabel = new JLabel("\uC800\uC790");
		Author3_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Author3_JLabel.setBounds(502, 470, 218, 32);
		BMS_main_contentPane.add(Author3_JLabel);
		
		Novel_JButton = new JButton("\uC18C\uC124");
		Novel_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Novel_JButton.setBounds(71, 95, 129, 43);
		BMS_main_contentPane.add(Novel_JButton);
		
		Novel_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Default_BMS_Novel frame = new Default_BMS_Novel(); //서브메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		Poem_JButton = new JButton("\uC2DC");
		Poem_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Poem_JButton.setBounds(244, 95, 129, 43);
		BMS_main_contentPane.add(Poem_JButton);
		
		Poem_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Default_BMS_Poem frame = new Default_BMS_Poem(); //서브메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		Humanity_JButton = new JButton("\uC778\uBB38");
		Humanity_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Humanity_JButton.setBounds(421, 95, 129, 43);
		BMS_main_contentPane.add(Humanity_JButton);
		
		Humanity_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Default_BMS_Humanity frame = new Default_BMS_Humanity(); //서브메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		Comic_JButton = new JButton("\uB9CC\uD654");
		Comic_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Comic_JButton.setBounds(591, 95, 129, 43);
		BMS_main_contentPane.add(Comic_JButton);
		
		Comic_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Default_BMS_Comic frame = new Default_BMS_Comic(); //서브메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		Search_JButton = new JButton("\uAC80\uC0C9");
		Search_JButton.setFont(new Font("굴림", Font.PLAIN, 12));
		Search_JButton.setBounds(433, 30, 60, 32);
		BMS_main_contentPane.add(Search_JButton);
		
		Search_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	
							Default_BMS_Search frame = new Default_BMS_Search(Search_JTextField.getText());
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		Login_JButton = new JButton("\uB85C\uADF8\uC778");
		Login_JButton.setFont(new Font("굴림", Font.BOLD, 13));
		Login_JButton.setBounds(630, 29, 102, 32);
		BMS_main_contentPane.add(Login_JButton);
		
		Image2_JButton = new JButton(new ImageIcon("img/메밀꽃필무렵.png"));
		Image2_JButton.setBounds(89, 242, 155, 168);
		BMS_main_contentPane.add(Image2_JButton);
		
		Image2_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Default.Main.bookName = Title2_JTextField.getText(); //추가
							Default_BMS_detail frame = new Default_BMS_detail();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
						}
					} //end of run
				});
			}
		});
		
		Image1_JButton = new JButton(new ImageIcon("img/운수좋은날.png"));
		Image1_JButton.setBounds(313, 242, 155, 168);
		BMS_main_contentPane.add(Image1_JButton);
		
		Image1_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try { // 버튼을 누르면 
							Default.Main.bookName = Title1_JTextField.getText();
							Default_BMS_detail frame = new Default_BMS_detail();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
						}
					} //end of run
				});
			}
		});
		
		Image3_JButton = new JButton(new ImageIcon("img/동백꽃.png"));
		Image3_JButton.setBounds(530, 242, 155, 168);
		BMS_main_contentPane.add(Image3_JButton);
		
		Image3_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Default.Main.bookName = Title3_JTextField.getText(); //추가
							Default_BMS_detail frame = new Default_BMS_detail();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
						}
					} //end of run
				});
			}
		});
		
		Login_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	//로그인 버튼을 누르면 
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
	}
}