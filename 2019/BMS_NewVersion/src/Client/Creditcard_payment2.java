package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Default.Default_BMS_main;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;

import java.util.*;

public class Creditcard_payment2 extends JFrame {

	private JPanel Creditcard_payment2_contentPane;
	private JTextField cardnum1_JTextField;
	private JTextField cardnum2_JTextField;
	private JTextField cardnum3_JTextField;
	private JTextField cardnum4_JTextField;
	private JTextField expirationdate_JTextField;
	private JTextField expirationmonth_JTextField;
	private JLabel expslash_JLabel;
	private JLabel cvcnum_JLabel;
	private JTextField cvcnum_JTextField;
	private JLabel password_JLabel;
	private JTextField password_JTextField;
	private JTextField total_JTextField;
	private JButton payment_JButton;
	private JButton back_JButton;
	
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Creditcard_payment2() {
		setTitle("Creditcard_payment2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		Creditcard_payment2_contentPane = new JPanel();
		Creditcard_payment2_contentPane.setBackground(SystemColor.desktop);
		Creditcard_payment2_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Creditcard_payment2_contentPane);
		Creditcard_payment2_contentPane.setLayout(null);
		
		JLabel card_JLabel = new JLabel("\uCE74\uB4DC\uACB0\uC81C");
		card_JLabel.setFont(new Font("굴림", Font.BOLD, 23));
		card_JLabel.setBounds(44, 82, 123, 59);
		Creditcard_payment2_contentPane.add(card_JLabel);
		
		JLabel cardnum_JLabel = new JLabel("\uCE74\uB4DC\uBC88\uD638");
		cardnum_JLabel.setFont(new Font("굴림", Font.BOLD, 23));
		cardnum_JLabel.setBounds(63, 165, 123, 59);
		Creditcard_payment2_contentPane.add(cardnum_JLabel);
		
		cardnum1_JTextField = new JTextField();
		cardnum1_JTextField.setBounds(187, 183, 116, 32);
		Creditcard_payment2_contentPane.add(cardnum1_JTextField);
		cardnum1_JTextField.setColumns(10);
		
		cardnum2_JTextField = new JTextField();
		cardnum2_JTextField.setColumns(10);
		cardnum2_JTextField.setBounds(327, 183, 116, 32);
		Creditcard_payment2_contentPane.add(cardnum2_JTextField);
		
		cardnum3_JTextField = new JTextField();
		cardnum3_JTextField.setColumns(10);
		cardnum3_JTextField.setBounds(462, 183, 116, 32);
		Creditcard_payment2_contentPane.add(cardnum3_JTextField);
		
		cardnum4_JTextField = new JTextField();
		cardnum4_JTextField.setColumns(10);
		cardnum4_JTextField.setBounds(596, 183, 116, 32);
		Creditcard_payment2_contentPane.add(cardnum4_JTextField);
		
		JLabel expiration_JLabel = new JLabel("\uC720\uD6A8\uAE30\uAC04");
		expiration_JLabel.setFont(new Font("굴림", Font.BOLD, 23));
		expiration_JLabel.setBounds(63, 257, 123, 59);
		Creditcard_payment2_contentPane.add(expiration_JLabel);
		
		expirationmonth_JTextField = new JTextField();
		expirationmonth_JTextField.setColumns(10);
		expirationmonth_JTextField.setBounds(187, 274, 48, 32);
		Creditcard_payment2_contentPane.add(expirationmonth_JTextField);
		
		expirationdate_JTextField = new JTextField();
		expirationdate_JTextField.setColumns(10);
		expirationdate_JTextField.setBounds(255, 275, 48, 32);
		Creditcard_payment2_contentPane.add(expirationdate_JTextField);
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.setBounds(32, 20, 161, 32);
		Creditcard_payment2_contentPane.add(icon_JButton);
		
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
		
		expslash_JLabel = new JLabel("/");
		expslash_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		expslash_JLabel.setBounds(240, 283, 21, 15);
		Creditcard_payment2_contentPane.add(expslash_JLabel);
		
		cvcnum_JLabel = new JLabel("CVC\uBC88\uD638");
		cvcnum_JLabel.setFont(new Font("굴림", Font.BOLD, 23));
		cvcnum_JLabel.setBounds(378, 257, 123, 59);
		Creditcard_payment2_contentPane.add(cvcnum_JLabel);
		
		cvcnum_JTextField = new JTextField();
		cvcnum_JTextField.setColumns(10);
		cvcnum_JTextField.setBounds(494, 266, 83, 42);
		Creditcard_payment2_contentPane.add(cvcnum_JTextField);
		
		password_JLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		password_JLabel.setFont(new Font("굴림", Font.BOLD, 23));
		password_JLabel.setBounds(63, 349, 123, 59);
		Creditcard_payment2_contentPane.add(password_JLabel);
		
		password_JTextField = new JTextField();
		password_JTextField.setColumns(10);
		password_JTextField.setBounds(187, 362, 391, 42);
		Creditcard_payment2_contentPane.add(password_JTextField);
		
		payment_JButton = new JButton("\uACB0\uC81C\uD558\uAE30");
		payment_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		payment_JButton.setBounds(562, 476, 129, 43);
		Creditcard_payment2_contentPane.add(payment_JButton);
		
		payment_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							if(cardnum1_JTextField.getText().equals("") || cardnum2_JTextField.getText().equals("") 
									|| cardnum3_JTextField.getText().equals("") || cardnum3_JTextField.getText().equals("")) {
										JOptionPane.showMessageDialog(null,"카드번호를 입력해주세요.");
										Creditcard_payment2 frame = new Creditcard_payment2();
										frame.setVisible(true);
										dispose();
								}
								
								else if(expirationmonth_JTextField.getText().equals("") || expirationdate_JTextField.getText().equals("")) {
									JOptionPane.showMessageDialog(null,"유효기간을 입력해주세요.");
									Creditcard_payment2 frame = new Creditcard_payment2();
									frame.setVisible(true);
								}
								
								else if(cvcnum_JTextField.getText().equals("")) {
									JOptionPane.showMessageDialog(null,"CVC번호를 입력해주세요.");
									Creditcard_payment2 frame = new Creditcard_payment2();
									frame.setVisible(true);
								}
								
								else if(password_JTextField.getText().equals("")) {
									JOptionPane.showMessageDialog(null,"비밀번호를 입력해주세요.");
									Creditcard_payment2 frame = new Creditcard_payment2();
									frame.setVisible(true);
								}
								
								else {
									JOptionPane.showMessageDialog(null,"                      이용해주셔서 감사합니다. \n 대여/구매한 도서는 마이페이지에서 확인 가능합니다.");
									dispose();
									Client_BMS_main frame = new Client_BMS_main();
									frame.setVisible(true);
									dispose(); //전 창은 없어짐
								}
							
//							if(Character.isDigit(cardnum1_JTextField.getText()) == false) {
//								
//							}
				
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		back_JButton = new JButton("\u261C");
		back_JButton.setFont(new Font("굴림", Font.BOLD, 40));
		back_JButton.setBackground(SystemColor.inactiveCaption);
		back_JButton.setBounds(640, 36, 87, 58);
		Creditcard_payment2_contentPane.add(back_JButton);
		
		back_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Creditcard_payment frame = new Creditcard_payment();
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JLabel totalamount_JLabel = new JLabel("\uCD1D\uC8FC\uBB38\uAE08\uC561 :");
		totalamount_JLabel.setFont(new Font("굴림", Font.BOLD, 18));
		totalamount_JLabel.setBounds(443, 88, 123, 59);
		Creditcard_payment2_contentPane.add(totalamount_JLabel);
		
		JLabel won_JLabel = new JLabel("\uC6D0");
		won_JLabel.setFont(new Font("굴림", Font.BOLD, 18));
		won_JLabel.setBounds(665, 88, 33, 59);
		Creditcard_payment2_contentPane.add(won_JLabel);
		
		if(Client.Client_BMS_main.buyPrice.equals("null")) {
			total_JTextField = new JTextField(Client.Client_BMS_main.borrowPrice);
			total_JTextField.setEditable(false);
			total_JTextField.setEnabled(false);
			total_JTextField.setBounds(563, 109, 90, 21);
			Creditcard_payment2_contentPane.add(total_JTextField);
			total_JTextField.setColumns(10);
			Client.Client_BMS_main.borrowPrice = "null";
		}
		
		else {
			total_JTextField = new JTextField(Client.Client_BMS_main.buyPrice);
			total_JTextField.setEditable(false);
			total_JTextField.setEnabled(false);
			total_JTextField.setBounds(563, 109, 90, 21);
			Creditcard_payment2_contentPane.add(total_JTextField);
			total_JTextField.setColumns(10);
			Client.Client_BMS_main.buyPrice = "null";
		}
		
	}
}
