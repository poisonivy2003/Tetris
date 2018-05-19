import java.awt.Color;
import java.awt.Graphics;

public class ReverseSBlock extends Blocks {
	private int currentSide; //which side the block is on (0-1 in this case)
	private int blockLong, blockWide; //how many squares long/wide the block is

	public ReverseSBlock(int x, int y) {
		super(x, y);
		currentSide = 0; // 0 is straight, 1 is sideways
	}
	
	//Returns how long(in squares) the block is
	public int getBlockLong() {
		if (currentSide == 1) {
			blockLong = 2;
		} else {
			blockLong = 3;
		}
		return blockLong;
	}

	//Returns the position of each square fitted together to make a block at each of the 4 different sides
	public int[][] getPositions() {
		int[][] blockPosition;
		if (currentSide == 0) {
			blockPosition = new int[][] { { 1, 0 }, { 1, 1 }, { 0, 1 }, { 0, 2 } };
		} else {
			blockPosition = new int[][] { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } };
		}
		return blockPosition;
	}

	//Turns the block
	public void turn() {
		if (currentSide == 0) {
			currentSide = 1;
		} else {
			currentSide = 0;
		}
		getPositions();
	}

	//Returns how wide(in squares) the block is
	public int getBlockWidth() {
		if (currentSide == 1) {
			blockWide = 3;
		} else {
			blockWide = 2;
		}
		return blockWide;
	}

	//Returns which type of block this class is
	public int getBlockType() {
		return BLOCK_REVERSES;
	}
}
