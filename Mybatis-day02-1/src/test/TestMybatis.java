package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import bean.User;
import mapper.UserMapper;

public class TestMybatis {
	SqlSessionFactory sqlSessionFactory =null;
	@Before
	public  void init() throws IOException{
		//获取sqlMapperConfig.xml
	InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
	//SqlSessinFactory
	sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	//sqlSession
	
				//namespace id
	}
	@Test
	public void test01() throws IOException{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		System.out.println(mapper);
		List<User> uList = mapper.findAll();
		for (User user : uList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void test02(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		System.out.println(mapper);
		List<User> uList = mapper.findAll();
		mapper.findAll();
		mapper.findAll();
		mapper.findAll();
		for (User user : uList) {
			System.out.println(user);
		}
	}
	@Test
	public void test03(){
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
		mapper1.findAll();
		sqlSession1.close();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		mapper2.findAll();
		
	}
	
	
	@Test
	public void test04(){
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
		List<User> uList = mapper1.findAll_U();
		for (User user : uList) {
			System.out.println(user);
		}
		
	}
	
	@Test
	public void test05(){
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
		List<User> uList = mapper1.oneToOne();
		for (User user : uList) {
			System.out.println(user);
		}
		
	}
}