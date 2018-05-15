import java.awt.Color;
import java.awt.Graphics;

public class SquareBlock extends Blocks{
	private int blockLong, blockWide;
	
	public SquareBlock(int x, int y) {
		super(x, y);
	}

	public int getBlockLong() {
		return 2;
	}

	public int[][] getPositions() {
		int[][] blockPosition;
		blockPosition = new int[][] {
			{0, 0}, {0, 1}, {1, 0}, {1, 1}
		};
		return blockPosition;	
	}
	
	public void turn() {
		getPositions();
	}
	
	public int getBlockWidth() {
		return 2;
	}

	public int getBlockType() {
		return BLOCK_SQUARE;
	}
}
