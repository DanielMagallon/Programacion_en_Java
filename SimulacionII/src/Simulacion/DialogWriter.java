package Simulacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileFilter;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import static Simulacion.MathData.valoresXi;

public class DialogWriter extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 8567373413217164406L;
	JList<BigDecimal> list;
	JTextField txt;
	JButton generar,agregar,borrar,refresh,open,save;
	DefaultListModel<BigDecimal> modelo;
	String text;
	BigDecimal conjunto[];
	JToolBar herramientas;
	JFileChooser chosser;
	int opc; 
	
	public DialogWriter()
	{
		
		modelo = new DefaultListModel<BigDecimal>();
		chosser = new JFileChooser();

		FileNameExtensionFilter filter = new FileNameExtensionFilter("Decimal", 
				"decimal");
		
		chosser.setFileFilter(filter);
		setModal(true);
		setTitle("Conjunto Ri determinado");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(420, 500);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(0,10));
		
		
		JScrollPane  sc = new JScrollPane(list = new JList<BigDecimal>());
		add(sc,"Center");
		list.setModel(modelo);
		
		JPanel up = new JPanel();
		{
			up.setLayout(new GridLayout(2, 1, 0, 5));
			JLabel lbl2 = new JLabel("Los elemenos se añaden en el cuadro de texto inferior");
			JLabel lbl3 = new JLabel("Debe de ingresar valores decimales");
			lbl3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl2.setForeground(Color.red);
			lbl3.setForeground(Color.red);
			up.add(lbl2);
			up.add(lbl3);

			sc.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), 
					"Conjunto Ri"));
			add(up,"North");
		}
		
		JPanel sout = new JPanel();
		
		{
			txt = new JTextField(15);
			txt.addActionListener((a)->
			{
				BigDecimal b;
				
				try
				{
					text = txt.getText();
					int ind = text.indexOf(".");
					
					if(ind==-1 )
						return;
					
					if(ind!=0)
					{
						text = text.substring(ind);
					}
					
					if(text.length()==1)
						return;
					
					if(text.length()==2)
						text+="0";
					
					b = new BigDecimal(text);
					
					modelo.addElement(b);
					
					if(modelo.size()==1)
						generar.setEnabled(true);
					
					txt.setText("");
				}
				catch(NumberFormatException e)
				{
					
				}
				
			});
			
			JPanel btns = new JPanel();
			JPanel panCon = new JPanel();
			sout.setLayout(new GridLayout(2,1,0,5));
			sout.add(panCon);
			sout.add(btns);
			
			refresh = new JButton("Refrescar");
			refresh.addActionListener(this);
			
			borrar = new JButton("Borrar elemento");
			borrar.addActionListener(this);
			generar = new JButton("Generar conjunto");
			generar.setEnabled(false);
			generar.addActionListener(this);
			panCon.add(new JLabel("Tecle Enter: "));
			panCon.add(txt);
			btns.add(borrar);
			btns.add(generar);
			btns.add(refresh);
			add(sout,"South");
		}
		
		herramientas = new JToolBar(JToolBar.VERTICAL);
		open = new JButton(getImageIcon("Simulacion/Files/", "open.png"));
		open.setToolTipText("Abrir archivo de conjuntos");
		open.addActionListener(this);
		save = new JButton(getImageIcon("Simulacion/Files/", "save.png"));
		save.setToolTipText("Guardar este conjunto en un archivo");
		save.addActionListener(this);
		herramientas.add(open);
		herramientas.add(save);
		
		add(herramientas,"West");
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == generar)
		{
			valoresXi = new BigDecimal[modelo.getSize()];
			
			for(int i=0; i<valoresXi.length; i++)
			{
				valoresXi[i] = modelo.get(i);
			}
		}
		else if(e.getSource() == refresh)
		{
			modelo.clear();
			generar.setEnabled(false);
		}
		else if(e.getSource() == save)
		{
			if(modelo.isEmpty())
			{
				JOptionPane.showMessageDialog(this, 
						"No se puede guardar el archivo", 
						"Conjunto Ri vacio", 
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			conjunto = new BigDecimal[modelo.getSize()];
			
			for(int i=0; i<modelo.getSize(); i++)
			{
				conjunto[i] = modelo.get(i);
			}
			
			opc = chosser.showSaveDialog(this);
			
			if(opc == JFileChooser.APPROVE_OPTION)
			{
				Serializa.saveObject(conjunto,new File
						(chosser.getSelectedFile().getAbsolutePath()+".decimal"));
			}
		}
		else if(e.getSource() == open)
		{
			opc = chosser.showOpenDialog(this);
			
			
				if(opc == JFileChooser.APPROVE_OPTION)
				{
					conjunto = (BigDecimal[]) Serializa.writeObject(chosser.getSelectedFile());
					
					if(conjunto == null)
					{
						JOptionPane.showMessageDialog(this, 
								"No se pudo abrir el archivo", 
								"Archivo corrupto", 
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					modelo.clear();
					
					for(int i=0; i<conjunto.length; i++)
					{
						modelo.addElement(conjunto[i]);
					}
					generar.setEnabled(true);
				}
			
		}
		
		else
		{
			int i = list.getSelectedIndex();
			
			if(i!=-1)
			{
				modelo.remove(i);
			}
			
			if(modelo.isEmpty())
				generar.setEnabled(false);
		}
		
	}
	
	public static ImageIcon getImageIcon(String path,String nombre)
	{
		return new ImageIcon(DialogWriter.class.getResource("/"+path+nombre));
		//return new ImageIcon(System.getProperty("user.dir") + "/src/"+path+nombre);
	}
}
