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
	/* localhost:8080/hello-mvc?name=�̸� �̶�� �����ߴٸ�
	 * 1. name �Ķ���� ������ �̸� �� ��� ���·� helloMvc �޼��� ȣ��
	 * 2. name�� ���� �𵨿� ����.
	 * 3. hello-template���� �����Ѵ�.
	 * 4. viewResolver�� hello-template.html�� �������ش�.
	 * 5. hello-template.html���� ${name} �ڸ��� �̸� �� ��� ���·� ��� (��ȯ�� Thymeleaf�� ����)
	 */
	
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
	
	
	
}
