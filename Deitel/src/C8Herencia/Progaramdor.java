package C8Herencia;

public class Progaramdor extends Empleado_Internet
{
	int lineasCodigoXh;
	String lenguaje;
	
	public Progaramdor(String nombre,String cedula,int edad,boolean casado,double salario,
			int lineasCodigoXh,String lenguaje)
	{
		// TODO Auto-generated constructor stub
		
		// Se uso super, para referirse a los atributos de la clase padre
		
		super.nombre=nombre;
		super.cedula=cedula;
		super.edad=edad;
		super.casado=casado;
		super.salario=salario;
		this.lineasCodigoXh=lineasCodigoXh;
		this.lenguaje=lenguaje;
	}
}
