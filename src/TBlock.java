import java.awt.Graphics;
import java.awt.Color;

public class TBlock extends Blocks {
	private int currentSide;
	private int blockLong, blockWide;

	public TBlock(int x, int y) {
		super(x, y);
		currentSide = 0; // 0 is flat, 1 is straight
	}

	public void shape(Graphics g) {
		if (currentSide == 0) {
			int add = 0;
			for (int i = 0; i < 3; i++) {
				g.setColor(Color.MAGENTA);
				g.fillRect(xCoord + add, yCoord, blockWidth, blockWidth);
				g.setColor(Color.BLACK);
				g.drawRect(xCoord + add, yCoord, blockWidth, blockWidth);
				add += blockWidth;
			}
			g.setColor(Color.MAGENTA);
			g.fillRect(xCoord + blockWidth, yCoord + blockWidth, blockWidth, blockWidth);
			g.setColor(Color.BLACK);
			g.drawRect(xCoord + blockWidth, yCoord + blockWidth, blockWidth, blockWidth);
		} else if (currentSide == 1) {
			int add = 0;
			for (int i = 0; i < 3; i++) {
				g.setColor(Color.MAGENTA);
				g.fillRect(xCoord, yCoord + add, blockWidth, blockWidth);
				g.setColor(Color.BLACK);
				g.drawRect(xCoord, yCoord + add, blockWidth, blockWidth);
				add += blockWidth;
			}
			g.setColor(Color.MAGENTA);
			g.fillRect(xCoord + blockWidth, yCoord + blockWidth, blockWidth, blockWidth);
			g.setColor(Color.BLACK);
			g.drawRect(xCoord + blockWidth, yCoord + blockWidth, blockWidth, blockWidth);
		} else if (currentSide == 2) {
			int add = 0;
			for (int i = 0; i < 3; i++) {
				g.setColor(Color.MAGENTA);
				g.fillRect(xCoord + add, yCoord + blockWidth, blockWidth, blockWidth);
				g.setColor(Color.BLACK);
				g.drawRect(xCoord + add, yCoord + blockWidth, blockWidth, blockWidth);
				add += blockWidth;
			}
			g.setColor(Color.MAGENTA);
			g.fillRect(xCoord + blockWidth, yCoord, blockWidth, blockWidth);
			g.setColor(Color.BLACK);
			g.drawRect(xCoord + blockWidth, yCoord, blockWidth, blockWidth);
		} else if (currentSide == 3) {
			int add = 0;
			for (int i = 0; i < 3; i++) {
				g.setColor(Color.MAGENTA);
				g.fillRect(xCoord + blockWidth, yCoord + add, blockWidth, blockWidth);
				g.setColor(Color.BLACK);
				add += blockWidth;
				g.drawRect(xCoord + blockWidth, yCoord + add, blockWidth, blockWidth);
			}
			g.setColor(Color.MAGENTA);
			g.fillRect(xCoord, yCoord + blockWidth, blockWidth, blockWidth);
			g.setColor(Color.BLACK);
			g.drawRect(xCoord, yCoord + blockWidth, blockWidth, blockWidth);
		}
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

	@Override
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

	@Override
	public int getBlockWide() {
		if (currentSide == 0 || currentSide == 2) {
			blockWide = 3;
		} else if (currentSide == 1 || currentSide == 3) {
			blockWide = 2;
		}
		return blockWide;
	}

	@Override
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

	@Override
	public int getBlockWidth() {
		if (currentSide == 0 || currentSide == 2) {
			blockWide = 3;
		} else if (currentSide == 1 || currentSide == 3) {
			blockWide = 2;
		}
		return blockWide;
	}

	@Override
	public int getBlockType() {
		// TODO Auto-generated method stub
		return BLOCK_T;
	}
}