package Practica2;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Simulador extends JFrame implements ActionListener 
{
	private static final long serialVersionUID = -20987949569500274L;
	
	TablaValores tabla = new TablaValores();
	JPanel sh = new JPanel();
	Reporte r= new Reporte();
	boolean informe = false;
	
	JButton btnAleatorios,btnEjecutar,btnAgregar,btnBorrar,btnReporte;
	
	public Simulador() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(getToolkit().getScreenSize().width,getToolkit().getScreenSize().height-40);
		setResizable(false);
		setLayout(new BorderLayout(30,10));
		
		
		JScrollPane c = new JScrollPane(tabla);
		add(c,"Center");
		
		btnAgregar = new JButton("Agregar nuevo cliente");
		btnEjecutar = new JButton("Simular fila");
		btnAleatorios = new JButton("Asingar arribos aleatoriamente");
		btnBorrar = new JButton("Borrar datos");
		btnReporte = new JButton("Medidas de desempeño");
		
		btnAgregar.addActionListener(this);
		btnEjecutar.addActionListener(this);
		btnAleatorios.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnReporte.addActionListener(this);
		
		btnAgregar.setBackground(Color.white);
		btnEjecutar.setBackground(Color.white);
		btnAleatorios.setBackground(Color.white);
		btnBorrar.setBackground(Color.white);
		btnReporte.setBackground(Color.white);
		
		
		sh.add(btnAgregar);
		sh.add(btnAleatorios);
		sh.add(btnEjecutar);
		sh.add(btnBorrar);
		sh.add(btnReporte);
		
		add(sh,"North");
		
		
		btnAleatorios.setEnabled(false);
		btnEjecutar.setEnabled(false);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnAgregar)
		{
			tabla.nuevoCliente();
			
			if(!btnAleatorios.isEnabled())
				btnAleatorios.setEnabled(true);
			
			if(btnEjecutar.isEnabled())
				btnEjecutar.setEnabled(false);
		}
		else if(e.getSource() == btnEjecutar)
		{
			tabla.ejecutar();
			informe = true;
			r.t.repaint();
		}
		
		else if(e.getSource() == btnAleatorios)
		{
			tabla.tablaAleatorios();
			btnEjecutar.setEnabled(true);
		}
		
		else if(e.getSource() == btnBorrar)
		{
			tabla.reset();
			btnAleatorios.setEnabled(false);
			btnEjecutar.setEnabled(false);
			informe=false;
		}
		else {
			r.setVisible(true);
		}
	}
	
	class Reporte extends JDialog{

		private static final long serialVersionUID = -1345117127338070292L;
		Texto t = new Texto(); 
		Font font = new Font("Arial", Font.BOLD|Font.ITALIC, 32);
		
		public Reporte() 
		{
			setBounds(400,150,600,350);
			add(t);
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);
			setTitle("REPORTE");
		}
		
		
		class Texto extends Canvas
		{
			private static final long serialVersionUID = 1081209032178081742L;

			public Texto() 
			{
				setBackground(Color.white);
			}
			
			@Override
			public void paint(Graphics g) 
			{
				g.setFont(font);
				g.setColor(Color.blue);
				g.drawString("MEDIDAS DE DESEMPEÑO", 85, 30);

				if(informe)
				{
					g.setColor(Color.black);
					g.setFont(new Font("Arial",Font.PLAIN,20));
					int x=30,y=100;
					
					for(int i=0; i<5; i++)
					{
						g.drawString(tabla.reporte[i]+tabla.valores[i], x, y);
						y+=40;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Simulador().setVisible(true);
			}
		});
	}
}
