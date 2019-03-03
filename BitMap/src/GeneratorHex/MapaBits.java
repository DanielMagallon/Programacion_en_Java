package GeneratorHex;

import java.awt.Color;
import java.awt.Graphics;

public class MapaBits 
{
	private int ash[]=
			{0x0fc00000, 0x10200000, 0x20100000, 0x60380000, 0x83f80000, 0x61f80000, 0x29300000, 0x28300000,
	0x20200000, 0x10d00000, 0x0f900000, 0x06500000, 0x06500000, 0x09e00000, 0x08400000, 0x07800000};


	
	public void drawAsh(Graphics g)
	{
		g.setColor(Color.black);
		
		int mascara = 1<<31;
		
		for (int i=0; i<ash.length; i++)
		{
			for (int c=0; c<=16; c++)
			{
				if((ash[i] & mascara >> 32) != 0)
				{
					g.drawLine(i+100, c+100, i+100, c+100);
				}
			}
		}
	}
}
