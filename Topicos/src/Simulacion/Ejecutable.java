package Simulacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ejecutable extends JFrame implements ItemListener, ActionListener
{

	JRadioButton cuadradosMedios,productosMedios,multipliConst;
	JButton ejecutar;
	TablaDatos tabla;
	CuadradosMedios cmedios;
	ProductosMedios pmedios;
	MultiplicadorConstante multCons;
	
	public Ejecutable() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		init();
		
		JPanel panelTabla = new JPanel();
		JScrollPane sc = new JScrollPane
				(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		{
			sc.setViewportView(tabla = new TablaDatos());
			panelTabla.setLayout(new GridLayout(1,1));
			panelTabla.add(sc);
			
			add(panelTabla,"Center");
		}
		
		JPanel panelBotones = new JPanel();
		
		{
			panelBotones.add(cuadradosMedios);
			panelBotones.add(productosMedios);
			panelBotones.add(multipliConst);
			
			add(panelBotones,"North");
		}
		
		JPanel panelEje = new JPanel();
		
		{
			panelEje.add(ejecutar);
			
			add(panelEje,"South");
		}
	}
	

	private void init()
	{
		cuadradosMedios = new JRadioButton("Cuadrados medios");
		cuadradosMedios.addItemListener(this);
		
		productosMedios = new JRadioButton("Productos Medios");
		productosMedios.addItemListener(this);
		
		multipliConst = new JRadioButton("Multiplicador constante");
		multipliConst.addItemListener(this);
		
		ejecutar = new JButton("Ejecutar");
		ejecutar.addActionListener(this);

		cmedios = new CuadradosMedios();
		pmedios = new ProductosMedios();
		multCons = new MultiplicadorConstante();
				
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(cuadradosMedios);
		bg.add(multipliConst);
		bg.add(productosMedios);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(ejecutar == arg0.getSource())
		{
			int x = 
			Integer.parseInt
					(JOptionPane.showInputDialog("Cuantos numeros quieres generar"));
			
			String  c = (JOptionPane.showInputDialog("Introduce la semilla: "));
			String  c2 = (JOptionPane.showInputDialog("Introduce la semilla 2: "));
			
//			cmedios.calcularCM(semilla, x);
			
//			pmedios.calcularCM(semilla, semilla2, x);
			multCons.calcularCM(c, c2, x);
			tabla.agregaReng(multCons.resultado);
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		if(cuadradosMedios.isSelected())
		{
			tabla.crearColumnas("i","Semilla","Semilla²","Digitos Centro","Valor semilla ri");
			tabla.validate();
		}
		else if(productosMedios.isSelected())
		{
			tabla.crearColumnas("i","Semilla","Semilla2","Semilla*Semilla2","Digitos Centro","Valor semilla ri");
			tabla.validate();
		}
	
		else if(multipliConst.isSelected())
		{
			tabla.crearColumnas("i","Constante","Semilla","Constante*Semilla","Digitos Centro","Valor semilla ri");
			tabla.validate();
		}
	}
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(
				
					()-> new Ejecutable().setVisible(true)
					
				
				);
	}
}
