package cn.tx;

import org.springframework.stereotype.Component;

@Component("tx")
public class TranscationManager {
	public void begin() {
		System.out.println("������");
		
	}

	public void commit() {

		System.out.println("�����ύ");
	}

	public void rollback() {

		System.out.println("����ع�");
	}
}
