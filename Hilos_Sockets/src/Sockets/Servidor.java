package Sockets;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Servidor extends JFrame implements Runnable
{
	JTextArea txtA;
	JMenuBar mBar;
	Thread hilo = new Thread(this);
	
//	ServerSocket server; 
	
//	Socket  sockert;
	
//	DataInputStream flujoEntrada; 
	
	
	public Servidor() 
	{
		setLayout(new BorderLayout());
		setSize(200, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new JScrollPane(txtA = new JTextArea()),"Center");
		
		
		setJMenuBar(mBar = new JMenuBar());
		JMenu menu;
		mBar.add(menu = new JMenu("Hilo"));
		JMenuItem mi;
		menu.add(mi = new JMenuItem("Esta corriendo? "));
		mi.addActionListener(
				
				(a)-> {
					System.out.println(hilo.isAlive());
				}
				
				);
		
		
		
		hilo.start();
		
		
	}
	

	
	@Override
	public void run() 
	{
		try 
		{	
			ServerSocket server = new ServerSocket(Cliente.PORT);
			
			while(true)
			{
				
				Socket sockert = server.accept();
				
				DataInputStream flujoEntrada = new DataInputStream(sockert.getInputStream());
			
				String msg = flujoEntrada.readUTF();
				
				txtA.append("\n"+msg);
				
				sockert.close();
					
			}
			
		}
		catch (IOException e) 
				{
					e.printStackTrace();
			
				}
		
	}

}
