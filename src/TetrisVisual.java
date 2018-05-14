import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;




public class TetrisVisual extends JPanel implements ActionListener {
	private Blocks mBlock;
	private Grid mG;
	private int mSquareWidth;
	private int mSquareHeight;
	Action mA;
	public static int time;
	
	public TetrisVisual() {
		mBlock = Blocks.chooseBlock();
		mA  = new Action();
		addKeyListener(mA);
		mG = new Grid(6, 15);
		mSquareWidth = 50;
		mSquareHeight = 50;
		time = 1000;
		Timer clock = new Timer(time, this);
		clock.start();

		// By default JPanel is not mouse-focused
		// see: https://stackoverflow.com/questions/11487369/jpanel-doesnt-response-to-keylistener-event
		this.setFocusable(true);
	}
	
	public void paintComponent (Graphics g)
	{
		int[][] matrix = mG.getMesh();
		for (int row=0; row<matrix.length; row++) {
			for (int column=0; column<matrix[row].length; column++) {
				int cell = matrix[row][column];
				int x = column*mSquareWidth;
				int y = row*mSquareHeight;
				if (cell == 0) {
				    g.setColor(Color.GRAY);
				} else {
					g.setColor(Color.RED);
				}
				g.fillRect(x, y, mSquareWidth-3, mSquareHeight-3);				
			}
					
		}
//		block.shape(g);
//		
//		block.turn(g);
//		repaint();
		//System.out.println("hello");
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		repaint();
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		TetrisVisual t = new TetrisVisual();
		window.getContentPane().add(t);
		window.setSize(50*6, 50*15);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}

}

		