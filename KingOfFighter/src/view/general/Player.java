package view.general;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.PlayerDao;
import view.admin.AdminLogin;
import vo.PlayerVo;

public class Player {

	JFrame frame;
	JPanel panel = new JPanel();
	private JTable table = new JTable();
	PlayerDao playerDao = new PlayerDao();
	String pro = "0";
	String weightClass = "";
	private JTextField tf_keyword;
	PlayerVo playerVo;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Player window = new Player();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Player() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1145, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1127, 578);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel btnGoPlayer = new JLabel("");
		btnGoPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnGoPlayer.setBounds(24, 273, 88, 30);
		panel.add(btnGoPlayer);

		JLabel btnGoRank = new JLabel("");
		btnGoRank.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Rank.main(null);
				frame.dispose();
			}
		});
		btnGoRank.setBounds(24, 229, 88, 28);
		panel.add(btnGoRank);

		JLabel btnGoMain = new JLabel("");
		btnGoMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.main(null);
				frame.dispose();
			}
		});
		btnGoMain.setBounds(24, 185, 88, 33);
		panel.add(btnGoMain);

		Choice selectProAma = new Choice();
		selectProAma.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String str = selectProAma.getSelectedItem();
				if (str.equals("Professional")) {
					pro = "0";
				} else if (str.equals("Amature")) {
					pro = "1";
				}

				if (!weightClass.equals("") && weightClass != null) {
					ArrayList<PlayerVo> playerList = playerDao.playerList(pro, weightClass);
					showPlayer(playerList);
				}
				System.out.println(pro + ", " + weightClass + "로 갱신");
			}
		});
		selectProAma.setBounds(202, 85, 181, 40);
		selectProAma.add("Professional");
		selectProAma.add("Amateur");
		selectProAma.select(0);
		pro = "0";
		panel.add(selectProAma);

		Choice selectWeightClass = new Choice();
		selectWeightClass.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent item) {
				if (selectWeightClass.getSelectedIndex() != 0) {
					weightClass = selectWeightClass.getSelectedItem();
					ArrayList<PlayerVo> playerList = playerDao.playerList(pro, weightClass);
					showPlayer(playerList);
					System.out.println(pro + ", " + weightClass + "로 갱신");
				}
			}
		});
		selectWeightClass.setBounds(855, 85, 220, 24);
		selectWeightClass.add("WeightClass");
		selectWeightClass.add("Flyweight");
		selectWeightClass.add("Bantamweight");
		selectWeightClass.add("Featherweight");
		selectWeightClass.add("Lightweight");
		selectWeightClass.add("Welterweight");
		selectWeightClass.add("Middleweight");
		selectWeightClass.add("Light Heavyweight");
		selectWeightClass.add("Heavyweight");
		selectWeightClass.add("Women's Bantamweight");
		selectWeightClass.add("Women's Featherweight");
		selectWeightClass.add("Women's Flyweight");
		selectWeightClass.add("Women's Strawweight");
		panel.add(selectWeightClass);

		String header[] = {"Idx" ,"Pro/Amature", "Physics Rating", "Name", "GYM", "Age", "Height", "Weight", "Reach", "Leg Reach",
				"Debut", "Picture","Country","Social_Networks","Status","Gym_idx" };
		ArrayList<PlayerVo> playerList = playerDao.playerList(pro, weightClass);

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		for (int i = 0; i < header.length; i++) {
			dtm.addColumn(header[i]);
		}

		showPlayer(playerList);

		table = new JTable(dtm) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.rowAtPoint(e.getPoint());
				int columns = table.columnAtPoint(e.getPoint());

				if (row >= 0 && columns >= 0) {

					JTable t = (JTable) e.getSource();

					if (e.getClickCount() == 2) {

						DefaultTableModel m = (DefaultTableModel) t.getModel();

						// 테이블 행을 선택하면 해당 행 읽기
						int idx = (int) m.getValueAt(row, 0);
						String pro = (String) m.getValueAt(row, 1);
						String physiqueRating = (String) m.getValueAt(row, 2);
						String name = (String) m.getValueAt(row, 3);
						String gym = (String) m.getValueAt(row, 4);
						int age = (int) m.getValueAt(row, 5);
						double height = (double) m.getValueAt(row, 6);
						double weight = (double) m.getValueAt(row, 7);
						double reach = (double) m.getValueAt(row, 8);
						double legReach = (double) m.getValueAt(row, 9);
						String debut = (String) m.getValueAt(row, 10);
						String picture = (String) m.getValueAt(row, 11);
						String country = (String)m.getValueAt(row, 12);
						String socialNetworks = (String)m.getValueAt(row, 13);
						String status = (String)m.getValueAt(row, 14);
						int gym_idx = (int)m.getValueAt(row, 15);
						System.out.println(idx+", "+pro + ", " + physiqueRating + ", " + name + ", " + gym + ", " + age + ", "
								+ height + ", " + weight + ", " + reach + ", " + legReach + ", " + debut + ", "
								+ picture+", "+country+", "+socialNetworks+", "+status+","+gym_idx);

						playerVo = new PlayerVo(idx ,pro, physiqueRating, name, gym, age, height, weight, reach,
								legReach, debut, picture, country, socialNetworks, status,gym_idx);
					
						frame.dispose();
						PlayerInfo window = new PlayerInfo();
						window.frame.setVisible(true);
						window.receive(playerVo);
					}
				}
			}
		});

		table.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		table.setBackground(Color.LIGHT_GRAY);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(202, 126, 873, 407);
		table.setBounds(202, 147, 873, 407);
		table.getColumn("Picture").setWidth(0);
		table.getColumn("Picture").setMinWidth(0);
		table.getColumn("Picture").setMaxWidth(0);
		table.getColumn("Country").setWidth(0);
		table.getColumn("Country").setMinWidth(0);
		table.getColumn("Country").setMaxWidth(0);
		table.getColumn("Idx").setWidth(0);
		table.getColumn("Idx").setMinWidth(0);
		table.getColumn("Idx").setMaxWidth(0);
		table.getColumn("Social_Networks").setWidth(0);
		table.getColumn("Social_Networks").setMinWidth(0);
		table.getColumn("Social_Networks").setMaxWidth(0);
		table.getColumn("Status").setWidth(0);
		table.getColumn("Status").setMinWidth(0);
		table.getColumn("Status").setMaxWidth(0);
		table.getColumn("Gym_idx").setWidth(0);
		table.getColumn("Gym_idx").setMinWidth(0);
		table.getColumn("Gym_idx").setMaxWidth(0);
		
		
		panel.add(scrollPane);

		tf_keyword = new JTextField();
		tf_keyword.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tf_keyword.setBounds(829, 12, 170, 25);
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
				showPlayer(playerList);
//				selectWeightClass.select(0);
			}
		});
		btnSearch.setBounds(1004, 9, 37, 36);
		panel.add(btnSearch);
		
		JLabel btnOut = new JLabel("");
		btnOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.main(null);
				frame.dispose();
			}
		});
		btnOut.setBounds(1090, 9, 37, 30);
		panel.add(btnOut);
		
		JLabel btnGoAdmin = new JLabel("");
		btnGoAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLogin.main(null);
				frame.dispose();
			}
		});
		btnGoAdmin.setBounds(1052, 9, 37, 32);
		panel.add(btnGoAdmin);

		JLabel BackgroundImg = new JLabel(new ImageIcon("C:\\JavaWork\\KingOfFighter\\image\\playerList.png"));
		BackgroundImg.setBounds(0, 0, 1127, 578);
		panel.add(BackgroundImg);

	}

	public void showPlayer(ArrayList<PlayerVo> list) {

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		table = new JTable(dtm) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		Object[] data = new Object[16];

		for (PlayerVo vo : list) {
			data[0] = vo.getIdx();
			data[1] = vo.getPro();
			data[2] = vo.getPhysique_rating();
			data[3] = vo.getName();
			data[4] = vo.getGym();
			data[5] = vo.getAge();
			data[6] = vo.getHeight();
			data[7] = vo.getWeight();
			data[8] = vo.getReach();
			data[9] = vo.getLeg_reach();
			data[10] = vo.getDebut();
			data[11] = vo.getPicture();
			data[12] = vo.getCountry();
			data[13] = vo.getSocial_networks();
			data[14] = vo.getStatus();
			data[15] = vo.getGym_idx();
			dtm.addRow(data);
		}

	}
}
