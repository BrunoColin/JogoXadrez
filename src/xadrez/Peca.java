package xadrez;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Peca {

	int tipo;
	int cor;
	boolean seMoveu = false;
	//BufferedImage imagem;

	public Peca(int tipo, int cor){
		this.tipo = tipo;
		this.cor = cor;
		//this.imagem = imagem;
	}
	
	public void DesenhaSe(Graphics2D dbg, int x, int y){
		
		if(cor == 1){
			dbg.setColor(Color.GREEN);
			dbg.fillRect(x* 60 + 5, y * 60 + 10, 45, 30);
			dbg.setColor(Color.black);
		}
		else{
			dbg.setColor(Color.DARK_GRAY);
			dbg.fillRect(x* 60 + 5, y * 60 + 10, 45, 30);
			dbg.setColor(Color.WHITE);
		}
		
		switch (tipo) {
		case 1:	
			dbg.drawString("Torre", x * 60 + 10, y * 60 + 30);
			break;
		case 2:	
			dbg.drawString("Cavalo", x * 60 + 10, y * 60 + 30);
			break;
		case 3:	
			dbg.drawString("Bispo", x * 60 + 10, y * 60 + 30);
			break;
		case 4:	
			dbg.drawString("Rainha", x * 60 + 10, y * 60 + 30);
			break;
		case 5:	
			dbg.drawString("Rei", x * 60 + 10, y * 60 + 30);
			break;
		case 6:	
			dbg.drawString("Peão", x * 60 + 10, y * 60 + 30);
			break;

		default:
			break;
		}
		//dbg.drawImage(imagem, x*60 +10, y*60 + 10, 40, 40, null);		
	}
	
	public int getCor(){
		return this.cor;
	}
	
	public int getTipo(){
		return this.tipo;
	}
	
	public void setMove(){
		this.seMoveu = true;
	}
	
	public boolean getMove(){
		return this.seMoveu;
	}
	
}
