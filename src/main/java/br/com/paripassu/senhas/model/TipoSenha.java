package br.com.paripassu.senhas.model;


public enum TipoSenha {
	NORMAL("N"),
    PREFERENCIAL("P");
	
	TipoSenha(String prefixo){
		this.prefixo = prefixo;
	}

    private final String prefixo;

    String formataSenha(Senha senha) {
        String senhaFormatada = prefixo + String.format("%4s", senha.getDigito());
        return senhaFormatada.replaceAll("\\s", "0");
    }
}
