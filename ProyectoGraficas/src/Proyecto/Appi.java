package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

import Libreria.Grafica;

public class Appi extends JFrame
{
	private static final long serialVersionUID = -6345646015769705197L;

	private Pestanas pestanas;
	private JPanel panelFunciones;
	private JMenuBar menuBar;
	private ActionListener[] actionesSecun;
	private Categorias tablaCategorias;
	public PanelFondos fondos;
	public JToggleButton togglePastel, toggleBarras,togglePorce;
	private JRadioButton rdNorte, rdSur;
	private JButton btnAumentar, btnDecre, btnTablaCategrias, btnNuevaG, btnRefres, 
		btnCerrar, btnRotarD, btnRotarIz;

	public static Cursor cursorCruz,cursorSeleccion;

	private AboutWindow aboutW;
	
	public JCheckBoxMenuItem mtcVisible;	
	private int opc;

	public static JComboBox<Integer> comboEspacios;

	private JTextField txtTitulo;

	private Clipboard portapapeles;
	public Transferable datos;
	
	private ClosingListener closList;
	
	private Timer timer;
	
	public Appi(String path, boolean showHelp)
	{
		super("Integrantes: Edgar Daniel Magallon V., Bryant Lopez, Brandon Said Onofre Segura");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setLayout(new BorderLayout(10, 10));
		
		closList = new ClosingListener();
		aboutW = new AboutWindow(this);
		
		
		cursorCruz = new Cursor(Cursor.MOVE_CURSOR);
		cursorSeleccion = new Cursor(Cursor.HAND_CURSOR);
		
		addWindowListener(closList);
		
		opc = Grafica.BARRAS;
		panelFunciones = new JPanel();

		tablaCategorias = new Categorias(path);

		pestanas = new Pestanas(tablaCategorias,this);
		pestanas.setBackground(Color.white);
		
		tablaCategorias.setTabbed(pestanas);

		fondos = new PanelFondos(pestanas);

		add(pestanas, "Center");
		add(fondos,"South");
		fondos.setVisible(false);

		accionesSecundarias();
		funciones();
		menuBar();
		eventos();

		habilitarBotones(false);
		setVisible(true);
		
		if(showHelp)
		{
			timer = new Timer(3000, (a)-> 
			{
				aboutW.setVisible(true);
				timer.stop();
				timer=null;
			});
			timer.start();
		}
		
	}

	public Appi(String path, String file, boolean show)
	{
		this(path,show);
		pestanas.openWithFile(file);
	}

	private void accionesSecundarias()
	{
		actionesSecun = new ActionListener[] { (a) -> 
		{
			pestanas.crear();

			if (!rdNorte.isEnabled())
			{
				habilitarBotones(true);
			}
		},

				(a) -> {
					if (!pestanas.estaVacia())
					{
						pestanas.getAreaDibujo().crearPNG();
					} else
					{
						JOptionPane.showMessageDialog(this, "No se ha cargado ninguna grafica", 
								"Imagen: null",
								JOptionPane.ERROR_MESSAGE);
					}
				},

				(a) -> {
					pestanas.cerrar();

					if (pestanas.estaVacia())
					{
						habilitarBotones(false);
					}
				},

				(a) -> 
				{
					obtenerDatosPortapapeles();
				}, 
				
				(a)->
				{
					fondos.setVisible(mtcVisible.isSelected());
					validate();
				}

		};

	}

	private void obtenerDatosPortapapeles()
	{
		if(checkValidPortapeles())
		{
			try
			{
				String ruta = datos.getTransferData(DataFlavor.stringFlavor).toString();
				
				String files[] = ruta.split("\n");
				
				for(String r : files)
					pestanas.openWithFile(r);
				
				habilitarBotones(true);
				
			} catch (UnsupportedFlavorException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean checkValidPortapeles()
	{
		portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();
		datos = portapapeles.getContents(null);
		
		return (datos.isDataFlavorSupported(DataFlavor.stringFlavor));
	}

	private void eventos()
	{
		btnRotarD.addActionListener((a) -> {
			if (togglePastel.isSelected())
				pestanas.getAreaDibujo().rotar(-45);
			else
				pestanas.getAreaDibujo().rotarBarras();

		});

		btnRotarIz.addActionListener((a) -> {

			if (togglePastel.isSelected())
				pestanas.getAreaDibujo().rotar(45);
			else
				pestanas.getAreaDibujo().rotarBarras();
		});

		btnAumentar.addActionListener((a) -> {
			pestanas.getAreaDibujo().aumentar();
		});

		btnDecre.addActionListener((a) -> {
			pestanas.getAreaDibujo().disminuir();
		});
		
		togglePorce.addActionListener((a)->{
			
			if(togglePorce.isSelected())
				pestanas.getAreaDibujo().gr.toPorcentajes();
			
			else pestanas.getAreaDibujo().gr.toDatos();
			
			pestanas.getAreaDibujo().repaint();
		});
	}

	@SuppressWarnings("serial")
	private void funciones()
	{
		add(panelFunciones, "North");
		TitledBorder tl = new TitledBorder(BorderFactory.createLineBorder(Color.black));
		tl.setTitle("FUNCIONES");
		tl.setTitleJustification(TitledBorder.CENTER);

		panelFunciones.setBorder(tl);
		panelFunciones.setBackground(Color.white);
		panelFunciones.setLayout(new BorderLayout());

		JPanel panelDatosG = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				super.paintComponents(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setPaint(new GradientPaint(200, 0, Color.cyan, 200, 100, Color.yellow));
				g2d.fillRect(3, 8, this.getWidth(), this.getHeight() - 10);
			}
		};

		{

			tl = new TitledBorder(BorderFactory.createLineBorder(Color.black));
			tl.setTitle("ASIGNACIONES");
			tl.setTitleJustification(TitledBorder.CENTER);
			panelDatosG.setBorder(tl);
			panelDatosG.setLayout(null);
			panelDatosG.setPreferredSize(new Dimension(300, 110));

			btnNuevaG = new JButton(getImageIcon("new.png"));
			btnNuevaG.setToolTipText("Nueva grafica");
			btnNuevaG.setBackground(Color.white);
			btnNuevaG.addActionListener(actionesSecun[0]);
			btnNuevaG.setBounds(20, 20, 36, 36);

			btnCerrar = new JButton(getImageIcon("error.png"));
			btnCerrar.setToolTipText("Cerrar pestaña");
			btnCerrar.setBackground(Color.white);
			btnCerrar.setBounds(20, 60, 36, 36);
			btnCerrar.addActionListener(actionesSecun[2]);

			JLabel lblTitulo = new JLabel("Titulo Grafica");
			lblTitulo.setBounds(110, 35, 100, 10);
			txtTitulo = new JTextField();
			txtTitulo.setBounds(90, 55, 130, 20);

			txtTitulo.addActionListener((a) -> pestanas.cambiarTitulo(txtTitulo.getText()));
			txtTitulo.addKeyListener(new KeyAdapter()
			{
				@Override
				public void keyReleased(KeyEvent e)
				{
					try
					{
						pestanas.getAreaDibujo().cad = txtTitulo.getText();
						pestanas.getAreaDibujo().repaint();
					} catch (NullPointerException ex)
					{
					}
				}
			});

			btnTablaCategrias = new JButton(getImageIcon("table.png"));
			btnTablaCategrias.setToolTipText("Agregar categorias");
			btnTablaCategrias.setBackground(Color.white);
			btnTablaCategrias.addActionListener((a) -> {
				tablaCategorias.setAreaDibujo(pestanas.getAreaDibujo());
				tablaCategorias.setVisible(true);
			}

			);
			btnTablaCategrias.setBounds(245, 20, 36, 36);
			btnTablaCategrias.setEnabled(false);

			btnRefres = new JButton(getImageIcon("refresh.png"));
			btnRefres.setToolTipText("Refrescar");
			btnRefres.setBackground(Color.white);
			btnRefres.setBounds(245, 60, 36, 36);
			btnRefres.addActionListener((a) -> {
				pestanas.getAreaDibujo().setTypeGraph(opc);
			});

			panelDatosG.add(btnTablaCategrias);
			panelDatosG.add(lblTitulo);
			panelDatosG.add(txtTitulo);
			panelDatosG.add(btnCerrar);
			panelDatosG.add(btnNuevaG);
			panelDatosG.add(btnRefres);

			panelFunciones.add(panelDatosG, "West");
		}

		JPanel panelCongG = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				super.paintComponents(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setPaint(new GradientPaint(200, 20, Color.white, 200, 400, Color.black));
				g2d.fillRect(3, 8, this.getWidth(), this.getHeight() - 10);
			}
		};

		{
			tl = new TitledBorder(BorderFactory.createLineBorder(Color.black));
			tl.setTitle("CONFIGURACIONES");
			tl.setTitleJustification(TitledBorder.CENTER);

			panelCongG.setBorder(tl);
			panelCongG.setLayout(null);

			JLabel lblTamaño = new JLabel("Escalar grafica");
			lblTamaño.setBounds(20, 15, 110, 35);

			btnAumentar = new JButton(getImageIcon("plus.png"));
			btnAumentar.setBackground(Color.white);
			btnAumentar.setBounds(25, 45, 36, 36);

			btnDecre = new JButton(getImageIcon("minus.png"));
			btnDecre.setBackground(Color.white);
			btnDecre.setBounds(75, 45, 36, 36);

			JLabel lblTipoG = new JLabel("Tipo de grafica");
			lblTipoG.setBounds(200, 15, 110, 35);

			toggleBarras = new JToggleButton(getImageIcon("barras.png"));
			toggleBarras.setBounds(205, 45, 36, 36);
			toggleBarras.setBackground(Color.white);
			toggleBarras.addActionListener((a) -> {
				opc = Grafica.BARRAS;
				pestanas.getAreaDibujo().setTypeGraph(opc);

			});
			toggleBarras.setSelected(true);

			togglePastel = new JToggleButton(getImageIcon("pastel.png"));
			togglePastel.setBounds(255, 45, 36, 36);
			togglePastel.setBackground(Color.white);
			togglePastel.addActionListener((a) -> {
				if (pestanas.getAreaDibujo().setTypeGraph(Grafica.PASTEL))
				{
					opc = Grafica.PASTEL;
				} else
					toggleBarras.setSelected(true);
			});

			{
				ButtonGroup bg = new ButtonGroup();
				bg.add(toggleBarras);
				bg.add(togglePastel);
			}

			JLabel lblPos = new JLabel("Posicion del titulo");
			lblPos.setBounds(370, 15, 130, 30);

			rdNorte = new JRadioButton("Norte");
			rdNorte.setSelected(true);
			rdNorte.addItemListener((a) -> {
				pestanas.getAreaDibujo().setPositionTitle(Grafica.NORTE);
			});

			rdNorte.setBackground(new Color(0, 0, 0, 0));
			rdNorte.setBounds(390, 45, 63, 20);

			rdSur = new JRadioButton("Sur");
			rdSur.addItemListener((a) -> {
				pestanas.getAreaDibujo().setPositionTitle(Grafica.SUR);
			});

			rdSur.setBackground(new Color(0, 0, 0, 0));
			rdSur.setBounds(390, 70, 50, 20);

			{
				ButtonGroup bg = new ButtonGroup();
				bg.add(rdNorte);
				bg.add(rdSur);
			}

			JLabel rotar = new JLabel("Rotar");
			rotar.setBounds(550, 15, 90, 30);

			btnRotarIz = new JButton(getImageIcon("rotleft.png"));
			btnRotarIz.setBounds(530, 45, 36, 36);
			btnRotarIz.setBackground(Color.white);

			btnRotarD = new JButton(getImageIcon("rotright.png"));
			btnRotarD.setBounds(575, 45, 36, 36);
			btnRotarD.setBackground(Color.white);

			JLabel lblEsp = new JLabel("Espaciado barras");
			lblEsp.setBounds(655, 15, 170, 30);
			comboEspacios = new JComboBox<Integer>(new Integer[] { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 });
			comboEspacios.setBounds(675, 55, 80, 20);
			comboEspacios.addItemListener((a) ->

			{
				pestanas.getAreaDibujo().espaciado(Integer.valueOf(comboEspacios.getSelectedItem().toString()));
			}

			);
			
			JLabel lbPor = new JLabel("Mostrar porcentajes");
			lbPor.setBounds(815, 15, 170, 30);
			togglePorce = new JToggleButton(getImageIcon("porcen.png"));
			togglePorce.setBounds(850, 45, 36, 36);
			togglePorce.setBackground(Color.white);
			togglePorce.setSelected(true);
			
			
			panelCongG.add(lbPor);
			panelCongG.add(togglePorce);
			panelCongG.add(btnRotarD);
			panelCongG.add(btnRotarIz);
			panelCongG.add(rotar);
			panelCongG.add(rdSur);
			panelCongG.add(rdNorte);
			panelCongG.add(lblPos);
			panelCongG.add(toggleBarras);
			panelCongG.add(togglePastel);
			panelCongG.add(lblTipoG);
			panelCongG.add(btnAumentar);
			panelCongG.add(btnDecre);
			panelCongG.add(lblTamaño);
			panelCongG.add(comboEspacios);
			panelCongG.add(lblEsp);
			panelFunciones.add(panelCongG, "Center");
		}

		habilitarBotones(false);
	}

	private void habilitarBotones(boolean h)
	{
		toggleBarras.setEnabled(h);
		btnCerrar.setEnabled(h);
		togglePastel.setEnabled(h);
		btnTablaCategrias.setEnabled(h);
		rdNorte.setEnabled(h);
		rdSur.setEnabled(h);
		btnAumentar.setEnabled(h);
		btnDecre.setEnabled(h);
		btnRotarD.setEnabled(h);
		btnRotarIz.setEnabled(h);
		btnRefres.setEnabled(h);
		comboEspacios.setEnabled(h);
		togglePorce.setEnabled(h);
	}
	
	private void menuBar()
	{
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("Archivo");

		menuBar.add(menu);

		JMenuItem mt1 = new JMenuItem("Nueva grafica");
		mt1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		
		JMenuItem mt4 = new JMenuItem("Cerrar pestaña");
		mt4.addActionListener(actionesSecun[2]);
		
		JMenuItem mt2 = new JMenuItem("Exportar como imagen");
		
		JMenuItem mt3 = new JMenuItem("Pegar archivo");
		
		
		
		mtcVisible = new JCheckBoxMenuItem("Activar panel configuraciones");
		mtcVisible.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
		
		
		mt3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		menu.add(mt1);
		menu.add(mt4);
		menu.add(mt2);
		menu.add(mt3);
		menu.add(mtcVisible);
		
		mt1.addActionListener(actionesSecun[0]);
		mt2.addActionListener(actionesSecun[1]);
		mt3.addActionListener(actionesSecun[3]);
		mtcVisible.addActionListener(actionesSecun[4]);


		menu.addSeparator();
		
		JMenuItem mtClose = new JMenuItem("Cerrar programa");
		menu.add(mtClose);
		mtClose.addActionListener((a)->closList.windowClosing(null));
		
		JMenu ayuda = new JMenu("Ayuda");
		JMenuItem about = new JMenuItem("Acerca de",getImageIcon("about.png"));
		about.addActionListener((a)->aboutW.setVisible(true));
		ayuda.add(about);
		menuBar.add(ayuda);
	}

	public static ImageIcon getImageIcon(String nombre)
	{
		try
		{
			return new ImageIcon(PathGeneral.rutaRecursos.getPath() + "/Icons/" + nombre);
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	class ClosingListener extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e)
		{
			int opc = JOptionPane.showConfirmDialog(Appi.this, 
					"Esta seguro que desea cerrar la aplicacion?",
					"Cerrando app",JOptionPane.YES_NO_OPTION);
			
			if(opc==JOptionPane.YES_OPTION)
				System.exit(0);
		}
	}
	
}
