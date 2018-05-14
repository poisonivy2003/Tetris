import java.awt.Color;
import java.awt.Graphics;

public class ReverseSBlock extends Blocks {
	private int currentSide;
	private int blockLong, blockWide;

	public ReverseSBlock(int x, int y) {
		super(x, y);
		currentSide = 0; // 0 is straight, 1 is sideways
	}

	public void shape(Graphics g) {
		assert (false);
	}

	public int getBlockLong() {
		if (currentSide == 1) {
			blockLong = 2;
		} else {
			blockLong = 3;
		}
		return blockLong;
	}

	public int[][] getPositions() {
		int[][] blockPosition;
		if (currentSide == 0) {
			blockPosition = new int[][] { { 1, 0 }, { 1, 1 }, { 0, 1 }, { 0, 2 } };
		} else {
			blockPosition = new int[][] { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } };
		}
		return blockPosition;
	}

	public void turn() {
		if (currentSide == 0) {
			currentSide = 1;
		} else {
			currentSide = 0;
		}
		getPositions();
	}

	public int getBlockWidth() {
		if (currentSide == 1) {
			blockWide = 3;
		} else {
			blockWide = 2;
		}
		return blockWide;
	}

	public int getBlockWide() {
		if (currentSide == 1) {
			blockWide = 3;
		} else {
			blockWide = 2;
		}
		return blockWide;
	}

	public int getBlockType() {
		return BLOCK_REVERSES;
	}
}
