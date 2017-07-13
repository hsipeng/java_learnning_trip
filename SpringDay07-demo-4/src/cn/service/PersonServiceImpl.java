package cn.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.anno.PrivilegeInfo;
import cn.dao.PersonDao;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	@Resource
	private PersonDao personDao;
	@Override
	@PrivilegeInfo(name = "add")
	public String save(String name) {
		personDao.save(name);
		return name;
	}
	@Override
	@PrivilegeInfo(name = "del")
	public void delete() {
		personDao.delPerson();
		
	}
	@Override
	public void findAll() {
		System.out.println("查询全部用户");
		
	}

}
