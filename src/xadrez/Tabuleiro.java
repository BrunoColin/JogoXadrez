package xadrez;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tabuleiro {

	
	private Casa[][] casas;
	
	private Peca pecaAux;	
	//private BufferedImage pecasI = GamePanel.loadImage("chess_2.png");
	
	Casa reiBranco;
	Casa reiPreto;
	
	int xequeMate = 0;
	
	
	public Tabuleiro(int padrao){
		
		setTabuleiro(padrao);
	}
	
	public void setTabuleiro(int padrao){
		
		casas = new Casa[8][8];
		
		setCasas();
		
		padrao(padrao);
		
	}

	public void setCasas(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j< 8; j++ ){
				if(j%2 == 0){
					if(i%2 == 0){
						casas[i][j] = new Casa(2,i,j);
					}
					else{						
						casas[i][j] = new Casa(1,i,j);
					}
				}
				else{
					if(i%2 == 0){
						casas[i][j] = new Casa(1,i,j);
					}
					else{						
						casas[i][j] = new Casa(2,i,j);
					}
				}
			}
		}
	}
	
	public Casa getCasas(int x, int y){
		return casas[x][y];
	}

	public void setReiBranco(Casa casa){
		this.reiBranco = casa;
	}
	
	public Casa getReiBranco(){
		return this.reiBranco;
	}
	
	public void setReiPreto(Casa casa){
		this.reiPreto = casa;
	}
	
	public Casa getReiPreto(){
		return this.reiPreto;
	}
	
	public int getXequeMate(){
		return this.xequeMate;
	}
	
	public void movePeca(int xSel, int ySel, int xMove, int yMove){
		casas[xSel][ySel].getPeca().setMove();
		casas[xMove][yMove].setPeca(casas[xSel][ySel].getPeca());
		casas[xSel][ySel].removePeca();
		if(casas[xMove][yMove].getPeca().getTipo() == 5 ){
			if(casas[xMove][yMove].getPeca().getCor() == 2){
				reiPreto = casas[xMove][yMove];
			}
			else{
				reiBranco = casas[xMove][yMove];
			}
		}
	}
	
	public void come(int xSel, int ySel, int xMove, int yMove){
		
		casas[xSel][ySel].getPeca().setMove();
		if(casas[xMove][yMove].getPeca().getTipo() == 5){
			if(casas[xMove][yMove].getPeca().getCor() == 2){
				xequeMate = 2;
			}
			else{
				xequeMate = 1;
			}
		}
		else{
			casas[xMove][yMove].setPeca(casas[xSel][ySel].getPeca());
			casas[xSel][ySel].removePeca();
			if(casas[xMove][yMove].getPeca().getTipo() == 5 ){
				if(casas[xMove][yMove].getPeca().getCor() == 2){
					reiPreto = casas[xMove][yMove];
				}
				else{
					reiBranco = casas[xMove][yMove];
				}
			}	
		}
	}
	
	public void roque(int xSel, int ySel, int xMove, int yMove){
		
		casas[xSel][ySel].getPeca().setMove();
		casas[xMove][yMove].getPeca().setMove();;
		pecaAux = casas[xMove][yMove].getPeca();
		casas[xMove][yMove].setPeca(casas[xSel][ySel].getPeca());
		casas[xSel][ySel].setPeca(pecaAux);
		
		if(casas[xSel][ySel].getPeca().getTipo() == 5 ){
			if(casas[xSel][ySel].getPeca().getCor() == 1){
				reiPreto = casas[xSel][ySel];
			}
			else{
				reiBranco = casas[xSel][ySel];
			}
		}
		if(casas[xMove][yMove].getPeca().getTipo() == 5 ){
			if(casas[xMove][yMove].getPeca().getCor() == 2){
				reiPreto = casas[xMove][yMove];
			}
			else{
				reiBranco = casas[xMove][yMove];
			}
		}
	}
	
	public void DesenhaSe(Graphics2D dbg){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j< 8; j++ ){
				casas[i][j].DesenhaSe(dbg);
			}
		}
	}
	
	public void padrao(int padrao){
		
		switch (padrao) {
		case 1:
			//set torres 
			casas[0][0].setPeca(new Peca(1,2));
			casas[7][0].setPeca(new Peca(1,2));
			casas[0][7].setPeca(new Peca(1,1));
			casas[7][7].setPeca(new Peca(1,1));
			
			//set cavalos
			casas[1][0].setPeca(new Peca(2,2));
			casas[6][0].setPeca(new Peca(2,2));
			casas[1][7].setPeca(new Peca(2,1));
			casas[6][7].setPeca(new Peca(2,1));
			
			//set bispos

			casas[2][0].setPeca(new Peca(3,2));
			casas[5][0].setPeca(new Peca(3,2));
			casas[2][7].setPeca(new Peca(3,1));
			casas[5][7].setPeca(new Peca(3,1));
			
			//set rainhas
			casas[3][0].setPeca(new Peca(4,2));
			casas[3][7].setPeca(new Peca(4,1));
			
			//set reis

			casas[4][0].setPeca(new Peca(5,2));
			casas[4][7].setPeca(new Peca(5,1));
			reiBranco = casas[4][7];
			reiPreto = casas[4][0];
			
			
			for(int i = 0; i< 8; i++){
				
				casas[i][1].setPeca(new Peca(6,2));
				casas[i][6].setPeca(new Peca(6,1));
				
			}
			break;
		case 2:
			//set torres 
			casas[0][0].setPeca(new Peca(1,2));
			casas[7][0].setPeca(new Peca(1,2));
			casas[0][5].setPeca(new Peca(1,1));
			casas[7][7].setPeca(new Peca(1,1));
			
			//set cavalos
			casas[1][0].setPeca(new Peca(2,2));
			casas[6][0].setPeca(new Peca(2,2));
			casas[1][7].setPeca(new Peca(2,1));
			casas[6][7].setPeca(new Peca(2,1));
			
			//set bispos

			casas[2][0].setPeca(new Peca(3,2));
			casas[5][0].setPeca(new Peca(3,2));
			casas[2][7].setPeca(new Peca(3,1));
			casas[3][5].setPeca(new Peca(3,1));
			
			//set rainhas
			casas[3][0].setPeca(new Peca(4,2));
			casas[3][7].setPeca(new Peca(4,1));
			
			//set reis

			casas[4][0].setPeca(new Peca(5,2));
			casas[4][7].setPeca(new Peca(5,1));
			reiBranco = casas[4][7];
			reiPreto = casas[4][0];
			
			
			for(int i = 0; i< 8; i++){
				
//				casas[i][1].setPeca(new Peca(6,2));
//				casas[i][6].setPeca(new Peca(6,1));
				
			}
			break;
		case 3:
			
			//set torres 
			casas[0][0].setPeca(new Peca(1,2));
			casas[7][0].setPeca(new Peca(1,2));
			casas[0][7].setPeca(new Peca(1,1));
			casas[7][7].setPeca(new Peca(1,1));
			
			//set cavalos
			casas[3][3].setPeca(new Peca(2,2));
			casas[6][0].setPeca(new Peca(2,2));
			casas[1][7].setPeca(new Peca(2,1));
			casas[5][5].setPeca(new Peca(2,1));
			
			//set bispos

			casas[7][5].setPeca(new Peca(3,2));
			casas[1][4].setPeca(new Peca(3,2));
			casas[2][7].setPeca(new Peca(3,1));
			casas[5][7].setPeca(new Peca(3,1));
			
			//set rainhas
			casas[3][0].setPeca(new Peca(4,2));
			casas[3][7].setPeca(new Peca(4,1));
			
			//set reis

			casas[4][0].setPeca(new Peca(5,2));
			casas[4][7].setPeca(new Peca(5,1));
			reiBranco = casas[4][7];
			reiPreto = casas[4][0];
			
			
			//peao
			casas[0][1].setPeca(new Peca(6,2));
			casas[2][2].setPeca(new Peca(6,2));
			casas[4][3].setPeca(new Peca(6,2));
			casas[0][7].setPeca(new Peca(6,1));
			casas[2][6].setPeca(new Peca(6,1));
			casas[4][5].setPeca(new Peca(6,1));
			
			break;
			
			
		default:
			break;
		}
		
	}
}
