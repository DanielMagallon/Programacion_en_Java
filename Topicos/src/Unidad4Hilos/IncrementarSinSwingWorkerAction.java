package Unidad4Hilos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
 
@SuppressWarnings("serial")
public class IncrementarSinSwingWorkerAction implements ActionListener{
	
	private EjemploFrame ejemploFrame;
	
	public IncrementarSinSwingWorkerAction(EjemploFrame ejemploSinSwingWorkerFrame){
		this.ejemploFrame = ejemploSinSwingWorkerFrame;
	}
 
	public void actionPerformed(ActionEvent arg0) {
		int ite = 0;
		while (ite < EjemploFrame.MAX_ITE){
			ite = ite + 1;
			this.ejemploFrame.getTextField().setText("" + ite);
		}
		
	}	
}