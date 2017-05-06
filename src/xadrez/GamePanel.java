package xadrez;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.image.*;

import javax.imageio.ImageIO;


public class GamePanel extends JPanel implements Runnable
{
public static final int PWIDTH = 640;
public static final int PHEIGHT = 480;

public static GamePanel instance;

private Thread animator;
private boolean running = false;
private boolean gameOver = false; 

private BufferedImage dbImage;
private Graphics2D dbg;


public static int FPS,SFPS;
public static int fpscount;

public static myCanvas canvasAtivo = null;

public GamePanel()
{
	instance = this;
	

	setBackground(Color.white);
	setPreferredSize(new Dimension(PWIDTH,PHEIGHT));

	// create game components
	setFocusable(true);

	requestFocus(); // JPanel now receives key events
	
	if (dbImage == null){
		dbImage = new BufferedImage(PWIDTH, PHEIGHT,BufferedImage.TYPE_INT_ARGB);
		if (dbImage == null) {
			System.out.println("dbImage is null");
			return;
		}else{
			dbg = (Graphics2D)dbImage.getGraphics();
		}
	}	
	
	
	// Adiciona um Key Listner
	addKeyListener( new KeyAdapter() {
		public void keyPressed(KeyEvent e)
			{ 
				if(canvasAtivo!=null){
					canvasAtivo.keyPressed(e);
				}
			}
		@Override
			public void keyReleased(KeyEvent e ) {
				if(canvasAtivo!=null){
					canvasAtivo.keyReleased(e);
				}
			}
	});
	
	addMouseMotionListener(new MouseMotionListener() {
		
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			if(canvasAtivo!=null){
				canvasAtivo.mouseMoved(e);
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			if(canvasAtivo!=null){
				canvasAtivo.mouseDragged(e);
			}
		}
	});
	
	addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(canvasAtivo!=null){
				canvasAtivo.mouseReleased(e);
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if(canvasAtivo!=null){
				canvasAtivo.mousePressed(e);
			}
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	
	canvasAtivo = new CanvasGame();
	
} // end of GamePanel()

public void addNotify()
{
	super.addNotify(); // creates the peer
	startGame(); // start the thread
}

private void startGame()
// initialise and start the thread
{
	if (animator == null || !running) {
		animator = new Thread(this);
		animator.start();
	}
} // end of startGame()

public void stopGame()
// called by the user to stop execution
{ running = false; }


public void run()
/* Repeatedly update, render, sleep */
{
	running = true;
	
	long DifTime,TempoAnterior;
	
	int segundo = 0;
	DifTime = 0;
	TempoAnterior = System.currentTimeMillis();
	
	while(running) {
	
		gameUpdate(DifTime); // game state is updated
		gameRender(); // render to a buffer
		paintImmediately(0, 0, 640, 480); // paint with the buffer
	
		try {
			Thread.sleep(0); // sleep a bit
		}	
		catch(InterruptedException ex){}
		
		DifTime = System.currentTimeMillis() - TempoAnterior;
		TempoAnterior = System.currentTimeMillis();
		
		if(segundo!=((int)(TempoAnterior/1000))){
			FPS = SFPS;
			SFPS = 1;
			segundo = ((int)(TempoAnterior/1000));
		}else{
			SFPS++;
		}
	
	}
System.exit(0); // so enclosing JFrame/JApplet exits
} // end of run()

int timerfps = 0;

private void gameUpdate(long DiffTime)
{ 
	if(canvasAtivo!=null){
		canvasAtivo.SimulaSe(DiffTime);
	}
}

private void gameRender()
// draw the current frame to an image buffer
{
	if(canvasAtivo!=null){
		canvasAtivo.DesenhaSe(dbg);
	}		
}


public void paintComponent(Graphics g)
{
	super.paintComponent(g);
	if (dbImage != null)
		g.drawImage(dbImage, 0, 0, null);
}


public static void main(String args[])
{
	GamePanel ttPanel = new GamePanel();

  // create a JFrame to hold the timer test JPanel
  JFrame app = new JFrame("Swing Timer Test");
  app.getContentPane().add(ttPanel, BorderLayout.CENTER);
  app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  app.pack();
  app.setResizable(false);  
  app.setVisible(true);
} // end of main()

public static BufferedImage loadImage(String source){
	BufferedImage image = null;
	try {
		BufferedImage tmp = ImageIO.read( GamePanel.instance.getClass().getClassLoader().getResource(source) );
		image = new BufferedImage(tmp.getWidth(),tmp.getHeight(),BufferedImage.TYPE_INT_ARGB);
		image.getGraphics().drawImage(tmp,0,0,null);
		tmp = null;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return image;
}


public static void writeFile(File f, char c, boolean b){
	
	try( FileWriter fw = new FileWriter( f,b) ){
		  BufferedWriter bw = new BufferedWriter(fw);            
		  bw.newLine();
		  bw.write( "teste" );
		  bw.newLine();
		  bw.write( "teste2");
		  bw.flush(); 
		}catch(IOException ex){
		  ex.printStackTrace();
		}
	
}

public static void readFile(File f){
	try( FileReader fr = new FileReader(f)){
		  BufferedReader br = new BufferedReader(fr);
		  String content;
		  while( ( content = br.readLine() ) != null){
		    System.out.println( content );
		  }
		}catch(IOException ex){
		  ex.printStackTrace();
		}
}

} // end of GamePanel class

