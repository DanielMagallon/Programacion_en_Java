package Unidad1P2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class Cafeteria extends JFrame implements ItemListener
{
	JRadioButton rdHamb,rdPasta,rdCamaron;
	JRadioButton rdAgua,rdaguaFru,rdRef;
	
	ButtonGroup grupoComida,grupoBebi;
	
	TablaSer tabla;
	JLabel lbl = new JLabel("Nombre del cliente:");
	JTextField txt = new JTextField(10);
	JButton btnAdd = new JButton("Agregar nuevo");
	JButton btnSave = new JButton("Guardar");
	double total;
	
	public Cafeteria() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(4,1,5,5));
		setSize(800, 600);
		
		JPanel panelComidas = new JPanel();
		
		{
			panelComidas.setLayout(new GridLayout(2,3));
			panelComidas.setBorder(
					
					BorderFactory.createTitledBorder
					(
							BorderFactory.createLineBorder(Color.orange, 5, true), 
							"Comidas")
					
					);
			
			add(panelComidas);
			
			grupoComida = new ButtonGroup();
			
			JLabel iconoHamb = new JLabel(new ImageIcon(getClass().getResource("/comida/f4.jpg")));
			iconoHamb.setHorizontalAlignment(JLabel.LEFT);
			
			JLabel iconoPasta = new JLabel(new ImageIcon(getClass().getResource("/comida/f5.jpg"))); 
			iconoPasta.setHorizontalAlignment(JLabel.LEFT);
			
			JLabel iconoCamaron = new JLabel(new ImageIcon(getClass().getResource("/comida/f6.jpg"))); 
			iconoCamaron.setHorizontalAlignment(JLabel.LEFT);
			
			rdHamb = new JRadioButton("Hamburguesas con papas 50$");
			rdHamb.addItemListener(this);

			rdPasta = new JRadioButton("Pasta 70$");
			rdPasta.addItemListener(this);
			
			rdCamaron = new JRadioButton("Tengrad de camaron 200$");
			rdCamaron.addItemListener(this);
			
			grupoComida.add(rdHamb);
			grupoComida.add(rdPasta);
			grupoComida.add(rdCamaron);
			
			panelComidas.add(iconoHamb);
			panelComidas.add(iconoPasta);
			panelComidas.add(iconoCamaron);
			panelComidas.add(rdHamb);
			panelComidas.add(rdPasta);
			panelComidas.add(rdCamaron);
		}
		
		JPanel panelBebs = new JPanel();
		
		{
			panelBebs.setLayout(new GridLayout(2, 3));
			panelBebs.setBorder(BorderFactory.createTitledBorder
					(
							BorderFactory.createLineBorder(Color.blue, 5, true), 
							"Bebidas")
					
					);
			
			grupoBebi = new ButtonGroup();
			
			rdAgua = new JRadioButton("Agua natural 10$");
			rdAgua.addItemListener(this);
			
			rdaguaFru = new JRadioButton("Agua de fruta 15$");
			rdaguaFru.addItemListener(this);
			
			rdRef = new JRadioButton("Refresco 30$");
			rdRef.addItemListener(this);
			
			rdAgua.setSelected(true);
			rdHamb.setSelected(true);
			grupoBebi.add(rdAgua);
			grupoBebi.add(rdaguaFru);
			grupoBebi.add(rdRef);
			
			JLabel iconoAgua = new JLabel(new ImageIcon(getClass().getResource("/comida/f1.jpg")));
			iconoAgua.setHorizontalAlignment(JLabel.LEFT);
			
			JLabel iconoAguaFr = new JLabel(new ImageIcon(getClass().getResource("/comida/f2.jpg"))); 
			iconoAguaFr.setHorizontalAlignment(JLabel.LEFT);
			
			JLabel iconRef = new JLabel(new ImageIcon(getClass().getResource("/comida/f3.jpg"))); 
			iconRef.setHorizontalAlignment(JLabel.LEFT);
			
			panelBebs.add(iconoAgua);
			panelBebs.add(iconoAguaFr);
			panelBebs.add(iconRef);
			
			panelBebs.add(rdAgua);
			panelBebs.add(rdaguaFru);
			panelBebs.add(rdRef);
			
			add(panelBebs);
		}
		
		tabla = (TablaSer) Serializa.writeObject(new File("Tabla.data"));
		
		if(tabla==null)
			tabla = new TablaSer();
		
		JScrollPane sc = new JScrollPane(tabla);

		add(sc);
		
		
		JPanel panelAdd = new JPanel();
		
		
		{
			panelAdd.setBorder(BorderFactory.createTitledBorder
					(
							BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5, true), 
							"Datos del cliente y cuenta",
							TitledBorder.CENTER,TitledBorder.ABOVE_TOP)
					
					);
			
			panelAdd.add(lbl);
			panelAdd.add(txt);
			panelAdd.add(btnAdd);
			panelAdd.add(btnSave);
			
			btnSave.addActionListener(
					
						(a)->{
							Serializa.saveObject(tabla, new File("Tabla.data"));
						}
					
					);
			
			btnAdd.addActionListener(
					
					(a)->{
						String nombre = txt.getText();
						
						if(nombre.trim().isEmpty())
						{
							JOptionPane.showMessageDialog(panelAdd, "Debe ingresar un nombre",
									"Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						tabla.agregar(nombre, com, beb, total);
					}
					
					);
			
		}
		
		add(panelAdd);
	}
	
	String com;
	String beb;
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		total = 0;
		
		if(rdHamb.isSelected())
		{
			com = "Hamburguesas";
			total+=50;
		}
			
		if(rdPasta.isSelected())
		{
			com = "Pasta";
			total+=70;
		}
			
		if(rdCamaron.isSelected())
		{
			com = "Camaron";
			total+=200;
		}
		
		if(rdAgua.isSelected())
		{
			total+=10;
			beb = "Agua";
		}
		
		if(rdaguaFru.isSelected())
		{
			total+=15;
			beb = "Agua de fruta";
		}
		
		if(rdRef.isSelected())
		{
			beb = "Refresco";
			total+=30;
		}
	}
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(
				
					()->new Cafeteria().setVisible(true)
				
				);
	}
}
