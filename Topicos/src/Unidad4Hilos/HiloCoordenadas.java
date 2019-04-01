package Unidad4Hilos;

import java.util.List;
import java.util.Random;

import javax.swing.SwingWorker;

public class HiloCoordenadas extends SwingWorker<Void, int[]>
{
	InterfazCuadros ic;
	int x,y,lado;
	
	public HiloCoordenadas(InterfazCuadros i)
	{
		ic = i;
	}
	
	@Override
	protected Void doInBackground() throws Exception
	{
		Random lb = new Random();
		
		while(ic.isVisible())
		{
			int vec[] = {lb.nextInt(ic.getWidth()),lb.nextInt(ic.getHeight()),
					lb.nextInt(50)+50};
			
			publish(vec);
			
			Thread.sleep(200);
		}
		return null;
	}
	
	@Override
	protected void process(List<int[]> chunks)
	{
		int x[] = chunks.get(chunks.size()-1);
		
		ic.area.append(x[0]+","+x[1]+" : "+x[2]+"\n");
		
		ic.cuadros.add(x);
		
		ic.repaint();
	}
}
