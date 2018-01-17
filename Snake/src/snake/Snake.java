package snake;

import java.awt.Color;
import java.util.LinkedList;

public class Snake extends Thread
{
	private int direction;
	private int newDirection;
	private int speed = 3;
	private int length = 2;
	private LinkedList<Positions> pos = new LinkedList<Positions>();
	private Positions fruit;
	private Positions head;
	private Positions tail;
	private Positions oldHead;
	Snake(String name)
	{
		super(name);
		direction=2;
		head = new Positions(MyWindow.width/2,MyWindow.height/2);
		tail = new Positions(getHead().getX(),getHead().getY());
		fruit = new Positions((int)(Math.random()*MyWindow.width-1),(int)(Math.random()*MyWindow.height-1));
	}

	@Override
	public void run()
	{
		while(true)
		{
			if(canMove()) move();
			else gameStop();
			render();
			delay();
		}
	}

	public void render()
	{
		MyWindow.Grid.get(getTail().getY()).get(getTail().getX()).changeColor(Color.white);
		MyWindow.Grid.get(getHead().getY()).get(getHead().getX()).changeColor(Color.black);
		for(int i=0; i<getPos().size(); i++)
			MyWindow.Grid.get(getPos().get(i).getY()).get(getPos().get(i).getX()).changeColor(Color.black);
		MyWindow.Grid.get(getFruit().getY()).get(getFruit().getX()).changeColor(Color.blue);
	}

	public void delay()
	{
		try
		{
			Snake.sleep(500/getSpeed());
		}
		catch(InterruptedException exc)
		{
			exc.printStackTrace();
		}
	}

	public boolean canMove()
	{
		for(int i=0; i<getPos().size(); i++)
			if(getPos().get(i).getX()==getHead().getX() && getPos().get(i).getY()==getHead().getY())
				return false;
			if(getHead().getX()==getFruit().getX() && getHead().getY()==getFruit().getY())
			{
				setLength(getLength() + 1);
				setSpeed(getSpeed() + 1);
				genFruit();
			}
		return true;
	}

	public void gameStop()
	{
		while(true)
		{
			try
			{
				Snake.sleep(999);
			}
			catch(InterruptedException exc)
			{
				exc.printStackTrace();
			}
		}
	}
	
	public void genFruit()
	{
		int xf = (int)(Math.random()*MyWindow.width);
		int yf = (int)(Math.random()*MyWindow.height);
		for(int i=0; i<getPos().size(); i++)
		{
			if(getPos().get(i).getX()==xf && getPos().get(i).getY()==yf)
			{
				xf = (int)(Math.random()*MyWindow.width);
				yf = (int)(Math.random()*MyWindow.height);
				i=-1;
			}
		}
		if(getHead().getX()==xf && getHead().getY()==yf || getTail().getX()==xf && getTail().getY()==yf)
		{
			xf = (int)(Math.random()*MyWindow.width);
			yf = (int)(Math.random()*MyWindow.height);
		}
		getFruit().setX(xf);
		getFruit().setY(yf);
	}

	public void move()
	{
		setOldHead(new Positions(getHead().getX(), getHead().getY()));
		if(getNewDirection()+2!=getDirection() && getNewDirection()-2!=getDirection()) setDirection(getNewDirection());
		if(getDirection()%2==1)
		{
			if(getHead().getX()-2+getDirection()==-1) getHead().setX(MyWindow.width-1);
			else if(getHead().getX()-2+getDirection()==MyWindow.width) getHead().setX(0);
			else getHead().setX(getHead().getX()-2+getDirection());
		}
		else
		{
			if(getHead().getY()-3+getDirection()==-1) getHead().setY(MyWindow.height-1);
			else if(getHead().getY()-2+getDirection()==MyWindow.height+1) getHead().setY(0);
			else getHead().setY(getHead().getY()-3+getDirection());
		}
		for(int i=getPos().size(); i<getLength(); i++)
			getPos().add(0, getOldHead());
		getTail().setX(getPos().get(getPos().size()-1).getX());
		getTail().setY(getPos().get(getPos().size()-1).getY());
		for(int i=getPos().size()-1; i>0; i--)
		{
			getPos().get(i).setX(getPos().get(i-1).getX());
			getPos().get(i).setY(getPos().get(i-1).getY());
		}
		getPos().get(0).setX(getOldHead().getX());
		getPos().get(0).setY(getOldHead().getY());
	}

	/**
	 * @return the direction
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * @return the newDirection
	 */
	public int getNewDirection() {
		return newDirection;
	}

	/**
	 * @param newDirection the newDirection to set
	 */
	public void setNewDirection(int newDirection) {
		this.newDirection = newDirection;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the pos
	 */
	public LinkedList<Positions> getPos() {
		return pos;
	}

	/**
	 * @param pos the pos to set
	 */
	public void setPos(LinkedList<Positions> pos) {
		this.pos = pos;
	}

	/**
	 * @return the fruit
	 */
	public Positions getFruit() {
		return fruit;
	}

	/**
	 * @param fruit the fruit to set
	 */
	public void setFruit(Positions fruit) {
		this.fruit = fruit;
	}

	/**
	 * @return the head
	 */
	public Positions getHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(Positions head) {
		this.head = head;
	}

	/**
	 * @return the tail
	 */
	public Positions getTail() {
		return tail;
	}

	/**
	 * @param tail the tail to set
	 */
	public void setTail(Positions tail) {
		this.tail = tail;
	}

	/**
	 * @return the oldHead
	 */
	public Positions getOldHead() {
		return oldHead;
	}

	/**
	 * @param oldHead the oldHead to set
	 */
	public void setOldHead(Positions oldHead) {
		this.oldHead = oldHead;
	}
}