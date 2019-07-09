package exe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import exe.entity.IntakeEntity;

public class IntakeDAO extends CommonDAO {

	public IntakeEntity find(String email) {
		IntakeEntity entity = null;
		
		String sql = " SELECT	* "
				+ "	FROM	CAF_INTAKE "
				+ " WHERE	EMAIL = ? ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = ds.getConnection();
			conn.setAutoCommit(false);

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);

			rs = stmt.executeQuery();
			if (rs.next()) {
				entity = new IntakeEntity();
				entity.setAmount(rs.getInt("AMOUNT"));
				entity.setEmail(rs.getString("EMAIL"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}

		return entity;
	}
	
	public boolean insert(IntakeEntity amount) {
		boolean result = false;

		String sql = " INSERT INTO CAF_INTAKE " + " VALUES( ?, ? ) ";

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = ds.getConnection();
			conn.setAutoCommit(false);

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, amount.getEmail());
			stmt.setInt(2, amount.getAmount());

			if (stmt.executeUpdate() >= 1) {
				result = true;
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}

		return result;
	}
	
	public boolean update(IntakeEntity amount) {
		boolean result = false;
		
		String sql = " UPDATE	CAF_INTAKE "
				+ "	SET		AMOUNT = AMOUNT + ? "
				+ "	WHERE	EMAIL = ? ";

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, amount.getAmount());
			stmt.setString(2, amount.getEmail());

			int count = stmt.executeUpdate();
			
			if (count >= 1) {
				result = true;
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
		return result;
	}

	public IntakeEntity check(int amount) {
		IntakeEntity result = null;
		
		String sql = " 	SELECT * "
				+ "		FROM CAF_INTAKE "
				+ "		WHERE AMOUNT = ? ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
					
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, amount);
			
			rs = stmt.executeQuery();
					
			if (rs.next()) {
				result = new IntakeEntity();
				result.setEmail(rs.getString("EMAIL"));
				result.setAmount(rs.getInt("AMOUNT"));
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
		return result;
	}

}
