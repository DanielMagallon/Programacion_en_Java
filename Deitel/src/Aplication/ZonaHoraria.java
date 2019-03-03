package Aplication;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ZonaHoraria extends JFrame implements ChangeListener 
{
	JSlider slidMex, slidEU, slidJap;
	JPanel panelMex,panelEU, panelJap;
	
	final int MINIUM, MAXIUM;
	int hora;
	
	public ZonaHoraria()
	{
		setLayout(new GridLayout(1,3));
		setDefaultCloseOperation(2);
		
		MINIUM=0;
		MAXIUM=23;
		
		createPanel();
		createSlid();
		inicializateSlid();
		
		pack();
	}
	
	private void createPanel()
	{
		panelMex=new JPanel();
		panelEU=new JPanel();
		panelJap=new JPanel();
		
		add(panelMex);
		add(panelEU);
		add(panelJap);
	}
	
	private void createSlid()
	{
		slidMex = new JSlider();
		slidMex.setOrientation(SwingConstants.VERTICAL);
		
		slidEU = new JSlider();
		slidEU.setOrientation(SwingConstants.VERTICAL);
		
		slidJap = new JSlider();
		slidJap.setOrientation(SwingConstants.VERTICAL);
		
		panelMex.add(slidMex);
		panelEU.add(slidEU);
		panelJap.add(slidJap);
		
		
	}
	
	private void inicializateSlid()
	{
		JSlider[] slids = {slidMex, slidEU, slidJap};
		
		for (JSlider slid : slids)
		{
			slid.setMaximum(MAXIUM);
			slid.setMinimum(MINIUM);
			slid.setPaintTicks(true);
			slid.setMajorTickSpacing(1);
			slid.setPaintLabels(true);
			slid.addChangeListener(this);
		}
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		if(e.getSource() == slidMex)
		{
			processMex();
		}
		
		else if(e.getSource()==slidEU)
		{
			
		}
		
		else if (e.getSource() == slidJap)
		{
			
		}
	}
	
	private void processMex()
	{
		hora=slidMex.getValue();
		
		slidEU.setValue(hora+1);
		slidJap.setValue(hora+15);
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Thread(
				
				() -> new ZonaHoraria().setVisible(true)

				)); 
	}
}
