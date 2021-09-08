package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest { // 외부에서 가져다 사용할 것이 아니기 때문에 public 이 필요없다.
	
	MemberRepository repository = new MemoryMemberRepository();
	
	// 만들어둔 save 기능이 정상적으로 돌아가는지 확인용
	// run을 하면 save() 메서드가 실행된다.
	@Test
	public void save() {
		// 멤버에 어떤 값을 넣어본다.
		Member member = new Member();
		member.setName("spring");
		
		// 메모리에 저장시킨다.
		repository.save(member);
		
		// id로 찾아서 결과를 result에 담아본다.
		Member result = repository.findById(member.getId()).get();

		// 저장한 이름 "spring"과 id로 찾은 값 result가 같으면 성공
		// 방법 1) 그냥 출력해본다. 
//		System.out.println("result = " + (result == member)); // result = true;
		
		// 방법 2) (기대값, 실제값) 을 비교하여 같으면 초록불, 다르면 빨간불
//		Assertions.assertEquals(member, result); 
		
		// 방법 3) assertThat(기대값).isEqualTo(실제값)
		assertThat(member).isEqualTo(result);
		
	}
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		Member result = repository.findByName("spring1").get();
		
		assertThat(result).isEqualTo(member1);
	}
	
	@Test
	 public void findAll() {
		
		 //given
		 Member member1 = new Member();
		 member1.setName("spring1");
		 repository.save(member1);
		 
		 Member member2 = new Member();
		 member2.setName("spring2");
		 repository.save(member2);
		 
		 //when
		 List<Member> result = repository.findAll();
		 
		 //then
		 assertThat(result.size()).isEqualTo(2);
	 
	 }
	
	
	
	
}
