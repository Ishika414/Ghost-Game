package gaming;

import java.awt.Rectangle;

public class fire extends Thread{
	
	Bullet bullet;
	
	GhostLevel g1;
	Ghost[][] ghost;
	
	public static int score = 0;
	
	 fire (Bullet bullet,GhostLevel g1,Ghost[][] ghost){
		this.bullet=bullet;
		this.g1=g1;
		this.ghost=ghost;
		
	}
	
	@Override	
	public void run() {
		
		while (bullet.getyAxis()>-100) {
			bullet.setyAxis(bullet.getyAxis()-10);
			checkCollision();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}
			g1.repaint();
		}
		
	}
public void checkCollision() {
	Rectangle bulletRect = new Rectangle(bullet.getxAxis(),bullet.getyAxis(),13,40);
	
	for(int i = 0;i<ghost.length;i++) {
		
		for(int j = 0;j<ghost[i].length;j++) {
			
			Rectangle ghostRect = new Rectangle(ghost[i][j].getxAxis(),ghost[i][j].getyAxis(),25,25);
			if(bulletRect.intersects(ghostRect)) {
				ghost[i][j].setxAxis(5000000);
				bullet.setxAxis(-50000);
				score++;
			}
		}
	}
}
}
