package br.com.paripassu.senhas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.paripassu.senhas.service.SenhaService;

@Controller
@RequestMapping("/gerente")
public class SenhaGerenteController {
	
	@Autowired
	private SenhaService senhaService;
	
	@GetMapping
	public ModelAndView PainelGerente() {		
        ModelAndView modelAndView = new ModelAndView("PainelGerente");
        modelAndView.addObject("senhaChamada", senhaService.getSenhaChamada());
		
		return modelAndView;
    }
	
    @GetMapping("proxima-senha")
    public String chamarProximaSenha() {
    	senhaService.proximaSenha();
        return "redirect:/gerente";
    }

    @PostMapping("reiniciar")
    public String reiniciarContagem() {
        senhaService.reiniciarContagem();
        return "redirect:/gerente";
    }
}
