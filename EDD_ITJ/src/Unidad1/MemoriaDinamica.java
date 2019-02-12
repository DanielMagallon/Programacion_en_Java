package Unidad1;

public class MemoriaDinamica {

	static int vec[] = {1,2,3,4,5};
	static int pos;
	
	static void agregarNuevo(int num)
	{
		pos = vec.length;
		
		int temp[] = new int[pos+1];
		
		for(int i=0; i<vec.length; i++)
			temp[i] = vec[i];
		
		temp[pos] = num;
		
		vec = temp;
	}
	
	static void mostrar()
	{
		for(int l : vec)
			System.out.print(l+" ");
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		mostrar();
		agregarNuevo(6);
		mostrar();
		agregarNuevo(7);
		mostrar();
		
//		int pos=5;
//		int num=6;
//		int vec[] = {1,2,3,4,5};
//		
//		try
//		{
//			vec[pos] = num;
//		}
//		catch(ArrayIndexOutOfBoundsException e)
//		{
//			int temp[] = new int[vec.length+1];
//			
//			for(int i=0; i<vec.length; i++)
//				temp[i] = vec[i];
//			
//			temp[pos] = num;
//			
//			vec = temp;
//		}
//		
//		for(int ele : vec)
//			System.out.print (ele+" ");
	}
}
