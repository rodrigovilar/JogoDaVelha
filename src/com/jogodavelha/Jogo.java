package com.jogodavelha;

public class Jogo {

	private boolean marcaPrimeiroJogadorX;
	private Boolean[][] tabuleiro = new Boolean[3][3];

	public boolean acabou() {
		return false;
	}

	public void setMarcaPrimeiroJogadorX(boolean marcaPrimeiroJogadorX) {
		this.marcaPrimeiroJogadorX = marcaPrimeiroJogadorX;
	}

	public boolean isMarcaPrimeiroJogadorX() {
		return marcaPrimeiroJogadorX;
	}

	public void desenharMarca(int linha, int coluna) {
		verificarLimites(linha, coluna);
		
		if (tabuleiro[linha][coluna] != null) {
			lancarExcecao();
		}

		tabuleiro[linha][coluna] = marcaPrimeiroJogadorX;
	}

	private void verificarLimites(int linha, int coluna) {
		if (coluna < 0 || coluna > 2) {
			lancarExcecao();
		}

		if (linha < 0 || linha > 2) {
			lancarExcecao();
		}
	}

	private void lancarExcecao() {
		throw new ExcecaoJogoDaVelha();
	}

	public Boolean isMarcaXNaPosicao(int linha, int coluna) {
		verificarLimites(linha, coluna);
		
		return tabuleiro[linha][coluna];
	}

}
