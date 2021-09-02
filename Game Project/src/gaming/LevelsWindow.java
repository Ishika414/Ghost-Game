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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class LevelsWindow extends JPanel implements ActionListener,KeyListener{
	
	
	JFrame window = new JFrame();
	
	String[] s = {"Ghost-Level","Evil-Level","Dragon-Level"};
	
	JComboBox nameOfLevels = new JComboBox(s);
	
	JButton enterButton = new JButton();
	JButton backButton = new JButton();
	
	Font customFont = new Font("Bold",Font.BOLD,30);
	Font comboFont = new Font("Italic",Font.ITALIC,25);
	
	LevelsWindow(){
		
		
		window.add(this);
		
		nameOfLevels.setFont(comboFont);
		nameOfLevels.setForeground(Color.DARK_GRAY);
		nameOfLevels.setBackground(Color.BLACK);
		nameOfLevels.setOpaque(true);

		window.add(nameOfLevels,BorderLayout.PAGE_START);
		backButton.setText("BACK");
		backButton.setFont(customFont);
		backButton.addKeyListener(this);
		backButton.addActionListener(this);
		backButton.setForeground(Color.BLACK);
		backButton.setBackground(Color.BLACK);
		backButton.setOpaque(true);
		
		window.add(backButton,BorderLayout.PAGE_END);
		
		
		enterButton.setIcon(new ImageIcon("Pics//Dragon.jpeg"));
		enterButton.setText("Click To Select");
		enterButton.addKeyListener(this);
		enterButton.addActionListener(this);
		window.add(enterButton,BorderLayout.CENTER);
		
		
		
		window.setUndecorated(true);
		window.setSize(1200,650);
		window.setLocation(300,100);
		window.setVisible(true);
		
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent kp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent kp) {
if(kp.getKeyCode()==KeyEvent.VK_ESCAPE) {
			
			window.dispose();
			Menu m =new Menu();
		}

else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==0) {
		
		JOptionPane.showMessageDialog(null,"Ghost Level Not Ready!");
	}

else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==1) {
		
		JOptionPane.showMessageDialog(null,"Evil Level Not Ready!");
	}

else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==2)
	
	JOptionPane.showMessageDialog(null,"Dragon Level Not Ready!");
}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==backButton) {
			
			window.dispose();
			Menu m =new Menu();
		}
		
		else if(ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==0) {
			
			GhostLevel g1 = new GhostLevel();
		}
		
else if(ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==1) {
			
			JOptionPane.showMessageDialog(null,"Evil Level Under Construction");
		}
		
else if(ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==2) {
	
	JOptionPane.showMessageDialog(null,"Dragon Level Under Construction");
}
		
		
		
		
		
	}
	
	
	
	
	

}
