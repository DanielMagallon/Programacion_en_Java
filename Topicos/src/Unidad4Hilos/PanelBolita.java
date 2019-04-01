package Unidad4Hilos;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelBolita extends JPanel
{
	JFrame jframe;
	BolitaSwing bolitas[];
	
	public PanelBolita(int cant)
	{
		jframe = new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jframe.setVisible(true);
		jframe.add(this,"Center");
		jframe.setSize(800,600);
		setSize(800,600);
		
//		bolitas = new Bolita[cant];
//		
//		for(int i=0; i<cant; i++)
//		{
//			bolitas[i] = new Bolita(this);
//		}
		bolitas = new BolitaSwing[cant];
		for(int i=0; i<cant; i++)
		{
			bolitas[i] = new BolitaSwing(this);
			bolitas[i].execute();
		}
		
	}
	
	@Override
	protected  void paintComponent(Graphics arg0)
	{
		super.paintComponent(arg0);
		for(int i=0; i<bolitas.length; i++)
			bolitas[i].dibujar(arg0);
		
	}
	
	public static void main(String[] args)
	{
		new PanelBolita(30);
	}
}
