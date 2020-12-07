package jj;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import jj.Character.customCharacters;
import jj.Map.MapNumber;
import jj.Map.MapOne;
import jj.Map.One;
import jj.blocks.RegSquare;
import jj.customize.customizeCharacter;
import jj.customize.customizeLevel;
import jj.customize.customizeScreen;

public class Driver extends JFrame implements Runnable, KeyListener, MouseListener, MouseMotionListener
{
	Container con = getContentPane();
	Thread t = new Thread(this);
	private static Player player;
	private static int currentMap;
	private static boolean mainScreen=true,levelScreen=false,playLevel=false,custScreen=false,custCharScreen=false,custLevScreen=false;
	private static boolean playClick=false,custClick=false,oneClick=false,twoClick=false,threeClick=false,fourClick=false,fiveClick=false,sixClick=false;
	private  One mapOne;
	private MapOne one;
	private static boolean deathScreen=false,winScreen=false;
	private  customizeScreen cScreen;
	private customizeCharacter cCustScreen;
	private customCharacters cc;
	private static customizeLevel custLev;
	private static MapNumber mapNum=new MapNumber();
	private static boolean changeHelper=false,changeHelper2=false;
	public static int type=1;

	int lk;
	int xx=35;
	ArrayList<RegSquare>reg=new ArrayList<RegSquare>();

    public Driver()
    {
	    addKeyListener(this);
	    addMouseListener(this);
	    addMouseMotionListener(this);
	    con.setLayout(new FlowLayout());
	    mapOne=new One();
	    one=new MapOne();
	    cScreen=new customizeScreen();
	    cCustScreen=new customizeCharacter();
	    player=new Player();
	    cc=new customCharacters();
	    custLev=new customizeLevel();
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    t.start();
    }
    
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyPressed(KeyEvent e) {
		if(playLevel)
		{
			if(e.getKeyChar()==32)
			{
				player.jump(true); 
			//	System.out.println("start");
			}
			if(e.getKeyCode()==79)
			{
				if(xx==35)
				xx=550;
				else if(xx==550)
					xx=20;
				else if(xx==20)
					xx=35;
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if(playLevel)
		{
			if(e.getKeyChar()==32)
			{
				player.jump(false);
			}
		}
	}
	
	public void mouseClicked(MouseEvent j) {
		if(playLevel)
		{
			if(deathScreen==true)
			{
				if(Images.getRetryRect().contains(j.getPoint()))
				{
					mapOne.retry();
				}
				if(Images.getMainRect().contains(j.getPoint()))
				{
					//mapOne.retry();
					mapOne.retry();
					playLevel=false;
					mainScreen=true;
				}
			}
			if(winScreen==true)
			{
				if(Images.getRetryRect().contains(j.getPoint()))
				{
					mapOne.retry();
					winScreen=false;
				}
				if(Images.getMainRect().contains(j.getPoint()))
				{
					//mapOne.retry();
					mapOne.retry();
					playLevel=false;
					winScreen=false;
					mainScreen=true;
				}
			}
		}
	}
	public void mousePressed(MouseEvent e) {
		if(mainScreen)
		{
		if(Images.getCustRect().contains(e.getPoint()))
			{
				custClick=true;
			}
			else
			{
				custClick=false;
			}
			if(Images.getPlayRect().contains(e.getPoint()))
			{
				playClick=true;
			}
			else{
				playClick=false;
			}
		}
		if(custCharScreen)
		{
			Rectangle temp[][]=cCustScreen.getPlaces();
			if(type==1)
			{
			for(int i=0;i<temp.length;i++)
			{
				for(int ii=0;ii<temp[i].length;ii++)
				{
					if(cCustScreen.getPencil().contains(temp[i][ii])||cCustScreen.getPencil().intersects(temp[i][ii]))
					{
						cCustScreen.setBlock((int)temp[i][ii].getMinX(),(int) temp[i][ii].getMinY());
					}
					}
				}
			}
			if(type==0)
			{
			for(int i=0;i<temp.length;i++)
			{
				for(int ii=0;ii<temp[i].length;ii++)
				{
					if(cCustScreen.getPencil().contains(temp[i][ii])||cCustScreen.getPencil().intersects(temp[i][ii]))
					{
						cCustScreen.delete((int)temp[i][ii].getMinX(),(int) temp[i][ii].getMinY());
					}
					}
				}
			}
			
		}
		
		if(levelScreen)
		{
			if(Images.getOne().contains(e.getPoint()))
			{
				oneClick=true;
			}
			if(Images.getTwo().contains(e.getPoint()))
			{
				twoClick=true;
				JOptionPane.showMessageDialog(null, "Only map one is done");
			}
			if(Images.getThree().contains(e.getPoint()))
			{
				threeClick=true;
				JOptionPane.showMessageDialog(null, "Only map one is done");
			}
			if(Images.getFour().contains(e.getPoint()))
			{
				fourClick=true;
				JOptionPane.showMessageDialog(null, "Only map one is done");
			}
			if(Images.getFive().contains(e.getPoint()))
			{
				fiveClick=true;
				JOptionPane.showMessageDialog(null, "Only map one is done");
			}
			if(Images.getSix().contains(e.getPoint()))
			{
				sixClick=true;
				JOptionPane.showMessageDialog(null, "Only map one is done");
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		
		if(custScreen)
		{
			if(cScreen.getChar().contains(e.getPoint()))
			{
				custScreen=false;
				custCharScreen=true;
			}
			if(cScreen.getLev().contains(e.getPoint()))
			{
				custLev.setCharacter();
				player.setCharacter(custLev.getChara());
			}
			if(cScreen.getBack().contains(e.getPoint()))
			{
				custScreen=false;
				changeHelper=true;
				//mainScreen=true;
				//System.out.println("gg");
			}
		}
		if(custCharScreen)
		{
			if(cCustScreen.getChangeC().contains(e.getPoint()))
			{
				cCustScreen.setColor();
			}
			if(cCustScreen.getSizeRect().contains(e.getPoint()))
			{
				cCustScreen.changeSize();;
			}
			if(cCustScreen.getSave().contains(e.getPoint()))
			{
				cCustScreen.saveRect();
				cCustScreen.resetTest();
			}
			if(cCustScreen.getErase().contains(e.getPoint()))
			{
				type=0;
				//cCustScreen.saveRect();
			}
			if(cCustScreen.getDraw().contains(e.getPoint()))
			{
				type=1;
				//cCustScreen.saveRect();
			}
			if(cCustScreen.getBack().contains(e.getPoint()))
			{
				custCharScreen=false;
				custScreen=true;
				//cCustScreen.saveRect();
			}
			
		}
		if(levelScreen)
		{
			if(Images.getOne().contains(e.getPoint()))
			{
				levelScreen=false;
				playLevel=true;
				currentMap=1;
				//System.out.println("dfg");
			}
			if(Images.getTwo().contains(e.getPoint()))
			{
				levelScreen=false;
				playLevel=true;
				currentMap=2;
			}
			if(Images.getThree().contains(e.getPoint()))
			{
				levelScreen=false;
				playLevel=true;
				currentMap=3;
			}
			if(Images.getFour().contains(e.getPoint()))
			{
				levelScreen=false;
				playLevel=true;
				currentMap=4;
			}
			if(Images.getFive().contains(e.getPoint()))
			{
				levelScreen=false;
				playLevel=true;
				currentMap=5;
			}
			if(Images.getSix().contains(e.getPoint()))
			{
				levelScreen=false;
				playLevel=true;
				currentMap=6;
			}
		}
		
		if(mainScreen)
		{
		if(Images.getCustRect().contains(e.getPoint()))
		{
			custScreen=true;
			mainScreen=false;
			//System.out.println("hi");
			//new customizeScreen();
		}
		if(Images.getPlayRect().contains(e.getPoint()))
		{
			mainScreen=false;
			levelScreen=true;
		}
		}
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		if(custCharScreen)
		{
			cCustScreen.setRect(e.getX(),e.getY());
			Rectangle temp[][]=cCustScreen.getPlaces();
			if(type==1)
			{
			for(int i=0;i<temp.length;i++)
			{
				for(int ii=0;ii<temp[i].length;ii++)
				{
					if(cCustScreen.getPencil().contains(temp[i][ii])||cCustScreen.getPencil().intersects(temp[i][ii]))
					{
						cCustScreen.setBlock((int)temp[i][ii].getMinX(),(int) temp[i][ii].getMinY());
					}
					}
				}
			}
			if(type==0)
			{
			for(int i=0;i<temp.length;i++)
			{
				for(int ii=0;ii<temp[i].length;ii++)
				{
					if(cCustScreen.getPencil().contains(temp[i][ii])||cCustScreen.getPencil().intersects(temp[i][ii]))
					{
						cCustScreen.delete((int)temp[i][ii].getMinX(),(int) temp[i][ii].getMinY());
					}
					}
				}
			}
		}
		
	}


	public void mouseMoved(MouseEvent e) {
	if(custCharScreen)
	{

		cCustScreen.setRect(e.getX(),e.getY());

	}
		
	}
	
	public int getMapNumber()
	{
		return currentMap;
	}
	
	public static void isDead(boolean isDead)
	{
		deathScreen=isDead;
	}
	
	public static void isWon(boolean isWon)
	{
		winScreen=isWon;
	}
    
    public void run()
    {
    try{
        while(true)
            {
            t.sleep(xx);
            if(changeHelper)
            {
            	changeHelper=false;
            	mainScreen=true;
            }
          //  reg=one.getReg();
           // System.out.println(mainScreen);
            if(mainScreen)
            {
            	
            }
            //optimize this later
           if(levelScreen)
           {
        	   
           }
           if(custCharScreen)
           {
        	 //  System.out.println(lk);
           }
           if(playLevel)
           {
        	   mapNum.setMapNumber(currentMap);
            if(currentMap==1)
            {
            	//System.out.println("hi");
            	mapOne.run();
            }
            else if(currentMap==2)
            {
            	
            }
            else if(currentMap==3)
            {
            	
            }
            else if(currentMap==4)
            {
            	
            }
            else if(currentMap==5)
            {
            	
            }
           }
            repaint();
            }
        }
    catch(Exception e)
        {
        e.printStackTrace();
        }
    }
    public void paint(Graphics gr)
    {
    Image i=createImage(getSize().width, getSize().height);
    Graphics2D g = (Graphics2D)i.getGraphics();
   // g.translate(player.getX(), player.getY());
    
    if(mainScreen)
    {
    	g.drawImage(Images.getHomeScreen(),0,0,this);
    	g.setColor(Color.black);
    	//g.draw(Images.getCustRect());
    	if(playClick)
    	g.drawOval(110, 280, 100, 100);
    	if(custClick)
    	g.drawOval(290, 280, 100, 100);
    }
    if(levelScreen)
    {
    	g.drawImage(Images.getLevelSelect(),0,0,this);
    	if(oneClick)
    	g.drawRect(30, 110, 100, 100);
    	if(twoClick)
    	g.drawRect(200, 110, 100, 100);
    	if(threeClick)
    	g.drawRect(370, 110, 100, 100);
    	if(fourClick)
    	g.drawRect(30, 315, 100, 100);
    	if(fiveClick)
    	g.drawRect(200, 315, 100, 100);
    	if(sixClick)
    	g.drawRect(370, 315, 100, 100);
    }
    if(custScreen)
    {
    	cScreen.draw(g);
    }
    if(custCharScreen)
    {
    	cCustScreen.draw(g);
    }
    if(playLevel)
    {
    if(currentMap==1)
    	mapOne.draw(g);
    player.draw(g);
    if(deathScreen)
    {
    	//g.draw(Images.getMainRect());
    	//Images.draw(g);
    //	g.drawImage(onDeath,0,0,this);
    	g.drawImage(Images.getOnDeath(),0,0,this);
    	//g.fillRect(0,0,500,500);
    }
    else if(winScreen)
    {
    	g.drawImage(Images.getOnWin(),0,0,this);
    	//System.out.println("hi");
    }
    }
    //cc.drawOne(g);
    g.dispose();
    gr.drawImage(i, 0, 0, this);
    }
    public static void main(String[] args)
    {
    Driver frame = new Driver();
    frame.setSize(500, 500);
    frame.setVisible(true);
    }
    public void update(Graphics g)
    {
        paint(g);
    }

	
	
}