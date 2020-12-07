package jj.customize;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import jj.Character.customCharacters;

public class customizeCharacter{

	private int x[]=new int [30];
	private int y[]=new int [30];
	static private boolean xTest[][]=new boolean[30][30];
	//static private boolean yTest[]=new boolean[30];
	private int charFile;
	private Rectangle changeC,save,back,erase,draw;
	private Rectangle places[][]=new Rectangle[30][30];
	private int red=255,blue=255,green=255;
	private int size;
	private Rectangle pencil;
	private customCharacters cust;
	private Rectangle sizeRect;
	//Color colorUse=new Color(255,255,255);
	static ArrayList<Color> c=new ArrayList<Color>();
	static ArrayList<Point> block=new ArrayList<Point>();
	static ArrayList<Color> pastC=new ArrayList<Color>();
	static ArrayList<Point> pastBlock=new ArrayList<Point>();
	static ArrayList<Color> saveC=new ArrayList<Color>();
	static ArrayList<Point> saveBlock=new ArrayList<Point>();
	public customizeCharacter()
	{
		cust=new customCharacters();
		//block.add(new Point(10000,1000));
		//c.add(Color.white);
		pencil=new Rectangle(0,0,8,8);
		changeC=new Rectangle(200,50,100,50);
		back=new Rectangle(25,400,50,50);
		save=new Rectangle(350,50,100,50);
		for(int i=0;i<x.length;i++)
			x[i]=(10*i)+100;
		for(int i=0;i<y.length;i++)
			y[i]=(10*i)+150;
		for(int i=0;i<places.length;i++)
		{
			for(int ii=0;ii<places[i].length;ii++)
				places[i][ii]=new Rectangle(x[i],y[ii],10,10);
		}
		sizeRect=new Rectangle(50,50,100,50);
		erase=new Rectangle(40,150,50,50);
		draw=new Rectangle(410,150,50,50);
	}
	
	public Rectangle[][] getPlaces()
	{
		return places;
	}
	
	public Rectangle getChangeC()
	{
		return changeC;
	}
	
	public Rectangle getErase()
	{
		return erase;
	}
	
	public Rectangle getDraw()
	{
		return draw;
	}
	
	public Rectangle getBack()
	{
		return back;
	}
	
	public Rectangle getSave()
	{
		return save;
	}
	
	
	
	public Rectangle getPencil()
	{
		return pencil;
	}
	
	public Rectangle getSizeRect()
	{
		return sizeRect;
	}
	
	public void changeSize()
	{
		size=(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter a pencil size"))*10)-2;
		pencil.setSize(size, size);
	}
	
	public void saveRect()
	{
		saveC=c;
		
		System.out.println(block.get(0).getX());
		saveBlock=new ArrayList<Point>(block);
		
			//saveBlock.get(i)=(saveC.get(i)-100)/10;
		charFile=Integer.parseInt(JOptionPane.showInputDialog(null,"Which file would you like to save under(1,2,or,3)?"));
		cust.save(saveBlock, saveC, charFile);
		System.out.println(saveBlock.get(0).getX());
		System.out.println(block.get(0).getX());
	}
	
	public void setRect(int x, int y)
	{
		pencil.setLocation(x-(size/2),y-(size/2));
		//System.out.println(x+" "+y);
	}
	
	public void setColor()
	{
		
		red=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter a red value"));
		green=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter a green value"));
		blue=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter a blue value"));
		//colorUse=new Color(tempR,tempG,tempB);//.add(new Color(tempR,tempG,tempB));
	}
	
	public void setBlock(int x,int y)
	{
		//System.out.println((y/10)-15);
	if(!xTest[(x/10)-10][(y/10)-15])
	{
					block.add(new Point(x,y));
					c.add(new Color(red,green,blue));
				
				xTest[(x/10)-10][(y/10)-15]=true;
			//	yTest[(y/10)-15]=true;
				//System.out.println("dfg");
	}
	}
	
	public void delete(int x,int y)
	{
		for(int i=0;i<block.size();i++)
		{
			if(((int)block.get(i).getX())==x && ((int)block.get(i).getY())==y)
			{
		block.remove(i);
		c.remove(i);
		xTest[(x/10)-10][(y/10)-15]=false;
			}
		}
		
	}
	
	public void resetTest()
	{
		for(int i=0;i<xTest.length;i++)
		{
			for(int ii=0;ii<xTest[i].length;ii++)
			{
				xTest[i][ii]=false;
			}
		}
		
	//	System.out.println(block.size());

	}
	
	public void draw(Graphics2D g)
	{
		for(int i=0;i<x.length;i++)
		{
			for(int ii=0;ii<y.length;ii++)
			{
				g.drawRect(x[i], y[ii], 10, 10);
			}
		}
		g.setColor(Color.blue);
		g.fill(changeC);
		g.fill(sizeRect);
		g.fill(save);
		g.fill(back);
		g.fill(erase);
		g.fill(draw);
		g.setColor(Color.white);
		g.drawString("Change Color", 210, 70);
		g.drawString("Change Size", 60, 70);
		g.drawString("Erase", 50, 170);
		g.drawString("Draw", 420, 170);
		g.drawString("Save the character", 350, 70);
		g.drawString("Back", 33, 425);
		for(int i=0;i<block.size();i++)
		{
			g.setColor(c.get(i));
			g.fillRect((int)block.get(i).getX(), (int)block.get(i).getY(), 10, 10);
			//System.out.println(block.get(i).getX());
		}
		g.setColor(Color.magenta);
		g.draw(pencil);
		
	}

}
