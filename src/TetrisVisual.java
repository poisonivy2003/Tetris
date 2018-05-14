import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;




public class TetrisVisual extends JPanel implements ActionListener {
	///zzz//private Blocks mBlock;
	private Grid mG;
	private int mSquareWidth;
	private int mSquareHeight;
	//private int[][] cellI
	Action mA;
	//zzz//public static int time;
	
	public TetrisVisual() {
		//zzz//mBlock = Blocks.chooseBlock();
		mG = new Grid(6, 15);
		mA  = new Action(mG);
		addKeyListener(mA);
		mSquareWidth = 50;
		mSquareHeight = 50;
		int time = 10;  // in milli-seconds
		Timer clock = new Timer(time, this);
		clock.start();

		// By default JPanel is not mouse-focused
		// see: https://stackoverflow.com/questions/11487369/jpanel-doesnt-response-to-keylistener-event
		this.setFocusable(true);
	}
	
	public void paintComponent (Graphics g)
	{
		int[][] matrix = mG.getMesh();
		if (matrix == null)
		{
			g.drawString("GAME OVER", 100, 100);
			return;
		}
		for (int row=0; row<matrix.length; row++) {
			for (int column=0; column<matrix[row].length; column++) {
				int cell = matrix[row][column];
				int x = column*mSquareWidth;
				int y = row*mSquareHeight;
				if (cell == Blocks.BLOCK_NONE) {
				    g.setColor(Color.GRAY);
				} else if (cell == Blocks.BLOCK_I) {
					g.setColor(Color.CYAN);
				} else if (cell == Blocks.BLOCK_J) {
					g.setColor(Color.BLUE);
				} else if (cell == Blocks.BLOCK_L) {
					g.setColor(Color.BLUE);
				} else if (cell == Blocks.BLOCK_S) {
					g.setColor(Color.GREEN);
				} else if (cell == Blocks.BLOCK_REVERSES) {
					g.setColor(Color.RED);
				} else if (cell == Blocks.BLOCK_SQUARE) {
					g.setColor(Color.YELLOW);
				} else if (cell == Blocks.BLOCK_T) {
					g.setColor(Color.MAGENTA);
				} else {
					assert(false);
				}
				g.fillRect(x, y, mSquareWidth-3, mSquareHeight-3);				
			}
					
		}
		g.setColor(Color.WHITE);
		g.fillRect(0, 50*16, 50*6, 50*2);
		g.setColor(Color.BLACK);
		g.drawString("" + mG.getScore(), 50*3, 50*17);
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
		window.setSize(50*6, 50*20);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}

}

		