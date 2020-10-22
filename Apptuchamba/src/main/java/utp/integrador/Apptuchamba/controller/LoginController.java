package utp.integrador.Apptuchamba.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utp.integrador.Apptuchamba.DAO.IClienteDao;
import utp.integrador.Apptuchamba.DAO.IUserDao;
import utp.integrador.Apptuchamba.models.Cliente;

@Controller
public class LoginController {
	
	
	@Autowired
	IClienteDao clienteRepository;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		Cliente cliente = new Cliente();
		model.addObject("cliente",cliente);	
		model.setViewName("login");
		return model;	
		
	}
	@RequestMapping(value="/adm",method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView model = new ModelAndView();
		model.setViewName("AdmHome");
		return model;
	}
	@RequestMapping(value="/cliente",method = RequestMethod.GET)
	public ModelAndView cliHome() {
		ModelAndView model = new ModelAndView();
		model.setViewName("UsuarioHome");
		return model;
	}
	@RequestMapping(value="/proveedor",method = RequestMethod.GET)
	public ModelAndView proHome() {
		ModelAndView model = new ModelAndView();
		model.setViewName("ProveedorHOme");
		return model; 
	}
		
	@RequestMapping(value="/registro",method = RequestMethod.GET)
	public ModelAndView registro() {
		ModelAndView model = new ModelAndView();
		Cliente cliente = new Cliente();
		model.addObject("cliente",cliente);
		return model;	
	}
	
	@RequestMapping(value="/registro",method = RequestMethod.POST)
	public ModelAndView registrouser(Cliente cliente,BindingResult BR,ModelMap modelMap) {
		clienteRepository.save(cliente);
		ModelAndView model = new ModelAndView();
		//validaciones
		/*if(BR.hasErrors()) {
			model.addObject("Error:","Error al llenar los campos");
			modelMap.addAttribute("bindingResult",BR);
			}
		else {
			
		}*/		
		model.addObject("cliente",cliente);
		return model;
	}
}
