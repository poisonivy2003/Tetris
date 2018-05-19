import java.awt.Color;
import java.awt.Graphics;

public class IBlock extends Blocks{
	private int currentSide; //which side the block is on (0-1 in this case)
	private int blockLong, blockWide; //how many squares long/wide the block is
	
	public IBlock(int x, int y) {
		super(x, y);
		currentSide = 0; // 0 is flat, 1 is straight
	}

	//Returns how long(in squares) the block is
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
	
	//Returns which type of block this class is
	public int getBlockType() {
		return BLOCK_I;
	}
	
	//Returns the position of each square fitted together to make a block at each of the 4 different sides
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
	
	//Turns the block
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

	//Returns how wide(in squares) the block is
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
