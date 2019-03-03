package C8Herencia;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class D3moLabel
{
	public static void main(String[] args)
	{
		// crea una etiqueta con texto solmante
		JLabel etiquetaNorte = new JLabel("Norte");
		etiquetaNorte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 2, 2)));
		
		// crea un icono a partir de una imagen 
		ImageIcon etiquetaIcono = new ImageIcon("Un.jpg");
		
		// crea una etiqueta con u icono en vez de texto
		JLabel etiquetaCentro = new JLabel(etiquetaIcono);
		
		//crea otra etiqute con un icono
		JLabel etiquetaSur = new JLabel(etiquetaIcono);
		etiquetaSur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 2, 2)));
		// establece la etiqueta para mostrar texto
		etiquetaSur.setText("Sur");
		
		// crea un marco
		JFrame aplicacion = new JFrame();
		
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicacion.add(etiquetaNorte,BorderLayout.NORTH);
		aplicacion.add(etiquetaCentro,BorderLayout.CENTER);
		aplicacion.add(etiquetaSur,BorderLayout.SOUTH);
		
		aplicacion.setSize(300,300);
		aplicacion.setVisible(true);
	}
}
