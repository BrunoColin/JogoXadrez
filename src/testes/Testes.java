package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import xadrez.Auxiliar;
import xadrez.Tabuleiro;

public class Testes {

	@Test
	public void verificaPosicaoReiPreto() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro();
		assertEquals(4, tabuleiro.getReiPreto().getPosX());
		
	}
	
}
