package Unidad4Hilos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class InterfazCuadros extends JPanel
{
	JTextArea area;
	HiloCoordenadas h;
	JFrame v;
	Vector<int[]> cuadros;
	
	public InterfazCuadros()
	{
		v = new JFrame();
		setSize(800,600);
		v.setSize(800, 600);
		v.setVisible(true);
		v.setLayout(new BorderLayout());
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.add(this,"Center");
		h = new HiloCoordenadas(this);
		
		JScrollPane sc = new JScrollPane(area = new JTextArea(10,10));
		v.add(sc,"West");
		cuadros = new Vector<int[]>();
		
		h.execute();
	}
	
	@Override
	protected void paintComponent(Graphics e)
	{
		super.paintComponent(e);
		Random r = new Random();
		
		for(int i=0; i<cuadros.size(); i++)
		{
			e.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256)));
//			e.setXORMode(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256)));
			int v[] = cuadros.get(i);
			
			e.fillRect(v[0], v[1], v[2], v[2]);
		}
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(()->new InterfazCuadros().v.setVisible(true));
	}
}
