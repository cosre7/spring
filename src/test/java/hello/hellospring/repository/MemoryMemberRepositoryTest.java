package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest { // �ܺο��� ������ ����� ���� �ƴϱ� ������ public �� �ʿ����.
	
	MemberRepository repository = new MemoryMemberRepository();
	
	// ������ save ����� ���������� ���ư����� Ȯ�ο�
	// run�� �ϸ� save() �޼��尡 ����ȴ�.
	@Test
	public void save() {
		// ����� � ���� �־��.
		Member member = new Member();
		member.setName("spring");
		
		// �޸𸮿� �����Ų��.
		repository.save(member);
		
		// id�� ã�Ƽ� ����� result�� ��ƺ���.
		Member result = repository.findById(member.getId()).get();

		// ������ �̸� "spring"�� id�� ã�� �� result�� ������ ����
		// ��� 1) �׳� ����غ���. 
//		System.out.println("result = " + (result == member)); // result = true;
		
		// ��� 2) (��밪, ������) �� ���Ͽ� ������ �ʷϺ�, �ٸ��� ������
//		Assertions.assertEquals(member, result); 
		
		// ��� 3) assertThat(��밪).isEqualTo(������)
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
