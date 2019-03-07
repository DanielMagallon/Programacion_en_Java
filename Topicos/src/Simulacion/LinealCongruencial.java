package Simulacion;

public class LinealCongruencial 
{
	private double mult,division,residuo,xind,ri;
	
	
	public  void calcular(double a, double x, double c,double mod)
	{
		mult = (a * x)+c;
		
		System.out.println("Mult: "+mult);
		
		division = mult/mod;
		
		residuo = division-(int) division;
		
		xind = residuo * mod;
				
		ri = xind/(mod-1);
		
		System.out.println("Res: "+division);
		System.out.println("REsidud; "+residuo);
		System.out.println("Xind: "+xind);
		System.out.println("Rind: "+ri);
	}
	
	public static void main(String[] args) {
		
		new LinealCongruencial().calcular(13, 6, 7, 8);
	}
}
