package org.kosa.myproject.test;

import org.kosa.myproject.config.AppConfig;
import org.kosa.myproject.model.Tool;
import org.kosa.myproject.model.WorkerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDI {

  public static void main(String[] args) {
    // 애너테이션 기반 설정 정보를 로드하여 스프링 컨테이너를 시작한다.
    AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
    /*
     * IOC : 필요 객체( 의존성 )를 생성하는 것이 아니라 스프링 컨테이너로 부터 받아온다.
     * getBean() -> IOC 개념 DL ( Dependency Lookup ) 즉 의존성을 검색 lookup을 통해 확보하는 기법이자 디자인 패턴
     */
    // DL Test
//    // IOC, DL
//    Tool tool1 = (Tool)factory.getBean("hammer"); // 별도의 설정이 없으면 소문자로 시작하는 클래스명이 bean name이 된다.
//    tool1.work();
//    // IOC, DL
//    Tool tool2 = (Tool)factory.getBean("spade");
//    tool2.work();
//    // IOC, DL
//    Tool tool3 = (Tool)factory.getBean("tool");// 이번에는 포크레인에서 직접 bean name을 지정했음
//    tool3.work();
    
    // DI Test
    WorkerService service = (WorkerService)factory.getBean("workerServiceImpl");
    // 컨터네이너에서 bean를 가져옴
    service.service();
    // 빈에서 정의된 메서드인 service()를 실행
    factory.close();
  }
}