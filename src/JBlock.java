/*
 * Coded By: Ivy Chang
 * Completed: 5/17/2018
 * Revision Number: 16
 */

import java.awt.Color;
import java.awt.Graphics;

public class JBlock extends Blocks{
	private int currentSide; //which side the block is on (0-3 in this case)
	private int blockLong, blockWide; //how many squares long/wide the block is
	
	public JBlock(int x, int y) {
		super(x, y);
		currentSide = 0; // 0 is j, 1 is 90 clockwise turn, and so on till 3 then back to 0
	}

	//Returns how long(in squares) the block is
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
	
	//Returns the position of each square fitted together to make a block at each of the 4 different sides
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
	
	//Turns the block by flipping which side it is on
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
	
	//Returns how wide(in squares) the block is
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
		return blockWide;
	}

	//Returns which type of block this class is
	public int getBlockType() {
		return BLOCK_J;
	}
}
