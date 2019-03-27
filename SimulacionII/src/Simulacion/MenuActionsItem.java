package Simulacion;


import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuActionsItem extends JMenuItem
{
	private static final long serialVersionUID = 390540548858683085L;

	private Method metodo;
	
	public MenuActionsItem(String name, Method action, int letra, int accion)
	{
		super(name);
		setAccelerator(KeyStroke.getKeyStroke(letra,accion));
		this.metodo = action;
	}
	
	
	public void action()
	{
		metodo.ejecutar();
	}
	
	
}
