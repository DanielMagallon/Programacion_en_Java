package Unidad1P2;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class Prcactica2 extends JFrame implements ActionListener, ItemListener
{
	
	JToggleButton tog1,tog2,tog3;
	Image img1,img2,img3,aux;
	JRadioButton rd1,rd2,rd3;
	
	public Prcactica2() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		JPanel up = new JPanel();
		
		{
			img1 = new ImageIcon(getClass().getResource("/Unidad1P2/gato.jpg")).getImage();
			img2 = new ImageIcon(getClass().getResource("/Unidad1P2/pajaro.jpg")).getImage();
			img3 = new ImageIcon(getClass().getResource("/Unidad1P2/perro1.jpg")).getImage();
			
			aux = img1;
			
			
			tog1 = new JToggleButton(new ImageIcon(img1),true);
			tog2 = new JToggleButton(new ImageIcon(getClass().getResource("/Unidad1P2/pajaro.jpg")));
			tog3 = new JToggleButton(new ImageIcon(img3));
			
			up.add(tog1);
			up.add(tog2);
			up.add(tog3);
			
			add(up,"North");
			
			tog1.addActionListener(this);
			tog2.addActionListener(this);
			tog3.addActionListener(this);
		}
		
		ButtonGroup g = new ButtonGroup();
		
		g.add(rd1 = new JRadioButton("Chica",true));
		g.add(rd2 = new JRadioButton("Mediana"));
		g.add(rd3 = new JRadioButton("Grande"));
		
		ButtonGroup g2 = new ButtonGroup();
		g2.add(tog1);
		g2.add(tog2);
		g2.add(tog3);
		
		JPanel ab = new JPanel();
		
		ab.add(rd1);
		ab.add(rd2);
		ab.add(rd3);
		add(ab,"South");
		
		rd1.addItemListener(this);
		rd2.addItemListener(this);
		rd3.addItemListener(this);
		medida = 150;
		repaint();
	}
	
	int medida;
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(
				
					()-> new Prcactica2().setVisible(true)
				
				);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0)
	{
		if(rd1.isSelected())
		{
			medida = 150;
		}
		
		else if(rd2.isSelected())
		{
			medida=250;
		}
		
		else
		{
			medida=450;
		}
			
		repaint();
	}
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		
		g.drawImage(aux, 200, 100, medida, medida==450 ? 350 : medida, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(tog1.isSelected())
		{
			aux = img1;
		}
		
		else if(tog2.isSelected())
		{
			aux = img2;
		}
		
		else
		{
			aux = img3;
		}
		
		repaint();
	}
}
