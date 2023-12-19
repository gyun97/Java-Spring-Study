package hello.hellospring.domain;

public class Member {

    private Long id;  // 회원 ID 식별자(데이터를 구분하기 위해 시스템이 부여)
    private String name; // 회원 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
