package org.kosa.myproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class StopWatchUnitTest {  
  public String findAllList() throws InterruptedException {
    StopWatch watch = new StopWatch();
    watch.start();
    ///////////////////////////////시작
    Thread.sleep(700); // 0.7초
    System.out.println("db에서 리스트를 조회");
    ///////////////////////////////끝
    watch.stop();
    System.out.println(watch.getTotalTimeMillis());// 밀리세컨드 단위로 소요 시간을 보여줌
    return "all list";
  }
   
  
  public static void main(String[] args) {
    // StopWatch text 용
    System.out.println("StopWatch 테스트");
    try {
      new StopWatchUnitTest().findAllList();
    }catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
