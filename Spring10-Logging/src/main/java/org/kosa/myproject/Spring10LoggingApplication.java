package org.kosa.myproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring10LoggingApplication implements CommandLineRunner {
  private static final Logger logger = LoggerFactory.getLogger(Spring10LoggingApplication.class);
  // slf4j : 로깅 구현체들의 표준화된 인터페이스
	public static void main(String[] args) {
		SpringApplication.run(Spring10LoggingApplication.class, args);
	}

  @Override
  public void run(String... args) throws Exception {
    logger.debug("로그 테스트 중입니다.");// 디버그 레벨로 설정
    logger.info("로그 테스트 info");
    logger.warn("로그 테스트 warn");
    logger.error("로그 테스트 error");
    // 가장 낮은 단계도 테스트 해본다.
    logger.trace("로그 테스트 trace");
    
  }

}
