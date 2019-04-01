package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import Libreria.Grafica;

public class Appi extends JFrame
{
	private static final long serialVersionUID = -6345646015769705197L;
	
	private Pestanas pestanas;
	private JPanel panelFunciones;
	private JMenuBar menuBar;
	private JSplitPane split;
	private ActionListener[] actionesSecun;
	private Categorias tablaCategorias;
	private PanelFondos fondos;

	private JToggleButton togglePastel, toggleBarras;
	private JRadioButton rdNorte, rdSur;
	private JButton btnAumentar, btnDecre, btnTablaCategrias, btnNuevaG, btnRefres, btnCerrar, btnRotarD, btnRotarIz;

	private Propiedades dialogFuentes;

	private int opc;
	
	public static JComboBox<Integer> comboEspacios;

	private JTextField txtTitulo;

	public Appi(String path)
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setLayout(new BorderLayout(10, 10));

		opc = Grafica.BARRAS;
		panelFunciones = new JPanel();

		tablaCategorias = new Categorias(path);

		pestanas = new Pestanas(tablaCategorias);
		dialogFuentes = new Propiedades(this,pestanas);
		tablaCategorias.setTabbed(pestanas);

		fondos = new PanelFondos(pestanas);

		JScrollPane sc = new JScrollPane(fondos);
		sc.setPreferredSize(new Dimension(140, 100));

		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		split.setRightComponent(pestanas);
		split.setLeftComponent(sc);
		add(split, "Center");

		accionesSecundarias();
		funciones();
		menuBar();
		eventos();

		habilitarBotones(false);
	}
	
	public Appi(String path,String file)
	{
		this(path);
		
		pestanas.crearConArchivo(path,file);
	}

	private void accionesSecundarias()
	{
		actionesSecun = new ActionListener[] { (a) -> {
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
						JOptionPane.showMessageDialog(this, "No se ha cargado ninguna grafica", "Imagen: null",
								JOptionPane.ERROR_MESSAGE);
					}
				},

				(a) -> dialogFuentes.setVisible(true),

				(a) -> {
					pestanas.cerrar();

					if (pestanas.estaVacia())
					{
						habilitarBotones(false);
					}
				}

		};

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
	}

	@SuppressWarnings("serial")
	private void funciones()
	{
		add(panelFunciones, "North");

		TitledBorder tl = new TitledBorder(BorderFactory.createLineBorder(Color.black));
		tl.setTitle("FUNCIONES");
		tl.setTitleJustification(TitledBorder.CENTER);

		panelFunciones.setBorder(tl);

		// panelFunciones.setLayout(new GridLayout(1,2,10,0));
		panelFunciones.setLayout(new BorderLayout());

		JPanel panelDatosG = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				super.paintComponents(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setPaint(new GradientPaint(200, 0, Color.WHITE, 200, 100, Color.BLUE));
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
			btnNuevaG.setBackground(Color.white);
			btnNuevaG.addActionListener(actionesSecun[0]);
			btnNuevaG.setBounds(20, 20, 36, 36);

			btnCerrar = new JButton(getImageIcon("error.png"));
			btnCerrar.setBackground(Color.white);
			btnCerrar.setBounds(20, 60, 36, 36);
			btnCerrar.addActionListener(actionesSecun[3]);

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

			btnTablaCategrias = new JButton(getImageIcon("barras.png"));
			btnTablaCategrias.setBackground(Color.white);
			btnTablaCategrias.addActionListener((a) -> {
				tablaCategorias.setAreaDibujo(pestanas.getAreaDibujo());
				tablaCategorias.setVisible(true);
			}

			);
			btnTablaCategrias.setBounds(245, 20, 36, 36);
			btnTablaCategrias.setEnabled(false);

			btnRefres = new JButton(getImageIcon("refresh.png"));
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
				g2d.setPaint(new GradientPaint(200, 20, Color.WHITE, 200, 400, Color.BLACK));
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

			btnAumentar = new JButton(getImageIcon("barras.png"));
			btnAumentar.setBackground(Color.white);
			btnAumentar.setBounds(25, 45, 36, 36);

			btnDecre = new JButton(getImageIcon("barras.png"));
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
			togglePastel.addActionListener((a) -> 
			{
				if(pestanas.getAreaDibujo().setTypeGraph(Grafica.PASTEL))
				{
					opc = Grafica.PASTEL;
				}
				else toggleBarras.setSelected(true);
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
			lblEsp.setBounds(675,15,170,30);
			comboEspacios = new JComboBox<Integer>(new Integer[] {0,10,20,30,40,50,60,70,80,90,100});
			comboEspacios.setBounds(675,55,120,20);
			comboEspacios.addItemListener((a)->
			
					{
						pestanas.getAreaDibujo().espaciado(
								Integer.valueOf(comboEspacios.getSelectedItem().toString()));
					}
			
			);

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
	}

	private void menuBar()
	{
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("Arhivo");

		menuBar.add(menu);

		JMenuItem mt1 = new JMenuItem("Nueva grafica");
		JMenuItem mt2 = new JMenuItem("Exportar como imagen");

		menu.add(mt1);
		menu.add(mt2);

		mt1.addActionListener(actionesSecun[0]);
		mt2.addActionListener(actionesSecun[1]);

		JMenu menuEdi = new JMenu("Editar");
		menuBar.add(menuEdi);

		JMenuItem menuF = new JMenuItem("Fuente");
		menuEdi.add(menuF);

		menuF.addActionListener(actionesSecun[2]);
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

	public static void copy(File sourceLocation, File targetLocation,String mk) throws IOException {
	    if (sourceLocation.isDirectory()) {
	        copyDirectory(sourceLocation, targetLocation,mk);
	    } else {
	        copyFile(sourceLocation, targetLocation);
	    }
	}
	
	private static  void copyDirectory(File source, File target,String mk) throws IOException 
	{
		File carpeta = new File(target.getPath()+"/"+mk+"/");
	    carpeta.mkdir();

	    for (String f : source.list()) {
	        copy(new File(source, f), new File(carpeta, f),mk);
	    }
	    
	}

	private static void copyFile(File source, File target) throws IOException {        
	    try (
	            InputStream in = new FileInputStream(source);
	            OutputStream out = new FileOutputStream(target)
	    ) {
	        byte[] buf = new byte[1024];
	        int length;
	        while ((length = in.read(buf)) > 0) {
	            out.write(buf, 0, length);
	        }
	        source.delete();
	        out.close();
	        in.close();
	    }
	}
	

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(
				
				()-> 
				{
					if(args.length==0)
					{
						System.out.println("Abriendo aplicion natal");
						
						 new PathGeneral((a)-> 
						 {
							 try
							 {
								 new Appi(a).setVisible(true);
							 }catch (Exception e) {
								 JOptionPane.showMessageDialog(null, "Ha ocurrudo un error "+e.getMessage());
								 e.printStackTrace();
							}
						 });
					}
					else
					{
						System.out.println("Abriendo aplicacion desde el archivo: "+args[0]+args[1]);
						 
						try
						 {
							 PathGeneral.rutaRecursos = new File(args[0]);
							 new Appi(args[0],args[1]).setVisible(true);
						 }catch (Exception e) {
							 JOptionPane.showMessageDialog(null, "Ha ocurrudo un error "+e.getMessage());
							 e.printStackTrace();
						}
					}
				}
				
				);
	}
}
