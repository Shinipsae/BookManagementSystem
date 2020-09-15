package Manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Default.Default_BMS_main;
import Default.Main;

import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;

public class Deletebook extends JFrame {

	private JPanel Deletebook_contentPane;
	private JTextField Name_JTextField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Deletebook() {
		setTitle("Deletebook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		Deletebook_contentPane = new JPanel();
		Deletebook_contentPane.setBackground(SystemColor.desktop);
		Deletebook_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Deletebook_contentPane);
		Deletebook_contentPane.setLayout(null);
		
		JLabel Management_ver_JLabel = new JLabel("(Management Version)");
		Management_ver_JLabel.setFont(new Font("굴림", Font.BOLD, 15));
		Management_ver_JLabel.setBounds(209, 29, 185, 32);
		Deletebook_contentPane.add(Management_ver_JLabel);
		
		JLabel Managerpage_JLabel = new JLabel("\uAD00\uB9AC\uC790\uD398\uC774\uC9C0");
		Managerpage_JLabel.setFont(new Font("굴림", Font.BOLD, 22));
		Managerpage_JLabel.setBounds(66, 103, 147, 32);
		Deletebook_contentPane.add(Managerpage_JLabel);
		
		JLabel Manager_JLabel = new JLabel("\uAD00\uB9AC\uC790\uB2D8");
		Manager_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Manager_JLabel.setBounds(422, 103, 100, 32);
		Deletebook_contentPane.add(Manager_JLabel);
		
		JButton Logout_JButton = new JButton("\uB85C\uADF8\uC544\uC6C3");
		Logout_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Logout_JButton.setBounds(575, 63, 129, 43);
		Deletebook_contentPane.add(Logout_JButton);
		
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
		
		JButton Clientlist_JButton = new JButton("\uD68C\uC6D0\uBAA9\uB85D");
		Clientlist_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Clientlist_JButton.setBounds(47, 246, 129, 43);
		Deletebook_contentPane.add(Clientlist_JButton);
		
		Clientlist_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Manager_BMS_main frame = new Manager_BMS_main(); //서브메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		JButton Addbook_JButton = new JButton("\uB3C4\uC11C\uCD94\uAC00");
		Addbook_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Addbook_JButton.setBounds(47, 349, 129, 43);
		Deletebook_contentPane.add(Addbook_JButton);
		
		Addbook_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Addbook frame = new Addbook(); //서브메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		JButton Deletebook_JButton = new JButton("\uB3C4\uC11C\uC0AD\uC81C");
		Deletebook_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Deletebook_JButton.setBounds(47, 452, 129, 43);
		Deletebook_contentPane.add(Deletebook_JButton);
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.setBounds(36, 29, 161, 32);
		Deletebook_contentPane.add(icon_JButton);
		
		icon_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Manager_BMS_main frame = new Manager_BMS_main(); //서브메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		String columnNames[] = {"ISBN", "제목", "저자", "종류", "대여가", "구매가"};
		Object rowData[][] = { };
		
		DefaultTableModel defaultTableModel = new DefaultTableModel(rowData, columnNames);	
		
		JTable jTable = new JTable(defaultTableModel);
		JScrollPane Booklist_JScrollPane = new JScrollPane(jTable);
		Booklist_JScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		Booklist_JScrollPane.setBounds(202, 228, 546, 279);
		Deletebook_contentPane.add(Booklist_JScrollPane);
		
		try {
			Connection conn = DriverManager.getConnection(Main.url, Main.user, Main.password);
			
			String sql = "SELECT * FROM book";
			
			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			ResultSet rs = pstmt1.executeQuery();
			
			while(rs.next()) {
				
				String isbn = rs.getString("ISBN");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String kind = rs.getString("kind");
				String borrow_p = rs.getString("borrowprice");
				String buy_p = rs.getString("buyprice");
				
				Object data[] = {isbn, title, author, kind, borrow_p, buy_p};
				defaultTableModel.addRow(data);
				
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
		try {
			Connection conn = DriverManager.getConnection(Main.url, Main.user, Main.password);
			
			String sql1 = "SELECT name FROM manager WHERE id = ?";
			
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, Manager.Manager_BMS_main.currentManager);

			ResultSet rs = pstmt1.executeQuery();
			
			if(rs.next()) {
				
				Name_JTextField = new JTextField();
				Name_JTextField.setEditable(false);
				Name_JTextField.setText(rs.getString(1));
				Name_JTextField.setBounds(282, 100, 129, 32);
				Deletebook_contentPane.add(Name_JTextField);
				Name_JTextField.setColumns(10);
			}
			
			pstmt1.close();
			conn.close();
			
		}
		
		 catch (SQLException e1) {
				e1.printStackTrace();
			}	
	}
}
