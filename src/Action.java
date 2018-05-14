import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Action extends KeyAdapter implements ActionListener{

	private KeyEvent up;
	private KeyEvent down;
	private KeyEvent left;
	private KeyEvent right;
	private Blocks block;
	
//	public Action(xCoord, yCoord) {
//		
//	}
	
	public void keyPressed(KeyEvent e) {
		int command = e.getKeyCode();
		System.out.println(command);
		switch(command) {
//		case 32:
//			if (Grid.getTmpWidth() != 15) {
//				TetrisVisual.time = 30;
//			}
		case 37:
			if (Grid.getTmpWidth() >= 0 && Grid.getTmpWidth() <= 5) {
				Grid.setTmpWidth(-1);
			}
			break;
		case 38:
			
			break;
		case 39:
			if (Grid.getTmpWidth() >= 0 && Grid.getTmpWidth() <= 5) {
				Grid.setTmpWidth(1);
			}
			break;
		case 40:
			Grid.setTmpHeight(1);
			break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		//System.out.println("f");
	}


	
	public void keyTyped(KeyEvent e) {
		System.out.println("g");
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
