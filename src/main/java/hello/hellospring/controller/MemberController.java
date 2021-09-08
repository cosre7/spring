package hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
	
}
