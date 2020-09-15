package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Readbook extends JFrame {

	private JPanel Readbook_contentPane;
	private JTable Title_JTable;
	private JTable Author_JTable;
	private JTable Content_JTable;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Readbook() {
		setTitle("Readbook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		Readbook_contentPane = new JPanel();
		Readbook_contentPane.setBackground(SystemColor.desktop);
		Readbook_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Readbook_contentPane);
		Readbook_contentPane.setLayout(null);
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		icon_JButton.setBounds(32, 20, 161, 32);
		Readbook_contentPane.add(icon_JButton);
		
		icon_JButton.setBounds(30, 21, 161, 32);
		Readbook_contentPane.add(icon_JButton);
		
		JLabel Title_JLabel = new JLabel("\uC81C\uBAA9");
		Title_JLabel.setFont(new Font("±¼¸²", Font.BOLD, 20));
		Title_JLabel.setBounds(45, 80, 59, 32);
		Readbook_contentPane.add(Title_JLabel);
		
		Title_JTable = new JTable();
		Title_JTable.setBounds(116, 80, 188, 32);
		Readbook_contentPane.add(Title_JTable);
		
		JLabel Author_JLabel = new JLabel("\uC800\uC790");
		Author_JLabel.setFont(new Font("±¼¸²", Font.BOLD, 20));
		Author_JLabel.setBounds(45, 125, 59, 32);
		Readbook_contentPane.add(Author_JLabel);
		
		Author_JTable = new JTable();
		Author_JTable.setBounds(116, 125, 188, 32);
		Readbook_contentPane.add(Author_JTable);
		
		JButton back_JButton = new JButton("\u261C");
		back_JButton.setFont(new Font("±¼¸²", Font.BOLD, 40));
		back_JButton.setBackground(SystemColor.inactiveCaption);
		back_JButton.setBounds(620, 37, 87, 58);
		Readbook_contentPane.add(back_JButton);
		
		Content_JTable = new JTable();
		Content_JTable.setBounds(37, 195, 670, 318);
		Readbook_contentPane.add(Content_JTable);
		
		JScrollBar Content_JScrollBar = new JScrollBar();
		Content_JScrollBar.setBounds(707, 195, 17, 318);
		Readbook_contentPane.add(Content_JScrollBar);
	}
}
