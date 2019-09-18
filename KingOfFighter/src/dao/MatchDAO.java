package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.MatchVO;


public class MatchDAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private void close() {

		try {
			if (conn != null)
				conn.close();
			if (psmt != null)
				psmt.close();
			if (rs != null)
				rs.close();

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

	public ArrayList<String> player() {

		ArrayList<String> list = new ArrayList<String>();
		getConnection();

		try {
			String sql = "select name from player order by name";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public int AddMatch(MatchVO vo) {

		int cnt = 0;

		getConnection();

		try {
			String sql = "insert into match values (MATCH_SEQ.NEXTVAL, ?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMatch());
			psmt.setInt(2, vo.getA_Player());
			psmt.setInt(3, vo.getB_Player());
			psmt.setString(4, vo.getDate());
			psmt.setInt(5, vo.getRound());
			psmt.setString(6, vo.getTime());
			psmt.setString(7, vo.getWinMethod());
			psmt.setInt(8, vo.getWinner());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	public int selectPlayer(String name) {

		int cnt = 0;

		getConnection();

		try {
			String sql = "select idx from Player where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	public ArrayList<String> DayCho() {

		ArrayList<String> list = new ArrayList<String>();
		getConnection();
		

		try {
			String sql = "select distinct day from match";
			psmt = conn.prepareStatement(sql);
			
			
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

}
