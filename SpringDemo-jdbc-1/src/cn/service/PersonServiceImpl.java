package cn.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bean.Person;
import cn.dao.PersonDao;
@Service
public class PersonServiceImpl implements PersonService {
	@Resource
	private PersonDao personDao;
	@Override
	public void addPerson(Person person) {
		personDao.addPerson(person);

	}

}
