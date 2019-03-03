package C8Herencia;

public class ImplicitTest extends Implicit
{
	@Override
	public int emp()
	{
		return super.emp();
		
	}
	
	@Override
	public int fg()
	{
		return super.fg();
	}
	
	public static void main(String[] args)
	{
		//System.out.println(new Implicit().emp());
		Implicit x = new Implicit();
		int l;
		System.out.println(x.emp());
		System.out.println(x.fg());
		
		l=5^5;
		System.out.println(l);
		System.out.println(x);
		System.out.println(x.toString());
	}
}
