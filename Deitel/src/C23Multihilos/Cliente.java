package C23Multihilos;

public class Cliente
{
	private String nombre;
	private int[] carroCompra;
	
	public Cliente(String name, int[] va)
	{
		nombre = name;
		carroCompra = va;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public int[] getCarroCompra()
	{
		return carroCompra;
	}
	
}
