package xadrez;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Peca {

	int tipo;
	int cor;
	boolean seMoveu = false;
	BufferedImage imagem;

	public Peca(int tipo, int cor, BufferedImage imagem){
		this.tipo = tipo;
		this.cor = cor;
		this.imagem = imagem;
	}
	
	public void DesenhaSe(Graphics2D dbg, int x, int y){
		dbg.drawImage(imagem, x*60 +10, y*60 + 10, 40, 40, null);		
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
