 package ProyectoColasU3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelCola extends JPanel
{
	
	private static final long serialVersionUID = -1158298061516213866L;
	BufferedImage mosaico, manag1,manag2,manag3;
	public static BufferedImage embarazada, discapacitado,normal;
	boolean creaProcesos;

	public static Estudiante alumnos[];
	
	public Timer timerP1,timerP2,timerP3;
	int tiempoLlegada=2000;
	
	public void destroy()
	{
		timerP1 = timerP2 = timerP3 = null;
		colaP1 = colaP2 = colaP3 = null;
	}
	
	public boolean hayEjecucion()
	{
		boolean p1,p2,p3;
		
		if(timerP1==null)
			p1=false;
		
		else p1 = timerP1.isRunning();
		
		if(timerP2==null)
			p2=false;
		
		else p2 = timerP2.isRunning();
		
		if(timerP3==null)
			p3=false;
		
		else p3 = timerP3.isRunning(); 
			
		return p1 || p2 || p3;
	}
	
	public void play()
	{
		timerP1.start();
		
		if(timerP2!=null)
			timerP2.start();
		
		if(timerP3!=null)
			timerP3.start();
	}
	
	ColaEstudiantes colaP1;
	String entroP1;
	public void timerProceso1()
	{
		timerP1 = new Timer(tiempoLlegada, new ActionListener()
		{
			int max = (alumnos.length>10) ? 9 : alumnos.length-1;
			int i=0;
			
			{
				p1Listo=false;				
				colaP1 = new ColaEstudiantes(max+1);
			}
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				colaP1.addAlumn(alumnos[i].getNombre(), alumnos[i].getPriority());
				entroP1 = alumnos[i].toString();
				repaint();
				
				i++;
				timerP1.stop();
				
				if(i<=max)
				timerP1.start();
				
				else
					p1Listo=true;
			}
		});
	}
	
	ColaEstudiantes colaP2;
	String entroP2;
	public void timerProceso2()
	{
		timerP2 = new Timer(tiempoLlegada, new ActionListener()
		{
			int max = (alumnos.length>=20) ? 19 : alumnos.length-1;
			int a=10;
			
			{
				p2Listo=false;
				colaP2 = new ColaEstudiantes(max-9);
			}
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				colaP2.addAlumn(alumnos[a].getNombre(), alumnos[a].getPriority());
				entroP2 = alumnos[a].toString();
				repaint();
				
				a++;
				timerP2.stop();
				
				if(a<=max)
					timerP2.start();
				
				else p2Listo=true;
			}
		});
	}
	
	ColaEstudiantes colaP3;
	String entroP3;
	public void timerProceso3()
	{
		timerP3 = new Timer(tiempoLlegada, new ActionListener()
		{
			int i=20;
			
			{
				p3Listo = false;
				colaP3 = new ColaEstudiantes(alumnos.length-20);
			}
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				colaP3.addAlumn(alumnos[i].getNombre(), alumnos[i].getPriority());
				entroP3=alumnos[i].toString();
				repaint();
				
				i++;
				timerP3.stop();
				
				if(i<alumnos.length)
					timerP3.start();
				
				else  p3Listo = true;
			}
		});
	}
	
	public PanelCola()
	{
		
		setBackground(Color.white);
		
		try
		{
			mosaico = ImageIO.read(ClassLoader.class.getResource("/ProyectoColasU3/moscaf.jpg"));
			manag1 = ImageIO.read(ClassLoader.class.getResource("/ProyectoColasU3/seller.png"));
			manag2 = ImageIO.read(ClassLoader.class.getResource("/ProyectoColasU3/professor.png"));
			manag3 = ImageIO.read(ClassLoader.class.getResource("/ProyectoColasU3/woman.png"));
			
			
			embarazada = ImageIO.read(ClassLoader.class.getResource("/ProyectoColasU3/pregnant3.png"));
			discapacitado = ImageIO.read(ClassLoader.class.getResource("/ProyectoColasU3/disabled2.png"));
			normal = ImageIO.read(ClassLoader.class.getResource("/ProyectoColasU3/men-and-women-toilet3.png"));
		}
		catch (IOException ex)
		{
			
		}
	}
	
	public void crearImagen(Graphics g)
	{
		g.drawImage(mosaico, 0, 0,700,104,this);
		g.drawImage(manag1, 15, 40,this);
			
		g.drawImage(mosaico, 0, 104,700,104,this);
		g.drawImage(manag2, 15, 140, this);
		
		g.drawImage(mosaico, 0, 104*2,700,104,this);
		g.drawImage(manag3, 15, 250,this);
		
		g.drawLine(55, 0, 55, 308);
		
		g.setFont(agencyFB14);
		g.drawString("Cola 1", 10, 20);
		g.drawString("Cola 2", 10, 124);
		g.drawString("Cola 3", 10, 124+104);
		
		dibujarLugares(g,40,80);
		dibujarLugares(g,140,80);
		dibujarLugares(g,250,80);
		
		if(creaProcesos)
			crearProcesos(g);
	}
	
	private void dibujarLugares(Graphics g, int posYlugar, int posXLugar)
	{
		for(int i=1; i<=10; i++)
		{
			g.drawRect(posXLugar, posYlugar, 30, 30);
			posXLugar += 40;
		}
	}
	
	boolean p1Listo;
	
	boolean p2Listo;
	
	
	boolean p3Listo;
	
	Font serifBold40 = new Font(Font.SERIF, Font.BOLD, 48);
	Font agencyFB14=new Font("Agency FB", Font.BOLD, 14);
	
	private void crearProcesos(Graphics g)
	{

		g.drawString("Entro el alumno: "+entroP1, 475, 60);
		
		colaP1.iteracion(g, this, 40);
		
		if(p1Listo)
		{
			g.setFont(serifBold40);
			g.drawString("COLA 1 LISTA", 120, 70);
			g.setFont(agencyFB14);
		}
		
		if(colaP2!=null)
		{
			g.drawString("Entro el alumno: "+entroP2, 475, 160);
			colaP2.iteracion(g, this, 140);
			if(p2Listo)
			{
				g.setFont(serifBold40);
				g.drawString("COLA 2 LISTA", 120, 170);
				g.setFont(agencyFB14);
			}
		}
		
		if(colaP3!=null)
		{
			g.drawString("Entro el alumno: "+entroP3, 475, 265);
			colaP3.iteracion(g, this, 250);
			if(p3Listo)
			{
				g.setFont(serifBold40);
				g.drawString("COLA 3 LISTA", 120, 275);
				g.setFont(agencyFB14);
			}
		}
		
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		  crearImagen(g);
	}
	
	
	
}
