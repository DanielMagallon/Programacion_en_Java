package Recursividad;

public class OrdenasElementosArreglo
{
	static int [] vec = {312, 614, 88, 22, 54};

    static void ordenar (int [] v, int cant) {
        if (cant > 1) {
            for (int f = 0 ; f < cant - 1 ; f++)
                if (v [f] > v [f + 1]) {
                    int aux = v [f];
                    v [f] = v [f + 1];
                    v [f + 1] = aux;
                }
            ordenar (v, cant - 1);
        }
    }

   static  void imprimir () {
        for (int f = 0 ; f < vec.length ; f++)
            System.out.print (vec [f] + "  ");
        System.out.println("\n");
    }


    public static void main (String [] ar)  {
        
        imprimir ();
        ordenar (vec, vec.length);
        imprimir ();
    }
}
