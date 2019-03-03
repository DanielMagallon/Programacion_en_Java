package C11ATM;

// Screen: Pantalla

public class Screen
{
	// Mostrar mensaje
	void displayMessage(String message)
	{
		System.out.print(message);
	}
	
	// Mostrar linea de mensajes
	void displayMessageLine(String message)
	{
		System.out.println(message);
	}
	
	// Displays a dollar amount
	// Muestra un monto en dolares
	void displayDollarAmount(double amount)
	{
		System.out.printf ("$%,.2f",amount);
	}
	
}
