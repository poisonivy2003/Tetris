import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main implements ActionListener{
	private static ImageIcon picture;
	private JButton start, credits, instructions, quit, mode, change;
	private String onep = "1 Player", twop = "2 Player", cm = onep;
	private JFrame window;
	
		// Creates the friendly window
		public Main ()
		{
			picture = new ImageIcon("Title.png");
			
			window = new JFrame("Welcome!");
			
			
			JPanel top = new JPanel();
			JLabel pic = new JLabel(picture);
			mode = new JButton("Mode");
			mode.addActionListener(this);
			
			JPanel bottom = new JPanel();
			start = new JButton("Start");
			start.addActionListener(this);
			credits = new JButton("Credits");
			credits.addActionListener(this);
			instructions = new JButton("Instructions");
			instructions.addActionListener(this);
			quit = new JButton("Quit");
			quit.addActionListener(this);
			
			top.setBackground(Color.BLACK);
			
			top.add(mode);
			top.add(pic);
			
			start.setBackground(Color.GREEN);
			bottom.add(start);
			bottom.add(credits);
			bottom.add(instructions);
			bottom.add(quit);
			bottom.setBackground(Color.BLUE);
			
			window.getContentPane().add(top, BorderLayout.CENTER);
			window.getContentPane().add(bottom, BorderLayout.SOUTH);
			window.setSize(500, 450);
			window.setVisible(true);
			window.setResizable(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
		
		public static void main(String[] args) {
			Main program = new Main();
		}

		public void actionPerformed(ActionEvent e) {
			 JButton b = (JButton)e.getSource();
			 JFrame w = new JFrame("Mode");
			 if (b == start)
			 {
				 window.setVisible(false);
				 JFrame window = new JFrame();
				 TetrisVisual t = new TetrisVisual();
				 window.getContentPane().add(t);
				 window.setSize(t.mSquareWidth * 8, t.mSquareHeight * 19);
				 window.setVisible(true);
				 window.setResizable(true);
				 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 }
			 else if (b == credits)
			 {
				 System.out.println("2");
			 }
			 else if (b == instructions)
			 {
				 System.out.println("2");
			 }
			 else if (b == quit)
			 {
				 window.setVisible(false);
			 }
			 else if (b == mode)
			 {
				 
				 JPanel top = new JPanel();
				 JTextField c = new JTextField("Current mode: " + cm);
				 
				 JPanel bottom = new JPanel();
				 change = new JButton("Change Mode");
				 change.addActionListener(this);
	
				 top.add(c);
				 bottom.add(change);
				 
				 w.getContentPane().add(top, BorderLayout.CENTER);
				 w.getContentPane().add(bottom, BorderLayout.SOUTH);
				 w.setLocation(150, 100);
				 w.setSize(200, 250);
				 w.setVisible(true);
				 w.setResizable(true);
			 }
			 else if (b == change)
			 {
				 changeMode();
			 }
		}
		
		private void changeMode()
		{
			if (cm == onep)
			{
				cm = twop;
			}
			else if (cm == twop)
			{
				cm = onep;
			}
		}
		
}
