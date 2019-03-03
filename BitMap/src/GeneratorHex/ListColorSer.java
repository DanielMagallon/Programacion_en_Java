package GeneratorHex;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JLabel;

public class ListColorSer implements Serializable 
{
	public ArrayList<JLabel> labels;
	
	public ListColorSer() 
	{
		labels = new ArrayList<>();
	}
	
	public void addLabelToLis(JLabel label)
	{
		labels.add(label);
	}
}
