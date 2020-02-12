package br.com.pos.entidade;

public enum Sigla {

	ALI("ALI", 7), AIE ("AIE", 5),EE("EE", 3),CE("CE", 3),SE("SE", 4);

	private int valor;
	private String texto;


	private Sigla(String texto,int valor) {
		this.valor = valor;
	} 

	public int getValor() {
		return valor;
	}
}
