package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import javax.xml.soap.SAAJResult;

/**
 * �ӿ���̨�����û������
 * username,password,email,nickname,account,
 * ��������JDBC�������ݿ�userinfo����
 * 		--����JDBCDemo3�������޸�
 * @author admin
 *
 */
public class JDBCDemo4 {
	public static void main(String[] args) {
		
		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("�������û���");
			String username = scanner.nextLine();
			System.out.println("����������");
			String password = scanner.nextLine();
			System.out.println("����������");
			String email = scanner.nextLine();
			System.out.println("�������ǳ�");
			String nickname = scanner.nextLine();
			System.out.println("������н��");
			String account = scanner.nextLine();
			//��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��������
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
			System.out.println("���ӳɹ�");
			//����sql���
			Statement state = conn.createStatement();
			String sql ="INSERT INTO userinfo "
					+ "(id,username,password,email,nickname,account) "
					+ "VALUES "
					+ "(seq_userinfo_id.NEXTVAL,"+"'"+username+"','"+password+"','"+email+"','"+nickname+"',"+account+")";
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
