package C3Evaluacion;

import java.util.Scanner;

public class Decimal_Binario 
{
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);	
		int binario;
		
		System.out.print (" Dame un numero binario: ");
		binario=input.nextInt();
		
		System.out.println();
		System.out.printf (" El numero decimal del binario %d es: %d",binario,convertirBinarioADecimal(binario));
		
		
		System.out.print ("\n\n Introduce un numero decimal: ");
		int decimal=input.nextInt();
		
		System.out.println();
		
		System.out.printf (" El equivalente binario del decimal %d es: ",decimal);
		convertirDecimal_Binario(decimal);
		
		System.out.println();
		
		System.out.printf (" El equivalente octal del decimal %d es: ",decimal);
		convertirDecimal_Octal(decimal);
		
		System.out.println();
		
		System.out.printf (" El equivalente hexadecimal del decimal %d es: ",decimal);
		convertirDecimal_Hexadecimal(decimal);
	}
	
	public static int convertirBinarioADecimal (int binario)
	{
	
		int num,resnum;
		int base=1;
		int decimal;
		int total=0;
		
		while (binario != 0)
		{
			resnum=binario;
			binario %= 10;
			num=binario;
		
			if (num>=2)
			{
				System.out.printf (" Error. El numero introducido no pertenece a los numeros binarios.\n"
						+ " El error esta en el numero %d",num);
				System.exit(0);
			}
			
			
			decimal=num*base;
			total += decimal;
			base *= 2;
			binario = resnum/10; 
		}
		
		return total;
	}
	
	public static void convertirDecimal_Binario (int decimal)
	{
		int exp=0, digito;
        double binario=0;

        while(decimal!=0)
        {
                digito = decimal % 2;            
                binario = binario + digito * Math.pow(10, exp);   
                exp++;
                decimal = decimal/2;
        }
        
        System.out.printf("%.0f", binario); 
        
        
        
		/*int base;
		int binario;
		int ultimatebase=0;
		
		 for (base=1;  base<=decimal; base *= 2)
		{
			ultimatebase=base;
		}
		
		while (decimal != 0)
		{
			binario=decimal/ultimatebase;
			System.out.printf ("%d",binario);
			decimal %= ultimatebase;
			ultimatebase /= 2;
		}*/
		
	}
	
	public static void convertirDecimal_Octal (int decimal)
	{
		
		int exp=0, digito;
        double octal=0;

        while(decimal!=0)
        {
                digito = decimal % 8;            
                octal = octal + digito * Math.pow(10, exp);   
                exp++;
                decimal = decimal/8;
        }
		
        System.out.printf("%.0f", octal); 
        
		/*int base;
		int octal;
		int ultimatebase=0;
		
		for (base=1;  base<=decimal; base *= 8)
		{
			ultimatebase=base;
		}
		
		while (decimal != 0)
		{
			octal=decimal/ultimatebase;
			System.out.printf ("%d",octal);
			
			decimal %= ultimatebase;
			ultimatebase /= 8;
		} */
	}
	
	public static void convertirDecimal_Hexadecimal (int decimal)
	{
		

		int exp=0, digito;
        double hexadecimal=0;

        while(decimal!=0)
        {
                digito = decimal % 16;            
                hexadecimal = hexadecimal + digito * Math.pow(10, exp);   
               
                if (hexadecimal==10)
                {
                	System.out.print ("A");
                }
                exp++;
                decimal = decimal/16;
        }
		
        System.out.printf("%.0f",  hexadecimal); 
		
		/*int base;
		int Hexadecimal;
		int ultimatebase=0;
		
		for (base=1;  base<=decimal; base *= 16)
		{
			ultimatebase=base;
		}
		
		while (decimal != 0)
		{
			Hexadecimal=decimal/ultimatebase;
			System.out.printf ("%d",Hexadecimal);
			
			decimal %= ultimatebase;
			ultimatebase /= 16;
		} */
	}
}

