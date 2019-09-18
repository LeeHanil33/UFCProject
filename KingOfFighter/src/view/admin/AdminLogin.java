package view.admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import dao.KofJoinDao;
import view.general.Main;
import vo.KofJoinVo;

public class AdminLogin {

	private JFrame frame;
	private JTextField tf_id;
	private JTextField tf_pw;
	private JLabel btn_Main;
	private JLabel btn_Score;
	private JLabel btn_match;
	private JLabel btn_signup;
	private JLabel btn_login;
	private JLabel btn_out;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1145, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 578, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 1127, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		tf_id = new JTextField();
		tf_id.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tf_id.setBounds(425, 344, 316, 34);
		panel.add(tf_id);
		tf_id.setColumns(10);
		
		tf_pw = new JTextField();
		tf_pw.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tf_pw.setColumns(10);
		tf_pw.setBounds(425, 395, 316, 34);
		panel.add(tf_pw);
		

		JLabel btn_player = new JLabel("");
		btn_player.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, "로그인 해주세요");
			}
		});
		btn_player.setBounds(14, 194, 81, 23);
		panel.add(btn_player);
		
		JLabel btn_score = new JLabel("");
		btn_score.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, "로그인 해주세요");
			}
		});
		btn_score.setBounds(14, 239, 81, 23);
		panel.add(btn_score);
		
		JLabel btn_match = new JLabel("");
		btn_match.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, "로그인 해주세요");
			}
		});
		btn_match.setBounds(14, 285, 94, 23);
		panel.add(btn_match);
		
		btn_signup = new JLabel("");
		btn_signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp.main(null);
				frame.dispose();
			}
		});
		btn_signup.setBounds(607, 480, 177, 47);
		panel.add(btn_signup);
		
		btn_login = new JLabel("");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = tf_id.getText();
				String pw = tf_pw.getText();
				
				KofJoinVo vo = new KofJoinVo(id, pw);
				KofJoinDao dao = new KofJoinDao();
				String cnt = dao.login(vo);
				
				if(cnt!=null) {
					AdminPlayerList.main(null);
					frame.dispose();
				}else {
					tf_id.setText("");
					tf_pw.setText("");
					
				}
			}
		});
		btn_login.setBounds(830, 354, 143, 85);
		panel.add(btn_login);
		
		btn_out = new JLabel("");
		btn_out.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.main(null);
				//System.exit(); 아예 종료
				frame.dispose();
			}
		});
		btn_out.setBounds(1086, 0, 41, 47);
		panel.add(btn_out);
		
		JLabel btn_back = new JLabel("");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main.main(null);
				frame.dispose();
			}
		});
		btn_back.setBounds(140, 12, 41, 23);
		panel.add(btn_back);
		
		JLabel lb_Main = new JLabel(new ImageIcon("C:\\JavaWork\\KingofFighter\\image\\setting4.png"));
		lb_Main.setBounds(0, 0, 1127, 578);
		panel.add(lb_Main);
	}

}
