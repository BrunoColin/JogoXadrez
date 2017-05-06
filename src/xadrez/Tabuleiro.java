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
	
	
	public Tabuleiro(){
		
		setTabuleiro();
	}
	
	public void setTabuleiro(){
		
		casas = new Casa[8][8];
		
		setCasas();
		
		//set torres 
//		casas[0][0].setPeca(new Peca(1,2, pecasI.getSubimage(3*128, 2*128, 128, 128)));
//		casas[7][0].setPeca(new Peca(1,2,pecasI.getSubimage(3*128, 2*128, 128, 128)));
//		casas[0][7].setPeca(new Peca(1,1,pecasI.getSubimage(3*128, 128, 128, 128)));
//		casas[7][7].setPeca(new Peca(1,1,pecasI.getSubimage(3*128, 128, 128, 128)));
		casas[0][0].setPeca(new Peca(1,2));
		casas[7][0].setPeca(new Peca(1,2));
		casas[0][7].setPeca(new Peca(1,1));
		casas[7][7].setPeca(new Peca(1,1));
		
		//set cavalos
//		casas[1][0].setPeca(new Peca(2,2,pecasI.getSubimage(128, 2*128, 128, 128)));
//		casas[6][0].setPeca(new Peca(2,2,pecasI.getSubimage(128, 2*128, 128, 128)));
//		casas[1][7].setPeca(new Peca(2,1,pecasI.getSubimage(128, 128, 128, 128)));
//		casas[6][7].setPeca(new Peca(2,1,pecasI.getSubimage(128, 128, 128, 128)));
		casas[1][0].setPeca(new Peca(2,2));
		casas[6][0].setPeca(new Peca(2,2));
		casas[1][7].setPeca(new Peca(2,1));
		casas[6][7].setPeca(new Peca(2,1));
		
		//set bispos
//		casas[2][0].setPeca(new Peca(3,2,pecasI.getSubimage(2*128, 2*128, 128, 128)));
//		casas[5][0].setPeca(new Peca(3,2,pecasI.getSubimage(2*128, 2*128, 128, 128)));
//		casas[2][7].setPeca(new Peca(3,1,pecasI.getSubimage(2*128, 128, 128, 128)));
//		casas[5][7].setPeca(new Peca(3,1,pecasI.getSubimage(2*128, 128, 128, 128)));
		casas[2][0].setPeca(new Peca(3,2));
		casas[5][0].setPeca(new Peca(3,2));
		casas[2][7].setPeca(new Peca(3,1));
		casas[5][7].setPeca(new Peca(3,1));
		
		//set rainhas
//		casas[3][0].setPeca(new Peca(4,2,pecasI.getSubimage(4*128, 2*128, 128, 128)));
//		casas[3][7].setPeca(new Peca(4,1,pecasI.getSubimage(4*128, 128, 128, 128)));
		casas[3][0].setPeca(new Peca(4,2));
		casas[3][7].setPeca(new Peca(4,1));
		
		//set reis
//		casas[4][0].setPeca(new Peca(5,2,pecasI.getSubimage(5*128, 2*128, 128, 128)));
//		casas[4][7].setPeca(new Peca(5,1,pecasI.getSubimage(5*128, 128, 128, 128)));
		casas[4][0].setPeca(new Peca(5,2));
		casas[4][7].setPeca(new Peca(5,1));
		reiBranco = casas[4][7];
		reiPreto = casas[4][0];
		
		
		for(int i = 0; i< 8; i++){
			
//			casas[i][1].setPeca(new Peca(6,2,pecasI.getSubimage(0, 2*128, 128, 128)));
//			casas[i][6].setPeca(new Peca(6,1,pecasI.getSubimage(0, 128, 128, 128)));
			casas[i][1].setPeca(new Peca(6,2));
			casas[i][6].setPeca(new Peca(6,1));
			
		}
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
}
