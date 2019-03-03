package C12Evalucacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TemperatureConvertion extends JFrame
{
	private JTextField text;
	private JLabel result;
	private JButton btnConversion;
	private FlowLayout layout;
	private JPanel panel;
	
	public TemperatureConvertion()
	{
		super("Temperature Conversion");
		
		panel=new JPanel();
		layout=new FlowLayout();
		panel.setLayout(layout);
		
		text=new JTextField(10);
		result = new JLabel();
		btnConversion = new JButton("Convert to Celsius");
		
		panel.add(text);
		panel.add(btnConversion);
		panel.add(result);
		add(panel);
		
		
		buttonConversion();
		textConvertion();
		
	}
	
	private void buttonConversion()
	{
		btnConversion.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				convertToCelsius();
			}
		});
	}
	
	private void textConvertion()
	{
		text.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				convertToCelsius();
				
			}
		});
	}
	
	private void convertToCelsius()
	{
		double celsius,farenheit;
		
		try
		{
			farenheit=Double.parseDouble(text.getText());
			 
			celsius=(5.0 / 9.0) * (farenheit-32);
			
			result.setText(String.format("The temperature in Celsius is: %.2f", 
							celsius));
		}
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this, 
					"Can not be converted letters/caracters to number",
					"Error Conversion",JOptionPane.ERROR_MESSAGE);
		}
	}
}
