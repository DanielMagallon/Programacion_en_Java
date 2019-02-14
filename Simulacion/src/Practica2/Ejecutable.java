package Practica2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Ejecutable extends JFrame implements ActionListener 
{
	TablaSimulada tabla = new TablaSimulada();
	JPanel abajo = new JPanel();
	JPanel arriba = new JPanel();
	JTextArea txtArea = new JTextArea(10,70);
	
	JButton btnAleatorios,btnEjecutar,btnAgregar,btnBorrar;
	
	public Ejecutable() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(getToolkit().getScreenSize().width,getToolkit().getScreenSize().height-40);
		setResizable(false);
		setLayout(new BorderLayout(30,10));
		
		add(new JScrollPane(tabla),"Center");
		
		btnAgregar = new JButton("Agregar cliente");
		btnEjecutar = new JButton("Ejecutar");
		btnAleatorios = new JButton("Asingar aleatoriamente");
		btnBorrar = new JButton("Borrar registros");
		
		btnAgregar.addActionListener(this);
		btnEjecutar.addActionListener(this);
		btnAleatorios.addActionListener(this);
		btnBorrar.addActionListener(this);
		
		abajo.add(btnAgregar);
		abajo.add(btnAleatorios);
		abajo.add(btnEjecutar);
		abajo.add(btnBorrar);
		
		add(abajo,"South");
		add(arriba,"North");
		
		btnAleatorios.setEnabled(false);

		arriba.setBorder(BorderFactory.createTitledBorder("Medidas de desempeño"));
		txtArea.setEditable(false);
		arriba.add(new JScrollPane(txtArea));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnAgregar)
		{
			tabla.agregarCliente();
			btnAleatorios.setEnabled(true);
		}
		else if(e.getSource() == btnEjecutar)
		{
			tabla.ejecutar();
			txtArea.setText(tabla.obtenMedidas());
		}
		
		else if(e.getSource() == btnAleatorios)
		{
			tabla.agregarAleatorios();
		}
		
		else if(e.getSource() == btnBorrar)
		{
			tabla.reset();
			btnAleatorios.setEnabled(false);
		}
	}
	
//	Font font = new Font("Arial", Font.BOLD|Font.ITALIC, 27);
//	class Texto extends JPanel{
//		
//		@Override
//		public void paint(Graphics g) 
//		{
//			g.setFont(font);
//			g.drawString("Abel", 720, 45);
//		}
//	}
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Ejecutable().setVisible(true);
			}
		});
	}
}
