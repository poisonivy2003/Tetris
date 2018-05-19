/*
 * Coded By: Ivy Chang
 * Completed: 5/11/2018
 * Revision Number: 3
 */

import java.awt.Color;
import java.awt.Graphics;

public class SquareBlock extends Blocks{
	//No fields used because this block looks the same, even when rotated
	
	public SquareBlock(int x, int y) {
		super(x, y);
	}

	//Returns how long(in squares) the block is
	public int getBlockLong() {
		return 2;
	}

	//Returns the position of each square fitted together to make a block at each of the 4 different sides
	public int[][] getPositions() {
		int[][] blockPosition;
		blockPosition = new int[][] {
			{0, 0}, {0, 1}, {1, 0}, {1, 1}
		};
		return blockPosition;	
	}
	
	//Gets this position (this doesn't turn because squares look the same no matter which way they are turned)
	public void turn() {
		getPositions();
	}
	
	//Returns how wide(in squares) the block is
	public int getBlockWidth() {
		return 2;
	}

	//Returns which type of block this class is
	public int getBlockType() {
		return BLOCK_SQUARE;
	}
}
