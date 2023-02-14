package spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {

	@RequestMapping("/one")
	public String one(HttpServletRequest req) {
		System.out.println("This is one handler");
		return "redirect:/two";
	}
	
	@RequestMapping("/two")
	public String two() {
		System.out.println("This is two handler");
		return "contact";
	}
	
	@RequestMapping("/three")
	public RedirectView three() {
		System.out.println("This is three handler");
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("two"); //either use absolute url or relative url. Relative url should not start with /
		return redirectView;
	} 
		
	@RequestMapping("/four")
	public void four(HttpServletResponse res) {
		System.out.println("This is four handler");
		try {
			res.sendRedirect("two");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
