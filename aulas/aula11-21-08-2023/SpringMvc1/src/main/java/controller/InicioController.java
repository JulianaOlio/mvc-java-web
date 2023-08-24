package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import persistence.DaoHelloMundo;


@Controller
@RequestMapping ("/inicio")
public class InicioController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String inciar(ModelMap modelo) {
		
		DaoHelloMundo daofrase = new DaoHelloMundo();
		String frase = daofrase.buscarFrase();
		
		
		modelo.addAttribute("message", frase);
		
		return "inicio"; 


	}

}
