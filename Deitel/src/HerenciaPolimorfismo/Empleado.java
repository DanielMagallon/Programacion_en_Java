package HerenciaPolimorfismo;

import javax.swing.JOptionPane;

public class Empleado extends Persona implements Enfermo
{
	double sueldo;
	String telefono;
	String direccion;

	public Empleado(String name, int age, double sueldo, String tel, String dir)
	{
		super(name, age);
		this.sueldo=sueldo;
		telefono=tel;
		direccion=dir;
	}
	
	@Override
	public void verDatos()
	{
		JOptionPane.showMessageDialog(null, String.format("Nombre: %s\nEdad: %d"
				+ "\nSueldo: %.2f\nTelefono %s\nDireccion: %s"
				,nombre,edad,sueldo,telefono,direccion));
	}

	@Override
	public void tos()
	{
		JOptionPane.showMessageDialog(null, "Hola, estoy enfermo de tos. Cof cof");
	}

	@Override
	public void diarrea()
	{
		JOptionPane.showMessageDialog(null, "Hola, estoy enfermo del estomago :c");
	}
	
	
}
