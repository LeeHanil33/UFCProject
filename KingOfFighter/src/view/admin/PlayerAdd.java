package view.admin;
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import dao.KofJoinDao;
import dao.PlayerDao;
import view.general.Main;
import vo.PlayerAddVo;

public class PlayerAdd {

	private JFrame frame;
	private JTextField tf_DEBUT;
	private JTextField tf_name;
	private JTextField tf_sns;
	private JTextField tf_age;
	private JTextField tf_height;
	private JTextField tf_weight;
	private JTextField tf_reach;
	private JTextField tf_legreach;
	private JTextField tf_country;
	String profileImgPath;
	JLabel profileImg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerAdd window = new PlayerAdd();
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
	public PlayerAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public String profileUpload() {

	      BufferedImage img;
	      // 1. FileDialog¸¦ ¿­¾î ºÒ·¯¿Ã ÆÄÀÏ ÁöÁ¤
	      FileDialog dialog = new FileDialog(frame, "ÇÁ·ÎÇÊ»çÁø ¼±ÅÃ", FileDialog.LOAD);
	      dialog.setVisible(true);
	      // 2. FileDialog°¡ ºñÁ¤»ó Á¾·áµÇ¾úÀ»¶§
	      if (dialog.getFile() == null) {
	         return null;
	      }
	      // 3. ºÒ·¯¿Ã ÆÄÀÏÀÇ °æ·Î¸í ÀúÀå
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
	        
	        //ÀÚ¹Ù 1.4 ImageIO¸¦ ÀÌ¿ëÇÑ ÀÌ¹ÌÁö ÀúÀå
	        String str = uniqueFileName;
	        File file1 = new File("C:\\profile\\"+ uniqueFileName+".png");
	        ImageIO.write(bi, "png", file1);
	        
	        return str;
	   }
	   
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
				
			}
		});
		btn_player.setBounds(14, 199, 81, 34);
		panel.add(btn_player);
		
		JLabel btn_score = new JLabel("");
		btn_score.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, "¼­ºñ½º ÁØºñÁß ÀÔ´Ï´Ù");
			}
		});
		btn_score.setBounds(14, 250, 81, 34);
		panel.add(btn_score);
		
		JLabel btn_match = new JLabel("");
		btn_match.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MatchAdd.main(null);
				frame.dispose();
			}
		});
		btn_match.setBounds(14, 296, 81, 34);
		panel.add(btn_match);
		
		JLabel btn_out = new JLabel("");
		btn_out.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				Main.main(null);
				//System.exit(); ¾Æ¿¹ Á¾·á
				frame.dispose();
			}
		});
		btn_out.setBounds(1085, 12, 42, 45);
		panel.add(btn_out);
		
		Choice choice_pro = new Choice();
		choice_pro.setBounds(231, 123, 215, 24);
		panel.add(choice_pro);
		choice_pro.add("Pro(P) / Amateur(A)");
		choice_pro.add("P");
		choice_pro.add("A");
		
		
		Choice choice_bdlv = new Choice();
		choice_bdlv.setBounds(563, 122, 215, 24);
		panel.add(choice_bdlv);
		choice_bdlv.add("Heavyweight");
		choice_bdlv.add("Lightweight");
		choice_bdlv.add("Light Heavyweight");
		choice_bdlv.add("Middleweight");
		choice_bdlv.add("Featherweight");
		choice_bdlv.add("Welterweight");
		choice_bdlv.add("Bantamweight");
		choice_bdlv.add("Flyweight");
		choice_bdlv.add("Women's Strawweight");
		choice_bdlv.add("Women's Bantamweight");
		choice_bdlv.add("Women's Flyweight");
		choice_bdlv.add("Women's Featherweight");
		
		Choice choice_gym = new Choice();
		choice_gym.setBounds(867, 122, 215, 24);
		panel.add(choice_gym);
		ArrayList<String> list = new ArrayList<String>();
		KofJoinDao dao = new KofJoinDao();
		
		list = dao.GymCho();
		for(int i = 0; i < list.size(); i++) {
			choice_gym.add(list.get(i));
		}
		
		
		Choice choice_stat = new Choice();
		choice_stat.setBounds(867, 176, 215, 24);
		panel.add(choice_stat);
		choice_stat.add("Active(0) / Inactive(1)");
		choice_stat.add("0");
		choice_stat.add("1");
		
		
		Label label = new Label("GYM");
		label.setBackground(Color.WHITE);
		label.setForeground(Color.GRAY);
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		label.setBounds(820, 122, 42, 25);
		panel.add(label);
		
		Label label_1 = new Label("DEBUT");
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		label_1.setBackground(Color.WHITE);
		label_1.setForeground(Color.GRAY);
		label_1.setBounds(496, 175, 65, 25);
		panel.add(label_1);
		
		tf_DEBUT = new JTextField();
		tf_DEBUT.setBounds(563, 176, 215, 24);
		panel.add(tf_DEBUT);
		tf_DEBUT.setColumns(10);
		
		profileImg = new JLabel("");
		profileImg.setBounds(153, 235, 117, 134);
		panel.add(profileImg);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lblNewLabel.setBounds(167, 175, 62, 18);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SNS");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_1.setBounds(383, 241, 41, 18);
		panel.add(lblNewLabel_1);
		
		tf_name = new JTextField();
		tf_name.setBounds(231, 175, 215, 24);
		panel.add(tf_name);
		tf_name.setColumns(10);
		
		tf_sns = new JTextField();
		tf_sns.setBounds(455, 239, 352, 24);
		panel.add(tf_sns);
		tf_sns.setColumns(10);
		
		JLabel lb_Confirm = new JLabel("SUMMIT");
		lb_Confirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = tf_name.getText();
				String gym = choice_gym.getSelectedItem();
				int age = Integer.parseInt(tf_age.getText());
				double height = Double.parseDouble(tf_height.getText());
				double weight = Double.parseDouble(tf_weight.getText());
				double reach = Double.parseDouble(tf_reach.getText());
				double legreach = Double.parseDouble(tf_legreach.getText());
				String country = tf_country.getText();
				String social = tf_sns.getText();
				String date = tf_DEBUT.getText();
				String pro = choice_pro.getSelectedItem();
				String bdlv = choice_bdlv.getSelectedItem();
				int stat = Integer.parseInt(choice_stat.getSelectedItem());
				
				String picture = null;
				try {
					picture = bufferedImage(profileImgPath);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				PlayerAddVo vo = new PlayerAddVo(name, pro, bdlv, stat, age, height, weight,
						reach, legreach, date, picture, social, country);
				System.out.println(vo);
				KofJoinDao joindao = new KofJoinDao();
				PlayerDao dao = new PlayerDao();
				int gymnum = joindao.GymChoice(gym);
				
				int cnt = dao.playerAdd(vo, gymnum);
				if(cnt > 0) {
					JOptionPane.showMessageDialog(frame, "¼±¼ö µî·ÏÀÌ ¼º°øÀûÀ¸·Î ¿Ï·áµÇ¾ú½À´Ï´Ù");
					AdminPlayerList.main(null);
					frame.dispose();
				}	
				
			}
		});
		lb_Confirm.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Confirm.setBackground(new Color(255, 204, 153));
		lb_Confirm.setForeground(Color.GRAY);
		lb_Confirm.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lb_Confirm.setBounds(534, 520, 140, 34);
		panel.add(lb_Confirm);
		
		JLabel lblNewLabel_2 = new JLabel("AGE");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setBounds(384, 320, 62, 18);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("HEIGHT");
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_3.setBounds(624, 320, 62, 18);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("WEIGHT");
		lblNewLabel_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4.setForeground(Color.GRAY);
		lblNewLabel_4.setBounds(902, 320, 73, 18);
		panel.add(lblNewLabel_4);
		
		Label label_stat = new Label("STATUS");
		label_stat.setForeground(Color.GRAY);
		label_stat.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		label_stat.setBackground(Color.WHITE);
		label_stat.setBounds(790, 175, 73, 25);
		panel.add(label_stat);
		
		Label label_pro = new Label("PRO/AMA");
		label_pro.setForeground(Color.GRAY);
		label_pro.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		label_pro.setBackground(Color.WHITE);
		label_pro.setBounds(148, 123, 81, 25);
		panel.add(label_pro);
		
		Label label_bdlv = new Label("W_RATING");
		label_bdlv.setForeground(Color.GRAY);
		label_bdlv.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		label_bdlv.setBackground(Color.WHITE);
		label_bdlv.setBounds(471, 122, 90, 25);
		panel.add(label_bdlv);
		
		tf_age = new JTextField();
		tf_age.setBounds(333, 352, 142, 24);
		panel.add(tf_age);
		tf_age.setColumns(10);
		
		tf_height = new JTextField();
		tf_height.setBounds(588, 352, 142, 24);
		panel.add(tf_height);
		tf_height.setColumns(10);
		
		tf_weight = new JTextField();
		tf_weight.setBounds(867, 352, 142, 24);
		panel.add(tf_weight);
		tf_weight.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("REACH");
		lblNewLabel_5.setForeground(Color.GRAY);
		lblNewLabel_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_5.setBounds(372, 430, 62, 18);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("LEG REACH");
		lblNewLabel_6.setForeground(Color.GRAY);
		lblNewLabel_6.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_6.setBounds(613, 422, 87, 34);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("COUNTRY");
		lblNewLabel_7.setForeground(Color.GRAY);
		lblNewLabel_7.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_7.setBounds(899, 426, 80, 26);
		panel.add(lblNewLabel_7);
		
		tf_reach = new JTextField();
		tf_reach.setBounds(333, 468, 142, 24);
		panel.add(tf_reach);
		tf_reach.setColumns(10);
		
		tf_legreach = new JTextField();
		tf_legreach.setBounds(588, 468, 142, 24);
		panel.add(tf_legreach);
		tf_legreach.setColumns(10);
		
		tf_country = new JTextField();
		tf_country.setBounds(867, 464, 142, 24);
		panel.add(tf_country);
		tf_country.setColumns(10);
		
		JButton btnProfileImg = new JButton("\uD504\uB85C\uD544\uC0AC\uC9C4 \uB4F1\uB85D");
		btnProfileImg.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		btnProfileImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				profileImgPath = profileUpload();
				Image i = new ImageIcon(profileImgPath).getImage().getScaledInstance(117, 134, Image.SCALE_SMOOTH);
	            ImageIcon Icon = new ImageIcon(i);
	            profileImg.setIcon(Icon);
				
			}
		});
		btnProfileImg.setBounds(151, 375, 119, 27);
		panel.add(btnProfileImg);
		
		JLabel btnBack = new JLabel("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminPlayerList.main(null);
				frame.dispose();
			}
		});
		btnBack.setBounds(127, 17, 65, 40);
		panel.add(btnBack);
		
		JLabel lb_Main = new JLabel(new ImageIcon("C:\\JavaWork\\KingofFighter\\image\\Setting3.png"));
		lb_Main.setBounds(0, 12, 1127, 578);
		panel.add(lb_Main);
	}
	
	
}
