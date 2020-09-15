package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Default.Default_BMS_Comic;
import Default.Default_BMS_Search;
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
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class Client_BMS_Comic extends JFrame {

	private JPanel BMS_sub_contentPane;
	private JTextField Search_JTextField;
	private JTextField Title1_JTextField;
	private JTextField Author1_JTextField;
	private JTextField Title2_JTextField;
	private JTextField Author2_JTextField;
	private JTextField Title3_JTextField;
	private JTextField Author3_JTextField;

	/**


	/**
	 * Create the frame.
	 */
	public Client_BMS_Comic() {
		setTitle("BMS_sub");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		BMS_sub_contentPane = new JPanel();
		BMS_sub_contentPane.setBackground(SystemColor.desktop);
		BMS_sub_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BMS_sub_contentPane);
		BMS_sub_contentPane.setLayout(null);
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		icon_JButton.setBounds(32, 20, 161, 32);
		BMS_sub_contentPane.add(icon_JButton);
		
		icon_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Client_BMS_main frame = new Client_BMS_main(); //서브메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		Search_JTextField = new JTextField();
		Search_JTextField.setColumns(10);
		Search_JTextField.setBounds(205, 35, 218, 32);
		BMS_sub_contentPane.add(Search_JTextField);
		
		JButton Search_JButton = new JButton("\uAC80\uC0C9");
		Search_JButton.setFont(new Font("굴림", Font.PLAIN, 12));
		Search_JButton.setBounds(425, 35, 60, 32);
		BMS_sub_contentPane.add(Search_JButton);
		
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
		
		JButton Logout_JButton = new JButton("\uB85C\uADF8\uC544\uC6C3");
		Logout_JButton.setFont(new Font("굴림", Font.BOLD, 13));
		Logout_JButton.setBounds(501, 34, 96, 32);
		BMS_sub_contentPane.add(Logout_JButton);
		
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
		
		JButton Mypage_JButton = new JButton("\uB9C8\uC774\uD398\uC774\uC9C0");
		Mypage_JButton.setFont(new Font("굴림", Font.BOLD, 13));
		Mypage_JButton.setBounds(600, 34, 111, 32);
		BMS_sub_contentPane.add(Mypage_JButton);
		
		Mypage_JButton.addActionListener(new ActionListener() {
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
		
		JButton Novel_JButton = new JButton("\uC18C\uC124");
		Novel_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Novel_JButton.setBounds(51, 97, 129, 43);
		BMS_sub_contentPane.add(Novel_JButton);
		
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
		
		JButton Poem_JButton = new JButton("\uC2DC");
		Poem_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Poem_JButton.setBounds(224, 97, 129, 43);
		BMS_sub_contentPane.add(Poem_JButton);
		
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
		
		JButton Humanity_JButton = new JButton("\uC778\uBB38");
		Humanity_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Humanity_JButton.setBounds(401, 97, 129, 43);
		BMS_sub_contentPane.add(Humanity_JButton);
		
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
		
		JButton Comic_JButton = new JButton("\uB9CC\uD654");
		Comic_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Comic_JButton.setBounds(571, 97, 129, 43);
		BMS_sub_contentPane.add(Comic_JButton);
		
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
		
		JScrollBar Content_JScrollBar = new JScrollBar();
		Content_JScrollBar.setBounds(683, 204, 17, 318);
		BMS_sub_contentPane.add(Content_JScrollBar);
		
		JPanel Content_JPanel = new JPanel();
		Content_JPanel.setBounds(51, 204, 632, 318);
		BMS_sub_contentPane.add(Content_JPanel);
		Content_JPanel.setLayout(null);
		
		JLabel Title1_JLabel = new JLabel("\uC81C\uBAA9");
		Title1_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Title1_JLabel.setBounds(12, 231, 51, 32);
		Content_JPanel.add(Title1_JLabel);
		
		JLabel Author1_JLabel = new JLabel("\uC800\uC790");
		Author1_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Author1_JLabel.setBounds(12, 276, 42, 32);
		Content_JPanel.add(Author1_JLabel);
		
		JLabel Title2_JLabel = new JLabel("\uC81C\uBAA9");
		Title2_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Title2_JLabel.setBounds(208, 231, 51, 32);
		Content_JPanel.add(Title2_JLabel);
		
		JLabel Author2_JLabel = new JLabel("\uC800\uC790");
		Author2_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Author2_JLabel.setBounds(208, 276, 51, 32);
		Content_JPanel.add(Author2_JLabel);
		
		JLabel Title3_JLabel = new JLabel("\uC81C\uBAA9");
		Title3_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Title3_JLabel.setBounds(414, 231, 51, 32);
		Content_JPanel.add(Title3_JLabel);
		
		JLabel Author3_JLabel = new JLabel("\uC800\uC790");
		Author3_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Author3_JLabel.setBounds(414, 276, 51, 32);
		Content_JPanel.add(Author3_JLabel);
		
		JButton BookImage1_JButton = new JButton(new ImageIcon("img/대학일기.png"));
		BookImage1_JButton.setBounds(40, 25, 146, 184);
		Content_JPanel.add(BookImage1_JButton);
		
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
		
		JButton BookImage2_JButton = new JButton(new ImageIcon("img/오늘도사랑스럽개.png"));
		BookImage2_JButton.setBounds(244, 25, 146, 184);
		Content_JPanel.add(BookImage2_JButton);
		
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
		
		JButton BookImage3_JButton = new JButton(new ImageIcon("img/바른연애길잡이.png"));
		BookImage3_JButton.setBounds(452, 25, 146, 184);
		Content_JPanel.add(BookImage3_JButton);
		
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
		
		Connection conn;
		String sql;
		PreparedStatement pstmt;
		ResultSet rs;
		
		try {
			conn = DriverManager.getConnection(Main.url, Main.user, Main.password);
			sql = "SELECT title, author, ISBN FROM book WHERE kind = '만화'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				Title1_JTextField = new JTextField(rs.getString(1));
				Title1_JTextField.setEditable(false);
				Title1_JTextField.setBounds(68, 231, 128, 32);
				Content_JPanel.add(Title1_JTextField);
				Title1_JTextField.setColumns(10);
				
				Author1_JTextField = new JTextField(rs.getString(2));
				Author1_JTextField.setEditable(false);
				Author1_JTextField.setColumns(10);
				Author1_JTextField.setBounds(68, 276, 128, 32);
				Content_JPanel.add(Author1_JTextField);
			}
			
			sql = "SELECT title, author, ISBN FROM book WHERE kind = '만화' AND ISBN != ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rs.getInt(3));
			int tmp = rs.getInt(3);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				Title2_JTextField = new JTextField(rs.getString(1));
				Title2_JTextField.setEditable(false);
				Title2_JTextField.setColumns(10);
				Title2_JTextField.setBounds(274, 231, 128, 32);
				Content_JPanel.add(Title2_JTextField);	
				
				Author2_JTextField = new JTextField(rs.getString(2));
				Author2_JTextField.setEditable(false);
				Author2_JTextField.setColumns(10);
				Author2_JTextField.setBounds(274, 276, 128, 32);
				Content_JPanel.add(Author2_JTextField);
			}
			
			sql = "SELECT title, author, ISBN FROM book WHERE kind = '만화' AND ISBN != ? AND ISBN != ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tmp);
			pstmt.setInt(2, rs.getInt(3));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Title3_JTextField = new JTextField(rs.getString(1));
				Title3_JTextField.setEditable(false);
				Title3_JTextField.setColumns(10);
				Title3_JTextField.setBounds(477, 231, 128, 32);
				Content_JPanel.add(Title3_JTextField);
				
				Author3_JTextField = new JTextField(rs.getString(2));
				Author3_JTextField.setEditable(false);
				Author3_JTextField.setColumns(10);
				Author3_JTextField.setBounds(477, 276, 128, 32);
				Content_JPanel.add(Author3_JTextField);
				
			}
			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}

		if(Title1_JTextField.getText().equals("대학일기"))
		{
			BookImage1_JButton = new JButton(new ImageIcon("img/대학일기.png"));
		} 
		else if(Title1_JTextField.getText().equals("오늘도 사랑스럽 개"))
		{
			BookImage1_JButton = new JButton(new ImageIcon("img/오늘도사랑스럽개.png"));
		} 
		else {
			BookImage1_JButton = new JButton(new ImageIcon("img/바른연애길잡이.png"));
		}
		
		if(Title2_JTextField.getText().equals("대학일기"))
		{
			BookImage2_JButton = new JButton(new ImageIcon("img/대학일기.png"));
		} 
		else if(Title2_JTextField.getText().equals("오늘도사랑스럽개"))
		{
			BookImage2_JButton = new JButton(new ImageIcon("img/오늘도사랑스럽개.png"));
		} 
		else
		{
			BookImage2_JButton = new JButton(new ImageIcon("img/바른연애길잡이.png"));
		}
		
		if(Title3_JTextField.getText().equals("대학일기"))
		{
			BookImage3_JButton = new JButton(new ImageIcon("img/대학일기.png"));
		} 
		else if(Title3_JTextField.getText().equals("오늘도사랑스럽개"))
		{
			BookImage3_JButton = new JButton(new ImageIcon("img/오늘도사랑스럽개.png"));
		}
		else
		{
			BookImage3_JButton = new JButton(new ImageIcon("img/바른연애길잡이.png"));
		}
		
		
		JLabel Kind_JLabel = new JLabel("\uB9CC\uD654");
		Kind_JLabel.setFont(new Font("굴림", Font.BOLD, 25));
		Kind_JLabel.setBounds(354, 150, 57, 28);
		BMS_sub_contentPane.add(Kind_JLabel);
	}

}
