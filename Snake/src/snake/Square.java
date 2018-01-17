package snake;

import javax.swing.JPanel;
import java.awt.Color;

public class Square extends JPanel
{
	private static final long serialVersionUID = 8905401206161904180L;
	private Color color;
	Square(Color color)
	{
		this.color = color;
		this.setBackground(color);
	}
	Square()
	{
		this.color = Color.white;
		this.setBackground(color);
	}
	public void setColor(Color color)
	{
		this.color = color;
		this.setBackground(color);
	}
	
	public void changeColor(Color color)
	{
		this.color = color;
		this.setBackground(color);
		this.repaint();
	}
}
