package Painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PaintVector extends JFrame implements MouseListener
{
	Graphics graph;
	JPanel[][] paneles;
	int FC = 8;
	Border bordo;
	
	PaintVector()
	{
		setLayout(new GridLayout(FC,FC));
		paneles = new JPanel[FC][FC];
		bordo = BorderFactory.createLineBorder(Color.black);
		createPanel();
		setSize(500, 500);
		setDefaultCloseOperation(2);
		setVisible(true);
	}

	public void createPanel()
	{
		for (int i=0; i<FC; i++)
		{
			for (int j=0; j<FC; j++)
			{
				paneles[i][j] = new JPanel();
				paneles[i][j].setBorder(bordo);
				paneles[i][j].addMouseListener(this);
				add(paneles[i][j]);
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		graph = e.getComponent().getGraphics();
		
		graph.setColor(Color.red);
		graph.drawLine(3, 3, 4, 6);
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)
	{
		new PaintVector();
	}
}
