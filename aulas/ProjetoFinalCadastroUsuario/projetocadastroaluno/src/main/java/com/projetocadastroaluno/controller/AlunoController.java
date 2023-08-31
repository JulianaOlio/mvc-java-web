package com.projetocadastroaluno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projetocadastroaluno.model.Aluno;
import com.projetocadastroaluno.repository.AlunoRepositorio;

@Controller
public class AlunoController {

	@Autowired
	AlunoRepositorio repositorio;

	@RequestMapping(value = "/cadastroAluno", method = RequestMethod.GET)
	public String cadastroAluno() {

		return "formularioAluno";

	}

	@RequestMapping(value = "/cadastroAluno", method = RequestMethod.POST)
	public String cadastroAlunoPost(Aluno aluno) {

		repositorio.save(aluno);

		return "redirect:/cadastroAluno";
	}

	@RequestMapping(value = "/listagemAlunos", method = RequestMethod.GET)
	public ModelAndView listarAluno() {

		ModelAndView modelAndView = new ModelAndView("listarAluno");
		Iterable<Aluno> listaAluno = repositorio.findAll();

		modelAndView.addObject("listarAlunoNome", listaAluno);

		return modelAndView;
	}

	@RequestMapping(value = "/deletarAluno")
	public String deletarAluno(Long matricula) {

		Aluno aluno = repositorio.findByMatricula(matricula);
		
		if (aluno != null) {
			repositorio.delete(aluno);
		}
		
		return "redirect:/listagemAlunos";

	}
	@RequestMapping("/alterarAluno")
	public ModelAndView alterarAluno (Long matricula) {
		
		ModelAndView modelAndView = new ModelAndView("alterarAluno");
		
		Aluno aluno = repositorio.findByMatricula(matricula);
		
		modelAndView.addObject("alterarCadastroAluno", aluno);
		
		return modelAndView;
		
		
	}
	
	
}
