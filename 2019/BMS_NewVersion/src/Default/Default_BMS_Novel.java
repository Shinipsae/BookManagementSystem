package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class Default_BMS_Novel extends JFrame {
	private JPanel BMS_sub_contentPane;
	private JPanel Content_JPanel;
	
	private JButton Search_JButton;
	private JButton Joinus_JButton;
	private JButton Login_JButton;
	private JButton Novel_JButton;
	private JButton Poem_JButton;
	private JButton Humanity_JButton;
	private JButton Comic_JButton;
	private JButton BookImage1_JButton;
	private JButton BookImage2_JButton;
	private JButton BookImage3_JButton;
	
	private JTextField Search_JTextField;
	private JTextField Title1_JTextField;
	private JTextField Title2_JTextField;
	private JTextField Title3_JTextField;
	private JTextField Author1_JTextField;
	private JTextField Author2_JTextField;
	private JTextField Author3_JTextField;

	public Default_BMS_Novel() {
		setTitle("BMS_sub");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		BMS_sub_contentPane = new JPanel();
		BMS_sub_contentPane.setBackground(SystemColor.desktop);
		BMS_sub_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BMS_sub_contentPane);
		BMS_sub_contentPane.setLayout(null);
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.setBounds(29, 35, 161, 32);
		BMS_sub_contentPane.add(icon_JButton);
		
		icon_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// ��ư�� ������ 
							Default_BMS_main frame = new Default_BMS_main(); //������� â���� �̵�
							frame.setVisible(true);
							dispose(); //�� â�� ������
							
						} catch (Exception e) {
							e.printStackTrace(); // ���н� �����޼��� ���
							
						}
					} //end of run
				});
			}
		});
		
		Search_JTextField = new JTextField();
		Search_JTextField.setColumns(10);
		Search_JTextField.setBounds(205, 35, 218, 32);
		BMS_sub_contentPane.add(Search_JTextField);
		
		Search_JButton = new JButton("�˻�");
		Search_JButton.setFont(new Font("����", Font.PLAIN, 12));
		Search_JButton.setBounds(425, 35, 60, 32);
		BMS_sub_contentPane.add(Search_JButton);
		
		Search_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	
							Default_BMS_Search frame = new Default_BMS_Search(Search_JTextField.getText());
							frame.setVisible(true);
							dispose(); //�� â�� ������
							
						} catch (Exception e) {
							e.printStackTrace(); // ���н� �����޼��� ���
							
						}
					} //end of run
				});
			}
		});
		
		Joinus_JButton = new JButton("ȸ������");
		Joinus_JButton.setFont(new Font("����", Font.BOLD, 13));
		Joinus_JButton.setBounds(501, 34, 96, 32);
		BMS_sub_contentPane.add(Joinus_JButton);
		
		Joinus_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	//ȸ������ ��ư�� ������ 
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
		
		Login_JButton = new JButton("�α���");
		Login_JButton.setFont(new Font("����", Font.BOLD, 13));
		Login_JButton.setBounds(600, 34, 111, 32);
		BMS_sub_contentPane.add(Login_JButton);
		
		Login_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	//�α��� ��ư�� ������ 
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
		
		Novel_JButton = new JButton("�Ҽ�");
		Novel_JButton.setFont(new Font("����", Font.BOLD, 20));
		Novel_JButton.setBounds(51, 97, 129, 43);
		BMS_sub_contentPane.add(Novel_JButton);
		
		Novel_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// ��ư�� ������ 
							Default_BMS_Novel frame = new Default_BMS_Novel(); //������� â���� �̵�
							frame.setVisible(true);
							dispose(); //�� â�� ������
						} catch (Exception e) {
							e.printStackTrace(); // ���н� �����޼��� ���
							
						}
					} //end of run
				});
			}
		});
		
		Poem_JButton = new JButton("��");
		Poem_JButton.setFont(new Font("����", Font.BOLD, 20));
		Poem_JButton.setBounds(224, 97, 129, 43);
		BMS_sub_contentPane.add(Poem_JButton);
		
		Poem_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// ��ư�� ������ 
							Default_BMS_Poem frame = new Default_BMS_Poem(); //������� â���� �̵�
							frame.setVisible(true);
							dispose(); //�� â�� ������
							
						} catch (Exception e) {
							e.printStackTrace(); // ���н� �����޼��� ���
							
						}
					} //end of run
				});
			}
		});
		
		Humanity_JButton = new JButton("�ι�");
		Humanity_JButton.setFont(new Font("����", Font.BOLD, 20));
		Humanity_JButton.setBounds(401, 97, 129, 43);
		BMS_sub_contentPane.add(Humanity_JButton);
		
		Humanity_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// ��ư�� ������ 
							Default_BMS_Humanity frame = new Default_BMS_Humanity(); //������� â���� �̵�
							frame.setVisible(true);
							dispose(); //�� â�� ������
							
						} catch (Exception e) {
							e.printStackTrace(); // ���н� �����޼��� ���
						}
					} //end of run
				});
			}
		});
		
		Comic_JButton = new JButton("��ȭ");
		Comic_JButton.setFont(new Font("����", Font.BOLD, 20));
		Comic_JButton.setBounds(571, 97, 129, 43);
		BMS_sub_contentPane.add(Comic_JButton);
		
		Comic_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// ��ư�� ������ 
							Default_BMS_Comic frame = new Default_BMS_Comic(); //������� â���� �̵�
							frame.setVisible(true);
							dispose(); //�� â�� ������
							
						} catch (Exception e) {
							e.printStackTrace(); // ���н� �����޼��� ���
						}
					} //end of run
				});
			}
		});
		
		Content_JPanel = new JPanel();
		Content_JPanel.setBounds(51, 204, 632, 318);
		BMS_sub_contentPane.add(Content_JPanel);
		Content_JPanel.setLayout(null);
		
		Connection conn;
		String sql;
		PreparedStatement pstmt;
		ResultSet rs;
		
		try {
			conn = DriverManager.getConnection(Main.url, Main.user, Main.password);
			sql = "SELECT title, author, ISBN FROM book WHERE kind = '�Ҽ�'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				Title1_JTextField = new JTextField(rs.getString(1));
				Title1_JTextField.setEditable(false);
				Title1_JTextField.setColumns(10);
				Title1_JTextField.setBounds(66, 231, 128, 32);
				Content_JPanel.add(Title1_JTextField);
				
				Author1_JTextField = new JTextField(rs.getString(2));
				Author1_JTextField.setEditable(false);
				Author1_JTextField.setColumns(10);
				Author1_JTextField.setBounds(66, 276, 128, 32);
				Content_JPanel.add(Author1_JTextField);
			}
			
			sql = "SELECT title, author, ISBN FROM book WHERE kind = '�Ҽ�' AND ISBN != ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rs.getInt(3));
			int tmp = rs.getInt(3);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				Title2_JTextField = new JTextField(rs.getString(1));
				Title2_JTextField.setEditable(false);
				Title2_JTextField.setColumns(10);
				Title2_JTextField.setBounds(272, 231, 128, 32);
				Content_JPanel.add(Title2_JTextField);
				
				Author2_JTextField = new JTextField(rs.getString(2));
				Author2_JTextField.setEditable(false);
				Author2_JTextField.setColumns(10);
				Author2_JTextField.setBounds(272, 276, 128, 32);
				Content_JPanel.add(Author2_JTextField);
			}
			
			sql = "SELECT title, author, ISBN FROM book WHERE kind = '�Ҽ�' AND ISBN != ? AND ISBN != ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tmp);
			pstmt.setInt(2, rs.getInt(3));
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				Title3_JTextField = new JTextField(rs.getString(1));
				Title3_JTextField.setEditable(false);
				Title3_JTextField.setColumns(10);
				Title3_JTextField.setBounds(475, 231, 128, 32);
				Content_JPanel.add(Title3_JTextField);
				
				Author3_JTextField = new JTextField(rs.getString(2));
				Author3_JTextField.setEditable(false);
				Author3_JTextField.setColumns(10);
				Author3_JTextField.setBounds(475, 276, 128, 32);
				Content_JPanel.add(Author3_JTextField);
			}
			
			pstmt.close();
			conn.close();
			
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		if(Title1_JTextField.getText().equals("���������"))
		{
			BookImage1_JButton = new JButton(new ImageIcon("img/���������.png"));
		} 
		else if(Title1_JTextField.getText().equals("�޹в��ʹ���"))
		{
			BookImage1_JButton = new JButton(new ImageIcon("img/�޹в��ʹ���.png"));
		} 
		else {
			BookImage1_JButton = new JButton(new ImageIcon("img/�����.png"));
		}
		
		BookImage1_JButton.setBounds(40, 30, 146, 184);
		Content_JPanel.add(BookImage1_JButton);
		
		if(Title2_JTextField.getText().equals("���������"))
		{
			BookImage2_JButton = new JButton(new ImageIcon("img/���������.png"));
		} 
		else if(Title2_JTextField.getText().equals("�޹в��ʹ���"))
		{
			BookImage2_JButton = new JButton(new ImageIcon("img/�޹в��ʹ���.png"));
		} 
		else
		{
			BookImage2_JButton = new JButton(new ImageIcon("img/�����.png"));
		}
		
		BookImage2_JButton.setBounds(244, 30, 146, 184);
		Content_JPanel.add(BookImage2_JButton);
		
		if(Title3_JTextField.getText().equals("���������"))
		{
			BookImage3_JButton = new JButton(new ImageIcon("img/���������.png"));
		} 
		else if(Title3_JTextField.getText().equals("�޹в��ʹ���"))
		{
			BookImage3_JButton = new JButton(new ImageIcon("img/�޹в��ʹ���.png"));
		}
		else
		{
			BookImage3_JButton = new JButton(new ImageIcon("img/�����.png"));
		}
		
		BookImage3_JButton.setBounds(452, 30, 146, 184);
		Content_JPanel.add(BookImage3_JButton);
		
		BookImage1_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try { // ��ư�� ������ 
							Default.Main.bookName = Title1_JTextField.getText();
							Default_BMS_detail frame = new Default_BMS_detail();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace(); // ���н� �����޼��� ���
						}
					} //end of run
				});
			}
		});
		
		BookImage2_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// ��ư�� ������ 
							Default.Main.bookName = Title2_JTextField.getText(); //�߰�
							Default_BMS_detail frame = new Default_BMS_detail();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace(); // ���н� �����޼��� ���
						}
					} //end of run
				});
			}
		});
		
		BookImage3_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// ��ư�� ������ 
							Default.Main.bookName = Title3_JTextField.getText(); //�߰�
							Default_BMS_detail frame = new Default_BMS_detail();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace(); // ���н� �����޼��� ���
						}
					} //end of run
				});
			}
		});
		
		JLabel Title1_JLabel = new JLabel("\uC81C\uBAA9");
		Title1_JLabel.setFont(new Font("����", Font.BOLD, 20));
		Title1_JLabel.setBounds(12, 231, 51, 32);
		Content_JPanel.add(Title1_JLabel);
		
		JLabel Author1_JLabel = new JLabel("\uC800\uC790");
		Author1_JLabel.setFont(new Font("����", Font.BOLD, 20));
		Author1_JLabel.setBounds(12, 276, 42, 32);
		Content_JPanel.add(Author1_JLabel);
		
		JLabel Title2_JLabel = new JLabel("\uC81C\uBAA9");
		Title2_JLabel.setFont(new Font("����", Font.BOLD, 20));
		Title2_JLabel.setBounds(208, 231, 51, 32);
		Content_JPanel.add(Title2_JLabel);
		
		JLabel Author2_JLabel = new JLabel("\uC800\uC790");
		Author2_JLabel.setFont(new Font("����", Font.BOLD, 20));
		Author2_JLabel.setBounds(208, 276, 51, 32);
		Content_JPanel.add(Author2_JLabel);
		
		JLabel Title3_JLabel = new JLabel("\uC81C\uBAA9");
		Title3_JLabel.setFont(new Font("����", Font.BOLD, 20));
		Title3_JLabel.setBounds(414, 231, 51, 32);
		Content_JPanel.add(Title3_JLabel);
		
		JLabel Author3_JLabel = new JLabel("\uC800\uC790");
		Author3_JLabel.setFont(new Font("����", Font.BOLD, 20));
		Author3_JLabel.setBounds(414, 276, 51, 32);
		Content_JPanel.add(Author3_JLabel);
		
		JLabel Kind_JLabel = new JLabel("\uC18C\uC124");
		Kind_JLabel.setFont(new Font("����", Font.BOLD, 25));
		Kind_JLabel.setBounds(354, 150, 57, 28);
		BMS_sub_contentPane.add(Kind_JLabel);
	}

}