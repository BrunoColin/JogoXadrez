package xadrez;

public class Auxiliar {

	public static Tabuleiro criaTabuleiro(int padrao){
	
		Tabuleiro tabuleiro = new Tabuleiro(padrao);
		
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
	
	public static boolean moveHorizontal(Turno turno){
		
		Jogadas jogadas= new Jogadas(0, 7, 1, 7, turno.tabuleiro);
		return jogadas.jogada();
		
	}
	
	public static boolean moveL(Turno turno){
		Jogadas jogadas= new Jogadas(1, 0, 2, 2, turno.tabuleiro);
		return jogadas.jogada();
	}
	
	public static boolean validaRoque(Turno turno){
		Jogadas jogadas= new Jogadas(7, 7, 4, 7, turno.tabuleiro);
		return jogadas.jogada();
	}
	
	public static boolean moveVertical(Turno turno){
		
		Jogadas jogadas= new Jogadas(0, 5, 0, 3, turno.tabuleiro);
		return jogadas.jogada();
		
	}
	
	public static boolean moveDiagonal(Turno turno){
		
		Jogadas jogadas= new Jogadas(5, 0, 0, 5, turno.tabuleiro);
		return jogadas.jogada();
		
	}
	
	public static boolean moveDiagonalInvalida(Turno turno){
		
		Jogadas jogadas= new Jogadas(5, 0, 1, 5, turno.tabuleiro);
		return jogadas.jogada();
		
	}
	
	public static boolean movimentoBloqueado(Turno turno){
		
		Jogadas jogadas= new Jogadas(3, 0, 3, 7, turno.tabuleiro);
		return jogadas.jogada();
		
	}	
	
	public static boolean verificaXeque(Turno turno){
		
		return turno.validaXeque(turno.tabuleiro.reiBranco);
		
	}	
	
	public static int verificaXequeMate(Turno turno){
		
		turno.tabuleiro.come(1, 4, 4, 7);
		return turno.tabuleiro.getXequeMate();
	}	
}
