package xadrez;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;


public class CanvasGame extends myCanvas {
	
	public static CanvasGame instance = null;
	
	Random rnd = new Random();

	boolean LEFT, RIGHT,UP, DOWN,A,W,S,D,SPACE,FIRE;
	boolean xeque = false;
	
	int MouseX,MouseY;
	
	Tabuleiro tabuleiro;
	
	Jogador jog1;
	Jogador jog2;
	Turno turno;
	
	public CanvasGame() {
		
		instance = this;
		
		jog1 = new Jogador("Bruno");
		jog2 = new Jogador("Xamps");
		
		tabuleiro  = new Tabuleiro(1);
		turno = new Turno(jog1, tabuleiro);
		//turno.setJogadorTurno(tabuleiro,jog1);
	}
	
	@Override
	public void SimulaSe(long diftime) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void DesenhaSe(Graphics2D dbg) {
		dbg.setColor(Color.white);
		dbg.fillRect (0, 0, GamePanel.PWIDTH, GamePanel.PHEIGHT);
		
		if(tabuleiro.xequeMate == 0){
		dbg.setColor(Color.red);
		
		dbg.drawString("Jogador Verde", 600, 20);
		dbg.drawString(jog1.nome, 600, 40);
		dbg.drawString("Jogador Preto", 600, 110);
		dbg.drawString(jog2.nome, 600, 130);
		
		dbg.setColor(Color.blue);
		
		if(turno.turno %2 == 1){
			dbg.drawString("Sua vez", 550, 20);
		}
		else{			
			dbg.drawString("Sua vez", 550, 110);
		}
		
		
		if(xeque){
			dbg.drawString(turno.jogador.nome + " está em xeque", 550, 420);
		}
		else{
			dbg.drawString(turno.jogador.nome + " não está em xeque", 550, 420);
		}
		
		for(int i = 0; i < 8; i++){
			
			dbg.drawString(""+i, 510, i*60 + 30);
			dbg.drawString(""+i, i*60 + 30, 500);
		}
		
		tabuleiro.DesenhaSe(dbg);
		}
		else if(tabuleiro.xequeMate == 1){
			dbg.setColor(Color.blue);
			dbg.drawString("Xeque mate!", 350, 220);
			dbg.drawString("O jogador " + jog2.nome + " venceu", 350, 240);
		}
		else{
			dbg.setColor(Color.blue);
			dbg.drawString("Xeque mate!", 350, 220);
			dbg.drawString("O jogador " + jog1.nome + " venceu", 350, 240);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_LEFT){
			LEFT = true;
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			RIGHT = true;
		}
		if(keyCode == KeyEvent.VK_UP){
			UP = true;
		}
		if(keyCode == KeyEvent.VK_DOWN){
			DOWN = true;
		}
		if(keyCode == KeyEvent.VK_A){
			A = true;
		}
		if(keyCode == KeyEvent.VK_D){
			D = true;
		}
		if(keyCode == KeyEvent.VK_W){
			W = true;
		}
		if(keyCode == KeyEvent.VK_S){
			S = true;
		}
		if(keyCode == KeyEvent.VK_SPACE){
			SPACE = true;
			if(turno.getSelecionada()){
				turno.setSelecionada(false);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_LEFT){
			LEFT = false;
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			RIGHT = false;
		}
		if(keyCode == KeyEvent.VK_UP){
			UP = false;
		}
		if(keyCode == KeyEvent.VK_DOWN){
			DOWN = false;
		}
		if(keyCode == KeyEvent.VK_A){
			A = false;
		}
		if(keyCode == KeyEvent.VK_D){
			D = false;
		}
		if(keyCode == KeyEvent.VK_W){
			W = false;
		}
		if(keyCode == KeyEvent.VK_S){
			S = false;
		}
		if(keyCode == KeyEvent.VK_SPACE){
			SPACE = false;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		MouseX = e.getX();
		MouseY = e.getY();
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		MouseX = e.getX();
		MouseY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		FIRE = false;
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		FIRE = true;
		if(e.getButton() == 1){
		
//			if(!turno.getSelecionada()){
//				turno.selecionaPeca(MouseX/60, MouseY/60);
//			}
			if(!turno.getSelecionada()){
				turno.selecionaPeca(MouseX/60, MouseY/60);
			}
			else{

				if(turno.validaJogada(MouseX/60, MouseY/60)){
					if(turno.jogada.tipoJogada == 1){						
						turno.movePecaSelecionada(MouseX/60, MouseY/60);
					}
					if(turno.jogada.tipoJogada == 3){
						turno.roque(MouseX/60, MouseY/60);
					}
					if(turno.jogada.tipoJogada == 2){
						turno.comePeca(MouseX/60, MouseY/60);
					}
				if(turno.turno%2==0){
					turno.setJogadorTurno(tabuleiro, jog1);
					xeque = turno.validaXeque(tabuleiro.getReiBranco());
				}
				else{
					turno.setJogadorTurno(tabuleiro, jog2);
					xeque = turno.validaXeque(tabuleiro.getReiPreto());
				}
				}
			}
		}
		if(e.getButton() == 3){
			if(turno.getSelecionada()){
				turno.setSelecionada(false);
			}
		}
	}
	
}
