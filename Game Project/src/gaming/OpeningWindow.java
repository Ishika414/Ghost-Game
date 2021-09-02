
/*
Dragon Slayer by 魔界Symphony | https://soundcloud.com/makai-symphony
Music promoted by https://www.chosic.com/
Creative Commons Attribution-ShareAlike 3.0 Unported
https://creativecommons.org/licenses/by-sa/3.0/
*/


package gaming;

import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OpeningWindow extends JPanel {
	
	JFrame window = new JFrame(); //to create a main window for gui
	
	OpeningWindow() {
		
		window.add(this);
		
		
		try {
		File sound = new File("Audio//start.wav");
		AudioInputStream ais = AudioSystem.getAudioInputStream(sound); // to add audio to the window
		Clip clip = AudioSystem.getClip();
		clip.open(ais); 
		clip.start();
		
		}
		catch(Exception e) {System.out.println(e);
		
		}
		window.setLocation(500,100); //display location of the window
		window.setUndecorated(true); //remove title bar
		window.setSize(1200,675);   //to set size of the window
		
		window.setVisible(true);  //to make the window visible
		
		try {
			Thread.sleep(5000); //to display the window for 5 seconds
			window.dispose(); //to close window
			Menu m = new Menu(); //create an object of class menu
	}
	catch(Exception e){
		System.out.println(e);
	}
		
	}
	public void paint(Graphics g) {
		
		ImageIcon background = new ImageIcon("Pics//main.jpeg"); //Image background inserted
		
		g.drawImage(background.getImage(),0,0,null); //to set bounds of the image
	}

}
