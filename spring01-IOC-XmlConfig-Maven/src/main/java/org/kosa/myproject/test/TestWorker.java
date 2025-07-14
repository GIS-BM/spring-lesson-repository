package org.kosa.myproject.test;

import org.kosa.myproject.model.Spade;
import org.kosa.myproject.model.Tool;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestWorker {
	public static void main(String[] args) {
		// 기존 제어 방식 : 필요시 객체를 만들어서 이동
		//Tool tool = new Hammer();
		//tool.work();
		// Hanner에서 space로 툴을 변경
		// 객체 생성부를 변경
		Tool tool = new Spade();
		tool.work();
		// 위의 제어 방식은 도구 객첵 변경 될 때마 코드를 수정, 변겨해야 하는 구조
		// -> 생성성, 유지보수성을 향상할 수 있는 방안
		// 직전에는 객체를 생성 전담하는 Factory를 정함했고
		// 동적으로 객체를 생성하는 Reflection API를 사용했다.
		// 그 역할을 하는 것이 IOC container로서의 역항를 한다.
		// IOC : Inversion Of Control 제어의 역전, 소프트웨어 설계 원리이자 디자인 패턴
		// 필요한 객체를 직접 생산하지 않고 컨테이너에 위임, 생성주기
		
		
		
		// Spring Container 역할 : ApplicationContext 계열, IOC/DI, AOP등을 지원
		// applicationContenxt.xml :스프링 설정 파일
		// ClassPathXmlApplicationContextsms 시작시점에 xml 설정 내용을 로드
		ClassPathXmlApplicationContext factory =new ClassPathXmlApplicationContext("applicationContext.xml");
		//Spring IOC Contaner에 저장되 tool 객체 반환받는다 ->IOC
		Tool iocTool = (Tool)factory.getBean("tool");
		// 반환받은 객체를 사용한다 = IOC
		// 기본 방식과 무슨 차이? 필요시 직접 생산하지 않고 스프링 컨테이너에서
		// 반들어진 객체(Bean)을 반드시 사용한다.
		// IOC를 적용하면 어떤 먼이 좋을까? Loose Coupling
		iocTool.work();
		System.out.println(factory.getBean("tool"));
		System.out.println(factory.getBean("tool"));
		System.out.println(factory.getBean("tool")); // 동일한 객체로 반환한다.
		// Spring Container는 Singleton으로 Bean을 관리한다.
		factory.close();
	}
}
