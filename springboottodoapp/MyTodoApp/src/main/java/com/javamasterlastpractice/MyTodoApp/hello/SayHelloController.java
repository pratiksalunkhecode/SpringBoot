package com.javamasterlastpractice.MyTodoApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@RequestMapping("SayHelloController")
	@ResponseBody
	public String hello() {
		return "say hello controller";
	}
	
	
	@RequestMapping("SayHelloControllerhtml")
	@ResponseBody
	public String hellohtml() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("<html>");		
		sb.append("<head>");
		sb.append("<title> my html page </title>");
		sb.append("<head>");
		sb.append("<body>");
		sb.append("my html page body");
		sb.append("<body>");
		sb.append("</html>"); 

		return sb.toString();
	}
	
	
	@RequestMapping("SayHelloFor")
	public String hellojsp() {
		return "sayHello";
	}

}
