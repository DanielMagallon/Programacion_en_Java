package Interfaz;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Abstract.Variables;
import Eventos.EstadoTablero;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Timer;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class Evaluador extends JFrame{

	private JPanel contentPane, tablero;
	private EvLabel labels[][] = new EvLabel[8][8];
	private JPanel panel;
	private JButton btnX;
	private JPanel panel_1;
	
	private boolean on=false;
	
	private Timer timer = new Timer(500, new ActionListener() 
	{
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(!on)
			{
				for(Position p : positions)
				{
					labels[p.fila][p.columna].marck();
					on=true;
					timer.stop();
					timer.start();
				}
			}
			else
			{
				for(Position p : positions)
				{
					labels[p.fila][p.columna].desmarck();
					on=false;
					timer.stop();
					timer.start();
					
				}
			}
		}
	});
	
	public Evaluador() 
	{
		setBackground(SystemColor.menu);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		
		panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
		);
		panel_1.setLayout(new GridLayout(1, 2, 5, 0));
		
		
		tablero = new JPanel();
		panel_1.add(tablero);
		tablero.setLayout(new GridLayout(8, 8));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		scrollPane.setViewportView(editorPane);
		
		btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		
		JButton button = new JButton(">");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(183)
					.addComponent(btnX, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(218))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(389))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(btnX)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		creaTablero();
	}
	
	private void creaTablero()
	{
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				labels[i][j] = new EvLabel(i,j);
				labels[i][j].addMouseListener(new Click());
				tablero.add(labels[i][j]);
			}
		}
	}
	
	public void activa()
	{
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				labels[i][j].setImage(TableroAjedrez.estado.tablero[i][j].pieza, 
						TableroAjedrez.estado.tablero[i][j].valor);
			}
		}
		
		marcaPieza();
		
		setVisible(true);
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

		for(Position p : positions)
		{
			labels[p.fila][p.columna].activado=false;
			labels[p.fila][p.columna].desmarck();
		}
		
		timer.stop();
		positions.clear();
		
		super.dispose();
		
	}
	
	private ArrayList<Position> positions = new ArrayList<>();
	
	private void marcaPieza()
	{
		Iterator<CasillaData> it;
		CasillaData casilla;
		
		if(Variables.turnoBlancas)
		{
			it = TableroAjedrez.estado.blancasOn.keySet().iterator();
			
			while(it.hasNext())
			{
				casilla = it.next();
				positions.add(new Position(casilla.position.fila, casilla.position.columna));
				labels[casilla.position.fila][casilla.position.columna].activado=true;
			}
		}
		else
		{
			it = TableroAjedrez.estado.negrasOn.keySet().iterator();
			
			while(it.hasNext())
			{
				casilla = it.next();
				positions.add(new Position(casilla.position.fila, casilla.position.columna));
				labels[casilla.position.fila][casilla.position.columna].activado=true;
			}
		}
		
		timer.start();
	}
	
	private EvLabel labelClick;
	
	class Click extends MouseAdapter
	{
		
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			labelClick = (EvLabel) e.getComponent();
			
			if(labelClick.activado)
			{
				timer.stop();
				labelClick.choss();
			}
			
		}
		
	}
}
