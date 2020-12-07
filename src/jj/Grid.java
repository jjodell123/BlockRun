package jj;

public class Grid {

	private int x[],y[];
	
	//takes length and height from whichever map class calls on it
	public Grid(int mapLength,int mapHeight)
	{
		x=new int[mapLength];
		y=new int[mapHeight];
		for(int i=0;i<x.length;i++)
		{
			x[i]=(30*i);//-4150;
		}
		for(int i=0;i<y.length;i++)
		{
			y[i]=(30*i);//-100;
		}
	}
	
	//updates grid location
	public void moveGrid()
	{
		
	}
	
	public int[] getGridX()
	{
		return x;
	}
	
	public int[] getGridY()
	{
		return y;
	}
}
