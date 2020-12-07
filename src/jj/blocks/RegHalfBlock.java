package jj.blocks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RegHalfBlock {
	int x,y;
	Rectangle rect;
	public RegHalfBlock(int x,int y,boolean topHalf)
	{
		if(topHalf)
		{
		this.x=x;
		this.y=y;
		}
		else
		{
			this.x=x;
			this.y=y+15;
		}
		rect=new Rectangle(x,y,30,15);
	}
	public void setRegHLoc(int moveSpeed)
	{
		x+=moveSpeed;
		rect.setLocation(x,y);
	}

	public void move()
	{
		y=-2000;
		rect.setLocation(x,y);
	}
	
	public int getY()
	{
		return y;
	}
	
	public void screenIsMoving(int move)
	{
		y+=move;
		rect.setLocation(x,y);
	}
	
	public Rectangle getRegHRect()
	{
		return rect;
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.black);
		g.fillRect(x,y, 30, 15);
		g.setColor(Color.blue);
		g.draw(rect);
		g.drawRect(x+1, y+1, 28, 13);
	}
}
