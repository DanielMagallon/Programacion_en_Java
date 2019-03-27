package Simulacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class App extends JFrame implements ItemListener, ActionListener
{

	private static final long serialVersionUID = 6340630260887584674L;
	
	MyRaddioButton cuadradosMedios,productosMedios,multipliConst,lineal,congruencialMult,m;
	
	TablaDatos tabla;
	
	CuadradosMedios cmedios;
	ProductosMedios pmedios;
	MultiplicadorConstante multCons;
	LinealCongruencial lc;
	AbstractCalculo refer;
	
	JPanel panelTabla;
	
	TablasEstadisticas tablaEst;
	PruebaChi2 pruebaChi2;
	PruebaKol_Smirov pruebaKSov;
	PruebaHuecos pruebaHuecos;
	CorridaUp_Down pruebaArrAb;
	UpDownMedia pruebaUpMedia;
	WindPSeries windowPSeries;
	
	MenuActionsItem btnValCrit,btnAreaCurva,btnChi2,btnExe,btnWriteNum;
	MenuActionsItem btbPruebaChi2,btnPruebaKS,btnPruPoker,btnPruebaHuecos,btnPruebaUp,btnPruebaUpM,
						btnPruebaSeries;
	WindowAnimated ventana1,ventana2,ventana3,venataPC2,ventanaPKS,ventanaHuecos,
					venetanaUp,ventanaUpM;
	
	static DialogWriter writer;
	
	Poker poker;
	
	public App() 
	{
		super("Simulacion");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout(10,10));
		
		init();
		
		panelTabla = new JPanel();
		{
			panelTabla.setLayout(new GridLayout(1,1));
			panelTabla.add(tabla);
			
			add(panelTabla,"Center");
		}
		
		
		tabla.habilitar(cuadradosMedios.vals,cuadradosMedios.buttons);
		tabla.crearColumnas(columnas[0]);
		refer = cmedios;
		m = cuadradosMedios;
		
		menuBar();
	}

	
	
	private void menuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		
		setJMenuBar(menuBar);

		JMenu programa = new JMenu("Programa");
		{
			menuBar.add(programa);
			programa.add(btnExe);
			
			btnWriteNum = new MenuActionsItem("Escribir numeros aleatorios", 
					()->{writer.setVisible(true);}, KeyEvent.VK_R, ActionEvent.CTRL_MASK);
			btnWriteNum.addActionListener(this);
			
			programa.add(btnWriteNum);
		}
		
		
		
		JMenu generar = new JMenu("Generador Aleatorios");
		{
			generar.add(cuadradosMedios);
			generar.add(productosMedios);
			generar.add(multipliConst);
			generar.add(lineal);
			generar.add(congruencialMult);
		}
		
		JMenu pruebasEst = new JMenu("Pruebas estadisticas");
		pruebasEst.add(btbPruebaChi2);
		pruebasEst.add(btnPruebaKS);
		pruebasEst.add(btnPruPoker);
		pruebasEst.add(btnPruebaHuecos);
		pruebasEst.add(btnPruebaUpM);
		pruebasEst.add(btnPruebaUp);
		pruebasEst.add(btnPruebaSeries);
		
		JMenu tablasEst = new JMenu("Tablas de Estadisticas");
		tablasEst.add(btnAreaCurva);
		tablasEst.add(btnChi2);
		tablasEst.add(btnValCrit);
		
		menuBar.add(generar);
		menuBar.add(pruebasEst);
		menuBar.add(tablasEst);
		
	}
	
	private void init()
	{

		
		cmedios = new CuadradosMedios();
		pmedios = new ProductosMedios();
		multCons = new MultiplicadorConstante();
		lc =  new LinealCongruencial();		
		
		cuadradosMedios = new MyRaddioButton("Cuadrados medios",0,0,cmedios,
				new boolean[] {true,false},
				"Semilla","Nro. semillas");
		cuadradosMedios.atajo(KeyEvent.VK_J, ActionEvent.CTRL_MASK);
		
		cuadradosMedios.setSelected(true);
		cuadradosMedios.addItemListener(this);
		
		productosMedios = new MyRaddioButton("Productos Medios",1,1,pmedios,
				new boolean[] {true,true,false},
				"Semilla","Semilla2","Nro. semillas");
		productosMedios.atajo(KeyEvent.VK_K, ActionEvent.CTRL_MASK);
		
		productosMedios.addItemListener(this);
		
		multipliConst = new MyRaddioButton("Multiplicador constante",2,1,multCons,
				new boolean[] {true,true,false},
				"Constante","Semilla","Nro. semillas");
		multipliConst.atajo(KeyEvent.VK_L, ActionEvent.CTRL_MASK);
		
		multipliConst.addItemListener(this);
		
		
		lineal = new MyRaddioButton("Lineal",3,2,lc,
				new boolean[] {false,false,false,false,false},
				"a","Semilla","c","Modulo","Nro. semillas");
		lineal.atajo(KeyEvent.VK_M, ActionEvent.CTRL_MASK);
		
		lineal.addItemListener(this);
		
		congruencialMult = new MyRaddioButton("Congruencial multiplicativo",4,2,lc,
				new boolean[] {false,false,false,false},
				"a","Semilla","Modulo","Nro. semillas");
		congruencialMult.addItemListener(this);
		congruencialMult.atajo(KeyEvent.VK_N, ActionEvent.CTRL_MASK);
		
		poker = new Poker();
				
		
		btnExe = new  MenuActionsItem("Ejecutar",()->execute(), KeyEvent.VK_E,
										ActionEvent.CTRL_MASK);
		btnExe.addActionListener(this);
		
		crearTablasEst();
		
		tabla = new TablaDatos();
		
		ventana1 = new WindowAnimated("Tabla valores area bajo la curva",tablaEst.scABC,1100,650,true,null);
		ventana2 = new WindowAnimated("Tabla de Chi cuadrada",tablaEst.scChi2,1100,650,true,null);
		ventana3 = new WindowAnimated("Tabla de valores criticos",tablaEst.scVC,800,550,true,null);
		

		
		btnAreaCurva = new MenuActionsItem("Tabla Area Bajo Curva",()->ventana1.setVisible(true),
				KeyEvent.VK_F,
				ActionEvent.ALT_MASK);
		btnAreaCurva.addActionListener(this);
		
		btnChi2 = new MenuActionsItem("Tabla de Chi2", ()->ventana2.setVisible(true),
				KeyEvent.VK_G,
				ActionEvent.ALT_MASK);
		
		btnChi2.addActionListener(this);
		
		btnValCrit = new MenuActionsItem("Tabla de valores criticos",()->ventana3.setVisible(true),
				KeyEvent.VK_H,
				ActionEvent.ALT_MASK);
		
		btnValCrit.addActionListener(this);
		
		
		btbPruebaChi2 = new MenuActionsItem("Pruebba de Chi2",()->venataPC2.setVisible(true),
				KeyEvent.VK_C,
				ActionEvent.ALT_MASK);
		
		btbPruebaChi2.addActionListener(this);
		
		btnPruebaKS = new MenuActionsItem("Prueba de  kolmogorov-smirnov",()->ventanaPKS.setVisible(true),
				KeyEvent.VK_K,
				ActionEvent.ALT_MASK);
		
		btnPruebaKS.addActionListener(this);
		
		btnPruPoker = new MenuActionsItem("Prueba Poker",()->poker.setVisible(true),
				KeyEvent.VK_P,
				ActionEvent.ALT_MASK);
		
		btnPruPoker.addActionListener(this);
		

		pruebaHuecos = new PruebaHuecos();
		ventanaHuecos = new WindowAnimated("Prueba de Huecos", new JScrollPane(pruebaHuecos), 
				800, 300,false,pruebaHuecos);
		buildHuecos();
		btnPruebaHuecos = new MenuActionsItem("Prueba de Huecos", ()-> ventanaHuecos.setVisible(true),
				KeyEvent.VK_H,
				ActionEvent.ALT_MASK);
		btnPruebaHuecos.addActionListener(this);
		
		pruebaChi2 = new  PruebaChi2();
		venataPC2 = new WindowAnimated("Prueba de Chi cuadrada",new JScrollPane(pruebaChi2), 800, 660,
				false,pruebaChi2);
		
		pruebaKSov = new PruebaKol_Smirov();
		ventanaPKS = new WindowAnimated("Prueba de Kolmogorov-Smirnov",new JScrollPane(pruebaKSov), 800, 660,
				false,pruebaKSov);
		
		
		pruebaUpMedia = new UpDownMedia();
		ventanaUpM = new WindowAnimated("Prueba arriba y abajo de la media", 
				new JScrollPane(pruebaUpMedia), 500, 300, false, pruebaUpMedia);
		btnPruebaUpM = new MenuActionsItem("Prueba arriba/abajo media", 
				()->ventanaUpM.setVisible(true), 
				KeyEvent.VK_I,
				ActionEvent.ALT_MASK);
		btnPruebaUpM.addActionListener(this);
		
		pruebaArrAb = new CorridaUp_Down();
		venetanaUp = new WindowAnimated("Prueba arriba y abajo", 
				new JScrollPane(pruebaArrAb), 500, 300, false, pruebaArrAb);
		btnPruebaUp = new MenuActionsItem("Prueba arriba/abajo", 
				()->venetanaUp.setVisible(true), 
				KeyEvent.VK_J,
				ActionEvent.ALT_MASK);
		btnPruebaUp.addActionListener(this);
		
		windowPSeries = new WindPSeries();
		btnPruebaSeries = new MenuActionsItem("Prueba de series", 
				()->windowPSeries.setVisible(true),
				KeyEvent.VK_K,
				ActionEvent.ALT_MASK);
		btnPruebaSeries.addActionListener(this);
		
		writer = new DialogWriter();
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(cuadradosMedios);
		bg.add(multipliConst);
		bg.add(productosMedios);
		bg.add(lineal);
		bg.add(congruencialMult);
		
		
	}
	
	private void buildHuecos()
	{
		JPanel sur = new JPanel();
		
		ventanaHuecos.add(sur,"South");
		
		JTextField txtAlfa = new JTextField(10);
		JTextField txtBeta = new JTextField(10);
		
		sur.add(new JLabel("Alfa: "));
		sur.add(txtAlfa);
		sur.add(new JLabel("Beta: "));
		sur.add(txtBeta);
		
		JButton est = new JButton("Establecer parametros");
		pruebaHuecos.modelo.setValueAt("α:null", 6, 0);
		pruebaHuecos.modelo.setValueAt("β:null", 6, 1);
		
		est.addActionListener((a)->{
			
			String text = txtAlfa.getText();
			String text2 = txtBeta.getText();
			
			try
			{
				Double v = Double.parseDouble(text);
				Double v2 = Double.parseDouble(text2);
				
				if(v.compareTo(v2)>0)
				{
					JOptionPane.showMessageDialog(ventanaHuecos, "Beta debe ser mayor igual "
							+ "que alfa","Error Alfa-Beta",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(v.doubleValue()<0 || v.doubleValue()>1 || v2.doubleValue()<0 || v2.doubleValue()>1)
				{
					JOptionPane.showMessageDialog(ventanaHuecos, "Alfa y beta deben estar en el intervalo"
							+ "(0-1)","Error Alfa-Beta",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				pruebaHuecos.modelo.setValueAt("α: "+v, 6, 0);
				pruebaHuecos.modelo.setValueAt("β: "+v2, 6, 1);
				pruebaHuecos.establecerParametros(text, text2);
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(ventanaHuecos, "Solo valores numericos",
						"Error Alfa-Beta",JOptionPane.ERROR_MESSAGE);
			}
			
		});
		
		sur.add(est);
	}
	
	private void crearTablasEst()
	{
		tablaEst = new TablasEstadisticas();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		MenuActionsItem e = (MenuActionsItem) arg0.getSource();
		
		e.action();
	}
	
	private void execute()
	{
		try
		{
			refer.calcular(tabla.getDatos());
			tabla.agregaReng(refer.resultados);
			
		}
		catch (NumberFormatException e) 
		{
			tabla.selecError();
			JOptionPane.showMessageDialog(this, "Debe ingresar valores enteros", 
					"Advertencia", JOptionPane.WARNING_MESSAGE);
			tabla.backSelection();
		}
		catch(MiExcepcion e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), 
					"Error", JOptionPane.ERROR_MESSAGE);
			tabla.backSelection();
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
		
		m = (MyRaddioButton) e.getSource();
		
		refer = m.calc;
		tabla.habilitar(m.vals,m.buttons);
		tabla.crearColumnas(columnas[m.getID()]);
		tabla.validate();
		
	}
}
