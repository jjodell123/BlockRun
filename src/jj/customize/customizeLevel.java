package jj.customize;

import javax.swing.JOptionPane;

public class customizeLevel {

	private static int chara=2;
	//actually sets character
	public customizeLevel()
	{
		
	}
	
	public void setCharacter()
	{
		chara=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter a character number(0-5, with 3-5 as the custom ones"));
	}
	
	public int getChara()
	{
		return chara;
	}
}
