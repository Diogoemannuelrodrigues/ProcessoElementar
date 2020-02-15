package br.com.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.pos.entidade.ProcessoElementar;
import br.com.pos.repository.ProcessoElementarRepository;

@Controller
public class ProcessoElementarController {
	
	@Autowired
	private ProcessoElementarRepository repo;
	
	@RequestMapping("/novos")
	public String novo(){
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveProcesso(ProcessoElementar processo) {
		repo.save(processo);
		return "index";
	}
	
}
