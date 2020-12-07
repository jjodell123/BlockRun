package jj;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

import jj.Character.customCharacters;
import jj.Map.MapNumber;
import jj.Map.One;

public class Player {
	private static String imageUrl = "src/resources/characters/";
	private static Image character0,character1,character2;

	private static int jumpTime,fallTime,jumpType;
	private static int customCharacter;
	private static  int x;
	private static int regY,y ;
	
	private static customCharacters cust;
	
	private static double holder,lastHolder,returnHolder ;
	
	private static Rectangle pRec,beneathRec,deathRec,wholeRect,pTelRect;
	
	private static boolean reset=false,isImage=true;
	
	private static MapNumber mapNum=new MapNumber();
	
	private Image currentCharacter=character2;
	
	private static boolean stopScreenMove=false;
	public Player()
	{
		cust=new customCharacters();
		x=50;
		y=One.getStartY();
		regY=y;
		pRec=new Rectangle(x,regY+25,29,5);
		pTelRect=new Rectangle(x+1,regY+14,1,2);
		beneathRec=new Rectangle(x,regY+30,29,5);
		deathRec=new Rectangle(x,regY,29,24);
		wholeRect=new Rectangle(x,regY,30,30);
		character0=Toolkit.getDefaultToolkit().getImage(imageUrl+"character_0.png");
		character0=character0.getScaledInstance(30, 30, 1);
		character1=Toolkit.getDefaultToolkit().getImage(imageUrl+"character_1.png");
		character1=character1.getScaledInstance(30, 30, 1);
		character2=Toolkit.getDefaultToolkit().getImage(imageUrl+"character_2.png");
		character2=character2.getScaledInstance(30, 30, 1);
	}
	
	public void jump(boolean isJumping)
	{

		if(isJumping==true)
		{
			
			if(mapNum.getMapNumber()==1)
			{
				One.setIsJumping(true);
				
			}
		}
		if(!isJumping)
		{
			if(mapNum.getMapNumber()==1)
			{
				One.setIsJumping(false);
			}
		}
	}
	
	public int getY()
	{
		return regY;
	}
	
	public void moveY(int yy)
	{
		y+=yy;
		regY+=yy;
	}
	
	public void setY(int yy)
	{
		y=yy;
		regY=yy;
		//System.out.println("fghgj");
	}
	
	
	
	public Rectangle getWholePlayerRect()
	{
		return wholeRect;
	}
	
	public Rectangle getPlayerRect()
	{
		
		return pRec;
	}
	
	public Rectangle getPlayerTelRect()
	{
		
		return pTelRect;
	}
	
	public Rectangle getPlayerBeneathRect()
	{
		
		return beneathRec;
	}
	
	public Rectangle getPlayerDeathRect()
	{
		
		return deathRec;
	}
	
	
	public void setRecLoc()
	{
		pRec.setLocation(x,regY+25);
		beneathRec.setLocation(x,regY+30);
		deathRec.setLocation(x,regY);
		wholeRect.setLocation(x,regY);
		pTelRect.setLocation(x+1,regY+14);
	}
	
	public int getRealY()
	{
		return y;
	}
	
	public void jump(int jumpTime)
	{
	//	System.out.println("ss");
		this.jumpTime=jumpTime;
		//System.out.println("hi");
		if(jumpTime<=140)
		{
			holder=(((double) (-80.0/4900)*((this.jumpTime-70)*(this.jumpTime-70)))+80);
			//System.out.println(holder);
			jumpType=0;
		}
		
		else if(reset)
		{
			holder=0;
			reset=false;
			//System.out.println("reset");
			//stopScreenMove=false;
			jumpType=1;
		}
		//make this not == false
		else if(stopScreenMove)
		{
			//lastHolder=0;
			holder=getScreenMoveSpeed();	
			jumpType=2;
		}
		else if(jumpTime>140)
		{
			holder=((double)(jumpTime*-2.5)+350);
			jumpType=3;
		}
		
		if(!stopScreenMove)
		{
			regY=y-(int)holder;
		//	System.out.println(jumpType);
			//System.out.println(y+" "+regY+" "+holder);
		}
	//	System.out.println(regY);
		
		if (jumpTime<=140)
			//returnHolder=(((double) (-80.0/4900)*((this.jumpTime-70)*(this.jumpTime-70)))+80);
			returnHolder=(int)(holder-lastHolder);
		else if(stopScreenMove)
		{
			returnHolder=(double)(-25);
		//	System.out.println(regY);
		}
		else
		{
			returnHolder=(int)(holder-lastHolder);
			if(returnHolder<0);
				//returnHolder=0;
//System.out.println(returnHolder);
		}
		lastHolder=holder;
	}
	
	
	
	public void fall(int fallTime)
	{	
		this.fallTime=fallTime;
		//System.out.println(regY);
		if(fallTime<=70)
		{
			holder=(((double) (-80.0/4900)*((this.fallTime*this.fallTime))));
		//	System.out.println("2");
		//	System.out.println(holder);
		}
		
		else if(stopScreenMove)
		{
		//	lastHolder=0;
			holder=getScreenMoveSpeed();	
		//System.out.println("4");
		//	System.out.println(holder);

		}
		else if(fallTime>70)
		{
	//		System.out.println("5");

			holder=((double)(fallTime*-2.5)+87);
		//	System.out.println(fallTime);

		}
			//System.out.println(fallTime);
		if(!stopScreenMove && !reset)
		{
			regY=y-(int)holder;
			//System.out.println(holder+" "+ regY);
		}
		
		if(reset)
		{
			reset=false;
		}
		
		if (fallTime<=70)
		{
			returnHolder=(((double) (-80.0/4900)*((this.fallTime-0)*(this.fallTime-0))));
			//returnHolder=y+returnHolder;
		}
		else if(stopScreenMove==true)
		{
			returnHolder=-25;
				//System.out.println("hi");
		}
		else
		{
			returnHolder=(int)(holder-lastHolder);
			if(returnHolder<0)
				returnHolder=0;
		//	System.out.println(returnHolder);
		}
				lastHolder=holder;
	}
	
	public void reset()
	{
		returnHolder=0;
		lastHolder=0;
		reset=true;
		//System.out.println("5674");
	}
	
	public void counterFall(boolean stopScreenMove)
	{
		this.stopScreenMove=stopScreenMove;
	//	System.out.println(this.stopScreenMove);
	}
	
	public int getFallSpeed()
	{
		return (int) returnHolder;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getScreenMoveSpeed()
	{
		return (int)lastHolder;
	}
	
	public void setCharacter(int character)
	{
		if(character==0)
		{
			currentCharacter=character0;
			isImage=true;
		}
		else if(character==1)
		{
			currentCharacter=character1;
			isImage=true;
		}
		else if(character==2)
		{
			currentCharacter=character2;
		isImage=true;
		}
		else if(character==3)
		{
			customCharacter=1;
			isImage=false;
		}
		else if(character==4)
		{
			customCharacter=2;
			//System.out.println("hdd");
			isImage=false;
		}
		else if(character==5)
		{
			customCharacter=3;
			isImage=false;
		}
	}
	
	public void draw(Graphics2D g)
	{
		//g.translate(x, regY);
		if(isImage)
		g.drawImage(currentCharacter,x,regY,null);
		else
		{
			//System.out.println("");
			if(customCharacter==1)
			{
				ArrayList<Point> temp=cust.getP();
				ArrayList<Color> tempC=cust.getC();
				//cust.drawOne(g);
				for(int i=0;i<temp.size();i++)
				{
					g.setColor(tempC.get(i));
				g.fillRect((x+(int)temp.get(i).getX()), (regY+(int)temp.get(i).getY()), 1, 1);
				//System.out.println(x+(int)temp.get(i).getX()+" "+regY+(int)temp.get(i).getY());
				}
				//System.out.println("gi");
			}
			if(customCharacter==2)
			{
				ArrayList<Point> temp=cust.getP2();
				ArrayList<Color> tempC=cust.getC2();
				//cust.drawOne(g);
				for(int i=0;i<temp.size();i++)
				{
					g.setColor(tempC.get(i));
				g.fillRect((x+(int)temp.get(i).getX()), (regY+(int)temp.get(i).getY()), 1, 1);
				//System.out.println(x+(int)temp.get(i).getX()+" "+regY+(int)temp.get(i).getY());
				}
			}
			if(customCharacter==3)
			{
				ArrayList<Point> temp=cust.getP3();
				ArrayList<Color> tempC=cust.getC3();
				//cust.drawOne(g);
				for(int i=0;i<temp.size();i++)
				{
					g.setColor(tempC.get(i));
				g.fillRect((x+(int)temp.get(i).getX()), (regY+(int)temp.get(i).getY()), 1, 1);
				//System.out.println(x+(int)temp.get(i).getX()+" "+regY+(int)temp.get(i).getY());
				}
			}
			
		}
		//g.setColor(Color.CYAN);
		//g.draw(deathRec);
		//g.setColor(Color.magenta);
		//g.draw(beneathRec);
		//g.draw(deathRec);
		
	}
}
