package UnidadII;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

import StringOperator.Operator;

public class Interfaz extends JFrame implements ActionListener
{
	JTextPane edPane = new JTextPane();
//	JEditorPane edPane = new JEditorPane();
	JToolBar toolB = new JToolBar(JToolBar.HORIZONTAL);
	String toolText[] = { "Concatenar cadena", "Crear nueva cadena", "Mostrar vocales", "Mostrar Consonantes",
			"Subcadenas", "Inversa" };

	Operator cadenaOper;

	JLabel lblTam = new JLabel("Tamaño: 0");
	JTextField txt = new JTextField(10);

	Image imgs[] = {
			new ImageIcon(getClass().getResource("/UnidadII/InterfazRec/concater.jpg")).getImage().getScaledInstance(32,
					32, Image.SCALE_SMOOTH),

			new ImageIcon(getClass().getResource("/UnidadII/InterfazRec/nuevo.png")).getImage().getScaledInstance(32,
					32, Image.SCALE_SMOOTH),

			new ImageIcon(getClass().getResource("/UnidadII/InterfazRec/vocales.jpg")).getImage().getScaledInstance(32,
					32, Image.SCALE_SMOOTH),

			new ImageIcon(getClass().getResource("/UnidadII/InterfazRec/conso.jpg")).getImage().getScaledInstance(32,
					32, Image.SCALE_SMOOTH),

			new ImageIcon(getClass().getResource("/UnidadII/InterfazRec/subc.png")).getImage().getScaledInstance(32, 32,
					Image.SCALE_SMOOTH),

			new ImageIcon(getClass().getResource("/UnidadII/InterfazRec/inv.png")).getImage().getScaledInstance(32, 32,
					Image.SCALE_SMOOTH)

	};
	JButton[] btns = new JButton[7];

	public Interfaz()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);

		setLayout(new BorderLayout());

		cadenaOper = new Operator("");

		JScrollPane sc = new JScrollPane(edPane);

		JPanel c = new JPanel();
		{
			c.setLayout(new BorderLayout());
			sc.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
					"Introduzca aqui el texto que desee"));
			c.add(sc);
			add(sc, "Center");
		}

		add(toolB, "North");
		edPane.setContentType("text/html");
		// edPane.setText("<b> Hola");

		for (int i = 0; i < imgs.length; i++)
		{
			btns[i] = new JButton(new ImageIcon(imgs[i]));
			btns[i].setToolTipText(toolText[i]);
			btns[i].addActionListener(this);
			toolB.add(btns[i]);
		}

		JPanel ab = new JPanel();

		{
			ab.add(new JLabel("Escriba aqui el texto para la accion a realizar: "));
			ab.add(txt);
			ab.add(lblTam);
		}

		add(ab, "South");
		

		edPane.setEditable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btns[0])
		{
			cadenaOper.concatenar(txt.getText());
			edPane.setText(cadenaOper.toString());
		}

		else if (e.getSource() == btns[1])
		{
			cadenaOper.asignar(txt.getText());
			edPane.setText(cadenaOper.toString());
		}

		else if (e.getSource() == btns[2])
		{
			Object[] x = cadenaOper.vocales().toArray();

			String cadena = cadenaOper.obtenerCadena() + "<br>";

			for (int i = 0, ind = 0; i < cadenaOper.longitud(); i++)
			{

				if (ind != x.length && (int) x[ind] == i)
				{
					cadena += formato(cadenaOper.obtenerCadena().charAt(i) + "", "red");
					ind++;
				} else
					cadena += cadenaOper.obtenerCadena().charAt(i);
			}

			edPane.setText(cadena);
		}

		else if (e.getSource() == btns[3])
		{
			String cad = cadenaOper.obtenerCadena() + "<br>";

			String cns = cadenaOper.consonantes();

			cad += formato(cns, "blue");

			edPane.setText(cad);
		}

		else if (e.getSource() == btns[4])
		{
			String cad = cadenaOper.obtenerCadena() + "<br>";
			String txto = txt.getText();

			int sizeSub = txto.length();

			Object[] x = cadenaOper.subcadenas(txto).toArray();

			for (int i = 0, ind = 0; i < cadenaOper.longitud(); i++)
			{
				if (ind != x.length && (int) x[ind] == i)
				{
					cad += formato(cadenaOper.obtenerCadena().substring(i, i + sizeSub), "green");
					ind++;
				} else
					cad += cadenaOper.obtenerCadena().charAt(i);
			}

			edPane.setText(cad);
		}

		else
		{

			String cad = cadenaOper.obtenerCadena() + "<br>" + formato(cadenaOper.inversa(), "yellow");

			edPane.setText(cad);

		}

		lblTam.setText("Tamaño: " + cadenaOper.longitud());
	}

	
	private String formato(String c, String color)
	{
		String forma = "<b>  <font color=\"" + color + "\">" + c + "</font> </b>";

		return forma;
	}

	public static void main(String[] args)
	{
		try
		{
			new Interfaz().setVisible(true);
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Se ha producido un error");
		}
	}

	/*
	 * 
	 */
}
