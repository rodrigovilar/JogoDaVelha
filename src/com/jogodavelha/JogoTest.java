package com.jogodavelha;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JogoTest {

	private Jogo jogo;

	@Before
	public void novoJogo() {
		jogo = new Jogo();
	}

	@Test
	public void criarJogo() {
		assertFalse("O jogo iniciou finalizado", jogo.acabou());
	}

	@Test
	public void definirPrimeiroJogador() {
		jogo.setMarcaPrimeiroJogadorX(true);
		assertTrue(jogo.isMarcaPrimeiroJogadorX());
	}
	
	@Test
	public void definirPrimeiroJogadorDeNovo() {
		jogo.setMarcaPrimeiroJogadorX(true); //X
		jogo.setMarcaPrimeiroJogadorX(false); //O
		assertFalse(jogo.isMarcaPrimeiroJogadorX()); //O
	}

	@Test
	public void desenharPrimeiraMarca() {
		jogo.setMarcaPrimeiroJogadorX(true);  //X
		jogo.desenharMarca(1, 0); //X
		assertTrue(jogo.isMarcaXNaPosicao(1, 0));
	}

}
