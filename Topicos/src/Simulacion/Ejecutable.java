package Simulacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Ejecutable extends JFrame implements ItemListener, ActionListener
{

	private static final long serialVersionUID = 6340630260887584674L;
	
	MyRaddioButton cuadradosMedios,productosMedios,multipliConst,lineal,congruencialMult;
	JButton ejecutar;
	TablaDatos tabla;
	CuadradosMedios cmedios;
	ProductosMedios pmedios;
	MultiplicadorConstante multCons;
	LinealCongruencial lc;
	JPanel panelTabla;
	AbstractCalculo refer;
	TablasEstadisticas tablaEst;
	PruebaChi2 pruebaChi2;

	JToolBar barraTablas;
	JButton btnValCrit,btnAreaCurva,btnChi2;
	VentanaTablas ventana1,ventana2,ventana3;
	
	public Ejecutable() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		
		init();
		
		panelTabla = new JPanel();
		{
			panelTabla.setLayout(new GridLayout(1,1));
			panelTabla.add(tabla);
			
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
		
		
		{
			barraTablas.add(btnAreaCurva);
			barraTablas.add(btnValCrit);
			barraTablas.add(btnChi2);
			add(barraTablas,"West");
		}
		
		
		tabla.habilitar(cuadradosMedios.buttons);
		tabla.crearColumnas(columnas[0]);
		refer = cmedios;
		m = cuadradosMedios;
		tabla.setRestrictions(restricciones[0]);
	}
	

	private void init()
	{

		
		cmedios = new CuadradosMedios();
		pmedios = new ProductosMedios();
		multCons = new MultiplicadorConstante();
		lc =  new LinealCongruencial();		
		
		cuadradosMedios = new MyRaddioButton("Cuadrados medios",0,0,cmedios,"Semilla","Nro. semillas");
		//Que la semilla sea mayor a 3 digitos, numero de semillas > 0
		
		cuadradosMedios.setSelected(true);
		cuadradosMedios.addItemListener(this);
		
		productosMedios = new MyRaddioButton("Productos Medios",1,1,pmedios,"Semilla","Semilla2",
				"Nro. semillas");
		//Que ambas semillas sean del mismo tamaño, y mayores a 3 digito,numerode semillas>0
		
		productosMedios.addItemListener(this);
		
		multipliConst = new MyRaddioButton("Multiplicador constante",2,1,multCons,"Constante","Semilla"
				,"Nro. semillas");

		multipliConst.addItemListener(this);
		
		
		lineal = new MyRaddioButton("Lineal",3,2,lc,"a","Semilla","c","Modulo","Nro. semillas");
		//todo > 0
		lineal.addItemListener(this);
		
		congruencialMult = new MyRaddioButton("Congruencial multiplicativo",4,2,lc,
							"a","Semilla","Modulo","Nro. semillas");
		congruencialMult.addItemListener(this);
		
		
		ejecutar = new JButton("Ejecutar");
		ejecutar.addActionListener(this);

		tablaEst = (TablasEstadisticas) Serializa.writeObject
				(new File(System.getProperty("user.dir")+"/src/Simulacion/Files/tabla.est"));
		
		
	/*	tablaEst = new TablasEstadisticas();
		Serializa.saveObject(tablaEst, new File(System.getProperty
				("user.dir")+"/src/Simulacion/Files/tabla.est"));*/
		
		tabla = new TablaDatos();
		
		ventana1 = new VentanaTablas(tablaEst.scABC,1100,650);
		ventana2 = new VentanaTablas(tablaEst.scChi2,1100,650);
		ventana3 = new VentanaTablas(tablaEst.scVC,800,550);
		
		barraTablas = new JToolBar(JToolBar.VERTICAL);

		btnAreaCurva = new JButton();
		btnAreaCurva.setToolTipText("Area bajo la curva");
		btnAreaCurva.addActionListener(this);
		
		btnChi2 = new JButton();
		btnChi2.setToolTipText("Tabla de Chi2");
		btnChi2.addActionListener(this);
		
		btnValCrit = new JButton();
		btnValCrit.setToolTipText("Tabla de valores criticos");
		btnValCrit.addActionListener(this);
		
		pruebaChi2 = new  PruebaChi2();
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(cuadradosMedios);
		bg.add(multipliConst);
		bg.add(productosMedios);
		bg.add(lineal);
		bg.add(congruencialMult);
		
	}
	
	public Validar restricciones[] =
		{
			(a)->
			{
				
				if(a[0]>3)
				{
					if(a[1]>0)
						return true;
					
					throw new MiExcepcion("Debe generar al menos una iteracion");
				}
			
				throw new MiExcepcion("Debe ingresar una semilla de 4 digitos o mas");
			},	
			
			(a)->
			{
				if(a[0]>3)
				{
					if(a[1]==a[0])
					{
						if(a[2]>0)
							return true;
						
						throw new MiExcepcion("Debe generar al menos una iteracion");
					}
					else throw new MiExcepcion("Ambas semillas deben tener el mismo tamaño");
				}
				else throw new MiExcepcion("Debe ingresar una semilla de 4 digitos o mas");
			},
			
			(a)->
			{
				for(int x : a)
				{
					if(x==0)
						throw new MiExcepcion("Los valores deben ser mayores a 0");
				}
				
				return true;
			}
			
		};
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(ejecutar == arg0.getSource())
		{
			try
			{
				refer.calcular(tabla.getDatos(m.getIDRestriction()<=1));
				tabla.agregaReng(refer.resultado);
				pruebaChi2.generar();
				
			}
			catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(this, "Debe ingresar valores enteros", 
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			}
			catch(MiExcepcion e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if(arg0.getSource() == btnChi2)
		{
			ventana2.setVisible(true);
		}
		
		else if(arg0.getSource() == btnValCrit)
		{
			ventana3.setVisible(true);
			
		}
		
		else if(arg0.getSource() == btnAreaCurva)
		{
			ventana1.setVisible(true);
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
	
	
	MyRaddioButton m;
	
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		
		m = (MyRaddioButton) e.getSource();
		
		refer = m.calc;
		tabla.setRestrictions(restricciones[m.getIDRestriction()]);
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
	
	class VentanaTablas extends JDialog
	{
		JButton btnOk,btnCanc,btnConf;
		
		public VentanaTablas(JScrollPane sc,int width,int height) 
		{
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setSize(width, height);
			setLocationRelativeTo(null);
			setLayout(new BorderLayout());
			add(sc,"Center");

			
			JPanel panelBtn = new JPanel();
			
			{
				btnOk = new JButton("Guardar cambios");
				btnCanc = new JButton("Cancelar");
				
				panelBtn.add(btnOk);
				panelBtn.add(btnCanc);
			}
			
			add(panelBtn,"South");
			
			JPanel panelCon = new JPanel();
			
			{
				panelCon.add(btnConf = new JButton("Configurar"));
				
				add(panelCon,"North");
			}
			
		}
		
	}
}
