package Proyecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import Libreria.Grafica;

public class AreaDibujo extends JPanel implements Serializable
{

	private static final long serialVersionUID = -2210544801040938245L;
	public Grafica gr = new Grafica();

	public String cad="";
	
	private int TYPO_GRAFICA; 
	
	private transient BufferedImage bi;
	private transient Graphics2D g2d;
	
	private Eventos evento;
	
	private boolean imgFondo=false;
	
	private transient Image img;

	private int xFig,yFig;
	 
	
	public AreaDibujo()
	{
		TYPO_GRAFICA = Grafica.BARRAS;
		xFig = 100;
		yFig = 150;
		gr.setNewXY(xFig, yFig);
		addMouseWheelListener(evento = new Eventos());
		addMouseMotionListener(evento);
		addMouseListener(evento);

	}
	
	public void fondo(Image img)
	{
		imgFondo = true;
		this.img = img;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		drawOnImage();
		
		g2.drawImage(bi, null, this);

	}
	
	public void espaciado(int barr)
	{
		gr.espaciadoBarras(barr);
		repaint();
	}
	
	public void rotarBarras()
	{
		gr.rotateBarras(!gr.isVerticalOrientation());
		repaint();
	}
	
	public void rotar(int ang)
	{
		gr.setRotacion(gr.getAnguloRotacion()+ang);
		repaint();
	}
	
	public void disminuir()
	{
		if(TYPO_GRAFICA == Grafica.PASTEL)
		{
			if(gr.getRadio()>=200)
			{
				gr.setRadio(gr.getRadio()-30);
				repaint();
			}	
		}
		else if(TYPO_GRAFICA == Grafica.BARRAS)
		{
			if(gr.getAnchoBarr()>=Grafica.ANCHO_MINIMO)
			{
				gr.cambiarAncho(-5);
				repaint();
			}
		}
	}
	
	public void aumentar()
	{
		if(TYPO_GRAFICA == Grafica.PASTEL)
		{
			gr.setRadio(gr.getRadio()+30);
			repaint();
		}
		else if(TYPO_GRAFICA == Grafica.BARRAS)
		{
			if(gr.getAnchoBarr()<=Grafica.ANCHO_MAXIMO)
			{
				gr.cambiarAncho(5);
				repaint();
			}
		}
		
	}
	
	public boolean setTypeGraph(int type)
	{
		if(gr.byPorcentaes && type == Grafica.PASTEL)
		{
			JOptionPane.showMessageDialog(null,"No es posible graficar por porcentajes con barra de pasteles\n"
					+ "Ayuda: Deshabilite la opcion de graficar por porcentaje",
					"Graficacion no valida",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else
		{
			TYPO_GRAFICA = type;
			repaint();
			return true;
		}
	}
	
	public int getTypheGraph()
	{
		return TYPO_GRAFICA;
	}
	
	public void setPositionTitle(int p)
	{
		gr.setTitleOrientation(p);
		repaint();
	}
	
	

	protected void drawOnImage() 
	{
//		if(bi==null)
		{
			bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
			g2d = bi.createGraphics();
			
		}

		if(imgFondo)
			g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);

		gr.setTitle(g2d, cad);
		
		if(TYPO_GRAFICA == 1)
		{
			gr.dibujarBarraPastel(g2d, xFig, yFig);
		}
		else if(TYPO_GRAFICA == 2)
		{
			gr.dibujarGraficaBarras(g2d, xFig, yFig);
		}

		
		
	}
	
	@Override
	public void setBackground(Color arg0)
	{
		super.setBackground(arg0);
		imgFondo = false;
		repaint();
	}

	public void crearPNG()
	{
		try
		{
			String title = gr.getTitle();
			
			while(title.trim().isEmpty())
			{
					title = JOptionPane.showInputDialog(null, "Nombre de la imagen: ",
							"Guardando como imagen");
				
				if(title==null)
					return;
					
				if((title.trim().isEmpty()))
				JOptionPane.showMessageDialog(null,"Tiene que especificar un nombre a la imagen",
						"Error",JOptionPane.ERROR_MESSAGE);
				
				 
			}
			
			
			File f = new File(PathGeneral.rutaRecursos.getPath()+"/ImagesCreadas/"+title+".png");
			ImageIO.write(bi, "png", f);
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	class Eventos extends MouseAdapter
	{
		private JPopupMenu popupMenu;
		private int indice;
		private Color color;
		
		public Eventos()
		{
			popupMenu = new JPopupMenu();
			
			JMenuItem nombre = new JMenuItem("Cambiar nombre categoria");
			
			nombre.addActionListener((a)->{
				
				String name = JOptionPane.showInputDialog(null, 
						"Nuevo nombre: ","Categoria: "+gr.getCategorias()[indice],
						JOptionPane.INFORMATION_MESSAGE);
				
				if(name!=null)
				{
					gr.getCategorias()[indice] = name;
					repaint();
				}
			});
			
			JMenuItem color = new JMenuItem("Cambir color categoria");
			
			color.addActionListener((a)->
				{
					Color col = JColorChooser.showDialog(null, "Color de la categoria", 
							this.color);
					
					if(col != null && col!=this.color)
					{
						gr.getColores()[indice] = col;
						this.color = col;
						repaint();
					}
				}
			);
			
			popupMenu.add(nombre);
			popupMenu.add(color);
		}
		
		@Override
		public void mouseClicked(MouseEvent e)
		{
			
			if(e.getClickCount()==2)
			{
				xFig = e.getX();
				yFig = e.getY();
				
				gr.setNewXY(xFig, yFig);
				
				AreaDibujo.this.repaint();
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e)
		{
				if(getCursor()==Appi.cursorSeleccion)
				{
					popupMenu.show(AreaDibujo.this, e.getX(), e.getY());
				}
		}
		
		@Override
		public void mouseMoved(MouseEvent e)
		{
			if(gr.posicionesXYClick!=null)
				for(int i=0; i<gr.posicionesXYClick.length; i++)
				{
					
					if(e.getX()>=gr.posicionesXYClick[i][0] && 
					   e.getX()<=gr.posicionesXYClick[i][1] &&
					   e.getY()>=gr.posicionesXYClick[i][2] && 
					   e.getY()<=gr.posicionesXYClick[i][3])
					{
						indice = i;
						color = gr.getColores()[i];
						setCursor(Appi.cursorSeleccion);
						break;
					}else {
						setCursor(null);
					}
				}
		}
		
		
		@Override
		public void mouseWheelMoved(MouseWheelEvent e)
		{
			if(e.getWheelRotation()==-1)
				aumentar();
				
			else disminuir(); 
		}
		
		@Override
		public void mouseReleased(MouseEvent e)
		{
			setCursor(null);
		}
		
		@Override
		public void mouseDragged(MouseEvent e)
		{
			setCursor(Appi.cursorCruz);
			xFig= e.getX();
			yFig = e.getY();

			gr.setNewXY(xFig, yFig);
			
			AreaDibujo.this.repaint();
		}
		
	}
}
