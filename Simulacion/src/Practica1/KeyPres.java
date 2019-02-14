package Practica1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyPres extends KeyAdapter{

		private Ejecutable f;
		
		public KeyPres(Ejecutable fe) 
		{
			f = fe;
		}
	
		@Override
		public void keyPressed(KeyEvent e) 
		{
			if(e.getKeyCode() == KeyEvent.VK_DELETE)
				f.borrarDatos();
			
		}
	
	}