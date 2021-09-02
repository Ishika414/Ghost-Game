package gaming;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener,KeyListener{

	JFrame window = new JFrame();
	JButton playButton = new JButton();  // to create a new button
	JButton exitButton = new JButton();
	JLabel infoLabel = new JLabel();  // to add button label
	JLabel imageLabel = new JLabel();
	JButton bgButton = new JButton();
	
	Font custom = new Font("Italic",Font.BOLD,30); // to create a new font
	 Menu()
{
		 
		 this.setBackground(Color.DARK_GRAY);
		 this.setForeground(Color.DARK_GRAY);
		window.add(this);
		
		
		 playButton.setBackground(Color.DARK_GRAY); 
		 playButton.setIcon(new ImageIcon ("Pics//play1.png"));
		 playButton.addActionListener(this);  //To specify the action
		 playButton.addKeyListener(this);   // To specify the keys for the action required
		 playButton.setOpaque(true);      // to display the background color set for this button
		 window.add(playButton,BorderLayout.PAGE_START); //to set the location of the button on the window
		 playButton.setSize(100,100);


		 exitButton.setBackground(Color.DARK_GRAY); 
		 exitButton.setIcon(new ImageIcon ("Pics//exitButtonPic.png"));
		 exitButton.addActionListener(this);
		 exitButton.addKeyListener(this);
		 exitButton.setOpaque(true);
		 window.add(exitButton,BorderLayout.PAGE_END);
		 exitButton.setSize(100,100);
		 
		 bgButton.setBackground(Color.DARK_GRAY);
		 bgButton.setIcon(new ImageIcon ("Pics//bg.png"));
		 bgButton.addActionListener(this);
		 bgButton.addKeyListener(this);
		 bgButton.setOpaque(true);
		 window.add(bgButton,BorderLayout.WEST);
		
		 infoLabel.setText("PRESS 'S' TO SHOOT!"); 
		 infoLabel.setFont(custom);
		 infoLabel.setBackground(Color.DARK_GRAY);
		 infoLabel.setForeground(Color.red);
		 window.add(infoLabel,BorderLayout.EAST);
		 
		 imageLabel.setBackground(Color.DARK_GRAY);
		 imageLabel.setIcon(new ImageIcon("Pics//MenuImage.jpeg"));
		 imageLabel.setOpaque(true);
		 window.add(imageLabel,BorderLayout.CENTER);
		 
		 
		 window.setLocation(300,100);
		 window.setUndecorated(true);
		 window.setSize(1500, 950);
		 window.setVisible(true);
}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent kp) {
		
if(kp.getKeyCode()== KeyEvent.VK_ESCAPE) {
	
	window.dispose();
}

else if(kp.getKeyCode()==KeyEvent.VK_ENTER) {
	
	
	window.dispose();
	LevelsWindow lw = new LevelsWindow();
}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == exitButton) {
			
			window.dispose();
		}
		
		
		else if(ae.getSource()==playButton) {
			
			
			window.dispose();
			LevelsWindow lw = new LevelsWindow();
	}
	
}
}