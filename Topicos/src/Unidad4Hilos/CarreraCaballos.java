package Unidad4Hilos;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CarreraCaballos extends JPanel
{
	Image img;
	int carril[] = {300,400,500};
	Caballo cabs[];
	
	public CarreraCaballos()
	{
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setSize(800, 600);
//		setLocationRelativeTo(null);
		
		img = getImageIcon("Unidad4Hilos/Caballos/", "pista.jpg").getImage();

		cabs = new Caballo[carril.length];
		
		cabs[0] = new Caballo("Negro", carril[0]);
		cabs[1] = new Caballo("Azul", carril[1]);
		cabs[2] = new Caballo("Rojo", carril[2]);
		
	}
	
	public void comenzr()
	{
		for(int i=0; i<cabs.length; i++)
		{
			cabs[i].start();
		}
	}
	
	//JPanel paintComponent-> doble buffer
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		
		for(int i=0; i<cabs.length; i++)
		{
			cabs[i].dibujar(g);
		}
	}
	
	public static ImageIcon getImageIcon(String path,String nombre)
	{
		return new ImageIcon(System.getProperty("user.dir") + "/src/"+path+nombre);
	}
	
	
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(()->
			{
				JFrame jf = new JFrame();
				CarreraCaballos c = new CarreraCaballos();
				JButton arr = new JButton("Arranca");
				jf.setLayout(new BorderLayout());
				arr.addActionListener((a)->{
					c.comenzr();
				});
				jf.add(arr,"North");
				jf.setSize(800, 600);
				jf.setLocationRelativeTo(null);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.add(c);
				jf.setVisible(true);
			}
		);
	}
	
	
	class Caballo extends Thread
	{
		int delay,x,y;
		Image gif;
		
		public Caballo(String name, int carril)
		{
			super(name);
			gif = CarreraCaballos.getImageIcon("Unidad4Hilos/Caballos/", "caballo.gif").getImage();
			y = carril;
			
		}
		
		public void dibujar(Graphics g)
		{
			g.drawImage(gif, x, y, 100,100,CarreraCaballos.this);
		}
		
		@Override
		public void run()
		{
			for(int i=0; i<=CarreraCaballos.this.getWidth(); i+=5)
			{
				x = i;
				CarreraCaballos.this.repaint();
				
				try
				{
					Thread.sleep(50);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("Finalizo: "+getName());
		}
	}
}
