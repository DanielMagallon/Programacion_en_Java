package Aplication;

import javax.swing.JToggleButton;

public interface ValorOfAll
{
	default int getFilaOfToogle(JToggleButton to)
	{
		return Integer.parseInt(to.getName())/10;
	}
	
	default int getColumnOfToogle(JToggleButton to)
	{
		return Integer.parseInt(to.getName())%10;
	}
	
	default boolean isOfPlayer1(JToggleButton tog)
	{
		if(tog.getIcon() == null)
			return false;
		
		String icon = tog.getIcon().toString();
		
		for (String p : AjedrezToggle.piezasPrinc )
		{
			if(icon.contains(p+"1.png") || icon.contains("peon0.png"))
				return true;
		}
		
		return false;
	}
	
	default boolean isOfPlayer2(JToggleButton tog)
	{
		if(tog.getIcon() == null)
			return false;
		
		String icon = tog.getIcon().toString();
		
		for (String p :AjedrezToggle.piezasPrinc )
		{
			if(icon.contains(p+"2.png") || icon.contains("peonYell0.png"))
				return true;
		}
		return false;
	}
	
	default String getRouteIcon()
	{
	  return AjedrezToggle.togNew.getIcon().toString();
	}
}
