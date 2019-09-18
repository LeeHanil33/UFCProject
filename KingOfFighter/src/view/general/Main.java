package view.general;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import view.admin.AdminLogin;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
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
		
		JLabel btnGoMain = new JLabel("");
		btnGoMain.setBounds(26, 185, 74, 29);
		panel.add(btnGoMain);
		
		JLabel btnGoRank = new JLabel("");
		btnGoRank.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Rank.main(null);
				frame.dispose();
			}
		});
		btnGoRank.setBounds(26, 226, 74, 29);
		panel.add(btnGoRank);
		
		
		JLabel btnGoPlayer = new JLabel("");
		btnGoPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				Player window = new Player();
				window.frame.setVisible(true);
			}
		});
		btnGoPlayer.setBounds(26, 275, 74, 29);
		panel.add(btnGoPlayer);
		
		JLabel btnExit = new JLabel("");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(1090, 12, 25, 29);
		panel.add(btnExit);
		
		JLabel btnGoLogin = new JLabel("");
		btnGoLogin.setBounds(26, 316, 74, 29);
		panel.add(btnGoLogin);
		
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
		
		JLabel backgroundImg = new JLabel(new ImageIcon("C:\\JavaWork\\KingOfFighter\\image\\main.png"));
		backgroundImg.setBounds(0, 0, 1129, 579);
		panel.add(backgroundImg);
	}
}
