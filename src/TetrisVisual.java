import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// This class creates a window and puts a Grid and Action object there to start the game.
public class TetrisVisual extends JPanel implements ActionListener {

	// fields
	private Grid mG;
	public int mSquareWidth;
	public int mSquareHeight;
	private Action mA;

	// constructor
	// The constructor initializes new Grid and Action objects, adds a keyListener
	// to get keyboard commands,
	// and sets the width and height of each square. Also, a timer is created to set
	// how fast
	public TetrisVisual() {
			mG = new Grid(8, 15);
			mA = new Action(mG);
			addKeyListener(mA);
			mSquareWidth = 40; /** change this line and the one below it to rescale **/
			mSquareHeight = 40;
			int time = 10; // in milli-seconds
			Timer clock = new Timer(time, this);
			clock.start();

			// By default JPanel is not mouse-focused
			// see:
			// https://stackoverflow.com/questions/11487369/jpanel-doesnt-response-to-keylistener-event
			this.setFocusable(true);
	}

	// Every 10 milliseconds the timer calls this method, which draws the grid of
	// tiles and sets each tile's color accordingly
	public void paintComponent(Graphics g) {
		int[][] matrix = mG.getMesh(); // This array contains numbers which represent the color that the of each tile
		if (matrix == null) // If no matrix is created then the game is over and the score is displayed
		{
			int point = (mSquareWidth / 5) * 2;
			Font f1 = new Font("Sans", Font.BOLD, point);
			g.setFont(f1);
			g.setColor(Color.WHITE);
			g.fillRect(point * 3, point * 3, point * 10, point * 4);
			g.setColor(Color.BLACK);
			g.drawString("GAME OVER", mSquareWidth * 2, point * 4);
			g.drawString("Score: " + mG.getScore(), mSquareWidth * 2, point * 6);
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
		g.drawString("" + mG.getScore(), mSquareWidth * 3, mSquareHeight * 16);

	}

	// Every 10 milliseconds the timer calls this method, and it repaints the entire
	// grid given the updated grid
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	// A window is created that has the width of the grid and is a bit longer than
	// the grid length
	public static void main(String[] args) {
//		JFrame window = new JFrame();
//		TetrisVisual t = new TetrisVisual();
//		window.getContentPane().add(t);
//		window.setSize(t.mSquareWidth * 8, t.mSquareHeight * 19);
//		window.setVisible(true);
//		window.setResizable(true);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
