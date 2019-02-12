package ProyectoColasU3;

import java.awt.Graphics;

import javax.swing.JOptionPane;

public class ColaEstudiantes
{
	private Estudiante alumnos[];
	private int pos, problemPriority;
	private String nombre;
	
	public ColaEstudiantes(int size)
	{
		alumnos = new Estudiante[size];
		pos=-1;
	}
	
	/**
	 * 
	 * @param nombre: El nombre del alumno 
	 * @param problem El defecto del alumno-> 1 para embarazada, 2 para dispacitado, >=3 || <=0 para persona normal
	 */
	
	public void addAlumn(String nombre, int problem)
	{
		if(pos!=alumnos.length-1)
		{
			this.nombre = nombre;
			
			problemPriority = problem;
			
			System.out.println("-----------------------------------------------------------\n");
			System.out.println("Llego a la cola: "+nombre+" -> "+Estudiante.getDefecto(problem));
			//Si esta vacia o el defecto es >=3 o <=0(que es persona normal) agrega el nuevo 
			//alumno en la posicion del arreglo (pos+1). En este caso, al final siempre
			if(pos==-1)
			{
				if(prioridadNormal())
					problem=3;
				
				alumnos[++pos] = new Estudiante(nombre, problem);
				agregado(pos);
			}
			else if(prioridadNormal())
			{
				alumnos[++pos] = new Estudiante(nombre, 3);
				agregado(pos);
			}
			
			//Si el defecto es 1 o 2, checa en el arreglo los elementos que hay y determina donde poner el sig alumno
			else checaPrioridad();
			 
			
		}
		else 
			JOptionPane.showMessageDialog(null, "La cola esta llena","ERROR",JOptionPane.ERROR_MESSAGE);
			
	}
	
	public boolean prioridadNormal()
	{
		return problemPriority<=0 || problemPriority>=3;
	}
	
	private void checaPrioridad()
	{
			int ind=0;
			
			while(alumnos[ind]!=null && !(problemPriority<alumnos[ind].getPriority()))
				ind++;
			
			for(int i=pos; i>=ind; i--)
				alumnos[i+1] = alumnos[i];
			
			alumnos[ind] = new Estudiante(nombre, problemPriority);
			
			pos++;
			
			agregado(ind);
			
	}
	
	private void agregado(int val)
	{
		if(val==0)
			System.out.printf("Agregare a %s al inicio\n",nombre);
		
		else
			System.out.printf("Agregare a %s despues de %s\n",nombre,alumnos[val-1].getNombre());
	}
	
	/**
	 * El toString() te retorna una cadena que contiene todos los elementos/alumnos de la lista
	 */
	@Override
	public String toString()
	{
		String als="";
		
		for(int i=0; i<=pos; i++)
		{
			als+=alumnos[i].getNombre()+" -> ";
		}
		
		
		return als;
	}
	
	/**
	 * 
	 * @param g Parametro recibido en la clase Panel Cola para dibujar sobre 
	 * 			el panel las imagenes acorde a la lista  de alumnos 
	 * 
	 * @param pc Es la referencia al panel donde se dibuja todo, solo se usa como ImageObserver en el metodo drawImage
	 * @param y La pos en y donde dibujara los graficos
	 */
	public void iteracion(Graphics g, PanelCola pc, int y)
	{
		int xImagen=80;
		
		for(int i=0; i<=pos; i++)
		{
//			if(i%2==0)
			g.drawString(alumnos[i].getNombre(), xImagen, y-20);
//			else 
//				g.drawString(alumnos[i].getNombre(), xImagen, y+45);
			
			g.drawImage(alumnos[i].imagen, xImagen, y, pc);
			xImagen+=40;
		}
	}
}
