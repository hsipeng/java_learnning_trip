package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC:
 * 	java���ݿ����ӱ�׼ JDBC��һ�ױ�׼�Ľӿڣ�
 * 	�涨���������ݿ�Ĳ�����������ݿ�Ĺ��ܣ�
 * 	��ͬ�����ݿ⳧���ṩ��һ��JDBC��ʵ���࣬
 * 	�Բ��������ݿ⣬��һ��ʵ�����Ϊ�����ݿ����������
 * JDBC��Ҫ�ӿڣ�
 * 	DriverManager����������������������ݿ�����
 * 	Connection:��ʾ�����ݿ��һ�����ӣ����𴴽�Statement
 * 	Statement�����������ݿ�ִ��SQL���
 * 	Reultset����ʾ���ݿ��һ����ѯ�����
 * @author admin
 *
 */

public class JDBCDemo1 {
	public static void main(String[] args) {
		try {
		/**
		 * 1������������ͬ�����ַ��������ݲ�һ��	
		 */
			Class.forName("oracle.jdbc.driver.OracleDriver");
		/**
		 * 2ʹ��DriverManagerͨ�����ص����������ݿ� ��������
		 * DriverManager�ľ�̬����getConnection���������ݿ⽨�����ӣ�
		 * 	��������������
		 * 		����1�����ݿ��ַ����ͬ���ݿⲻһ����
		 * 		����2�����ݿ��û���
		 * 		����3�����ݿ�����
		 */
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Or175824");
			System.out.println("���ӳɹ�");
			/**
			 * 3����Statemanent�Է���sql���
			 * 
			 */
			Statement state = conn.createStatement();
			/**
			 * ��Բ�ͬ��SQL��䣬StatementҲ�ṩ����Ӧ��ִ�з���
			 * 1 int executeUpdate(String sql)ר������ִ��DML��䷽����
			 * 		����ֵ����Ϊһ�����֣���ʾִ��DML������Ӱ���˱��еļ�¼
			 * 2 ResultSet executeQuery(String sql) ����ִ��DQL��䷽��������ֵ
			 * 		Resultʵ������ʾDQLִ�к�Ĳ�ѯ���
			 * 3 boolean executeQuery(String sql) ����DML��DQL��ר�ŵķ���
			 * 		����ͨ��ʹ��execute����ִ��DDL��䣬����ֵΪbooleanֵ����
			 * 		��ֵΪtrueʱ˵��ִ��SQL�����в�ѯ���
			 * 
			 */
			/**
			 * ����һ�ű�
			 * �ֶΣ�
			 * 	id NUMBER(6)
			 * 	username VARCHAR2(50)
			 * 	password VARCHAR2(50)
			 * 	email VARCHAR2(100)
			 * 	nickname VARCHAR2(50)
			 * 	account NUMBER(10,2)
			 */
			String sql ="CREATE TABLE userinfo( "
						+ "id NUMBER(6), "
						+ "username VARCHAR2(50), "
						+ "password VARCHAR2(50), "
						+ "email VARCHAR2(100), "
						+ "nickname VARCHAR2(50), "
						+ "account NUMBER(10,2) "
						+ ")";
			System.out.println(sql);
			/**
			 * �����ݿ�ִ��sql���
			 */
			state.execute(sql);
			System.out.println("成功");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
