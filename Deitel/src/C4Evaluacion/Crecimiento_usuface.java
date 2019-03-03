package C4Evaluacion;

public class Crecimiento_usuface 
{	
	public static void main(String[] args) 
	{
		int mes=1,resmes=0,resmes2=0;
		boolean bandera=false,bandera2=false;
		int usuarios;
		
		System.out.printf (" %20s%38s\n","Mes"," Usuarios de Facebook");
		System.out.println();
		
		for (usuarios=500; usuarios<=2500; usuarios += (usuarios *.05))
		{
				System.out.printf ("%20d%25d millones \n",mes,usuarios);
				
			
				if (bandera==false)
				{
					if (usuarios>=1000)
					{
						resmes=mes;
					    bandera=true;
					}
				}
				
				if (bandera2==false)
				{
					if (usuarios>=2000)
					{
						resmes2=mes;
					    bandera2=true;
					}
				}
				
				mes++;
		}
		
		System.out.println();
		System.out.printf (" Facebook tardara %d meses en subir su base de usuarios a 1000 millones",resmes);
		System.out.println("\n");
		System.out.printf (" Facebook tardara %d meses en subir su base de usuarios a 2000 millones",resmes2);
	}
}
