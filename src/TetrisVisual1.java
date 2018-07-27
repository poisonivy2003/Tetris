import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/* only used in two player mode */
public class TetrisVisual1 extends JPanel implements ActionListener {
	private Grid1 mG1;
	public int mSquareWidth;
	public int mSquareHeight;
	private Action1 mA1;

	
	public TetrisVisual1 () {
		mG1 = new Grid1(8, 15);
		mA1 = new Action1(mG1);
		addKeyListener(mA1);
		mSquareWidth = 40; /** change this line and the one below it to rescale **/
		mSquareHeight = 40;
		int time = 100; // in milli-seconds
		Timer clock = new Timer(time, this);
		clock.start();

		// By default JPanel is not mouse-focused
		// see:
		// https://stackoverflow.com/questions/11487369/jpanel-doesnt-response-to-keylistener-event
		this.setFocusable(true);
	}
	
	public void paintComponent(Graphics g) {
		int[][] matrix = mG1.getMesh(); // This array contains numbers which represent the color that the of each tile
		if (matrix == null) // If no matrix is created then the game is over and the score is displayed
		{
			int point = (mSquareWidth / 5) * 2;
			Font f1 = new Font("Sans", Font.BOLD, point);
			g.setFont(f1);
			g.setColor(Color.WHITE);
			g.fillRect(point * 3, point * 3, point * 10, point * 4);
			g.setColor(Color.BLACK);
			g.drawString("GAME OVER", mSquareWidth * 2, point * 4);
			g.drawString("Score: " + mG1.getScore(), mSquareWidth * 2, point * 6);
			return;
		}
		for (int row = 0; row < matrix.length; row++) { // These 2 loops increase the number of rows and columns until
														// they have reached the size of the desired matrix
			for (int column = 0; column < matrix[row].length; column++) {
				int cell = matrix[row][column]; // Checks each individual tile's number which symbolizes its color
				int x = column * mSquareWidth;
				int y = row * mSquareHeight;
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
					assert (false);
				}
				g.fillRect(x, y, mSquareWidth - 3, mSquareHeight - 3); // drawing the tile after its color has been set
			}

		}
		// Then the points are drawn at the bottom of the window under the grid
		int point = (mSquareWidth / 5) * 2;
		Font f1 = new Font("Ariel", Font.BOLD, point);
		g.setFont(f1);
		g.setColor(Color.WHITE);
		g.fillRect(0, (int) (mSquareHeight * 15.5), mSquareWidth * 6, mSquareHeight * 1);
		g.setColor(Color.BLACK);
		g.drawString("" + mG1.getScore(), mSquareWidth * 3, mSquareHeight * 16);
	}
	
	public void actionPerformed(ActionEvent e) {
		repaint();
	} 
	
}
