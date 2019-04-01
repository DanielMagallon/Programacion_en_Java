package Proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Propiedades extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4515859170734946919L;

	public Propiedades(JFrame f, Pestanas p)
	{
		super(f, true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(f);
		setLayout(new GridLayout(4, 1, 0, 10));
		

		PanelFormato p1 = new PanelFormato("Titulo","Formato del titulo");
		PanelFormato p2 = new PanelFormato("Categoria","Formato de las categorias");

		JButton btnOk = new JButton("Aplicar");
		btnOk.addActionListener((a)->{
			
			p.getAreaDibujo().gr.setFontTitle(p1.font).setTitleColor(p1.colorFuenteT);
			p.getAreaDibujo().gr.setDatosFont(p2.font).setDatosColor(p2.colorFuenteT);
			this.dispose();
			
		});
		
		JPanel pOk = new JPanel();
		pOk.add(btnOk);
		
		
		add(p1);
		add(p2);
		add(pOk);
	}

	class PanelFormato extends JPanel implements ActionListener, ItemListener
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 2476746078103121729L;
		Color colorFuenteT = Color.black;
		JComboBox<Integer> tamanFuent;
		JLabel lblTitulo;
		int italicT, boldT;
		JCheckBox boxBoldT, boxItalicT;
		JComboBox<String> tipoFuente;
		JButton btnColor;
		Font font;
		
		private String tipoD;
		private int tamD = 10;
		
		public PanelFormato(String title, String border)
		{
			setBorder(BorderFactory.createTitledBorder(border));
			
			String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().
					getAvailableFontFamilyNames();
			
			tipoFuente = new JComboBox<String>(fuentes);

			Vector<Integer> list = new Vector<Integer>();

			for (int i = 10; i <= 40; i++)
				list.add(i);

			tamanFuent = new JComboBox<Integer>(list);

			list = null;

			tamanFuent.addItemListener(this);
			tipoFuente.addItemListener(this);
			lblTitulo = new JLabel(title);
			boxBoldT = new JCheckBox("Bold");
			boxBoldT.addActionListener(this);
			boxItalicT = new JCheckBox("Italic");
			boxItalicT.addActionListener(this);
			
			btnColor = new JButton("Color fuente");
			btnColor.addActionListener(this);
			
			add(lblTitulo);
			add(tipoFuente);
			add(tamanFuent);
			add(boxBoldT);
			add(boxItalicT);
			add(btnColor);
		}
		

		@Override
		public void itemStateChanged(ItemEvent e)
		{

			if (e.getSource() == tamanFuent)
			{
				tamD = Integer.parseInt(tamanFuent.getSelectedItem() + "");
				updateeFont();
			}


			else if (e.getSource() == tipoFuente)
			{
				tipoD = tipoFuente.getSelectedItem().toString();
				updateeFont();
			}
			
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == btnColor)
			{
				Color color = JColorChooser.showDialog(this, "Selecciona un color", colorFuenteT);

				if (color != null && color != colorFuenteT)
				{
					lblTitulo.setForeground(color);
					colorFuenteT = color;
				}
			}

			else
			{
				if (e.getSource() == boxBoldT)
				{
					if (boxBoldT.isSelected())
					{
						boldT = Font.BOLD;
					} else
						boldT = 0;

					updateeFont();
				}

				else if (e.getSource() == boxItalicT)
				{
					if (boxItalicT.isSelected())
					{
						italicT = Font.ITALIC;
					} else
						italicT = 0;

					updateeFont();
				}
			}
		}

		private void updateeFont()
		{
			int tipo;
			if (italicT == 0 && boldT == 0)
				tipo = Font.PLAIN;
			else
				tipo = italicT | boldT;

			font = new Font(tipoD, tipo, tamD);
			lblTitulo.setFont(font);
		}
	}
}
