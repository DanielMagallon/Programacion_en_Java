package HerenciaPolimorfismo;

public class EmpleadoApp
{
	public static void main(String[] args)
	{
		Empleado emp1 = new Empleado("Edgar", 17, 4000, "353-100-04-62","Felix Ireta #365");
		
		emp1.verDatos();
		emp1.tos();
		emp1.diarrea();
	}
}
