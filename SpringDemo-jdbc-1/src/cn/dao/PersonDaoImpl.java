package cn.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.bean.Person;
@Repository
public class PersonDaoImpl implements PersonDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Override
	public void addPerson(Person person) {
		String sql = "INSERT INTO person VALUES(null,?)";
		jdbcTemplate.update(sql,person.getName());
	}

}
