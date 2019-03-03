package GeneratorHex;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class PanelSeriazable extends JPanel implements Serializable, MouseListener
{
	/**
	 * 
	 */
	GridLayout gridLy = new GridLayout(10, 10);
	JPanel[][] pls = new JPanel[10][10];
	Border border = BorderFactory.createLineBorder(Color.black);
	public PanelSeriazable()
	{
		for (int i=0; i<pls.length; i++)
		{
			for (int j=0; j<pls[i].length; j++)
			{
				pls[i][j] = new JPanel();
				pls[i][j].addMouseListener(this);
				pls[i][j].setBorder(border);
				add(pls[i][j]);
			}
		}
	}
	
	JPanel pl;
	
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		pl = (JPanel)arg0.getComponent();
		pl.setBackground(Color.RED);
	}
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	
}
