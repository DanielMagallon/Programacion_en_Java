package C4Evaluacion;

public class Ley_Morgan 
{
	public static void main(String[] args) 
	{
		int x=4,y=8,a=9,b=9,g=1,i=5,j=6;
		
		System.out.print (" a) !(x < 5) && !( y >= 7) = ");
		System.out.println( !(x < 5) && !( y >= 7));
		System.out.println("");
		System.out.print ("    !(x < 5 || y>=7) = ");
		System.out.println (!(x < 5 || y>=7));
		System.out.println();
		System.out.print (" a) !(x < 5) && !( y >= 7) = !(x < 5 || y>=7)");
		
		System.out.println();
		System.out.println("---------------------------");;
		System.out.println();
		
		System.out.print (" b) !(a==b) || ! (g!=5) = ");
		System.out.println( !(a==b) || ! (g!=5));
		System.out.println();
		System.out.print ("    ! (a==b || g!=5) = ");
		System.out.println( ! (a==b || g!=5) );
		System.out.println();
		System.out.print (" b) !(a==b) || ! (g!=5) = ! (a==b || g!=5)");
		
		System.out.println();
		System.out.println("---------------------------");;
		System.out.println();
		 
		System.out.print (" c) !(( x<=4) && (y>4)) = ");
		System.out.println( !(( x<=4) && (y>4)) );
		System.out.println();
		System.out.print ("   !((x<=4 || y>4)) =  " );
		System.out.println( !((x<=4 || y>4)));
		System.out.println();
		System.out.print (" c) !(( x<=4) && (y>4)) = !((x<=4 || y>4))");

		System.out.println();
		System.out.println("---------------------------");;
		System.out.println();
		
		System.out.print (" d) !((i>4) || (j<=6)) = ");
		System.out.println( !((i>4) || (j<=6)));
		System.out.println();
		System.out.print ("   !(i>4 && j<=6) = ");
		System.out.println( !(i>4 && j<=6));
		System.out.println();
		System.out.print (" d) !((i>4) || (j<=6)) = !(i>4 && j<=6)");
	}
}
