package utp.integrador.Apptuchamba.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(Model model,Principal principal,RedirectAttributes flash) {
		
		if(principal != null) {
			flash.addFlashAttribute("info","ya iniciaste session");
			return "redirect:/";
		}
		return "login";
	}
	
	@RequestMapping(value="/registro",method = RequestMethod.GET)
	public ModelAndView registro() {
		ModelAndView model = new ModelAndView();
		//user user = new User;
		model.addObject("user",/*user*/);
		model.setViewName("layout");
		return model;
		
		
	}
	


	
}
