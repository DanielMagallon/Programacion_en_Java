package ProyectoColasU3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Animacion extends JDialog
{

	private static final long serialVersionUID = -3181258809956609495L;
	
	private JPanel contentPanel;
	public PanelCola panelProceso;
	private JButton btnReproduceAnimacion;
	
	public Animacion()
	{
		setTitle("COLA ALUMNOS");
		
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				if(!panelProceso.hayEjecucion())
				{
					panelProceso.destroy();
					Registro.btnNewButton.setEnabled(true);
					btnReproduceAnimacion.setEnabled(true);
					Animacion.this.dispose();
				}
				else JOptionPane.showMessageDialog(Animacion.this,
						"No puede cerrar la ventana, hay procesos en ejecucion","STOP",JOptionPane.WARNING_MESSAGE);
			}
		});
				
				
		contentPanel  = new JPanel();
		panelProceso = new PanelCola();
		setBounds(310, 160, 725, 400);
		contentPanel.setBackground(Color.white);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(panelProceso, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.SOUTH);
		
		 btnReproduceAnimacion = new JButton("Reproducir");
		panel.setBackground(Color.white);
		btnReproduceAnimacion.setBackground(Color.white);
		panel.add(btnReproduceAnimacion);
		btnReproduceAnimacion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				panelProceso.creaProcesos=true;
				btnReproduceAnimacion.setEnabled(false);
				panelProceso.play();
			}
		});
	}
	
	@Override
	public void setVisible(boolean arg0)
	{
		super.setVisible(arg0);

		if(arg0)
		{
			panelProceso.creaProcesos=false;
			if(PanelCola.alumnos.length>10)
				panelProceso.timerProceso2();
				
			if(PanelCola.alumnos.length>20)
				panelProceso.timerProceso3();
		}
	}

}
