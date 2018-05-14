import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

//Contains basic methods of blocks
public abstract class Blocks{

	//Fields:
	public static int xCoord, yCoord; //in terms of pixels
	public static int xPos, yPos; //in terms of blocks
	public static final int blockWidth = 20;
	public static final int BLOCK_NONE = 0;
	public static final int BLOCK_I = 1;
	public static final int BLOCK_J = 2;
	public static final int BLOCK_L = 3;
	public static final int BLOCK_S = 4;
	public static final int BLOCK_REVERSES = 5;
	public static final int BLOCK_SQUARE = 6;
	public static final int BLOCK_T = 7;

	//Constructors:
	public Blocks(int x, int y) //starting in the middle of the screen
	{
		xCoord = x;
		yCoord = y;
		xPos = xCoord/blockWidth;
		yPos = yCoord/blockWidth;
	}
	
	//Abstract methods:
	public abstract void shape(Graphics g);
	public abstract void turn(Graphics g);
	public abstract int getBlockLong();
	public abstract int getBlockWide();
	public abstract int[][] getPositions();
	public abstract int getBlockType();
	
	//Non-abstract methods
//	public static int getX()
//	{
//		return xCoord;
//	}
//	
//	public static int getY()
//	{
//		return yCoord;
//	}
	
	public static int getXPos()
	{
		return xPos;
	}
	
	public static int getYPos()
	{
		return yPos;
	}
	
	public static void setXPos(int x)
	{
		xPos = x;	
	}
	
	public static void setYPos(int y)
	{
		yPos = y;
	}
	
//	public static void setX(int x)
//	{
//		xCoord = x;
//	}
//	
//	public static void setY(int y)
//	{
//		yCoord = y;
//	}

//	private void chooseBlock()
//	{
//		choose = (int) (Math.random() * 7);
//		switch (choose)
//		{
//		case 1: //Iblock
//			IBlock i = new IBlock(xCoord, yCoord);
//		case 2: 
//			//
//		case 3:
//			//
//		case 4:
//			//
//		case 5:
//			JBlock j = new JBlock(xCoord, yCoord);
//		case 6:
//			//
//		case 7:
//			//
//		}
//	}
}
