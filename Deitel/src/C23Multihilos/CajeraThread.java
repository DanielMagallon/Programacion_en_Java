package C23Multihilos;

public class CajeraThread extends Thread
{
	private String nombre;

	private Cliente cliente;

	private long initialTime;

	public CajeraThread(String na, Cliente cliente, long ini)
	{
		nombre = na;
		this.cliente = cliente;
		initialTime  = ini;
	}
	
	@Override
	public void run()
	{
		System.out.println("La cajera " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " 
				+ this.cliente.getNombre() + " EN EL TIEMPO: " 
				+ (System.currentTimeMillis() - this.initialTime) / 1000 
				+ "seg");

	for (int i = 0; i < this.cliente.getCarroCompra().length; i++) { 
		this.esperarXsegundos(cliente.getCarroCompra()[i]); 
		System.out.println("Procesado el producto " + (i + 1) 
		+ " del cliente " + this.cliente.getNombre() + "->Tiempo: " 
		+ (System.currentTimeMillis() - this.initialTime) / 1000 
		+ "seg");
	}

	System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR " 
					+ this.cliente.getNombre() + " EN EL TIEMPO: " 
					+ (System.currentTimeMillis() - this.initialTime) / 1000 
					+ "seg");
	}
	
	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
