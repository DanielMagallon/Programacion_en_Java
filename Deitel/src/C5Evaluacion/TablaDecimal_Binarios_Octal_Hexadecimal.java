package C5Evaluacion;

import java.util.Scanner;

public class TablaDecimal_Binarios_Octal_Hexadecimal
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.printf ("%15s%20s%20s%20s\n\n","Decimal","Binario","Octal","Hexadecimal");
		
		for (int  dec=1; dec<=256; dec++)
		{
			System.out.printf ("%12d%22.0f%20.0f\n",dec,convertirDecimal_Binario(dec),convertirDecimal_Octal(dec));
		}
		
		
		
	}

	public static double convertirDecimal_Binario (int dec)
	{
		int exp=0, digito;
        double binario=0;

        while(dec!=0)
        {
                digito = dec % 2;            
                binario = binario + digito * Math.pow(10, exp);   
                exp++;
                dec = dec/2;
        }
        
      return  binario;
	}
	
	public static double convertirDecimal_Octal (int dec)
	{
		
		int exp=0, digito;
        double octal=0;

        while(dec!=0)
        {
                digito = dec % 8;            
                octal = octal + digito * Math.pow(10, exp);   
                exp++;
                dec = dec/8;
        }
		
       return octal; 
	}
}
