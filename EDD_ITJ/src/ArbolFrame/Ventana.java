package ArbolFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Unidad4.ArbolBinario;

public class Ventana extends JFrame
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		ArbolBinario arbol = new ArbolBinario();
		
		String datos[] = 
			{
					"50", "70", "30", "25", "45", "85", "90", "60", "55", "17", "09", "33", "71"
//					"D","G","I","Z","A","L","K","C","B","N","Y","R"
//					"h","o","f","t","d","m","b","e","w","g","n",/*"eg"*/ //"i"
//					"70","40","45","35","36","25","17","80"
//					"08","03","10","01","06","14","04","07","13"
//					"n","g","p","r","e","a","d","o","s","b"
			};
			
			
			for(String c : datos)
				arbol.insert(c);
		
		Dibujo dib = new Dibujo();
		dib.dibujaArbol(arbol);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(dib, BorderLayout.CENTER);
	}

}
