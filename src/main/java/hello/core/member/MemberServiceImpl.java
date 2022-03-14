package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 추후 @Autowired를 통해 생성자와 함께 Depency를 주입할 예정
    // 현재는 순수 자바 코드를 이용하여 제작
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save( member );
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById( memberId );
    }
}
