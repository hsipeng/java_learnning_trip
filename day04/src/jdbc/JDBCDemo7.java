package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
/***
 * SELECT *　
 * FROM
 * (SELECT ROWNUM rn, t.* 
 * FROM
 * (SELECT empno,ename,sal,job,deptno
 * FROM emp
 * ORDER BY sal DESC) t 
 * WHERE ROWNUM <= x)
 * WHERE RN  >=5
 * @author admin
 *
 */
public class JDBCDemo7 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入条数：");
			int pageSize = Integer.parseInt(sc.nextLine());
			System.out.println("请输入页数：");
			int page = Integer.parseInt(sc.nextLine());
			
			int start = (page-1)*pageSize+1;
			int end = pageSize*page;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Or175824");
			System.out.println("链接成功");
			Statement state = conn.createStatement();
			String sql = "SELECT * "
					+ "FROM  (SELECT ROWNUM rn, t.* "
					+ "FROM (SELECT empno,ename,sal,job,deptno "
					+ "FROM emp ORDER BY sal DESC) t "
					+ "WHERE ROWNUM <= "+end+") "
					+ "WHERE RN  >="+start;
			System.out.println(sql);
			
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				System.out.println(empno+","+ename+","+sal+","+job+","+deptno);
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
