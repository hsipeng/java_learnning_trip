package cn.dao;

import org.springframework.stereotype.Repository;

@Repository
public class PersonImpl implements Person {

	@Override
	public void save() {
		System.out.println("add one user.");

	}

	@Override
	public void del() {
		System.err.println("del one user.");

	}

}
