import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class Action extends KeyAdapter implements ActionListener{

//	private KeyEvent up;
//	private KeyEvent down;
//	private KeyEvent left;
//	private KeyEvent right;
//	private Blocks block;
	private Grid mGrid;
	
	public Action(Grid grid) {
		mGrid = grid;
		int time = 1000;  // in milli-seconds
		Timer clock = new Timer(time, this);
		clock.start();
	}
	
	static final int  CMD_NONE = 0;
	static final int  CMD_ROTATE = 1;
	static final int  CMD_MOVE_LEFT = 2;
	static final int  CMD_MOVE_RIGHT = 3;
	static final int  CMD_MOVE_DOWN = 4;
	static final int  CMD_MOVE_BOTTOM = 5;
	
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
