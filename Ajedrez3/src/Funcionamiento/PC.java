package Funcionamiento;

import static Interfaz.TableroAjedrez.estadoAnalisis;

import javax.swing.JOptionPane;

import Abstract.Validaciones;
import Interfaz.CasillaData;
/**
 * https://camster.com/webcam/lailypink/110306#/myBio
 * @author edgar
 *
 */
public class PC 
{
	public void menear()
	{
//		analizar();
	}
	
	private void analizar()
	{
		CasillaData cas;
		Validaciones.estado = estadoAnalisis;
		estadoAnalisis.jackeBlancas.limpiar();
		estadoAnalisis.jackeNegras.limpiar();
		estadoAnalisis.peligroBlancas.limpiar();
		estadoAnalisis.peligroNegras.limpiar();
		
		
	}
}
