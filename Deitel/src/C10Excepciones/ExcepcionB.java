package C10Excepciones;

public class ExcepcionB extends ExcepcionA
{
	int dividir() throws ArithmeticException
	{
		
		return super.getNum1() / super.getNum2();
		
	}
}
