package gaming;

public class Dropper extends Thread{
	
	GhostLevel g1;
	Ghost[][] ghost;
	
	Dropper(GhostLevel g1,Ghost[][] ghost)
	{
		this.ghost=ghost;
		this.g1=g1;
		
		
		
	}
	
	public void run() {
		
		while(ghost[0][0].getyAxis()<700) {
			
		
		for(int i = 0;i<ghost.length;i++) {
			
			for(int j = 0; j<ghost[i].length;j++) {
				
				ghost[i][j].setyAxis(ghost[i][j].getyAxis()+30);
				System.out.println(ghost[i][j].getyAxis());
			}
		}
		try{
			
			Thread.sleep(2000); //to control speed of skull dropping
			
			
		}catch(Exception e) {System.out.println(e);}
		
		
		g1.repaint();
	}

}
}
