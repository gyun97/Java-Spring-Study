package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration // Bean을 등록하고 싱글톤을 유지하기 위한 애노테이션 -> @Bean이 있는 메서드를 Spring Bean으로 등록하라
public class SpringConfig {

    @Bean // Spring Bean으로 수동 등록
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}


