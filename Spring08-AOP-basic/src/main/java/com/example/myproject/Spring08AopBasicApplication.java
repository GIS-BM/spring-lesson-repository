package com.example.myproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.myproject.model.MemberService;
import com.example.myproject.model.ProductService;
/**
 * 요구 사항 -> AOP를 사용하지 않고 공통 기능을 처리 또는 횡단 관심사를 처리
 * 
 * 현재 서비스 중인 시스템의 검색 계열 ( find 계열 ) 기능 메서드들을 대상으로
 * 특정 업무를 메서드 코어 작업 실행 직전에 수행하도록 작업을 추가해야 한다.
 * 대상 서비스 클래스들과 메서드들이 다수가 존재하는 것으로 전재하고
 * 공통된 업무 즉 추가 요구 사항을 적용해본다.
 * 
 * 검색 계열 메서드 실행 전에
 * ***cross cutting concern ***MemberService **** findMemberById*** 공통 로그 출력
 * 
 * 1. common.CommonOutputLogging 별도 클래스와 메서드를 정의
 * 2. 각 Service의 method에서 재사용
 * ** 위 방안으로 작업 후 회고**
 * 잘 구현된 공통 컴포넌트를 import해서 사용하는 것을 좋은 선택이고
 * 작업량이 줄어드는 면도 있지만 여전히 공통 또는 횡단 관심사에 대한
 * 반복적인 작업은 피할 수 없었다. -> 개선방안 : AOP를 적용해 설계, 구현해보자
 * ==> spring09-AOP-Solution에서 해본다.
 */
@SpringBootApplication
public class Spring08AopBasicApplication implements CommandLineRunner {
  private final MemberService memberService;
  private final ProductService productService;
  
	public Spring08AopBasicApplication(MemberService memberService, ProductService productService) {
    super();
    this.memberService = memberService;
    this.productService = productService;
  }

  public static void main(String[] args) {
		SpringApplication.run(Spring08AopBasicApplication.class, args);
	}
	
  @Override
  public void run(String... args) throws Exception {
    // IOC, DI 테스트
    // DI 의존성 주입이 잘 되었음을 확인, MemberServiceImpl에 @Service
    // ProductServiceImpl에 @Service 처리를 했으므로 됨
    //System.out.println(memberService);
    //System.out.println(productService);
    memberService.findMemberByAddress();
    memberService.findMemberById();
    memberService.findMemberList();
    memberService.register();
    productService.findProductById();
    productService.findProductByName();
    productService.findProductByMaker();
    productService.updateProduct();
  }
}