package Unidad1;
import java.util.Scanner;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Patch;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;

/**
 *
 * @author ACASARRU
 */
public class SonidoTest {

    private void pintaMenu() {
        imprimeInstrumentos();
    }
    Synthesizer sintetizador;
    MidiChannel canales;
    Soundbank bancoSonidos;
    Instrument listaInstrumentos[];
    Patch patch;
    int[] listaNotas;
    static int upperRange;

    SonidoTest() {
        try {
            listaNotas = new int[]{40, 47, 52, 55, 59, 64};
            //Se obtiene el sintetizador midi
            sintetizador = MidiSystem.getSynthesizer();
            //Se abre el sintetizador para poder reproducir sonidos
            sintetizador.open();
            //Se obtienen los canales del sintetizador
            canales = sintetizador.getChannels()[1];
            //se carga el banco de sonidos
            bancoSonidos = sintetizador.getDefaultSoundbank();
            //se carga la lista de sonidos
            sintetizador.loadAllInstruments(bancoSonidos);
            //Se cargan los instrumentos
            listaInstrumentos = sintetizador.getLoadedInstruments();
            upperRange = listaInstrumentos.length -1 ;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void imprimeInstrumentos() {
        System.out.println("Presiona que instrumento deseas escuchar: ");
        System.out.println("0) Piano ");
        System.out.println("30) Guitarra (distorsion)");
        System.out.println("33) Bajo(con dedos)");
        System.out.println("34) Bajo(con pllumilla)");
        System.out.println("tambien puedes introducir un numero entre el 0 - el "+upperRange+" y escuchar su sonido");
    }

    public static void main(String[] args) {
        SonidoTest sonido = new SonidoTest();
        int opcion = 0;
        while (opcion >= 0) {
            sonido.pintaMenu();
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            if (opcion < 0 || opcion > upperRange) {
                System.out.println("El numero debe estar contenido[0 - "+upperRange+"], se reproducira el sonido de la guitarra.");
                opcion = 30;
            } 
            sonido.afinaInstrumento(opcion);
        }

    }

    private void afinaInstrumento(int opcion) {
        System.out.println("-> " + opcion);
        Instrument instrumento = listaInstrumentos[opcion];
        patch = instrumento.getPatch();
        canales.programChange(patch.getBank(), patch.getProgram());
        try {
            for (int i = 0; i < listaNotas.length; i++) {
                canales.noteOn(listaNotas[i], 100);
                Thread.sleep(1000);
            }
            Thread.sleep(3000);
            canales.allNotesOff();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}