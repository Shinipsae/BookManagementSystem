package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Default.Default_BMS_main;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class Cash_payment extends JFrame {

	private JPanel Cash_payment_contentPane;
	private JTextField total_JTextField;
	private JTextField name_JTextField;



	/**
	 * Create the frame.
	 */
	public Cash_payment() {
		setTitle("Cash_payment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		Cash_payment_contentPane = new JPanel();
		Cash_payment_contentPane.setBackground(SystemColor.desktop);
		Cash_payment_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Cash_payment_contentPane);
		Cash_payment_contentPane.setLayout(null);
		
		JLabel deposit_JLabel = new JLabel("\uBB34\uD1B5\uC7A5\uC785\uAE08");
		deposit_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		deposit_JLabel.setBounds(66, 64, 123, 59);
		Cash_payment_contentPane.add(deposit_JLabel);
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.setBounds(32, 20, 161, 32);
		Cash_payment_contentPane.add(icon_JButton);
		
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
		
		JLabel totalamount_JLabel = new JLabel("\uCD1D\uC8FC\uBB38\uAE08\uC561 :");
		totalamount_JLabel.setFont(new Font("굴림", Font.BOLD, 18));
		totalamount_JLabel.setBounds(481, 64, 123, 59);
		Cash_payment_contentPane.add(totalamount_JLabel);
		
		if(Client.Client_BMS_main.buyPrice.equals("null")) {
			total_JTextField = new JTextField(Client.Client_BMS_main.borrowPrice);
			total_JTextField.setEditable(false);
			total_JTextField.setEnabled(false);
			total_JTextField.setBounds(601, 85, 90, 21);
			Cash_payment_contentPane.add(total_JTextField);
			total_JTextField.setColumns(10);
			Client.Client_BMS_main.borrowPrice = "null";
		}
		else {
			total_JTextField = new JTextField(Client.Client_BMS_main.buyPrice);
			total_JTextField.setEditable(false);
			total_JTextField.setEnabled(false);
			total_JTextField.setBounds(601, 85, 90, 21);
			Cash_payment_contentPane.add(total_JTextField);
			total_JTextField.setColumns(10);
			Client.Client_BMS_main.buyPrice = "null";
		}
		
//		total_JTextField = new JTextField(Client.Client_BMS_main.borrowPrice);
//		total_JTextField.setEditable(false);
//		total_JTextField.setEnabled(false);
//		total_JTextField.setBounds(601, 85, 90, 21);
//		Cash_payment_contentPane.add(total_JTextField);
//		total_JTextField.setColumns(10);
		
		JLabel won_JLabel = new JLabel("\uC6D0");
		won_JLabel.setFont(new Font("굴림", Font.BOLD, 18));
		won_JLabel.setBounds(703, 64, 33, 59);
		Cash_payment_contentPane.add(won_JLabel);
		
		JLabel name_JLabel = new JLabel("\uC785\uAE08\uC790\uBA85");
		name_JLabel.setFont(new Font("굴림", Font.BOLD, 25));
		name_JLabel.setBounds(112, 152, 108, 50);
		Cash_payment_contentPane.add(name_JLabel);
		
		name_JTextField = new JTextField();
		name_JTextField.setBounds(232, 163, 358, 38);
		Cash_payment_contentPane.add(name_JTextField);
		name_JTextField.setColumns(10);
		
		JLabel bank_JLabel = new JLabel("\uC785\uAE08\uC740\uD589");
		bank_JLabel.setFont(new Font("굴림", Font.BOLD, 25));
		bank_JLabel.setBounds(112, 246, 108, 50);
		Cash_payment_contentPane.add(bank_JLabel);
		
		JRadioButton woori_JRadioButton = new JRadioButton("\uC6B0\uB9AC 1002-958-0433-70 (\uC8FC) \uBBF8\uB9BC\uB3C4\uC11C\uAD00");
		woori_JRadioButton.setSelected(true);
		woori_JRadioButton.setFont(new Font("굴림", Font.PLAIN, 15));
		woori_JRadioButton.setBounds(232, 256, 358, 38);
		Cash_payment_contentPane.add(woori_JRadioButton);
		
		JRadioButton kb_JRadioButton = new JRadioButton("\uAD6D\uBBFC 429501-01-317502 (\uC8FC) \uBBF8\uB9BC\uB3C4\uC11C\uAD00");
		kb_JRadioButton.setFont(new Font("굴림", Font.PLAIN, 15));
		kb_JRadioButton.setBounds(232, 320, 358, 38);
		Cash_payment_contentPane.add(kb_JRadioButton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(kb_JRadioButton);
		bg.add(woori_JRadioButton);
		
		JButton payment_JButton = new JButton("\uACB0\uC81C\uD558\uAE30");
		payment_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		payment_JButton.setBounds(558, 482, 129, 43);
		Cash_payment_contentPane.add(payment_JButton);
		
		payment_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JOptionPane.showMessageDialog(null,"입금확인후 정상결제 됩니다. \n 이용해주셔서 감사합니다.");
							dispose();
							Client_BMS_main frame = new Client_BMS_main();
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JCheckBox agreement_JCheckBox = new JCheckBox("                                  \uC0C1\uAE30 \uACB0\uC81C\uB0B4\uC5ED\uC5D0 \uB3D9\uC758\uD569\uB2C8\uB2E4.");
		agreement_JCheckBox.setBounds(112, 403, 478, 43);
		Cash_payment_contentPane.add(agreement_JCheckBox);
		
		JButton back_JButton = new JButton("\u261C");
		back_JButton.setFont(new Font("굴림", Font.BOLD, 40));
		back_JButton.setBackground(SystemColor.inactiveCaption);
		back_JButton.setBounds(649, 10, 87, 58);
		Cash_payment_contentPane.add(back_JButton);
		
		back_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Client_BMS_main frame = new Client_BMS_main();
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}
}
