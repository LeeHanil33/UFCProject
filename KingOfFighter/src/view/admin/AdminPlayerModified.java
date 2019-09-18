package view.admin;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import dao.AdminDao;
import view.general.Main;
import vo.PlayerVo;

public class AdminPlayerModified {

	JFrame frame;
	private JTextField tf_name;
	private JTextField tf_sns;
	private JTextField tf_age;
	private JTextField tf_reach;
	private JTextField tf_height;
	private JTextField tf_legreach;
	private JTextField tf_weight;
	private JTextField tf_country;
	private JTextField tf_debut;
	JLabel profileImg;
	String pro, weightClass, status, profileImgPath;
	int gym_idx;
	Choice choice_proAma, choice_weightClass, choice_status, choice_gym;
	PlayerVo playerVo;
	AdminDao adminDao = new AdminDao();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminPlayerModified window = new AdminPlayerModified();
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
	public AdminPlayerModified() {
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
		btn_match.setBounds(14, 285, 81, 23);
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
		btn_out.setBounds(1086, 0, 41, 46);
		panel.add(btn_out);
		
		JLabel btn_back = new JLabel("");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AdminPlayerList.main(null);
				frame.dispose();	
			}
		});
		btn_back.setBounds(133, 12, 54, 23);
		panel.add(btn_back);
		
		choice_proAma = new Choice();
		choice_proAma.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String str = choice_proAma.getSelectedItem();
				if (str.equals("Professional")) {
					pro = "0";
				} else if (str.equals("Amature")) {
					pro = "1";
				}
			}
		});
		choice_proAma.setBounds(601, 119, 181, 40);
		choice_proAma.add("Professional");
		choice_proAma.add("Amature");
//		choice_proAma.select(0);
//		pro = "0";
		choice_proAma.setBounds(163, 122, 215, 24);
		panel.add(choice_proAma);
		
		
		
		choice_weightClass = new Choice();
		choice_weightClass.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent item) {
				if (choice_weightClass.getSelectedIndex() != 0) {
					weightClass = choice_weightClass.getSelectedItem();
				}else {
					weightClass = "";
				}
			}
		});
		choice_weightClass.setBounds(443, 122, 249, 24);
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
		
		
		
		choice_status = new Choice();
		choice_status.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent item) {
				if (choice_status.getSelectedIndex() != 0) {
					status = choice_status.getSelectedItem();
				}else {
					status = "";
				}
			}
		});
		choice_status.setBounds(764, 122, 271, 24);
		choice_status.add("활동중");
		choice_status.add("휴식중");
		panel.add(choice_status);
		
		choice_gym = new Choice();
		choice_gym.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				gym_idx = choice_gym.getSelectedIndex();
			}
		});
		choice_gym.setBounds(210, 176, 482, 24);
		panel.add(choice_gym);
		
		
		Label label = new Label("GYM");
		label.setBackground(Color.WHITE);
		label.setForeground(Color.GRAY);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		label.setBounds(163, 176, 41, 25);
		panel.add(label);
		
		Label label_1 = new Label("DEBUT");
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		label_1.setBackground(Color.WHITE);
		label_1.setForeground(Color.GRAY);
		label_1.setBounds(764, 176, 65, 25);
		panel.add(label_1);
		
		
		
		profileImg = new JLabel();
		profileImg.setBounds(153, 235, 127, 186);
		panel.add(profileImg);
		
		
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel.setBounds(332, 263, 62, 18);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SNS");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_1.setBounds(355, 313, 31, 18);
		panel.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("AGE");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setBounds(342, 367, 62, 18);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("HEIGHT");
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_3.setBounds(543, 367, 62, 18);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("WEIGHT");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_4.setForeground(Color.GRAY);
		lblNewLabel_4.setBounds(764, 367, 73, 18);
		panel.add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_5 = new JLabel("REACH");
		lblNewLabel_5.setForeground(Color.GRAY);
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_5.setBounds(342, 457, 62, 18);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Leg Reach");
		lblNewLabel_6.setForeground(Color.GRAY);
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_6.setBounds(528, 449, 87, 34);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Country");
		lblNewLabel_7.setForeground(Color.GRAY);
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_7.setBounds(764, 457, 62, 26);
		panel.add(lblNewLabel_7);
		
		tf_name = new JTextField();
		tf_name.setBounds(443, 263, 412, 24);
		panel.add(tf_name);
		tf_name.setColumns(10);
		
		tf_sns = new JTextField();
		tf_sns.setBounds(443, 312, 412, 24);
		panel.add(tf_sns);
		tf_sns.setColumns(10);
		
		tf_age = new JTextField();
		tf_age.setBounds(314, 397, 116, 24);
		panel.add(tf_age);
		tf_age.setColumns(10);
		
		tf_reach = new JTextField();
		tf_reach.setBounds(314, 495, 116, 24);
		panel.add(tf_reach);
		tf_reach.setColumns(10);
		
		tf_height = new JTextField();
		tf_height.setBounds(510, 397, 116, 24);
		panel.add(tf_height);
		tf_height.setColumns(10);
		
		tf_legreach = new JTextField();
		tf_legreach.setBounds(510, 495, 116, 24);
		panel.add(tf_legreach);
		tf_legreach.setColumns(10);
		
		tf_weight = new JTextField();
		tf_weight.setBounds(739, 397, 116, 24);
		panel.add(tf_weight);
		tf_weight.setColumns(10);
		
		tf_country = new JTextField();
		tf_country.setBounds(739, 500, 116, 24);
		panel.add(tf_country);
		tf_country.setColumns(10);
		
		tf_debut = new JTextField();
		tf_debut.setBounds(835, 176, 178, 24);
		panel.add(tf_debut);
		tf_debut.setColumns(10);
		
		JButton btnProfileChange = new JButton("\uD504\uB85C\uD544 \uBC14\uAFB8\uAE30");
		btnProfileChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				profileImgPath = profileUpload();
				Image i = new ImageIcon(profileImgPath).getImage().getScaledInstance(127, 186, Image.SCALE_SMOOTH);
				ImageIcon Icon = new ImageIcon(i);
				profileImg.setIcon(Icon);
			}
		});
		btnProfileChange.setBounds(153, 422, 127, 27);
		panel.add(btnProfileChange);
		
		JLabel btnSubmit = new JLabel("");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				playerVo.setAge(Integer.parseInt(tf_age.getText()));
				playerVo.setCountry(tf_country.getText());
				playerVo.setDebut(tf_debut.getText());
				playerVo.setGym(choice_gym.getSelectedItem());
				playerVo.setHeight(Double.parseDouble(tf_height.getText()));
				playerVo.setWeight(Double.parseDouble(tf_weight.getText()));
				playerVo.setLeg_reach(Double.parseDouble(tf_legreach.getText()));
				playerVo.setReach(Double.parseDouble(tf_reach.getText()));
				playerVo.setName(tf_name.getText());
				playerVo.setSocial_networks(tf_sns.getText());
				playerVo.setPhysique_rating(choice_weightClass.getSelectedItem());
				playerVo.setPro(choice_proAma.getSelectedItem());
				playerVo.setStatus(choice_status.getSelectedItem());
				playerVo.setGym_idx(gym_idx);
				try {
					if(playerVo.getPicture().equals(profileImgPath)) {
						playerVo.setPicture(profileImgPath);
					}else {
						String p = bufferedImage(profileImgPath);
						playerVo.setPicture(p);						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println(playerVo);
				int cnt = adminDao.playerUpdate(playerVo);
				if(cnt > 0) {
					JOptionPane.showMessageDialog(frame, "수정되었습니다");
				}else {
					JOptionPane.showMessageDialog(frame, "수정 실패");
				}
			}
		});
		btnSubmit.setBounds(1019, 526, 94, 40);
		panel.add(btnSubmit);
		
	
		
		JLabel lb_Main = new JLabel(new ImageIcon("C:\\JavaWork\\KingofFighter\\image\\Setting2.png"));
		lb_Main.setBounds(0, 0, 1127, 578);
		panel.add(lb_Main);
	}
	
	
	public void receive(PlayerVo vo) {
		
		profileImgPath = vo.getPicture();
		Image i = new ImageIcon("C:\\profile\\"+vo.getPicture()+".png").getImage().getScaledInstance(127, 186, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(i);
		profileImg.setIcon(Icon);
		
		choice_weightClass.select(vo.getPhysique_rating());
		
		if(vo.getPro().equals("Pro")) {
			choice_proAma.select(0);
		}else if(vo.getPro().equals("Amature")) {
			choice_proAma.select(1);
		}
		
		if(vo.getStatus().equals("0")) {
			choice_status.select(0);
		}else if (vo.getStatus().equals("1")) {
			choice_status.select(1);
		}
		
		choice_gym.add("GYM");
		HashMap<Integer, String> gymList =  adminDao.gymList();
		for (int j = 1; j < gymList.size(); j++) {
			choice_gym.add(gymList.get(j));
		}
		choice_gym.select(vo.getGym());
		gym_idx = vo.getGym_idx();
		tf_age.setText(Integer.toString(vo.getAge()));
		tf_country.setText(vo.getCountry());
		tf_debut.setText(vo.getDebut().split(" ")[0]);
		tf_height.setText(Double.toString(vo.getHeight()));
		tf_weight.setText(Double.toString(vo.getWeight()));
		tf_reach.setText(Double.toString(vo.getReach()));
		tf_legreach.setText(Double.toString(vo.getLeg_reach()));
		tf_name.setText(vo.getName());
		tf_sns.setText(vo.getSocial_networks());
		
		playerVo = vo;
		
	}
	
	
	
	public String profileUpload() {

		BufferedImage img;
		// 1. FileDialog를 열어 불러올 파일 지정
		FileDialog dialog = new FileDialog(frame, "프로필사진 선택", FileDialog.LOAD);
		dialog.setVisible(true);
		// 2. FileDialog가 비정상 종료되었을때
		if (dialog.getFile() == null) {
			return null;
		}
		// 3. 불러올 파일의 경로명 저장
		String dfName = dialog.getDirectory() + dialog.getFile();
		System.out.println(dfName);
		
		return dfName;

	}
	
	
	private String bufferedImage(String fileName) throws Exception {
		// TODO Auto-generated method stub
		File file = new File(fileName);
        BufferedImage bi = ImageIO.read(file);
        long currentTime = System.currentTimeMillis();
        SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
        int randomNumber = (int)(Math.random()*100000);
        String uniqueFileName = "" + randomNumber + simDf.format(new Date(currentTime));
        
        //자바 1.4 ImageIO를 이용한 이미지 저장
        String str = uniqueFileName;
        File file1 = new File("C:\\profile\\"+ uniqueFileName+".png");
        ImageIO.write(bi, "png", file1);
        
        return str;
	}
	
	
}
