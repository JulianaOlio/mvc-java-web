package projetodespesa.projetodespesa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import projetodespesa.projetodespesa.model.DespesasModel;
import projetodespesa.projetodespesa.repository.DespesasRepositorio;

@Controller
public class DespesasController {
	
	@Autowired
	DespesasRepositorio repositorio;
	

	@RequestMapping(value = "/despesa", method = RequestMethod.GET)
	public String cadastroDespesasGet() {
						
		return "cadastroDespesa";

	}

	@RequestMapping(value ="/despesa", method = RequestMethod.POST)
	public String cadastroDespesasPost(DespesasModel despesa) {
			
		repositorio.save(despesa);
		
		return "redirect:/despesa";
		
	}
	
	@RequestMapping(value="listadespesa", method = RequestMethod.GET)
	public ModelAndView listarDespesas() {
		
		ModelAndView modelAndView = new ModelAndView();
		Iterable<DespesasModel> listaDespesas = repositorio.findAll();
		
		modelAndView.addObject("listaDespesas",listaDespesas );
		
		return modelAndView;
		
	}
		

}	
