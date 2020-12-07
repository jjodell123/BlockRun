package jj.blocks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import jj.Map.One;

public class Teleporter {

	int x,y,telY;
	Rectangle rect;
	
	//mapOne=new MapOne();
	public Teleporter(int x,int y, int telY)
	{
		this.x=x;
		this.y=y;
		this.telY=telY;
		
		rect=new Rectangle(x,y,30,30);
	}
	
	public void setTelLoc(int moveSpeed)
	{
		x+=moveSpeed;
		rect.setLocation(x,y);
		//System.out.println(x);
	}
	
	public void screenIsMoving(int move)
	{
		//System.out.println(move);
		y+=move;
		telY+=move;
		rect.setLocation(x,y);
	}

	public void move()
	{
		y=-2000;
		telY=-2000;
		rect.setLocation(x,y);
	}
	
	public int getTelY()
	{
		return telY;
	}
	
	public  int getX()
	{
		return x;
	}
	
	public Rectangle getTelRect()
	{
		return rect;
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.green);
		g.fillOval(x,y,30,30);
		g.setColor(Color.darkGray);
		g.draw(rect);
		g.drawOval(x+1,y+1,28,28);
		g.setColor(Color.darkGray);
		g.fillOval(x,telY,30,30);
		g.setColor(Color.green);
		g.drawOval(x,telY,30,30);
		g.drawOval(x+1,telY+1,28,28);
	//	g.setColor(Color.red);
		//g.draw(rect);
	}
}

