package xadrez;

import static org.junit.Assert.*;

import org.junit.Test;

import xadrez.Tabuleiro;

public class Testes {

	@Test
	public void verificaPosicaoReiPreto() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(1);
		assertEquals(4, tabuleiro.getReiPreto().getPosX());
		assertEquals(0, tabuleiro.getReiPreto().getPosY());
		
	}
	
	@Test
	public void verificaPosicaoReiBranco() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(1);
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
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(1);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		assertEquals("Bruno", turno.jogador.getNome());
		assertEquals(1, turno.getTurno());
	}
	
	@Test
	public void verificaCliqueForaDoTabuleiro() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(1);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultadoClique = Auxiliar.verificaCliqueForaDoTabuleiro(turno);
		assertEquals(false, resultadoClique);
	}
	
	@Test
	public void verificaCliqueDentroDoTabuleiro() throws Exception{
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(1);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultadoClique = Auxiliar.verificaCliqueDentroDoTabuleiro(turno);
		assertEquals(true, resultadoClique);
	}
	
	@Test
	public void verificaCorDaPeca() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(1);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultadoVerificacaoCorPeca = Auxiliar.verificaCorDaPeca(turno);
		assertEquals(false, resultadoVerificacaoCorPeca);
	}
	
	@Test
	public void verificaPecaSelecionada() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(1);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		Peca peca = Auxiliar.verificaSelecaoPeca(turno);
		assertEquals(1, peca.getTipo());
		
	}
	
	@Test
	public void verificaMovimentoHorizontal() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(1);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultado = Auxiliar.moveHorizontal(turno);
		assertEquals(true, resultado);
		
	}
	
	@Test
	public void verificaMovimentoL() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(1);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultado = Auxiliar.moveL(turno);
		assertEquals(true, resultado);
		
	}
	
	@Test
	public void verificaMovimentoVertical() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(2);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultado = Auxiliar.moveVertical(turno);
		assertEquals(true, resultado);
		
	}
	
	@Test
	public void verficaDiagonal() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(2);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultado = Auxiliar.moveDiagonal(turno);
		assertEquals(true, resultado);
	}
	
	@Test
	public void verficaDiagonalInvalida() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(2);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultado = Auxiliar.moveDiagonalInvalida(turno);
		assertEquals(false, resultado);
	}
	
	@Test
	public void movimentoBloqueado() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(2);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultado = Auxiliar.movimentoBloqueado(turno);
		assertEquals(false, resultado);
		
	}
	
	@Test
	public void verificaXeque() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(3);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultado = Auxiliar.verificaXeque(turno);
		assertEquals(true, resultado);
		
	}
	
	@Test
	public void verificaXequeMate() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(3);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		int resultado = Auxiliar.verificaXequeMate(turno);
		assertEquals(1, resultado);
		
	}
	
	@Test
	public void roqueInvalido() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(1);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultado = Auxiliar.validaRoque(turno);
		assertEquals(false, resultado);
		
	}
	
	@Test
	public void roqueValido() throws Exception{
		
		Tabuleiro tabuleiro = Auxiliar.criaTabuleiro(3);
		Jogador jogador = Auxiliar.criaJogador();
		Turno turno = Auxiliar.criaTurno(jogador, tabuleiro);
		boolean resultado = Auxiliar.validaRoque(turno);
		assertEquals(true, resultado);
		
	}
	
}
