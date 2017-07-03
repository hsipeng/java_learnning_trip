package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ִ��DML���
 * @author admin
 *
 */
public class JDBCDemo3 {
	public static void main(String[] args) {
		try {
			//��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��������
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Or175824");
			System.out.println("���ӳɹ�");
			//����sql���
			Statement state = conn.createStatement();
			String sql ="INSERT INTO userinfo "
					+ "(id,username,password,email,nickname,account) "
					+ "VALUES "
					+ "(seq_userinfo_id.NEXTVAL,'JACK','123456','jack@qq.com','jj',500)";
			System.out.println(sql);
			
			int i = state.executeUpdate(sql);
			if(i>0){
				System.out.println("ִ�гɹ�");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
