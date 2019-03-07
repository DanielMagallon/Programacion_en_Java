package Unidad1P2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class TextoFormatoP3 extends JFrame implements ActionListener
{

	JToggleButton tgItalica,tgBold,tgMayus,tgMinus;
	JLabel lblTxt;
	JTextField txt;
	
	public TextoFormatoP3() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		JPanel up = new JPanel();
		
		ButtonGroup gr = new ButtonGroup();
		{
			
			up.setLayout(new GridLayout(1,4,5,5));
			tgItalica = new JToggleButton("Italic");
			tgBold = new JToggleButton("Bold");
			
			
			gr.add(tgMayus = new JToggleButton("Mayuscula"));
			gr.add(tgMinus = new JToggleButton("Minuscula"));
			
			tgItalica.addActionListener(this);
			tgBold.addActionListener(this);
			tgMayus.addActionListener(this);
			tgMinus.addActionListener(this);
			
			up.add(tgItalica);
			up.add(tgBold);
			up.add(tgMayus);
			up.add(tgMinus);
		
			add(up,"North");
		}
		
		JPanel ab = new JPanel();
		
		{
			ab.add(new JLabel("Escribe una cadena: "));
			
			 txt = new JTextField(10);
			
			txt.addActionListener(this);
			
			ab.add(txt);
			
			add(lblTxt = new JLabel(),"Center");
			add(ab,"South");
			
			lblTxt.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		texto();
	}
	
	private void texto()
	{
		int italica = tgItalica.isSelected() ? Font.ITALIC : 0;
		int bold = tgBold.isSelected() ? Font.BOLD : 0;
		
		String t = txt.getText();
		
		t = tgMayus.isSelected() ? t.toUpperCase() : t.toLowerCase();
		
		lblTxt.setFont(new Font("Arial", italica|bold, 24));
		lblTxt.setText(t);
	}
	
	public static void main(String[] args) {
		
		new TextoFormatoP3().setVisible(true);
	}
}
