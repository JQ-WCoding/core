package hello.core.member;

public interface MemberRepository {
    // 저장기능
    void save( Member member );

    // 아이디로 찾기
    Member fidById( Long memberId );
}
