import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//public class ActionParent{
//
//	public ActionParent (Grid grid) {
//		Action act = new Action(grid);
//	}
//
//	public ActionParent (Grid1 grid) {
//		Action1 act1 = new Action1(grid);
//	}
//}

public class ActionParent extends KeyAdapter{
	Action act;
	Action1 act1;
	

	public ActionParent (Grid grid) {
		act = new Action(grid);
	}

	public ActionParent (Grid1 grid) {
		act1 = new Action1(grid);
	}
	
	public void keyPressed(KeyEvent e)
	{
		int command = e.getKeyCode();
		if (command == 32 || command == 37 || command == 38 || command == 39 || command == 40) //action
		{
			
		}
		else if (command == 65 || command == 68 || command == 83 || command == 87 || command == 88) //action1
		{
			act1.recieveKeyBoardCommand(command);
		}
		else
		{
			assert(false);		
		}
	}
}
