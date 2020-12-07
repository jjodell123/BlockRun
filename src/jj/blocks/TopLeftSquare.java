package jj.blocks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class TopLeftSquare {
	int x,y;
	Rectangle rect;
	public TopLeftSquare(int x,int y)
	{
		this.x=x;
		this.y=y;
		rect=new Rectangle(x,y,30,30);
	}
	
	public void setTLLoc(int moveSpeed)
	{
		x+=moveSpeed;
		rect.setLocation(x,y);
	}
	
	public int getY()
	{
		return y;
	}

	public void move()
	{
		y=-2000;
		rect.setLocation(x,y);
	}
	
	public void screenIsMoving(int move)
	{
		y+=move;
	}
	
	public Rectangle getTLRect()
	{
		return rect;
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.black);
		g.fillRect(x,y, 30, 30);
		g.setColor(Color.blue);
		g.drawLine(x,y,x+30,y);
		g.drawLine(x, y, x, y+30);
		g.drawLine(x+1,y+1,x+28,y+1);
		g.drawLine(x+1, y+1, x+1, y+28);
	}
}
