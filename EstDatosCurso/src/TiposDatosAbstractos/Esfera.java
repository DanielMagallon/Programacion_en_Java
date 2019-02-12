package TiposDatosAbstractos;

public class Esfera 
{
	private double radio;
	
	public Esfera(double radio)
	{
		if (radio>0)
			this.radio=radio;
		
		else
			this.radio=0;
	}
	
	// Creamos los meotod u operacion del TDAEsfera
	
	void setRadio(double rad)
	{
		radio=rad;
	}
	
	double getRadio()
	{
		return radio;
	}
	
	double getDiametro()
	{
		return (radio*2);
	}
	
	double getCircunferencia()
	{
		return (Math.PI*(getDiametro()));
	}
	
	double getArea()
	{
		return (4*Math.PI * (getRadio()*getRadio()));
	}
	
	double getVolumen()
	{
		return (4*Math.PI * (Math.pow(getRadio(), 3)))/3;
	}
}
