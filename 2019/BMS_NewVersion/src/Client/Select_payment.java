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

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Select_payment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Select_payment() {
		setTitle("Select_payment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Select_JLabel = new JLabel("\uACB0\uC81C \uC218\uB2E8\uC744 \uC120\uD0DD\uD558\uC138\uC694.");
		Select_JLabel.setFont(new Font("±¼¸²", Font.BOLD, 15));
		Select_JLabel.setBounds(108, 77, 175, 35);
		contentPane.add(Select_JLabel);
		
		JButton Card_JButton = new JButton("\uCE74\uB4DC");
		Card_JButton.setFont(new Font("±¼¸²", Font.BOLD, 20));
		Card_JButton.setBounds(33, 157, 142, 43);
		contentPane.add(Card_JButton);
		
		Card_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Creditcard_payment frame = new Creditcard_payment();
							frame.setVisible(true);
							dispose(); //Àü Ã¢Àº ¾ø¾îÁü
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton Cash_JButton = new JButton("\uBB34\uD1B5\uC7A5\uC785\uAE08");
		Cash_JButton.setFont(new Font("±¼¸²", Font.BOLD, 20));
		Cash_JButton.setBounds(194, 157, 156, 43);
		contentPane.add(Cash_JButton);
		
		Cash_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Cash_payment frame = new Cash_payment();
							frame.setVisible(true);
							dispose(); //Àü Ã¢Àº ¾ø¾îÁü
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton back_JButton = new JButton("\u261C");
		back_JButton.setFont(new Font("±¼¸²", Font.BOLD, 40));
		back_JButton.setBackground(SystemColor.inactiveCaption);
		back_JButton.setBounds(279, 10, 93, 57);
		contentPane.add(back_JButton);
		
		back_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Client_BMS_main frame = new Client_BMS_main();
							frame.setVisible(true);
							dispose(); //Àü Ã¢Àº ¾ø¾îÁü
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}
}
