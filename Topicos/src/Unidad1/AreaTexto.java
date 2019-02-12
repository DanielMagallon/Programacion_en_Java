package Unidad1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class AreaTexto extends Applet{
//&
	TextArea txtArea;
	TextField txtRuta = new TextField(80);
	FileDialog dialogo = new FileDialog(new Frame());
	Panel panelBotones = new Panel();
	Panel panelRuta = new Panel();
	
	Label lbl = new Label("ruta://");
	Button btnAbrir,btnSalir,btnSave,btnBorrar;
	
	@Override
	public void init() 
	{
		setLayout(new BorderLayout());
		setSize(900,500);
		
		txtRuta.setEditable(true);
		txtArea = new TextArea("",80,100,TextArea.SCROLLBARS_BOTH);
		add(txtArea,BorderLayout.CENTER);
		
		panelBotones.setLayout(new GridLayout(10, 1,10,10));
		
		btnAbrir = new Button("Abrir");
		btnAbrir.addActionListener(
				
					(a)-> {
						dialogo.setTitle("Seleccione un archivo");
						dialogo.setMode(FileDialog.LOAD);
						dialogo.setVisible(true);
						txtRuta.setText(dialogo.getDirectory()+dialogo.getFile());

						String cont = leer2(txtRuta.getText());
						txtArea.setText(cont);
					}
				
				);
		
		btnBorrar = new Button("Borrar");
		
		btnBorrar.addActionListener(
				
				(a) -> {
					txtArea.setText("");
					txtRuta.setText("");
				}
				
				);
		
		btnSave = new Button("Guardar");
		
		btnSave.addActionListener(
				
					(a) -> {

						if(txtRuta.getText().compareTo("")!=0)
						{
							String contenido = txtArea.getText();
							txtArea.setText("");
							
							
							//Grabar 1)
							try
							{
								FileOutputStream fos = new FileOutputStream(txtRuta.getText());
								
								fos.write(contenido.getBytes());
								System.out.println("Se uardo");
								fos.close();
								txtRuta.setText("");
							}
							catch(IOException e){
								e.printStackTrace();
							}
							
							
							
//							dialogo.setMode(FileDialog.SAVE);
//							dialogo.setTitle("Guardar archivo");
//							dialogo.setVisible(true);
						}
						
						
					}
				
				);
		
		btnSalir = new Button("Salir");
		
		btnSalir.addActionListener(
				
					(a)-> System.exit(0)
				
				);
		
		panelBotones.add(btnAbrir);
		panelBotones.add(btnBorrar);
		panelBotones.add(btnSave);
		panelBotones.add(btnSalir);
		
		add(panelBotones,BorderLayout.WEST);
		
		panelRuta.add(lbl);
		panelRuta.add(txtRuta);
		
		add(panelRuta,BorderLayout.NORTH);
		
	}
	
	private String leer(String ruta)
	{
		String cont="";
		
		try 
		{
			FileInputStream file = new FileInputStream(ruta);
			
			byte[] buffer = new byte[64];
			int numElemLeidos=0;
			
			do
			{
				numElemLeidos = file.read(buffer);
				cont+=new String(buffer,0,numElemLeidos);
			}
			while(numElemLeidos==64);
			
			file.close();
		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(this, "Error de abertura","ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		return cont;
		
	}
	
	private String leer2(String ruta)
	{
		String cont="";
		
		FileReader f;
		
		try
		{
			f = new FileReader(ruta);
			
			BufferedReader b = new BufferedReader(f);
			String c;
			do
			{
				c = b.readLine();
				
				if(c!=null)
					cont+=c+"\n";
				
			}
			while(c!=null);
			
			f.close();
			
		}
		catch(IOException e){
		
		}
		return cont;
	}
}
