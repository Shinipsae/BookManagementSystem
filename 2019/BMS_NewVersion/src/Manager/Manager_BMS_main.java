package Manager;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import Client.Client_BMS_Novel;
import Default.Default_BMS_main;
import Default.Main;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Manager_BMS_main extends JFrame {
	public static String currentManager;

	private JPanel BMS_managermain_contentPane;
	private JTextField Name_JTextField;


	private DefaultTableModel dtm;
	private JTable jtable;
	private JScrollPane jsp;
	private Object[] objColNms = new Object[] { "name", "id", "password","Del" }; //JTable 생성을 위한 컬럼 생성

	public Manager_BMS_main() {
		setTitle("Manager_BMS_main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		BMS_managermain_contentPane = new JPanel();
		BMS_managermain_contentPane.setBackground(SystemColor.desktop);
		BMS_managermain_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BMS_managermain_contentPane);
		BMS_managermain_contentPane.setLayout(null);
		
		JButton icon_JButton = new JButton(new ImageIcon("img/BMS_main.png"));
		icon_JButton.setBounds(32, 20, 161, 32);
		BMS_managermain_contentPane.add(icon_JButton);
		
		JLabel Management_ver_JLabel = new JLabel("(Management Version)");
		Management_ver_JLabel.setFont(new Font("굴림", Font.BOLD, 15));
		Management_ver_JLabel.setBounds(207, 20, 185, 32);
		BMS_managermain_contentPane.add(Management_ver_JLabel);
		
		JLabel Managerpage_JLabel = new JLabel("\uAD00\uB9AC\uC790\uD398\uC774\uC9C0");
		Managerpage_JLabel.setFont(new Font("굴림", Font.BOLD, 22));
		Managerpage_JLabel.setBounds(61, 89, 147, 32);
		BMS_managermain_contentPane.add(Managerpage_JLabel);
		
		JLabel Manager_JLabel = new JLabel("\uAD00\uB9AC\uC790\uB2D8");
		Manager_JLabel.setFont(new Font("굴림", Font.BOLD, 20));
		Manager_JLabel.setBounds(417, 89, 100, 32);
		BMS_managermain_contentPane.add(Manager_JLabel);
		
		JButton Clientlist_JButton = new JButton("\uD68C\uC6D0\uBAA9\uB85D");
		Clientlist_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Clientlist_JButton.setBounds(34, 234, 129, 43);
		BMS_managermain_contentPane.add(Clientlist_JButton);
		
		JButton Addbook_JButton = new JButton("\uB3C4\uC11C\uCD94\uAC00");
		Addbook_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Addbook_JButton.setBounds(34, 337, 129, 43);
		BMS_managermain_contentPane.add(Addbook_JButton);
		
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
		Deletebook_JButton.setBounds(34, 440, 129, 43);
		BMS_managermain_contentPane.add(Deletebook_JButton);
		
		Deletebook_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	// 버튼을 누르면 
							Deletebook frame = new Deletebook(); //서브메인 창으로 이동
							frame.setVisible(true);
							dispose(); //전 창은 없어짐
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		
		JButton Logout_JButton = new JButton("\uB85C\uADF8\uC544\uC6C3");
		Logout_JButton.setFont(new Font("굴림", Font.BOLD, 20));
		Logout_JButton.setBounds(570, 49, 129, 43);
		BMS_managermain_contentPane.add(Logout_JButton);
 
		
		
		
        dtm = new DefaultTableModel(new Object[][] {}, objColNms);
        jtable = new JTable(dtm);
        jtable.getColumnModel().getColumn(3).setCellRenderer(new TableCell()); //네번째 컬럼에 추가
        jtable.getColumnModel().getColumn(3).setCellEditor(new TableCell()); //네번째 컬럼에 추가
        jsp = new JScrollPane(jtable);
        //jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setBounds(207, 213, 481, 279);
		BMS_managermain_contentPane.add(jsp); 
		
		jsp.setVisible(true);
		
		try {
				String sql = "SELECT * FROM client"; //book 데이터 베이스에서 값 불러오기
				Connection conn= DriverManager.getConnection(Main.url, Main.user, Main.password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs= pstmt.executeQuery();
				
				while(rs.next()) {
					String name = rs.getString("name"); 
					String id = rs.getString("id");
					String password = rs.getString("password");
					
					Object data[] = {name, id, password}; //JTable 생성을 위한 컬럼 생성
					dtm.addRow(data);
				} 
		} catch (SQLException e) {
				e.printStackTrace(); //실패시 오류 메세지 출력
		}
	}
	
	@SuppressWarnings("rawtypes")
    public void JTableRemoveRow() {
        int row = jtable.getSelectedRow();
        
        if (row == -1)
            return;
        
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.removeRow(row);
 
        int rowCnt = jtable.getRowCount();
 
        System.out.println(rowCnt);
        
        if (rowCnt > 0) {
            Vector vector = model.getDataVector();
            Object[][] objData = new Object[vector.size()][((Vector) vector.get(0)).size()];
            
            for (int i = 0; i < vector.size(); i++) {
                Vector vec = (Vector) vector.get(i);
                
                for (int j = 0; j < vec.size(); j++) {
                    objData[i][j] = vec.get(j);
                }
            }
 
            DefaultTableModel clonModel = new DefaultTableModel(objData, objColNms);
            JTable clonTable = new JTable(clonModel);
 
            jsp.removeAll();
 

            dtm = new DefaultTableModel(new Object[][] {}, objColNms);
            jtable = new JTable(clonModel);
            jtable.getColumnModel().getColumn(3).setCellRenderer(new TableCell()); //네번째 컬럼에 추가
            jtable.getColumnModel().getColumn(3).setCellEditor(new TableCell()); //네번째 컬럼에 추가
            jsp = new JScrollPane(jtable);
            //jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            jsp.setBounds(207, 213, 481, 279);
    		BMS_managermain_contentPane.add(jsp); 
    		
    		BMS_managermain_contentPane.revalidate();
    		BMS_managermain_contentPane.repaint();
        } else {
            DefaultTableModel clonModel = new DefaultTableModel(null, objColNms);
            JTable clonTable = new JTable(clonModel);
 
            jsp.removeAll();
            
            jtable = clonTable;
            jsp = new JScrollPane(jtable);

            BMS_managermain_contentPane.add(jsp);
            BMS_managermain_contentPane.revalidate();
            BMS_managermain_contentPane.repaint();
        }
    } // end public void JTableRemoveRow()
 
    class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
        JButton jb;
 
        public TableCell() {
            jb = new JButton("삭제");
            jb.addActionListener(e -> {JTableRemoveRow();});
            jb.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
//    				try {
//    					String sql = "INSERT INTO client (?)";
//    					Connection conn= DriverManager.getConnection(Main.url, Main.user, Main.password);
//    					PreparedStatement pstmt = conn.prepareStatement(sql);
//    					ResultSet rs= pstmt.executeQuery();
//    					
//    					while(rs.next()) {
//    						String loanedbook1 = rs.getString("책이름");
//    						Object data[] = {loanedbook1};
//    						dtm.addRow(data);
//    					}
//    				} catch (SQLException e1) {
//    					e1.printStackTrace();
//    				}
    			}
    		});
        }
 
        @Override
        public Object getCellEditorValue() {
            return null;
        }
 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            return jb;
        }
 
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            return jb;
        }
    }
}
