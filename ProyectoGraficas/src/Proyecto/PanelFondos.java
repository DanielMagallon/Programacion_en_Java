package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;


public class PanelFondos extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 3988773978387799642L;
	int rows=2;
	private GridLayout gridL;
	private JPanel fondoColor,fondoImg;
	public static JButton lblColor;
	private JButton acep;
	private ImageListener imgLis;
	private JSplitPane split;
	public static Color colorFondo = Color.white;
	private Pestanas pest;
	private Image imagenesFondos[];
	
	public PanelFondos(Pestanas pest)
	{
		this.pest=pest;
		setLayout(new BorderLayout());
		
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		add(split,"Center");
		
		fondoColor = new JPanel();
		fondoColor.setBorder(BorderFactory.createTitledBorder
				("Color de fondo"));
		
		 lblColor = new JButton("Cambiar");
		fondoColor.setLayout(new BorderLayout(0,10));
		lblColor.setOpaque(true);
		lblColor.setBackground(colorFondo);
		lblColor.addActionListener(this);
		imgLis = new ImageListener();
		acep = new JButton("Aplicar");
		acep.addActionListener(this);
		fondoColor.add(lblColor,"Center");
		fondoColor.add(acep,"South");
		
		split.setTopComponent(fondoColor);
		
		
		fondoImg = new JPanel();
		fondoImg.setBorder(BorderFactory.createTitledBorder
				("Imagen de fondo"));
	
		File listImg [] = new File(PathGeneral.rutaRecursos.getPath()+"/Wallpaper/").listFiles();
		imagenesFondos = new Image[listImg.length];

		gridL = new GridLayout(listImg.length,2,5,5);
		fondoImg.setLayout(gridL);
		
		for(int i=0; i<imagenesFondos.length; i++)
		{
			try
			{
				imagenesFondos[i] = new ImageIcon(listImg[i].getPath()).getImage();
				
				fondoImg.add(new ImageLabel(i,imagenesFondos[i].getScaledInstance
						(60, 60, Image.SCALE_AREA_AVERAGING),imgLis));
				
			}
			catch(NullPointerException e)
			{
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error al leer las imagenes",
						"Error de imagen",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		JScrollPane barras = new JScrollPane(fondoImg);
		
		split.setBottomComponent(barras);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == lblColor)
		{
			Color c = JColorChooser.showDialog(PanelFondos.this, 
					"Color de fondo", lblColor.getBackground());
			
			if(c!=null)
				lblColor.setBackground(c);
		}
		
		else if(!pest.estaVacia())
		{
			colorFondo = lblColor.getBackground();
			pest.getAreaDibujo().setBackground(colorFondo);
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
	}
}
