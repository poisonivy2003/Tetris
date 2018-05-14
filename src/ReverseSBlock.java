import java.awt.Color;
import java.awt.Graphics;

public class ReverseSBlock extends Blocks{
	private int currentSide;
	private int blockLong;

	public ReverseSBlock(int x, int y) {
		super(x, y);
		currentSide = 0; // 0 is j + (flipped l), 1 is 90 clockwise turn, and so on till 3 then back to 0
		getBlockLong();
	}

	public void shape(Graphics g) {
		if (currentSide == 0) //j-shape
		{
			int addDown = 0, addAcross = blockWidth;
			for (int i = 0; i < 2; i++)
			{
				g.setColor(Color.RED);
				g.fillRect(xCoord, yCoord + addDown, blockWidth, blockWidth);
				g.setColor(Color.BLACK);
				g.drawRect(xCoord, yCoord + addDown, blockWidth, blockWidth);
				addDown += blockWidth;
			}
			for (int i = 0; i < 2; i++)
			{
				g.setColor(Color.RED);
				g.fillRect(xCoord - addAcross, yCoord + (addDown - blockWidth), blockWidth, blockWidth);
				g.setColor(Color.BLACK);
				g.drawRect(xCoord - addAcross, yCoord + (addDown - blockWidth), blockWidth, blockWidth);
				addDown += blockWidth;
			}
		}
		else
		{
			int addDown = blockWidth, addAcross = 0;
			for (int i = 0; i < 2; i++)
			{
				g.setColor(Color.RED);
				g.fillRect(xCoord + addAcross, yCoord + addDown, blockWidth, blockWidth);
				g.fillRect(xCoord - addAcross, yCoord, blockWidth, blockWidth);
				g.setColor(Color.BLACK);
				g.drawRect(xCoord + addAcross, yCoord + addDown, blockWidth, blockWidth);
				g.drawRect(xCoord - addAcross, yCoord, blockWidth, blockWidth);
				addAcross += blockWidth;
			}
		}
	}

	public void turn(Graphics g) {
		if (currentSide == 0)
		{
			currentSide = 1;
			shape(g);
		}
		else
		{
			currentSide = 0;
			shape(g);
		}
	}

	public int getBlockLong() {
		if (currentSide == 1)
		{
			blockLong = 2;
		}
		else 
		{
			blockLong = 3;
		}
		return blockLong;
	}
	
	public int[][] getPositions() {
		int[][] blockPosition;
		if (currentSide == 0)
		{
			blockPosition = new int[][] {
				{0, 0}, {0, 1}, {-1, 1}, {-1, 2}
			};
		}
		else
		{
			blockPosition = new int[][] {
				{0, 0}, {0, 1}, {1, 0}, {-1, 1}
			};
		}
		return blockPosition;
	}

}

