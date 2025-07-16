package org.kosa.myproject.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.kosa.myproject.config.AppConfig;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * final field로 DataSource 선언
 * Constructor Injection
 * 실제 DataSource를 이용해 spring_member table의 회원 정보를 조회하여 회원 객체를 리턴한다.
 */
@Repository
public class MemberDao {

  private final DataSource dataSource;
  // DataSource 클래스 참조변수 dataSource 선언

  // 생성자를 통해 DI 받도록 한다.
  public MemberDao(DataSource dataSource) {
    super();
    this.dataSource = dataSource;
  }
  
  public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
    if (rs != null)
      rs.close();
    closeAll(pstmt, con);
  }

  public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
    if (pstmt != null)
      pstmt.close();
    if (con != null)
      con.close(); // 커넥션을 소멸시키는 것이 아니라 DBCP에 커넥션을 반납한다.;
  }

  public MemberVo findMemberById(String memberId) throws SQLException {
    MemberVo memberVo = null;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
       con = dataSource.getConnection(); // DataSource 타입의 DBCP 구현체로부터 커넥션을 빌려온다.
       String sql = "select id,password,name,address from spring_member where id=?";
       pstmt = con.prepareStatement(sql);
       pstmt.setString(1, memberId);
       rs = pstmt.executeQuery();
       if (rs.next()) {
          memberVo = new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
       }
    } finally {
       this.closeAll(rs, pstmt, con); // DBCP로부터 빌린 커넥션을 반납한다.
    }

    return memberVo;
 }


}
