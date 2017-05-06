package xadrez;

import java.awt.Color;
import java.awt.Graphics2D;

public class Casa {

	int x, y;
	Peca peca;
	boolean vazio = true;
	int cor;
	int tamanho = 60;
	
	public Casa(int cor, int x, int y){
	
		this.cor = cor;
		this.x = x;
		this.y = y;
		
	}
	
	public void setPosX(int x){
		this.x = x;
	}
	
	public int getPosX(){
		return this.x;
	}
	
	public void setPosY(int y){
		this.y = y;
	}
	
	public int getPosY(){
		return this.y;
	}
	
	public void setPeca(Peca peca){
		this.peca = peca;
		//this.peca.x = x;
		//this.peca.y = y;
		vazio = false;
	}
	
	public Peca getPeca(){
		return this.peca;
	}
	
	public void removePeca(){
		this.vazio = true;
		this.peca = null;
	}
	
	public void setVazio(boolean vazio){
		this.vazio = vazio;
	}
	
	public boolean getVazio(){
		return this.vazio;
	}
	
	public void DesenhaSe(Graphics2D dbg){
		
		if(cor == 1){
			
			dbg.setColor(Color.BLACK);
		}
		else{
			
			dbg.setColor(Color.white);
		}
		dbg.fillRect(x*tamanho, y*tamanho, tamanho, tamanho);
		
		if(vazio == false){
		peca.DesenhaSe(dbg, x, y);
		}
	}
	
}
