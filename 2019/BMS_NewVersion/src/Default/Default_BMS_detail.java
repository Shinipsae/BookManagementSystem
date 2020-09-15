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
		
		JButton Novel_JButton = new JButton("�Ҽ�");
		Novel_JButton.setFont(new Font("����", Font.BOLD, 20));
		Novel_JButton.setBounds(71, 97, 129, 43);
		BMS_detail_contentPane.add(Novel_JButton);
		
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
		
		JButton Poem_JButton = new JButton("��");
		Poem_JButton.setFont(new Font("����", Font.BOLD, 20));
		Poem_JButton.setBounds(244, 97, 129, 43);
		BMS_detail_contentPane.add(Poem_JButton);
		
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
		
		JButton Humanity_JButton = new JButton("�ι�");
		Humanity_JButton.setFont(new Font("����", Font.BOLD, 20));
		Humanity_JButton.setBounds(421, 97, 129, 43);
		BMS_detail_contentPane.add(Humanity_JButton);
		
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
		
		JButton Comic_JButton = new JButton("��ȭ");
		Comic_JButton.setFont(new Font("����", Font.BOLD, 20));
		Comic_JButton.setBounds(591, 97, 129, 43);
		BMS_detail_contentPane.add(Comic_JButton);
		
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
		
		Search_JTextField = new JTextField();
		Search_JTextField.setColumns(10);
		Search_JTextField.setBounds(213, 32, 218, 32);
		BMS_detail_contentPane.add(Search_JTextField);
		
		JButton Search_JButton = new JButton("�˻�");
		Search_JButton.setBounds(433, 32, 64, 32);
		BMS_detail_contentPane.add(Search_JButton);
		
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

		JLabel Title_JLabel = new JLabel("����");
		Title_JLabel.setFont(new Font("����", Font.BOLD, 20));
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
		
		if(Title_JTextField.getText().equals("���������"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/���������.png"));
		} 
		else if(Title_JTextField.getText().equals("�޹в��ʹ���"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/�޹в��ʹ���.png"));
		} 
		else if(Title_JTextField.getText().equals("�����"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/�����.png"));
		} 
		else if(Title_JTextField.getText().equals("����¹�"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/����¹�.png"));
		} 
		else if(Title_JTextField.getText().equals("����ħ��"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/����ħ��.png"));
		} 
		else if(Title_JTextField.getText().equals("����"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/����.png"));
		} 
		else if(Title_JTextField.getText().equals("Java�� ����"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/Java������.png"));
		} 
		else if(Title_JTextField.getText().equals("ȥ�� �����ϴ� �ڹ�"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/ȥ�ڰ����ϴ��ڹ�.png"));
		} 
		else if(Title_JTextField.getText().equals("�̰��� �ڹٴ�"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/�̰����ڹٴ�.png"));
		} 
		else if(Title_JTextField.getText().equals("�����ϱ�"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/�����ϱ�.png"));
		} 
		else if(Title_JTextField.getText().equals("���õ� ������� ��"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/���õ����������.png"));
		} 
		else if(Title_JTextField.getText().equals("�ٸ� ���� ������"))
		{
			Bookphoto_JButton = new JButton(new ImageIcon("img/�ٸ����ֱ�����.png"));
		} 
		
		Bookphoto_JButton.setBounds(57, 198, 212, 235);
		BMS_detail_contentPane.add(Bookphoto_JButton);
		
		JLabel Author_JLabel = new JLabel("����");
		Author_JLabel.setFont(new Font("����", Font.BOLD, 20));
		Author_JLabel.setBounds(31, 498, 59, 32);
		BMS_detail_contentPane.add(Author_JLabel);

		JLabel Borrowprice_JLabel = new JLabel("�뿩�� :");
		Borrowprice_JLabel.setFont(new Font("����", Font.BOLD, 20));
		Borrowprice_JLabel.setBounds(379, 342, 79, 32);
		BMS_detail_contentPane.add(Borrowprice_JLabel);
		
		JLabel borrow_won_JLabel = new JLabel("��");
		borrow_won_JLabel.setFont(new Font("����", Font.BOLD, 20));
		borrow_won_JLabel.setBounds(646, 342, 39, 32);
		BMS_detail_contentPane.add(borrow_won_JLabel);
		
		JLabel Buyprice_JLabel = new JLabel("���Ű� :");
		Buyprice_JLabel.setFont(new Font("����", Font.BOLD, 20));
		Buyprice_JLabel.setBounds(379, 417, 79, 32);
		BMS_detail_contentPane.add(Buyprice_JLabel);
		
		JLabel Buy_won_JLabel = new JLabel("��");
		Buy_won_JLabel.setFont(new Font("����", Font.BOLD, 20));
		Buy_won_JLabel.setBounds(646, 417, 39, 32);
		BMS_detail_contentPane.add(Buy_won_JLabel);
		
		JButton Borrow_JButton = new JButton("�뿩�ϱ�");
		Borrow_JButton.setFont(new Font("����", Font.BOLD, 20));
		Borrow_JButton.setBounds(439, 482, 129, 43);
		BMS_detail_contentPane.add(Borrow_JButton);
		
		Borrow_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JOptionPane.showMessageDialog(null,"�α��� �� �̿밡���� ���� �Դϴ�. \n �α��� â���� �̵��մϴ�.");
							dispose();
							Login frame = new Login();
							frame.setVisible(true);
							dispose(); //�� â�� ������
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton Buy_JButton = new JButton("�����ϱ�");
		Buy_JButton.setFont(new Font("����", Font.BOLD, 20));
		Buy_JButton.setBounds(591, 482, 129, 43);
		BMS_detail_contentPane.add(Buy_JButton);
		
		Buy_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JOptionPane.showMessageDialog(null,"�α��� �� �̿밡���� ���� �Դϴ�. \n �α��� â���� �̵��մϴ�.");
							dispose();
							Login frame = new Login();
							frame.setVisible(true);
							dispose(); //�� â�� ������
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JLabel Week2_JLabel = new JLabel("�ش뿩���� �������� 2�ְ� �� �� �ֽ��ϴ�.");
		Week2_JLabel.setFont(new Font("����", Font.PLAIN, 14));
		Week2_JLabel.setBounds(395, 384, 325, 15);
		BMS_detail_contentPane.add(Week2_JLabel);
		
		JButton back_JButton = new JButton("��");
		back_JButton.setFont(new Font("����", Font.BOLD, 40));
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
							dispose(); //�� â�� ������
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
		
		JLabel Plot_JLabel = new JLabel("\uC904\uAC70\uB9AC");
		Plot_JLabel.setFont(new Font("����", Font.BOLD, 20));
		Plot_JLabel.setBounds(367, 179, 79, 24);
		BMS_detail_contentPane.add(Plot_JLabel);
	}

}