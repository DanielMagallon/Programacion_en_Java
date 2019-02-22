package Sockets;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Adress 
{
//	public static void address()
//	{
//		try
//		{
//			InetAddress address = InetAddress.getLocalHost();
//			System.out.println("IP local: "+address.getHostAddress());
//			
//			String domain="www.facebook.com";
//			InetAddress ad2 = InetAddress.getByName(domain);
//			
//			byte IP[] = ad2.getAddress();
//			
//			System.out.println("Ip del dom: "+ad2.getHostAddress());
//			for (int index = 0; index < IP.length; index++)
//	        {
//	           if (index > 0)
//	                 System.out.print(".");
//	           System.out.print(((int)IP[index])& 0xff);
//	        }
//		}
//		catch(java.net.UnknownHostException e)
//		{
//			e.printStackTrace();
//		}
//	}
	
	public static String getAdress(boolean mostrar)
	{
		try
		{
			InetAddress address = InetAddress.getLocalHost();
			
			if(mostrar)
				JOptionPane.showMessageDialog(null, "Adres: "+address.getHostAddress());
			
			return address.getHostAddress();
		}
		catch(UnknownHostException e)
		{
			return null;
		}
		
	}
}
