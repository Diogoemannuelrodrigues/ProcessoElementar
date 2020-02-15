package br.com.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.pos.entidade.ProcessoElementar;

@Controller
public class ProcessoElementarController {

	@RequestMapping("/novos")
	public String novo(){
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveProcesso(ProcessoElementar processo) {
//		repo.save(processo);
		System.out.println(">>>"+ processo.getDescricao());
		return "index";
	}
	
}
