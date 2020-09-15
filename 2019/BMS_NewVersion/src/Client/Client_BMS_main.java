package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Default.Default_BMS_Novel;
import Default.Default_BMS_main;
import Default.Main;

import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Client_BMS_main extends JFrame {
	
	public static String currentUser;
	public static String borrowPrice = "null";
	public static String buyPrice = "null";
	
	private JPanel BMS_main_contentPane;
	private JTextField Search_JTextField;
	private JLabel Title2_JLabel;
	private JLabel Author2_JLabel;
	private JLabel Title1_JLabel;
	private JLabel Author1_JLabel;
	private JLabel Title3_JLabel;
	private JLabel Author3_JLabel;
	private JButton Novel_JButton;
	private JButton Poem_JButton;
	private JButton Humanity_JButton;
	private JButton Comic_JButton;
	private JButton Search_JButton;
	private JButton logout_JButton;
	private JButton mypage_JButton;
	private JButton BookImage2_JButton;
	private JButton BookImage1_JButton;
	private JButton BookImage3_JButton;
	private JTextField Title2_JTextField;
	private JTextField Author2_JTextField;
	private JTextField Title1_JTextField;
	private JTextField Author1_JTextField;
	private JTextField Title3_JTextField;
	private JTextField Author3_JTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_BMS_main frame = new Client_BMS_main();
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
	public Client_BMS_main() {
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
		
		Title2_JLabel = new JLabel("\uC81C\uBAA9");
		Title2_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Title2_JLabel.setBounds(39, 425, 60, 32);
		BMS_main_contentPane.add(Title2_JLabel);
		
		Author2_JLabel = new JLabel("\uC800\uC790");
		Author2_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Author2_JLabel.setBounds(39, 470, 50, 32);
		BMS_main_contentPane.add(Author2_JLabel);
		
		Title1_JLabel = new JLabel("\uC81C\uBAA9");
		Title1_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Title1_JLabel.setBounds(285, 425, 42, 32);
		BMS_main_contentPane.add(Title1_JLabel);
		
		Author1_JLabel = new JLabel("\uC800\uC790");
		Author1_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Author1_JLabel.setBounds(285, 470, 42, 32);
		BMS_main_contentPane.add(Author1_JLabel);
		
		Title3_JLabel = new JLabel("\uC81C\uBAA9");
		Title3_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Title3_JLabel.setBounds(502, 425, 42, 32);
		BMS_main_contentPane.add(Title3_JLabel);
		
		Author3_JLabel = new JLabel("\uC800\uC790");
		Author3_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Author3_JLabel.setBounds(502, 470, 42, 32);
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
							Client_BMS_Novel frame = new Client_BMS_Novel(); //서브메인 창으로 이동
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
							Client_BMS_Poem frame = new Client_BMS_Poem(); //서브메인 창으로 이동
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
							Client_BMS_Humanity frame = new Client_BMS_Humanity(); //서브메인 창으로 이동
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
							Client_BMS_Comic frame = new Client_BMS_Comic(); //서브메인 창으로 이동
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
							Client_BMS_Search frame = new Client_BMS_Search(Search_JTextField.getText());
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		logout_JButton = new JButton("\uB85C\uADF8\uC544\uC6C3");
		logout_JButton.setFont(new Font("굴림", Font.BOLD, 13));
		logout_JButton.setBounds(526, 29, 105, 32);
		BMS_main_contentPane.add(logout_JButton);
		
		logout_JButton.addActionListener(new ActionListener() {
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
		
		mypage_JButton = new JButton("\uB9C8\uC774\uD398\uC774\uC9C0");
		mypage_JButton.setFont(new Font("굴림", Font.BOLD, 13));
		mypage_JButton.setBounds(643, 29, 105, 32);
		BMS_main_contentPane.add(mypage_JButton);
		
		BookImage2_JButton = new JButton(new ImageIcon("img/메밀꽃필무렵.png"));
		BookImage2_JButton.setBounds(90, 242, 155, 168);
		BMS_main_contentPane.add(BookImage2_JButton);
		
		BookImage2_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Default.Main.bookName = Title2_JTextField.getText();
							Client_BMS_detail frame = new Client_BMS_detail();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		BookImage1_JButton = new JButton(new ImageIcon("img/운수좋은날.png"));
		BookImage1_JButton.setBounds(314, 242, 155, 168);
		BMS_main_contentPane.add(BookImage1_JButton);
		
		BookImage1_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Default.Main.bookName = Title1_JTextField.getText();
							Client_BMS_detail frame = new Client_BMS_detail();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		BookImage3_JButton = new JButton(new ImageIcon("img/동백꽃.png"));
		BookImage3_JButton.setBounds(531, 242, 155, 168);
		BMS_main_contentPane.add(BookImage3_JButton);
		
		BookImage3_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Default.Main.bookName = Title3_JTextField.getText();
							Client_BMS_detail frame = new Client_BMS_detail();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});

		
		
		mypage_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Mypage frame = new Mypage(); //마이페이지 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		try {
			Connection conn = DriverManager.getConnection(Main.url, Main.user, Main.password);

			String sql1 = "SELECT title, author, image FROM book WHERE ISBN = 1";
			
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);

			ResultSet rs = pstmt1.executeQuery();
			
			if(rs.next()) {
				Title1_JTextField = new JTextField(rs.getNString(1));
				Title1_JTextField.setEditable(false);
				Title1_JTextField.setColumns(10);
				Title1_JTextField.setBounds(329, 425, 161, 32);
				BMS_main_contentPane.add(Title1_JTextField);
				
				Author1_JTextField = new JTextField(rs.getNString(2));
				Author1_JTextField.setEditable(false);
				Author1_JTextField.setColumns(10);
				Author1_JTextField.setBounds(329, 470, 161, 32);
				BMS_main_contentPane.add(Author1_JTextField);
			}
			
			String sql2 = "SELECT title, author FROM book WHERE ISBN = 2";
			
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			
			rs = pstmt2.executeQuery();
			
			if(rs.next()) {
				Title2_JTextField = new JTextField(rs.getNString(1));
				Title2_JTextField.setEditable(false);
				Title2_JTextField.setBounds(90, 425, 161, 32);
				BMS_main_contentPane.add(Title2_JTextField);
				Title2_JTextField.setColumns(10);
				
				Author2_JTextField = new JTextField(rs.getNString(2));
				Author2_JTextField.setEditable(false);
				Author2_JTextField.setColumns(10);
				Author2_JTextField.setBounds(90, 470, 161, 32);
				BMS_main_contentPane.add(Author2_JTextField);
			}
			
			String sql3 = "SELECT title, author FROM book WHERE ISBN = 3";
			
			PreparedStatement pstmt3 = conn.prepareStatement(sql3);
			rs = pstmt3.executeQuery();
			
			if(rs.next()) {
				Title3_JTextField = new JTextField(rs.getNString(1));
				Title3_JTextField.setEditable(false);
				Title3_JTextField.setColumns(10);
				Title3_JTextField.setBounds(556, 425, 161, 32);
				BMS_main_contentPane.add(Title3_JTextField);
				
				Author3_JTextField = new JTextField(rs.getNString(2));
				Author3_JTextField.setEditable(false);
				Author3_JTextField.setColumns(10);
				Author3_JTextField.setBounds(556, 470, 161, 32);
				BMS_main_contentPane.add(Author3_JTextField);
			}
			
			pstmt1.close();
			pstmt2.close();
			pstmt3.close();
			conn.close();
			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
