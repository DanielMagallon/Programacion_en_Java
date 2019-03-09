package Simulacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Ejecutable extends JFrame implements ItemListener, ActionListener
{

	MyRaddioButton cuadradosMedios,productosMedios,multipliConst,lineal,congruencialMult;
	JButton ejecutar;
	TablaDatos tabla;
	CuadradosMedios cmedios;
	ProductosMedios pmedios;
	MultiplicadorConstante multCons;
	LinealCongruencial lc;
	JPanel panelTabla;
	AbstractCalculo refer;
	
	public Ejecutable() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		
		init();
		
		panelTabla = new JPanel();
		{
			panelTabla.setLayout(new GridLayout(1,1));
			panelTabla.add(tabla = new TablaDatos());
			
			add(panelTabla,"Center");
		}
		
		JPanel panelBotones = new JPanel();
		
		{
			panelBotones.add(cuadradosMedios);
			panelBotones.add(productosMedios);
			panelBotones.add(multipliConst);
			panelBotones.add(lineal);
			panelBotones.add(congruencialMult);
			
			add(panelBotones,"North");
		}
		
		JPanel panelEje = new JPanel();
		
		{
			panelEje.add(ejecutar);
			
			add(panelEje,"South");
		}
		
		
		tabla.habilitar(cuadradosMedios.buttons);
		tabla.crearColumnas(columnas[0]);
		refer = cmedios;
	}
	

	private void init()
	{
		cmedios = new CuadradosMedios();
		pmedios = new ProductosMedios();
		multCons = new MultiplicadorConstante();
		lc =  new LinealCongruencial();		
		
		cuadradosMedios = new MyRaddioButton("Cuadrados medios",0,cmedios,"Semilla","Nro. semillas");
		cuadradosMedios.setSelected(true);
		cuadradosMedios.addItemListener(this);
		
		productosMedios = new MyRaddioButton("Productos Medios",1,pmedios,"Semilla","Semilla2",
				"Nro. semillas");
		productosMedios.addItemListener(this);
		
		multipliConst = new MyRaddioButton("Multiplicador constante",2,multCons,"Constante","Semilla"
				,"Nro. semillas");
		multipliConst.addItemListener(this);
		
		
		lineal = new MyRaddioButton("Lineal",3,lc,"a","Semilla","c","Modulo","Nro. semillas");
		lineal.addItemListener(this);
		
		congruencialMult = new MyRaddioButton("Congruencial multiplicativo",4,lc,
							"a","Semilla","Modulo","Nro. semillas");
		congruencialMult.addItemListener(this);
		
		
		ejecutar = new JButton("Ejecutar");
		ejecutar.addActionListener(this);

		ButtonGroup bg = new ButtonGroup();
		
		bg.add(cuadradosMedios);
		bg.add(multipliConst);
		bg.add(productosMedios);
		bg.add(lineal);
		bg.add(congruencialMult);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(ejecutar == arg0.getSource())
		{
			refer.calcular(tabla.getDatos());
			tabla.agregaReng(refer.resultado);
		}
	}
	
	public String columnas[][] =
			{
				{"i","Semilla","Semilla²","Digitos Centro","Valor semilla ri"},
				{"i","Semilla","Semilla2","Semilla*Semilla2","Digitos Centro","Valor semilla ri"},
				{"i","Constante","Semilla","Constante*Semilla","Digitos Centro","Valor semilla ri"},
				{"i","Semilla","(a*semilla) + c","Modulo","xi","ri"},
				{"i","Semilla","(a*semilla)","Modulo","xi","ri"}
			};
	
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		MyRaddioButton m = (MyRaddioButton) e.getSource();
		
		refer = m.calc;
		tabla.habilitar(m.buttons);
		tabla.crearColumnas(columnas[m.getID()]);
		tabla.validate();
	}
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(
				
					()-> new Ejecutable().setVisible(true)
					
				
				);
	}
}
