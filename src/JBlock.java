import java.awt.Color;
import java.awt.Graphics;

public class JBlock extends Blocks{
	private int currentSide;
	private int blockLong, blockWide;
	
	public JBlock(int x, int y) {
		super(x, y);
		currentSide = 4; // 0 is j, 1 is 90 clockwise turn, and so on till 3 then back to 0
	}

	public int getBlockLong() {
		if (currentSide == 1 || currentSide == 3)
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
				{1, 0}, {1, 1}, {1, 2}, {0, 2}
			};
		}
		else if (currentSide == 1)
		{
			blockPosition = new int[][] {
				{0, 0}, {0, 1}, {1, 1}, {2, 1}
			};
		}
		else if (currentSide == 2)
		{
			blockPosition = new int[][] {
				{0, 0}, {0, 1}, {0, 2}, {1, 0}
			};
		}
		else
		{
			blockPosition = new int[][] {
				{2, 0}, {2, 1}, {1, 0}, {0, 0}
			};
		}
		return blockPosition;
	}
	
	public void turn() {
		if (currentSide == 0)
		{
			currentSide = 1;
		}
		else if (currentSide == 1)
		{
			currentSide = 2;
		}
		else if (currentSide == 2)
		{
			currentSide = 3;
		}
		else
		{
			currentSide = 0;
		}
		getPositions();
	}

	public int getBlockWidth()
	{
		if (currentSide == 1)
		{
			blockWide = 3;
		}
		else if (currentSide == 0 || currentSide == 2)
		{
			blockWide = 2;
		}
		else
		{
			blockWide = 3;
		}
		System.out.println(blockWide);
		return blockWide;
	}

	public int getBlockType() {
		return BLOCK_J;
	}
}
