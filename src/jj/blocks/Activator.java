package jj.blocks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import jj.Map.One;

public class Activator {

	int x,y;
	Rectangle rect;
	ArrayList<Integer> del=new ArrayList<Integer>();
	ArrayList<String> type=new ArrayList<String>();
	//mapOne=new MapOne();
	public Activator(int x,int y, ArrayList <Integer> del, ArrayList <String> type)
	{
		this.x=x;
		this.y=y;
		this.del=del;
		this.type=type;
		rect=new Rectangle(x,y,30,30);
	}
	
	public void setActLoc(int moveSpeed)
	{
		x+=moveSpeed;
		rect.setLocation(x,y);
	}
	
	public void screenIsMoving(int move)
	{
		//System.out.println(move);
		y+=move;
		rect.setLocation(x,y);
	}
	
	public void delete()
	{
		
			One.remove(del,type);
		
	}
	
	public void move()
	{
		y=-2000;
		rect.setLocation(x,y);
	}
	
	public  int getX()
	{
		return x;
	}
	
	public Rectangle getActRect()
	{
		return rect;
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.blue);
		g.fillOval(x,y,30,30);
	//	g.setColor(Color.red);
		//g.draw(rect);
	}
}
