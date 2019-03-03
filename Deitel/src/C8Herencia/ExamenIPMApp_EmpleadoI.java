package C8Herencia;

public class ExamenIPMApp_EmpleadoI
{
	public static void main(String[] args)
	{
		Progaramdor pr = new Progaramdor(
				"Edgar","3456",20,false,1000,123,"Java");
		
		pr.aumentarSalario(0.25);
		pr.imprimirEmpleado();
	}
}
