package view.admin;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

public class SignUp {

	private JFrame frame;
	private JTextField tf_id;
	private JTextField tf_pw;
	private JTextField tf_email;
	private JLabel btn_main;
	private JLabel btn_score;
	private JLabel btn_match;
	private JLabel btn_search;
	private JLabel btn_out;
	private int gymnum;
	ArrayList<String> list = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
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
		tf_id.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tf_id.setColumns(10);
		tf_id.setBounds(442, 273, 253, 32);
		panel.add(tf_id);

		tf_pw = new JTextField();
		tf_pw.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tf_pw.setColumns(10);
		tf_pw.setBounds(442, 337, 253, 32);
		panel.add(tf_pw);

		tf_email = new JTextField();
		tf_email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tf_email.setColumns(10);
		tf_email.setBounds(442, 409, 253, 32);
		panel.add(tf_email);

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
		btn_match.setBounds(14, 285, 81, 23);
		panel.add(btn_match);

		Choice choiceGym = new Choice();
		choiceGym.setFont(new Font("Tahoma", Font.PLAIN, 16));
		choiceGym.setBounds(442, 210, 253, 24);
		panel.add(choiceGym);
		KofJoinDao dao = new KofJoinDao();
		choiceGym.add("GYM");
		list = dao.GymCho();
		for (int i = 0; i < list.size(); i++) {
			choiceGym.add(list.get(i));
		}

		JLabel lb_select = new JLabel("");
		lb_select.setForeground(Color.RED);
		lb_select.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lb_select.setBackground(Color.WHITE);
		lb_select.setBounds(442, 243, 173, 18);
		panel.add(lb_select);

		btn_search = new JLabel("");
		btn_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String gym = choiceGym.getSelectedItem();
				KofJoinDao dao = new KofJoinDao();
				gymnum = dao.GymChoice(gym);
				if (gymnum > 0) {
					System.out.println(gymnum);
					lb_select.setText("Success");
				}

			}
		});
		btn_search.setBounds(739, 205, 107, 32);
		panel.add(btn_search);

		JLabel btn_signup = new JLabel("");
		btn_signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String id = tf_id.getText();
				String pw = tf_pw.getText();
				String email = tf_email.getText();

				KofJoinVo vo = new KofJoinVo(id, pw, email);
				KofJoinDao dao = new KofJoinDao();
				int cnt = dao.join(vo, gymnum);

				if (cnt > 0) {
					JOptionPane.showMessageDialog(frame, "관리자 등록 성공");
					AdminLogin.main(null);
					frame.dispose();
				} else {
					tf_id.setText("");
					tf_pw.setText("");
					tf_email.setText("");

				}

			}
		});
		btn_signup.setBounds(874, 273, 168, 100);
		panel.add(btn_signup);

		btn_out = new JLabel("");
		btn_out.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.main(null);
				frame.dispose();
			}
		});
		btn_out.setBounds(1086, 3, 41, 45);
		panel.add(btn_out);

		JLabel btn_back = new JLabel("");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AdminLogin.main(null);
				frame.dispose();

			}
		});
		btn_back.setBounds(134, 3, 53, 41);
		panel.add(btn_back);

		JLabel lb_main = new JLabel(new ImageIcon("C:\\JavaWork\\KingofFighter\\image\\setting5.png"));
		lb_main.setBounds(0, 0, 1127, 578);
		panel.add(lb_main);

	}
}