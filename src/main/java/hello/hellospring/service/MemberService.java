package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberService {
	
	// 서비스를 만들기 위해서는 리포지토리가 필요하다.
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	/*
	 * 회원 가입
	 */
	public Long join(Member member) {
		// 일반적인 회원 가입 상황
//		memberRepository.save(member);
//		return member.getId();
		
		// 같은 이름이 있는 중복 회원X
		/*
		 * 1. 리포지토리에서 같은 이름을 가진 회원이 있는지 확인한다
		 * 2. 있으면 x 없으면 회원 가입 진행
		 */
//		Optional<Member> result = memberRepository.findByName(member.getName());
//		// 값이 있으면
//		// 기존의 방법에서는 null이 아니면 이라는 방식으로 검사했겠지만
//		// Optional이기 때문에 ifPresent가 가능하다.
//		result.ifPresent(m -> {
//			throw new IllegalStateException("이미 존재하는 회원입니다.");
//		}); 
		
		// Optional~~ 라고 작성하는 것보다 이렇게 간단하게!
//		memberRepository.findByName(member.getName())
//		.ifPresent(m -> {
//			throw new IllegalStateException("이미 존재하는 회원입니다.");
//		});
		
		// 메서드가 새로 정의될 수 있는 경우 따로 빼주기
		// Refactor -> Extract Method 사용
		validateDuplicateMember(member); // 중복 회원 검증
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
			.ifPresent(m -> {
				throw new IllegalStateException("이미 존재하는 회원입니다.");
			});
	}
	
	/*
	 * 전체 회원 조회
	 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	
	/*
	 * 한 명의 회원 조회
	 */
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
}
