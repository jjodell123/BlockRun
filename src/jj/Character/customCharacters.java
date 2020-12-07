package jj.Character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class customCharacters {

	static ArrayList<Point>p=new ArrayList<Point>();
	static ArrayList<Color>c=new ArrayList<Color>();
	static ArrayList<Point>p2=new ArrayList<Point>();
	static ArrayList<Color>c2=new ArrayList<Color>();
	static ArrayList<Point>p3=new ArrayList<Point>();
	static ArrayList<Color>c3=new ArrayList<Color>();
	public customCharacters()
	{
		
	}
	
	public void save(ArrayList<Point> p, ArrayList<Color> c,int file)
	{
		for(int i=0;i<p.size();i++)
		{
			
			p.set(i, new Point((int)(p.get(i).getX()/10)-10,(int)(p.get(i).getY()/10)-15) );
			//System.out.println(p.get(i).getX());
			//System.out.println(p.size());
		}
		
		if(file==1)
		{
			this.p=p;
			this.c=c;
			//System.out.println(p.size());
			/*try{
				FileWriter writer=new FileWriter("customOneBlock.txt");
				BufferedWriter out=new BufferedWriter(writer);
				String st="";
				for(Point pp:p)
				{
					st+=(int)pp.getX()+ " "+(int)pp.getY()+" ";
				}
				out.write(st);
				out.close();
				//System.out.println("hi");
			}
			catch(Exception e)
			{
				System.err.println("Error: "+e.getMessage());
			}
			try{
				FileWriter writer=new FileWriter("customOneColors.txt");
				BufferedWriter out=new BufferedWriter(writer);
				String st="";
				for(Color cc:c)
				{
					st+=cc.getRed()+ " "+cc.getGreen()+ " "+cc.getBlue()+ " ";
				}
				out.write(st);
				out.close();
				//System.out.println("hi");
			}
			catch(Exception e)
			{
				System.err.println("Error: "+e.getMessage());
			}*/
			//Scanner infile=new Scanner(new fileRe)
		}
		if(file==2)
		{
			this.p2=p;
			this.c2=c;
		/*	try{
				FileWriter writer=new FileWriter("customOneBlock.txt");
				BufferedWriter out=new BufferedWriter(writer);
				String st="";
				for(Point pp:p)
				{
					st+=(int)pp.getX()+ " "+(int)pp.getY()+" ";
				}
				out.write(st);
				out.close();
				//System.out.println("hi");
			}
			catch(Exception e)
			{
				System.err.println("Error: "+e.getMessage());
			}
			try{
				FileWriter writer=new FileWriter("customOneColors.txt");
				BufferedWriter out=new BufferedWriter(writer);
				String st="";
				for(Color cc:c)
				{
					st+=cc.getRed()+ " "+cc.getGreen()+ " "+cc.getBlue()+ " ";;
				}
				out.write(st);
				out.close();
				//System.out.println("hi");
			}
			catch(Exception e)
			{
				System.err.println("Error: "+e.getMessage());
			}*/
		}
		if(file==3)
		{
			this.p3=p;
			this.c3=c;
			/*try{
				FileWriter writer=new FileWriter("customOneBlock.txt");
				BufferedWriter out=new BufferedWriter(writer);
				String st="";
				for(Point pp:p)
				{
					st+=(int)pp.getX()+ " "+(int)pp.getY()+" ";
				}
				out.write(st);
				out.close();
				//System.out.println("hi");
			}
			catch(Exception e)
			{
				System.err.println("Error: "+e.getMessage());
			}
			try{
				FileWriter writer=new FileWriter("customOneColors.txt");
				BufferedWriter out=new BufferedWriter(writer);
				String st="";
				for(Color cc:c)
				{
					st+=cc.getRed()+ " "+cc.getGreen()+ " "+cc.getBlue()+ " ";;
				}
				out.write(st);
				out.close();
				//System.out.println(st);
			}
			catch(Exception e)
			{
				System.err.println("Error: "+e.getMessage());
			}*/
		}
	
	
	}
	
	public ArrayList<Point> getP(){
		return p;
	}
	public ArrayList<Color> getC(){
		return c;
	}
	public ArrayList<Point> getP2(){
		return p2;
	}
	public ArrayList<Color> getC2(){
		return c2;
	}
	public ArrayList<Point> getP3(){
		return p3;
	}
	public ArrayList<Color> getC3(){
		return c3;
	}
	public void drawOne(Graphics2D g)
	{
		
		for(int i=0;i<p.size();i++)
		{
			g.setColor(c.get(i));
			g.fillRect(((int)p.get(i).getX()-100)/10, ((int)p.get(i).getY()-150)/10, 1, 1);
			
		}
		//System.out.println(p.size());//(int)p.get(0).getX());
	}
	public void drawTwo(Graphics2D g)
	{
		
		for(int i=0;i<p2.size();i++)
		{
			g.setColor(c2.get(i));
			g.fillRect((int)p2.get(i).getX(), (int)p2.get(i).getY(), 1, 1);
		}
	}
	public void drawThree(Graphics2D g)
	{
		
		for(int i=0;i<p3.size();i++)
		{
			g.setColor(c3.get(i));
			g.fillRect((int)p3.get(i).getX(), (int)p3.get(i).getY(), 1, 1);
		}
	}
}
