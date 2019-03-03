package C15Evalucacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SaveFiles extends JFrame
{
	File open;
	JTextArea texto;
	JFileChooser chosser;
	JButton abrirFile;
	
	public SaveFiles()
	{
		init();
		propierties();
		actionButton();
	}
	
	private void init()
	{
		Box box = Box.createHorizontalBox();
		
		texto=new JTextArea(14,20);
		chosser = new JFileChooser();
		abrirFile = new JButton("Guardar Archivo");
		
		box.add(new JScrollPane(texto));
		box.add(abrirFile);
		
		setDefaultCloseOperation(2);
		setSize(250,250);
		
		add(box);
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
				saveFile();
				
			}
		});
	}
	
	private void saveFile()
	{
		chosser.showSaveDialog(this);
		
		open = chosser.getSelectedFile();
		
		try
		{
			FileWriter wr = new FileWriter(open+".txt");
			wr.write(texto.getText());
			wr.close();
		}
		catch (IOException e){}
	}
	
	public static void main(String[] args)
	{
		new SaveFiles().setVisible(true);
	}
}
