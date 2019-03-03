package JuegosMesa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
			isTurnP1=true, haEscogido, canEat,isPlayer1=false,siPuede,isTorre, isPeon, isAfil;
	static String piezaPeon="peon0";	
	static int newFila, newCol, fila, col, peonesToLeft=0, peonesToRight=0,filaActual, columnaActual,
				indiceFila1, indiceFila2, indiceColumna1, indiceColumna2,
				MaxFilasToUp, MaxFilasToDown, MaxColumnasToLeft, MaxColumnasToRight,
				maxDownRigth, maxDownLeft, maxUpRigth, maxUpLeft; 
	
	static JToggleButton toggle,togNew,respTogle, auxTogleNuevo;
	static JLabel bancsP1[][], bancsP2[][];
	static String piezasPrinc[] = {"torre","horse","alfil","queen","rey"}; 
	static String ficha;
	Icon respIconOld;
	static Peon peon;
	static Procces pro;
	static Torre torres;
	static Alfil alfil;
	static Peones p;
	static Queen queen;
	static Caballo horse;
	static King rey;
	JMenuBar barMenu;
	JMenu juego;
	JMenuItem menuItRest;
	Restart rest;
	
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
		createComps();
		
		add(barMenu, BorderLayout.NORTH);
		add(este, BorderLayout.EAST);
		add(centro, BorderLayout.CENTER);
		add(oeste, BorderLayout.WEST);
		
		setSize(900,700);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
		
	}
	
	private void instanceClass()
	{
		rest = new Restart();
		
		p = new Peones();
		peon = new Peon();
		pro = new Procces();
		torres = new Torre();
		alfil = new Alfil();
		horse =  new Caballo();
		queen = new Queen();
		rey = new King();
	}
	
	private void createComps()
	{
		barMenu = new JMenuBar();
		juego = new JMenu("Juego");
		menuItRest = new JMenuItem("Reiniciar");
		
		juego.add(menuItRest);
		barMenu.add(juego);
		
		menuItRest.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				long i = System.currentTimeMillis();
				rest.restart();
				System.out.println("M tarde: " + (System.currentTimeMillis() - i));
			}
		});
	}
	
	
	public void addIconToLabels(JLabel lab, int i, int j)
	{
		if(i<=4)
		{
			lab.setIcon(addIcon(piezasPrinc[i]+"B"));
		}
		else
		{
			lab.setIcon(addIcon(piezasPrinc[i-5]+"B"));
		}
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
				
				if(j==0)
				{
					bancsP1[i][j].setIcon(addIcon("peonB"));
					addIconToLabels(bancsP2[i][j], i, j);
				}
				else
				{
					bancsP2[i][j].setIcon(addIcon("peonB"));
					addIconToLabels(bancsP1[i][j], i, j);
				}
				
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
		for (int i=0; i<piezasPrinc.length; i++)
		{
			cuadros[0][i].setIcon(addIcon(piezasPrinc[i]+"1"));
			cuadros[7][i].setIcon(addIcon(piezasPrinc[i]+"2"));
			
			if(i<3)
			{
			cuadros[0][TAMANIO-1-i].setIcon(addIcon(piezasPrinc[i]+"1"));
			cuadros[7][TAMANIO-1-i].setIcon(addIcon(piezasPrinc[i]+"2"));
			}
		}
	}
	
	private Icon addIcon(String name)
	{
		return new ImageIcon(getClass().getResource("/Aplication/Ajz/"+name+".png"));
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
	
	public void putPeones(int i, int j)
	{
		if(i==6 && !piezaPeon.equals("peonYell0")) 
			piezaPeon="peonYell0";
		
		cuadros[i][j].setIcon(new ImageIcon(getClass().getResource("/Aplication/Ajz/"+piezaPeon+".png")));
	}
	
	private void escoger()
	{
		hasIcon = toggle.getIcon()!=null;
		haEscogido=true;
		fila = getOldFila();
		col = getOldCol(); 
		
		if(togNew!=null)
			togNew.setSelected(false);
	}
	
	
	private class MouseC extends MouseAdapter
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			respTogle = (JToggleButton) e.getComponent();
			
			if(respTogle.getIcon()!=null)
			{
				WichIs.setRuta(respTogle.getIcon().toString());
				WichIs.setIcon(respTogle.getIcon());
			}
			
			if(hasIcon)
			{
				togNew = (JToggleButton) e.getComponent();
				pro.Move();
				//setFalseHasIconChosed();
			}
			else
			{
				if(haEscogido)
					toggle.setSelected(false);
				
				toggle = (JToggleButton) e.getComponent();
				getActualPosition();
				escoger();
			}
		}
	}
	
	private void getActualPosition()
	{
		if(toggle.getIcon()!=null)
		{
			isPlayer1=peon.isOfPlayer1(toggle);
			
			siPuede=peon.canEatDiagonalPlayerX(toggle);
			
			p.walkPeon();
			
			if(torres.getPiece().isTower())
			{
				isTorre=true;
				torres.walkTorre();
				return;
			}
			else
			{
				isTorre=false;
			}
			
			if(alfil.getPiece().isAlfil())
			{
				isAfil = true;
				alfil.walkAlfil(); 
				return;
			}
			else 
				isAfil=false;
			
			if(queen.getPiece().isQueen())
			{
				queen.walkQueen();
				return;
			}

			if(horse.getPiece().isHorse())
			{
				horse.walkHorse();
				return;
			}
			
			if(rey.getPiece().isKing())
			{
				rey.waklKing();
				return;
			}
		}
	}

	private int getOldFila()
	{
		return Integer.parseInt(toggle.getName())/10;
	}
	
	private int getOldCol()
	{
		return Integer.parseInt(toggle.getName())%10;
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
