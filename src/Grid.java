
public class Grid {
	private boolean mIsFilled; // true if the entire block is filled
	private boolean mIsGameOver;
	private int mxPos, myPos; // how many blocks down and right the lock is
	public static int mScore; // points
	Blocks mThisBlock; // block passed in
	private int[][] mBackGrid; // holds a number of points that represent the total amount of blocks to fill
								// the grid( 0 = empty, 1 = full)
	private int mHeight;
	private int mWidth;

	public Grid(int width, int height) {
		createNewBlock();
		mHeight = height;
		mWidth = width;
		mBackGrid = new int[height][width];
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				mBackGrid[i][j] = Blocks.BLOCK_NONE; // looping through array and setting each column(height) and row(width) to zero
			}
		}
		mIsGameOver = false;
	}

	public void tryClearRows() {
		for (int row = 0; row < mBackGrid.length; ++row) {
			if (isFilled(row) == true) // checks if this current row is filled
			{
				for (int i = row; i > 0; --i) // starts at the filled row
				{
					for (int p = 0; p < mBackGrid[row].length; ++p) { // goes down the row, replacing every value with
																		// the one above it
						mBackGrid[i][p] = mBackGrid[i - 1][p];
					}

				}
				for (int p = 0; p < mBackGrid[0].length; ++p) { // goes down 0th row, replacing every value with the one
																// above it
					mBackGrid[0][p] = Blocks.BLOCK_NONE;
				}
			}
		}
	}

	public boolean checkOverlap() {
		// updates the original grid, ("background")
		if (mThisBlock == null) {
			return false;
		}
		int[][] blockPos = mThisBlock.getPositions();
		mxPos = mThisBlock.getXPos();
		myPos = mThisBlock.getYPos();
		for (int i = 0; i < blockPos.length; ++i) { // changes 0's to 1's for the squares that are occupied by the
			// current block
			// gets actual position from relative position
			int x = mxPos + blockPos[i][0];
			int y = myPos + blockPos[i][1];
			//System.out.println("check" + x + " " + y);
			if (mBackGrid[y][x] != Blocks.BLOCK_NONE)
			{
				return true;
			}
		}
		return false;
	}

	public boolean isGameOver() {
		for (int i = 0; i < mBackGrid[0].length; ++i) {
			if (mBackGrid[0][i] == 1) {
				return true;
			}
		}
		return false;
	}

	// checks to see if the row inputted is filled
	private boolean isFilled(int row) {
		int count = 0;
		for (int i = 0; i < mBackGrid[row].length; ++i) {
			if (mBackGrid[row][i] != Blocks.BLOCK_NONE) {
				count++;
			}
			if (count == mBackGrid[row].length)
				return true;
		}
		System.out.println(count);
		return false;
	}

	// Assumption: User only calls this after the block has stopped moving
	private boolean mergeBlockIntoGrid() {
		// updates the original grid, ("background")
		if (mThisBlock == null) {
			return false;
		}
		int[][] blockPos = mThisBlock.getPositions();
		mxPos = mThisBlock.getXPos();
		myPos = mThisBlock.getYPos();
		for (int i = 0; i < blockPos.length; ++i) { // changes 0's to 1's for the squares that are occupied by the
													// current block
			// gets actual position from relative position
			int x = mxPos + blockPos[i][0];
			int y = myPos + blockPos[i][1];
			//System.out.println("merge" + x + " " + y);
			mBackGrid[y][x] = mThisBlock.getBlockType();
		}
		mThisBlock = null;
		return isGameOver();
	}

	// Caller is VIEW
	public int[][] getMesh() {
		if (mIsGameOver == true)
		{
			return null;
		}
		// create new object that copies the original background's elements
		int[][] meshToDraw = new int[mHeight][mWidth];
		for (int i = 0; i < mHeight; ++i) {
			for (int j = 0; j < mWidth; ++j) {
				meshToDraw[i][j] = mBackGrid[i][j];
			}
		}
		// update the copied grid with current block falling down
		if (mThisBlock == null) {
			return meshToDraw;
		}
		int[][] blockPos = mThisBlock.getPositions();
		mxPos = mThisBlock.getXPos();
		myPos = mThisBlock.getYPos();
		//System.out.println(mxPos + " " + myPos);
		for (int i = 0; i < blockPos.length; ++i) { // changes 0's to 1's for the squares that are occupied by the
													// current block
			int x = mxPos + blockPos[i][0];
			int y = myPos + blockPos[i][1];
			meshToDraw[y][x] = mThisBlock.getBlockType();
		}
		// update grid with pile
		//int [][] pilePos = 
		return meshToDraw;
	}
	
	private void createNewBlock() {
		int choose = (int) (Math.random() * 7) + 1;
        switch (choose)
        {
        case 1: //Iblock
    		mThisBlock = new IBlock(mWidth/2,0);
    		break;
       case 2:
        	mThisBlock = new JBlock(mWidth/2,0);
    		break;
        case 3:
        	mThisBlock = new LBlock(mWidth/2,0);
    		break;
        case 4:
        	mThisBlock = new SBlock(mWidth/2,0);
    		break;
        case 5:
        	mThisBlock = new ReverseSBlock(mWidth/2,0);
    		break;
        case 6:
        	mThisBlock = new SquareBlock(mWidth/2,0);
    		break;
        case 7:
        	mThisBlock = new TBlock(mWidth/2,0);
    		break;
    	default:
    		assert(false);
    		break;
        }
	}

	public void moveBlock(int cmd) {
		System.out.println("test " + cmd);
		if (mThisBlock == null) {
			return;
		}
		switch (cmd) {
		case Action.CMD_ROTATE:
			mThisBlock.turn();
			break;
		case Action.CMD_MOVE_LEFT:
			if (Blocks.getXPos() > 0) {
				mThisBlock.setXPos(mxPos - 1);
			}
			break;
		case Action.CMD_MOVE_RIGHT:
			if (Blocks.getXPos() + mThisBlock.getBlockWidth() < mWidth) {
				mThisBlock.setXPos(mxPos + 1);
			}
			break;
		case Action.CMD_MOVE_DOWN:
			if (Blocks.getYPos() + mThisBlock.getBlockLong() < mHeight) {
				mThisBlock.setYPos(myPos + 1);
				if (checkOverlap() == true)
				{
					mThisBlock.setYPos(myPos - 1);
					mIsGameOver = mergeBlockIntoGrid();
					if (mIsGameOver == false)
					{
						createNewBlock();
					}
				}
			} else {
				mIsGameOver = mergeBlockIntoGrid();
				if (mIsGameOver == false)
				{
					createNewBlock();
				}
			}
			updateScore(2);
			break;
		case Action.CMD_MOVE_BOTTOM:
			break;
		default:
			break;
		}
		if (mIsGameOver == false)
		{
			tryClearRows();
		}
	}
	
	public void updateScore(int e)
	{
		mScore += e;
	}

}
