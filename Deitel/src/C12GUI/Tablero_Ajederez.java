package C12GUI;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tablero_Ajederez extends JFrame
{
	
	JLabel[][] label;
	
	public Tablero_Ajederez()
	{
		
		label=new JLabel[8][8];
		setLayout(new GridLayout(8, 8));
		
		for (int i=0; i<label.length; i++)
		{
			for (int j=0; j<label[i].length; j++)
			{
				label[i][j]=new JLabel();
				label[i][j].setOpaque(true);
				
			if ((i+1)%2==0)
			{
				if((j+1)%2==0)
					label[i][j].setBackground(Color.WHITE);
				else
					label[i][j].setBackground(Color.BLACK);
			}
			
			else
			{
				if((j+1)%2==0)
					label[i][j].setBackground(Color.BLACK);
				else
					label[i][j].setBackground(Color.WHITE);
			}
			
				add(label[i][j]);
			}
		}
		
		setSize(500,500);
		setDefaultCloseOperation(2);
	}
	
	public static void main(String[] args)
	{
		new Tablero_Ajederez().setVisible(true);
		
	}
}
