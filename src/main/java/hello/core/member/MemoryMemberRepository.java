package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// 회원을 조회하고 저장하는 메소드를 지정해둔 클래스
// 인터페이스와 구현체를 변경하는 것이 좋다
public class MemoryMemberRepository implements MemberRepository {

    // ConCurrentHashMap을 사용하여 동시성 문제를 실무에서는 해결, 현재는 그냥 간략하게 HashMap 사용
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save( Member member ) {
        store.put( member.getId(), member );
    }

    @Override
    public Member findById( Long memberId ) {
        return store.get( memberId );
    }
}
