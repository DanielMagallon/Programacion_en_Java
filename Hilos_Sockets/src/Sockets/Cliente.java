package Sockets;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Cliente extends JFrame 
{

	private static final long serialVersionUID = 4313668870069110997L;
	JTextField txt; 
	JButton btn;
	Servidor serv = new Servidor();
	static final int PORT = 9999;
	
	
	public Cliente() 
	{
		
		setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 100);
		setLocation(400,100);
		
		serv.setVisible(true);
		
		String labelText ="<html><FONT COLOR=RED>Red</FONT> and <FONT COLOR=BLUE>Blue</FONT> Text</html>";
		add(new JLabel(labelText));
		
		add(txt = new JTextField(10));
		add(btn = new JButton("Enviar"));
		
		addWindowListener(new Cerrar());
		
		btn.addActionListener(
				
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						// TODO Auto-generated method stub{}
						try 
						{
							Socket socket = new Socket(Adress.getAdress(false),PORT);
							DataOutputStream flujoSalida = new DataOutputStream(socket.getOutputStream());
							
							flujoSalida.writeUTF(txt.getText());
							socket.close();
						}
						catch (IOException ex) 
						{
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
					}
				}				
				);
		
		
	}
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			
			@Override
			public void run() {
				new Cliente().setVisible(true);
			}
		});
	}
	
	class Cerrar extends WindowAdapter{
		
		@Override
		public void windowClosing(WindowEvent e) 
		{
//			JOptionPane.showMessageDialog(Cliente.this, "Cerrando");
		}
	}

	
}

