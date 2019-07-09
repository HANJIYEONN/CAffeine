package exe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exe.entity.UserEntity;

public class UserDAO extends CommonDAO {

	public UserEntity login(String id, String pw) {
		UserEntity newUser = null;
		String sql = 
				" SELECT	* "
				+ " FROM	CAF_ACCOUNT "
				+ " WHERE	ID = ? "
				+ " AND		PW = ? ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				newUser = new UserEntity();
				newUser.setId(rs.getString("ID"));
				newUser.setPw(rs.getString("PW"));
				newUser.setName(rs.getString("NAME"));
				newUser.setNickname(rs.getString("NICKNAME"));
				newUser.setEmail(rs.getString("EMAIL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
		return newUser;
	}
	
	public boolean addUser(UserEntity user) {
		boolean result = false;
		
		String sql = " INSERT INTO CAF_ACCOUNT "
				+ "	VALUES( ?, ?, ?, ?, ? ) ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try { 
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getId());
			stmt.setString(2, user.getPw());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getNickname());
			stmt.setString(5, user.getEmail());
			int count = stmt.executeUpdate();
			
			if (count >=1 ) {
				result = true;
				conn.commit();
				
			} else {
				conn.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
		return result;
		
	}
	
	public UserEntity findUser (String email) {
		UserEntity findUser = null;
		
		String sql = " SELECT * "
				+ " FROM CAF_ACCOUNT "
				+ "	WHERE EMAIL = ? ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try { 
			conn = ds.getConnection();
			
			stmt = conn.prepareStatement(sql);	
			stmt.setString(1, email);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				findUser = new UserEntity();
				findUser.setId(rs.getString("ID"));
				findUser.setPw(rs.getString("PW"));
				findUser.setName(rs.getString("NAME"));
				findUser.setNickname(rs.getString("NICKNAME"));
				findUser.setEmail(rs.getString("EMAIL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
	
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
		return findUser;
	}
	
}
