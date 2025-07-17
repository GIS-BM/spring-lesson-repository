package org.kosa.myproject;

import org.kosa.myproject.model.board.BoardService;
import org.kosa.myproject.model.member.MemberService;
import org.springframework.boot.CommandLineRunner;

public class MyStartRunner implements CommandLineRunner {
  private final MemberService memberService;
  private final BoardService boardService;
  
  public MyStartRunner(MemberService memberService, BoardService boardService) {
    this.memberService = memberService;
    this.boardService = boardService;
  }
  
  @Override
  public void run(String... args) throws Exception {
    memberService.findMember();
    memberService.findAllMember();
    memberService.register("ace", "tastegood");
    boardService.find();
    boardService.findAllList();
  }

}