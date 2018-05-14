import java.awt.Color;
import java.awt.Graphics;

public class IBlock extends Blocks{
	private int currentSide;
	private int blockLong, blockWide;
	
	public IBlock(int x, int y) {
		super(x, y);
		currentSide = 0; // 0 is flat, 1 is straight
	}

	public void shape(Graphics g) {
		if (currentSide == 0)
		{
			int add = 0;
			for (int i = 0; i < 4; i++)
			{
				g.setColor(Color.CYAN);
				g.fillRect(xCoord + add, yCoord, blockWidth, blockWidth);
				g.setColor(Color.BLACK);
				g.drawRect(xCoord + add, yCoord, blockWidth, blockWidth);
				add += blockWidth;
			}
		}
		else
		{
			int add = 0;
			for (int i = 0; i < 4; i++)
			{
				g.setColor(Color.CYAN);
				g.fillRect(xCoord, yCoord + add, blockWidth, blockWidth);
				g.setColor(Color.BLACK);
				g.drawRect(xCoord, yCoord + add, blockWidth, blockWidth);
				add += blockWidth;
			}
		}
	}
//
//	public void turnShape(Graphics g) {
//		if (currentSide == 0)
//		{
//			currentSide = 1;
//			shape(g);
//		}
//		else
//		{
//			currentSide = 0;
//			shape(g);
//		}
//	}

	public int getBlockLong() {
		if (currentSide == 0)
		{
			blockLong = 1;
		}
		else 
		{
			blockLong = 4;
		}
		return blockLong;
	}

	public int[][] getPositions() {
		int[][] blockPosition;
		if (currentSide == 0)
		{
			blockPosition = new int[][] {
				{0, 0}, {1, 0}, {2, 0}, {3, 0}
			};
		}
		else
		{
			blockPosition = new int[][] {
				{0, 0}, {0, 1}, {0, 2}, {0, 3}
			};
		}
		return blockPosition;
	}
	
	public void turn() {
		if (currentSide == 0)
		{
			currentSide = 1;
		}
		else
		{
			currentSide = 0;
		}
		getPositions();
	}

	public int getBlockWidth()
	{
		if (currentSide == 0)
		{
			blockWide = 4;
		}
		else 
		{
			blockWide = 1;
		}
		return blockWide;
	}
}
