package JuegosMesa;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Restart
{
	private String pieza;
	
	public void restart()
	{
		pieza="peon0";
		//Agregar 
		add();
		putMorePiece();
		
		//Quitar
		quitarIconTab();
		quitarBancas();
		AjedrezToggle.isTurnP1=true;
	}
	
	private void add()
	{
		for (int i=0; i<8; i++)
		{
			for (int j=0; j<8; j++)
			{
				if(AjedrezToggle.cuadros[i][j].isSelected())
				AjedrezToggle.cuadros[i][j].setSelected(false);
				
				if(i==1 || i==6)
					putPeones(i, j);
			}
		}
	}
	
	private void putPeones(int i, int j)
	{
		if(i==6 && !pieza.equals("peonYell0")) 
			pieza="peonYell0";
		
		AjedrezToggle.cuadros[i][j]
				.setIcon(new ImageIcon(getClass().getResource("/Aplication/Ajz/"+pieza+".png")));
	}
	
	private void putMorePiece()
	{
		for (int i=0; i<AjedrezToggle.piezasPrinc.length; i++)
		{
			AjedrezToggle.cuadros[0][i].setIcon(addIcon(AjedrezToggle.piezasPrinc[i]+"1"));
			AjedrezToggle.cuadros[7][i].setIcon(addIcon(AjedrezToggle.piezasPrinc[i]+"2"));
			
			if(i<3)
			{
			AjedrezToggle.cuadros[0][7-i].setIcon(addIcon(AjedrezToggle.piezasPrinc[i]+"1"));
			AjedrezToggle.cuadros[7][7-i].setIcon(addIcon(AjedrezToggle.piezasPrinc[i]+"2"));
			}
		}
	}
	
	private Icon addIcon(String name)
	{
		return new ImageIcon(getClass().getResource("/Aplication/Ajz/"+name+".png"));
	}

	private void quitarIconTab()
	{
		for (int i=2; i<6; i++)
		{
			for (int j=0; j<8; j++)
			{
				AjedrezToggle.cuadros[i][j].setIcon(null);
			}
		}
	}
	
	private void quitarBancas()
	{
		for (int i=0; i<AjedrezToggle.bancsP1.length; i++)
		{
			for (int j=0; j<AjedrezToggle.bancsP2[i].length; j++)
			{
				if(j==0)
				{
					AjedrezToggle.bancsP1[i][j].setIcon(addIcon("peonB"));
					addIconToLabels(AjedrezToggle.bancsP2[i][j], i, j);
				}
				else
				{
					AjedrezToggle.bancsP2[i][j].setIcon(addIcon("peonB"));
					addIconToLabels(AjedrezToggle.bancsP1[i][j], i, j);
				}
			}
		}
	}
	
	private void addIconToLabels(JLabel lab, int i, int j)
	{
		if(i<=4)
		{
			lab.setIcon(addIcon(AjedrezToggle.piezasPrinc[i]+"B"));
		}
		else
		{
			lab.setIcon(addIcon(AjedrezToggle.piezasPrinc[i-5]+"B"));
		}
	}
}
