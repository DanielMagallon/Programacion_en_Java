package Unidad1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Memorama extends Applet  
{
	
	Button btnJugar,btnSalir;
	String[][] nameImgs = 
		{
				{"im1.jpg","1"},
				{"im2.jpg","2"},
				{"im3.jpg","3"},
				{"im4.jpg","4"},
				{"im5.jpg","5"},
				{"im6.jpg","6"}
		};
	Imagenes ims[][] = new Imagenes[2][6];
	
	boolean pintarImg=true;
	
	@Override
	public void init() 
	{
		setSize(1500, 650);
		setLayout(new BorderLayout());
		
		Panel sur = new Panel();
		btnJugar= new Button("Jugar");
		btnSalir = new Button("Salir");
		
		sur.add(btnJugar);
		sur.add(btnSalir);
		add(sur,"South");
		
		btnJugar.addActionListener(
				
				(a)->{
				
					pintarImg=false;
					enJuego=true;
					repaint();
				}
			
				
				);
		
		addMouseListener(new Mouse());
		
		for(int i=0; i<ims.length; i++)
		{
			for(int j=0; j<ims[i].length; j++)
			{
				ims[i][j] = new Imagenes();
			}
		}
		
		revolver();
	}
	
	void revolver()
	{
		Collections.shuffle(Arrays.asList(nameImgs));
		
		URL url;
		
		int fila=0;
		
		for(int j=0; j<ims[0].length; j++)
		{
			url = getClass().getResource("/Unidad1/Recursos/"+nameImgs[fila][0]);
			ims[0][j].img = getImage(url);
			ims[0][j].val = nameImgs[fila][1];
			fila++;
		}
		
		Collections.shuffle(Arrays.asList(nameImgs));
		fila=0;
		for(int j=0; j<ims[0].length; j++)
		{
			url = getClass().getResource("/Unidad1/Recursos/"+nameImgs[fila][0]);
			ims[1][j].img = getImage(url);
			ims[1][j].val = nameImgs[fila][1];
			fila++;
		}
	}
	
	boolean enJuego=false;
	boolean haEscogido=false;
	boolean acerto=false;
	Method metodo;
	int i,j;
	
	@Override
	public void paint(Graphics g) 
	{
		int x = 20;
		
			for(int j=1; j<=6; j++)
			{
				g.drawRect(x, 10, 180, 280);
				g.drawRect(x, 320, 180, 280);
				x+=220;
			}
			
			if(pintarImg)
			{
				x = 50;
				int y = 50;
				for(int i=0; i<ims.length; i++)
				{
					for(int j=0; j<ims[i].length; j++)
					{
						g.drawImage(ims[i][j].img, x, y,130,200, this);
						ims[i][j].x = x;
						ims[i][j].y = y;
						x+=220;
					}
					x=50;
					y = 350;
				}
			}
			else {

				g.setColor(Color.cyan);
				x = 21;
				
				for(int j=1; j<=6; j++)
				{
					g.fillRect(x, 11, 179, 279);
					g.fillRect(x, 321, 179, 279);
					x+=220;
				}
				
				if(enJuego)
				{
					scan:
					{
					if(posFila!=-1)
					{
						g.setColor(Color.white);
						
						if(posFila==0)
						g.fillRect(ims[posFila][posCol].x-29, ims[posFila][posCol].y-39, 179, 279);
						else
							g.fillRect(ims[posFila][posCol].x-29, ims[posFila][posCol].y-29, 179, 279);
							
						g.drawImage(ims[posFila][posCol].img, ims[posFila][posCol].x,
							ims[posFila][posCol].y,130,200, this);
						
						if(!haEscogido) 
						{
							if(!ims[posFila][posCol].escogida)
							{
								i=posFila;j=posCol;
								haEscogido=true;
							}
							acerto=false;
						}
						else 
						{
							if((i == posFila && j == posCol) || ims[posFila][posCol].escogida)
								break scan;
							
							if(i==0)
								g.fillRect(ims[i][j].x-29, ims[i][j].y-39, 179, 279);
								else
									g.fillRect(ims[i][j].x-29, ims[i][j].y-29, 179, 279);
									
								g.drawImage(ims[i][j].img, ims[i][j].x,
									ims[i][j].y,130,200, this);
							
							if(posFila==0)
								g.fillRect(ims[posFila][posCol].x-29, ims[posFila][posCol].y-39, 179, 279);
								else
									g.fillRect(ims[posFila][posCol].x-29, ims[posFila][posCol].y-29, 179, 279);
									
								g.drawImage(ims[posFila][posCol].img, ims[posFila][posCol].x,
									ims[posFila][posCol].y,130,200, this);
							
							haEscogido=false;
							
							if(ims[i][j].val.equals(ims[posFila][posCol].val))
							{
								acerto=true;
								valoresIJ.add(i);
								valoresIJ.add(j);
								ims[i][j].escogida=true;
								valoresPosFC.add(posFila);
								valoresPosFC.add(posCol);
								ims[posFila][posCol].escogida=true;
							}else acerto=false;
						}
					}
					}
					int c,d;
					for(int a=0; a<valoresIJ.size(); a+=2)
					{
						c = valoresIJ.get(a);
						d = valoresIJ.get(a+1);
						
						
						if(c==0)
							g.fillRect(ims[c][d].x-29, ims[c][d].y-39, 179, 279);
							else
								g.fillRect(ims[c][d].x-29, ims[c][d].y-29, 179, 279);
								
							g.drawImage(ims[c][d].img, ims[c][d].x,
								ims[c][d].y,130,200, this);
							
						c = valoresPosFC.get(a);
						d = valoresPosFC.get(a+1);
						
						if(c==0)
							g.fillRect(ims[c][d].x-29, ims[c][d].y-39, 179, 279);
							else
								g.fillRect(ims[c][d].x-29, ims[c][d].y-29, 179, 279);
								
							g.drawImage(ims[c][d].img, ims[c][d].x,
								ims[c][d].y,130,200, this);
					}
				
					if(acerto)
						JOptionPane.showMessageDialog(this, "Ha acertado");
				}
			}
			
			
			/*
			 *
			 *        
			 * + [20-180],[240-420],[460-640],[680-860],[900-1080],[1120-1300]    &&y[10-280],
			 * + [20-180],[240-420],[460-640],[680-860],[900-1080],[1120-1300] && y[320-600]
			 */
	}
	
	ArrayList<Integer> valoresIJ = new ArrayList<Integer>();
	ArrayList<Integer> valoresPosFC = new ArrayList<Integer>();
	
	int posFila=-1,posCol=-1;
	
	class Mouse extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			if(enJuego)
			{
				if(e.getY()>=10 && e.getY()<=280)
					posFila = 0;
				
				else if(e.getY()>=320 && e.getY()<=600)
					posFila = 1;
				
				else return;
				 
				int x = e.getX();
				
				if(x>=20 && x<=200)
					posCol = 0;
				
				else if(x>=240 && x<=420)
					posCol = 1;
				
				else if(x>460 && x<=640)
					posCol = 2;
				
				else if(x>=680 && x<=860)
					posCol = 3;
				
				else if(x>=900 && x<=1080)
					posCol = 4;
				
				else if(x>=1120 && x<=1300)
					posCol = 5;
				
				else {
					posFila=-1;
					return;
				}
				
				repaint();
			}
		}
	}
	
	class Imagenes {
		Image img;
		String val;
		int x,y;
		boolean escogida=false;
	}
	
}
