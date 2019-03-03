package C15Files;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PersonMain implements ActionListener
{
	JButton btn = new JButton("G");
	JButton btnL = new JButton("R");
	
	public static void ser()
	{

		/*myFile = new File("OBJETOS"); //Crea el archivo
		
		objPersona = new Persona("Luis","Magallon",16);
		objPersona2 = new Persona("Daniel","Magallon",21);
		
		vector.add(objPersona);
		vector.add(objPersona2);
		
		try
		{
			oos = new ObjectOutputStream(new FileOutputStream(myFile));
			oos.writeObject(vector);
			oos.close();
		}
		catch (IOException io)
		{
			System.err.println("Error");
		}*/
		
	}
	File myFile;
	//Persona objAux;
	//Persona objPersona2;
	//Vector vector = new Vector();
	ObjectOutputStream oos;
	ObjectInputStream ois;
	PanelSeriazable objPane;
	
	public PersonMain(boolean isSEr)
	{
		if(!isSEr)
		{
			objPane = new PanelSeriazable();
		}
		else
		{
			myFile = new File("Paneles");
			try
			{
				ois = new ObjectInputStream(new FileInputStream(myFile));
				objPane = (PanelSeriazable)ois.readObject();
			}
			catch (ClassNotFoundException | IOException ex){
				System.err.println("Error"+ex.getMessage());
			}
		}
		
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.add(btn, BorderLayout.NORTH);
		frame.add(btnL, BorderLayout.SOUTH);
		btn.addActionListener(this);
		btnL.addActionListener(this);
		frame.add(objPane, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(2);
		frame.setSize(500, 500);
	}
	
	public static void deserealizar(boolean ser, String name, String apel, String n2, String p2)
	{
		File myFile;
		Persona objPersona;
		Persona objAux;
		Persona objPersona2;
		Vector vector = new Vector();
		ObjectOutputStream oos;
		ObjectInputStream ois;
		myFile = new File("OBJETOS");
		
		try
		{
			ois = new ObjectInputStream(new FileInputStream(myFile));
			vector = (Vector) ois.readObject();
		}
		catch (ClassNotFoundException | IOException | ArrayIndexOutOfBoundsException e){
			System.err.println("Error");
		}
		
		System.out.println("El vector tiene tamaño: "+vector.size());
		
		for (int i=0; i<vector.size(); i++)
		{
			objAux = (Persona) vector.get(i);
			System.out.println("La persona: "+(i+1)+"es "+objAux.getNombre()+" "+objAux.getApellido());
		}
		
		if(ser)
		{
			objPersona = new Persona(name,apel,16);
			objPersona2 = new Persona(n2,p2,21);
			
			vector.add(objPersona);
			vector.add(objPersona2);
			
			try
			{
				oos = new ObjectOutputStream(new FileOutputStream(myFile));
				oos.writeObject(vector);
				oos.close();
			}
			catch (IOException io)
			{
				System.err.println("Error");
			}
		}
	}
	
	public static void main(String[] args)
	{
		//deserealizar(false,"Valey", "Alavres","Y ", " y ya");
		
		new PersonMain(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnL)
		{
			myFile = new File("Paneles");
			try
			{
				ois = new ObjectInputStream(new FileInputStream(myFile));
				objPane = (PanelSeriazable)ois.readObject();
			}
			catch (ClassNotFoundException | IOException ex){
				System.err.println("Error");
			}
		}
		if(e.getSource() == btn)
		{
			myFile = new File("Paneles");
			
			try
			{
				oos = new ObjectOutputStream(new FileOutputStream(myFile));
				oos.writeObject(objPane);
				oos.close();
			}
			catch (IOException io)
			{
				System.err.println("Error");
			}
		}
		
	}
}

