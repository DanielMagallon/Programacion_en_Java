package Simulacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import static Simulacion.MathData.valoresXi;

public class WindPSeries extends JDialog
{
	private Grafica grafica;
	
	public WindPSeries()
	{
		setLayout(new BorderLayout());
		setModal(true);
		setSize(this.getParent().getSize());
		setBounds((GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds()));
		
		grafica = new Grafica();
		
		JScrollPane sc = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setViewportView(grafica);
		
		
		add(sc,"Center");
		
		JPanel ok = new JPanel();
		
		{
			add(ok,"South");
			
			JButton oc = new JButton("Graficar puntos");
			oc.addActionListener((a)->
			{
				if(valoresXi == null || valoresXi.length==1)
				{
					JOptionPane.showMessageDialog(this, "No es posible graficar con el conjunto Ri dado",
							"Conjunro Ri Vacio/Tamaño 1",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				createPoints();
				grafica.graphicPoints();
			});
			ok.add(oc);
			
			JButton dividir = new JButton("Dividir Espacio");
			
			dividir.addActionListener((a)->
				{
					if(valoresXi!=null && valoresXi.length!=1)
					{
					grafica.dividirEspacio();
					}
					else JOptionPane.showMessageDialog(this, "No es posible dividir con el conjunto Ri dado",
							"Conjunro Ri Vacio/Tamaño 1",JOptionPane.ERROR_MESSAGE);
				}
			);
			
			ok.add(dividir);
		}
	}
	
	public void createPoints()
	{
		
		grafica.points = new int[valoresXi.length-1][2];
		grafica.colores = new Color[valoresXi.length-1];
		String twoDig,cad;
		Random lb = new Random();
		int index;
		
			for(int i=0; i<grafica.points.length; i++)
			{
					grafica.colores[i] = new Color
							(lb.nextInt(256),lb.nextInt(256),lb.nextInt(256));
				
					cad = valoresXi[i]+"";
					index = cad.indexOf(".");
					twoDig = (cad).substring
							(index+1, index+3);
					
					grafica.points[i][0] = Integer.parseInt(twoDig);
					
					cad = valoresXi[i+1]+"";
					index = cad.indexOf(".");
					twoDig = (cad).substring
							(index+1, index+3);
					
					grafica.points[i][1] = Integer.parseInt(twoDig);
				}
	}
}
