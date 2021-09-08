package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 스프링에서 컨트롤러임을 나타내는 애노테이션
public class HelloController {

	@GetMapping("hello") // 웹 애플리케이션에서 /hello 라고 호출하면 이 메서드가 호출된다.
	public String hello(Model model) {
		model.addAttribute("data","hello!!"); 
		// attributeName : "data", attributeValue : "hello!!"
		return "hello"; // resources/templates/hello.html 파일을 실행시켜라!!(렌더링해라)
	}
	
	// 파라미터를 받아서 리턴해주는 메서드
	// 웹 브라우저에서 localhost:8080/hello-mvc?name= 에 값을 넣어준 상태로 실행
	@GetMapping("hello-mvc") 
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}
	
	@GetMapping("hello-String")
	@ResponseBody	// http의 응답 body 부에 직접 return ~을 넣어주겠다!
	public String HelloString(@RequestParam("name") String name) {
		return "hello " + name; // hello 이름" 이라는 문자가 요청 클라이언트로 그대로 전달
		// 뷰 같은 것이 없이 그대로 내려간다.
		// 소스보기를 하면 문자열 그대로 나타난다.
	}
	
	@GetMapping("hello-api") 
	@ResponseBody
	public Hello helloAPI(@RequestParam("name") String name) {
		
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
		// JSON 방식으로 결과 출력 // {"name":"이름"}
	}
	
	static class Hello { 
		// class 안에서 static class 를 선언하는 것도 가능!
		// HelloController.Hello 등의 방식으로 사용한다.
		private String name;

		// getter, setter -> 자바 빈 규약(표준 방식) or 프로퍼티 접근 방식
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
}
