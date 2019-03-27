package Simulacion;

import java.awt.Font;
import java.awt.GridLayout;
import java.math.BigDecimal;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class CorridasPanel extends JPanel implements Prueba
{

	private static final long serialVersionUID = -3781566028381257643L;
	private JPanel panelMco,panelOCo,panelZo;
	private JTextField txtCo,txtVari,txtZo;
	protected BigDecimal MCo,VarianzaCo,Zo;
	private Font font;
	
	public CorridasPanel()
	{
		font = new Font("Arial", Font.BOLD, 18);
		
		
		setLayout(new GridLayout(4, 1,0,5));
		
		panelMco = new JPanel();
		txtCo = new JTextField(10);
		panelOCo = new JPanel();
		txtVari = new JTextField(10);
		panelZo = new JPanel();
		txtZo = new JTextField(10);
		{
			JLabel lbl = new JLabel("MCo: ");
			lbl.setFont(font);
			panelMco.add(lbl);
			panelMco.add(txtCo);
			JLabel lbl2 = new JLabel("O²Co: ");
			lbl2.setFont(font);
			panelOCo.add(lbl2);
			panelOCo.add(txtVari);
			JLabel lbl3 = new JLabel("Zo: ");
			lbl3.setFont(font);
			panelZo.add(lbl3);
			panelZo.add(txtZo);
			
			add(panelMco);
			add(panelOCo);
			add(panelZo);
		}
	}
	
	@Override
	public void generar()
	{
		txtCo.setText(MCo.toString());
		txtVari.setText(VarianzaCo.toString());
		txtZo.setText(Zo.toString());
	}
}
