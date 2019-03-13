package P17420571;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ExamenU1P2 extends JFrame implements ItemListener
{
	JRadioButton radioKm,radioMillas;
	JTextField txtKms,txtMillas,ref;
	JLabel img;
	JButton calc;
	BigDecimal total,constante;
	
	
	public ExamenU1P2()
	{
		super("Examen");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		
		radioKm = new JRadioButton("Km a millas");
		radioMillas = new JRadioButton("Millas a km");
		
		img = new JLabel(
				
					new ImageIcon(getClass().getResource("/P17420571/millas.jpg"))
				
				);
		
		JPanel panelArr = new JPanel();
		
		{
			panelArr.add(new JLabel("Kms: "));
			panelArr.add(txtKms = new JTextField(10));
			panelArr.add(new JLabel("Millas: "));
			panelArr.add(txtMillas = new JTextField(10));
			
			add(panelArr,"North");
		}
		
		JPanel este = new JPanel();
		
		{
			este.setLayout(new GridLayout(5,1,10,10));
			este.add(radioKm);
			este.add(radioMillas);
			add(este,BorderLayout.WEST);
		}
		
		add(img,"Center");
		
		calc = new JButton("Calcular");
		JPanel sur = new JPanel();
		
		{
			sur.add(calc);
			
			add(sur,"South");
		}
		
		radioKm.setSelected(true);
		constante =  new BigDecimal("0.621371"); 
		
		ButtonGroup bt = new ButtonGroup();
		
		bt.add(radioKm);
		bt.add(radioMillas);
		txtMillas.setEditable(false);
		
		radioKm.addItemListener(this);
		radioMillas.addItemListener(this);
		
		calc.addActionListener(
				
				(a)->
				{
					if(radioKm.isSelected())
					{
						if(esNumero(txtKms.getText()))
						{
							total = new BigDecimal(txtKms.getText()).multiply(constante);
							txtMillas.setText(total+"");
						}
					}
					else
					{
						if(esNumero(txtMillas.getText()))
						{
							total = new BigDecimal(txtMillas.getText()).multiply(constante);
							txtKms.setText(total+"");
						}
					}
				}
				
			);
	}
	
	private boolean esNumero(String txt)
	{
		try
		{
			Double.parseDouble(txt);
			return true;
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this, "Solo datos numericos", "Error", 
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
//	
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource() == radioKm)
		{
			constante =  new BigDecimal("0.621371"); 
			txtKms.setEditable(true);
			txtMillas.setEditable(false);
		}
		else {
			constante =  new BigDecimal("1.60934");
			txtKms.setEditable(false);
			txtMillas.setEditable(true);
		}
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(
				
					new Runnable()
					{
						
						@Override
						public void run()
						{
							new ExamenU1P2().setVisible(true);
						}
					}
				
				);
	}
}
