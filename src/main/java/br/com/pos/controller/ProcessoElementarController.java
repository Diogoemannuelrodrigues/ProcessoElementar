package br.com.pos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ModelAndView listaProcessos() {
		ProcessoElementar pro = new ProcessoElementar();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("processos", repo.findAll());
//		for (Processos processos : processos) {	
			Integer total = pro.getQuantidade();
//		}
		return mav;
	}
	
//	@GetMapping("/delete/{id}")
//	public String remove(@PathVariable("id") long id, Model model) {
//		Optional<ProcessoElementar> processo = repo.findById(id);
////		Object ob = repo.findById(processo.getId());
//		repo.deleteById(processo.get());
//		return "index";
//	}
	
	
//	public String deleteUser(@PathVariable("id") long id, Model model) {
//	    User user = userRepository.findById(id)
//	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//	    userRepository.delete(user);
//	    model.addAttribute("users", userRepository.findAll());
//	    return "index";
//	}
	

}
