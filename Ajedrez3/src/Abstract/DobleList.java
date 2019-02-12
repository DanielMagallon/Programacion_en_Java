package Abstract;

import java.util.ArrayList;

import Interfaz.CasillaData;

public class DobleList 
{
	
	//Esa contiene las piezas que pueden cubrir eljaque
	private ArrayList<CasillaData> casillaAct = new ArrayList<>();
	//Cotiene las CasillaModificables que cubren las piezas
	private ArrayList<CasillaData> casillaOld = new ArrayList<>();
	
	public void addCasillas(CasillaData casAct, CasillaData casOld)
	{
		casillaAct.add(casAct);
		casillaOld.add(casOld);
	}
	
	
	public void clear()
	{
		casillaAct.clear();
		casillaOld.clear();
	}

	
	public CasillaData getCasillaAct(int ind)
	{
		return casillaAct.get(ind);
	}
	
	public CasillaData getCasillaOld(int ind)
	{
		return casillaOld.get(ind);
	}
	
	public int size()
	{
		return casillaAct.size();
	}
	
	public StringBuilder mostrar(String hace)
	{
		StringBuilder cad = new StringBuilder();
		
		for (int i=0; i<casillaAct.size(); i++)
		{
			cad.append(casillaAct.get(i)).append(hace).append(casillaOld.get(i)+"\n");
		}
		
		return cad;
	}
	
	
}
