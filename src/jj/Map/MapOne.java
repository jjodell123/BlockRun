package jj.Map;

import java.util.ArrayList;

import jj.Grid;
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

public class MapOne {
	
	Grid theGrid;
	
	//instantiation of different blocks
	private  ArrayList <RegSquare> reg=new ArrayList<RegSquare>(); 
	private  ArrayList <RegTriangle> regT=new ArrayList<RegTriangle>(); 
	private ArrayList <RegHalfBlock> regH=new ArrayList<RegHalfBlock>(); 
	private ArrayList <BottomLeftSquare> BLS=new ArrayList<BottomLeftSquare>(); 
	private ArrayList <BottomRightSquare> BRS=new ArrayList<BottomRightSquare>(); 
	private ArrayList <BottomSquare> BS=new ArrayList<BottomSquare>(); 
	private ArrayList <MiddleLeftSquare> MLS=new ArrayList<MiddleLeftSquare>(); 
	private ArrayList <MiddleRightSquare> MRS=new ArrayList<MiddleRightSquare>(); 
	private ArrayList <MiddleSquare> MS=new ArrayList<MiddleSquare>(); 
	private ArrayList <TopLeftSquare> TLS=new ArrayList<TopLeftSquare>(); 
	private ArrayList <TopRightSquare> TRS=new ArrayList<TopRightSquare>(); 
	private ArrayList <TopSquare> TS=new ArrayList<TopSquare>(); 
	private ArrayList <Activator> act=new ArrayList<Activator>();
	private ArrayList <Teleporter> tel=new ArrayList<Teleporter>();
	
	//made equal to the grid locations
	private int x[],y[];
	
	public MapOne()
	{
		theGrid=new Grid(200,50);
		x=theGrid.getGridX();
		y=theGrid.getGridY();
		
		//begins declaration of where each block goes
		for(int i=0;i<86;i++)
		{
		reg.add(new RegSquare(x[i],y[10]));
		}
		regH.add(new RegHalfBlock(x[15],y[8],true));
		regH.add(new RegHalfBlock(x[19],y[7],true));
		regH.add(new RegHalfBlock(x[20],y[7],true));
		for(int i=14;i<25;i++)
		{
			regT.add(new RegTriangle(new int[]{x[i],x[i]+15,x[i]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		}  
		regT.add(new RegTriangle(new int[]{x[28],x[28]+15,x[28]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		regT.add(new RegTriangle(new int[]{x[29],x[29]+15,x[29]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		regT.add(new RegTriangle(new int[]{x[30],x[30]+15,x[30]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		regT.add(new RegTriangle(new int[]{x[35],x[35]+15,x[35]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		regT.add(new RegTriangle(new int[]{x[36],x[36]+15,x[36]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		regH.add(new RegHalfBlock(x[43],y[7],false));
		MLS.add(new MiddleLeftSquare(x[43],y[8]));
		TLS.add(new TopLeftSquare(x[42],y[9]));
		regT.add(new RegTriangle(new int[]{x[42],x[42]+15,x[42]+30} , new int[]{y[8]+30,y[8],y[8]+30}));
		MS.add(new MiddleSquare(x[43],y[9]));
		MS.add(new MiddleSquare(x[44],y[9]));
		MS.add(new MiddleSquare(x[44],y[8]));
		regH.add(new RegHalfBlock(x[44],y[7],false));
		regH.add(new RegHalfBlock(x[45],y[7],false));
		regT.add(new RegTriangle(new int[]{x[45],x[45]+15,x[45]+30} , new int[]{y[6]+45,y[6]+15,y[6]+45}));
		MS.add(new MiddleSquare(x[45],y[9]));
		MS.add(new MiddleSquare(x[45],y[8]));
		regH.add(new RegHalfBlock(x[46],y[7],false));
		MS.add(new MiddleSquare(x[46],y[9]));
		MS.add(new MiddleSquare(x[46],y[8]));
		regH.add(new RegHalfBlock(x[47],y[7],false));
		MRS.add(new MiddleRightSquare(x[47],y[8]));
		MS.add(new MiddleSquare(x[47],y[9]));
		TRS.add(new TopRightSquare(x[48],y[9]));
		regT.add(new RegTriangle(new int[]{x[48],x[48]+15,x[48]+30} , new int[]{y[8]+30,y[8],y[8]+30}));
		regT.add(new RegTriangle(new int[]{x[52],x[52]+15,x[52]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		regT.add(new RegTriangle(new int[]{x[53],x[53]+15,x[53]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		regT.add(new RegTriangle(new int[]{x[54],x[54]+15,x[54]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		regH.add(new RegHalfBlock(x[61],y[8],true));
		regH.add(new RegHalfBlock(x[62],y[8],true));
		regT.add(new RegTriangle(new int[]{x[62],x[62]+15,x[62]+30} , new int[]{y[7]+30,y[7],y[7]+30}));
		for(int i=59;i<86;i++)
		regT.add(new RegTriangle(new int[]{x[i],x[i]+15,x[i]+30} , new int[]{y[9]+30,y[9],y[9]+30}));	
		{
			ArrayList<Integer> tempIndex=new ArrayList<Integer>();
			tempIndex.add(65);
			tempIndex.add(66);
			tempIndex.add(67);
			tempIndex.add(68);
			tempIndex.add(29);
			tempIndex.add(30);
			tempIndex.add(31);
			tempIndex.add(32);
			ArrayList<String> tempType=new ArrayList<String>();
			tempType.add("reg");
			tempType.add("reg");
			tempType.add("reg");
			tempType.add("reg");
			tempType.add("regT");
			tempType.add("regT");
			tempType.add("regT");
			tempType.add("regT");
			act.add(new Activator (x[65],y[7], tempIndex, tempType));
		}  
		for(int i=60;i<94;i++)
			reg.add(new RegSquare(x[i],y[25]));
		regH.add(new RegHalfBlock(x[75], y[23], true));
		regH.add(new RegHalfBlock(x[80], y[23], true));
		for(int i=74;i<82;i++)
			regT.add(new RegTriangle(new int[]{x[i],x[i]+15,x[i]+30} , new int[]{y[24]+30,y[24],y[24]+30}));
		regH.add(new RegHalfBlock(x[89],y[23],true));
		regH.add(new RegHalfBlock(x[92],y[20],false));
		regH.add(new RegHalfBlock(x[95],y[22],true));
		regH.add(new RegHalfBlock(x[98],y[19],false));
		regH.add(new RegHalfBlock(x[103],y[19],false));
		regH.add(new RegHalfBlock(x[104],y[19],false));
		regH.add(new RegHalfBlock(x[105],y[19],false));
		regH.add(new RegHalfBlock(x[106],y[19],false));
		regH.add(new RegHalfBlock(x[107],y[19],false));
		regT.add(new RegTriangle(new int[]{x[107],x[107]+15,x[107]+30} , new int[]{y[19]+15,y[19]-15,y[19]+15}));
		regH.add(new RegHalfBlock(x[110],y[19],false));
		regT.add(new RegTriangle(new int[]{x[110],x[110]+15,x[110]+30} , new int[]{y[19]+15,y[19]-15,y[19]+15}));
		for(int i=105;i<130;i++)
			reg.add(new RegSquare(x[i],y[22]));
		regH.add(new RegHalfBlock(x[116],y[19],false));
		regH.add(new RegHalfBlock(x[119],y[17],true));
		regH.add(new RegHalfBlock(x[122],y[14],false));
		regH.add(new RegHalfBlock(x[127],y[12],true));
		regH.add(new RegHalfBlock(x[131],y[9],false));
		regH.add(new RegHalfBlock(x[134],y[7],true));
		regH.add(new RegHalfBlock(x[139],y[5],true));
		regT.add(new RegTriangle(new int[]{x[139],x[139]+15,x[139]+30} , new int[]{y[4]+30,y[4],y[4]+30}));
		for(int i=135;i<150;i++)
			reg.add(new RegSquare(x[i],y[10]));
		
		{
			ArrayList<Integer> tempIndex=new ArrayList<Integer>();
			tempIndex.add(169);
			ArrayList<String> tempType=new ArrayList<String>();
			tempType.add("reg");

			act.add(new Activator (x[149],y[9], tempIndex, tempType));
		}  
		for(int i=0;i<11;i++)
			reg.add(new RegSquare(x[150],y[i]));
		System.out.println(reg.size());
		reg.add(new RegSquare(x[151],y[5]));
		reg.add(new RegSquare(x[152],y[6]));
		reg.add(new RegSquare(x[153],y[7]));
		reg.add(new RegSquare(x[154],y[8]));
		reg.add(new RegSquare(x[155],y[9]));
		reg.add(new RegSquare(x[156],y[10]));
		tel.add(new Teleporter(x[151],y[9],y[4]));
		for(int i=157;i<170;i++)
			reg.add(new RegSquare(x[i],y[10]));
		regT.add(new RegTriangle(new int[]{x[160],x[160]+15,x[160]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		regT.add(new RegTriangle(new int[]{x[161],x[161]+15,x[161]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		regT.add(new RegTriangle(new int[]{x[162],x[162]+15,x[162]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		regT.add(new RegTriangle(new int[]{x[165],x[165]+15,x[165]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		regT.add(new RegTriangle(new int[]{x[166],x[166]+15,x[166]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		regT.add(new RegTriangle(new int[]{x[167],x[167]+15,x[167]+30} , new int[]{y[9]+30,y[9],y[9]+30}));
		regH.add(new RegHalfBlock(x[173],y[8],true));
		for(int i=170;i<190;i++)
		{
			reg.add(new RegSquare(x[i],y[20]));
			regT.add(new RegTriangle(new int[]{x[i],x[i]+15,x[i]+30} , new int[]{y[19]+30,y[19],y[19]+30}));
		}
		tel.add(new Teleporter(x[174],y[18],y[21]));
		for(int i=170;i<191;i++)
			reg.add(new RegSquare(x[i],y[22]));
		reg.add(new RegSquare(x[195],y[22]));
		//reg.add(new RegSquare(x[198],y[22]));
		//System.out.println(reg.size());
	}
	
	public  void remover(ArrayList<Integer> del, ArrayList<String> type)
	{
		//reg.remove((int)del.get(0));
		for(int i=0; i<del.size();i++)
		{
			if(type.get(i).equals("reg"))
			{
				//System.out.println(del+" "+type);
				reg.remove((int)del.get(i));
			}
			if(type.get(i).equals("regT"))
			{
				//System.out.println(del+" "+type);
				regT.remove((int)del.get(i));
			}
		}
	}
	
	
	public ArrayList<RegSquare> getReg()
	{
		return reg;
	}
	
	public ArrayList<RegTriangle> getRegT()
	{
		return regT;
	}
	
	public ArrayList<RegHalfBlock> getRegH()
	{
		return regH;
	}
	public ArrayList<TopLeftSquare> getTLS()
	{
		return TLS;
	}
	public ArrayList<TopSquare> getTS()
	{
		return TS;
	}
	public ArrayList<TopRightSquare> getTRS()
	{
		return TRS;
	}
	public ArrayList<BottomLeftSquare> getBLS()
	{
		return BLS;
	}
	public ArrayList<BottomSquare> getBS()
	{
		return BS;
	}
	public ArrayList<BottomRightSquare> getBRS()
	{
		return BRS;
	}
	public ArrayList<MiddleLeftSquare> getMLS()
	{
		return MLS;
	}
	public ArrayList<MiddleSquare> getMS()
	{
		return MS;
	}
	public ArrayList<MiddleRightSquare> getMRS()
	{
		return MRS;
	}
	public ArrayList<Activator> getAct()
	{
		return act;
	}
	public ArrayList<Teleporter> getTel()
	{
		return tel;
	}
	
}
