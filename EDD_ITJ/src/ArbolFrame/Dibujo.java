package ArbolFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import Unidad4.ArbolBinario;
import Unidad4.NodoArbol;

public class Dibujo extends Component
{
	ArbolBinario arb;
	
	public void dibujaArbol(ArbolBinario arbol)
	{
		arb = arbol;
		arb.porNivel2();
		repaint();
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		dibujarNodo(g);
	}

	public int dim = 60;
	
	public void dibujarNodo(Graphics g)
	{
//		ArrayList<NodoArbol> l2;
//		int x=30,y=30;
//		
//		for(int i=0; i<arb.list.size(); i++)
//		{
//			l2 = arb.list.get(i);
//			for(int j=0; j<l2.size(); j++)
//			{
//				g.drawString(l2.get(j).toString(), getWidth()/x, y);
//				x+=5;
//			}
//			x=30;
//			y+=20;
//		}
	}
	
}
