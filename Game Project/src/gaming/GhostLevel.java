package gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GhostLevel  extends JPanel implements KeyListener {
	
	JFrame window = new JFrame("GhostLevel");
	Shooter shooter = new Shooter(570,800,"Pics//machine_gun.png");
	Ghost[][] ghost = new Ghost[2][18]; //to define rows of skull and how many skulls in a row resp.
	int xAxis = 25;
	int yAxis = 10;
	
	Bullet[] bullets = new Bullet[1000];
	int count = 0;
	Dropper dropper = new Dropper(this,ghost);
	private Boolean fail = false;
	
	GhostLevel(){
		
		this.setFocusable(true);
		this.addKeyListener(this);
		
		
		window.add(this);
		
		
		for(int i = 0;i<ghost.length;i++) {
			for(int j = 0;j<ghost[i].length;j++) {
				ghost[i][j] = new Ghost(xAxis,yAxis,"Pics//skull.png");
				xAxis += 90;
			
			}
			yAxis += 90;
			xAxis = 60;
		}
		
		
		dropper.start();
		
		for(int i = 0; i<bullets.length;i++) {
			
			bullets[i] = new Bullet(570,970,"Pics//bullet.png");
			
			
			
		}
		window.setSize(1700,1000);
		window.setLocation(80,20);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
	
	
	public void paint(Graphics g) {
		
		ImageIcon bg = new ImageIcon("Pics//Dragonbg.jpeg");
		g.drawImage(bg.getImage(),0,0,null);
		
		
		shooter.drawShooter(g);
		for(int i =0;i<ghost.length;i++) {
			for(int j = 0;j<ghost[i].length;j++) {
				ghost[i][j].drawGhostFunction(g);
				
			}
			
			
		}
		
		for(int i = 0;i<bullets.length;i++) {
			
			bullets[i].drawBullet(g);
		}
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("",Font.BOLD,22));
		g.drawString("Score ="+fire.score, 00, 50);
		levelFailed();
		levelComplete(); //call method in main
		
	}
	
	public void levelComplete() {
		if(fire.score >= 10) {
			
			window.dispose();
			dropper.stop();
			JOptionPane.showMessageDialog(null, "Level Complete!");
		}
		
	}
	public void levelFailed() {
		
		for(int i = 0;i<ghost.length;i++)
		{
			
			for(int j = 0;j<ghost[i].length;j++) {
				
				if(ghost[i][j].getyAxis()>750) {
					
					fail = true;
					dropper.stop(); // to stop the thread from continuing after the game is over
					break;
				}
			}
		}
		 
		if (fail == true) // to make the game stop after the skull drop below a certain level
		{
			window.dispose(); // dispose game window after the skull drop y>750 
		
			JOptionPane.showMessageDialog(null, "Game Over!"); // dialog box
			
		}
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent kp) 
	{
     if(kp.getKeyCode()== KeyEvent.VK_RIGHT)	
        {
	
	      if(shooter.getxAxis()<1805) {
	    	  shooter.setxAxis(shooter.getxAxis()+5);
	    	  this.repaint();
	      }
         }
     else if (kp.getKeyCode()==KeyEvent.VK_LEFT) {
    	 
    	 if(shooter.getxAxis()>-2) {
    		 shooter.setxAxis(shooter.getxAxis()-5);
    		 
    	 }
    	 this.repaint();
     }
     else if (kp.getKeyCode()==KeyEvent.VK_SPACE) {
    	 
    	 try
    	 {
    		 File sound = new File("Audio//GunShot.wav");
    			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
    			Clip clip = AudioSystem.getClip();
    			clip.open(ais); 
    			clip.start();
    	 }
    	 catch(Exception e) {System.out.println(e);}
    
    	 fire f = new fire(bullets[count],this,ghost);
    	 bullets[count].setxAxis(shooter.getxAxis()+60);
    	 bullets[count].setyAxis(shooter.getyAxis()+10);
    	 f.start();
    	 count++;
    	 
     }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
