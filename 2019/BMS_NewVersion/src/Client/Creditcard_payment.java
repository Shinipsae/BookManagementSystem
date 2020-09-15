package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.ldap.Rdn;
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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class Creditcard_payment extends JFrame {

	private JPanel Creditcard_payment_contentPane;
	private JTextField total_JTextField;

//	public void itemStateChanged(ItemEvent e) {
//		if(e.getStateChange() == ItemEvent.DESELECTED) {
//			JOptionPane.showMessageDialog(null,"동의항목에 체크해주시기 바랍니다.");
//			Creditcard_payment frame = new Creditcard_payment();
//			frame.setVisible(true);
//			dispose();
//		}
//		else {
//			Creditcard_payment2 frame = new Creditcard_payment2();
//			frame.setVisible(true);
//			dispose(); //전 창은 없어짐
//		}
//	}
	
	
	public Creditcard_payment() {
		setTitle("Creditcard_payment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		Creditcard_payment_contentPane = new JPanel();
		Creditcard_payment_contentPane.setBackground(SystemColor.desktop);
		Creditcard_payment_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Creditcard_payment_contentPane);
		Creditcard_payment_contentPane.setLayout(null);
		
		JLabel card_JLabel = new JLabel("\uCE74\uB4DC\uACB0\uC81C");
		card_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		card_JLabel.setBounds(61, 66, 123, 59);
		Creditcard_payment_contentPane.add(card_JLabel);
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.setBounds(32, 20, 161, 32);
		Creditcard_payment_contentPane.add(icon_JButton);
		
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
		
		JLabel bank_JLabel = new JLabel("\uC740\uD589");
		bank_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		bank_JLabel.setBounds(44, 135, 55, 59);
		Creditcard_payment_contentPane.add(bank_JLabel);
		
		JRadioButton hd_JRadioButton = new JRadioButton("\uD604\uB300");
		hd_JRadioButton.setSelected(true);
		hd_JRadioButton.setFont(new Font("굴림", Font.BOLD, 20));
		hd_JRadioButton.setBounds(81, 200, 81, 44);
		Creditcard_payment_contentPane.add(hd_JRadioButton);
		
		JRadioButton sh_JRadioButton_1 = new JRadioButton("\uC2E0\uD55C");
		sh_JRadioButton_1.setFont(new Font("굴림", Font.BOLD, 20));
		sh_JRadioButton_1.setBounds(258, 200, 81, 44);
		Creditcard_payment_contentPane.add(sh_JRadioButton_1);
		
		JRadioButton bc_JRadioButton_2 = new JRadioButton("\uBE44\uC528");
		bc_JRadioButton_2.setFont(new Font("굴림", Font.BOLD, 20));
		bc_JRadioButton_2.setBounds(442, 200, 81, 44);
		Creditcard_payment_contentPane.add(bc_JRadioButton_2);
		
		JRadioButton kb_JRadioButton_3 = new JRadioButton("\uAD6D\uBBFC");
		kb_JRadioButton_3.setFont(new Font("굴림", Font.BOLD, 20));
		kb_JRadioButton_3.setBounds(617, 200, 81, 44);
		Creditcard_payment_contentPane.add(kb_JRadioButton_3);
		
		JRadioButton ss_JRadioButton_4 = new JRadioButton("\uC0BC\uC131");
		ss_JRadioButton_4.setFont(new Font("굴림", Font.BOLD, 20));
		ss_JRadioButton_4.setBounds(81, 291, 81, 44);
		Creditcard_payment_contentPane.add(ss_JRadioButton_4);
		
		JRadioButton lt_JRadioButton_5 = new JRadioButton("\uB86F\uB370");
		lt_JRadioButton_5.setFont(new Font("굴림", Font.BOLD, 20));
		lt_JRadioButton_5.setBounds(258, 291, 81, 44);
		Creditcard_payment_contentPane.add(lt_JRadioButton_5);
		
		JRadioButton hn_JRadioButton_6 = new JRadioButton("\uD558\uB098");
		hn_JRadioButton_6.setFont(new Font("굴림", Font.BOLD, 20));
		hn_JRadioButton_6.setBounds(442, 291, 81, 44);
		Creditcard_payment_contentPane.add(hn_JRadioButton_6);
		
		JRadioButton wr_JRadioButton_7 = new JRadioButton("\uC6B0\uB9AC");
		wr_JRadioButton_7.setFont(new Font("굴림", Font.BOLD, 20));
		wr_JRadioButton_7.setBounds(617, 291, 81, 44);
		Creditcard_payment_contentPane.add(wr_JRadioButton_7);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(hd_JRadioButton);
		bg.add(sh_JRadioButton_1);
		bg.add(bc_JRadioButton_2);
		bg.add(kb_JRadioButton_3);
		bg.add(ss_JRadioButton_4);
		bg.add(lt_JRadioButton_5);
		bg.add(hn_JRadioButton_6);
		bg.add(wr_JRadioButton_7);
		
		JCheckBox agreement_JCheckBox = new JCheckBox("                                       \uC0C1\uAE30 \uACB0\uC81C\uB0B4\uC5ED\uC5D0 \uB3D9\uC758\uD569\uB2C8\uB2E4.");
		agreement_JCheckBox.setBounds(158, 397, 478, 43);
		Creditcard_payment_contentPane.add(agreement_JCheckBox);
		
		JButton back_JButton = new JButton("\u261C");
		back_JButton.setFont(new Font("굴림", Font.BOLD, 40));
		back_JButton.setBackground(SystemColor.inactiveCaption);
		back_JButton.setBounds(656, 20, 87, 58);
		Creditcard_payment_contentPane.add(back_JButton);
		
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
		
		JButton next_JButton = new JButton("\uB2E4\uC74C");
		next_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		next_JButton.setBounds(586, 477, 112, 43);
		Creditcard_payment_contentPane.add(next_JButton);
		
		JLabel totalamount_JLabel = new JLabel("\uCD1D\uC8FC\uBB38\uAE08\uC561 :");
		totalamount_JLabel.setFont(new Font("굴림", Font.BOLD, 18));
		totalamount_JLabel.setBounds(443, 88, 123, 59);
		Creditcard_payment_contentPane.add(totalamount_JLabel);
		
//		total_JTextField = new JTextField();
//		total_JTextField.setEnabled(false);
//		total_JTextField.setEditable(false);
//		total_JTextField.setColumns(10);
//		total_JTextField.setBounds(563, 109, 90, 21);
//		Creditcard_payment_contentPane.add(total_JTextField);
		
		if(Client.Client_BMS_main.buyPrice.equals("null")) {
			total_JTextField = new JTextField(Client.Client_BMS_main.borrowPrice);
			total_JTextField.setEditable(false);
			total_JTextField.setEnabled(false);
			total_JTextField.setBounds(563, 109, 90, 21);
			Creditcard_payment_contentPane.add(total_JTextField);
			total_JTextField.setColumns(10);
		}
		else {
			total_JTextField = new JTextField(Client.Client_BMS_main.buyPrice);
			total_JTextField.setEditable(false);
			total_JTextField.setEnabled(false);
			total_JTextField.setBounds(563, 109, 90, 21);
			Creditcard_payment_contentPane.add(total_JTextField);
			total_JTextField.setColumns(10);
		}
		
		JLabel won_JLabel = new JLabel("\uC6D0");
		won_JLabel.setFont(new Font("굴림", Font.BOLD, 18));
		won_JLabel.setBounds(665, 88, 33, 59);
		Creditcard_payment_contentPane.add(won_JLabel);
		
		next_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
			//				itemStateChange(agreement_JCheckBox);
							Creditcard_payment2 frame = new Creditcard_payment2();
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.DESELECTED) {
							JOptionPane.showMessageDialog(null,"동의항목에 체크해주시기 바랍니다.");
							Creditcard_payment frame = new Creditcard_payment();
							frame.setVisible(true);
							dispose();
						}
						else {
							Creditcard_payment2 frame = new Creditcard_payment2();
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
						}
					}				});
			}
		});
	}
}
