package xadrez;

public enum Pecas{
	Peao(1),
	Torre(2),
	Bispo(3),
	Cavalo(4),
	Rainha(5),
	Rei(6);
	
	int tipo;
	
	Pecas(int tipo){
		this.tipo = tipo;
	}
}
