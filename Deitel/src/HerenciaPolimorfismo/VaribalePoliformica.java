package HerenciaPolimorfismo;

public class VaribalePoliformica
{
	public static void main(String[] args)
	{
		// Varibale Poliformica es aquella
		// que contiene refrencia a un objeto
		
		OptimistaVarPol objOptimista = new OptimistaVarPol();
		PesimistaVarPol objPesimista = new PesimistaVarPol();
		ExtrovertidoVarPol objExtrovertido = new ExtrovertidoVarPol();
		IntrovertidoVarPol objIntrovertido = new IntrovertidoVarPol();
		
		// Crando mi variable poliformica
		
		/**
		 * objPersonalidad=varibale pol.
		 */
		
		PersonaladidadVarPol[] objPersonalidad = new PersonaladidadVarPol[4];
		
		objPersonalidad[0]=objOptimista; // contiene un objeto
		objPersonalidad[1]=objPesimista;
		objPersonalidad[2]=objExtrovertido;
		objPersonalidad[3]=objIntrovertido;
		
		// Poniendo a trabajar nuestro variable

		/*for (int i=0; i<objPersonalidad.length; i++)
		{
			objPersonalidad[i].hablar();
		}*/
		
		for (PersonaladidadVarPol objPersonalidades : objPersonalidad)
		{
			objPersonalidades.hablar();
		}
	}
}
