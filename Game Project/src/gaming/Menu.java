package gaming;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener,KeyListener{

	JFrame window = new JFrame();
	JButton playButton = new JButton();
	JButton exitButton = new JButton();
	
	
	 Menu()
{
		 
		 this.setBackground(Color.WHITE);
		 this.setForeground(Color.WHITE);
		window.add(this);
		
		
		 playButton.setBackground(Color.WHITE); 
		 playButton.setIcon(new ImageIcon ("Pics//play1.png"));
		 playButton.addActionListener(this);
		 playButton.addKeyListener(this);
		 window.add(playButton,BorderLayout.PAGE_START);
		 playButton.setSize(100,100);


		 exitButton.setBackground(Color.WHITE); 
		 exitButton.setIcon(new ImageIcon ("Pics//exitButtonPic.png"));
		 exitButton.addActionListener(this);
		 exitButton.addKeyListener(this);
		 window.add(exitButton,BorderLayout.PAGE_END);
		 exitButton.setSize(100,100);
		 
		 
		
		 window.setLocation(500,100);
		 window.setUndecorated(true);
		 window.setSize(1000, 750);
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
		
	}
	
}
