package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import persistence.DaoHelloMundo;


@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String imprimirHelloWorld(ModelMap model) {
		
		DaoHelloMundo daofrase = new DaoHelloMundo();
		String frase = daofrase.buscarFrase();
		
		model.addAttribute("message", frase);
		
		//model.addAttribute("message", "Bem vindo ao Spring MVC raiz");
		
		return "hello";
		
	}
}
	
	

