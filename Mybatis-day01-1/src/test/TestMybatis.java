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
		List<User> uList = sqlSession.selectList("bean.UserMapper.findAll");
		for (User user : uList) {
			System.out.println(user);
		}
		
	}
	
	@Test
	public void test02(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setName("二郎神");
		user.setSex("保密");
		user.setAge(5);
		user.setId(-1);
		int i = sqlSession.insert("bean.UserMapper.addUser",user);
		if(i>0){
			System.out.println("插入成功");
			sqlSession.commit();
		}else {
			System.err.println("插入失败");
			
		}
	}
	
	@Test
	public void test03(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("bean.UserMapper.findOne");
		System.out.println(user);
	}
	
	@Test
	public void test04(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, String> uMap = new HashMap<String,String>();
		uMap.put("age", "age");
		List<User>  uList= sqlSession.selectList("bean.UserMapper.findUserByAge",uMap);
		for (User user : uList) {
			
			System.out.println(user);
		}
	}
	
	@Test
	public void test05(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, Object> uMap = new HashMap<String,Object>();
		uMap.put("minAge", 1);
		uMap.put("maxAge", 100);
		List<User>  uList= sqlSession.selectList("bean.UserMapper.findUserAge",uMap);
		for (User user : uList) {
			
			System.out.println(user);
		}
	}
	
	@Test
	public void test06(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
//		user.setName("啦啦啦拉拉");
		user.setSex("小meimei");
		user.setAge(18);
		user.setId(11);
		int i = sqlSession.update("bean.UserMapper.updateUser",user);
		if(i>0){
			System.out.println("修改成功");
			sqlSession.commit();
		}else {
			System.err.println("修改失败");
			
		}
	}
	
	@Test
	public void test07(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
//		user.setName("啦啦啦拉拉");
		user.setSex("小meimei");
//		user.setAge(18);
//		user.setId(11);
		List<User> uList= sqlSession.selectList("bean.UserMapper.findMoreUser",user);
		for (User user1 : uList) {
			System.out.println(user1);
		}
	}
	
	@Test
	public void test08(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int[] ids={4,7};
		sqlSession.delete("bean.UserMapper.delUsers",ids);
		sqlSession.commit();
	}
}