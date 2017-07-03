package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import javax.xml.soap.SAAJResult;

/**
 * 从控制台接收用户输入的
 * username,password,email,nickname,account,
 * 数据利用JDBC插入数据库userinfo表中
 * 		--参照JDBCDemo3，进行修改
 * @author admin
 *
 */
public class JDBCDemo4 {
	public static void main(String[] args) {
		
		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入用户名");
			String username = scanner.nextLine();
			System.out.println("请输入密码");
			String password = scanner.nextLine();
			System.out.println("请输入邮箱");
			String email = scanner.nextLine();
			System.out.println("请输入昵称");
			String nickname = scanner.nextLine();
			System.out.println("请输入薪资");
			String account = scanner.nextLine();
			//加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//建立连接
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
			System.out.println("连接成功");
			//建立sql语句
			Statement state = conn.createStatement();
			String sql ="INSERT INTO userinfo "
					+ "(id,username,password,email,nickname,account) "
					+ "VALUES "
					+ "(seq_userinfo_id.NEXTVAL,"+"'"+username+"','"+password+"','"+email+"','"+nickname+"',"+account+")";
			System.out.println(sql);
			
			int i = state.executeUpdate(sql);
			if(i>0){
				System.out.println("执行成功");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
