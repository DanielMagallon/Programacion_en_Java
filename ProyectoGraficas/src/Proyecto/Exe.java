package Proyecto;


import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Exe
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(

				() -> create(args)

		);
	}

	private static void create(String args[])
	{
		if (args.length == 0)
		{
			System.out.println("Abriendo aplicion natal");

			PathGeneral.getInstance((a,b) -> 
			{
				try
				{
					new Appi(a,b);
				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "Ha ocurrudo un error " + e.getMessage());
					e.printStackTrace();
				}
			});
		} else
		{
			System.out.println("Abriendo aplicacion desde el archivo: " + args[0]);

			PathGeneral.getInstance((a,b) -> 
			{
				try
				{
					new Appi(a,args[0],b);
				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "Ha ocurrudo un error " + e.getMessage());
					e.printStackTrace();
				}
			});
		}
	}
}
