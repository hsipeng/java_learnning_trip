package mapper;

import java.util.List;

import bean.User;

public interface UserMapper {
	List<User> findAll();
	List<User> findAll_U();
	List<User> oneToOne();
}