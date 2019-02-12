package Unidad3;

import java.util.LinkedList;
import java.util.Queue;


public class Colas
{
	public static void main(String[] args)
	{
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(1);
		queue.offer(5);
		queue.offer(4);
		
		System.out.println(queue);

		queue.remove(5);
		
		System.out.println(queue);
	}
}
