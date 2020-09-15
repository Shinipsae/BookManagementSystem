package Default;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.Client_BMS_main;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.naming.directory.SearchResult;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Default_BMS_Search extends JFrame {

	private JPanel contentPane;
	private JTextField Search_JTextField;

	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 */
	public Default_BMS_Search(String test) {
		setTitle("BMS_search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.setBounds(34, 21, 161, 32);
		contentPane.add(icon_JButton);
		
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
		
		Search_JTextField = new JTextField();
		Search_JTextField.setColumns(10);
		Search_JTextField.setBounds(215, 31, 218, 32);
		contentPane.add(Search_JTextField);
		
		JButton Search_JButton = new JButton("\uAC80\uC0C9");
		Search_JButton.setFont(new Font("굴림", Font.PLAIN, 12));
		Search_JButton.setBounds(435, 31, 60, 32);
		contentPane.add(Search_JButton);
		
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
		
		JTextField t1 = new JTextField();
		
		Search_JButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//SearchResult s1 = new SearchResult(t1.getText());
				//dispose();			
			}
		});;
		
		JButton Joinus_JButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		Joinus_JButton.setFont(new Font("굴림", Font.BOLD, 13));
		Joinus_JButton.setBounds(514, 30, 106, 32);
		contentPane.add(Joinus_JButton);
		
		JButton Login_JButton = new JButton("\uB85C\uADF8\uC778");
		Login_JButton.setFont(new Font("굴림", Font.BOLD, 13));
		Login_JButton.setBounds(632, 30, 102, 32);
		contentPane.add(Login_JButton);
		
		JPanel Search_JPanel = new JPanel();
		Search_JPanel.setBounds(34, 187, 719, 338);
		contentPane.add(Search_JPanel);
		
		JLabel Result_JLabel = new JLabel("' " + test + " ' 로 검색한 결과");
		Result_JLabel.setFont(new Font("굴림", Font.BOLD, 25));
		Result_JLabel.setBounds(235, 115, 347, 50);
		contentPane.add(Result_JLabel);
	}
}
