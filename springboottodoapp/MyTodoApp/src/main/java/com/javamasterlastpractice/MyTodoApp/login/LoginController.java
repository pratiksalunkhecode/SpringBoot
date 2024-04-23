package com.javamasterlastpractice.MyTodoApp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("Name")
public class LoginController {
	
//	@Autowired
//	private AuthenticationService authenticationservicess;
//	
//	//private Logger logger = LoggerFactory.getLogger(getClass());
//	
    	@RequestMapping(value="/",method = RequestMethod.GET)
    	public String gotologinpage(ModelMap model) {
		//model.put("name", name);
    		model.put("Name", "in28minute"); //hard code name putting
		
//		logger.debug("request param is {}" + name);
//		logger.info("i want on info level");
//		logger.warn("i want on warn level");
		
		return "WelcomePage";
	}
    	
//    	@RequestMapping(value="login",method = RequestMethod.POST)
//    	public String gotowelcomepage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//    		
//    		if(authenticationservicess.anthenticationM(name, password))
//    		{
//    		model.put("Name", name);
//    		model.put("password", password);
//    	
//    		return "WelcomePage";
//    		}
//    		model.put("errorMessage", "invalid credential please put valid password & username");
//    		return "login";
//    	}

}
