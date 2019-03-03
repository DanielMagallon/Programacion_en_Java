package RegularExpresion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validate
{
	private static Pattern pat;
	private static Matcher mat;
	
	public static boolean isValidName(String name)
	{
		return validExpression("^[A-Z][a-z].*", name);
	}
	
	public static boolean isNumber(String number)
	{
		return isIntegerNumber(number) || isDecimalNumber(number);
	}
	
	public static boolean isDecimalNumber(String number)
	{
		return validExpression("[\\d]*[.][\\d]+", number);
		
	}
	
	public static boolean isIntegerNumber(String number)
	{
		return validExpression("[0-9]+", number);
	}
	
	public static boolean isValidDateNumberFormat(String date)
	{
		return validExpression("[\\d]{2}[-|/][\\d]{2}[-|/][\\d]{4}", date);
	}
	
	public static boolean isValidDateMonthFormat(String date)
	{
		String[] monthSpanish={"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
				 "Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		
		String[] monthEnglish={"January","February","March","April","May","June","Julio",
				"August","September","November","December"};
		
		String encontrado="";
		
		for (int i=0; i<monthEnglish.length; i++)
		{
			if ( validExpression(".*"+monthEnglish[i]+".*", date) )
			{
				encontrado=monthEnglish[i];
				break;
			}
			
			else if ( validExpression(".*"+monthSpanish[i]+".*", date) )
			{
				encontrado=monthSpanish[i];
				break;
			}
		}

		
		if(encontrado.equals(""))
			return false;

		return validExpression("[\\d]{2}[-|/]"+encontrado+"[-|/][\\d]{4}", date);
		
	}

	public static boolean isValidDate(String date)
	{
		return isValidDateNumberFormat(date) ||  isValidDateMonthFormat(date);
	}
	
	public static boolean isValidatePhone(String phone)
	{
		return validExpression("[1-9]{3}-[\\d]{3}-[\\d]{2}-[\\d]{2}", phone);
	}

	
	
	private static boolean validExpression(String expresion, String val)
	{
		pat = Pattern.compile(expresion); 
		mat = pat.matcher(val);
		
		return mat.matches();
	}
}
