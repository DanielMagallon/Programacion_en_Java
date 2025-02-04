package C12GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseTrackeFrame extends JFrame
{
	private JPanel mousePanel;
	private JLabel statusBar;
	
	public MouseTrackeFrame()
	{
		super("Demostrating Mouse Events");
		
		mousePanel =  new JPanel();
		mousePanel.setBackground(Color.WHITE);
		add(mousePanel,BorderLayout.CENTER);
		
		statusBar = new JLabel("Mouse Outside JPanel");
		add(statusBar,BorderLayout.SOUTH);
		
		MouseHandler handler = new MouseHandler();
		mousePanel.addMouseListener(handler);
		mousePanel.addMouseMotionListener(handler);
		
	}
	
	private class MouseHandler implements MouseListener,
					MouseMotionListener
	{

		@Override
		public void mouseDragged(MouseEvent e)
		{
			statusBar.setText(String.format("Draged at [%d, %d]", 
					e.getX(),e.getY()));
		}

		@Override
		public void mouseMoved(MouseEvent e)
		{
			statusBar.setText(String.format("Moved at [%d, %d]", 
					e.getX(),e.getY()));
		}

		@Override
		public void mouseClicked(MouseEvent e)
		{
			statusBar.setText(String.format("Clicked at [%d, %d]", 
					e.getX(),e.getY()));
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{
			statusBar.setText(String.format("Mouse Entered at [%d, %d]", 
					e.getX(),e.getY()));
			mousePanel.setBackground(Color.green);
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
			statusBar.setText( "Mouse outside JPanel" );
			mousePanel.setBackground(Color.white);
		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			statusBar.setText(String.format("Pressed at [%d, %d]", 
					e.getX(),e.getY()));
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			statusBar.setText(String.format("Released at [%d, %d]", 
					e.getX(),e.getY()));
			
		}
		
	}
}
