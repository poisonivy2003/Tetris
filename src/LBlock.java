import java.awt.Color;
import java.awt.Graphics;

public class LBlock extends Blocks {
	private int currentSide;
	private int blockLong, blockWide;

	public LBlock(int x, int y) {
		super(x, y);
		currentSide = 0; // 0 is flat, 1 is straight
	}

	/*** SHAPE IS MESSED UP! Look @ getPositions for correct shape!***/
	public void shape(Graphics g) {
		g.setColor(Color.ORANGE);
		if (currentSide == 0) {
			int add = 0;
			for (int i = 0; i < 3; i++) {
				g.drawRect(xCoord, yCoord + add, blockWidth, blockWidth);
				add += blockWidth;
			}
			g.drawRect(xCoord + blockWidth, yCoord, blockWidth, blockWidth);
		} else if (currentSide == 1) {
			int add = 0;
			for (int i = 0; i < 3; i++) {
				g.drawRect(xCoord + add, yCoord, blockWidth, blockWidth);
				add += blockWidth;
			}
			g.drawRect(xCoord, yCoord + blockWidth, blockWidth, blockWidth);
		} else if (currentSide == 2) {
			int add = 0;
			for (int i = 0; i < 3; i++) {
				g.drawRect(xCoord + blockWidth, yCoord + add, blockWidth, blockWidth);
				add += blockWidth;
			}
			g.drawRect(xCoord, yCoord, blockWidth, blockWidth);
		} else if (currentSide == 3) {
			int add = 0;
			for (int i = 0; i < 3; i++) {
				g.drawRect(xCoord + add, yCoord + blockWidth, blockWidth, blockWidth);
				add += blockWidth;
			}
			g.drawRect(xCoord + 2 * blockWidth, yCoord, blockWidth, blockWidth);
		}
	}

//	public void turn(Graphics g) {
//		if (currentSide == 0) {
//			currentSide = 1;
//			shape(g);
//		} else if (currentSide == 1) {
//			currentSide = 2;
//			shape(g);
//		}
//		else if (currentSide == 2) {
//			currentSide = 3;
//			shape(g);
//		}
//		else if (currentSide == 3) {
//			currentSide = 0;
//			shape(g);
//		}
//	}

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
				{0, 0}, {0, 1}, {-1, 1}, {-2, 1}
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
		return blockLong;
	}

	@Override
	public int getBlockWide() {
		if (currentSide == 1 || currentSide == 3) {
			blockWide = 3;
		} 
		else {
			blockWide = 2;
		}
		return blockLong;

	}

	@Override
	public int getBlockType() {
		// TODO Auto-generated method stub
		return BLOCK_L;
	}

}

