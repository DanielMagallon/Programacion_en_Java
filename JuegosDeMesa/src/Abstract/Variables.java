package Abstract;

import javax.swing.ImageIcon;

import PerfomanceAjedrez.Reina;

public class Variables 
{
	public static ImageIcon reinaJ1 = getImageIcon("/Recursos/Ajedrez/reina1.png");
	public static ImageIcon reinaJ2 = getImageIcon("/Recursos/Ajedrez/reina2.png");
	
	public static ImageIcon reyJ1 = getImageIcon("/Recursos/Ajedrez/rey1.png");
	public static ImageIcon reyJ2 = getImageIcon("/Recursos/Ajedrez/rey2.png");
	
	public static ImageIcon torreJ1 = getImageIcon("/Recursos/Ajedrez/torre1.png");
	public static ImageIcon torreJ2 = getImageIcon("/Recursos/Ajedrez/torre2.png");
	
	public static ImageIcon alfilJ1 = getImageIcon("/Recursos/Ajedrez/alfil1.png");
	public static ImageIcon alfilJ2 = getImageIcon("/Recursos/Ajedrez/alfil2.png");
	
	public static ImageIcon peonJ1 = getImageIcon("/Recursos/Ajedrez/peon1.png");
	public static ImageIcon peonJ2 = getImageIcon("/Recursos/Ajedrez/peon2.png");
	
	public static ImageIcon caballoJ2 = getImageIcon("/Recursos/Ajedrez/caballo2.png"); //316363
	public static ImageIcon caballoJ1 = getImageIcon("/Recursos/Ajedrez/caballo1.png"); //B5C1C3
	

	public static final int JUGADOR_BLANCAS = 2;
	public static final int JUGADOR_NEGRAS = -JUGADOR_BLANCAS;
	
	public static Reina reina = new Reina(10);

	public static ImageIcon getImageIcon(String img)
	{
		return new ImageIcon(ClassLoader.class.getResource(img));
	}
}

