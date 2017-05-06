package xadrez;

public class Turno {

	
	Jogador jogador;
	Jogadas jogada;
	int turno;
	boolean selecionada = false;
	int xSel, ySel, xMove, yMove;
	Tabuleiro tabuleiro;
	
	public Turno(Jogador jogador, Tabuleiro tabuleiro){
		this.jogador = jogador;
		this.turno = 1;
		this.tabuleiro = tabuleiro;
	}
	
	public void setJogadorTurno(Tabuleiro tabuleiro,Jogador jogador){
		
		this.tabuleiro = tabuleiro;
		this.jogador = jogador;
		turno++;
	}
	
	public Jogador getJogador(){
		return this.jogador;
	}
	
	public void setTurno(int turno){
		this.turno = turno;
	}
	
	public int getTurno(){
		return this.turno;
	}
	
	public void setSelecionada(boolean selecionada){
		this.selecionada = selecionada;
	}
	
	public boolean getSelecionada(){
		return this.selecionada;
	}
	public Peca selecionaPeca(int x, int y){
		
		if(verificaCasa(x, y)){
			if(verificaPeca(x,y)){
				xSel = x;
				ySel = y;
				selecionada = true;
				System.out.println("peca " + tabuleiro.getCasas(x, y).getPeca().getTipo() + " selecionada");
				return tabuleiro.getCasas(x, y).getPeca();
			}
			else{
				System.out.println("O jogador não pode selecionar a peça do adversário");
				return null;
			}
		}
		else{
			System.out.println("Posição invalida");
			return null;
		}
		
	}
	
	public void movePecaSelecionada(int x, int y){
		
		tabuleiro.movePeca(xSel, ySel, x, y);
		selecionada = false;
		
	}
	
	public void comePeca(int x, int y){
		
		tabuleiro.come(xSel, ySel, x, y);
		selecionada = false;
		
	}
	
	public void roque(int x, int y){

		tabuleiro.roque(xSel, ySel, x, y);
		selecionada = false;
		
	}

	
	public boolean verificaPeca(int x, int y){
			
		if(tabuleiro.getCasas(x, y).vazio){
			return false;
		}
		else{
			int corPeca = tabuleiro.getCasas(x, y).getPeca().getCor(); 

			if(corPeca%2 == turno%2){
				return true;
			}
			else{
				return false;
			}
		}
	}
	
	public boolean verificaCasa(int x, int y){
		
		if(x < 0 || x > 7 || y < 0 || y > 7){
			return false;
		}
		else{
			if(tabuleiro.getCasas(x, y).vazio){
				return false;
			}
			else{
			return true;
			}
		}
	}
	
	public boolean validaJogada(int x, int y){
		
		jogada = new Jogadas(xSel, ySel, x, y, tabuleiro);
		return jogada.jogada();
	}
	
//	
//	public boolean validaXeque(Casa rei){
//	
//		return xeque(rei);
//	}
	
	public boolean validaXeque(Casa rei){
		
		boolean validate = false;

		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){

				if(tabuleiro.getCasas(i, j).getVazio() == false){

					if(tabuleiro.getCasas(i, j).getPeca().getCor() != tabuleiro.getCasas(rei.getPosX(), rei.getPosY()).getPeca().getCor() ){


						if(i != rei.getPosX() || j != rei.getPosY()){

							Jogadas xeque = new Jogadas(i, j, rei.getPosX(), rei.getPosY(), this.tabuleiro);
							validate =  xeque.jogada();
							if(validate){
								return true;
							}
						}
					}

				}

			}
		}

		return validate;
	}

}
