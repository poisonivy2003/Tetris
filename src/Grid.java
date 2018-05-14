
public class Grid {
	private boolean mIsFilled, collide; //true if the entire block is filled
	private int mxPos, myPos; //how many blocks down and right the lock is
	public static int mScore; //points
	Blocks mThisBlock; //block passed in
	private int[][] blockGrid; //holds a number of points that represent the total amount of blocks to fill the grid( 0 = empty, 1 = full)
	private int mHeight;
	private int mWidth;
	
	public Grid(Blocks b, int width, int height) {
		mThisBlock = b;
		mHeight = height;
		mWidth = width;
		blockGrid = new int[height][width];
		for (int i=0; i<height; ++i) {
			for (int j=0; j<width; ++j) {
			    blockGrid[i][j] = 0; //looping through array and setting each column(height) and row(width) to zero
			}
		}
	}

	public void clearRow() {
		for (int row=0; row<blockGrid.length; ++row) { 
			if (isFilled(row) == true) //checks if this current row is filled
			{
				for (int i=row; i > 0; --i) //starts at the filled row
				{
					for (int p=0; p<blockGrid[row].length; ++p) { //goes down the row, replacing every value with the one above it
						blockGrid[i][p] = blockGrid[i-1][p];
					}
					
				}
				for (int p=0; p<blockGrid[0].length; ++p) { //goes down 0th row, replacing every value with the one above it
					blockGrid[0][p] = 0;
				}
			}
		}
	}

	public int stop(int height) {
		int y = Blocks.getYPos();
		if (collide == false)
		{
			int whereOnY = Blocks.getYPos();
			if (whereOnY == height)
			{
				return 0;	
			}
			else
			{
				return 1;
			}
		}
		else
		{
			return 0;		
		}
	}

	public boolean endGame() {
		for (int i=0; i<blockGrid[0].length; ++i) { 
			if (blockGrid[0][i] == 1)
			{
				return true;
			}
		}
		return false;
	}
	
	//checks to see if the row inputted is filled
	private boolean isFilled(int row)
	{
		int count = 0;
		for (int i=0; i<blockGrid[row].length; ++i) { 
			if (blockGrid[row][i] == 1)
			{
				count++;
			}
			if (count == blockGrid.length)
				return true;
		}
		return false;
	}
	
	//Assumption: User only calls this after the block has stopped moving
	private void updateBackgroundGrid ()
	{
		//updates the original grid, ("background")
		int[][]  blockPos = mThisBlock.getPositions();
		mxPos = mThisBlock.getXPos();
		myPos = mThisBlock.getYPos();
		for (int i=0; i<blockPos.length; ++i) { //changes 0's to 1's for the squares that are occupied by the current block
			int x = mxPos + blockPos[i][0]; 
			int y = myPos + blockPos[i][1];
			blockGrid[x][y] = 1;
		}
	}
	
	// Caller is VIEW
	private int[][] getMesh_ofGridAndBlock ()
	{
		//create new object that copies the original background's elements
		int[][] meshToDraw = new int[mHeight][mWidth]; 
		for (int i=0; i<mHeight; ++i) {
			for (int j=0; j<mWidth; ++j) {
			    meshToDraw[i][j] = blockGrid[i][j];
			}
		}
		//update the copied grid with current block falling down
		int[][]  blockPos = mThisBlock.getPositions();
		mxPos = mThisBlock.getXPos();
		myPos = mThisBlock.getYPos();
		for (int i=0; i<blockPos.length; ++i) { //changes 0's to 1's for the squares that are occupied by the current block
			int x = mxPos + blockPos[i][0]; 
			int y = myPos + blockPos[i][1];
			meshToDraw[x][y] = 1;
		}
		return meshToDraw;
	}
	

}
