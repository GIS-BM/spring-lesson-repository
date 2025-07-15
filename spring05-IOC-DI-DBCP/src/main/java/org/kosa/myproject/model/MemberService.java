package org.kosa.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class MemberService {
  private final MemberDao memberDao;
  // @Autowired // DI 어노테이션 생략 가능 -> 생성자 1개일 경우 자동 DI 의존성 주입
  public MemberService(MemberDao memberDao) {
    super();
    this.memberDao =memberDao;
  }
  // 생성자 하나면 자동 autowire
  @PostConstruct
  public void init() {
    System.out.println(getClass()+"Bean 초기화 작업");
  }
  // Bean에서 정의한 비즈니스 메서드
  public MemberVo findMemberById(String id) throws SQLException {
    System.out.println(getClass()+" findMemberById 비즈니스 메서드");
    return memberDao.findMemberById(id);
  }
  
  @PreDestroy // Bean 소멸 전에 해야되는 작업
  public void destroy() {
    System.out.println(getClass()+"Bean 소멸 직전 작업");
  }
  

  
}