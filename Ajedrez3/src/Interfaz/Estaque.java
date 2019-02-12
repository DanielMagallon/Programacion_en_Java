package Interfaz;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Piezas.Pieza;

public class Estaque extends JLabel
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6060512035645648950L;

	private Border borde = BorderFactory.createLineBorder(Color.black);
	
	private Color defaultColor, selectedColor, marckColor; 
	
	private boolean isValid, opcional;
	
	public int fila,columna;

	public Estaque(int f, int c)
	{
		fila = f;
		columna = c;
		setBorder(borde);
		setHorizontalAlignment(SwingConstants.CENTER);
		setOpaque(true);
	}
	
	public void putPiece(Pieza pieza, int player) 
	{
		if(pieza == null)
		{
			setIcon(null);
		}else{
			
			setIcon(pieza.getPieza(player));
		}
		
	}
	
	public void setOpcional(boolean opc)
	{
		opcional=opc;
	}
	
	public boolean isOpcinal()
	{
		return opcional;
	}
	
	public void setDefaultColor(Color color)
	{
		setBackground(color);
		defaultColor=color;
	}
	
	public void setSelectedColor(Color c)
	{
		selectedColor=c;
	}
	
	private boolean selected;
	public void selected()
	{
		selected=true;
		setBackground(selectedColor);
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setColorMarck(Color c)
	{
		marckColor=c;
	}
	
	public void marck()
	{
		if(marcked)
		{
			setBackground(marckColor);
			isValid=true;
		}
		
		if(!Pieza.casillasCamino.contains(TableroAjedrez.estado.estaqueAt(fila,columna)))
		Pieza.casillasCamino.add(TableroAjedrez.estado.estaqueAt(fila,columna));
	}
	
	public static boolean marcked;
	
	public boolean isValidCasilla()
	{
		return isValid;
	}
	
	public void desmarcar()
	{
		isValid=false;
		setBackground(defaultColor);
	}
	
	public static Icon getImage(String carpeta, String file)
	{
		return new ImageIcon(ClassLoader.class.getResource(carpeta+file+".png"));
	}
	
	@Override
	public String toString() {
		return "["+fila+"] - ["+columna+"]";
	}
}
