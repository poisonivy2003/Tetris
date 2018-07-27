import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

// This class extends the KeyAdapter class so that it can listen to keyboard inputs and process them. 
// It also implements the ActionListener interface so that it can use the timer and move the current block down every second.
public class Action extends KeyAdapter implements ActionListener{

	// fields

	private Grid mGrid; // a grid object is created for the action to send its commands to 
	public static final int  CMD_NONE = 0; // static constants to represent each move
	public static final int  CMD_ROTATE = 1;
	public static final int  CMD_MOVE_LEFT = 2;
	public static final int  CMD_MOVE_RIGHT = 3;
	public static final int  CMD_MOVE_DOWN = 4;
	public static final int  CMD_MOVE_BOTTOM = 5;
	
	// constructor
	
	// This constructor takes in a grid as a parameter and sets it equal to the mGrid field
	// A timer is also started to set the rate at which the blocks fall down
	public Action(Grid grid) {
		mGrid = grid;
		int time = 1000;  // in milli-seconds
		Timer clock = new Timer(time, this);
		clock.start();
	}
	
	// methods
	
	// This method detects when one of the arrow keys or the space bar is pressed and calls on the moveBlock method
	// from the Grid class to move the current block in the appropriate direction
	public void keyPressed(KeyEvent e) {
		int command = e.getKeyCode();
		int cmd = CMD_NONE;
		switch(command) {
		case 32: // space bar
			cmd = CMD_MOVE_BOTTOM;
			break;
		case 37: // left arrow
			cmd = CMD_MOVE_LEFT;
			break;
		case 38: //up arrow
			cmd = CMD_ROTATE;
			break;
		case 39: //right arrow
			cmd = CMD_MOVE_RIGHT;
			break;
		case 40: //bottom arrow
			cmd = CMD_MOVE_DOWN;
			break;
		
		default:
			assert(false);
			break;
		}
		mGrid.moveBlock(cmd); // move the block according to the command
	}

	// each time the timer calls on this method, the moveBlock method is called to move the block down 1 tile
	public void actionPerformed(ActionEvent e) {
		mGrid.moveBlock(CMD_MOVE_DOWN);
	}
}
