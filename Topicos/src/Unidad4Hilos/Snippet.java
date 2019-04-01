package Unidad4Hilos;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;


public class Snippet
{
	final static int teclas[] = { KeyEvent.VK_H, KeyEvent.VK_O, KeyEvent.VK_L, KeyEvent.VK_A, KeyEvent.VK_SPACE,
			KeyEvent.VK_M, KeyEvent.VK_U, KeyEvent.VK_N, KeyEvent.VK_D, KeyEvent.VK_O };

	public static void main(String[] args) throws AWTException
	{
		// instanciamos la clase Robot
//		Robot robot = new Robot();
//
//		// esperamos 2 segundos antes de empezar a escribir
//		robot.delay(2000);
//
//		// iteramos a través del arreglo de teclas
//		for (int i = 0; i < teclas.length; i++)
//		{
//			// presionamos y soltamos cada tecla del array
//			robot.keyPress(teclas[i]);
//			robot.keyRelease(teclas[i]);
//
//			// dormimos el robot por 250 mili segundos luego de usar cada teclahola mundo
//			robot.delay(250);
//		}

//		Logger.getLogger(Snippet.class.getName()).log(
//	            Level.CONFIG, "Mensaje informativo...");
		try
		{
			captureScreen("g.png");
		} catch (Exception ex)
		{
			Logger.getLogger(Snippet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void captureScreen(String fileName) throws Exception { 
		   
		   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
		   Rectangle screenRectangle = new Rectangle(screenSize); 
		   Robot robot = new Robot(); 
		   BufferedImage image = robot.createScreenCapture(screenRectangle); 
		   ImageIO.write(image, "png", new File(fileName));
	}
}
