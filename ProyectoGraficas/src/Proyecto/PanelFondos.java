package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileFilter;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;


public class PanelFondos extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 3988773978387799642L;
	int rows=2;
	private GridLayout gridL;
	private JPanel panelFuentes,panelImg;
	public static JButton btnCamColor;
	private JButton acep,btnColeje;
	private ImageListener imgLis;
	private JSplitPane split;
	public static Color colorFondo = Color.white;
	private Pestanas pest;
	private Image imagenesFondos[];
	public boolean cambioFond,cambioEje;
	private PanelFormato p1,p2;
	
	public static int tamanio=150;
	
	public PanelFondos(Pestanas pest)
	{
		setPreferredSize(new Dimension(600,200));
		this.pest=pest;
		setLayout(new BorderLayout());
		
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(split,"Center");
		
		panelFuentes = new JPanel();
		panelFuentes.setBorder(BorderFactory.createTitledBorder
				("Fuentes y colores"));
		
		btnCamColor = new JButton("Cambiar");
		
		 p1 = new PanelFormato("Titulo","Formato del titulo");
		 p2 = new PanelFormato("Categoria","Formato de las categorias");
		panelFuentes.setLayout(new GridLayout(4,1,0,10));
		panelFuentes.add(p1);
		panelFuentes.add(p2);
		
		JPanel panelColorFondo = new JPanel();
		{
			panelColorFondo.setBorder(BorderFactory.createTitledBorder("Configuracion de la grafica"));
			btnCamColor.setOpaque(true);
			btnCamColor.setBackground(colorFondo);
			panelColorFondo.add(new JLabel("Color de fondo"));
			panelColorFondo.add(btnCamColor);
			btnCamColor.addActionListener(this);
			panelColorFondo.add(btnCamColor);
			
			btnColeje = new JButton("Cambiar");
			btnColeje.setBackground(Color.white);
			btnColeje.addActionListener(this);
			panelColorFondo.add(new JLabel("Color de los ejes"));
			panelColorFondo.add(btnColeje);
			
			panelColorFondo.add(new JLabel("Tamano eje Y (por porcentajes)"));
			
			JComboBox<Integer> ejeY = new JComboBox<Integer>();
			
			for(int i=150; i<=500; i+=50)
			{
				ejeY.addItem(i);
			}
			
			panelColorFondo.add(ejeY);
			
			ejeY.addItemListener((a)->
			{
					tamanio = (int) ejeY.getSelectedItem();
					pest.getAreaDibujo().gr.setAltura(tamanio);
					pest.getAreaDibujo().repaint();
			});
			
			panelFuentes.add(panelColorFondo);
		}
		
		JScrollPane scPF = new JScrollPane(panelFuentes);
		scPF.setPreferredSize(new Dimension(600,200));
		split.setLeftComponent(scPF);
	
		FileFilter  filtro = (a)->{
			 if(a.getPath().endsWith("png") || 
				a.getPath().endsWith("jpg") || a.getPath().endsWith("jpeg"))
			 {
				 return true;
			 }
			 JOptionPane.showMessageDialog(null, "La carpeta wallpaper contiene este archivo: "+a.getName()
			 		+ "\nel cual no pertence a imagenes, por lo tanto sera eliminado");
			 a.delete();
			 return false;
		};
		
		File listImg [] = new File(PathGeneral.rutaRecursos.getPath()+"/Wallpaper/").listFiles(filtro);
		imagenesFondos = new Image[listImg.length];

		panelImg = new JPanel();
		panelImg.setBorder(BorderFactory.createTitledBorder
				("Imagen de fondo"));
		
		gridL = new GridLayout(1,listImg.length,5,0);
		panelImg.setLayout(gridL);
		imgLis = new ImageListener();
		
		for(int i=0; i<imagenesFondos.length; i++)
		{
			try
			{
				imagenesFondos[i] = new ImageIcon(listImg[i].getPath()).getImage();
				panelImg.add(new ImageLabel(i,imagenesFondos[i].getScaledInstance
						(60, 60, Image.SCALE_AREA_AVERAGING),imgLis));
				
			}
			catch(NullPointerException e)
			{
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error al leer las imagenes",
						"Error de imagen",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		JScrollPane barras = new JScrollPane(panelImg);
		
		split.setRightComponent(barras);
		
		JPanel confiGraf = new JPanel();
		
		{
			confiGraf.setBorder(new TitledBorder("Guadar cambios"));
			
			panelFuentes.add(confiGraf);
			
			acep = new JButton("Aplicar cambios");
			acep.addActionListener(this);
			confiGraf.add(acep);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnCamColor)
		{
			Color c = JColorChooser.showDialog(null, 
					"Color de fondo", btnCamColor.getBackground());
			
			if(c!=null)
			{
				cambioFond = true;
				btnCamColor.setBackground(c);
			}
		}
		else if(e.getSource() == btnColeje) 
		{
			Color c = JColorChooser.showDialog(null, 
					"Color de fondo", btnColeje.getBackground());
			
			if(c!=null)
			{
				cambioEje = true;
				btnColeje.setBackground(c);
				
			}
		}
		
		else if(!pest.estaVacia())
		{
			if(cambioFond)
			{
				colorFondo = btnCamColor.getBackground();
				pest.getAreaDibujo().setBackground(colorFondo);
				pest.getAreaDibujo().repaint();
			}
			if(cambioEje)
			{
				pest.getAreaDibujo().gr.setColorEjes(btnColeje.getBackground());
				pest.getAreaDibujo().repaint();
				
			}
			if(p1.cambioFont)
			{
				pest.getAreaDibujo().gr.setFontTitle(p1.font).setTitleColor(p1.colorFuenteT);
				pest.getAreaDibujo().repaint();
			}
			if(p2.cambioFont)
			{
				pest.getAreaDibujo().gr.setDatosFont(p2.font).setDatosColor(p2.colorFuenteT);
				pest.getAreaDibujo().repaint();
			}
			
			p1.cambioFont=p2.cambioFont=cambioFond=false;
		}
		
	}
	
	class PanelFormato extends JPanel implements ActionListener, ItemListener
	{
		private static final long serialVersionUID = 2476746078103121729L;
		Color colorFuenteT = Color.black;
		JComboBox<Integer> tamanFuent;
		JLabel lblTitulo;
		int italicT, boldT;
		JCheckBox boxBoldT, boxItalicT;
		JComboBox<String> tipoFuente;
		JButton btnColor;
		Font font;
		public boolean cambioFont; 
		
		private String tipoD;
		private int tamD = 10;
		
		public PanelFormato(String title, String border)
		{
			
			setBorder(BorderFactory.createTitledBorder(border));
			String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().
					getAvailableFontFamilyNames();
			
			tipoFuente = new JComboBox<String>(fuentes);

			Vector<Integer> list = new Vector<Integer>();

			for (int i = 20; i <= 40; i++)
				list.add(i);

			tamanFuent = new JComboBox<Integer>(list);

			list = null;

			tamanFuent.addItemListener(this);
			tipoFuente.addItemListener(this);
			lblTitulo = new JLabel(title);
			boxBoldT = new JCheckBox("Bold");
			boxBoldT.addActionListener(this);
			boxItalicT = new JCheckBox("Italic");
			boxItalicT.addActionListener(this);
			
			btnColor = new JButton("Color fuente");
			btnColor.addActionListener(this);
			
			add(lblTitulo);
			add(tipoFuente);
			add(tamanFuent);
			add(boxBoldT);
			add(boxItalicT);
			add(btnColor);
			
		}
		

		@Override
		public void itemStateChanged(ItemEvent e)
		{

			if (e.getSource() == tamanFuent)
			{
				tamD = Integer.parseInt(tamanFuent.getSelectedItem() + "");
				updateeFont();
			}


			else if (e.getSource() == tipoFuente)
			{
				tipoD = tipoFuente.getSelectedItem().toString();
				updateeFont();
			}
			
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == btnColor)
			{
				Color color = JColorChooser.showDialog(null, "Selecciona un color", colorFuenteT);

				if (color != null && color != colorFuenteT)
				{
					lblTitulo.setForeground(color);
					colorFuenteT = color;
					
					cambioFont = true;
				}
			}

			else
			{
				if (e.getSource() == boxBoldT)
				{
					if (boxBoldT.isSelected())
					{
						boldT = Font.BOLD;
					} else
						boldT = 0;
				}
				
				else if (e.getSource() == boxItalicT)
				{
					if (boxItalicT.isSelected())
					{
						italicT = Font.ITALIC;
					} else
						italicT = 0;
				}
				
				updateeFont();
			}
		}

		private void updateeFont()
		{
			int tipo;
			if (italicT == 0 && boldT == 0)
				tipo = Font.PLAIN;
			else
				tipo = italicT | boldT;

			font = new Font(tipoD, tipo, tamD);
			lblTitulo.setFont(font);
			cambioFont = true;
		}
	}
	
	class ImageLabel extends JLabel
	{
		private static final long serialVersionUID = 2487153244320128521L;
		int index;
		
		public ImageLabel(int ind, Image img, ImageListener imgl)
		{
			index = ind;
			setHorizontalAlignment(CENTER);
			setIcon(new ImageIcon(img));
			addMouseListener(imgl);
			setPreferredSize(new Dimension(60,60));
		}
	}
	
	class ImageListener extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			{
				int opc = JOptionPane.showConfirmDialog
						(null, "Desea cambiar la imagen de fondo?", 
								"Cambiando imagen...", JOptionPane.YES_NO_OPTION);
				
				if(opc == JOptionPane.OK_OPTION)
				{
					if(!pest.estaVacia())
					{
						ImageLabel im = (ImageLabel) e.getComponent();
						pest.getAreaDibujo().fondo(imagenesFondos[im.index]);
					}
					else
					{
						JOptionPane.showMessageDialog(null, 
								"No se ha creado ninguna grafica","Grafic: null",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		}
		
		@Override
		public void mouseEntered(MouseEvent e)
		{
			setCursor(Appi.cursorSeleccion);
		}
		
		@Override
		public void mouseExited(MouseEvent e)
		{
			setCursor(null);
		}
	}
}
