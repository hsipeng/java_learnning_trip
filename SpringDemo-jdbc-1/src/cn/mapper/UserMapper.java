package cn.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cn.bean.User;
@Component
public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet, int index) throws SQLException {
		User user = new User();
		user.setId(resultSet.getInt("id"));
		user.setName(resultSet.getString("name"));
		user.setAge(resultSet.getInt("age"));
		return user;
	}

}
