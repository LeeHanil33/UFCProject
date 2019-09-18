package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.KofJoinVo;

public class KofJoinDao {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String db_url = "jdbc:oracle:thin:@192.168.0.20:1521:xe";
			String db_id = "kof2";
			String db_pw = "1234";

			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String login(KofJoinVo kf) {
		String name = null;

		getConnection();

		try {
			String sql = "select * from admin where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, kf.getId());
			psmt.setString(2, kf.getPw());
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				name = rs.getString(2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return name;
	}
	

	
	
	public ArrayList<String> GymCho() {
		String gym = null;
		ArrayList<String> list = new ArrayList<String>();

		getConnection();

		try {

			String sql = "select name from gym";
			psmt = conn.prepareStatement(sql);
			

			rs = psmt.executeQuery();
			

			while (rs.next()) {
				gym = rs.getString("NAME");
				list.add(gym);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close();
		}
		return list;
		
	}
	public String Information(String info) {
		String str = null;
		return str;
	}
	
	

	public int GymChoice(String gymName) {
		int gym = 0;

		getConnection();

		try {

			String sql = "select idx from gym where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, gymName);

			rs = psmt.executeQuery();

			if (rs.next()) {
				gym = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close();
		}
		return gym;
	}

	public int join(KofJoinVo kf, int gym) {
		int cnt = 0;

		getConnection();

		try {

			String sql = "INSERT INTO ADMIN VALUES (ADMIN_SEQ.NEXTVAL, ?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, kf.getId());
			psmt.setString(2, kf.getPw());
			psmt.setString(3, kf.getEmail());
			psmt.setInt(4, gym);
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close();
		}
		return cnt;
	}

}
