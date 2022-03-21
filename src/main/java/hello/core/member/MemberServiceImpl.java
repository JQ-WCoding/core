package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 추후 @Autowired를 통해 생성자와 함께 Depency를 주입할 예정
    // 현재는 순수 자바 코드를 이용하여 제작
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // ServiceImpl 구현된 클래스들은 모두 실구현객체를 몰라도 된다.
    // 즉 인터페이스의 기능 설명만 보고 사용하더라도 문제없도록 하는 것이 SRP라는 단일책임 원칙과 OCP 개방폐쇄 원칙을 지켜 사용한 것이다.
    // 멤버 서비스는 MemoryMemberRepositry에서 부터 구현되어 있는 메소드들을 사용한다
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save( member );
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById( memberId );
    }
}
