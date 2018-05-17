import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class Action extends KeyAdapter implements ActionListener{

	private Grid mGrid;
	
	public static final int  CMD_NONE = 0;
	public static final int  CMD_ROTATE = 1;
	public static final int  CMD_MOVE_LEFT = 2;
	public static final int  CMD_MOVE_RIGHT = 3;
	public static final int  CMD_MOVE_DOWN = 4;
	public static final int  CMD_MOVE_BOTTOM = 5;
	
	// This constructor takes in a grid as a parameter and sets it equal to the mGrid field
	// A timer is also started to set the rate at which the blocks fall down
	public Action(Grid grid) {
		mGrid = grid;
		int time = 1000;  // in milli-seconds
		Timer clock = new Timer(time, this);
		clock.start();
	}
	
	
	
	
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
		case 38:
			cmd = CMD_ROTATE;
			break;
		case 39:
			cmd = CMD_MOVE_RIGHT;
			break;
		case 40:
			cmd = CMD_MOVE_DOWN;
			break;
		default:
			assert(false);
			break;
		}
		mGrid.moveBlock(cmd);
	}

	public void actionPerformed(ActionEvent e) {
		mGrid.moveBlock(CMD_MOVE_DOWN);
	}
	
	

}
