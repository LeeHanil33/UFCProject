package view.general;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import dao.PlayerDao;
import view.admin.AdminLogin;
import vo.PlayerVo;
import vo.RankVo;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class Rank {

	JFrame frame;
	ArrayList<String> player = new ArrayList<String>();
	JTextField tf_keyword;
	PlayerDao playerDao = new PlayerDao();
	RankVo rankVo;
	ArrayList<RankVo> list = new ArrayList<>();
	JLabel fly1, fly2, fly3, bantam1, bantam2, bantam3, feather1, feather2, feather3, welter1, welter2, welter3;
	private JLabel light1;
	private JLabel light2;
	private JLabel light3;
	private JLabel middle1;
	private JLabel middle2;
	private JLabel middle3;
	private JLabel lightHeavy1;
	private JLabel lightHeavy2;
	private JLabel lightHeavy3;
	private JLabel heavy1;
	private JLabel heavy2;
	private JLabel heavy3;
	private JLabel straw1;
	private JLabel straw2;
	private JLabel straw3;
	private JLabel wFly1;
	private JLabel wFly2;
	private JLabel wFly3;
	private JLabel wBantam1;
	private JLabel wBantam2;
	private JLabel wBantam3;
	private JLabel wFeather1;
	private JLabel wFeather2;
	private JLabel wFeather3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Rank window = new Rank();
					window.callRankList();
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
	public Rank() {
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
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 579, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 1129, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lb_main = new JLabel("");
		lb_main.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				Main.main(null);
				frame.dispose(); // ÇöÀçÃ¢¸¸ Á¾·á
			}
		});

		JLabel lb_rank = new JLabel("");
		lb_rank.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Rank.main(null);
				frame.dispose();
			}
		});

		JLabel btn_main = new JLabel("");
		btn_main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.main(null);
				frame.dispose();
			}
		});
		btn_main.setBounds(25, 188, 71, 31);
		panel.add(btn_main);

		JLabel btn_rank = new JLabel("");
		btn_rank.setBounds(25, 231, 71, 31);
		panel.add(btn_rank);

		JLabel btn_player = new JLabel("");
		btn_player.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.dispose(); // ÇöÀçÃ¢¸¸ Á¾·á
				Player window = new Player();
				window.frame.setVisible(true);
			}
		});

		btn_player.setBounds(25, 271, 71, 31);
		panel.add(btn_player);

		JLabel btn_out = new JLabel("");
		btn_out.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.main(null);
				// System.exit(); ¾Æ¿¹ Á¾·á
				frame.dispose();
			}
		});
		btn_out.setBounds(1086, 0, 43, 45);
		panel.add(btn_out);

		JLabel btn_back = new JLabel("");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.main(null);
				// System.exit(); ¾Æ¿¹ Á¾·á
				frame.dispose();
			}
		});
		btn_back.setBounds(131, 0, 59, 45);
		panel.add(btn_back);

		JLabel btnGoAdmin = new JLabel("");
		btnGoAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLogin.main(null);
				frame.dispose();
			}
		});
		btnGoAdmin.setBounds(1043, 0, 43, 45);
		panel.add(btnGoAdmin);

		tf_keyword = new JTextField();
		tf_keyword.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		tf_keyword.setBounds(799, 12, 171, 27);
		tf_keyword.setBorder(null);
		tf_keyword.setOpaque(false);
		tf_keyword.setColumns(10);
		panel.add(tf_keyword);

		JLabel btnSearch = new JLabel("");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String keyword = tf_keyword.getText();
				ArrayList<PlayerVo> playerList = playerDao.searchKeyword(keyword);
				frame.dispose();
				Player window = new Player();
				window.frame.setVisible(true);
				window.showPlayer(playerList);
//				showPlayer(playerList);
//				selectWeightClass.select(0);
			}
		});
		btnSearch.setBounds(984, 12, 37, 27);
		panel.add(btnSearch);

		fly1 = new JLabel("");
		fly1.setHorizontalAlignment(SwingConstants.LEFT);
		fly1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		fly1.setBounds(199, 122, 204, 27);
		panel.add(fly1);

		fly2 = new JLabel("");
		fly2.setHorizontalAlignment(SwingConstants.LEFT);
		fly2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		fly2.setBounds(199, 150, 204, 27);
		panel.add(fly2);

		fly3 = new JLabel("");
		fly3.setHorizontalAlignment(SwingConstants.LEFT);
		fly3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		fly3.setBounds(199, 178, 204, 27);
		panel.add(fly3);

		bantam1 = new JLabel("");
		bantam1.setHorizontalAlignment(SwingConstants.LEFT);
		bantam1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		bantam1.setBounds(437, 178, 162, 27);
		panel.add(bantam1);

		bantam2 = new JLabel("");
		bantam2.setHorizontalAlignment(SwingConstants.LEFT);
		bantam2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		bantam2.setBounds(437, 150, 162, 27);
		panel.add(bantam2);

		bantam3 = new JLabel("");
		bantam3.setHorizontalAlignment(SwingConstants.LEFT);
		bantam3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		bantam3.setBounds(437, 122, 162, 27);
		panel.add(bantam3);

		feather1 = new JLabel("");
		feather1.setHorizontalAlignment(SwingConstants.LEFT);
		feather1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		feather1.setBounds(651, 122, 162, 27);
		panel.add(feather1);

		feather2 = new JLabel("");
		feather2.setHorizontalAlignment(SwingConstants.LEFT);
		feather2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		feather2.setBounds(651, 150, 162, 27);
		panel.add(feather2);

		feather3 = new JLabel("");
		feather3.setHorizontalAlignment(SwingConstants.LEFT);
		feather3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		feather3.setBounds(651, 178, 162, 27);
		panel.add(feather3);

		welter1 = new JLabel("");
		welter1.setHorizontalAlignment(SwingConstants.LEFT);
		welter1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		welter1.setBounds(882, 122, 162, 27);
		panel.add(welter1);

		welter2 = new JLabel("");
		welter2.setHorizontalAlignment(SwingConstants.LEFT);
		welter2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		welter2.setBounds(882, 150, 162, 27);
		panel.add(welter2);

		welter3 = new JLabel("");
		welter3.setHorizontalAlignment(SwingConstants.LEFT);
		welter3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		welter3.setBounds(882, 178, 162, 27);
		panel.add(welter3);

		light1 = new JLabel("");
		light1.setHorizontalAlignment(SwingConstants.LEFT);
		light1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		light1.setBounds(187, 271, 205, 27);
		panel.add(light1);

		light2 = new JLabel("");
		light2.setHorizontalAlignment(SwingConstants.LEFT);
		light2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		light2.setBounds(187, 299, 205, 27);
		panel.add(light2);

		light3 = new JLabel("");
		light3.setHorizontalAlignment(SwingConstants.LEFT);
		light3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		light3.setBounds(187, 327, 205, 27);
		panel.add(light3);

		middle1 = new JLabel("");
		middle1.setHorizontalAlignment(SwingConstants.LEFT);
		middle1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		middle1.setBounds(426, 271, 162, 27);
		panel.add(middle1);

		middle2 = new JLabel("");
		middle2.setHorizontalAlignment(SwingConstants.LEFT);
		middle2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		middle2.setBounds(426, 299, 162, 27);
		panel.add(middle2);

		middle3 = new JLabel("");
		middle3.setHorizontalAlignment(SwingConstants.LEFT);
		middle3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		middle3.setBounds(426, 327, 162, 27);
		panel.add(middle3);

		lightHeavy1 = new JLabel("");
		lightHeavy1.setHorizontalAlignment(SwingConstants.LEFT);
		lightHeavy1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lightHeavy1.setBounds(640, 271, 162, 27);
		panel.add(lightHeavy1);

		lightHeavy2 = new JLabel("");
		lightHeavy2.setHorizontalAlignment(SwingConstants.LEFT);
		lightHeavy2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lightHeavy2.setBounds(640, 299, 162, 27);
		panel.add(lightHeavy2);

		lightHeavy3 = new JLabel("");
		lightHeavy3.setHorizontalAlignment(SwingConstants.LEFT);
		lightHeavy3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lightHeavy3.setBounds(640, 327, 162, 27);
		panel.add(lightHeavy3);

		heavy1 = new JLabel("");
		heavy1.setHorizontalAlignment(SwingConstants.LEFT);
		heavy1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		heavy1.setBounds(871, 271, 162, 27);
		panel.add(heavy1);

		heavy2 = new JLabel("");
		heavy2.setHorizontalAlignment(SwingConstants.LEFT);
		heavy2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		heavy2.setBounds(871, 299, 162, 27);
		panel.add(heavy2);

		heavy3 = new JLabel("");
		heavy3.setHorizontalAlignment(SwingConstants.LEFT);
		heavy3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		heavy3.setBounds(871, 327, 162, 27);
		panel.add(heavy3);
		
		straw1 = new JLabel("");
		straw1.setHorizontalAlignment(SwingConstants.LEFT);
		straw1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		straw1.setBounds(216, 431, 176, 27);
		panel.add(straw1);
		
		straw2 = new JLabel("");
		straw2.setHorizontalAlignment(SwingConstants.LEFT);
		straw2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		straw2.setBounds(216, 459, 176, 27);
		panel.add(straw2);
		
		straw3 = new JLabel("");
		straw3.setHorizontalAlignment(SwingConstants.LEFT);
		straw3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		straw3.setBounds(216, 487, 176, 27);
		panel.add(straw3);
		
		wFly1 = new JLabel("");
		wFly1.setHorizontalAlignment(SwingConstants.LEFT);
		wFly1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		wFly1.setBounds(406, 431, 193, 27);
		panel.add(wFly1);
		
		wFly2 = new JLabel("");
		wFly2.setHorizontalAlignment(SwingConstants.LEFT);
		wFly2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		wFly2.setBounds(406, 459, 193, 27);
		panel.add(wFly2);
		
		wFly3 = new JLabel("");
		wFly3.setHorizontalAlignment(SwingConstants.LEFT);
		wFly3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		wFly3.setBounds(406, 487, 193, 27);
		panel.add(wFly3);
		
		wBantam1 = new JLabel("");
		wBantam1.setHorizontalAlignment(SwingConstants.LEFT);
		wBantam1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		wBantam1.setBounds(640, 431, 162, 27);
		panel.add(wBantam1);
		
		wBantam2 = new JLabel("");
		wBantam2.setHorizontalAlignment(SwingConstants.LEFT);
		wBantam2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		wBantam2.setBounds(640, 459, 162, 27);
		panel.add(wBantam2);
		
		wBantam3 = new JLabel("");
		wBantam3.setHorizontalAlignment(SwingConstants.LEFT);
		wBantam3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		wBantam3.setBounds(640, 487, 162, 27);
		panel.add(wBantam3);
		
		wFeather1 = new JLabel("");
		wFeather1.setHorizontalAlignment(SwingConstants.LEFT);
		wFeather1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		wFeather1.setBounds(851, 431, 193, 27);
		panel.add(wFeather1);
		
		wFeather2 = new JLabel("");
		wFeather2.setHorizontalAlignment(SwingConstants.LEFT);
		wFeather2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		wFeather2.setBounds(851, 459, 193, 27);
		panel.add(wFeather2);
		
		wFeather3 = new JLabel("");
		wFeather3.setHorizontalAlignment(SwingConstants.LEFT);
		wFeather3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		wFeather3.setBounds(851, 487, 193, 27);
		panel.add(wFeather3);
		
				JLabel lb_Player = new JLabel(new ImageIcon("C:\\JavaWork\\KingofFighter\\image\\rank_4.png"));
				lb_Player.setBackground(Color.BLACK);
				lb_Player.setBounds(0, 0, 1129, 579);
				panel.add(lb_Player);

	}

	public void callRankList() {
		list = playerDao.rankList();
		System.out.println(list);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPhysique_rating().equals("Flyweight")) {
				if (list.get(i).getRank() == 1) {
					fly1.setText(list.get(i).getName());
				} else if (list.get(i).getRank() == 2) {
					fly2.setText(list.get(i).getName());
				} else if (list.get(i).getRank() == 3) {
					fly3.setText(list.get(i).getName());
				}
			} else if (list.get(i).getPhysique_rating().equals("Bantamweight")) {
				if (list.get(i).getRank() == 1) {
					bantam1.setText(list.get(i).getName());
				} else if (list.get(i).getRank() == 2) {
					bantam2.setText(list.get(i).getName());
				} else if (list.get(i).getRank() == 3) {
					bantam3.setText(list.get(i).getName());
				}
			} else if (list.get(i).getPhysique_rating().equals("Featherweight")) {
				if (list.get(i).getRank() == 1) {
					feather1.setText(list.get(i).getName());
				} else if (list.get(i).getRank() == 2) {
					feather2.setText(list.get(i).getName());
				} else if (list.get(i).getRank() == 3) {
					feather3.setText(list.get(i).getName());
				}
			} else if (list.get(i).getPhysique_rating().equals("Welterweight")) {
				if (list.get(i).getRank() == 1) {
					welter1.setText(list.get(i).getName());
				} else if (list.get(i).getRank() == 2) {
					welter2.setText(list.get(i).getName());
				} else if (list.get(i).getRank() == 3) {
					welter3.setText(list.get(i).getName());
				}
			} else if (list.get(i).getPhysique_rating().equals("Lightweight")) {
				if (list.get(i).getRank() == 1) {
					light1.setText(list.get(i).getName());
				} else if (list.get(i).getRank() == 2) {
					light2.setText(list.get(i).getName());
				} else if (list.get(i).getRank() == 3) {
					light3.setText(list.get(i).getName());
				}
			} else if (list.get(i).getPhysique_rating().equals("Middleweight")) {
				if (list.get(i).getRank() == 1) {
					middle1.setText(list.get(i).getName());
				} else if (list.get(i).getRank() == 2) {
					middle2.setText(list.get(i).getName());
				} else if (list.get(i).getRank() == 3) {
					middle3.setText(list.get(i).getName());
				}
			} else if (list.get(i).getPhysique_rating().equals("Light Heavyweight")) {
				if (list.get(i).getRank() == 1) {
					lightHeavy1.setText(list.get(i).getName());
				} else if (list.get(i).getRank() == 2) {
					lightHeavy2.setText(list.get(i).getName());
				} else if (list.get(i).getRank() == 3) {
					lightHeavy3.setText(list.get(i).getName());
				}
			}else if(list.get(i).getPhysique_rating().equals("Heavyweight")) {
				if(list.get(i).getRank()==1) {
					heavy1.setText(list.get(i).getName());
				}else if(list.get(i).getRank()==2) {
					heavy2.setText(list.get(i).getName());		
				}else if(list.get(i).getRank()==3) {
					heavy3.setText(list.get(i).getName());
				}	
			}else if(list.get(i).getPhysique_rating().equals("Women's Strawweight")) {
				if(list.get(i).getRank()==1) {
					straw1.setText(list.get(i).getName());
				}else if(list.get(i).getRank()==2) {
					straw2.setText(list.get(i).getName());		
				}else if(list.get(i).getRank()==3) {
					straw3.setText(list.get(i).getName());
				}	
			}else if(list.get(i).getPhysique_rating().equals("Women's Flyweight")) {
				if(list.get(i).getRank()==1) {
					wFly1.setText(list.get(i).getName());
				}else if(list.get(i).getRank()==2) {
					wFly2.setText(list.get(i).getName());		
				}else if(list.get(i).getRank()==3) {
					wFly3.setText(list.get(i).getName());
				}	
			}else if(list.get(i).getPhysique_rating().equals("Women's Featherweight")) {
				if(list.get(i).getRank()==1) {
					wFeather1.setText(list.get(i).getName());
				}else if(list.get(i).getRank()==2) {
					wFeather2.setText(list.get(i).getName());		
				}else if(list.get(i).getRank()==3) {
					wFeather3.setText(list.get(i).getName());
				}	
			}else if(list.get(i).getPhysique_rating().equals("Women's Bantamweight")) {
				if(list.get(i).getRank()==1) {
					wBantam1.setText(list.get(i).getName());
				}else if(list.get(i).getRank()==2) {
					wBantam2.setText(list.get(i).getName());		
				}else if(list.get(i).getRank()==3) {
					wBantam3.setText(list.get(i).getName());
				}	
			}
		}

	}
}
