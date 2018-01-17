package snake;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args)
	{
				MyWindow win = new MyWindow();
				
				win.setTitle("Snake");
				win.setSize(MyWindow.width*30,MyWindow.height*30);
				win.setVisible(true);
				win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	}
}
