package Unidad1P2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class AdivinaP3 extends JFrame implements ActionListener
{
	JButton btns[] = new JButton[7];
	String textos[] = {"Chicken","Carro","Perro","Lapiz","Mesa","Manzana"};
	Random lb = new Random();
	String txt;
	
	public AdivinaP3() 
	{
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		
		JPanel cen = new JPanel();

		
		{
			cen.setLayout(new GridLayout(3,3,5,5));
			
			ImageIcon img[] = 
				{
						new ImageIcon(getClass().getResource("/inglesw/gallina.jpg")),
						new ImageIcon(getClass().getResource("/inglesw/carro.jpg")),
						new ImageIcon(getClass().getResource("/inglesw/perro.jpg")),
						new ImageIcon(getClass().getResource("/inglesw/lapiz.jpg")),
						new ImageIcon(getClass().getResource("/inglesw/mesa.jpg")),
						new ImageIcon(getClass().getResource("/inglesw/manzana.jpg"))
				};
			
			for(int i=0; i<btns.length-1; i++)
			{
				btns[i] = new JButton();
				btns[i].setBackground(Color.white);
				btns[i].setName(textos[i]);
				btns[i].setIcon(img[i]);
				btns[i].setActionCommand(textos[i]);
				btns[i].addActionListener(this);
				cen.add(btns[i]);
			}
			
			
			txt = textos[lb.nextInt(6)];
			btns[6] = new JButton(txt);
			
			add(cen,"Center");
		}
		
		{
			JToolBar tool = new JToolBar(JToolBar.HORIZONTAL);
			tool.add(btns[6]);
			add(tool,"North");
		}
		
	}
	
	String txtant;
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(txt))
		{
			JOptionPane.showMessageDialog(this, "Es un "+txt,"Correcto",
					JOptionPane.INFORMATION_MESSAGE);
		}
		else JOptionPane.showMessageDialog(this, "No es un "+txt,"Incorrecto",
				JOptionPane.ERROR_MESSAGE);
		
		txtant = txt;
		
		do
		{
			txt = textos[lb.nextInt(6)];
		}while(txtant.equals(txt));
		
		btns[6].setText(txt);
	}
	
	public static void main(String[] args) 
	{
		new AdivinaP3().setVisible(true);
	}
}
