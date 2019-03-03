package FuerzaBruta;

public class Password
{
	public static void main(String[] args)
	{
		String[] arr1 = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r",
						"s","t","u","v","w","x","y","z"};
		
		int size=arr1.length;
		String pass;
		int vez=0;
		
		
		
		scan:
		{
			for (int i=0; i<size; i++)
			{
				for (int j=0; j<size; j++)
				{
					for (int k=0; k<size; k++)
					{
						for (int m=0; m<size; m++)
						{
							for (int n=0; n<size; n++)
							{
								for (int o=0; o<size; o++)
								{
									for (int p=0; p<size; p++)
									{
										for (int q=0; q<size; q++)
										{
											for (int r=0; r<size; r++)
											{
												pass = arr1[i]+arr1[j]+arr1[k]+arr1[m]+arr1[n]+arr1[o]
													   +arr1[p]+arr1[q]+arr1[r];
												
												if(pass.equals("aaaaaaaad"))
												{
													System.out.println("Pass: "+pass);
													System.out.println("Se ha encontrado la contraseña");
													System.out.println(vez);
													break scan;
												}
												else
												{
													vez++;
													//System.out.println("No coincide");
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
