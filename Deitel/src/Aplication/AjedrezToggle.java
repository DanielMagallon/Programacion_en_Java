package Aplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


public class AjedrezToggle extends JFrame
{
	static JToggleButton[][] cuadros;
	JPanel centro,este, oeste;
	final int TAMANIO;
	static boolean sigueBlanco=true, hasIcon=false, isFisrtMovP1=true, isFisrtMovP2=true, 
			isTurnP1=true, haEscogido, canEat,isPlayer1=false,siPuede;
	String piezaPeon="peon0";	
	static int newFila, newCol, fila, col, peonesToLeft=0, peonesToRight=0,filaActual, columnaActual,
			indiceFila1, indiceFila2, indiceColumna1, indiceColumna2;
	
	static JToggleButton toggle, respTogle,togNew;
	JLabel bancsP1[][], bancsP2[][];
	static String piezasPrinc[] = {"torre","horse","alfil","queen","rey"};
	Icon respIconOld;
	Peon peon;
	public AjedrezToggle()
	{
		TAMANIO=8;
		setLayout(new BorderLayout());

		centro = new JPanel();
		centro.setLayout(new GridLayout(TAMANIO, TAMANIO));
		cuadros = new JToggleButton[TAMANIO][TAMANIO];

		putBancas();
		addTablero();
		putMorePiece();
		instanceClass();
		
		add(este, BorderLayout.EAST);
		add(centro, BorderLayout.CENTER);
		add(oeste, BorderLayout.WEST);
		
		
		setSize(900,700);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
		
	}
	
	private void instanceClass()
	{
		peon = new Peon();
	}
	
	private void addIconToLabels(JLabel lab, int i, int j)
	{
//		if(i<=4)
//		{
//			lab.setIcon(addIcon(piezasPrinc[i]+"B"));
//		}
//		else
//		{
//			lab.setIcon(addIcon(piezasPrinc[i-5]+"B"));
//		}
	}
	
	private void putBancas()
	{
		GridLayout grid = new GridLayout(TAMANIO, 2);
		
		bancsP1 = new JLabel[8][2];
		oeste = new JPanel(grid); 
		
		bancsP2 = new JLabel[8][2];
		este = new JPanel(grid);

		for (int i=0; i<bancsP1.length; i++)
		{
			for (int j=0; j<bancsP2[i].length; j++)
			{
				bancsP1[i][j] = new JLabel();
				bancsP2[i][j] = new JLabel();
				
				bancsP1[i][j].setName(i+""+j);
				bancsP2[i][j].setName(i+""+j);
				
//				if(j==0)
//				{
//					bancsP1[i][j].setIcon(addIcon("peonB"));
//					addIconToLabels(bancsP2[i][j], i, j);
//				}
//				else
//				{
//					bancsP2[i][j].setIcon(addIcon("peonB"));
//					addIconToLabels(bancsP1[i][j], i, j);
//				}
				
				oeste.add(bancsP1[i][j]);
				este.add(bancsP2[i][j]);
			}
		}
	}
	
	private void addTablero()
	{
		for (int i=0; i<TAMANIO; i++)
		{
			for (int j=0; j<TAMANIO; j++)
			{
				cuadros[i][j] = new JToggleButton();
				cuadros[i][j].addMouseListener(new MouseC());
				cuadros[i][j].setName(i+""+j);
				checarColor(i, j);
				
				if(i==1 || i==6)
					putPeones(i, j);
					
				
				centro.add(cuadros[i][j]);
			}
		}
	}
	
	private void putMorePiece()
	{
//		for (int i=0; i<piezasPrinc.length; i++)
//		{
//			cuadros[0][i].setIcon(addIcon(piezasPrinc[i]+"1"));
//			cuadros[7][i].setIcon(addIcon(piezasPrinc[i]+"2"));
//			
//			if(i<3)
//			{
//			cuadros[0][TAMANIO-1-i].setIcon(addIcon(piezasPrinc[i]+"1"));
//			cuadros[7][TAMANIO-1-i].setIcon(addIcon(piezasPrinc[i]+"2"));
//			}
//		}
	}
	
//	private Icon addIcon(String name)
//	{
//		return new ImageIcon(getClass().getResource("/Aplication/Ajz/"+name+".png"));
//	}
	
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
//		if(i==6 && !piezaPeon.equals("peonYell0")) 
//			piezaPeon="peonYell0";
//		
//		cuadros[i][j].setIcon(new ImageIcon(getClass().getResource("/Aplication/Ajz/"+piezaPeon+".png")));
	}
	
	private void setFalseHasIconChosed()
	{
		hasIcon=false;
		haEscogido=false;
	}
	
	private void whenTogNewEqNull()
	{
		togNew.setIcon(toggle.getIcon());
		toggle.setSelected(false);
		toggle.setIcon(null);
		newFila = getNewFila();
		newCol = getNewCol();
	}
	
	private boolean hizoMovimientoValido()
	{
		return peon.getFilaOfToogle(togNew) == indiceFila1 && 
				peon.getColumnOfToogle(togNew) == indiceColumna1 
			   || peon.getFilaOfToogle(togNew) == indiceFila2 && 
					   peon.getColumnOfToogle(togNew) == indiceColumna2;
	}
	
	private void siPuedeComerEnDiag()
	{
			////////Aqui se lo come
					if(togNew.getIcon()!=null)
					{
						if(hizoMovimientoValido())
						{
						if(peon.isOfPlayer1(toggle))
						{
							if(isTurnP1)
							{
								if(peon.isPeonP2())
								{
									bancsP1[peonesToLeft][0].setIcon(togNew.getIcon());
									peonesToLeft++;
								}
							}
							else
							{
								showMessage("Lo siento no era tu turno");
								toggle.setSelected(false);
								return;
							}
						}
						else
						{
							
							if(!isTurnP1)
							{
								if(peon.isPeonP1())
								{
								bancsP2[peonesToRight][1].setIcon(togNew.getIcon());
								peonesToRight++;
								}
							}
							else
							{
								showMessage("Lo siento no era tu truno");
								toggle.setSelected(false);
								return;
							}
						}
						whenTogNewEqNull();
						setFalseHasIconChosed();
						isTurnP1=!isTurnP1;
						return;
						}
						else
						{ 
							//showMessage("invalido");//String.format("Se hizo un movieneto %s"
									//,(hizoMovimientoValido()) ? "valido" : "invalido"));
							toggle.setSelected(false);
							//togNew.setSelected(false);
							setFalseHasIconChosed();
							return;
						}
					}
					else
					{
						whenTogNewEqNull();
					}

					if(peon.isPeonP1() || peon.isPeonP2())
					{
						walkPeon();
						togNew.setSelected(true);
					}
	}
	
	private void menear()
	{
		if(togNew != toggle)
		{
			if(haEscogido)
			{
				if(siPuede)
				{
					siPuedeComerEnDiag();
				}
				
				else if(togNew.getIcon()==null)
				{
					whenTogNewEqNull();
				}
				else 
				{
					togNew.setSelected(true);
					return;
				}

				try
				{
				if(peon.isPeonP1() || peon.isPeonP2())
				{
					if(!siPuede)
					walkPeon();
				}
				}catch (NullPointerException ex){}
			}
		}
	}
	
	private void escoger()
	{
		hasIcon = toggle.getIcon()!=null;
		haEscogido=true;
		fila = getOldFila();
		col = getOldCol(); 
		respTogle = toggle;
		
		if(togNew!=null)
			togNew.setSelected(false);
	}
	

	private class MouseC extends MouseAdapter
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			System.out.println(String.format("Pl %s", (isTurnP1) ? "1" : "2"));
			
			if(hasIcon)
			{
				togNew = (JToggleButton) e.getComponent();
				menear();
				setFalseHasIconChosed();
			}
			else
			{
				if(haEscogido)
					toggle.setSelected(false);
				
				toggle = (JToggleButton) e.getComponent();
				getActualPosition((JToggleButton)e.getComponent());
				escoger();
			}
		}
	}
	
	private void getActualPosition(JToggleButton tog)
	{
		if(tog.getIcon()!=null)
		{
			isPlayer1=peon.isOfPlayer1(tog);
			siPuede=peon.canEatDiagonalPlayerX(tog);
		}
	}

	/*private boolean isPeonP2()
	{
		return getRouteIcon().contains("peonYell0.png") ;
	}
	
	private boolean isPeonP1()
	{
		return getRouteIcon().contains("peon0.png");
	}
	
	private boolean isTorreP1()
	{
		return getRouteIcon().contains("torre1.png");
	}
	
	private boolean isTorreP2()
	{
		return getRouteIcon().contains("torre2.png");
	}

	private boolean isHorseP1()
	{
		return getRouteIcon().contains("horse1.png");
	}
	
	private boolean isHorseP2()
	{
		return getRouteIcon().contains("horse2.png");
	}
	
	private boolean isAlfilP1()
	{
		return getRouteIcon().contains("alfil1.png");
	}
	
	private boolean isAlfilP2()
	{
		return getRouteIcon().contains("alfil2.png");
	}
	
	private boolean isQueenP1()
	{
		return getRouteIcon().contains("queen1.png");
	}
	
	private boolean isQueenP2()
	{
		return getRouteIcon().contains("queen2.png");
	}
	
	private boolean isKingP1()
	{
		return getRouteIcon().contains("rey1.png");
	}
	
	private boolean isKingP2()
	{
		return getRouteIcon().contains("rey2.png");
	}
	
	private String getRouteIcon()
	{
	  return togNew.getIcon().toString();
	}*/
	
	private void walkPeon()
	{
		if(isTurnP1)
		{
			if(!peon.isPeonP2())
			{
			isFisrtMovP1 = fila==1 && col>=0 && col<=7;
				
				if(isFisrtMovP1)
				{
					if(newFila-2 != fila && newFila-1 != fila || newCol != col)
					{
						validPeon();
						return;
					}
					
				}
				
				else
				{
					if(newFila-1 != fila || newCol != col)
					{
						validPeon();
						return;
					}
					
				}
			isTurnP1=false;
			}
			
			else
			{
				toggle.setIcon(togNew.getIcon());
				togNew.setIcon(null);
			}
		}
	
		else
		{
			if(!peon.isPeonP1())
			{
			isFisrtMovP2 = fila==6 && col>=0 && col<=7;
			
			if(isFisrtMovP2)
			{
				if(newFila+2 != fila && newFila+1 != fila || newCol != col)
				{
					validPeon();
					return;
				}
				
			}
			else
			{
				if(newFila+1 != fila || newCol != col)
				{
					validPeon();
					return;
				}
				
			}
			isTurnP1=true;
			}
			else
			{
				toggle.setIcon(togNew.getIcon());
				togNew.setIcon(null);
			}
		}
	}
	
	private void validPeon()
	{
		
		toggle.setIcon(togNew.getIcon());
		togNew.setIcon(null);
	}

	private int getOldFila()
	{
		return Integer.parseInt(toggle.getName())/10;
	}
	
	private int getOldCol()
	{
		return Integer.parseInt(toggle.getName())%10;
	}
	
	private int getNewFila()
	{
		return Integer.parseInt(togNew.getName())/10;
	}
	
	private int getNewCol()
	{
		return Integer.parseInt(togNew.getName())%10;
	}
	
	private void showMessage(String mess)
	{
		JOptionPane.showMessageDialog(null, mess);
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			
			@Override
			public void run()
			{
				new AjedrezToggle().setVisible(true);
			}
		});
	}
}
