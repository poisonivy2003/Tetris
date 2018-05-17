import java.awt.Color;
import java.awt.Graphics;

public class LBlock extends Blocks {
	private int currentSide;
	private int blockLong, blockWide;

	public LBlock(int x, int y) {
		super(x, y);
		currentSide = 0; // 0 is flat, 1 is straight
	}

	public int getBlockLong() {
		if (currentSide == 1 || currentSide == 3) {
			blockLong = 2;
		} else {
			blockLong = 3;
		}
		return blockLong;
	}
	
	public int[][] getPositions() {
		int[][] blockPosition;
		if (currentSide == 0)
		{
			blockPosition = new int[][] {
				{0, 0}, {0, 1}, {0, 2}, {1, 2}
			};
		}
		else if (currentSide == 1)
		{
			blockPosition = new int[][] {
				{0, 0}, {0, 1}, {1, 0}, {2, 0}
			};
		}
		else if (currentSide == 2)
		{
			blockPosition = new int[][] {
				{0, 0}, {1, 0}, {1, 1}, {1, 2}
			};
		}
		else
		{
			blockPosition = new int[][] {
				{2, 0}, {2, 1}, {1, 1}, {0, 1}
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
	
	public int getBlockWidth() {
		if (currentSide == 1 || currentSide == 3) {
			blockWide = 3;
		} 
		else {
			blockWide = 2;
		}
		return blockWide;
	}

	public int getBlockType() {
		return BLOCK_L;
	}

}

