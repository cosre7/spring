package hello.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;

@Controller
public class MemberController {

	/*
	 * memberService�� ��� �ϳ��� ����� �ΰ� �������� ����ϴ� ���� �� ���� ������
	 * new �� ���� �����ϴ� ���� ���� �ٶ������� �ʴ�.
	 * -> ������ �����̳ʿ� ����ϰ� ����ϴ� ���� ��õ
	 */
//	private final MemberService memberService = new MemberService();

	private final MemberService memberService;
	
	@Autowired // MemberController�� MemberService�� ������ �����̳ʰ� �������鼭 ��������ش�.
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}
	
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());
		
		memberService.join(member);
		
		return "redirect:/";
	}
	
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members); // members ����Ʈ ��ü�� �𵨿� ��Ƽ� ȭ������!
		return "members/memberList";
		
	}
}
