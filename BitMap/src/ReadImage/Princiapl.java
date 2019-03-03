package ReadImage;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Princiapl extends JApplet implements MouseMotionListener
{
	 
	 Robot r;
	 JPanel p;
	 ArrayList<Color> colores;
	 
	 @Override
	 public void init(){
	  colores = new ArrayList<>();
	  
	  try 
	  {
	   r=new Robot();
	  } 
	  catch (AWTException e) 
	  {
	   e.printStackTrace();
	  }
	  
	  imagen=new ImageIcon(this.getClass().getResource("/imagenes/sqi.jpg"));
	  JLabel l=new JLabel(imagen);
	  l.addMouseMotionListener(this);
	  p=new JPanel();
	  add(l,BorderLayout.NORTH);
	  add(p,BorderLayout.CENTER);
	 }
	 ImageIcon imagen;
	 Color col;
	 
	 private void analizateColorsImage(MouseEvent e)
	 {
		 for (int i=0; i<e.getY(); i++)
		 {
			 for (int j=0; j<e.getX(); j+=4)
			 {
				 r.getPixelColor(i, j);
				 addColor();
			 }
		 }
		 
	 }

	 private void addColor()
	 {
		 if(!exists())
		 {
			 colores.add(col);
			 System.out.println(col);
		 }
	 }
	 
	 private boolean exists()
	 {
		 for (int i=0; i<colores.size(); i++)
		 {
			 if(colores.get(i) == col)
				 return true;
		 }
		 
		 return false;
	 }
	 
	 @Override
	 public void mouseDragged(MouseEvent e) {
	  // TODO Auto-generated method stub
	  
	 }


	 @Override
	 public void mouseMoved(MouseEvent e) {
		 analizateColorsImage(e);
	 /* Color c=r.getPixelColor(e.getXOnScreen(), e.getYOnScreen());
	  p.setBackground(c);
	  repaint();*/
	 }
	}


