package Reflection_Annotation;

public class NecesitaObjetoInyectado
{

	@Autowired
	private Inyection_Spring miObjetoInyectado;

	public void usarObjetoInyectadoYMostrarPorPantalla()
	{
		String textoObtenidoDeObjetoInyectado = miObjetoInyectado.metodoDeObjetoInyectado();
		System.out.println(
				"Lo que me devuelve el método del objeto que me han inyectado: " + textoObtenidoDeObjetoInyectado);
	}

}