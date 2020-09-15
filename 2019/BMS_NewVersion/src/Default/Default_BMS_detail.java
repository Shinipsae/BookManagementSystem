package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.Client_BMS_Comic;
import Client.Client_BMS_Humanity;
import Client.Client_BMS_Novel;
import Client.Client_BMS_Poem;
import Client.Client_BMS_main;

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
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Default_BMS_detail extends JFrame {

	private JPanel BMS_detail_contentPane;
	private JTextField Search_JTextField;
	private JButton Bookphoto_JButton;
	private JTextField Title_JTextField;
	private JTextField Author_JTextField;
	private JTextField Plot_JTextField;
	private JTextField Borrowprice_JTextField;
	private JTextField Buyprice_JTextField;
	
	public Default_BMS_detail() {
		setTitle("BMS_detail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		BMS_detail_contentPane = new JPanel();
		BMS_detail_contentPane.setBackground(SystemColor.desktop);
		BMS_detail_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BMS_detail_contentPane);
		BMS_detail_contentPane.setLayout(null);
		
		JButton Novel_JButton = new JButton("소설");
		Novel_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Novel_JButton.setBounds(71, 97, 129, 43);
		BMS_detail_contentPane.add(Novel_JButton);
		
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
		
		JButton Poem_JButton = new JButton("시");
		Poem_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Poem_JButton.setBounds(244, 97, 129, 43);
		BMS_detail_contentPane.add(Poem_JButton);
		
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
		
		JButton Humanity_JButton = new JButton("인문");
		Humanity_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Humanity_JButton.setBounds(421, 97, 129, 43);
		BMS_detail_contentPane.add(Humanity_JButton);
		
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
		
		JButton Comic_JButton = new JButton("만화");
		Comic_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Comic_JButton.setBounds(591, 97, 129, 43);
		BMS_detail_contentPane.add(Comic_JButton);
		
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
		
		Search_JTextField = new JTextField();
		Search_JTextField.setColumns(10);
		Search_JTextField.setBounds(213, 32, 218, 32);
		BMS_detail_contentPane.add(Search_JTextField);
		
		JButton Search_JButton = new JButton("검색");
		Search_JButton.setBounds(433, 32, 64, 32);
		BMS_detail_contentPane.add(Search_JButton);
		
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

		JLabel Title_JLabel = new JLabel("제목");
		Title_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Title_JLabel.setBounds(31, 453, 59, 32);
		BMS_detail_contentPane.add(Title_JLabel);
		
		Connection conn;
		String sql;
		PreparedStatement pstmt;
		ResultSet rs;
		
		try {
			conn = DriverManager.getConnection(Main.url, Main.user, Main.password);
			sql = "SELECT * FROM book WHERE title = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Default.Main.bookName);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				Title_JTextField = new JTextField(rs.getString(2));
				Title_JTextField.setBounds(102, 453, 188, 32);
				Title_JTextField.setEditable(false);
				BMS_detail_contentPane.add(Title_JTextField);
				
				Author_JTextField = new JTextField(rs.getString(3));
				Author_JTextField.setBounds(102, 498, 188, 32);
				Author_JTextField.setEditable(false);
				BMS_detail_contentPane.add(Author_JTextField);
				
				Borrowprice_JTextField = new JTextField(rs.getString(5));
				Borrowprice_JTextField.setBounds(470, 342, 156, 32);
				Borrowprice_JTextField.setEditable(false);
				BMS_detail_contentPane.add(Borrowprice_JTextField);
				
				Buyprice_JTextField = new JTextField(rs.getString(6));
				Buyprice_JTextField.setBounds(470, 417, 156, 32);
				Buyprice_JTextField.setEditable(false);
				BMS_detail_contentPane.add(Buyprice_JTextField);
				
				Plot_JTextField = new JTextField(rs.getString(7));
				Plot_JTextField.setBounds(367, 213, 318, 104);
				Plot_JTextField.setEditable(false);
				BMS_detail_contentPane.add(Plot_JTextField);
			}
			
			pstmt.close();
			conn.close();
			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		if(Title_JTextField.getText().equals("운수좋은날"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/운수좋은날.png"));
		} 
		else if(Title_JTextField.getText().equals("메밀꽃필무렵"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/메밀꽃필무렵.png"));
		} 
		else if(Title_JTextField.getText().equals("동백꽃"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/동백꽃.png"));
		} 
		else if(Title_JTextField.getText().equals("별헤는밤"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/별헤는밤.png"));
		} 
		else if(Title_JTextField.getText().equals("님의침묵"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/님의침묵.png"));
		} 
		else if(Title_JTextField.getText().equals("서시"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/서시.png"));
		} 
		else if(Title_JTextField.getText().equals("Java의 정석"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/Java의정석.png"));
		} 
		else if(Title_JTextField.getText().equals("혼자 공부하는 자바"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/혼자공부하는자바.png"));
		} 
		else if(Title_JTextField.getText().equals("이것이 자바다"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/이것이자바다.png"));
		} 
		else if(Title_JTextField.getText().equals("대학일기"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/대학일기.png"));
		} 
		else if(Title_JTextField.getText().equals("오늘도 사랑스럽 개"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/오늘도사랑스럽개.png"));
		} 
		else if(Title_JTextField.getText().equals("바른 연애 길잡이"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/바른연애길잡이.png"));
		} 
		
		Bookphoto_JButton.setBounds(57, 198, 212, 235);
		BMS_detail_contentPane.add(Bookphoto_JButton);
		
		JLabel Author_JLabel = new JLabel("저자");
		Author_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Author_JLabel.setBounds(31, 498, 59, 32);
		BMS_detail_contentPane.add(Author_JLabel);

		JLabel Borrowprice_JLabel = new JLabel("대여가 :");
		Borrowprice_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Borrowprice_JLabel.setBounds(379, 342, 79, 32);
		BMS_detail_contentPane.add(Borrowprice_JLabel);
		
		JLabel borrow_won_JLabel = new JLabel("원");
		borrow_won_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		borrow_won_JLabel.setBounds(646, 342, 39, 32);
		BMS_detail_contentPane.add(borrow_won_JLabel);
		
		JLabel Buyprice_JLabel = new JLabel("구매가 :");
		Buyprice_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Buyprice_JLabel.setBounds(379, 417, 79, 32);
		BMS_detail_contentPane.add(Buyprice_JLabel);
		
		JLabel Buy_won_JLabel = new JLabel("원");
		Buy_won_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Buy_won_JLabel.setBounds(646, 417, 39, 32);
		BMS_detail_contentPane.add(Buy_won_JLabel);
		
		JButton Borrow_JButton = new JButton("대여하기");
		Borrow_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Borrow_JButton.setBounds(439, 482, 129, 43);
		BMS_detail_contentPane.add(Borrow_JButton);
		
		Borrow_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JOptionPane.showMessageDialog(null,"로그인 후 이용가능한 서비스 입니다. \n 로그인 창으로 이동합니다.");
							dispose();
							Login frame = new Login();
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton Buy_JButton = new JButton("구매하기");
		Buy_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Buy_JButton.setBounds(591, 482, 129, 43);
		BMS_detail_contentPane.add(Buy_JButton);
		
		Buy_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JOptionPane.showMessageDialog(null,"로그인 후 이용가능한 서비스 입니다. \n 로그인 창으로 이동합니다.");
							dispose();
							Login frame = new Login();
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JLabel Week2_JLabel = new JLabel("※대여일을 기준으로 2주간 볼 수 있습니다.");
		Week2_JLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		Week2_JLabel.setBounds(395, 384, 325, 15);
		BMS_detail_contentPane.add(Week2_JLabel);
		
		JButton back_JButton = new JButton("☜");
		back_JButton.setFont(new Font("굴림", Font.BOLD, 40));
		back_JButton.setBackground(SystemColor.inactiveCaption);
		back_JButton.setBounds(646, 22, 87, 58);
		BMS_detail_contentPane.add(back_JButton);
		
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
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		icon_JButton.setBounds(32, 20, 161, 32);
		BMS_detail_contentPane.add(icon_JButton);
		
		icon_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Default_BMS_main frame = new Default_BMS_main(); //서브메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		JLabel Plot_JLabel = new JLabel("\uC904\uAC70\uB9AC");
		Plot_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Plot_JLabel.setBounds(367, 179, 79, 24);
		BMS_detail_contentPane.add(Plot_JLabel);
	}

}