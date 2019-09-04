package br.com.paripassu.senhas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.paripassu.senhas.model.TipoSenha;
import br.com.paripassu.senhas.service.SenhaService;

@Controller
@RequestMapping("/senhas")
public class SenhaClienteController {
	
	@Autowired
	private SenhaService senhaService;
	
	@GetMapping
	public ModelAndView recuperaSenhas() {
		ModelAndView modelAndView = new ModelAndView("PainelCliente");
		modelAndView.addObject("senhas", senhaService.getSenhas());
		modelAndView.addObject("senhaGerada", senhaService.getSenhaGerada());
		modelAndView.addObject("senhasChamadas", senhaService.getSenhasChamadas());
		modelAndView.addObject("senhaChamada", senhaService.getSenhaChamada());
		return modelAndView;
	}
	
    @PostMapping("/normal")
	public String gerarSenhaNormal() {
		senhaService.gerarSenha(TipoSenha.NORMAL);
		return "redirect:/senhas";
	}
    
    @PostMapping("/preferencial")
	public String gerarSenhaPreferencial() {
    	senhaService.gerarSenha(TipoSenha.PREFERENCIAL);
		return "redirect:/senhas";
	}
    
}
