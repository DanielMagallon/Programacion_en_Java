package HelpClass;

public class Navidad {

private static void cancion(){
String textoPorCaso = "";
String textoVersoCaso = "";
String mensaje = "", mensaje2 = "";

for (int i = 1; i <= 12; i++) {

switch(i){
case 1:
textoPorCaso = "El primer";
textoVersoCaso = "una perdiz picando peras del peral";
break;
case 2:
textoPorCaso = "El segundo";
textoVersoCaso = "dos tortolitas y ";
break;
case 3:
textoPorCaso = "El tercer";
textoVersoCaso = "tres gallinitas, ";
break;
case 4:
textoPorCaso = "El cuarto";
textoVersoCaso = "cuatro pajaritos, ";
break;
case 5:
textoPorCaso = "El quinto";
textoVersoCaso = "cinco anillos dorados, ";
break;
case 6:
textoPorCaso = "El sexto";
textoVersoCaso = "seis mamá gansas, ";
break;
case 7:
textoPorCaso = "El septimo";
textoVersoCaso = "siete cisnitos, ";
break;
case 8:
textoPorCaso = "El octavo";
textoVersoCaso = "ocho lecheritas, ";
break;
case 9:
textoPorCaso = "El noveno";
textoVersoCaso = "nueve bailarinas, ";
break;
case 10:
textoPorCaso = "El decimó";
textoVersoCaso = "diez señores saltando, ";
break;
case 11:
textoPorCaso = "El undecimó";
textoVersoCaso = "once gaiteritos, ";
break;
case 12:
textoPorCaso = "El duodecimó";
textoVersoCaso = "doce tamborileros, ";
break;
}

textoPorCaso += " día de Navidad, mi amor me mandó";

mensaje2 = mensaje;
mensaje = textoVersoCaso;
mensaje += mensaje2;
System.out.println(textoPorCaso + "\n");
System.out.println(mensaje + ".\n\n");
}
}

public static void main(String[] args) {
cancion();
}

} 
