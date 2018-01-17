package snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter
{
	private final Snake snake;
	
	KeyboardListener(Snake snake) {
		this.snake = snake;
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
				this.snake.setNewDirection(1);
				break;
				
			case KeyEvent.VK_UP:
				this.snake.setNewDirection(2);
	    		break;
	    		
	    	case KeyEvent.VK_RIGHT:
	    		this.snake.setNewDirection(3);
	    		break;
	    		
	    	case KeyEvent.VK_DOWN:
	    		this.snake.setNewDirection(4);
		    	break;
		    	
		    default:
		    	break;
 		}
	}
}