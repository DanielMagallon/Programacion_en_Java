package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Perfomance.Proceso;
import java.awt.Color;

public class Restricciones extends JDialog {

	private static final long serialVersionUID = 8779600946073074012L;
	private JPanel panel;
	private JScrollPane scrollPane;
	private TableRestricciones table;
	
	public Restricciones() 
	{
		super.setTitle("Punto de Fallo general");
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(Color.WHITE);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						table.getPuntoFalloGeneral();
						ProcesFrame.btnGuardarProcesos.setText("Guardar Procesos");
						ProcesFrame.btnEjecutarProcesos.setEnabled(true);
						Restricciones.this.dispose();
					}
				});
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		{
			panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new TableRestricciones();
					scrollPane.setViewportView(table);
				}
			}
		}
		
		setLocationRelativeTo(null);
		setBounds(250, 240, 900, 122);
	}
}
