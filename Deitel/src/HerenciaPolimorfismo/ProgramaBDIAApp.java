package HerenciaPolimorfismo;

import javax.swing.JOptionPane;

public class ProgramaBDIAApp
{
	public static void main(String[] args)
	{
		Programador p1 = new Programador();
		Analizta an1 = new Analizta();
		AdministradorBD ad1 = new AdministradorBD();
		
		JOptionPane.showMessageDialog(null, "Aqui Comienza el Polimorfismo Overload");
		p1.datos("Edgar","Magallon");
		p1.sueldo(5, 1500);
		p1.labores("programar en Java");
		
		an1.datos("Alfonso","Villanueva","Lazaro #525");
		an1.sueldo(9, 3500, 500);
		an1.labores("progrmar y analizar paginas Web",10);
		
		ad1.datos("Luis");
		ad1.sueldo(4000);
		ad1.labores("administrar bases de datos");
		
		ProgramadorOverride p2 = new ProgramadorOverride();
		AnaliztaOverride an2 = new AnaliztaOverride();
		AdministradorOverride ad2 = new AdministradorOverride();
		
		JOptionPane.showMessageDialog(null, "Aqui Comienza el Polimorfismo Override");

		p2.datos("Yeo");
		p2.sueldo(1500);
		p2.labores("programar en Java");
		
		an2.datos("Alfonso");
		an2.sueldo(3500);
		an2.labores("diseñae y analizar paginas Web");
		
		ad2.datos("Luis");
		ad2.sueldo(4000);
		ad2.labores("administrar bases de datos");
	}
}
