package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 스프링 컨테이너가 생성되면 Membercontroller 객체가 생성되어 스프링이 관리한다.
public class MemberController {

    private final MemberService memberService;

    @Autowired // 생성자에 @Autowired 붙이면 스프링이 memberService를 스프링 컨테이너에 있는 memberService와 연결
    // 생성자
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

