package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // ���������� ��Ʈ�ѷ����� ��Ÿ���� �ֳ����̼�
public class HelloController {

	@GetMapping("hello") // �� ���ø����̼ǿ��� /hello ��� ȣ���ϸ� �� �޼��尡 ȣ��ȴ�.
	public String hello(Model model) {
		model.addAttribute("data","hello!!"); 
		// attributeName : "data", attributeValue : "hello!!"
		return "hello"; // resources/templates/hello.html ������ ������Ѷ�!!(�������ض�)
	}
	
	// �Ķ���͸� �޾Ƽ� �������ִ� �޼���
	// �� ���������� localhost:8080/hello-mvc?name= �� ���� �־��� ���·� ����
	@GetMapping("hello-mvc") 
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}
	
	@GetMapping("hello-String")
	@ResponseBody	// http�� ���� body �ο� ���� return ~�� �־��ְڴ�!
	public String HelloString(@RequestParam("name") String name) {
		return "hello " + name; // hello �̸�" �̶�� ���ڰ� ��û Ŭ���̾�Ʈ�� �״�� ����
		// �� ���� ���� ���� �״�� ��������.
		// �ҽ����⸦ �ϸ� ���ڿ� �״�� ��Ÿ����.
	}
	
	@GetMapping("hello-api") 
	@ResponseBody
	public Hello helloAPI(@RequestParam("name") String name) {
		
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
		// JSON ������� ��� ��� // {"name":"�̸�"}
	}
	
	static class Hello { 
		// class �ȿ��� static class �� �����ϴ� �͵� ����!
		// HelloController.Hello ���� ������� ����Ѵ�.
		private String name;

		// getter, setter -> �ڹ� �� �Ծ�(ǥ�� ���) or ������Ƽ ���� ���
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
}
