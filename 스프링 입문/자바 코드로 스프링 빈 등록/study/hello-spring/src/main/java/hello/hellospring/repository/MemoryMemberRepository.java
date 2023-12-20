package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // Member 객체를 저장하는 Map 컬렉션
    private static long sequence = 0L; // sequence: 회원의 고유한 id를 생성하기 위한 시퀀스 번호

    @Override
    public Member save(Member member) {  // 새로운 회원 정보를 저장하고 반환

        member.setId(++sequence); // 새 멤버 저장될 때마다 이전보다 1 늘어난 id 생성
        store.put(member.getId(), member);  // put(): map에 키-값 쌍 추가
        return member;
    }

    @Override
    public Optional<Member> findbyID(Long id) { // 특정 id를 가진 회원을 조회

        return Optional.ofNullable(store.get(id));  // Optional.ofNullable(): () 안의 값이 Null이어도 감쌀 수 있다
    }                                              // 해당 id의 회원이 없으면 빈 Optional을 반환

    @Override
    public Optional<Member> findbyName(String name) {  // 회원의 이름(name)으로 회원을 조회

        // values()로 store의 멤버 객체들을 컬렉션화하고 stream()으로 스트림 객체 생성하여 하나씩 순회 처리
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // filter(lambda)로 멤버 이름이 파라미터 name과의 일치 확인
                .findAny();  // 조건에 맞는 요소를 찾아서 반환, 없으면 빈 값(Optional)을 반환
    }

    @Override
    public List<Member> findAll() { //저장된 모든 회원 목록을 반환
        return new ArrayList<>(store.values()); // store에 저장된 모든 Member 객체를 리스트로 변환하여 반환
    }


    public void clearStore() {
        store.clear(); // List의 모든 객체 삭제
    }


}


