package SimpleTron;

public interface Error
{
	public String someError(String error);
	default String lengthError(){
		return "LengthException el tama�o del codigo debe ser de 4";
	}
}
