package Juego;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio
{
	
	
	public static void main(String[] args) 
	{	
		Boolean x=false,y=false;
		System.out.println(x);
		System.out.println(y);
		
		ArrayList<Boolean> lsit = new ArrayList<>();
		lsit.add(x);
		lsit.add(y);
		
		System.out.println(lsit);
		
		
//		Boolean arrA[] = arrB.clone();
//		Boolean arrC[] = arrB;
		
		System.out.println("\n");
//		
//		
//		System.out.println(arrA[0]);
//		System.out.println(arrA[1]);
//		System.out.println(arrA[2]);
//		
//		System.out.println("\n");
//		
//		System.out.println(arrC[0]);
//		System.out.println(arrC[1]);
//		System.out.println(arrC[2]);
		x= true;
		System.out.println(x);
		System.out.println(lsit);
//		Clip sonido=null;
//		
		try 
		{
			Clip sonido = AudioSystem.getClip();
			File a = new File("C:/Users/edgar/Documents/workspace_mars/Ajedrez2.0/Recursos/Music/CLICK.WAV");
			sonido.open(AudioSystem.getAudioInputStream(a));
			sonido.start();
			//Thread.sleep(1000); // 1000 milisegundos (10 segundos)
			//sonido.close();
			
		}
		catch (Exception tipoerror) {
		System.out.println("" + tipoerror);
		}
//		
//		System.out.println("Acado");
//		System.out.println(sonido.isActive());
	}
}
