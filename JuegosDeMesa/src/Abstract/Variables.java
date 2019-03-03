package Abstract;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import PerfomanceAjedrez.Alfil;
import PerfomanceAjedrez.Caballo;
import PerfomanceAjedrez.Peon;
import PerfomanceAjedrez.Reina;
import PerfomanceAjedrez.Rey;
import PerfomanceAjedrez.Torre;

public class Variables 
{
	
	public static Image reinaJ1 = getImage("/Recursos/Ajedrez/reina1.png");
	public static Image reinaJ2 = getImage("/Recursos/Ajedrez/reina2.png");
	
	public static Image reyJ1 = getImage("/Recursos/Ajedrez/rey1.png");
	public static Image reyJ2 = getImage("/Recursos/Ajedrez/rey2.png");
	
	public static Image torreJ1 = getImage("/Recursos/Ajedrez/torre1.png");
	public static Image torreJ2 = getImage("/Recursos/Ajedrez/torre2.png");
	
	public static Image alfilJ1 = getImage("/Recursos/Ajedrez/alfil1.png");
	public static Image alfilJ2 = getImage("/Recursos/Ajedrez/alfil2.png");
	
	public static Image peonJ1 = getImage("/Recursos/Ajedrez/peon1.png");
	public static Image peonJ2 = getImage("/Recursos/Ajedrez/peon2.png");
	
	public static Image caballoJ2 = getImage("/Recursos/Ajedrez/caballo2.png"); //316363
	public static Image caballoJ1 = getImage("/Recursos/Ajedrez/caballo1.png"); //B5C1C3
	

	public static final int JUGADOR_BLANCAS = 2;
	public static final int JUGADOR_NEGRAS = -JUGADOR_BLANCAS;
	
	public static Reina reina = new Reina(10);
	public static Rey rey = new Rey(15);
	public static Alfil alfil = new Alfil(3);
	public static Torre torre = new Torre(7);
	public static Caballo caballo = new Caballo(5);
	public static Peon peon = new Peon(1);
	
	public static int iFor,jFor;
	
	public static Image getImage(String img)
	{
		//
		Image i=null;
		try 
		{
			i = ImageIO.read(new File(System.getProperty("user.dir")+"/src/"+img));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}

