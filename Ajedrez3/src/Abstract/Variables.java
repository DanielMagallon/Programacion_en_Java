package Abstract;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Piezas.Alfil;
import Piezas.Caballo;
import Piezas.Peon;
import Piezas.Reina;
import Piezas.Rey;
import Piezas.Torre;

public class Variables {

	public static int k,l;
	
	public static final Icon REY1 = getImage("\\Chess\\", "rey"); 
	public static final Icon REY2 = getImage("\\Chess\\", "rey2"); 
	
	public static final Icon ALFIL = getImage("\\Chess\\", "alfil");
	public static final Icon ALFIL2 = getImage("\\Chess\\", "alfil2");
	
	public static final Icon CABALLO = getImage("\\Chess\\", "caballo");
	public static final Icon CABALLO2 = getImage("\\Chess\\", "caballo2");
	
	public static final Icon PEON = getImage("\\Chess\\", "peonB");
	public static final Icon PEON2 = getImage("\\Chess\\", "peonN");
	
	public final static Icon REINA = getImage("\\Chess\\", "reina");
	public final static Icon REINA2 = getImage("\\Chess\\", "reina2");
	
	public static final Icon TORRE = getImage("\\Chess\\", "torre");
	public static final Icon TORRE2 = getImage("\\Chess\\", "torre2");
	
	public static final int JUGADOR_NEGRAS = 2;
	public static final int JUGADOR_BLANCAS = ~JUGADOR_NEGRAS;
	public static boolean turnoBlancas=true;
	
	public static boolean reyNegroMeneado,reyBlancoMeneado, torreNegraCM, torreNegraLM,
							torreBlancaCM, torreBlancaLM;
	
	public static final int [][] movsCaballo = 
		{
				{-2,-1},
				{-2,1},	
				{2,-1},
				{2,1},
				{-1,-2},
				{1,-2},
				{-1,2},
				{1,2}
		};
	
	public static final int ARRIBA = 0;
	public static final int ABAJO = 1;
	public static final int IZQUIERDA = 2;
	public static final int DERECHA = 3;
	public static final int ABAJO_DER = 4;
	public static final int ARRIBA_IZQ = 5;
	public static final int ARRIBA_DER = 6;
	public static final int ABAJO_IZQ = 7;
	
	public static int indexEvaluado; 
	
//	\\\\No menear posiciones
	public final static int[][] movsLibre =
		{
				{-1,0},//Arriba
				{1,0},//abajo
				{0,-1},//Izq
				{0,1},//Der
				
				{1,1},//Abajo-Der
				{-1,-1},//Arriba-Izq
				{-1,1},//Arriba-Der
				{1,-1},//Abajo-Izq
		};
	
	public static Rey rey = new Rey(10); 
	public static Reina reina = new Reina(5);
	public static Torre torre = new Torre(4);
	public static Alfil alfil = new Alfil(3);
	public static Caballo caballo = new Caballo(2);
	public static Peon peon = new Peon(1);
	
	public static Icon getImage(String carpeta, String file)
	{
		
		return new ImageIcon(System.getProperty("user.dir")+carpeta+file+".png");
	}
}
