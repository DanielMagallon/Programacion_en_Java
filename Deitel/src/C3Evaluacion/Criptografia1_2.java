package C3Evaluacion;

import java.util.Scanner;


public class Criptografia1_2 
{
	Criptografia1 cp = new Criptografia1 (0,0);
	
	public void Desencriptarnum ()
	{
		
		System.out.printf (" Su clave encriptada fue: %d",cp.Obtenerentero());

		int dig1,dig2,dig3,dig4,temp1,temp2,num;
		
		dig1=cp.Obtenerentero()/1000;
		
		dig2=cp.Obtenerentero()%1000;
		dig2=dig2/100;
	
		dig3=cp.Obtenerentero()%100;
		dig3=dig3/10;
	
		dig4=cp.Obtenerentero()%10;
		dig4=dig4/1;
	
		
		temp1=dig1;
		dig1=dig3;
		dig3=temp1;
		
		temp2=dig2;
		dig2=dig4;
		dig4=temp2;
		
		
		dig1=(dig1+10-7);
		dig1=dig1%10;
	
		dig2=(dig2+10-7);
		dig2=dig2%10;
	
		dig3=(dig3+10-7);
		dig3=dig3%10;
	
		dig4=(dig4+10-7);
		dig4=dig4%10;
		

		System.out.println();

		num = (dig4*1) + (dig3*10) + (dig2*100) + (dig1*1000);
		
		System.out.printf (" Su clave desencriptada fue: %d",num);
	}	

	public static void main(String[] args) 
	{
		Criptografia1_2 p = new Criptografia1_2();
		p.Desencriptarnum();
	}
}
 