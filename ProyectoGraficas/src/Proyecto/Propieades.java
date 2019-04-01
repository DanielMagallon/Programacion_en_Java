package Proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Propieades extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4515859170734946919L;
	public static Font fuente = new Font("Arial", Font.BOLD, 32);
	public static Color colorfuente = Color.black;
	JComboBox<String> fonts;
	JComboBox<Integer> tamanioF;
	
	public Propieades(JFrame f)
	{
		super(f, true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600, 200);
		setLocationRelativeTo(f);
		
		setLayout(new GridLayout(4,1,10,10));
		
		JPanel tipo = new JPanel();
		
		{
			JLabel lblTipoF = new JLabel("Escoga el tipo de fuente: ");
			String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
			
			fonts = new JComboBox<String>(fuentes);
			
			tipo.add(lblTipoF);
			tipo.add(fonts);
			add(tipo);
		}
		
		
		JPanel tam = new JPanel();
		
		{
			JLabel lblTam = new JLabel("Tamaño fuente: ");
			
			Integer ent[] = new Integer[75];
			
			for(int i=0; i<ent.length; i++)
					ent[i] = i+8;
			
			 tamanioF = new JComboBox<Integer>(ent);
			
			tam.add(lblTam);
			tam.add(tamanioF);
			
			add(tam);
		}
		
		JPanel colorF = new JPanel();
		
		{
			JLabel lblCol = new JLabel("Color fuente");
			
			JLabel col = new JLabel("...");
			col.setOpaque(true);
			
			col.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					colorfuente = JColorChooser.showDialog
							(Propieades.this, "Escoga un color", colorfuente);
					
					col.setBackground(colorfuente);
				}
			});
			colorF.add(lblCol);
			colorF.add(col);
			
			add(colorF);
		}
		
		JPanel cambios = new JPanel();
		
		{
			JButton aceptar = new JButton("Aceptar");
			
			aceptar.addActionListener((a)->
			
						fuente = new Font
						(fonts.getSelectedItem().toString(), 
								Font.BOLD, 
						 Integer.parseInt(tamanioF.getSelectedItem().toString()))
					
					);
			
			cambios.add(aceptar);
			
			add(cambios);
		}
	}
}
