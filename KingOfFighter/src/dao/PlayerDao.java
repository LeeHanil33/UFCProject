package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import vo.GameResultVo;
import vo.PlayerAddVo;
import vo.PlayerVo;
import vo.RankVo;

public class PlayerDao {

	private static Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	PlayerVo playerVo = new PlayerVo();
	GameResultVo gameResultVo = new GameResultVo();
	RankVo rankVo;
	
	private void getConn() {
		String url = "jdbc:oracle:thin:@192.168.0.20:1521:xe";
		String user = "kof2";
		String password = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<PlayerVo> playerList(String pro, String weightClass){
		
		getConn();
		ArrayList<PlayerVo> playerList = new ArrayList<>();

		try {
			pst = conn.prepareStatement("select p.*, g.name as gym \r\n" + 
					"from player p\r\n" + 
					"left outer join gym g\r\n" + 
					"on p.gym_idx = g.idx\r\n" + 
					"where pro=? and physique_rating=?");
			pst.setString(1, pro);
			pst.setString(2, weightClass);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				int get_idx = rs.getInt("IDX");
				String get_pro = "0";
				if(rs.getString("PRO").equals("0")) {
					get_pro = "Pro";
				}else if(rs.getString("PRO").equals("1")) {
					get_pro = "Amature";
				}
				String get_physiqueRating = rs.getString("PHYSIQUE_RATING");
				String get_name = rs.getString("NAME");
				String get_gym = rs.getString("GYM");
				int get_age = rs.getInt("AGE");
				double get_height = rs.getDouble("HEIGHT");
				double get_weight = rs.getDouble("WEIGHT");
				double get_reach = rs.getDouble("REACH");
				double get_legReach = rs.getDouble("LEG_REACH");
				String get_debut = rs.getString("DEBUT");
				String get_picture = rs.getString("PICTURE");
				String get_country = rs.getString("COUNTRY");
				String get_social_networks = rs.getString("SOCIAL_NETWORKS");
				String get_status = rs.getString("STATUS");
				int get_gym_idx = rs.getInt("GYM_IDX");
				playerVo = new PlayerVo(get_idx, get_pro, get_physiqueRating, get_name, get_gym, get_age, get_height, get_weight, get_reach, get_legReach,get_debut,get_picture,get_country,get_social_networks,get_status,get_gym_idx);
				playerList.add(playerVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return playerList;
	}
	
	
	public ArrayList<PlayerVo> searchKeyword(String keyword) {
		System.out.println(keyword);
		getConn();
		ArrayList<PlayerVo> playerList = new ArrayList<>();
		
		try {
			pst = conn.prepareStatement("select p.*, g.name as gym \r\n" + 
					"from player p \r\n" + 
					"left outer join gym g \r\n" + 
					"on p.gym_idx = g.idx \r\n" + 
					"where p.name LIKE '%' || ? || '%'");
			
//			pst = conn.prepareStatement("select p.idx, p.pro, p.physique_rating, p.name, g.name as gym ,p.age, p.height, p.weight, p.reach, p.leg_reach, to_char(p.debut,'YY.MM.DD') as debut, p.picture, p.country \r\n" + 
//					"from player p , gym g \r\n" + 
//					"where p.gym_idx=g.idx and p.name LIKE '%' || ? || '%'");
			pst.setString(1, keyword);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				int get_idx = rs.getInt("IDX");
				String get_pro = "0";
				if(rs.getString("PRO").equals("0")) {
					get_pro = "Pro";
				}else if(rs.getString("PRO").equals("1")) {
					get_pro = "Amateur";
				}
				String get_physiqueRating = rs.getString("PHYSIQUE_RATING");
				String get_name = rs.getString("NAME");
				String get_gym = rs.getString("GYM");
				int get_age = rs.getInt("AGE");
				double get_height = rs.getDouble("HEIGHT");
				double get_weight = rs.getDouble("WEIGHT");
				double get_reach = rs.getDouble("REACH");
				double get_legReach = rs.getDouble("LEG_REACH");
				String get_debut = rs.getString("DEBUT");
				String get_picture = rs.getString("PICTURE");
				String get_country = rs.getString("COUNTRY");
				String get_social_networks = rs.getString("SOCIAL_NETWORKS");
				String get_status = rs.getString("STATUS");
				int get_gym_idx = rs.getInt("GYM_IDX");
				playerVo = new PlayerVo(get_idx, get_pro, get_physiqueRating, get_name, get_gym, get_age, get_height, get_weight, get_reach, get_legReach,get_debut,get_picture,get_country,get_social_networks,get_status,get_gym_idx);
				playerList.add(playerVo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close();
		}
		return playerList;
	}
	
	public ArrayList<GameResultVo> gameResult(int idx){
		
		getConn();
		ArrayList<GameResultVo> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement("select m.day,m.match,(select physique_rating from player p where m.a_player = p.idx)as physique_rating,(select name from player p where m.b_player = p.idx) as opponent,m.round,m.time,m.method\r\n" + 
					"from match m\r\n" + 
					"where m.a_player = ?");
			pst.setInt(1, idx);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String get_day = rs.getString("DAY");
				String get_match = rs.getString("MATCH");
				String get_physicque_rating = rs.getString("PHYSIQUE_RATING");
				String get_opponent = rs.getString("OPPONENT");
				int get_round = rs.getInt("ROUND");
				String get_play_time = rs.getString("TIME");
				String get_judgement = rs.getString("METHOD");
				
				gameResultVo = new GameResultVo(get_day, get_match, get_physicque_rating, get_opponent, get_round, get_play_time, get_judgement);
				list.add(gameResultVo);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	
	public int playerAdd(PlayerAddVo vo, int gym) {

		int cnt = 0;

		getConn();

		try {	
			String sql = "insert into player values (PLAYER_SEQ.NEXTVAL, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);

//			private String name; // 이름
//			private String pro;       // P프로,A아마 M매니저
//			private String bdlevel; // 신체등급
//			private int status;  // 활동여부 0,1
//			
//			private int age;     // 나이
//			private double height;  //키
//			private double weight;  //몸무게
//			private double reach;   //팔길이
//			private double legReach; //발길이
//			private String date;  //데뷔일자
//			private String picture; //사진위치
//			private String social;  //sns url
//			private String country; //출신

			pst.setString(1, vo.getName());
			if(vo.getPro().equals("P")) {
				pst.setString(2, "0");	
			}else if(vo.getPro().equals("A")) {
				pst.setString(2, "1");
			}
			pst.setString(3, vo.getBdlevel());
			pst.setInt(4, gym);
			pst.setInt(5, vo.getStatus());
			pst.setInt(6, vo.getAge());
			pst.setDouble(7, vo.getHeight());
			pst.setDouble(8, vo.getWeight());
			pst.setDouble(9, vo.getReach());
			pst.setDouble(10, vo.getLegReach());
			pst.setString(11, vo.getDate());
			pst.setString(12, vo.getPicture());
			pst.setString(13, vo.getSocial());
			pst.setString(14, vo.getCountry());

			cnt = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	
	
	public ArrayList<RankVo> rankList() {
		
		getConn();
		
		ArrayList<RankVo> list = new ArrayList<>();
		

		try {
			
			pst = conn.prepareStatement("select * from (\r\n" + 
					"    select p.name, p.physique_rating,(s.win-s.lost) as winnum,\r\n" + 
					"          ROW_NUMBER() OVER (PARTITION BY p.physique_rating ORDER BY (s.win-s.lost) DESC) as rk\r\n" + 
					"    from player p, score s\r\n" + 
					"    where p.idx = s.idx and p.physique_rating is not null\r\n" + 
					")\r\n" + 
					"where rk <= 3\r\n" + 
					"order by physique_rating, rk");
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String get_name = rs.getString("NAME");
				String get_physique_rating = rs.getString("PHYSIQUE_RATING");
				int get_winNum = rs.getInt("WINNUM");
				int get_rank = rs.getInt("RK");
				
				rankVo = new RankVo(get_name, get_physique_rating, get_winNum, get_rank);
				
				list.add(rankVo);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	
	}
}
