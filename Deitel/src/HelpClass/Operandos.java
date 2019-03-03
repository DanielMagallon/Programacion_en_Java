package HelpClass;

public class Operandos
{
	public static void main(String[] args)
	{
		
		int l = 0b001111;
		
		System.out.println(l);
		
		l= l<<2; //28
		
		System.out.println(l);
		
		l=15>>2;
		
		System.out.println(l);
		
		System.out.println(132 & 144);
		
		Operandos x = new Operandos();
		
		System.out.println(x.toThis());
		Operandos ini = x;
		
		System.out.println(ini.toThis());
	}
	
	public Operandos toThis()
	{
	
		e : 
		{
			System.out.println("Hola This");
			break e;
		}
	
		return this;
	}
}
