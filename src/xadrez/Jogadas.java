package xadrez;

public class Jogadas {

	Peca peca;
	int xSel, ySel, xMove, yMove;
	Tabuleiro tabuleiro;
	int tipoJogada = 0;
	boolean adversario;
	
	public Jogadas(int xSel, int ySel, int xMove, int yMove,Tabuleiro tabuleiro){
		this.xSel = xSel;
		this.ySel = ySel;
		this.xMove = xMove;
		this.yMove = yMove;
		this.tabuleiro = tabuleiro;
		peca = tabuleiro.getCasas(xSel, ySel).getPeca();
	}
	
	public boolean jogada(){
		
		boolean jogada = false;
		adversario = false;
		
		if(tabuleiro.getCasas(xMove, yMove).getVazio() == false){
			if(tabuleiro.getCasas(xMove, yMove).getPeca().getCor() != peca.getCor()){
				adversario = true;
			}
		}
		
		switch (peca.getTipo()) {
		case 1:
			
			if(Math.abs(xSel - xMove) == 0){
				if(Math.abs(ySel - yMove) > 0){
					if(adversario){
						jogada = comeVertical(8);
						tipoJogada = 2;					
					}
					else{
						jogada = validarVertical(8);
						tipoJogada = 1;
					}
				}
			}
			if(Math.abs(ySel - yMove) == 0){
				if(Math.abs(xSel - xMove) > 0){
					
					if(adversario){
						jogada = comeHorizontal(8);
						tipoJogada = 2;					
					}
					else{
						jogada = validaHorizontal(8);
						tipoJogada = 1;
					}
				}
			}
			
			if(adversario == false){
				if(tabuleiro.getCasas(xMove, yMove).getVazio() == false){
					if(tabuleiro.getCasas(xSel, ySel).getPeca().getMove() == false && tabuleiro.getCasas(xMove, yMove).getPeca().getMove() == false && tabuleiro.getCasas(xMove, yMove).getPeca().getTipo() == 5){

						jogada = validaHorizontalRoque();
						tipoJogada = 3;
					}
				}	
			}
				
			break;
		case 2:
			if(adversario){
				jogada = comeL();
				tipoJogada = 2;					
			}else{
				jogada = validarL();
				tipoJogada = 1;
			}
			break;
		case 3:
			if(Math.abs(xSel - xMove) != 0 && Math.abs(ySel - yMove) != 0 ){
				
				if(adversario){
					jogada = comeDiagonal(8);
					tipoJogada = 2;					
				}
				else{
					jogada = validarDiagonal(8);
					tipoJogada = 1;
				}
			}
			break;
		case 4:
			
			if(Math.abs(xSel - xMove) == 0){
				if(Math.abs(ySel - yMove) > 0){
					
					if(adversario){
						jogada = comeVertical(8);
						tipoJogada = 2;					
					}
					else{
						jogada = validarVertical(8);
						tipoJogada = 1;
					}
				}
			}
			if(Math.abs(ySel - yMove) == 0){
				if(Math.abs(xSel - xMove) > 0){
					
					if(adversario){
						jogada = comeHorizontal(8);
						tipoJogada = 2;					
					}
					else{
						jogada = validaHorizontal(8);
						tipoJogada = 1;
					}
				}
			}
			
			if(Math.abs(xSel - xMove) != 0 && Math.abs(ySel - yMove) != 0 ){
				
				if(adversario){
					jogada = comeDiagonal(8);
					tipoJogada = 2;					
				}
				else{
					jogada = validarDiagonal(8);
					tipoJogada = 1;
				}
			}
			break;
		case 5:
			
			if(Math.abs(xSel - xMove) == 0){
				if(Math.abs(ySel - yMove) > 0){
					
					if(adversario){
						jogada = comeVertical(1);
						tipoJogada = 2;					
					}
					else{
						jogada = validarVertical(1);
						tipoJogada = 1;
					}
				}
			}
			if(Math.abs(ySel - yMove) == 0){
				if(Math.abs(xSel - xMove) > 0){
					
					if(adversario){
						jogada = comeHorizontal(1);
						tipoJogada = 2;					
					}
					else{
						jogada = validaHorizontal(1);
						tipoJogada = 1;
					}
				}
			}
			
			if(Math.abs(xSel - xMove) != 0 && Math.abs(ySel - yMove) != 0 ){
				
				if(adversario){
					jogada = comeDiagonal(1);
					tipoJogada = 2;					
				}
				else{
					jogada = validarDiagonal(1);
					tipoJogada = 1;
				}
			}
			
			if(adversario == false){
				if(tabuleiro.getCasas(xMove, yMove).getVazio() == false){
					if(tabuleiro.getCasas(xSel, ySel).getPeca().getMove() == false && tabuleiro.getCasas(xMove, yMove).getPeca().getMove() == false && tabuleiro.getCasas(xMove, yMove).getPeca().getTipo() == 1){

						jogada = validaHorizontalRoque();
						if(adversario){
							tipoJogada = 2;					
						}
						tipoJogada = 3;
					}
				}
			}
			
			break;
		case 6:
			if(adversario == false){
			if(Math.abs(xSel - xMove) == 0){
				if(peca.cor == 2){
					if(ySel - yMove < 0){
						if(peca.getMove() == false){

							jogada = validarVertical(2);
							tipoJogada = 1;
						}
						else{
							jogada = validarVertical(1);
							tipoJogada = 1;
						}
					}
				}
				else{
					if(ySel - yMove > 0){
						if(peca.getMove() == false){

							jogada = validarVertical(2);
							tipoJogada = 1;
						}
						else{
							jogada = validarVertical(1);
							tipoJogada = 1;
						}
					}
				}

			}
			}
			else{
				if(Math.abs(xSel - xMove) != 0 && Math.abs(ySel - yMove) != 0){
					if(peca.cor == 2){
						if(ySel - yMove < 0){
							jogada = comeDiagonal(1);
							tipoJogada = 2;
						}
					}
					else{
						if(ySel - yMove > 0){
							jogada = comeDiagonal(1);
							tipoJogada = 2;
						}
					}
					
				}
			}
			break;
		default:
			break;
		}
		
		return jogada;
	}
	
	boolean comeHorizontal(int max){
		
		int distHorizontal = xSel - xMove;
		int dist = Math.abs(xSel - xMove);
		if(dist <= max){
		if(distHorizontal > 0){
			
			for(int i = 1; i < Math.abs(distHorizontal); i++){
				
				if(tabuleiro.getCasas(xSel-i, ySel).getVazio() == false){
					
					return false;
					
				}
			}
		
		}
		else{
			
			for(int i = 1; i < Math.abs(distHorizontal); i++){
				
				if(tabuleiro.getCasas(xSel+i, ySel).getVazio() == false){
					
					return false;
					
				}
			}
		}
	
		return true;
		}
		else{
			return false;
		}
	}

	
	boolean validaHorizontal(int max){
		
		int distHorizontal = xSel - xMove;
		int dist = Math.abs(xSel - xMove);
		if(dist <= max){
		if(distHorizontal > 0){
			
			for(int i = 1; i <= Math.abs(distHorizontal); i++){
				
				if(tabuleiro.getCasas(xSel-i, ySel).getVazio() == false){
					
					return false;
					
				}
			}
		
		}
		else{
			
			for(int i = 1; i <= Math.abs(distHorizontal); i++){
				
				if(tabuleiro.getCasas(xSel+i, ySel).getVazio() == false){
					
					return false;
					
				}
			}
		}
	
		return true;
		}
		else{
			return false;
		}
	}
	
	boolean validaHorizontalRoque(){
		
		int distHorizontal = xSel - xMove;
		if(distHorizontal > 0){
			
			for(int i = 1; i < Math.abs(distHorizontal); i++){
				
				if(tabuleiro.getCasas(xSel-i, ySel).getVazio() == false){
					
					return false;
					
				}
			}
		
		}
		else{
			
			for(int i = 1; i < Math.abs(distHorizontal); i++){
				
				if(tabuleiro.getCasas(xSel+i, ySel).getVazio() == false){
					
					return false;
					
				}
			}
		}
		return true;
	}

	boolean comeVertical(int max){
		
		int distVertical = ySel - yMove;
		int dist = Math.abs(ySel - yMove);
		if(dist <= max){
		if(distVertical > 0){
			
			for(int i = 1; i < Math.abs(distVertical); i++){
				
				if(tabuleiro.getCasas(xSel, ySel-i).getVazio() == false){
					
					return false;
					
				}
			}
		
		}
		else{
			
			for(int i = 1; i < Math.abs(distVertical); i++){
				
				if(tabuleiro.getCasas(xSel, ySel+i).getVazio() == false){
					
					return false;
					
				}
			}
		}
	
		return true;
		}
		else{
			return false;
		}
	}


	boolean validarVertical(int max){
		
		int distVertical = ySel - yMove;
		int dist = Math.abs(ySel - yMove);
		if(dist <= max){
		if(distVertical > 0){
			
			for(int i = 1; i <= Math.abs(distVertical); i++){
				
				if(tabuleiro.getCasas(xSel, ySel-i).getVazio() == false){
					
					return false;
					
				}
			}
		
		}
		else{
			
			for(int i = 1; i <= Math.abs(distVertical); i++){
				
				if(tabuleiro.getCasas(xSel, ySel+i).getVazio() == false){
					
					return false;
					
				}
			}
		}
	
		return true;
		}
		else{
			return false;
		}
	}
	
	boolean comeL(){
		
		if((Math.abs(xSel - xMove) == 2 && Math.abs(ySel - yMove) == 1) || (Math.abs(xSel - xMove) == 1 && Math.abs(ySel - yMove) == 2)){
			
			return true;
		}
		else{
			return false;
		}
		
	}
	
	boolean validarL(){
		
		if((Math.abs(xSel - xMove) == 2 && Math.abs(ySel - yMove) == 1) || (Math.abs(xSel - xMove) == 1 && Math.abs(ySel - yMove) == 2)){
			
			if(tabuleiro.getCasas(xMove, yMove).getVazio() == true){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
	}
	

	boolean comeDiagonal(int max){

		int distDiagonalX = Math.abs(xSel - xMove);
		int distDiagonalY = Math.abs(ySel - yMove);
		int distX = xSel - xMove;
		int distY = ySel - yMove;

		if(distDiagonalX == distDiagonalY){
		if(distDiagonalX <= max){

			if(distX > 0 && distY > 0){

				for(int i = 1; i < distDiagonalX; i++){

					if(tabuleiro.getCasas(xSel-i, ySel-i).getVazio() == false){
						return false;
					}

				}

			}

			if(distX > 0 && distY < 0){

				for(int i = 1; i < distDiagonalX; i++){

					if(tabuleiro.getCasas(xSel-i, ySel+i).getVazio() == false){
						return false;
					}

				}
			}

			if(distX < 0 && distY < 0){

				for(int i = 1; i < distDiagonalX; i++){

					if(tabuleiro.getCasas(xSel+i, ySel+i).getVazio() == false){
						return false;
					}

				}
			}

			if(distX < 0 && distY > 0){

				for(int i = 1; i < distDiagonalX; i++){

					if(tabuleiro.getCasas(xSel+i, ySel-i).getVazio() == false){
						return false;
					}

				}
			}

			return true;
		}
		else{
			return false;
		}
		}
		else{
			return false;
		}
	}
	
	boolean validarDiagonal(int max){

		int distDiagonalX = Math.abs(xSel - xMove);
		int distDiagonalY = Math.abs(ySel - yMove);
		int distX = xSel - xMove;
		int distY = ySel - yMove;

		if(distDiagonalX == distDiagonalY){
		
		if(distDiagonalX <= max){

			if(distX > 0 && distY > 0){

				for(int i = 1; i <= distDiagonalX; i++){

					if(tabuleiro.getCasas(xSel-i, ySel-i).getVazio() == false){
						return false;
					}

				}

			}

			if(distX > 0 && distY < 0){

				for(int i = 1; i <= distDiagonalX; i++){

					if(tabuleiro.getCasas(xSel-i, ySel+i).getVazio() == false){
						return false;
					}

				}
			}

			if(distX < 0 && distY < 0){

				for(int i = 1; i <= distDiagonalX; i++){

					if(tabuleiro.getCasas(xSel+i, ySel+i).getVazio() == false){
						return false;
					}

				}
			}

			if(distX < 0 && distY > 0){

				for(int i = 1; i <= distDiagonalX; i++){

					if(tabuleiro.getCasas(xSel+i, ySel-i).getVazio() == false){
						return false;
					}

				}
			}

			return true;
		}
		else{
			return false;
		}
		}
		else{
			return false;
		}
	}
	
	public boolean roque(){

		if(tabuleiro.getCasas(xSel, ySel).getPeca().getMove() == false && tabuleiro.getCasas(xMove, yMove).getPeca().getMove() == false){
			return validaHorizontal(8);
		}
		else{
			return false;
		}
	}
	
	}
