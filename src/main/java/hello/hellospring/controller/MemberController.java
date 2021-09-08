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
	 * memberService의 경우 하나만 만들어 두고 공용으로 사용하는 것이 더 좋기 때문에
	 * new 로 새로 생성하는 것은 딱히 바람직하지 않다.
	 * -> 스프링 컨테이너에 등록하고 사용하는 것을 추천
	 */
//	private final MemberService memberService = new MemberService();

	private final MemberService memberService;
	
	@Autowired // MemberController와 MemberService를 스프링 컨테이너가 가져오면서 연결시켜준다.
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
		model.addAttribute("members", members); // members 리스트 자체를 모델에 담아서 화면으로!
		return "members/memberList";
		
	}
}
