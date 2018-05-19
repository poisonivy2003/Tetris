import java.awt.Graphics;
import java.awt.Color;

public class TBlock extends Blocks {
	private int currentSide; //which side the block is on (0-3 in this case)
	private int blockLong, blockWide; //how many squares long/wide the block is

	public TBlock(int x, int y) {
		super(x, y);
		currentSide = 0; // 0 is t, 1 is t turned 90 counterclockwise, and so on
	}

	// Returns how long (in squares) the block is
	public int getBlockLong() {
		if (currentSide == 1 || currentSide == 3) {
			blockLong = 3;
		} else {
			blockLong = 2;
		}
		return blockLong;
	}

	// Turns the block
	public void turn() {
		if (currentSide == 0) {
			currentSide = 1;
		} else if (currentSide == 1) {
			currentSide = 2;
		} else if (currentSide == 2) {
			currentSide = 3;
		} else if (currentSide == 3) {
			currentSide = 0;
		}
		getPositions();
	}

	//Returns the position of each square fitted together to make a block at each of the 4 different sides
	public int[][] getPositions() {
		int[][] blockPosition;
		if (currentSide == 0) {
			blockPosition = new int[][] { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, 1 } };
		} else if (currentSide == 1) {
			blockPosition = new int[][] { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 0, 2 } };
		} else if (currentSide == 2) {
			blockPosition = new int[][] { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 2, 1 } };
		} else {
			blockPosition = new int[][] { { 1, 0 }, { 1, 1 }, { 1, 2 }, { 0, 1 } };
		}
		return blockPosition;
	}

	//Returns how wide(in squares) the block is
	public int getBlockWidth() {
		if (currentSide == 0 || currentSide == 2) {
			blockWide = 3;
		} else if (currentSide == 1 || currentSide == 3) {
			blockWide = 2;
		}
		return blockWide;
	}

	//Returns which type of block this class is
	public int getBlockType() {
		return BLOCK_T;
	}

}