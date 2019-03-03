package Unidad1P2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ConversorTemperatura extends JFrame implements ChangeListener
{
	
	JSlider sliderCelsius,sliderFarenheit;
	JPanel paneCont, panelCels,panelFar;
	JTextField txtC,txtF;

	public ConversorTemperatura() 
	{
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		sliderCelsius = new JSlider(JSlider.VERTICAL,0,100,0);
		sliderFarenheit = new JSlider(JSlider.VERTICAL,32,212,32);
		
		paneCont = new JPanel();
		paneCont.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
					"Conversor de Grados"));
		
		paneCont.setLayout(new GridLayout(1,2,10,10));
		
		panelCels = new JPanel();
		panelCels.setBorder(BorderFactory.createTitledBorder
				(BorderFactory.createRaisedSoftBevelBorder(),"Grados Celsius"));
		
		panelCels.setLayout(new BorderLayout(5,5));
		panelCels.add(sliderCelsius,"Center");
		
		JPanel pc = new JPanel();
		pc.add(new JLabel("C°:"));
		pc.add(txtC = new JTextField(5)); 
		panelCels.add(pc,"South");
		
		sliderCelsius.setPaintLabels(true);
		sliderCelsius.setPaintTicks(true);
		sliderCelsius.setMajorTickSpacing(10);
		sliderCelsius.setMinorTickSpacing(5);
		
		
		sliderCelsius.addChangeListener(this);
		sliderFarenheit.addChangeListener(this);
		
		sliderFarenheit.setPaintLabels(true);
		sliderFarenheit.setPaintTicks(true);
		sliderFarenheit.setMajorTickSpacing(10);
		sliderFarenheit.setMinorTickSpacing(5);
		
		panelFar = new JPanel();
		panelFar.setLayout(new BorderLayout());
		panelFar.setBorder(BorderFactory.createTitledBorder
				(BorderFactory.createRaisedSoftBevelBorder(),"Grados Farenheit"));
		
		panelFar.add(sliderFarenheit,"Center");
		
		JPanel pc2 = new JPanel();
		pc2.add(new JLabel("F°:"));
		pc2.add(txtF = new JTextField(5));
		panelFar.add(pc2,"South");
		
		paneCont.add(panelCels);
		paneCont.add(panelFar);
		
		add(paneCont,"Center");
		sliderCelsius.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseDragged(MouseEvent e) {
				val = (sliderCelsius.getValue() * (9/5))+32;
				sliderFarenheit.setValue((int)val);
				
				txtC.setText(sliderCelsius.getValue()+"");
				txtF.setText(val+"");
			}
		});
		
		sliderFarenheit.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseDragged(MouseEvent e) {
				val = (double)(sliderFarenheit.getValue()-32);
//				System.out.println(val);
				val = (val *5)/9; 
//				BigDecimal db = new BigDecimal(val);
//				db.multiply(new BigDecimal( (double)(5/9)));
//				System.out.println(db.doubleValue());
				sliderCelsius.setValue((int)val);
				txtF.setText(sliderFarenheit.getValue()+"");
				txtC.setText(String.format("%.0f",val));
			}
		});
		
	}
	
/*
 *  C =(F-32) * 5/9
		 *  F = C * 9/5 + 32;
 */
	
	double val;
	
	double  cons=5/9;
	@Override
	public void stateChanged(ChangeEvent e) 
	{
		
//		if(e.getSource() == sliderCelsius)
//		{
//			
//		}
//
//		
//		if(e.getSource() == sliderFarenheit)
//		{
//			
//				{
//				
//				}
//		}
	}
	
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(

				()->
				{
					new ConversorTemperatura().setVisible(true);
				}
				
				);
	}
}
