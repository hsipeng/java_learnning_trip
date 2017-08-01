package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import bean.Dept;
import mapper.DeptMapper;

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
		DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
		System.out.println(mapper);
		List<Dept> dList = mapper.oneToMore();
		for (Dept d : dList) {
			System.out.println(d);
		}
	}

}