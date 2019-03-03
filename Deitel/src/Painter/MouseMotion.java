package Painter;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseMotion extends JFrame implements MouseMotionListener
{
	JButton btn;
	
	public MouseMotion()
	{
		setLayout(new FlowLayout());
		btn = new JButton("Arratrame");
		btn.addMouseMotionListener(this);
		add(btn);
		setDefaultCloseOperation(2);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new MouseMotion();
	}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub
		btn.setLocation(e.getXOnScreen()-10, e.getYOnScreen()-55);
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		
	}
}	
