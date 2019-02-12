package Partidas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Eventos.Almacena;
import Interfaz.Estaque;
import Interfaz.TableroAjedrez;

public class Mostra implements ActionListener
{
	public Timer timer = new Timer(1500, this);
	
	private Almacena almacena;
	private int index=0, max;
	private Estaque estM, estT;
	
	public Mostra(Almacena alm) 
	{
		almacena=alm;
		max = alm.estaqueM.size();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(index!=max)
		{
			estT = almacena.estaqueT.get(index);
			estM = almacena.estaqueM.get(index);
			
			TableroAjedrez.casillas[estT.fila][estT.columna].setIcon(null);
			TableroAjedrez.casillas[estM.fila][estM.columna].setIcon(almacena.piezas.get(index));
			
			index++;
		}
		else timer.stop();
	}
}
