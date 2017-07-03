package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo2 {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Or175824");
			
			String sql = "INSERT INTO userinfo "
					+ "(id,username,password,email,nickname,account) "
					+ "VALUES "
					+ "(seq_userinfo_id.NEXTVAL,?,?,?,?,?) ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "ddd");
			ps.setString(2, "123456");
			ps.setString(3, "ddd@qq.com");
			ps.setString(4, "DDD");
			ps.setDouble(5, 4000.0);
			
			int rs = ps.executeUpdate();
			if(rs > 0){
				System.out.println("插入成功");
			}else {
				System.err.println("插入失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}
}
