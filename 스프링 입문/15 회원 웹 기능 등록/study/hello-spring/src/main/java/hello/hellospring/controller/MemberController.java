package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 스프링 컨테이너가 생성되면 Membercontroller 객체가 생성되어 스프링이 관리한다.
public class MemberController {

    private final MemberService memberService;

    @Autowired // 생성자에 @Autowired 붙이면 스프링이 memberService를 스프링 컨테이너에 있는 memberService와 연결
    public MemberController(MemberService memberService) { // 생성자
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}

