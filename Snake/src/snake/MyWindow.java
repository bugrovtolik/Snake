package snake;

import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class MyWindow extends JFrame
{
	private static final long serialVersionUID = -8255319694373975038L;
	public static int width = 21;
	public static int height = 21;
	public static ArrayList<ArrayList<Square>> Grid;
	MyWindow()
	{
		ArrayList<Square> G;
		Grid = new ArrayList<ArrayList<Square>>();
		for(int i=0; i<height; i++)
		{
			G = new ArrayList<Square>(); 
			for(int j=0; j<width; j++)
			{
				Square s = new Square();
				G.add(s);
			}
			Grid.add(G);
		}
		
		setLayout(new GridLayout(width,height,0,0));
		
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
				add(Grid.get(i).get(j));
			}
		}
		
		Snake s = new Snake("Player1");
		
		this.addKeyListener((KeyListener) new KeyboardListener(s));
		
		s.start();
		
	}
}
