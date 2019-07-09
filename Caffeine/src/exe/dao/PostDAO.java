package exe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exe.entity.PostEntity;

public class PostDAO extends CommonDAO {

	public boolean insertPost(PostEntity post) {
		boolean result = false;
		
		String sql = " INSERT INTO CAF_POST "
				+ " VALUES( SEQ_POST.NEXTVAL,?,?,?,?,?,?,? ) ";
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, post.getTitle());
			stmt.setString(2, post.getWriter());
			stmt.setString(3, post.getDate());
			stmt.setString(4, post.getContent());
			stmt.setString(5, post.getPicture());
			stmt.setInt(6, post.getCaffeine());
			stmt.setString(7, post.getEmail());
			
			if (stmt.executeUpdate() >= 1) {
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
	
	
	public ArrayList<PostEntity> selectAll(int startNum, int pageCount) {
		ArrayList<PostEntity> list = new ArrayList<PostEntity>();
	
		String sql = " 	select	b.* " 
				+ " 	from	(	select 	a.* "
				+ "							,rownum as rnum "
				+ " 				from	(	select 		* " 
				+ " 							from 		CAF_POST "
				+ "								order by 	num desc " 
				+ "						 	) a " 
				+ " 		 	) b "
				+ " 	where rnum between ? and ? ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
			try {
				conn = ds.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, startNum);
				stmt.setInt(2, startNum + pageCount - 1);

				rs = stmt.executeQuery();
				
				while (rs.next()) {
					PostEntity post = new PostEntity();
					post.setNum(rs.getInt("num"));
					post.setTitle(rs.getString("title"));
					post.setWriter(rs.getString("writer"));
					post.setDate(rs.getString("post_date"));
					post.setContent(rs.getString("content"));
					post.setPicture(rs.getString("picture"));
					post.setCaffeine(rs.getInt("caffeine"));
					post.setEmail(rs.getString("email"));
			
					list.add(post);
				}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}

		return list;
	}
	

	public int getTotalRow() {
		int totalRow = 0;

		String sql = " 	select 	count(*) " 
					+ " from 	CAF_POST ";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			if (rs.next()) {
				totalRow = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return totalRow;
	}


	public PostEntity select(String num) {
		PostEntity post = null;
		
		String sql = " 	SELECT * "
						+ " FROM CAF_POST "
						+ " WHERE NUM = ? " ;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(num));
			
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				post = new PostEntity();
				post.setNum(rs.getInt("num"));
				post.setTitle(rs.getString("title"));
				post.setWriter(rs.getString("writer"));
				post.setDate(rs.getString("post_date"));
				post.setContent(rs.getString("content"));
				post.setPicture(rs.getString("picture"));
				post.setCaffeine(rs.getInt("caffeine"));
				post.setEmail(rs.getString("email"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
		return post;
	} 
	
}
