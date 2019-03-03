package C14RegularExpresion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
	public static void main(String[] args)
	{
		Pattern expression = Pattern.compile("J.*\\d[0-35-9]-\\d\\d-\\d\\d");
		
		String s1 = "Jane's Birthday is 05-12-75\n"+
					"Dave's Birthday is 11-04-68\n"+
					"John's Birthday is 04-28-73\n"+
					"Joe's Birthday is 12-17-77\n";
		
		Matcher matches = expression.matcher(s1);
		
		while(matches.find())
			System.out.println(matches.group());
		
	}
}
