package Discretas;

public class Evaluar {

	public static boolean tabla[][] =
			{ 
					{true,true,true},
					{true,true,false},
					{true,false,true},
					{true,false,false},
					{false,true,true},
					{false,true,false},
					{false,false,true},
					{false,false,false}
		
			};

	public static boolean tabla2[][] =
		{ 
				{true,true},
				{true,false},
				{false,true},
				{false,false},
	
		};
	
	public static void evaluar()
	{
		boolean p,q,r, val;
		
		for(int i=0; i<tabla2.length; i++)
		{
			p = tabla2[i][0];
			q = tabla2[i][1];
//			r = tabla2[i][2];
			
			//val = ( (p&&q) || (p&&r) ) && ( (p||!r) && (p&&!q) );
			//val = ((p&&q) || (p&&r)) && (p&&!p) && false;
			val = ((p&&q) || !p) && false;
			System.out.println(val);
		}
	}
	
	public static void main(String[] args) {
		evaluar();
	}
}
