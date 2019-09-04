package br.com.paripassu.senhas.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import br.com.paripassu.senhas.model.Senha;
import br.com.paripassu.senhas.model.TipoSenha;

@Service
public class SenhaService {
	
	private AtomicInteger atomicInteger = new AtomicInteger();
	private List<Senha> senhas = new LinkedList<>();
	private List<Senha> senhasChamadas = new ArrayList<>();
	
	private Senha senhaChamada;
	private Senha senhaGerada;
	private static Predicate<Senha> senhaNaoChamada = s -> !s.isChamada();
	private static Comparator<Senha> ordenaPorTipoEDataCriacao = Comparator.comparing(Senha::getTipo).reversed()
			.thenComparing(Senha::getDataCriacao);

	public Senha gerarSenha(TipoSenha tipoSenha) {
		final Senha novaSenha = new Senha(atomicInteger.incrementAndGet(), tipoSenha);
		senhas.add(novaSenha);
		setSenhaGerada(novaSenha);

		return novaSenha;
	}

	public Senha proximaSenha() {
		Senha proximaSenha = senhas.parallelStream().filter(senhaNaoChamada).min(ordenaPorTipoEDataCriacao)
				.orElse(null);

		if (proximaSenha != null) {
			proximaSenha.chamar();
			setSenhaChamada(proximaSenha);
			this.senhasChamadas.add(0, proximaSenha);
		}
		
		return proximaSenha;
	}

	public void reiniciarContagem() {
		atomicInteger.set(0);
		setSenhaChamada(null);
		setSenhaGerada(null);
		this.senhasChamadas.clear();
		this.senhas.clear();
	}

	public List<Senha> getSenhas() {
		return senhas;
	}

	public List<Senha> getSenhasChamadas(){
		return senhasChamadas;
	}

	public void setSenhasChamadas(List<Senha> senhasChamadas) {
		this.senhasChamadas = senhasChamadas;
	}

	public Senha getSenhaChamada() {
		return senhaChamada;
	}

	public void setSenhaChamada(Senha senhaChamada) {
		this.senhaChamada = senhaChamada;
	}

	public Senha getSenhaGerada() {
		return senhaGerada;
	}

	public void setSenhaGerada(Senha senhaGerada) {
		this.senhaGerada = senhaGerada;
	}
	
	
	
}
