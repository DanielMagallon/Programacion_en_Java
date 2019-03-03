package HelpClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
public class Lambda {
 
 public static void main(String[] args) {
 
	 scan:
	 {
	 	int a=18;
	 
	 	for (int i=0; i<20; i++)
	 		System.out.println(i);
	 	
	 	if(a==18)
	 	break scan;
	 	System.out.println(200);
	 	
	 }
	 
 ArrayList<Persona> milista= new ArrayList<Persona>();
 milista.add(new Persona("Miguel"));
 milista.add(new Persona("Alicia"));

 Collections.sort(milista,
		 (Persona p1,Persona p2) -> p1.getNombre().compareTo(p2.getNombre()));
 
 /*Collections.sort(milista,new Comparator<Persona>() {
 
	 public int compare(Persona p1,Persona p2) {
 
	 return p1.getNombre().compareTo(p2.getNombre());
 		}
 
 });*/
 
 for (Persona p: milista) {
 
 System.out.println(p.getNombre());
 
 }
 }
 
}
