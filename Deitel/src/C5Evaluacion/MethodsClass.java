package C5Evaluacion;

public class MethodsClass
{
	
	public Account getID(int d) throws NullPointerException{
		return getPIN(d);//.getNull();
	}
	
	public Account getPIN(int id)
	{
		Account c = new Account();
		
		if(c.getAccount() == id)
			return c;
		
		return null;
	}
	
	public static void main(String[] args)
	{
		MethodsClass x = new MethodsClass();
		
		System.out.println(x.getID(0));
	}
}
