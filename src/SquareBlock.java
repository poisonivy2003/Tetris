import java.awt.Color;
import java.awt.Graphics;

public class SquareBlock extends Blocks{
	private int blockLong;
	
	public SquareBlock(int x, int y) {
		super(x, y);
	}

	public void shape(Graphics g) {
		int addDown = blockWidth, addAcross = 0;
		for (int i = 0; i < 2; i++)
		{
			g.setColor(Color.YELLOW);
			g.fillRect(xCoord + addAcross, yCoord, blockWidth, blockWidth);
			g.setColor(Color.BLACK);
			g.drawRect(xCoord + addAcross, yCoord, blockWidth, blockWidth);
			addAcross += blockWidth;
		}
		addAcross = 0; //reset values
		for (int i = 0; i < 2; i++)
		{
			g.setColor(Color.YELLOW);
			g.fillRect(xCoord + addAcross, yCoord + addDown, blockWidth, blockWidth);
			g.setColor(Color.BLACK);
			g.drawRect(xCoord + addAcross, yCoord + addDown, blockWidth, blockWidth);
			addAcross += blockWidth;
		}
		
	}

	public void turn(Graphics g) {
		shape(g);
	}

	public int getBlockLong() {
		return 2;
	}

	public int[][] getPositions() {
		int[][] blockPosition;
		blockPosition = new int[][] {
			{0, 0}, {0, 1}, {1, 0}, {1, 1}
		};
		return blockPosition;	
	}
}
