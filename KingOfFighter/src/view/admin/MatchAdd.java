package view.admin;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import dao.MatchDAO;
import view.general.Main;
import vo.MatchVO;

public class MatchAdd {

	private JFrame frame;
	private JTextField tf_match;
	private JTextField tf_date;
	private JTextField tf_round;
	private JTextField tf_time;
	ArrayList<String> list = new ArrayList<String>();
	String aPlayer = null;
	String bPlayer = null;
	Choice choice_winner;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchAdd window = new MatchAdd();
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
	public MatchAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MatchDAO mdao = new MatchDAO();

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

		JLabel lblAPlayer = new JLabel("A PLAYER");
		lblAPlayer.setForeground(Color.GRAY);
		lblAPlayer.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		lblAPlayer.setBounds(212, 309, 151, 23);
		panel.add(lblAPlayer);

		JLabel lblBPlayer = new JLabel("B PLAYER");
		lblBPlayer.setForeground(Color.GRAY);
		lblBPlayer.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		lblBPlayer.setBounds(894, 309, 151, 23);
		panel.add(lblBPlayer);

		JLabel lblRound = new JLabel("ROUND");
		lblRound.setForeground(Color.GRAY);
		lblRound.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		lblRound.setBounds(565, 200, 122, 23);
		panel.add(lblRound);

		JLabel lblTime = new JLabel("TIME");
		lblTime.setForeground(Color.GRAY);
		lblTime.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		lblTime.setBounds(577, 274, 70, 23);
		panel.add(lblTime);

		JLabel lblMethod = new JLabel("WIN METHOD");
		lblMethod.setForeground(Color.GRAY);
		lblMethod.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		lblMethod.setBounds(528, 352, 184, 23);
		panel.add(lblMethod);

		JLabel lblWinner = new JLabel("WINNER");
		lblWinner.setForeground(new Color(255, 102, 51));
		lblWinner.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lblWinner.setBounds(552, 434, 147, 23);
		panel.add(lblWinner);

		Choice choice_winmethod = new Choice();
		choice_winmethod.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));
		choice_winmethod.setBounds(511, 389, 212, 24);
		panel.add(choice_winmethod);
		choice_winmethod.add("(Win Method)");
		choice_winmethod.add("DEC");
		choice_winmethod.add("Knock Out");
		choice_winmethod.add("SubMission");
		choice_winmethod.add("TKO");
		choice_winmethod.add("Unanimous Decision");	
		

		JLabel lblDay = new JLabel("DATE");
		lblDay.setForeground(Color.GRAY);
		lblDay.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 19));
		lblDay.setBounds(165, 181, 62, 18);
		panel.add(lblDay);

		tf_date = new JTextField();
		tf_date.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));
		tf_date.setColumns(10);
		tf_date.setBounds(249, 179, 139, 24);
		panel.add(tf_date);

		tf_round = new JTextField();
		tf_round.setHorizontalAlignment(SwingConstants.CENTER);
		tf_round.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		tf_round.setColumns(10);
		tf_round.setBounds(558, 238, 107, 24);
		panel.add(tf_round);

		tf_time = new JTextField();
		tf_time.setHorizontalAlignment(SwingConstants.CENTER);
		tf_time.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		tf_time.setColumns(10);
		tf_time.setBounds(558, 309, 107, 24);
		panel.add(tf_time);

		JLabel btn_player = new JLabel("");
		btn_player.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminPlayerList.main(null);
				frame.dispose();
			}
		});
		btn_player.setBounds(14, 194, 81, 23);
		panel.add(btn_player);

		JLabel btn_score = new JLabel("");
		btn_score.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, "¼­ºñ½º ÁØºñÁß ÀÔ´Ï´Ù");
			}
		});
		btn_score.setBounds(14, 239, 81, 23);
		panel.add(btn_score);

		JLabel btn_match = new JLabel("");
		btn_match.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btn_match.setBounds(14, 285, 94, 23);
		panel.add(btn_match);

		JLabel btn_out = new JLabel("");
		btn_out.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent e) {
				Main.main(null);
				// System.exit(); ¾Æ¿¹ Á¾·á
				frame.dispose();
			}
		});
		btn_out.setBounds(1086, 12, 41, 34);
		panel.add(btn_out);

		JLabel btn_back = new JLabel("");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AdminPlayerList.main(null);
				frame.dispose();

			}
		});
		btn_back.setBounds(140, 12, 41, 23);
		panel.add(btn_back);

		Choice ch_a_player = new Choice();
		ch_a_player.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));
		ch_a_player.setBounds(175, 346, 200, 24);
		panel.add(ch_a_player);
		String a = "(A PLAYER)";
		ch_a_player.add(a);
		list = mdao.player();
		for (int i = 0; i < list.size(); i++) {
			ch_a_player.add(list.get(i));
		}
		
		ch_a_player.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(ch_a_player.getSelectedIndex() > 0) {
					aPlayer = ch_a_player.getSelectedItem();					
				}else {
					aPlayer = null;
				}
				
				if(aPlayer != null && bPlayer != null) {
					System.out.println(aPlayer+", "+bPlayer);
					choice_winner.removeAll();
					choice_winner.add("(WINNER)");
					choice_winner.add(aPlayer);
					choice_winner.add(bPlayer);
				}
			}
		});

		Choice ch_b_player = new Choice();
		ch_b_player.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));
		ch_b_player.setBounds(859, 346, 212, 34);
		panel.add(ch_b_player);
		String b = "(B PLAYER)";
		ch_b_player.add(b);
		for (int i = 0; i < list.size(); i++) {
			ch_b_player.add(list.get(i));
		}
		ch_b_player.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(ch_b_player.getSelectedIndex() > 0) {
					bPlayer = ch_b_player.getSelectedItem();					
				}else {
					bPlayer = null;
				}
				
				if(aPlayer != null && bPlayer != null) {
					System.out.println(aPlayer+", "+bPlayer);
					choice_winner.removeAll();
					choice_winner.add("(WINNER)");
					choice_winner.add(aPlayer);
					choice_winner.add(bPlayer);
				}
			}
		});
		
		

		JLabel lblNewLabel = new JLabel("MATCH");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 19));
		lblNewLabel.setBounds(165, 131, 70, 18);
		panel.add(lblNewLabel);

		tf_match = new JTextField();
		tf_match.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));
		tf_match.setBounds(249, 129, 280, 24);
		panel.add(tf_match);
		tf_match.setColumns(10);

		choice_winner = new Choice();
		choice_winner.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));
		choice_winner.setBounds(511, 473, 212, 24);
		panel.add(choice_winner);
		choice_winner.add("(WINNER)");
		
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a_Player = ch_a_player.getSelectedItem();
				String b_Player = ch_b_player.getSelectedItem();
				String winMethod = choice_winmethod.getSelectedItem();
				String winner = choice_winner.getSelectedItem();
				String date = tf_date.getText();
				String time = tf_time.getText();
				String match = tf_match.getText();
				int round = Integer.parseInt(tf_round.getText());
				MatchDAO mdao = new MatchDAO();
				
				int a_PlayerNum = mdao.selectPlayer(a_Player);
				int b_PlayerNum = mdao.selectPlayer(b_Player);
				int winnerNum = mdao.selectPlayer(winner);
				MatchVO mvo = new MatchVO(a_PlayerNum, b_PlayerNum, winMethod, winnerNum, date, time, match, round);
				
				
				int cnt = mdao.AddMatch(mvo);
				
				if(cnt > 0) {
					JOptionPane.showMessageDialog(frame, "¸ÅÄ¡Á¤º¸°¡ ¼º°øÀûÀ¸·Î µî·ÏµÇ¾ú½À´Ï´Ù");
					AdminPlayerList.main(null);
					frame.dispose();
				}		
			}
		});
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setBackground(new Color(255, 204, 153));
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		btnNewButton.setBounds(954, 508, 139, 40);
		panel.add(btnNewButton);
		

		JLabel lb_Main = new JLabel(new ImageIcon("C:\\JavaWork\\KingofFighter\\image\\MatchGameAdd.png"));
		lb_Main.setBounds(0, 0, 1127, 578);
		panel.add(lb_Main);
	}
}