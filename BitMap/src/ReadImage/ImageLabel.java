package ReadImage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageLabel extends JLabel implements MouseListener
{
	static BufferedImage imaRead;
	ImageIcon imagen;
	int x, y;
	int altura, ancho;
	Graphics gr;
	static File file;
	
	public ImageLabel() 
	{
		
		
		 file = new File("C:/Users/Daniel/Documents/workspace Mars/Graficos/src/imagenes/milotic.jpg");
		
		try 
		{
			imaRead = ImageIO.read(file);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		imagen = new ImageIcon(imaRead);
		
		altura = imagen.getIconHeight();
		ancho = imagen.getIconWidth();
		setIcon(imagen);
		addMouseListener(this);
		
		gr = imaRead.getGraphics();
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		x=e.getX();
		y=e.getY();
		System.out.println("X: "+x);
		System.out.println("Y: "+y);
		pintar();
		repaint();
	}

	private void pintar()
	{
		gr.setColor(Color.red);
		for (int k=0; k<=ancho; k+=20)
		{
			for (int i=y; i<=altura*2; i++)
			{
			//dibuja una linea vertical
				gr.drawLine(x,i,x+2,i);
				//imagen.paintIcon(this, getGraphics(), x-2, y);
			}
			x+=20;
			//dibuja una linea horizonas
			//g.drawLine(x,y,ancho,y);
			//repaint();
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) 
	{
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(2);
		f.add(new ImageLabel());
		f.setVisible(true);
		f.setSize(1000, 1000);
		
		f.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				super.keyPressed(e);
				if(e.getKeyCode() == KeyEvent.VK_S)
				{
					System.out.println("Se apreto la teclas");
					try {
						   ImageIO.write(imaRead, "jpg", file);
						} catch (IOException ex) {
						   System.out.println("Error de escritura");
						}
				}
			}
		});
	}
}
