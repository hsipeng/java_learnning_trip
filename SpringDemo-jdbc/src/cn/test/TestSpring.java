package cn.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.bean.User;
import cn.mapper.UserMapper;



public class TestSpring {
	ApplicationContext context = null;
	//before 每当执行@Test时，都会先执行
	@Before
	public void Init(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");

	}
/*	@Test
	public void testJdbc() throws SQLException{
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
		
		
		
	}*/
	
	/*@Test
	public void test02(){
		JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
		User user = new User();
		user.setName("gg");
		user.setAge(33);
		String sql = "INSERT INTO user (name,age) VALUES(?,?)";
		int rows = jdbcTemplate.update(sql,user.getName(),user.getAge());
		System.out.println("影响了"+rows+"行");
		
		
	}
	
	@Test
	public void test03(){
		JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
		String sql = "UPDATE user SET name=?,age=? WHERE id=?";
		int rows = jdbcTemplate.update(sql,"大腰子",0,1);
		System.out.println("影响了"+rows+"行");
		
		
	}*/
	
	/*@Test
	public void test04(){
		JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
		String sql = "DELETE FROM user WHERE id=?";
		int rows = jdbcTemplate.update(sql,1);
		System.out.println("影响了"+rows+"行");
		
		
	}*/
	
/*	@Test
	public void test05(){
		JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
		String sql = "SELECT * FROM user";
		List<Map<String, Object>> userlist = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> map : userlist) {
			System.out.println(map);
		}
	}
	
	@Test
	public void test06(){
		JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
		String sql = "SELECT * FROM user";
		List<User> userlist = jdbcTemplate.query(sql,new UserMapper());
		for (User user : userlist) {
			System.out.println(user);
		}
		
	}
	
	@Test
	public void test07(){
		JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
		String sql = "SELECT * FROM user WHERE id=?";
		User user = jdbcTemplate.queryForObject(sql, new UserMapper(),6);
			System.out.println(user);
		
	}*/
	@Test
	public void test08(){
		JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
		String sql = "SELECT * FROM user";
		RowMapper<User> userMapper = new BeanPropertyRowMapper<User>(User.class);
		List<User> userList = jdbcTemplate.query(sql, userMapper);
		for (User user : userList) {
			System.out.println(user);
		}
	}
}
