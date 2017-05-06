package xadrez;

public class Jogador {

	String nome;
	public Jogador(String nome){
		this.nome = nome;
	}
	
	public Peca selecionaPeca(Tabuleiro tabuleiro, int x, int y){
		
		return tabuleiro.getCasas(x, y).peca;
		
	}
	
	//public movimentaPeca ()
	
}
