package CreatingWebAppUsingSpringBoot.WebAppProject.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
///src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
/////Controllers handle Requests

@Controller
public class SayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String SayHello() {
		return "Hi this is my fiest Wep App";
		
	}
///we have to map the whole url , but we have given prefix and suffix for location in applicatin properties file
	@RequestMapping("say-hello-jsp")
	public String SayHelloJsp() {
		return "sayHello";
	}

}
