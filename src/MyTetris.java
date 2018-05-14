import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyTetris extends JPanel 
				implements ActionListener{
	private int time = 0, x = 150, y = 0;
	public static final int height = 200;
	public static final int totalRow = height/20;
	private enum State {READY, MOVING, STOPPED}
	private State currentState;
	
	public MyTetris() 
	{
		Timer clock = new Timer(30, this); 
		clock.start();
	}
	
	public static void main(String[] args)
	{
		JFrame window = new JFrame("MineTetris");
		window.setBounds(100, 100, 300, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new MyTetris();
		canvas.setBackground(Color.WHITE);
		window.getContentPane().add(canvas);
		window.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	    int width = getWidth();    
	    int height = getHeight();
	    int stop, currenty;
		Blocks chang = new JBlock(x, y);
		//Blocks chen = new SquareBlock(x, y);
		//currenty = y;
		Grid yes = new Grid(chang, 6, 15);
//		Grid no = new Grid(chen);
//		stop = yes.stop(15);
//		if (stop == 0)
//	    {
//			Blocks.setYPos(Blocks.getYPos());
//	    }
//	    else
//	    {
	    	y = (int)(time);
//	    }
//		if (time / 50 > 3)
//		{
//			chang.turn(g);
//		}
//		else
//		{
			chang.shape(g);
//		}
//		if (currentState == State.READY)
//		{
//			chang.shape(g);
//			currentState = State.MOVING;
//		}
//		else if (currentState == State.MOVING)
//		{
//			chang.turn(g);
//		}
//		else if (currentState == State.STOPPED) // never happens
//		{
//			y = currenty;
//			currentState = State.READY;
//		}
	}

	public void actionPerformed(ActionEvent a) {
		time++;
	    repaint();
	}
	
	private void chooseBlock()
	{
		int choose = (int) (Math.random() * 7);
		switch (choose)
		{
		case 1: //Iblock
			IBlock i = new IBlock(x, 7);
		case 2: 
			//
		case 3:
			//
		case 4:
			//
		case 5:
			JBlock j = new JBlock(x, y);
		case 6:
			//
		case 7:
			//
		}
	}
}