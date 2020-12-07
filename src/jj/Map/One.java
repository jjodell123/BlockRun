package jj.Map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import jj.Driver;
import jj.Grid;
import jj.Player;
import jj.blocks.Activator;
import jj.blocks.BottomLeftSquare;
import jj.blocks.BottomRightSquare;
import jj.blocks.BottomSquare;
import jj.blocks.MiddleLeftSquare;
import jj.blocks.MiddleRightSquare;
import jj.blocks.MiddleSquare;
import jj.blocks.RegHalfBlock;
import jj.blocks.RegSquare;
import jj.blocks.RegTriangle;
import jj.blocks.Teleporter;
import jj.blocks.TopLeftSquare;
import jj.blocks.TopRightSquare;
import jj.blocks.TopSquare;

public class One {
	
	private static Grid theGrid;
	
	private static int x[],y[];
	
	private static int intersected,lastIndex;
	
	private static String lastType;
	
	private static int moveSpeed,jumpTime=0,fallTime=0;
	
	private static boolean godMode=false;                 
	
	public static int startY;
	
	private static boolean isJumping, preformJump=false,stopJump=false, isFalling=false,stopFall=false,screenMove=false, fallTester=false;
	
	private static boolean resetAid=false;
	
	private static Player player=new Player();
	
	private static ArrayList <RegSquare> reg=new ArrayList<RegSquare>();
	private static ArrayList <RegTriangle> regT=new ArrayList<RegTriangle>();
	private static ArrayList <RegHalfBlock> regH=new ArrayList<RegHalfBlock>(); 
	private static ArrayList <BottomLeftSquare> BLS=new ArrayList<BottomLeftSquare>(); 
	private static ArrayList <BottomRightSquare> BRS=new ArrayList<BottomRightSquare>(); 
	private static ArrayList <BottomSquare> BS=new ArrayList<BottomSquare>(); 
	private static ArrayList <MiddleLeftSquare> MLS=new ArrayList<MiddleLeftSquare>(); 
	private static ArrayList <MiddleRightSquare> MRS=new ArrayList<MiddleRightSquare>(); 
	private static ArrayList <MiddleSquare> MS=new ArrayList<MiddleSquare>(); 
	private static ArrayList <TopLeftSquare> TLS=new ArrayList<TopLeftSquare>(); 
	private static ArrayList <TopRightSquare> TRS=new ArrayList<TopRightSquare>(); 
	private static ArrayList <TopSquare> TS=new ArrayList<TopSquare>(); 
	private static ArrayList <Activator> act=new ArrayList<Activator>();
	private static ArrayList <Teleporter> tel=new ArrayList<Teleporter>();
	private static ArrayList <Boolean> actUsed=new ArrayList<Boolean>();
	
	private static boolean hasDied=false,hasWon=false;

	private static MapOne map;
	
	private static Color backGround;
	
	
	public One()
	{
		
		map= new MapOne();
		theGrid=new Grid(200,50);
		x=theGrid.getGridX();
		y=theGrid.getGridY();theGrid=new Grid(200,50);
		reg=map.getReg();
		regT=map.getRegT();
		regH=map.getRegH();
		BLS=map.getBLS();
		BS=map.getBS();
		BRS=map.getBRS();
		MLS=map.getMLS();
		MS=map.getMS();
		MRS=map.getMRS();
		TLS=map.getTLS();
		TS=map.getTS();
		TRS=map.getTRS();
		act=map.getAct();
		tel=map.getTel();
		for(int i=0;i<act.size();i++)
		{
			actUsed.add(false);
		}
		moveSpeed= -5;
		startY=y[9];
		backGround=new Color(100,0,170);
		//retry();
	}
	
	//runs map one
	public static void run()
	{
	//	while the player is alive
		if(!hasDied && !hasWon)
		{
			//if it passes an activator
			actTest();
			telTest();
			testPlayerY();
			testScreenMove();
			makeFall();
			makeJump();
			testDeath();
			testFall();
			moveObjects();
			testBounds();
		}
		else if(hasWon)
		{
			Driver.isWon(true);
		}
		else
	    {
	    	Driver.isDead(true);
	   	}
	    	
	    	

	    		
	    		
	    		//System.out.println(x.length);
	           
	}
	
	public static void actTest()
	{
		for(int i=0;i<act.size();i++){
	
		if((player.getWholePlayerRect().intersects(act.get(i).getActRect()) || player.getWholePlayerRect().contains(act.get(i).getActRect())) && !actUsed.get(i))
		{
			act.get(i).delete();
			actUsed.set(i, true);
			
			//sss=1;
		}
	}
	}
	public static void telTest()
	{
	for(int ii=0;ii<tel.size();ii++){
		if((player.getWholePlayerRect().intersects(tel.get(ii).getTelRect()) || player.getWholePlayerRect().contains(tel.get(ii).getTelRect())))
		{
			player.setY(tel.get(ii).getTelY());
			player.setRecLoc();
		}
		for(int i=0;i<reg.size();i++)
		{
			//System.out.println("hi");
			//if(player.getPlayerTelRect().intersects(reg.get(i).getRegRect()))
			while(reg.get(i).getRegRect().contains(player.getPlayerTelRect())||reg.get(i).getRegRect().intersects(player.getPlayerTelRect()))
				{
					//if()
				int temp=player.getY();
				player.setY(reg.get(i).getY()-30);
				player.setRecLoc();
				//System.out.println(player.getY()+" "+reg.get(i).getY());
				for(int iii=0;iii<reg.size();iii++)
				{
				if(reg.get(iii).getRegRect().contains(player.getWholePlayerRect())||reg.get(iii).getRegRect().intersects(player.getWholePlayerRect()))
				{
					player.setY(temp);
					player.setRecLoc();
					//System.out.println(temp);
				}
				}
				player.setRecLoc();
				moveObjects();
				}
		}
	for(int i=0;i<regH.size();i++)
	{
		while(regH.get(i).getRegHRect().contains(player.getPlayerTelRect())||regH.get(i).getRegHRect().intersects(player.getPlayerTelRect()))
				{
			int temp=player.getY();
			player.setY(regH.get(i).getY()-30);
			player.setRecLoc();
			//System.out.println(player.getY()+" "+reg.get(i).getY());
			for(int iii=0;iii<regH.size();iii++)
			{
			if(regH.get(iii).getRegHRect().contains(player.getWholePlayerRect())||regH.get(iii).getRegHRect().intersects(player.getWholePlayerRect()))
			{
				player.setY(temp);
				player.setRecLoc();
				//System.out.println(temp);
			}
			}
			player.setRecLoc();
			moveObjects();

				}
	}
	for(int i=0;i<BLS.size();i++)
	{
		while(BLS.get(i).getBLRect().contains(player.getPlayerTelRect())||BLS.get(i).getBLRect().intersects(player.getPlayerTelRect()))
		{
			int temp=player.getY();
			player.setY(BLS.get(i).getY()-30);
			player.setRecLoc();
			//System.out.println(player.getY()+" "+reg.get(i).getY());
			for(int iii=0;iii<BLS.size();iii++)
			{
			if(BLS.get(iii).getBLRect().contains(player.getWholePlayerRect())||BLS.get(iii).getBLRect().intersects(player.getWholePlayerRect()))
			{
				player.setY(temp);
				player.setRecLoc();
				//System.out.println(temp);
			}
			}
			player.setRecLoc();
			moveObjects();

		}
	}
	for(int i=0;i<BRS.size();i++)
	{
		while(BRS.get(i).getBRRect().contains(player.getPlayerTelRect())||BRS.get(i).getBRRect().intersects(player.getPlayerTelRect()))
		{
			int temp=player.getY();
			player.setY(BRS.get(i).getY()-30);
			player.setRecLoc();
			//System.out.println(player.getY()+" "+reg.get(i).getY());
			for(int iii=0;iii<BRS.size();iii++)
			{
			if(BRS.get(iii).getBRRect().contains(player.getWholePlayerRect())||BRS.get(iii).getBRRect().intersects(player.getWholePlayerRect()))
			{
				player.setY(temp);
				player.setRecLoc();
				//System.out.println(temp);
			}
			}
			player.setRecLoc();
			moveObjects();
		}
	}
	for(int i=0;i<BS.size();i++)
	{
		while(BS.get(i).getBSRect().contains(player.getPlayerTelRect())||BS.get(i).getBSRect().intersects(player.getPlayerTelRect()))
		{
			int temp=player.getY();
			player.setY(BS.get(i).getY()-30);
			player.setRecLoc();
			//System.out.println(player.getY()+" "+reg.get(i).getY());
			for(int iii=0;iii<BS.size();iii++)
			{
			if(BS.get(iii).getBSRect().contains(player.getWholePlayerRect())||BS.get(iii).getBSRect().intersects(player.getWholePlayerRect()))
			{
				player.setY(temp);
				player.setRecLoc();
				//System.out.println(temp);
			}
			}
			player.setRecLoc();
			moveObjects();
		}
	}
	for(int i=0;i<MLS.size();i++)
	{
		while(MLS.get(i).getMLRect().contains(player.getPlayerTelRect())|MLS.get(i).getMLRect().intersects(player.getPlayerTelRect()))
		{
			int temp=player.getY();
			player.setY(MLS.get(i).getY()-30);
			player.setRecLoc();
			//System.out.println(player.getY()+" "+reg.get(i).getY());
			for(int iii=0;iii<MLS.size();iii++)
			{
			if(MLS.get(iii).getMLRect().contains(player.getWholePlayerRect())||MLS.get(iii).getMLRect().intersects(player.getWholePlayerRect()))
			{
				player.setY(temp);
				player.setRecLoc();
				//System.out.println(temp);
			}
			}
			player.setRecLoc();
			moveObjects();
		}
	}
	for(int i=0;i<MRS.size();i++)
	{
		while(MRS.get(i).getMRRect().contains(player.getPlayerTelRect())||MRS.get(i).getMRRect().intersects(player.getPlayerTelRect()))
		{
			int temp=player.getY();
			player.setY(MRS.get(i).getY()-30);
			player.setRecLoc();
			//System.out.println(player.getY()+" "+reg.get(i).getY());
			for(int iii=0;iii<MRS.size();iii++)
			{
			if(MRS.get(iii).getMRRect().contains(player.getWholePlayerRect())||MRS.get(iii).getMRRect().intersects(player.getWholePlayerRect()))
			{
				player.setY(temp);
				player.setRecLoc();
				//System.out.println(temp);
			}
			}
			player.setRecLoc();
			moveObjects();
		}
	}
	for(int i=0;i<MS.size();i++)
	{
		while(MS.get(i).getMSRect().contains(player.getPlayerTelRect())||MS.get(i).getMSRect().intersects(player.getPlayerTelRect()))
		{
			int temp=player.getY();
			player.setY(MS.get(i).getY()-30);
			player.setRecLoc();
			//System.out.println(player.getY()+" "+reg.get(i).getY());
			for(int iii=0;iii<MS.size();iii++)
			{
			if(MS.get(iii).getMSRect().contains(player.getWholePlayerRect())||MS.get(iii).getMSRect().intersects(player.getWholePlayerRect()))
			{
				player.setY(temp);
				player.setRecLoc();
				//System.out.println(temp);
			}
			}
			player.setRecLoc();
			moveObjects();
		}
	}
	for(int i=0;i<TLS.size();i++)
	{
		while(TLS.get(i).getTLRect().contains(player.getPlayerTelRect())||TLS.get(i).getTLRect().intersects(player.getPlayerTelRect()))
		{
			int temp=player.getY();
			player.setY(TLS.get(i).getY()-30);
			player.setRecLoc();
			//System.out.println(player.getY()+" "+reg.get(i).getY());
			for(int iii=0;iii<TLS.size();iii++)
			{
			if(TLS.get(iii).getTLRect().contains(player.getWholePlayerRect())||TLS.get(iii).getTLRect().intersects(player.getWholePlayerRect()))
			{
				player.setY(temp);
				player.setRecLoc();
				//System.out.println(temp);
			}
			}
			player.setRecLoc();
			moveObjects();
		}
	}
	for(int i=0;i<TRS.size();i++)
	{
		while(TRS.get(i).getTRRect().contains(player.getPlayerTelRect())||TRS.get(i).getTRRect().intersects(player.getPlayerTelRect()))
		{
			int temp=player.getY();
			player.setY(TRS.get(i).getY()-30);
			player.setRecLoc();
			//System.out.println(player.getY()+" "+reg.get(i).getY());
			for(int iii=0;iii<TRS.size();iii++)
			{
			if(TRS.get(iii).getTRRect().contains(player.getWholePlayerRect())||TRS.get(iii).getTRRect().intersects(player.getWholePlayerRect()))
			{
				player.setY(temp);
				player.setRecLoc();
				//System.out.println(temp);
			}
			}
			player.setRecLoc();
			moveObjects();
		}
	}
	for(int i=0;i<TS.size();i++)
	{
		while(TS.get(i).getTSRect().contains(player.getPlayerTelRect())||TS.get(i).getTSRect().intersects(player.getPlayerTelRect()))
		{
			int temp=player.getY();
			player.setY(TS.get(i).getY()-30);
			player.setRecLoc();
			//System.out.println(player.getY()+" "+reg.get(i).getY());
			for(int iii=0;iii<TS.size();iii++)
			{
			if(TS.get(iii).getTSRect().contains(player.getWholePlayerRect())||TS.get(iii).getTSRect().intersects(player.getWholePlayerRect()))
			{
				player.setY(temp);
				player.setRecLoc();
				//System.out.println(temp);
			}
			}
			player.setRecLoc();
			moveObjects();
		}
	}
			//actUsed.set(i, true);
			
			//sss=1;
		}
	}
	
	
	public static void testPlayerY()
	{
		if(player.getY()<=70)
		{
			
			screenMove=true;
			player.counterFall(true);
		//	player.fall(105);
			int counter=player.getFallSpeed();
			//System.out.println(counter+"sd");
		//	System.out.println(counter+" "+player.getRealY()+" "+player.getFallSpeed());
			if(resetAid)
			{
				
				counter=player.getY()-100;
				if(counter<0)
					counter*=-1;
				//player.setY(counter);
				//System.out.println("sdfg");
				
			}
			resetAid=false;
			for(int i=0;i<y.length;i++)
				y[i]+=counter;
			
			doScreenMove(counter);
			//System.out.println(counter);
		}
			 
	if(player.getY()>=370)
	{
		
			
		screenMove=true;
		//System.out.println(resetAid);
		player.counterFall(true);
	//	player.fall(105);
		int counter=player.getFallSpeed();
		
		
		if(resetAid)
		{
			
			counter=player.getY()-350;
			
			
			
		}
		//System.out.println(counter+"1");
		if(counter>0)
			counter*=-1;
		if(counter<-25)
		{
			counter=-25;
		//System.out.println("hi");
		}
		//System.out.println(counter+"sdq");
		resetAid=false;
		for(int i=0;i<y.length;i++)
			y[i]+=counter;
		doScreenMove(counter);
		//System.out.println();
		
		//System.out.println(counter);
	}
	}
	
	public static void doScreenMove(int counter)
	{
		//player.setY(player.getY()+counter);
		//stopFall=true;
		//doStopFall();
for(int i=0;i<reg.size();i++)
			
	
		{
			reg.get(i).screenIsMoving(counter);
			//System.out.println(counter);
		}
		for(int i=0;i<regT.size();i++)
		{
			regT.get(i).screenIsMoving(counter);
		}
		for(int i=0;i<regH.size();i++)
		{
			regH.get(i).screenIsMoving(counter);
		}
		for(int i=0;i<BLS.size();i++)
		{
			BLS.get(i).screenIsMoving(counter);
		}
		for(int i=0;i<BS.size();i++)
		{
			BS.get(i).screenIsMoving(counter);
		}
		for(int i=0;i<BRS.size();i++)
		{
			BRS.get(i).screenIsMoving(counter);
		}
		for(int i=0;i<MRS.size();i++)
		{
			MRS.get(i).screenIsMoving(counter);
		}
		for(int i=0;i<MS.size();i++)
		{
			MS.get(i).screenIsMoving(counter);
		}
		for(int i=0;i<MLS.size();i++)
		{
			MLS.get(i).screenIsMoving(counter);
		}
		for(int i=0;i<TLS.size();i++)
		{
			TLS.get(i).screenIsMoving(counter);
		}
		for(int i=0;i<TS.size();i++)
		{
			TS.get(i).screenIsMoving(counter);
		}
		for(int i=0;i<TRS.size();i++)
		{
			TRS.get(i).screenIsMoving(counter);
		}
		for(int i=0;i<act.size();i++)
		{
			act.get(i).screenIsMoving(counter);
		}
		for(int i=0;i<tel.size();i++)
		{
			tel.get(i).screenIsMoving(counter);
		}
	}
	
	public static void testScreenMove()
	{
		for(int i=0; i<reg.size();i++)
		{
			if(screenMove && (player.getWholePlayerRect().intersects(reg.get(i).getRegRect()) || (player.getPlayerBeneathRect().intersects(reg.get(i).getRegRect()) ||  player.getPlayerBeneathRect().contains(reg.get(i).getRegRect()))))
			{
				//System.out.println("hi12");
				intersected=reg.get(i).getY()-30;
				resetScreenMove();
				//resetAid=false;
			 //	System.out.println("hi");
			//	player.counterFall(false);
				
			}
		}
		for(int i=0; i<regH.size();i++)
		{
			if(screenMove && (player.getWholePlayerRect().intersects(regH.get(i).getRegHRect()) || (player.getPlayerBeneathRect().intersects(regH.get(i).getRegHRect()) ||  player.getPlayerBeneathRect().contains(regH.get(i).getRegHRect()))))
			{
				//System.out.println("hi12");
				intersected=regH.get(i).getY()-30;
				resetScreenMove();
			// 	System.out.println("hi");
			//	player.counterFall(false);
				
			}
		}
		for(int i=0; i<TS.size();i++)
		{
			if(screenMove && (player.getWholePlayerRect().intersects(TS.get(i).getTSRect()) || (player.getPlayerBeneathRect().intersects(TS.get(i).getTSRect()) ||  player.getPlayerBeneathRect().contains(TS.get(i).getTSRect()))))
			{
				//System.out.println("hi12");
				intersected=TS.get(i).getY()-30;
				resetScreenMove();
			// 	System.out.println("hi");
			//	player.counterFall(false);
				
			}
		}
		for(int i=0; i<TRS.size();i++)
		{
			if(screenMove && (player.getWholePlayerRect().intersects(TRS.get(i).getTRRect()) || (player.getPlayerBeneathRect().intersects(TRS.get(i).getTRRect()) ||  player.getPlayerBeneathRect().contains(TRS.get(i).getTRRect()))))
			{
				//System.out.println("hi12");
				intersected=TRS.get(i).getY()-30;
				resetScreenMove();
			// 	System.out.println("hi");
			//	player.counterFall(false);
				
			}
		}
		for(int i=0; i<TLS.size();i++)
		{
			if(screenMove && (player.getWholePlayerRect().intersects(TLS.get(i).getTLRect()) || (player.getPlayerBeneathRect().intersects(TLS.get(i).getTLRect()) ||  player.getPlayerBeneathRect().contains(TLS.get(i).getTLRect()))))
			{
				//System.out.println("hi12");
				intersected=TLS.get(i).getY()-30;
				resetScreenMove();
			// 	System.out.println("hi");
			//	player.counterFall(false);
				
			}
		}
		for(int i=0; i<MS.size();i++)
		{
			if(screenMove && (player.getWholePlayerRect().intersects(MS.get(i).getMSRect()) || (player.getPlayerBeneathRect().intersects(MS.get(i).getMSRect()) ||  player.getPlayerBeneathRect().contains(MS.get(i).getMSRect()))))
			{
				//System.out.println("hi12");
				intersected=MS.get(i).getY()-30;
				resetScreenMove();
			// 	System.out.println("hi");
			//	player.counterFall(false);
				
			}
		}
		for(int i=0; i<MRS.size();i++)
		{
			if(screenMove && (player.getWholePlayerRect().intersects(MRS.get(i).getMRRect()) || (player.getPlayerBeneathRect().intersects(MRS.get(i).getMRRect()) ||  player.getPlayerBeneathRect().contains(MRS.get(i).getMRRect()))))
			{
				//System.out.println("hi12");
				intersected=MRS.get(i).getY()-30;
				resetScreenMove();
			// 	System.out.println("hi");
			//	player.counterFall(false);
				
			}
		}
		for(int i=0; i<MLS.size();i++)
		{
			if(screenMove && (player.getWholePlayerRect().intersects(MLS.get(i).getMLRect()) || (player.getPlayerBeneathRect().intersects(MLS.get(i).getMLRect()) ||  player.getPlayerBeneathRect().contains(MLS.get(i).getMLRect()))))
			{
				//System.out.println("hi12");
				intersected=MLS.get(i).getY()-30;
				resetScreenMove();
			// 	System.out.println("hi");
			//	player.counterFall(false);
				
			}
		}
		for(int i=0; i<BS.size();i++)
		{
			if(screenMove && (player.getWholePlayerRect().intersects(BS.get(i).getBSRect()) || (player.getPlayerBeneathRect().intersects(BS.get(i).getBSRect()) ||  player.getPlayerBeneathRect().contains(BS.get(i).getBSRect()))))
			{
				//System.out.println("hi12");
				intersected=BS.get(i).getY()-30;
				resetScreenMove();
			// 	System.out.println("hi");
			//	player.counterFall(false);
				
			}
		}
		for(int i=0; i<BRS.size();i++)
		{
			if(screenMove && (player.getWholePlayerRect().intersects(BRS.get(i).getBRRect()) || (player.getPlayerBeneathRect().intersects(BRS.get(i).getBRRect()) ||  player.getPlayerBeneathRect().contains(BRS.get(i).getBRRect()))))
			{
				//System.out.println("hi12");
				intersected=BRS.get(i).getY()-30;
				resetScreenMove();
			// 	System.out.println("hi");
			//	player.counterFall(false);
				
			}
		}
		for(int i=0; i<BLS.size();i++)
		{
			if(screenMove && (player.getWholePlayerRect().intersects(BLS.get(i).getBLRect()) || (player.getPlayerBeneathRect().intersects(BLS.get(i).getBLRect()) ||  player.getPlayerBeneathRect().contains(BLS.get(i).getBLRect()))))
			{
				//System.out.println("hi12");
				intersected=BLS.get(i).getY()-30;
				resetScreenMove();
			// 	System.out.println("hi");
			//	player.counterFall(false);
				
			}
		}
	}
	
	public static void makeFall()
	{
		if(isFalling && !stopFall)
		{
	//	System.out.println("dfg");
			fallTime+=5;
			player.fall(fallTime);                 
			player.setRecLoc();
			
			for(int i=0;i<reg.size();i++)
			{
				if(player.getPlayerRect().intersects(reg.get(i).getRegRect()))
				{
					stopFall=true;
					intersected=(reg.get(i).getY())-30;
				//	System.out.println("ff");
					//player.setY(yy);
				}
			}
			for(int i=0;i<regH.size();i++)
			{
				if(player.getPlayerRect().intersects(regH.get(i).getRegHRect()))
				{
					stopFall=true;
				//	System.out.println("123");

					intersected=(regH.get(i).getY())-30;
					//player.setY(yy);
				}
			}
			for(int i=0;i<BLS.size();i++)
			{
				if(player.getPlayerRect().intersects(BLS.get(i).getBLRect()))
				{
					stopFall=true;//	System.out.println("123");

					intersected=(BLS.get(i).getY())-30;
					//player.setY(yy);
				}
			}
			for(int i=0;i<BS.size();i++)
			{
				if(player.getPlayerRect().intersects(BS.get(i).getBSRect()))
				{	//System.out.println("123");

					stopFall=true;
					intersected=(BS.get(i).getY())-30;
					//player.setY(yy);
				}
			}
			for(int i=0;i<BRS.size();i++)
			{
				if(player.getPlayerRect().intersects(BRS.get(i).getBRRect()))
				{	//System.out.println("123");

					stopFall=true;
					intersected=(BRS.get(i).getY())-30;
					//player.setY(yy);
				}
			}
			for(int i=0;i<MLS.size();i++)
			{
				if(player.getPlayerRect().intersects(MLS.get(i).getMLRect()))
				{	//System.out.println("123");

					stopFall=true;
					intersected=(MLS.get(i).getY())-30;
					//player.setY(yy);
				}
			}
			for(int i=0;i<MS.size();i++)
			{
				if(player.getPlayerRect().intersects(MS.get(i).getMSRect()))
				{	//System.out.println("123");

					stopFall=true;
					intersected=(MS.get(i).getY())-30;
					//player.setY(yy);
				}
			}
			for(int i=0;i<MRS.size();i++)
			{
				if(player.getPlayerRect().intersects(MRS.get(i).getMRRect()))
				{	//System.out.println("123");

					stopFall=true;
					intersected=(MRS.get(i).getY())-30;
					//player.setY(yy);
				}
			}
			for(int i=0;i<TLS.size();i++)
			{
				if(player.getPlayerRect().intersects(TLS.get(i).getTLRect()))
				{	//System.out.println("123");

					stopFall=true;
					intersected=(TLS.get(i).getY())-30;
					//player.setY(yy);
				}
			}
			for(int i=0;i<TS.size();i++)
			{
				if(player.getPlayerRect().intersects(TS.get(i).getTSRect()))
				{	//System.out.println("123");

					stopFall=true;
					intersected=(TS.get(i).getY())-30;
					//player.setY(yy);
				}
			}
			for(int i=0;i<TRS.size();i++)
			{
				if(player.getPlayerRect().intersects(TRS.get(i).getTRRect()))
				{	//System.out.println("123");

					stopFall=true;
					intersected=(TRS.get(i).getY())-30;
					//player.setY(yy);
				}
			}
		}
			doStopFall();
	}
	
	public static void doStopFall()
	{
		if(stopFall)
		{
			isFalling=false;
			stopFall=false;
			fallTime=0;
			player.setY(intersected);
		//	System.out.println("i");
			player.setRecLoc();
		
		}
	}
	
	public static void makeJump()
	{
		
		//starts the jump
			if(isJumping && preformJump==false && !isFalling &&!screenMove)
			{
				preformJump=true;
			}
			if(preformJump && !stopJump && isFalling==false)
			{
				jumpTime+=5;
				player.jump(jumpTime);
				player.setRecLoc();
				for(int i=0;i<reg.size();i++)
				{
					if(player.getPlayerRect().intersects(reg.get(i).getRegRect()))
					{
						stopJump=true;
						intersected=(reg.get(i).getY())-30;
						//player.setY(yy);
					}
				}
				for(int i=0;i<regH.size();i++)
				{
					if(player.getPlayerBeneathRect().intersects(regH.get(i).getRegHRect()))
					{
						stopJump=true;
						intersected=(regH.get(i).getY())-30;
						//player.setY(yy);
					}
				}
				for(int i=0;i<BLS.size();i++)
				{
					if(player.getPlayerRect().intersects(BLS.get(i).getBLRect()))
					{
						stopJump=true;
						intersected=(BLS.get(i).getY())-30;
						//player.setY(yy);
					}
				}
				for(int i=0;i<BS.size();i++)
				{
					if(player.getPlayerRect().intersects(BS.get(i).getBSRect()))
					{
						stopJump=true;
						intersected=(BS.get(i).getY())-30;
						//player.setY(yy);
					}
				}
				for(int i=0;i<BRS.size();i++)
				{
					if(player.getPlayerRect().intersects(BRS.get(i).getBRRect()))
					{
						stopJump=true;
						intersected=(BRS.get(i).getY())-30;
						//player.setY(yy);
					}
				}
				for(int i=0;i<MLS.size();i++)
				{
					if(player.getPlayerRect().intersects(MLS.get(i).getMLRect()))
					{
						stopJump=true;
						intersected=(MLS.get(i).getY())-30;
						//player.setY(yy);
					}
				}
				for(int i=0;i<MS.size();i++)
				{
					if(player.getPlayerRect().intersects(MS.get(i).getMSRect()))
					{
						stopJump=true;
						intersected=(MS.get(i).getY())-30;
						//player.setY(yy);
					}
				}
				for(int i=0;i<MRS.size();i++)
				{
					if(player.getPlayerRect().intersects(MRS.get(i).getMRRect()))
					{
						stopJump=true;
						intersected=(MRS.get(i).getY())-30;
					}
				}
				for(int i=0;i<TLS.size();i++)
				{
					if(player.getPlayerRect().intersects(TLS.get(i).getTLRect()))
					{
						stopJump=true;
						intersected=(TLS.get(i).getY())-30;
					}
				}
				for(int i=0;i<TS.size();i++)
				{
					if(player.getPlayerRect().intersects(TS.get(i).getTSRect()))
					{
						stopJump=true;
						intersected=(TS.get(i).getY())-30;
					}
				}
				for(int i=0;i<TRS.size();i++)
				{
					if(player.getPlayerRect().intersects(TRS.get(i).getTRRect()))
					{
						stopJump=true;
						intersected=(TRS.get(i).getY())-30;
					}
				}
				
			}
			//if(!preformJump)
				//System.out.println("n");
			//System.out.println(stopJump);
			doStopJump();
	}
	
	public static void doStopJump()
	{
		if(stopJump)
		{
			preformJump=false;
			stopJump=false;
			jumpTime=0;
			//jumpHelper=0;
			player.setY(intersected);
			//System.out.println(intersected+ "hi");
			player.setRecLoc();
			
		}
	}
	
	public static void testDeath()
	{
		if(!godMode)
		{
			player.setRecLoc();
			for(int i=0;i<reg.size();i++)
			{
				//reg.get(i).setRegLoc();
				if(player.getPlayerDeathRect().intersects(reg.get(i).getRegRect()) && !player.getPlayerBeneathRect().intersects(reg.get(i).getRegRect()) && !player.getPlayerRect().intersects(reg.get(i).getRegRect()))
					{
						hasDied=true;
						//System.out.println(i);
					}
			}
		for(int i=0;i<regH.size();i++)
		{
			if(player.getPlayerDeathRect().intersects(regH.get(i).getRegHRect()) && !player.getPlayerBeneathRect().intersects(regH.get(i).getRegHRect())&& !player.getPlayerRect().intersects(regH.get(i).getRegHRect()))
					{
					hasDied=true;
					//System.out.println(i);
					}
		}
		for(int i=0;i<BLS.size();i++)
		{
			if(player.getPlayerDeathRect().intersects(BLS.get(i).getBLRect()) && !player.getPlayerBeneathRect().intersects(BLS.get(i).getBLRect())&& !player.getPlayerRect().intersects(BLS.get(i).getBLRect()))
					{
					hasDied=true;
					}
		}
		for(int i=0;i<BRS.size();i++)
		{
			if(player.getPlayerDeathRect().intersects(BRS.get(i).getBRRect()) && !player.getPlayerBeneathRect().intersects(BRS.get(i).getBRRect())&& !player.getPlayerRect().intersects(BRS.get(i).getBRRect()))
					{
				hasDied=true;
					}
		}
		for(int i=0;i<BS.size();i++)
		{
			if(player.getPlayerDeathRect().intersects(BS.get(i).getBSRect()) && !player.getPlayerBeneathRect().intersects(BS.get(i).getBSRect())&& !player.getPlayerRect().intersects(BS.get(i).getBSRect()))
					{
				hasDied=true;
					}
		}
		for(int i=0;i<MLS.size();i++)
		{
			if(player.getPlayerDeathRect().intersects(MLS.get(i).getMLRect()) && !player.getPlayerBeneathRect().intersects(MLS.get(i).getMLRect())&& !player.getPlayerRect().intersects(MLS.get(i).getMLRect()))
					{
				hasDied=true;
					}
		}
		for(int i=0;i<MRS.size();i++)
		{
			if(player.getPlayerDeathRect().intersects(MRS.get(i).getMRRect()) && !player.getPlayerBeneathRect().intersects(MRS.get(i).getMRRect())&& !player.getPlayerRect().intersects(MRS.get(i).getMRRect()))
					{
				hasDied=true;
					}
		}
		for(int i=0;i<MS.size();i++)
		{
			if(player.getPlayerDeathRect().intersects(MS.get(i).getMSRect()) && !player.getPlayerBeneathRect().intersects(MS.get(i).getMSRect())&& !player.getPlayerRect().intersects(MS.get(i).getMSRect()))
					{
				hasDied=true;
					}
		}
		for(int i=0;i<TLS.size();i++)
		{
			if(player.getPlayerDeathRect().intersects(TLS.get(i).getTLRect()) && !player.getPlayerBeneathRect().intersects(TLS.get(i).getTLRect())&& !player.getPlayerRect().intersects(TLS.get(i).getTLRect()))
					{
				hasDied=true;
					}
		}
		for(int i=0;i<TRS.size();i++)
		{
			if(player.getPlayerDeathRect().intersects(TRS.get(i).getTRRect()) && !player.getPlayerBeneathRect().intersects(TRS.get(i).getTRRect())&& !player.getPlayerRect().intersects(TRS.get(i).getTRRect()))
					{
				hasDied=true;
					}
		}
		for(int i=0;i<TS.size();i++)
		{
			if(player.getPlayerDeathRect().intersects(TS.get(i).getTSRect()) && !player.getPlayerBeneathRect().intersects(TS.get(i).getTSRect())&& !player.getPlayerRect().intersects(TS.get(i).getTSRect()))
					{
				hasDied=true;
					}
		}
		for(int i=0;i<regT.size();i++)
		{
			if(regT.get(i).getPoly().intersects(player.getPlayerRect()))
			{
				hasDied=true;
			}
		}
		}
	}

	public static void testFall()
	{
		if(fallTester==false)
		{
		for(int i=0;i<reg.size();i++)
		{
			if( !reg.get(i).getRegRect().contains(player.getPlayerBeneathRect()) && !preformJump)		{
				
				isFalling=true;
				
			}
			else
			{
				isFalling=false;
				i=reg.size()-1;
				fallTester=true;
			}
		}
		}
		if(fallTester==false)
		{
		for(int i=0;i<regH.size();i++)
		{
			if( !regH.get(i).getRegHRect().contains(player.getPlayerBeneathRect()) && !preformJump)		{
				
				isFalling=true;
				
			}
			else
			{
				isFalling=false;
				i=reg.size()-1;
				fallTester=true;
				
			}
		}
		}
		if(fallTester==false)
		{
		for(int i=0;i<BLS.size();i++)
		{
			if(!BLS.get(i).getBLRect().contains(player.getPlayerBeneathRect()) && !preformJump)		{
				
				isFalling=true;
			}
			else
			{
				isFalling=false;
				i=reg.size()-1;
				fallTester=true;
			}
		}
		}
		if(fallTester==false)
		{
		for(int i=0;i<BS.size();i++)
		{
			if(!BS.get(i).getBSRect().contains(player.getPlayerBeneathRect()) && !preformJump)		{
				
				isFalling=true;
			}
			else
			{
				isFalling=false;
				i=reg.size()-1;
				fallTester=true;
			}
		}
		}
		if(fallTester==false)
		{
		for(int i=0;i<BRS.size();i++)
		{
			if(!BRS.get(i).getBRRect().contains(player.getPlayerBeneathRect()) && !preformJump)		{
				
				isFalling=true;
			}
			else
			{
				isFalling=false;
				i=reg.size()-1;
				fallTester=true;
			}
		}
		}
		if(fallTester==false)
		{
		for(int i=0;i<MLS.size();i++)
		{
			if( !MLS.get(i).getMLRect().contains(player.getPlayerBeneathRect()) && !preformJump)		{
				
				isFalling=true;
			}
			else
			{
				isFalling=false;
				i=reg.size()-1;
				fallTester=true;
			}
		}
		}
		if(fallTester==false)
		{
		for(int i=0;i<MS.size();i++)
		{
			if(!MS.get(i).getMSRect().contains(player.getPlayerBeneathRect()) && !preformJump)		{
				
				isFalling=true;
			}
			else
			{
				isFalling=false;
				i=reg.size()-1;
				fallTester=true;
			}
		}
		}
		if(fallTester==false)
		{
		for(int i=0;i<MRS.size();i++)
		{
			if( !MRS.get(i).getMRRect().contains(player.getPlayerBeneathRect()) && !preformJump)		{
				
				isFalling=true;
			}
			else
			{
				isFalling=false;
				i=reg.size()-1;
				fallTester=true;
			}
		}
		}
		if(fallTester==false)
		{
		for(int i=0;i<TLS.size();i++)
		{
			if(!TLS.get(i).getTLRect().contains(player.getPlayerBeneathRect()) && !preformJump)		{
				
				isFalling=true;
			}
			else
			{
				isFalling=false;
				i=reg.size()-1;
				fallTester=true;
			}
		}
		}
		if(fallTester==false)
		{
		for(int i=0;i<TS.size();i++)
		{
			if( !TS.get(i).getTSRect().contains(player.getPlayerBeneathRect()) && !preformJump)		{
				
				isFalling=true;
			}
			else
			{
				isFalling=false;
				fallTester=true;
				i=reg.size()-1;
				
			}
		}
		}
		if(fallTester==false)
		{
		for(int i=0;i<TRS.size();i++)
		{
			if( !TRS.get(i).getTRRect().contains(player.getPlayerBeneathRect()) && !preformJump)		{
				
				isFalling=true;
			}
			else
			{
				isFalling=false; 
				i=reg.size()-1;
				fallTester=true;
			}
		}
		}
		fallTester=false;
	}
	
	public static void moveObjects()
	{
		for(int i=0;i<x.length;i++)
		{
			x[i]+=moveSpeed;
		}
		for(int i=0;i<reg.size();i++)
		{
			reg.get(i).setRegLoc(moveSpeed);
		}
		for(int i=0;i<regT.size();i++)
		{
			regT.get(i).setRegLoc(moveSpeed);
		}
		for(int i=0;i<regH.size();i++)
		{
			regH.get(i).setRegHLoc(moveSpeed);
		}
		for(int i=0;i<BLS.size();i++)
		{
			BLS.get(i).setBLLoc(moveSpeed);
		}
		for(int i=0;i<BRS.size();i++)
		{
			BRS.get(i).setBRLoc(moveSpeed);
		}
		for(int i=0;i<BS.size();i++)
		{
			BS.get(i).setBSLoc(moveSpeed);
		}
		for(int i=0;i<MLS.size();i++)
		{
			MLS.get(i).setMLLoc(moveSpeed);
		}
		for(int i=0;i<MRS.size();i++)
		{
			MRS.get(i).setMRLoc(moveSpeed);
		}
		for(int i=0;i<MS.size();i++)
		{
			MS.get(i).setMSLoc(moveSpeed);
		}
		for(int i=0;i<TLS.size();i++)
		{
			TLS.get(i).setTLLoc(moveSpeed);
		}
		for(int i=0;i<TRS.size();i++)
		{
			TRS.get(i).setTRLoc(moveSpeed);
		}
		for(int i=0;i<TS.size();i++)
		{
			TS.get(i).setTSLoc(moveSpeed);
		}
		for(int i=0;i<act.size();i++)
		{
			act.get(i).setActLoc(moveSpeed);
		}
		for(int i=0;i<tel.size();i++)
		{
			tel.get(i).setTelLoc(moveSpeed);
		}
	}
	
	public static void testBounds()
	{
		if(y[y.length-1]<=player.getY())
			hasDied=true;
		if(x[x.length-1]<=player.getX())
			hasWon=true;
		
	}
	
	public static void retry()
	{
		map=new MapOne();
		preformJump=false;
		
		jumpTime=0;
		screenMove=false;
		player.counterFall(false);
		isFalling=false;
		fallTime=0;
		hasWon=false;
		//System.out.println("hiii+fallTime");
		player.setY(startY);
		x=theGrid.getGridX();
		y=theGrid.getGridY();theGrid=new Grid(200,50);
		reg=map.getReg();
		regT=map.getRegT();
		regH=map.getRegH();
		BLS=map.getBLS();
		BS=map.getBS();
		BRS=map.getBRS();
		MLS=map.getMLS();
		MS=map.getMS();
		MRS=map.getMRS();
		TLS=map.getTLS();
		TS=map.getTS();
		TRS=map.getTRS();
		act=map.getAct();
		tel=map.getTel();
		for(int i=0;i<act.size();i++)
			actUsed.set(i, false);
		moveSpeed=-5;
		startY=y[9];
		backGround=new Color(100,0,170);
		 hasDied=false;
		 Driver.isDead(false);
	}
	
	public static void resetScreenMove()
	{
		
		screenMove=false;
		stopJump=true;
		stopFall=true;
		resetAid=true;
		
	//	System.out.println(34675);
		for(int i=0;i<reg.size();i++)
		{
			if(player.getWholePlayerRect().intersects(reg.get(i).getRegRect()) || (player.getPlayerBeneathRect().intersects(reg.get(i).getRegRect()) ||  player.getPlayerBeneathRect().contains(reg.get(i).getRegRect())))
			{
				intersected=(reg.get(i).getY())-30;
				lastType="reg";
				lastIndex=i;
				//System.out.println(player.getY());
			//	System.out.println(intersected + "hil");
			}
		}
		for(int i=0;i<regH.size();i++)
		{
			if(player.getWholePlayerRect().intersects(regH.get(i).getRegHRect()) || (player.getPlayerBeneathRect().intersects(regH.get(i).getRegHRect()) ||  player.getPlayerBeneathRect().contains(regH.get(i).getRegHRect())))
			{
				intersected=(regH.get(i).getY())-30;
				lastType="regH";
				lastIndex=i;
			//	System.out.println(intersected+"jkl");
			}
		}
		for(int i=0;i<BLS.size();i++)
		{
			if(player.getWholePlayerRect().intersects(BLS.get(i).getBLRect()) || (player.getPlayerBeneathRect().intersects(BLS.get(i).getBLRect()) ||  player.getPlayerBeneathRect().contains(BLS.get(i).getBLRect())))
			{
				intersected=(BLS.get(i).getY())-30;
				lastType="BLS";
				lastIndex=i;
			}
		}
		for(int i=0;i<BS.size();i++)
		{
			if(player.getWholePlayerRect().intersects(BS.get(i).getBSRect()) || (player.getPlayerBeneathRect().intersects(BS.get(i).getBSRect()) ||  player.getPlayerBeneathRect().contains(BS.get(i).getBSRect())))
			{
				intersected=(BS.get(i).getY())-30;
				lastType="BS";
				lastIndex=i;
			}
		}
		for(int i=0;i<BRS.size();i++)
		{
			if(player.getWholePlayerRect().intersects(BRS.get(i).getBRRect()) || (player.getPlayerBeneathRect().intersects(BRS.get(i).getBRRect()) ||  player.getPlayerBeneathRect().contains(BRS.get(i).getBRRect())))
			{
				intersected=(BRS.get(i).getY())-30;
				lastType="BRS";
				lastIndex=i;
			}
		}
		for(int i=0;i<MLS.size();i++)
		{
			if(player.getWholePlayerRect().intersects(MLS.get(i).getMLRect()) || (player.getPlayerBeneathRect().intersects(MLS.get(i).getMLRect()) ||  player.getPlayerBeneathRect().contains(MLS.get(i).getMLRect())))
			{
				intersected=(MLS.get(i).getY())-30;
				lastType="MLS";
				lastIndex=i;
			}
		}
		for(int i=0;i<MS.size();i++)
		{
			if(player.getWholePlayerRect().intersects(MS.get(i).getMSRect()) || (player.getPlayerBeneathRect().intersects(MS.get(i).getMSRect()) ||  player.getPlayerBeneathRect().contains(MS.get(i).getMSRect())))
			{
				intersected=(MS.get(i).getY())-30;
				lastType="MS";
				lastIndex=i;
			}
		}
		for(int i=0;i<MRS.size();i++)
		{
			if(player.getWholePlayerRect().intersects(MRS.get(i).getMRRect()) || (player.getPlayerBeneathRect().intersects(MRS.get(i).getMRRect()) ||  player.getPlayerBeneathRect().contains(MRS.get(i).getMRRect())))
			{
				intersected=(MRS.get(i).getY())-30;
				lastType="MRS";
				lastIndex=i;
			}
		}
		for(int i=0;i<TLS.size();i++)
		{
			if(player.getWholePlayerRect().intersects(TLS.get(i).getTLRect()) || (player.getPlayerBeneathRect().intersects(TLS.get(i).getTLRect()) ||  player.getPlayerBeneathRect().contains(TLS.get(i).getTLRect())))
			{
				intersected=(TLS.get(i).getY())-30;
				lastType="TLS";
				lastIndex=i;
			}
		}
		for(int i=0;i<TS.size();i++)
		{
			if(player.getWholePlayerRect().intersects(TS.get(i).getTSRect()) || (player.getPlayerBeneathRect().intersects(TS.get(i).getTSRect()) ||  player.getPlayerBeneathRect().contains(TS.get(i).getTSRect())))
			{
				intersected=(TS.get(i).getY())-30;
				lastType="TS";
				lastIndex=i;
			}
		}
		for(int i=0;i<TRS.size();i++)
		{
			if(player.getWholePlayerRect().intersects(TRS.get(i).getTRRect()) || (player.getPlayerBeneathRect().intersects(TRS.get(i).getTRRect()) ||  player.getPlayerBeneathRect().contains(TRS.get(i).getTRRect())))
			{
				intersected=(TRS.get(i).getY())-30;
				lastType="TRS";
				lastIndex=i;
			}
		}
		//doScreenMove(105);
		doStopFall();
		doStopJump();
		player.setRecLoc();
		player.counterFall(false);
		//player.setY(intersected);
		player.reset();
		//System.out.println(player.getY());
		if(player.getY()<=70)
		{
			int counter=50;
			//intersected+=counter;
			//System.out.println(intersected);
			for(int i=0;i<reg.size();i++)
			
			
			{
				reg.get(i).screenIsMoving(counter);
				//System.out.println(counter);
			}
			for(int i=0;i<regT.size();i++)
			{
				regT.get(i).screenIsMoving(counter);
			}
			for(int i=0;i<regH.size();i++)
			{
				regH.get(i).screenIsMoving(counter);
			}
			for(int i=0;i<BLS.size();i++)
			{
				BLS.get(i).screenIsMoving(counter);
			}
			for(int i=0;i<BS.size();i++)
			{
				BS.get(i).screenIsMoving(counter);
			}
			for(int i=0;i<BRS.size();i++)
			{
				BRS.get(i).screenIsMoving(counter);
			}
			for(int i=0;i<MRS.size();i++)
			{
				MRS.get(i).screenIsMoving(counter);
			}
			for(int i=0;i<MS.size();i++)
			{
				MS.get(i).screenIsMoving(counter);
			}
			for(int i=0;i<MLS.size();i++)
			{
				MLS.get(i).screenIsMoving(counter);
			}
			for(int i=0;i<TLS.size();i++)
			{
				TLS.get(i).screenIsMoving(counter);
			}
			for(int i=0;i<TS.size();i++)
			{
				TS.get(i).screenIsMoving(counter);
			}
			for(int i=0;i<TRS.size();i++)
			{
				TRS.get(i).screenIsMoving(counter);
			}
			for(int i=0;i<act.size();i++)
			{
				act.get(i).screenIsMoving(counter);
			}
			for(int i=0;i<tel.size();i++)
			{
				tel.get(i).screenIsMoving(counter);
			}
			//intersected=getBeneathObject()-30;
			player.moveY(counter);
			//player.setY(intersected);
		//	System.out.println("sfgdh"+" "+intersected);
		}
		//testPlayerY();
		//System.out.println("123");
	}
	
	public static int getBeneathObject()
	{
		if(lastType.equals("reg"))
		{
			//System.out.println("ya");
			return reg.get(lastIndex).getY();
		}
		return 0;
	}
	
	public static void setIsJumping(boolean jump)
	{
		//isJumping=true;
		isJumping=jump;
		if(isJumping)
		{
			//preformJump=true;
			//jumpHelper=1;
		}
	}
	
	public static int getStartY()
	{
		return startY;
	} 
	
	//removes blocks when called by activator
	public static void remove(ArrayList<Integer> x, ArrayList <String> g)
	{
		for(int i=0;i<x.size();i++)
		{
			if(g.get(i).equals("reg"))
				reg.get(x.get(i)).move();
			if(g.get(i).equals("regT"))
				regT.get(x.get(i)).move();
			if(g.get(i).equals("regH"))
				regH.get(x.get(i)).move();
			if(g.get(i).equals("BRS"))
				BRS.get(x.get(i)).move();
			if(g.get(i).equals("BS"))
				BS.get(x.get(i)).move();
			if(g.get(i).equals("BLS"))
				BLS.get(x.get(i)).move();
			if(g.get(i).equals("TRS"))
				TRS.get(x.get(i)).move();
			if(g.get(i).equals("TS"))
				TS.get(x.get(i)).move();
			if(g.get(i).equals("TLS"))
				TLS.get(x.get(i)).move();
			if(g.get(i).equals("MRS"))
				MRS.get(x.get(i)).move();
			if(g.get(i).equals("MS"))
				MS.get(x.get(i)).move();
			if(g.get(i).equals("MLS"))
				MLS.get(x.get(i)).move();
		}
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(backGround);
		g.fillRect(0, 0, 1000, 1000);
		//draws grid
		g.setColor(Color.black);
		for(int i=0;i<x.length;i++)
		{
			for(int ii=0;ii<y.length;ii++)
			{
				g.drawRect(x[i],y[ii],30,30);
			
			}
		}
		for(RegSquare r:reg)
		{
			r.draw(g);
		}
		for(RegTriangle r:regT)
		{
			r.draw(g);
		}
		for(RegHalfBlock r:regH)
		{
			r.draw(g);
		}
		for(BottomLeftSquare r:BLS)
		{
			r.draw(g);
		}
		for(BottomRightSquare r:BRS)
		{
			r.draw(g);
		}
		for(BottomSquare r:BS)
		{
			r.draw(g);
		}
		for(MiddleLeftSquare r:MLS)
		{
			r.draw(g);
		}
		for(MiddleRightSquare r:MRS)
		{
			r.draw(g);
		}
		for(MiddleSquare r:MS)
		{
			r.draw(g);
		}
		for(TopLeftSquare r:TLS)
		{
			r.draw(g);
		}
		for(TopRightSquare r:TRS)
		{
			r.draw(g);
		}
		for(TopSquare r:TS)
		{
			r.draw(g);
		}
		for(Activator r:act)
		{
			r.draw(g);
		}
		for(Teleporter r:tel)
		{
			r.draw(g);
		}
		//g.setColor(Color.magenta);
	//	g.fill(reg.get(171).getRegRect());
	}
}
