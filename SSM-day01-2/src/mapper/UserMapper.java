package mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import pojo.User;

public interface UserMapper {
	List<User> findAll();

}
