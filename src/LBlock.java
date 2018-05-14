//import java.awt.Color;
//import java.awt.Graphics;
//
//public class LBlock extends Blocks {
//	private int currentSide;
//	private int blockLong;
//
//	public LBlock(int x, int y) {
//		super(x, y);
//		currentSide = 0; // 0 is flat, 1 is straight
//	}
//
//	public void shape(Graphics g) {
//		g.setColor(Color.ORANGE);
//		if (currentSide == 0) {
//			int add = 0;
//			for (int i = 0; i < 3; i++) {
//				g.drawRect(xCoord, yCoord + add, blockWidth, blockWidth);
//				add += blockWidth;
//			}
//			g.drawRect(xCoord + blockWidth, yCoord, blockWidth, blockWidth);
//		} else if (currentSide == 1) {
//			int add = 0;
//			for (int i = 0; i < 3; i++) {
//				g.drawRect(xCoord + add, yCoord, blockWidth, blockWidth);
//				add += blockWidth;
//			}
//			g.drawRect(xCoord, yCoord + blockWidth, blockWidth, blockWidth);
//		} else if (currentSide == 2) {
//			int add = 0;
//			for (int i = 0; i < 3; i++) {
//				g.drawRect(xCoord + blockWidth, yCoord + add, blockWidth, blockWidth);
//				add += blockWidth;
//			}
//			g.drawRect(xCoord, yCoord, blockWidth, blockWidth);
//		} else if (currentSide == 3) {
//			int add = 0;
//			for (int i = 0; i < 3; i++) {
//				g.drawRect(xCoord + add, yCoord + blockWidth, blockWidth, blockWidth);
//				add += blockWidth;
//			}
//			g.drawRect(xCoord + 2 * blockWidth, yCoord, blockWidth, blockWidth);
//		}
//	}
//
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
//
//	public int getBlockLong() {
//		if (currentSide == 1 || currentSide == 3) {
//			blockLong = 2;
//		} else {
//			blockLong = 3;
//		}
//		return blockLong;
//	}
//}
//
