package cn.tx;

import org.springframework.stereotype.Component;

@Component("tx")
public class TranscationManager {
	public void begin() {
		System.out.println("开始事务");
		
	}

	public void commit() {

		System.out.println("提交事务");
	}

	public void rollback() {

		System.out.println("事务回滚");
	}
}
