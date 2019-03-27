package Simulacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;

public class TablaAnimada extends JFrame implements ActionListener
{
	int x = 500;
	int y = 200;
	int Xred = 1000;
	JScrollPane s1,s2,s3;
	
	Timer timer = new Timer(50, (a)->
		{
			x-=100;
			Xred-=100;
			
			s1.setBounds(x, y, 300, 300);
			s2.setBounds(Xred, y, 300, 300);
			
			if(Xred<=500)
				det();
		}
	); 
		
	private void det()
	{
		timer.stop();
	}
	
	JPanel panelTablas,panelD;
	
	
	Object[] columnas1 = {"Tabla","Animada"};
	Object[] columnas2 = {"Tabla2","Animada"};
	Object[] columnas3 = {"Tabla3","Animada"};
	
	Object[][] row = {
			{"Hola","Mundo"},
			{"Hello","Wolrd"}
	};
	
	
	Object[][] row2 = {
			{"1","2"},
	};
	
	Object[][] row3 = {
			{"ff","c"},
			{"ff","c"},
			{"ff","c"},
			{"ff","c"}
	};
	
	public TablaAnimada()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		
		panelTablas = new JPanel();
		{
			add(panelTablas,"Center");
			panelTablas.setLayout(null);
			
			JTable t1,t2,t3;
			
			t1 = new JTable(row,columnas1);
			t2 = new JTable(row2,columnas2);
			t3 = new JTable(row3,columnas3);
			
			s1 = new JScrollPane(t1);
			s2 = new JScrollPane(t2);
			s3 = new JScrollPane(t3);
			
			s1.setBounds(x, y, 300, 300);
			s2.setBounds(Xred, y, 300, 300);
			
			panelTablas.add(s1);
			panelTablas.add(s2);
			
		}
		
		panelD = new JPanel();
		
		{
			JButton b = new JButton(">");
			
			b.addActionListener(this);
			
			add(panelD,"South");
			panelD.add(b);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		timer.start();
	}

	
	public static void main(String[] args)
	{
		new TablaAnimada().setVisible(true);
	}
}
