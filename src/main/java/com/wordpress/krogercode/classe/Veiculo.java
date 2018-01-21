package com.wordpress.krogercode.classe;

public class Veiculo {

	private String modelo;
	
	private String marca;
	
	private int portaMalas;
	
	private int portaMalasUsado;
	
	public Veiculo(String modelo, String marca, int portaMalas) {
		this.modelo = modelo;
		this.marca = marca;
		this.portaMalas = portaMalas;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public int getCapacidadeTotalPortaMalas() {
		return this.portaMalas;
	}
	
	public int getCapacidadeDisponivelPortaMalas() {
		return this.portaMalas - this.portaMalasUsado; 
	}
	
	public int getQuantidadeUtilizadaPortaMalas() {
		return this.portaMalasUsado;
	}
	
	public void adicionarCargaPortaMalas(int litros) throws Exception {
		if(capacidadeExcedida(litros))
			throw new Exception("Erro: Excesso de carga. Espaço disponível: " + getCapacidadeDisponivelPortaMalas());
		else
			this.portaMalasUsado += litros;
	}

	private boolean capacidadeExcedida(int litros) {
		return getCapacidadeDisponivelPortaMalas() < litros;
	}
	
}
