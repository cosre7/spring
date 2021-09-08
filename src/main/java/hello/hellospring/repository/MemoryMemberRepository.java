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
	
	// 리포지토리의 내용을 저장해줄 메모리 공간
	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L; // key값을 생성해준다.
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence); // 이름은 고객 직접 등록, 아이디는 시스템 등록
		store.put(member.getId(), member);
		return member;
	}
	
	@Override
	public Optional<Member> findById(Long id) {
		// 예전에는 그냥 store.get(id) 로 진행했었다.
		// 하지만 이 때 null이 반환될 수도 있기 때문에 Optional.ofNullable로 감싼다.
		// -> null이더라도 클라이언트에서 사용 가능
		return Optional.ofNullable(store.get(id));
	}
	
	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream()
			.filter(member -> member.getName().equals(name)) // 파라미터로 넘어온 name과 저장된 name이 같은 경우에만 반환
			.findAny(); // 그 중 어떤것이라도 찾으면 반환
	}
	
	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values()); // 맵에 있는 값들을 리스트로 넣어 반환해준다.
	}

}
