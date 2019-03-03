package C16Recursion;

public class TowersOfHanoi
{
	public static void solveTowers(int disks, int sourcePeg, int destinationPeg,
			int tempPeg)
	{
			if(disks==1)
			{
				System.out.printf( "\n%d --> %d", sourcePeg, destinationPeg );
				return;
			}
			//   3     1    3   2
			
			solveTowers(disks-1, sourcePeg, tempPeg, destinationPeg);
			
			System.out.printf( "\n%d --> %d", sourcePeg, destinationPeg );
			
			solveTowers( disks - 1, tempPeg, destinationPeg, sourcePeg );
	}
	
	public static void main(String[] args)
	{
		int startPeg=1;
		int endPeg=3;
		int tempPeg=2;
		int totalDisks=10;
		
		//				3         1 		3		2
		solveTowers(totalDisks, startPeg, endPeg, tempPeg);
		
	}
}
