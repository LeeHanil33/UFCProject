package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.GameResultVo;
import vo.PlayerVo;

public class AdminDao {
	
	private static Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int cnt;
	
	PlayerVo playerVo = new PlayerVo();
	GameResultVo gameResultVo = new GameResultVo();
	
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
	
	public HashMap<Integer, String> gymList() {
		
//		ArrayList<String> list = new ArrayList<>();
		HashMap<Integer, String> map = new HashMap<>();
		
		getConn();
		try {
			pst = conn.prepareStatement("select * from gym ORDER by name");
			rs = pst.executeQuery();
			
			while(rs.next()) {
				int idx = rs.getInt("IDX");
				String gymName = rs.getString("NAME");
				map.put(idx, gymName);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close();
		}
		
		return map;
	}
	
	
	public ArrayList<PlayerVo> playerList(String pro, String weightClass, String gymName) {
		
		getConn();
		ArrayList<PlayerVo> list = new ArrayList<>();
		try {
			
			pst = conn.prepareStatement("select p.*, g.name as gym \r\n" + 
					"from player p\r\n" + 
					"left outer join gym g\r\n" + 
					"on p.gym_idx = g.idx\r\n" + 
					"where pro=? and physique_rating=? and g.name=?");
			pst.setString(1, pro);
			pst.setString(2, weightClass);
			pst.setString(3, gymName);
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
				
				list.add(playerVo);
			}

			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	
	
	public int playerUpdate(PlayerVo vo) {
		
		System.out.println(vo);
		getConn();
		try {
			
			pst = conn.prepareStatement("UPDATE player \r\n" + 
					"SET NAME = ?, PRO = ?, PHYSIQUE_RATING = ?, GYM_IDX = ?, STATUS = ?, AGE = ?, HEIGHT = ?, WEIGHT = ?, REACH = ?, LEG_REACH = ?, DEBUT = ?, PICTURE = ?, SOCIAL_NETWORKS = ?, COUNTRY = ? \r\n" + 
					"WHERE idx = ?");
			
			pst.setString(1, vo.getName());
			if(vo.getPro().equals("Professional")) {
				pst.setString(2,"0");				
			}else if(vo.getPro().equals("Amature")){
				pst.setString(2,"1");
			}
			pst.setString(3,vo.getPhysique_rating());
			pst.setInt(4, vo.getGym_idx());
			if(vo.getStatus().equals("활동중")) {
				pst.setString(5, "0");				
			}else if(vo.getStatus().equals("휴식중")) {
				pst.setString(5, "1");
			}
			pst.setInt(6,vo.getAge());
			pst.setDouble(7, vo.getHeight());
			pst.setDouble(8, vo.getWeight());
			pst.setDouble(9, vo.getReach());
			pst.setDouble(10, vo.getLeg_reach());
			pst.setString(11, vo.getDebut());
			pst.setString(12, vo.getPicture());
			pst.setString(13, vo.getSocial_networks());
			pst.setString(14, vo.getCountry());
			pst.setInt(15, vo.getIdx());
			
			cnt = pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close();
		}
		
		return cnt;
	}

}
