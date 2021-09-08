package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // ���������� ��Ʈ�ѷ����� ��Ÿ���� �ֳ����̼�
public class HelloController {

	@GetMapping("hello") // �� ���ø����̼ǿ��� /hello ��� ȣ���ϸ� �� �޼��尡 ȣ��ȴ�.
	public String hello(Model model) {
		model.addAttribute("data","hello!!"); 
		// attributeName : "data", attributeValue : "hello!!"
		return "hello"; // resources/templates/hello.html ������ ������Ѷ�!!(�������ض�)
	}
}
