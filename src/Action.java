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
		
	}
	
	static final int  CMD_NONE = 0;
	static final int  CMD_ROTATE = 1;
	static final int  CMD_MOVE_LEFT = 2;
	static final int  CMD_MOVE_RIGHT = 3;
	static final int  CMD_MOVE_DOWN = 4;
	static final int  CMD_MOVE_BOTTOM = 5;
	
	public void keyPressed(KeyEvent e) {
		int command = e.getKeyCode();
		//System.out.println(command);
		int cmd = CMD_NONE;
		switch(command) {
		case 32: // space bor
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
		default:
			assert(false);
			break;
		}
		mGrid.moveBlock(cmd);
	}
	
	public void keyReleased(KeyEvent e) {
		//System.out.println("f");
	}


	
	public void keyTyped(KeyEvent e) {
		//System.out.println("g");
//		if (e.getSource() == left) {
//			System.out.println("left");
//		} else if (e.getSource() == right) {
//			System.out.println("right");
//		} else if (e.getSource() == up) {
//			System.out.println("up");
//		} else if (e.getSource() == down) {
//			System.out.println("down");
//		}
//		String u = (String) e.getSource();
//		System.out.println(u);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("a");
	}
	
	

}
