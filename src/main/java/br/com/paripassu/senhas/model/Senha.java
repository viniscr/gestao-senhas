package br.com.paripassu.senhas.model;

import java.util.Date;

public class Senha {
	private Integer digito;
	private TipoSenha tipo;
	private boolean chamada = false;
	private Date dataChamada;
	private Date dataCriacao = new Date();
	
	public Senha(Integer digito, TipoSenha tipo) {
		this.digito = digito;
		this.tipo = tipo;
	}
	
	public String toString() {
		return tipo.formataSenha(this);
	}
	
	public void chamar() {
		this.chamada = true;
		this.dataChamada = new Date();
	}

	public Integer getDigito() {
		return digito;
	}

	public void setDigito(Integer digito) {
		this.digito = digito;
	}

	public TipoSenha getTipo() {
		return tipo;
	}

	public void setTipo(TipoSenha tipo) {
		this.tipo = tipo;
	}

	public boolean isChamada() {
		return chamada;
	}

	public void setChamada(boolean chamada) {
		this.chamada = chamada;
	}

	public Date getDataChamada() {
		return dataChamada;
	}

	public void setDataChamada(Date dataChamada) {
		this.dataChamada = dataChamada;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
}
