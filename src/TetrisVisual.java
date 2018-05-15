import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;




public class TetrisVisual extends JPanel implements ActionListener {
	private Grid mG;
	private int mSquareWidth;
	private int mSquareHeight;
	Action mA;
	
	public TetrisVisual() {
		mG = new Grid(8, 15);
		mA  = new Action(mG);
		addKeyListener(mA);
		mSquareWidth = 50; /**change this line and the one below it to rescale**/
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
			int point = (mSquareWidth/5)*2;
			Font f1 = new Font("Sans", Font.BOLD, point);
			g.setFont(f1);
			g.setColor(Color.WHITE);
			g.fillRect(point * 3, point * 3, point * 10, point * 2);
			g.setColor(Color.BLACK);
			g.drawString("GAME OVER", mSquareWidth * 2, point * 4);
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
					g.setColor(Color.ORANGE);
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
		int point = (mSquareWidth/5)*2;
		Font f1 = new Font("Ariel", Font.BOLD, point);
		g.setFont(f1);
		g.setColor(Color.WHITE);
		g.fillRect(0, (int) (mSquareHeight*15.5), mSquareWidth*6, mSquareHeight*1);
		g.setColor(Color.BLACK);
		g.drawString("" + mG.getScore(), mSquareWidth*3, mSquareHeight*16);
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		repaint();
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		TetrisVisual t = new TetrisVisual();
		window.getContentPane().add(t);
		window.setSize(t.mSquareWidth*8, t.mSquareHeight*19);
		window.setVisible(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

		