package JavaSE8;

public class Hilo extends S implements Runnable
{
	
	@Override
	public void run()
	{
		System.out.println("Hola desde el hilo...");
	}

	public static void main(String[] args)
	{
		new Hilo().run();
	}
}
