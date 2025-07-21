package org.kosa.myproject.runner;

import java.util.List;
import java.util.Map;

import org.kosa.myproject.mapper.DirectorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//@Component
//@Order(2)
public class DirectorStudyRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DirectorStudyRunner.class);
    private final DirectorMapper directorMapper;
    
    public DirectorStudyRunner(DirectorMapper directorMapper) {
      super();
      this.directorMapper = directorMapper;
    }

    @Override
    public void run(String... args) throws Exception {
      logger.debug("className {} run.. DI {})", getClass(),directorMapper);
      System.out.println("DirectorStudyRunner");

    /**
     * TABLE Director의 리스트 정보를 반환받아 출력
     * DirectorMapper interface와 DirectorMapper xml을 정의하여
     * 아래 메서드가 정상저그올 수행하여 출력되도록 구현
     */
//     List<Director> list = directorMapper.findDirectorAllList();
//     for(Director director:list)
//       System.out.println(director);
      
      // 통계 sql 조회
      List<Map<String,Object>> list = directorMapper.findDirectorStatistics();
      for(Map<String,Object> map:list)
        // ROUND(AVG(m.attendance),0) AS AverageAttendance와 AS로 별칭을 준 이름이 map의 key로 반환된다.
        System.out.println(map.get("directorId")+" "+map.get("directorName")+" "+map.get("totalAttendance")+" "+map.get("averageAttendance"));
    }
}