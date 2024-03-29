package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Utils.DBUtil;
import models.Comment;
import models.User;

public class CommentDaoImpl implements CommentDao{

	public List<Comment> getAllComments() {
		Connection conn = null;
		Statement st = null;
		List<Comment> cList = new ArrayList<Comment>();
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * From comments";
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Comment c = new Comment();
				c.setId(rs.getInt("c_id"));
				c.setUserId(rs.getInt("user_id"));
				c.setContent(rs.getString("c_content"));
				c.setPublishTime(rs.getTimestamp("c_publishtime").toString());
				c.setModifyTime(rs.getTimestamp("c_modifytime").toString());
				c.setStatus(rs.getInt("c_status"));
				cList.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(st !=null){
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn !=null){
				DBUtil.closeConnection(conn);
			}
		}
		return cList;
	}

	public List<Comment> getAllCommentsByPage(int start, int pageSize) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<Comment> cList = new ArrayList<Comment>();
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT c.*,u.username From comments c,user u "
					+ "WHERE c.user_id=u.id"
					+ " ORDER BY c_id ASC LIMIT ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Comment c = new Comment();
				c.setId(rs.getInt("c_id"));
				c.setUserId(rs.getInt("user_id"));
				c.setUsername(rs.getString("username"));
				c.setContent(rs.getString("c_content"));
				c.setPublishTime(rs.getTimestamp("c_publishtime").toString());
				c.setModifyTime(rs.getTimestamp("c_modifytime").toString());
				c.setStatus(rs.getInt("c_status"));
				cList.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(ps !=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn !=null){
				DBUtil.closeConnection(conn);
			}
		}
		return cList;
	}

	public boolean newComment(String comment, int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<Comment> cList = new ArrayList<Comment>();
		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO comments "
					+ "(user_id,c_content,c_publishtime,c_modifytime) "
					+ "VALUES "
					+ "(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, comment);
			Date date = new Date();
			Timestamp ts = new Timestamp(date.getTime());
			ps.setTimestamp(3, ts);
			ps.setTimestamp(4, ts);
			
			int i = ps.executeUpdate();
			if(i >0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(ps !=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn !=null){
				DBUtil.closeConnection(conn);
			}
		}
		return false;
	}

}
