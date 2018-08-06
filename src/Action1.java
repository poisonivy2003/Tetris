import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class Action1 extends KeyAdapter implements ActionListener{
	/*only for two player mode */
	private Grid1 tGrid; // a grid object is created for the action to send its commands to 
	public static final int  CMD_NONE1 = 10;
	public static final int  CMD_ROTATE1 = 11;
	public static final int  CMD_MOVE_LEFT1 = 12;
	public static final int  CMD_MOVE_RIGHT1 = 13;
	public static final int  CMD_MOVE_DOWN1 = 14;
	public static final int  CMD_MOVE_BOTTOM1 = 15;
	
	public Action1(Grid1 grid) {
		tGrid = grid;
//		int time = 1000;  // in milli-seconds
//		Timer clock = new Timer(time, this);
//		clock.start();
	}

	public void keyPressed(KeyEvent e) {
		int command = e.getKeyCode();
		int cmd = CMD_NONE1;
//		if (command == 88)
//		{
//			cmd = CMD_MOVE_BOTTOM1;
//		}
//		else if (command == 65)
//		{
//			cmd = CMD_MOVE_LEFT1;
//		}
//		else if (command == 87)
//		{
//			cmd = CMD_ROTATE1;
//		}
//		else if (command == 68)
//		{
//			cmd = CMD_MOVE_RIGHT1;
//		}
//		else if (command == 83)
//		{
//			cmd = CMD_MOVE_DOWN1;
//		}
//		else
//		{
//			cmd = CMD_NONE1;
//		}
		
		switch(command)
		{
		case 88: // X
			cmd = CMD_MOVE_BOTTOM1;
			break;
		case 65: //A
			cmd = CMD_MOVE_LEFT1;
			break;
		case 87: //W
			cmd = CMD_ROTATE1;
			break;
		case 68: //D
			cmd = CMD_MOVE_RIGHT1;
			break;
		case 83: //S
			cmd = CMD_MOVE_DOWN1;
			break;
		
		default:
			assert(false);
			break;
		}
		tGrid.moveBlock(cmd); // move the block according to the command
	}

	public void recieveKeyBoardCommand (int command)
	{
		
	}
	
	// each time the timer calls on this method, the moveBlock method is called to move the block down 1 tile
	public void actionPerformed(ActionEvent e) {
		tGrid.moveBlock(CMD_MOVE_DOWN1);
	}
	
}
