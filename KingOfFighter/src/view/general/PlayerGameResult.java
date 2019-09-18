package view.general;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import vo.GameResultVo;
import vo.PlayerVo;

public class PlayerGameResult {

	JFrame frame;
	JLabel btnGoMain, btnGoPlayer, btnGoRank, profileImg;
	JTextField tf_keyword;
	JTable table = new JTable();
	PlayerDao playerDao = new PlayerDao();
	PlayerVo playerVo = new PlayerVo();
	int idx;
	private JLabel btnGoSns;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PlayerGameResult window = new PlayerGameResult();
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
	public PlayerGameResult() {
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
		
		profileImg = new JLabel("");
		profileImg.setBounds(127, 46, 316, 445);
		panel.add(profileImg);	
		
		tf_keyword = new JTextField();
		tf_keyword.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		tf_keyword.setBounds(829, 12, 163, 27);
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
		btnSearch.setBounds(1003, 12, 37, 27);
		panel.add(btnSearch);
		
		
		String header[] = {"Day","Match","Physique-Rating","Opponent","Round","Play Time","Judgement" };
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		for (int i = 0; i < header.length; i++) {
			dtm.addColumn(header[i]);
		}
		

		table = new JTable(dtm) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		table.setBackground(Color.LIGHT_GRAY);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(470, 92, 611, 407);
		table.setBounds(202, 147, 873, 407);
		panel.add(scrollPane);
		
		
		
		
		btnGoMain = new JLabel("");
		btnGoMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main.main(null);
				frame.dispose();
			}
		});
		btnGoMain.setBounds(29, 186, 68, 30);
		panel.add(btnGoMain);
		
		btnGoRank = new JLabel("");
		btnGoRank.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Rank.main(null);
				frame.dispose();
			}
		});
		btnGoRank.setBounds(29, 229, 68, 30);
		panel.add(btnGoRank);
		
		btnGoPlayer = new JLabel("");
		btnGoPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Player window = new Player();
				window.frame.setVisible(true);
			}
		});
		btnGoPlayer.setBounds(29, 271, 68, 31);
		panel.add(btnGoPlayer);
		
		JLabel btnGoPlayerInfo = new JLabel("");
		btnGoPlayerInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				PlayerInfo window = new PlayerInfo();
				window.frame.setVisible(true);
				window.receive(playerVo);
			}
		});
		btnGoPlayerInfo.setBounds(179, 511, 40, 40);
		panel.add(btnGoPlayerInfo);
		
		btnGoSns = new JLabel("");
		btnGoSns.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConnSns cs = new ConnSns();
				cs.goSns(playerVo.getName(),playerVo.getSocial_networks());
			}
		});
		btnGoSns.setBounds(303, 511, 48, 40);
		panel.add(btnGoSns);
		
		
		JLabel btnOut = new JLabel("");
		btnOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.main(null);
				frame.dispose();
			}
		});
		btnOut.setBounds(1090, 0, 37, 46);
		panel.add(btnOut);
		
		
		JLabel btnGoAdmin = new JLabel("");
		btnGoAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLogin.main(null);
				frame.dispose();
			}
		});
		btnGoAdmin.setBounds(1051, 12, 35, 29);
		panel.add(btnGoAdmin);
		
		
		
		JLabel BackgroundImg = new JLabel(new ImageIcon("C:\\JavaWork\\KingOfFighter\\image\\player3.png"));
		BackgroundImg.setBounds(0, 0, 1127, 578);
		panel.add(BackgroundImg);
	}
	
	
	
	
	
	
	
	
	public void receive(PlayerVo vo) {
		
		idx = vo.getIdx();
		Image i = new ImageIcon("C:\\profile\\"+vo.getPicture()+".png").getImage().getScaledInstance(316, 445, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(i);
		profileImg.setIcon(Icon);
		playerVo = vo;
		ArrayList<GameResultVo> resultList = playerDao.gameResult(idx);
		showGameResult(resultList);
		
	}
	
	
	
	
	
	
	public void showGameResult(ArrayList<GameResultVo> list) {
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		table = new JTable(dtm) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		Object[] data = new Object[7];

		for (GameResultVo vo : list) {
			data[0] = vo.getDay();
			data[1] = vo.getMatch();
			data[2] = vo.getPhysicque_rating();
			data[3] = vo.getOpponent();
			data[4] = vo.getRound();
			data[5] = vo.getPlay_time();
			data[6] = vo.getJudgement();			
			dtm.addRow(data);
		}

	}
}
