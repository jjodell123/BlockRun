package jj.customize;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class customizeScreen{

	private Rectangle level,character,back;
	public customizeScreen()
	{
		level=new Rectangle(260, 100, 200, 190);
		character=new Rectangle(50, 100, 200, 190);
		back=new Rectangle(150, 300, 200, 190);
	}
	
	public Rectangle getChar()
	{
		return character;
	}
	
	public Rectangle getLev()
	{
		return level;
	}
	
	public Rectangle getBack()
	{
		return back;
	}

	public void draw(Graphics2D g)
	{
		g.setColor(Color.blue);
		g.fillRect(0, 0, 500, 500);
		g.setColor(Color.red);
		g.fillRect(50, 100, 200, 190);
		
		g.fillRect(260, 100, 200, 190);
		g.fillRect(150, 300, 200, 190);
		g.setColor(Color.white);
		g.drawString("Set Character",320,200);
		g.drawString("Customize Character",100,200);
		g.drawString("Back", 240, 400);
	}
}
