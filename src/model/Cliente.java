package model;

public class Cliente{

	public int numero;
	public String nome;
	
	public Cliente() {
		super();
		
	}
	public Cliente(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}

	public String toString() {
		return "Cliente [nome=" + nome + ", numero=" + numero + "]";
	}
}
