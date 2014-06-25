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
		jogo.setMarcaPrimeiroJogadorX(true); // X
		jogo.setMarcaPrimeiroJogadorX(false); // O
		assertFalse(jogo.isMarcaPrimeiroJogadorX()); // O
	}

	@Test
	public void desenharPrimeiraMarca() {
		jogo.setMarcaPrimeiroJogadorX(true); // X
		jogo.desenharMarca(1, 0); // X
		assertTrue(jogo.isMarcaXNaPosicao(1, 0));
	}

	@Test(expected = ExcecaoJogoDaVelha.class)
	public void desenharEmCelulaOcupada() {
		jogo.setMarcaPrimeiroJogadorX(true);
		jogo.desenharMarca(1, 0);
		jogo.desenharMarca(1, 0);
	}

	@Test(expected = ExcecaoJogoDaVelha.class)
	public void desenharEmColunaErrada() {
		jogo.setMarcaPrimeiroJogadorX(false);
		jogo.desenharMarca(1, 4);
	}

	@Test(expected = ExcecaoJogoDaVelha.class)
	public void desenharEmLinhaErrada() {
		jogo.setMarcaPrimeiroJogadorX(false);
		jogo.desenharMarca(-1, 0);
	}

	@Test
	public void lerDeUmaCelulaDesocupada() {
		jogo.setMarcaPrimeiroJogadorX(false);
		assertNull(jogo.isMarcaXNaPosicao(0, 0));
	}

	@Test(expected = ExcecaoJogoDaVelha.class)
	public void lerMarcaDeUmaColunaErrada() {
		jogo.setMarcaPrimeiroJogadorX(true);
		jogo.isMarcaXNaPosicao(1, 3);
	}

	@Test(expected = ExcecaoJogoDaVelha.class)
	public void lerMarcaDeUmaLinhaErrada() {
		jogo.setMarcaPrimeiroJogadorX(true);
		jogo.isMarcaXNaPosicao(-1, 1);
	}

	@Test(expected = ExcecaoJogoDaVelha.class)
	public void definirPrimeiroJogadorAposInicioDoJogo() {
		jogo.setMarcaPrimeiroJogadorX(true);
		jogo.desenharMarca(1, 0); // Início do jogo
		jogo.setMarcaPrimeiroJogadorX(true);
	}

	@Test(expected = ExcecaoJogoDaVelha.class)
	public void desenharMarcaAntesDeDefinirPrimeiroJogador() {
		jogo.desenharMarca(1, 0);
	}

	@Test
	public void desenharSegundaMarca() {
		jogo.setMarcaPrimeiroJogadorX(true); // X
		jogo.desenharMarca(1, 0); // X
		jogo.desenharMarca(1, 1); // O
		assertFalse(jogo.isMarcaXNaPosicao(1, 1));
	}

	@Test
	public void jogoGanhoAtravesDeColuna() {
		jogo.setMarcaPrimeiroJogadorX(false);
		jogo.desenharMarca(0, 0);
		jogo.desenharMarca(1, 2);
		jogo.desenharMarca(1, 0);
		jogo.desenharMarca(2, 2);
		jogo.desenharMarca(2, 0);
		assertTrue("Esperava que o jogo tivesse acabado", jogo.acabou());
	}
}
