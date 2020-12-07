package jj.blocks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class RegTriangle// extends Polygon{
{

	private int[] x,y;
	private Polygon tri;
	public RegTriangle(int[]x, int[] y)
	{
	//	super(x,y,3);
		this.x=x;
		this.y=y;
		tri=new Polygon(x,y,3);
		
		//tri=new Rectangle();
		
	}
	
	public void screenIsMoving(int move)
	{
		for(int i=0;i<y.length;i++)
			y[i]+=move;
		tri=new Polygon(x,y,3);
	}

	public void move()
	{
		for(int i=0;i<y.length;i++)

		y[i]=-2000;
		tri=new Polygon(x,y,3);
	}
	
	public Polygon getPoly()
	{
		return tri;
	}
	
	/*@Override
	public Rectangle getBounds()
	{
		//tri= 
		//tri= new Rectangle(super.xpoints[0],super.ypoints[0],30,30);
		return tri;//= new Rectangle(super.xpoints[0],super.ypoints[0],30,30);
	}*/
	
	public void setRegLoc(int moveSpeed)
	{
	//	x[i]+=moveSpeed;
		//tri.setLocation(x,y);
		for(int i=0;i<x.length;i++)
		{
			x[i]+=moveSpeed;
		}
		tri=new Polygon(x,y,3);
		//tri.
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.black);
		g.fill(tri);
		g.setColor(Color.magenta);
		g.draw(tri);
		//g.drawLine(x1, y1, x2, y2);
	}
}
