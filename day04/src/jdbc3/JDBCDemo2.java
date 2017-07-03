package jdbc3;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.plaf.synth.SynthStyle;

import jdbc2.DBUtil;

public class JDBCDemo2 {
		public static void main(String[] args) {
			Connection conn = null;
			try {
				conn = DBUtil.getConnection();
				
				/***
				 * 在一个事务中插入100000条可以减少数据库写入操作次数，提高效率
				 */
				conn.setAutoCommit(false);
				String sql = "INSERT INTO userinfo "
						+ "(id, username, password, email, nickname, account)"
						+ "VALUES "
						+ "(?,?,'123456',?,?,5000)";
				/***
				 * 使用ps可以100000条SQL使用一个执行计划
				 * 从而提高SQL执行效率
				 * 
				 */
				PreparedStatement ps = conn.prepareStatement(sql);
				long start = System.currentTimeMillis();
				for(int i = 100000;i< 200000; i++){
					ps.setInt(1, i);
					ps.setString(2, "test"+i);
					ps.setString(3, "test"+i+"@qq.com");
					ps.setString(4, "nick"+i);
//					ps.executeUpdate();
					//添加到本地缓存
					ps.addBatch();
				}
				//执行批操作（将缓存的内容一次性发给数据库执行）
				int[] d = ps.executeBatch();
				conn.commit();
				long end = System.currentTimeMillis();
				System.out.println("耗时"+(end-start)+"ms");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(conn !=null){
					DBUtil.closeConnection(conn);
				}
			}
		}
}
