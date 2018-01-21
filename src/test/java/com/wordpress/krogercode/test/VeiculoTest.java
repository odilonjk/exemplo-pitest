package com.wordpress.krogercode.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import com.wordpress.krogercode.classe.Veiculo;

public class VeiculoTest {
	
	@Test
	public void testeConstrutor() {
		
		String modelo = "Challenger";
		String marca = "Dodge";
		int capacidadePortaMalas = 459;
		
		Veiculo challenger = new Veiculo(modelo, marca, capacidadePortaMalas);
		
		assertTrue(challenger.getMarca().equals(marca));
		assertTrue(challenger.getModelo().equals(modelo));
		assertEquals(challenger.getCapacidadeTotalPortaMalas(), capacidadePortaMalas);
		assertEquals(challenger.getQuantidadeUtilizadaPortaMalas(), 0);
		assertEquals(challenger.getCapacidadeDisponivelPortaMalas(), capacidadePortaMalas);
		
	}
	
	@Test
	public void testeCapacidade() throws Exception {
		
		String modelo = "Jimmy";
		String marca = "Suzuki";
		int capacidadePortaMalas = 113;
		
		Veiculo jimmy = new Veiculo(modelo, marca, capacidadePortaMalas);
		
		jimmy.adicionarCargaPortaMalas(13);
		
		// Adicionado para matar o mutante
		assertEquals(jimmy.getCapacidadeDisponivelPortaMalas(), 100);
		
	}

	@Test
	public void testeValidacaoCapacidade() {
		
		String modelo = "Caravan";
		String marca = "Chevrolet";
		int capacidadePortaMalas = 774;
		
		Veiculo caravan = new Veiculo(modelo, marca, capacidadePortaMalas);

		//	Adicionado para matar o mutante
		try {
			caravan.adicionarCargaPortaMalas(774);
		} 
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		try {
			caravan.adicionarCargaPortaMalas(800);
		} 
		catch (Exception e) {
			assertTrue(e.getMessage()
					.equals("Erro: Excesso de carga. Espaço disponível: " 
							+ caravan.getCapacidadeDisponivelPortaMalas()));
		}
		
		// Adicionado para matar o mutante
		assertEquals(caravan.getCapacidadeDisponivelPortaMalas(), 0);
		
	}
}
