package org.kosa.myproject.controller;

import org.kosa.myproject.mapper.MemberMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
  
  private final MemberMapper memberMapper;
  // MemberMapper 클래스의 객체 memberMapper 생성

  //@Autowired는 생성자가 하나일 경우 생략 가능(자동 생성)
  public MemberController(MemberMapper memberMapper) {
  // MemberController 객체 생성할 때 memberMapper 주입받으면서 생성
    super();
    this.memberMapper = memberMapper;
  }
  
  @GetMapping("/member-totalcount")
  public String getTotalMemberCount(Model model) {
    int totalCount = memberMapper.getTotalMemberCount();
    model.addAttribute("totalMemberCount",totalCount);
    // model.addAttribute("totalMemberCount", memberMapper.getTotalMemberCount()); // 이것도 가능
    
    return "member/total-count";
  }

}