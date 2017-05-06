package xadrez;

import static org.junit.Assert.*;

import org.junit.Test;

import xadrez.Tabuleiro;

public class Testes {

	@Test
	public void verificaPosicaoReiPreto() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro();
		assertEquals(4, tabuleiro.getReiPreto().getPosX());
		assertEquals(0, tabuleiro.getReiPreto().getPosY());
		
	}
	
	@Test
	public void verificaPosicaoReiBranco() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro();
		assertEquals(4, tabuleiro.getReiBranco().getPosX());
		assertEquals(7, tabuleiro.getReiBranco().getPosY());
		
	}
	
	@Test 
	public void verificaNomeJogador() throws Exception{
		
		Jogador jogador = Auxiliar.criaJogador();
		assertEquals("Bruno", jogador.getNome());
	}
	
	@Test 
	public void verificaTurnoInicial() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro();
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		assertEquals("Bruno", turno.jogador.getNome());
		assertEquals(1, turno.getTurno());
	}
	
	@Test
	public void verificaCliqueForaDoTabuleiro() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro();
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultadoClique = Auxiliar.verificaCliqueForaDoTabuleiro(turno);
		assertEquals(false, resultadoClique);
	}
	
	@Test
	public void verificaCliqueDentroDoTabuleiro() throws Exception{
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro();
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultadoClique = Auxiliar.verificaCliqueDentroDoTabuleiro(turno);
		assertEquals(true, resultadoClique);
	}
	
	@Test
	public void verificaCorDaPeca() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro();
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultadoVerificacaoCorPeca = Auxiliar.verificaCorDaPeca(turno);
		assertEquals(false, resultadoVerificacaoCorPeca);
	}
	
	@Test
	public void verificaPecaSelecionada() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro();
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		Peca peca = Auxiliar.verificaSelecaoPeca(turno);
		assertEquals(1, peca.getTipo());
		
	}
	
	@Test
	public void movePecaSelecionada() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro();
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		Peca peca = Auxiliar.verificaSelecaoPeca(turno);
		Auxiliar.movePecaSelecionada(turno);
		//assertEquals(2, peca.);
		
	}
}
