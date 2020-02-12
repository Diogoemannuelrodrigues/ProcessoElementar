package br.com.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pos.entidade.ProcessoElementar;
import br.com.pos.repository.ProcessoElementarRepository;

@Controller
public class Processo {
	
	@Autowired
	ProcessoElementarRepository repo;
	
	@RequestMapping("/")
	public String inicio(){
		return "index";
	}
	
	@RequestMapping("/teste")
	public String inicio2(){
		return "teste";
	}
	
	@RequestMapping("/all")
	public List<ProcessoElementar> processos() {
		return repo.findAll();
	}
	
	@PostMapping("/save")
	public String saveProcesso(ProcessoElementar processo) {
		repo.save(processo);
		return null;
	}
	
	@GetMapping("/delete")
	public String deleteProcesso(ProcessoElementar processo) {
		repo.delete(processo);
		return null;
	}
	
	@GetMapping("/find")
	@ResponseBody
	public ProcessoElementar findProcesso(ProcessoElementar processo) {
		repo.findById(processo.getId());
		return null;
	}
	
}
