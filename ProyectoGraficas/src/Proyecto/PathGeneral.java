package Proyecto;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PathGeneral extends JDialog
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1599756145911079082L;
	public static File rutaRecursos;
	private String path;
	private boolean pathEstablecida=false;
	
	public PathGeneral(Metodo act)
	{
	
		try
		{
			path = (String) Serializa.writeObject(new File("path.data"));
			rutaRecursos = new File(path);
			System.out.println("Ruta de recursos: "+rutaRecursos);
			
			if(path==null)
			{
				throw new Exception();
			}
			
			act.metodo(path);
				
		}
		catch(Exception e)
		{
			System.out.println("Ruta de recursos: null");
			System.out.println("Creando el archivo path.data");
			JLabel lblDesc;
			JTextField txtRuta;
			JButton btnBrowse,btnOk;
			JFileChooser chosser;
			chosser = new JFileChooser();
			
			addWindowListener(new WindowAdapter()
			{
				@Override
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
			
			setSize(850, 120);
			setLocationRelativeTo(null);
			setLayout(new BorderLayout());
			JPanel p = new JPanel();
			btnOk = new JButton("Aceptar");
			
			{
				JLabel nomb = new JLabel("Carpeta recursos: ");				
				txtRuta = new JTextField(50);
				JTextField mkd = new JTextField(15);
				mkd.addKeyListener(new KeyAdapter()
				{

					@Override
					public void keyReleased(KeyEvent e)
					{
						btnOk.setEnabled(mkd.getText().trim().length()!=0 && pathEstablecida);	
						
						if(rutaRecursos==null)
							txtRuta.setText("/"+mkd.getText().replaceAll("/", ""));
						
						else txtRuta.setText(rutaRecursos.getPath()+"/"+mkd.getText().replaceAll("/", ""));
					}
					
				});
				txtRuta.setEditable(false);
				
				
				btnOk.setEnabled(false);
				btnOk.addActionListener((a)->
				{
					
					String carpetas[] = {"Wallpaper","Icons","ImagesCreadas","SerFiles"};
					File mkdirs[] = new File[carpetas.length];
					
					path = txtRuta.getText();
					rutaRecursos = new File(path);
					FileWorker.mkdirRecursos(new File(path));
					
					for(int i=0; i<carpetas.length; i++)
					{
						mkdirs[i] = new File(System.getProperty("user.dir")+"/"+carpetas[i]+"/");
						FileWorker.moveDelete(mkdirs[i], new File(path), carpetas[i]);
					}
					
					JOptionPane.showMessageDialog(null, "Archivos copiados correctamente",
							"Proceso finalizado",JOptionPane.INFORMATION_MESSAGE);
					Serializa.saveObject(path, new File("path.data"));
						
					
					
					this.dispose();
					act.metodo(path);
				});
				
				lblDesc = new JLabel("Seleccione la ruta para almacenar los archivos: ");
				btnBrowse = new JButton("Examinar");
				btnBrowse.addActionListener((a)->
						{
							pathEstablecida = true;
							btnOk.setEnabled(establecerRuta(chosser,txtRuta,mkd) && 
									txtRuta.getText().trim().length()!=0);
						}			
					);
				
			
				
				p.add(lblDesc);
				p.add(txtRuta);
				p.add(btnBrowse);
				p.add(btnOk);
				p.add(nomb);
				p.add(mkd);
			}
		
			add(p,"Center");
			this.setVisible(true);
		}
	}
	
	
	public boolean establecerRuta(JFileChooser chosser,JTextField txtRuta, JTextField mkd)
	{
		int opc;
		chosser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		opc = chosser.showOpenDialog(this);
		chosser.setCurrentDirectory(chosser.getSelectedFile());
		
		if(opc == JFileChooser.APPROVE_OPTION)
		{
			String t = mkd.getText();
			txtRuta.setText(chosser.getSelectedFile().getAbsolutePath());
			path = txtRuta.getText();
			rutaRecursos = new File(path);
			txtRuta.setText(chosser.getSelectedFile().getAbsolutePath().concat("/"+t.replaceAll
					("/", "")));
			return true;
		}
		
		return false;
	}
}
