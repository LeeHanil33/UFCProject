package view.general;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.PlayerDao;
import view.admin.AdminLogin;
import vo.PlayerVo;

public class PlayerInfo {

	JFrame frame;
	JLabel lb_name;
	JLabel lb_debut;
	JLabel lb_physiqueRating;
	JLabel lb_gym;
	JLabel lb_height;
	JLabel lb_age;
	JLabel lb_weight;
	JLabel lb_legReach;
	JLabel lb_reach;
	JLabel lb_proAma;
	JLabel profileImg;
	JTextField tf_keyword = new JTextField();
	private JLabel lb_country;
	private JLabel btnGoMain;
	private JLabel btnGoRank;
	private JLabel btnGoPlayer;
	String profileImgPath;
	int idx;
	PlayerVo playerVo = new PlayerVo();
	PlayerDao playerDao = new PlayerDao();
	private JLabel btnGoSns;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PlayerInfo window = new PlayerInfo();
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
	public PlayerInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 1145, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1127, 578);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		profileImg = new JLabel("");
		profileImg.setBounds(127, 46, 316, 443);
		panel.add(profileImg);

		lb_name = new JLabel("");
		lb_name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lb_name.setBounds(514, 88, 500, 40);
		panel.add(lb_name);

		lb_country = new JLabel("");
		lb_country.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lb_country.setBounds(514, 166, 245, 40);
		panel.add(lb_country);

		lb_debut = new JLabel("");
		lb_debut.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lb_debut.setBounds(954, 166, 124, 40);
		panel.add(lb_debut);

		lb_gym = new JLabel("");
		lb_gym.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lb_gym.setBounds(514, 236, 500, 40);
		panel.add(lb_gym);

		lb_physiqueRating = new JLabel("");
		lb_physiqueRating.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lb_physiqueRating.setBounds(514, 303, 245, 40);
		panel.add(lb_physiqueRating);

		lb_age = new JLabel("");
		lb_age.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lb_age.setHorizontalAlignment(SwingConstants.CENTER);
		lb_age.setBounds(514, 397, 80, 40);
		panel.add(lb_age);

		lb_height = new JLabel("");
		lb_height.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lb_height.setHorizontalAlignment(SwingConstants.CENTER);
		lb_height.setBounds(685, 397, 143, 40);
		panel.add(lb_height);

		lb_weight = new JLabel("");
		lb_weight.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lb_weight.setHorizontalAlignment(SwingConstants.CENTER);
		lb_weight.setBounds(918, 397, 143, 40);
		panel.add(lb_weight);

		lb_proAma = new JLabel("");
		lb_proAma.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lb_proAma.setHorizontalAlignment(SwingConstants.CENTER);
		lb_proAma.setBounds(479, 501, 170, 40);
		panel.add(lb_proAma);

		lb_legReach = new JLabel("");
		lb_legReach.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lb_legReach.setHorizontalAlignment(SwingConstants.CENTER);
		lb_legReach.setBounds(685, 501, 143, 40);
		panel.add(lb_legReach);

		lb_reach = new JLabel("");
		lb_reach.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lb_reach.setHorizontalAlignment(SwingConstants.CENTER);
		lb_reach.setBounds(908, 501, 159, 40);
		panel.add(lb_reach);

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

		JLabel btnGoPlayerGameResult = new JLabel("");
		btnGoPlayerGameResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(idx);
				System.out.println(profileImgPath);

				frame.dispose();
				PlayerGameResult window = new PlayerGameResult();
				window.frame.setVisible(true);
				window.receive(playerVo);

			}
		});
		btnGoPlayerGameResult.setBounds(246, 511, 39, 40);
		panel.add(btnGoPlayerGameResult);

		btnGoSns = new JLabel("");
		btnGoSns.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConnSns cs = new ConnSns();
				cs.goSns(playerVo.getName(),playerVo.getSocial_networks());
			}

		});
		btnGoSns.setBounds(309, 511, 37, 40);
		panel.add(btnGoSns);
		
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
		
		JLabel btnOut = new JLabel("");
		btnOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main.main(null);
				frame.dispose();
			}
		});
		btnOut.setBounds(1092, 12, 35, 27);
		panel.add(btnOut);

		JLabel BackgroundImg = new JLabel(new ImageIcon("C:\\JavaWork\\KingOfFighter\\image\\player4.png"));
		BackgroundImg.setBounds(0, 0, 1127, 578);
		panel.add(BackgroundImg);
	}

	public void receive(PlayerVo pv) {

		Image i = new ImageIcon("C:\\profile\\" + pv.getPicture() + ".png").getImage().getScaledInstance(316, 443,
				Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(i);
		profileImg.setIcon(Icon);

		idx = pv.getIdx();
		profileImgPath = pv.getPicture();

		lb_name.setText(pv.getName());
		lb_debut.setText(pv.getDebut().split(" ")[0]);
		lb_gym.setText(pv.getGym());
		lb_physiqueRating.setText(pv.getPhysique_rating());
		lb_age.setText(Integer.toString(pv.getAge()));
		lb_height.setText(Double.toString(pv.getHeight()));
		lb_weight.setText(Double.toString(pv.getWeight()));
		lb_legReach.setText(Double.toString(pv.getLeg_reach()));
		lb_reach.setText(Double.toString(pv.getReach()));
		lb_country.setText(pv.getCountry());
		if (pv.getPro().equals("Pro")) {
			lb_proAma.setText("Professional");
		} else if (pv.getPro().equals("Amateur")) {
			lb_proAma.setText("Amateur");
		}

		playerVo = pv;

	}
}
