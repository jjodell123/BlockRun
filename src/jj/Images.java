package jj;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Images {
	private static String imageUrl = "src/resources/backgrounds/";
			//"D:/Users/jjode/OneDrive/Documents/JJ's Folder/Magnet/Sophmore/AP CS/BlockRun/src/resources/backgrounds/";

	//death screen picture
	public static Image onDeath=Toolkit.getDefaultToolkit().getImage(imageUrl+"deathScreen.png").getScaledInstance(500, 500, 1);
	public static Image onWin=Toolkit.getDefaultToolkit().getImage(imageUrl+"winScreen.png").getScaledInstance(500, 500, 1);
	public static Image homeScreen=Toolkit.getDefaultToolkit().getImage(imageUrl+"homeScreen.png").getScaledInstance(500, 500, 1);
	public static Image levelSelect=Toolkit.getDefaultToolkit().getImage(imageUrl+"levelSelect.png").getScaledInstance(500, 500, 1);

	
	private static Rectangle retryRect=new Rectangle(40,300,120,120);
	private static Rectangle mainRect=new Rectangle(340,300,120,120);
	private static Rectangle playRect=new Rectangle(110, 280, 100, 100);
	private static Rectangle custRect=new Rectangle(290, 280, 100, 100);
	private static Rectangle oneRect=new Rectangle(30, 110, 100, 100);
	private static Rectangle twoRect=new Rectangle(200, 110, 100, 100);
	private static Rectangle threeRect=new Rectangle(370, 110, 100, 100);
	private static Rectangle fourRect=new Rectangle(30, 315, 100, 100);
	private static Rectangle fiveRect=new Rectangle(200, 315, 100, 100);
	private static Rectangle sixRect=new Rectangle(370, 315, 100, 100);
	
	
	public static Image getOnDeath()
	{
		return onDeath;
	}
	
	public static Image getOnWin()
	{
		return onWin;
	}
	
	public static Image getHomeScreen()
	{
		return homeScreen;
	}
	
	public static Image getLevelSelect()
	{
		return levelSelect;
	}
	
	
	public static Rectangle getRetryRect()
	{
		return retryRect;
	}
	
	public static Rectangle getMainRect()
	{
		return mainRect;
	}
	
	public static Rectangle getPlayRect()
	{
		return playRect;
	}
	
	public static Rectangle getCustRect()
	{
		return custRect;
	}
	
	public static Rectangle getOne()
	{
		return oneRect;
	}
	
	public static Rectangle getTwo()
	{
		return twoRect;
	}
	
	public static Rectangle getThree()
	{
		return threeRect;
	}
	
	public static Rectangle getFour()
	{
		return fourRect;
	}
	
	public static Rectangle getFive()
	{
		return fiveRect;
	}
	
	public static Rectangle getSix()
	{
		return sixRect;
	}
	
	
	
	public static void draw(Graphics2D g)
	{
		g.drawImage(onDeath, 0, 0, null);
	}
}
