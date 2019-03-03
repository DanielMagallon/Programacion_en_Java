package Aplication;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Ajedrez extends JFrame
{
	JLabel[][] cuadros;
	final int TAMANIO;
	boolean sigueBlanco=true, hasIcon=false, isFisrtMovP1=true, isFisrtMovP2=true, isTurnP1=true;
	String piezaPeon="peon0";	
	int k, m;
	int fila, col;
	JLabel eti;
	long i,f;
	
	public Ajedrez()
	{
		TAMANIO=8;
		setLayout(new GridLayout(TAMANIO, TAMANIO));
		cuadros = new JLabel[TAMANIO][TAMANIO];

		//i=System.currentTimeMillis();
		addTablero();
		//f=System.currentTimeMillis();
		//JOptionPane.showMessageDialog(this, "Time up: "+ (f-i));
		setSize(600,600);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
	}
	
	private void addTablero()
	{
		for (int i=0; i<TAMANIO; i++)
		{
			for (int j=0; j<TAMANIO; j++)
			{
				cuadros[i][j] = new JLabel();
				cuadros[i][j].addMouseListener(new MouseC());
				cuadros[i][j].setOpaque(true);
				cuadros[i][j].setText(i+""+j);
				checarColor(i, j);
				
				if(i==1 || i==6)
					putPeones(i, j);
					
				
				add(cuadros[i][j]);
			}
		}
	}
	
	private void checarColor(int i, int j)
	{
		
		if(j == 0)
		sigueBlanco = (i==0 || i%2==0);
		
		if (sigueBlanco)
		{
			cuadros[i][j].setBackground(Color.WHITE);
			cuadros[i][j].setForeground(Color.WHITE);
			sigueBlanco=false;
		}
		else
		{
			cuadros[i][j].setBackground(Color.BLACK);
			cuadros[i][j].setForeground(Color.BLACK);
			sigueBlanco=true;
		}
	}
 	private void putPeones(int i, int j)
	{
		if(i==6 && !piezaPeon.equals("peonYell0")) 
			piezaPeon="peonYell0";
		
		cuadros[i][j].setIcon(addIcon(piezaPeon));
	}
	
	private Icon addIcon(String name)
	{
		return new ImageIcon(getClass().getResource("/Aplication/Ajz/"+name+".png"));
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			
			@Override
			public void run()
			{
				new Ajedrez().setVisible(true);
			}
		});
	}
	
	private class MouseC extends MouseAdapter
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			eti = (JLabel) e.getComponent();

			
			//Menea
			if(hasIcon)
			{
				k=getFila();
				m=getCol();
				
				cuadros[k][m].setIcon(cuadros[fila][col].getIcon());
				cuadros[fila][col].setIcon(null);
				
				try
				{
					if(isPeonP1() || isPeonP2())
					{
						
						walkPeon();
					}
					
				}
				catch (NullPointerException ex){}
				
				hasIcon=false;
				System.out.println("Menea\n");
			}
			
			//Esocge
			else
			{
				fila = getFila();
				col = getCol();
				
				System.out.println("Escoge\n");
				hasIcon = cuadros[fila][col].getIcon() != null;
			}
		}
	}

	private boolean isPeonP2()
	{
		
		String r = getRouteIcon();
		//isTurnP1=true;
		return r.contains("peonYell0.png") ;
		
	}
	
	private boolean isPeonP1()
	{
		String r = getRouteIcon();
		//isTurnP1=false;
		return r.contains("peon0.png");
	}
	

	private String getRouteIcon()
	{
		return cuadros[k][m].getIcon().toString();
	}
	
	private void walkPeon()
	{
		if(isTurnP1)
		{
			isFisrtMovP1 = fila==1 && col>=0 && col<=7;
			
			if(isFisrtMovP1)
			{
				if(k-2 != fila && k-1 != fila || m != col)
					valid();
				
			}
			else
			{
				if(k-1 != fila || m != col)
					valid();
			}
			isTurnP1=false;
		}
	
		else
		{
			isFisrtMovP2 = fila==6 && col>=0 && col<=7;
			
			if(isFisrtMovP2)
			{
				if(k+2 != fila && k+1 != fila || m != col)
					valid();
			}
			else
			{
				if(k+1 != fila || m != col)
					valid();
			}
			isTurnP1=true;
		}
	}
	
	private void valid()
	{
		cuadros[fila][col].setIcon(cuadros[k][m].getIcon());
		cuadros[k][m].setIcon(null);
	}
	
	private int getFila()
	{
		return Integer.parseInt(eti.getText())/10;
	}
	
	private int getCol()
	{
		return Integer.parseInt(eti.getText())%10;
	}
	
}
