package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import hello.hellospring.domain.Member;

@Repository
public class MemoryMemberRepository implements MemberRepository {
	
	// �������丮�� ������ �������� �޸� ����
	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L; // key���� �������ش�.
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence); // �̸��� �� ���� ���, ���̵�� �ý��� ���
		store.put(member.getId(), member);
		return member;
	}
	
	@Override
	public Optional<Member> findById(Long id) {
		// �������� �׳� store.get(id) �� �����߾���.
		// ������ �� �� null�� ��ȯ�� ���� �ֱ� ������ Optional.ofNullable�� ���Ѵ�.
		// -> null�̴��� Ŭ���̾�Ʈ���� ��� ����
		return Optional.ofNullable(store.get(id));
	}
	
	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream()
			.filter(member -> member.getName().equals(name)) // �Ķ���ͷ� �Ѿ�� name�� ����� name�� ���� ��쿡�� ��ȯ
			.findAny(); // �� �� ����̶� ã���� ��ȯ
	}
	
	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values()); // �ʿ� �ִ� ������ ����Ʈ�� �־� ��ȯ���ش�.
	}

}
