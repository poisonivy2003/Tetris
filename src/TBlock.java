import java.awt.Graphics;
import java.awt.Color;

public class TBlock extends Blocks {
	private int currentSide;
	private int blockLong, blockWide;

	public TBlock(int x, int y) {
		super(x, y);
		currentSide = 0; // 0 is flat, 1 is straight
	}

	

	public void turn(Graphics g) {
		if (currentSide == 0) {
			currentSide = 1;
			shape(g);
		} else if (currentSide == 1) {
			currentSide = 2;
			shape(g);
		} else if (currentSide == 2) {
			currentSide = 3;
			shape(g);
		} else if (currentSide == 3) {
			currentSide = 0;
			shape(g);
		}
	}

	public int getBlockLong() {
		if (currentSide == 1 || currentSide == 3) {
			blockLong = 3;
		} else {
			blockLong = 2;
		}
		return blockLong;
	}

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

	public int getBlockWide() {
		if (currentSide == 0 || currentSide == 2) {
			blockWide = 3;
		} else if (currentSide == 1 || currentSide == 3) {
			blockWide = 2;
		}
		return blockWide;
	}

	public int[][] getPositions() {
		int[][] blockPosition;
		if (currentSide == 0) {
			blockPosition = new int[][] { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, 1 } };
		} else if (currentSide == 1) {
			blockPosition = new int[][] { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, 1 } };
		} else if (currentSide == 2) {
			blockPosition = new int[][] { { 0, 1 }, { 1, 1 }, { 2, 1 }, { 1, 0 } };
		} else {
			blockPosition = new int[][] { { 1, 0 }, { 1, 1 }, { 1, 2 }, { 0, 1 } };
		}
		return blockPosition;
	}

	public int getBlockWidth() {
		if (currentSide == 0 || currentSide == 2) {
			blockWide = 3;
		} else if (currentSide == 1 || currentSide == 3) {
			blockWide = 2;
		}
		return blockWide;
	}

	public int getBlockType() {
		return BLOCK_T;
	}

	public void shape(Graphics g) {
		assert(false);
	}
}