package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    //회원가입을 하려면 MemberService 존재 필요
    MemberService memberService;

    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    @AfterEach // 각 메서드의 테스트가 끝날 때마다 호출되어 특정한 동작을 실행한다(callback method)
    public void afterEach() {
        memberRepository.clearStore(); // 각 메서드의 테스트가 끝날 때마다 memberRepository의 데이터 모두 삭제

    }


    // 테스트에서는 한글로 메서드 이름 작성 가능
    @Test
    void 회원가입() {
        //given(준비): 테스트를 위한 준비 부분. 테스트에 사용하는 변수, 입력 값, Mock 객체 정의 등
        Member member = new Member();
        member.setName("hello");

        //when(실행): 실제 테스트를 실행하는 부분(보통 1~2줄로 끝난다)
        Long saveID = memberService.join(member); //회원가입하면 ID로 반환되게 join() 작성

        //then(검증): 테스트가 제대로 되었는지 검증하는 부분. 예상 값, 실제 값을 이용하여 검증
        Member findeMember = memberService.findONe(saveID).get();
        assertThat(member.getName()).isEqualTo(findeMember.getName());
    }

    @ Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring"); // 중복 처리 예외에 걸리게 member1과 이름 똑같이 설정

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }



    @Test
    void findMembers() {
    }

    @Test
    void findONe() {
    }
}
