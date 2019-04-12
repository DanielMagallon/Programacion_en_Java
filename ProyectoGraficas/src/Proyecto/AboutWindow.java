package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import PanelsAbout.Info;
import PanelsAbout.StringData;

public class AboutWindow extends JDialog
{
	private static final long serialVersionUID = -6372016228104503567L;

	private JPanel panelGeneral;
	private PanelFuncionamientos panels[];
	private JScrollPane sc;
	
	public String[][][] datos =
		{
			StringData.pasosCrear,
			StringData.pasosCopyPaste,
			StringData.pasosPath,
			StringData.pasosCmd
		};
	
	private String[] questions = 
		{
			"¿Como se ingresan los datos?",
			"¿Como copiar y pegar archivos en los distintos formatos (.table,.list o de imagen)?",
			"Archivo path",
			"Ejecutar archivos desde cmd"
		};
	
	public AboutWindow(Appi w)
	{
		super(w,true);
		setTitle("Acerca del programa");
		setSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize());
		
		panelGeneral = new JPanel();
		sc = new JScrollPane(panelGeneral);
		panelGeneral.setBackground(Color.white);
		panelGeneral.setLayout(new BoxLayout(panelGeneral, BoxLayout.Y_AXIS));
		add(sc);
		
		panels = new PanelFuncionamientos[questions.length];
		
		for(int i=0; i<questions.length; i++)
		{
			panels[i] = new PanelFuncionamientos(questions[i], new Info(datos[i]));
			panelGeneral.add(panels[i]);
		}
		
		panels[1].panelInfo.lbl[4].setForeground(Color.blue);
		panels[1].panelInfo.lbl[4].addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e) {
				
				try
				{
					Desktop.getDesktop().open(new File(PathGeneral.rutaRecursos.getPath()+"/SerFiles/"));
				} catch (IOException ex)
				{
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			};
			
		});
		
	}
	
	
	class PanelFuncionamientos extends JPanel
	{
		private static final long serialVersionUID = -533583547355512118L;
		
		JLabel lblQuestion;
		JLabel mostrar;
		Icon up,down;
		Info panelInfo;
		
		public PanelFuncionamientos(String question, Info abp)
		{
			panelInfo = abp;
			setLayout(new BorderLayout());
			JPanel panelN = new JPanel();
			panelN.setLayout(new FlowLayout(FlowLayout.LEFT));
			panelN.setBackground(Color.white);
			add(panelN,"North");
			
			this.setBackground(Color.white);
			lblQuestion = new JLabel(question);

			down = Appi.getImageIcon("caret-down.png");
			up = Appi.getImageIcon("up.png");
			
			mostrar = new JLabel(down);
			mostrar.addMouseListener(new CambiaFlecha());
			mostrar.setBackground(Color.white);
			
			panelN.add(lblQuestion);
			panelN.add(mostrar);

			abp.setPreferredSize(new Dimension(400,400));
			add(abp,"Center");
			abp.setVisible(false);
		}
		
		
		class CambiaFlecha extends MouseAdapter
		{
			private boolean upC=false;
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				mostrar.setIcon((upC=!upC) ? up : down);
				panelInfo.setVisible(upC);
			}
		}
		
	}
}
