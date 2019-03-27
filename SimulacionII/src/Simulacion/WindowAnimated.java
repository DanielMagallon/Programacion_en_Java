package Simulacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class WindowAnimated extends JDialog
{
	
	public WindowAnimated(String title,JScrollPane sc,int width,int height,boolean btns, Prueba p) 
	{
		JButton btnOk;
		setModal(true);
		setTitle(title);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		add(sc,"Center");

		
		JPanel panelBtn = new JPanel();
		
		{
			
			if(btns)
			{
//				btnOk = new JButton("Aceptar");
//				JButton btnConf;
//				btnCanc = new JButton("Cancelar");
//				panelBtn.add(btnConf = new JButton("Configurar"));
//				panelBtn.add(btnOk);
//				panelBtn.add(btnCanc);
				
			}
			else
			{
				btnOk = new JButton("Generar Prueba");
				
				btnOk.addActionListener((a)->
					{
						if(MathData.valoresXi!=null)
							p.generar();
						else
							JOptionPane.showMessageDialog(this, 
									"No ha generado ningun conjunto Ri", 
									"Conjunto Ri vacio", 
									JOptionPane.ERROR_MESSAGE);
					}
				);
				
				panelBtn.add(btnOk);
			}
		}
		
		add(panelBtn,"North");
	}
	
}
