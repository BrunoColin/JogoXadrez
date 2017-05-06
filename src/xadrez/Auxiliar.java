package xadrez;

public class Auxiliar {

	public static Tabuleiro criaTabuleiro(){
	
		Tabuleiro tabuleiro = new Tabuleiro();
		
		return tabuleiro;
		
	}
	
	public static Jogador criaJogador(){
		
		Jogador jogador = new Jogador("Bruno");
		
		return jogador;
	}
	
	public static Turno criaTurno(Jogador jogador, Tabuleiro tabuleiro){
		
		Turno turno = new Turno(jogador, tabuleiro);
		
		return turno;
		
	}
	
	public static boolean verificaCliqueForaDoTabuleiro(Turno turno){
		
		return turno.verificaCasa(8, 8);
		
	}

	public static boolean verificaCliqueDentroDoTabuleiro(Turno turno){
		
		return turno.verificaCasa(4, 4);
		
	}
	
	public static boolean verificaCorDaPeca(Turno turno){
		
		return turno.verificaPeca(4,4);
	}
	
	public static Peca verificaSelecaoPeca(Turno turno){
		
		return turno.selecionaPeca(0,7);
	}
	
	public static void movePecaSelecionada(Turno turno){
		
		turno.movePecaSelecionada(2, 7);
	}
}
