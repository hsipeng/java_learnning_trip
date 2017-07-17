package cn.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpring {
	@Test
	public void testJdbc() throws SQLException{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		Connection conn = dataSource.getConnection();
		String sql = "INSERT INTO user (name,age) VALUES(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "超哥");
		ps.setInt(2, 250);
		
		int i = ps.executeUpdate();
		if(i>0){
			System.out.println("插入成功");
		}
		
		
		
	}
}
