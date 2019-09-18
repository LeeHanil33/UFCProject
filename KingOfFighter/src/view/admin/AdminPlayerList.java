package view.admin;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import dao.AdminDao;
import view.general.Main;
import vo.PlayerVo;

public class AdminPlayerList {

	private JFrame frame;
	AdminDao adminDao = new AdminDao();
	JTable table = new JTable();
	String pro;
	String weightClass;
	String gymName;
	PlayerVo playerVo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPlayerList window = new AdminPlayerList();
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
	public AdminPlayerList() {
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
		
		JLabel btn_playerModifed = new JLabel("");
		btn_playerModifed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(playerVo);
				frame.dispose();
				AdminPlayerModified window = new AdminPlayerModified();
				window.frame.setVisible(true);
				window.receive(playerVo);
			}
		});
		btn_playerModifed.setBounds(357, 497, 198, 41);
		panel.add(btn_playerModifed);
		
		JLabel btn_playerAdd = new JLabel("");
		btn_playerAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PlayerAdd.main(null);
				frame.dispose();
			}
		});
		btn_playerAdd.setBounds(697, 497, 142, 34);
		panel.add(btn_playerAdd);
		
		JLabel btn_player = new JLabel("");
		btn_player.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btn_player.setBounds(14, 194, 81, 23);
		panel.add(btn_player);
		
		JLabel btn_score = new JLabel("");
		btn_score.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, "서비스 준비중 입니다");
			}
		});
		btn_score.setBounds(14, 239, 81, 23);
		panel.add(btn_score);
		
		JLabel btn_match = new JLabel("");
		btn_match.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MatchAdd.main(null);
				frame.dispose();
			}
		});
		btn_match.setBounds(14, 285, 94, 23);
		panel.add(btn_match);
		
		JLabel btn_out = new JLabel("");
		btn_out.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				Main.main(null);
				//System.exit(); 아예 종료
				frame.dispose();
			}
		});
		btn_out.setBounds(1086, 12, 41, 34);
		panel.add(btn_out);
		
		JLabel btn_back = new JLabel("");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main.main(null);
				frame.dispose();
			
			}
		});
		btn_back.setBounds(136, 12, 51, 22);
		panel.add(btn_back);
		
		HashMap<Integer, String> gymList = adminDao.gymList();
		Choice choice_gym = new Choice();
		choice_gym.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(choice_gym.getSelectedIndex() != 0) {
					gymName = choice_gym.getSelectedItem();
					System.out.println(gymName);
					System.out.println(choice_gym.getSelectedIndex());
					ArrayList<PlayerVo> playerList = adminDao.playerList(pro, weightClass, gymName);
					showPlayer(playerList);
				}else {
					gymName = "";
				}
				System.out.println(pro + ", " + weightClass + ","+ gymName+"로 갱신");
			}
		});
		choice_gym.setBounds(173, 119, 396, 24);
		choice_gym.add("GYM");
		for (int i = 1; i < gymList.size(); i++) {
			choice_gym.add(gymList.get(i));
		}
		panel.add(choice_gym);
		
		
		
		Choice choice_proAma = new Choice();
		choice_proAma.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String str = choice_proAma.getSelectedItem();
				if (str.equals("Professional")) {
					pro = "0";
				} else if (str.equals("Amature")) {
					pro = "1";
				}

				if (!weightClass.equals("") && weightClass != null) {
					ArrayList<PlayerVo> playerList = adminDao.playerList(pro, weightClass,gymName);
					showPlayer(playerList);
				}
				System.out.println(pro + ", " + weightClass + ","+ gymName+"로 갱신");
			}
		});
		choice_proAma.setBounds(601, 119, 181, 40);
		choice_proAma.add("Professional");
		choice_proAma.add("Amature");
		choice_proAma.select(0);
		pro = "0";
		panel.add(choice_proAma);
		
		
		
		Choice choice_weightClass = new Choice();
		choice_weightClass.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent item) {
				if (choice_weightClass.getSelectedIndex() != 0) {
					weightClass = choice_weightClass.getSelectedItem();
					ArrayList<PlayerVo> playerList = adminDao.playerList(pro, weightClass,gymName);
					showPlayer(playerList);
					System.out.println(pro + ", " + weightClass + ","+ gymName+"로 갱신");
				}else {
					weightClass = "";
				}
			}
		});
		choice_weightClass.setBounds(808, 119, 238, 24);
		choice_weightClass.add("WeightClass");
		choice_weightClass.add("Flyweight");
		choice_weightClass.add("Bantamweight");
		choice_weightClass.add("Featherweight");
		choice_weightClass.add("Lightweight");
		choice_weightClass.add("Welterweight");
		choice_weightClass.add("Middleweight");
		choice_weightClass.add("Light Heavyweight");
		choice_weightClass.add("Heavyweight");
		choice_weightClass.add("Women's Bantamweight");
		choice_weightClass.add("Women's Featherweight");
		choice_weightClass.add("Women's Flyweight");
		choice_weightClass.add("Women's Strawweight");
		panel.add(choice_weightClass);
		
		
		String header[] = {"Idx" ,"Pro/Amature", "Physics Rating", "Name", "GYM", "Age", "Height", "Weight", "Reach", "Leg Reach",
				"Debut", "Picture","Country","Social_Networks","Status","Gym_idx"};
		ArrayList<PlayerVo> playerList = adminDao.playerList(pro, weightClass,gymName);

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

					if (e.getClickCount() == 1) {

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
						System.out.println(playerVo);
					
//						frame.dispose();
//						PlayerInfo window = new PlayerInfo();
//						window.frame.setVisible(true);
//						window.receive(playerVo);
					}
				}
			}
		});
		
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		table.setBackground(Color.LIGHT_GRAY);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(173, 160, 873, 302);
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
		
		
		
		JLabel lb_Main = new JLabel(new ImageIcon("C:\\JavaWork\\KingofFighter\\image\\Setting1.png"));
		lb_Main.setBounds(0, 0, 1127, 578);
		panel.add(lb_Main);
		
	}
	
	
	public void showPlayer(ArrayList<PlayerVo> list) {
		
		System.out.println(list);
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
