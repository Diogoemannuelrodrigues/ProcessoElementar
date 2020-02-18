package br.com.pos.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.pos.entidade.ProcessoElementar;
import br.com.pos.repository.ProcessoElementarRepository;

@Controller
public class ProcessoElementarController {

	@Autowired
	private ProcessoElementarRepository repo;

	@RequestMapping("/processoElementar")
	public String telaInicial() {
		return "index";
	}

	@PostMapping(value = "save")
	public String saveProcesso(ProcessoElementar processo) {
		repo.save(processo);
		return "redirect:/processoElementar";
	}

	@GetMapping("/processoElementar")
	public ModelAndView listaProssos() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("processos", repo.findAll());
		return mav;
	}
	
	@PostMapping
	public String remove(ProcessoElementar processo) {
//		Object ob = repo.findById(processo.getId());
		repo.deleteById(processo.getId());
		return "index";
	}
	

}
