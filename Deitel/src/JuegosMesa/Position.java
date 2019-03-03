package JuegosMesa;

import java.util.ArrayList;
import java.util.List;

public class Position implements ValorOfAll
{
	List<String> position = new ArrayList<>();
	private String newPos;
	long i;
	
	public void addPosition(String pos)
	{
		position.add(pos);
	}
	
	public void deletePositions()
	{
		position.removeAll(position);
	}
	
	public boolean comparePositions()
	{
		newPos = getStringPosition();
		
		for (String pos : position)
		{
			if(newPos.equals(pos))
			{
				return true;
			}
		}
		return false;
	}

}
