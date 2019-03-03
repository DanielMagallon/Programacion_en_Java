package C8Herencia;

public class Multiplicar extends OperacionPadre
{
	void multiplicar ()
	{
		resultado=valor1*valor2;
	}
}

class Dividir extends OperacionPadre
{
	void dividir ()
	{
		resultado=valor1/valor2;
	}
}
