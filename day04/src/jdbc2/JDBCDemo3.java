package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDemo3 {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Or175824");
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入删除的id：");
			int index = sc.nextInt();
			
			String sql = "DELETE FROM userinfo "
					+ "WHERE "
					+ "id = ? ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, index);
			
			int rs = ps.executeUpdate();
			if(rs > 0){
				System.out.println("删除成功");
			}else {
				System.err.println("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}
}
