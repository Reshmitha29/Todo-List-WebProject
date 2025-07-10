package CreatingWebAppUsingSpringBoot.WebAppProject.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
//creating Login page 
//model - when we need to do something in html/jsp page 
public class LoginController{
		@RequestMapping(value = "/",method = RequestMethod.GET)
		public String LoginJSP(ModelMap model){
			
			model.put("Name", "Reshu");			
			return "Welcome";
		}
		
}