package ReadImage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Reader 
{
	BufferedImage imageRead;
	Graphics gra;
	
	public Reader() 
	{
		imageRead = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		gra = imageRead.getGraphics();
		
		gra.setColor(Color.red);
		gra.fillRect(50, 50, 100, 100);
		gra.setColor(Color.green);
		gra.fillRect(0, 0, 50, 50);
		gra.setColor(Color.yellow);
		gra.fillOval(25, 25, 50, 50);
		
		try {
			   ImageIO.write(imageRead, "jpg", new File("foto.jpg"));
			} catch (IOException e) {
			   System.out.println("Error de escritura");
			}
	}
	
	public static void main(String[] args) 
	{
		new Reader();
	}
}
