package C15Evalucacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class OpenFiles extends JFrame
{
	File open;
	JTextArea texto;
	JFileChooser chosser;
	JButton abrirFile;
	JPanel centro, sur;
	
	public OpenFiles()
	{
		init();
		propierties();
		actionButton();
	}
	
	private void init()
	{
		setLayout(new BorderLayout());
		
	    centro = new JPanel();
		sur  = new JPanel();
		texto=new JTextArea(14,20);
		chosser = new JFileChooser();
		abrirFile = new JButton("Abrir Archivo");
		
		
		centro.add(new JScrollPane(texto));

		sur.setLayout(new GridLayout(1,3));
		sur.add(new JPanel());
		sur.add(abrirFile);
		sur.add(new JPanel());
		
		//add(new JPanel(), BorderLayout.NORTH);
		add(centro, BorderLayout.CENTER);
		add(sur, BorderLayout.SOUTH);
	}
	
	private void propierties()
	{
		texto.setLineWrap(true);
		texto.setWrapStyleWord(true);
	}
	
	private void actionButton()
	{
		abrirFile.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				texto.setText(openNewFile());
				
			}
		});
	}
	
	private String openNewFile()
	{
		chosser.showOpenDialog(this);
		
		open = chosser.getSelectedFile();
		
		String letra="", aux;
		
		try
		{
			FileReader lector = new FileReader(open);
			BufferedReader br = new BufferedReader(lector); 
			
			while(true)
			{
				aux = br.readLine();
				
				if(aux!=null)
					letra+=aux+"\n";
				
				else break;
			}
			
			lector.close();
			br.close();
			
			return letra;
		}
		catch (IOException e){}
		
		return null;
	}
}
