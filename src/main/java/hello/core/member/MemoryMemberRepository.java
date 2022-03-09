package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// 회원을 조회하고 저장하는 메소드를 지정해둔 클래스
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save( Member member ) {
        store.put( member.getId(), member );
    }

    @Override
    public Member fidById( Long memberId ) {
        return store.get( memberId );
    }
}
