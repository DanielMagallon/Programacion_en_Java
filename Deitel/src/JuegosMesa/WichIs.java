package JuegosMesa;

import static JuegosMesa.AjedrezToggle.bancsP2;
import static JuegosMesa.AjedrezToggle.bancsP1;
import javax.swing.Icon;
import javax.swing.JLabel;

import static JuegosMesa.AjedrezToggle.peonesToRight;


import static JuegosMesa.AjedrezToggle.peonesToLeft;

public class WichIs
{
	private static String ruta;
	private static Icon icon;
	private static boolean hasPutedTower1=false, hasPutedTower2=false;
	
	public static void find()
	{
		if(isPeon1())
		{
			bancsP2[peonesToRight][1].setIcon(icon);
			peonesToRight++;
			return;
		}
		
		if(isPeon2())
		{
			bancsP1[peonesToLeft][0].setIcon(icon);
			peonesToLeft++;
			return;
		}
		
		if(isTorre1())
		{
			if(!hasPutedTower2)
				bancsP2[0][0].setIcon(icon);
			
			if(hasPutedTower2)
				bancsP2[5][0].setIcon(icon);
			
			hasPutedTower2=true;
			return;
		}
		
		if(isTorre2())
		{
			if(!hasPutedTower1)
				bancsP1[0][1].setIcon(icon);
			
			if(hasPutedTower1)
				bancsP1[5][1].setIcon(icon);
			
			hasPutedTower1=true;
			return;
		}
	}
	
	/*private static boolean hasAnIconP2(int i, int j)
	{
		return bancsP2[i][j].getIcon() != null;
	}
	
	private static boolean hasAnIconP1(int i, int j)
	{
		return bancsP1[i][j].getIcon() != null;
	}*/
	
	private static boolean isPeon1()
	{
		return ruta.contains("peon0.png");
	}
	
	private static boolean isPeon2()
	{
		return ruta.contains("peonYell0.png");
	}
	
	private static boolean isTorre1()
	{
		return ruta.contains("torre1.png");
		
	}
	
	private static boolean isTorre2()
	{
		return ruta.contains("torre2.png");
	}
	
	public static void setRuta(String to)
	{
		ruta=to;
	}
	
	public static void setIcon(Icon ic)
	{
		icon=ic;
	}
}
