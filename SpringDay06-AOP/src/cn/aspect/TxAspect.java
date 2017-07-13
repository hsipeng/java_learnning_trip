package cn.aspect;
//�������� ������ר��������������

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.util.LangUtil.ProcessController.Thrown;
import org.springframework.stereotype.Component;

import cn.tx.TranscationManager;

@Component
public class TxAspect {
	@Resource
	private TranscationManager tx;
	
	//ǰ��֪ͨ
	public void before(JoinPoint joinPoint){
		System.out.println("����һ��ǰ��֪ͨ");
		//��ȡĿ����������
		Class targetClass = joinPoint.getTarget().getClass();
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Ŀ����������ǣ�"+targetClass);
		System.out.println("Ŀ�귽����:"+methodName);
	}
	//����֪ͨ ����뷵�ؽ��ֵ
	public void afterReturn(JoinPoint joinPoint,String number){
		System.out.println("����һ������֪ͨ");
		System.out.println("����Ŀ�귽��ִ�к�Ľ��Ϊ��"+number);
	}
	/*�쳣֪ͨ
	 * 1.��ӡ�쳣����
	 * 2.��ӡ�쳣��Ϣ
	 */
	public void afterThrow(Throwable throwable){
		System.out.println("����һ���쳣֪ͨ");
		System.out.println("�쳣��Ϣ����Ϊ��"+throwable.getClass());
		System.out.println("�쳣��ϢΪ��"+throwable.getMessage());
	}
	//����֪ͨ
	public void after(){
		System.out.println("����һ������֪ͨ");
	}
	
	
	
	
	
	
	
	
	
	
//	//����֪ͨ
//	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
//		tx.begin();//������
//		joinPoint.proceed();//��Ŀ�귽��ִ��
//		tx.commit();//�����ύ
//		
//		
//	}
	
	
	
	
	
}
