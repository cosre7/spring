package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 스프링에서 컨트롤러임을 나타내는 애노테이션
public class HelloController {

	@GetMapping("hello") // 웹 애플리케이션에서 /hello 라고 호출하면 이 메서드가 호출된다.
	public String hello(Model model) {
		model.addAttribute("data","hello!!"); 
		// attributeName : "data", attributeValue : "hello!!"
		return "hello"; // resources/templates/hello.html 파일을 실행시켜라!!(렌더링해라)
	}
}
