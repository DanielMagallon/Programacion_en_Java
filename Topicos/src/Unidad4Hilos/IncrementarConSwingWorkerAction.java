package Unidad4Hilos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.SwingWorker;
 
@SuppressWarnings("serial")
public class IncrementarConSwingWorkerAction /*extends SwingWorker<Void, Void>*/ implements ActionListener
{
	
	private EjemploFrame ejemploFrame;
	
	public IncrementarConSwingWorkerAction(EjemploFrame ejemploSinSwingWorkerFrame){
		this.ejemploFrame = ejemploSinSwingWorkerFrame;
	}
 
//	@Override
//	protected Void doInBackground() throws Exception
//	{
//		int ite = 0;
//		while (ite < EjemploFrame.MAX_ITE){
//			ite = ite + 1;
//			ejemploFrame.getTextField().setText("" + ite);
//		}	
//		return null;
//	}
	
	public void actionPerformed(ActionEvent arg0) {
		final SwingWorker worker = new SwingWorker(){
 
			@Override
			protected Object doInBackground() throws Exception {
				int ite = 0;
				while (ite < EjemploFrame.MAX_ITE){
					ite = ite + 1;
					ejemploFrame.getTextField().setText("" + ite);
				}	
				return null;
			}	
		};
		worker.execute();
	}
}	