package cn.tx;

import org.springframework.stereotype.Component;

@Component("tx")
public class TranscationManager {
	public void begin() {
		System.out.println("事务开启");
		
	}

	public void commit() {

		System.out.println("事务提交");
	}

	public void rollback() {

		System.out.println("事务回滚");
	}
}
