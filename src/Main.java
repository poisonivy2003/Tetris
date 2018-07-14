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

public class Main implements ActionListener{
	private static ImageIcon picture;
	private JButton start, credits, instructions, quit;
	private JFrame window;
	
		// Creates the friendly window
		public Main ()
		{
			picture = new ImageIcon("Title.png");
			
			window = new JFrame("Welcome!");
			
			
			JPanel top = new JPanel();
			JLabel pic = new JLabel(picture);
			
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
			
			top.add(pic);
			
			start.setBackground(Color.GREEN);
			bottom.add(start);
			bottom.add(credits);
			bottom.add(instructions);
			bottom.add(quit);
			bottom.setBackground(Color.BLUE);
			
			window.getContentPane().add(top, BorderLayout.CENTER);
			window.getContentPane().add(bottom, BorderLayout.SOUTH);
			window.setSize(500, 430);
			window.setVisible(true);
			window.setResizable(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
		
		public static void main(String[] args) {
			Main program = new Main();
		}

		public void actionPerformed(ActionEvent e) {
			 JButton b = (JButton)e.getSource();
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
		}
		
}
