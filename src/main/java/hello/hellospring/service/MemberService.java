package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberService {
	
	// ���񽺸� ����� ���ؼ��� �������丮�� �ʿ��ϴ�.
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	/*
	 * ȸ�� ����
	 */
	public Long join(Member member) {
		// �Ϲ����� ȸ�� ���� ��Ȳ
//		memberRepository.save(member);
//		return member.getId();
		
		// ���� �̸��� �ִ� �ߺ� ȸ��X
		/*
		 * 1. �������丮���� ���� �̸��� ���� ȸ���� �ִ��� Ȯ���Ѵ�
		 * 2. ������ x ������ ȸ�� ���� ����
		 */
//		Optional<Member> result = memberRepository.findByName(member.getName());
//		// ���� ������
//		// ������ ��������� null�� �ƴϸ� �̶�� ������� �˻��߰�����
//		// Optional�̱� ������ ifPresent�� �����ϴ�.
//		result.ifPresent(m -> {
//			throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
//		}); 
		
		// Optional~~ ��� �ۼ��ϴ� �ͺ��� �̷��� �����ϰ�!
//		memberRepository.findByName(member.getName())
//		.ifPresent(m -> {
//			throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
//		});
		
		// �޼��尡 ���� ���ǵ� �� �ִ� ��� ���� ���ֱ�
		// Refactor -> Extract Method ���
		validateDuplicateMember(member); // �ߺ� ȸ�� ����
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
			.ifPresent(m -> {
				throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
			});
	}
	
	/*
	 * ��ü ȸ�� ��ȸ
	 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	
	/*
	 * �� ���� ȸ�� ��ȸ
	 */
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
}
