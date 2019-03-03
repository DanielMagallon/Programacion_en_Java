package GeneratorHex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


public class Analizate extends JFrame
{
	final int SIZE=33;
	
	JPanel centro, este, panelFuncion;
	
	JLabel lanels[][] = new JLabel[SIZE][SIZE];
	Border border = BorderFactory.createLineBorder(Color.black);
	Border borderBlue = BorderFactory.createLineBorder(Color.blue);
	GridLayout layGrid = new GridLayout(SIZE, SIZE,0,0);
	
	JTextField FROM_f,FROM_c, TO_f,TO_c;
	
	public Analizate()
	{
		setLayout(new BorderLayout());
		
		centro = new JPanel();
		este = new JPanel();
		//este.setBackground(Color.BLUE);
		
		centro.setLayout(layGrid);
		menuEmergent();
		putPanels();
		funcionesPanels();
		
		
		add(centro, BorderLayout.CENTER);
		add(este, BorderLayout.EAST);
		
		setDefaultCloseOperation(2);
		setVisible(true);
		setSize(700, 500);
		
	}
	
	JLabel lblClick;
	
	private void putPanels()
	{
		
		for (int i=0; i<lanels.length; i++)
		{
			for (int j=0; j<lanels[i].length; j++)
			{
				lanels[i][j] = new JLabel();
				lanels[i][j].setComponentPopupMenu(pop);
				lanels[i][j].setBorder(border);
				lanels[i][j].addMouseListener(new LabelClick());
				lanels[i][j].setOpaque(true);
				centro.add(lanels[i][j]);
			}
		}
		
		for (int j=1; j<lanels.length; j++)
		{
			lanels[0][j].setHorizontalAlignment(0);
			lanels[0][j].setText(""+j);
		}
		
		for (int i=1; i<lanels.length; i++)
		{
			lanels[i][0].setHorizontalAlignment(0);
			lanels[i][0].setText(""+i);
		}
	}
	
	JButton btnColorDial, fullLBL;
	Color miColor = Color.black;
	JPanel theColor, FTO;
	JCheckBox cbxEraser;
	int filaFROM, colFROM,filaTO,colTO;
	JPopupMenu pop;
	JMenuItem itemMenu;
	
	private void menuEmergent()
	{
		pop=new JPopupMenu();
		itemMenu=new JMenuItem("GET");
		pop.add(itemMenu);
		
		itemMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				miColor=lblClick.getBackground();
			}
		});
	}
	
	private void funcionesPanels()
	{
		theColor = new JPanel();
		este.setLayout(new GridLayout(3, 1));
		btnColorDial = new JButton("Color");
		cbxEraser = new JCheckBox("Erase Color");
		panelFuncion = new JPanel(); 
		theColor.setBackground(miColor);
		
		panelFuncion.setLayout(new BorderLayout());
		panelFuncion.add(btnColorDial, BorderLayout.NORTH);
		panelFuncion.add(theColor, BorderLayout.SOUTH);
		panelFuncion.add(cbxEraser, BorderLayout.CENTER);
		
		este.add(new JPanel());
		este.add(panelFuncion);
		
		FROM_f = new JTextField("Fromfila");
		TO_f = new JTextField("ToFila");
		
		FROM_c = new JTextField("FromCol");
		TO_c = new JTextField("ToCol");
		
		FTO = new JPanel();
		FTO.setLayout(new BorderLayout());
		FTO.add(FROM_f,BorderLayout.NORTH);
		FTO.add(TO_f, BorderLayout.SOUTH);
		FTO.add(FROM_c,BorderLayout.WEST);
		FTO.add(TO_c, BorderLayout.EAST);
		
		este.add(FTO, BorderLayout.CENTER);
		
		btnColorDial.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				miColor = JColorChooser.showDialog(Analizate.this, 
						"Choose a color", miColor);
				
				if(miColor==null)
					miColor=Color.black;
				
				theColor.setBackground(miColor);
			}
		});
		
		fullLBL = new JButton("Rellenar");
		
		fullLBL.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				filaFROM = Integer.parseInt(FROM_f.getText());
				colFROM = Integer.parseInt(FROM_c.getText());
				
				filaTO = Integer.parseInt(TO_f.getText());
				colTO = Integer.parseInt(TO_c.getText());
				
				for (int i=filaFROM; i<=filaTO; i++)
				{
					for (int j=colFROM; j<=colTO; j++)
					{
						lanels[i][j].setBackground(miColor);
					}
				}
			}
		});
		
		add(fullLBL, BorderLayout.SOUTH);
		
		generate = new JButton("Generate HEXA");
		
		generate.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				generateCode();
			}
		});
		
		add(generate, BorderLayout.NORTH);
	}
	
	JButton generate;
	final Color initialC = new Color(238,238,238);
	
	class LabelClick extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			lblClick = (JLabel) e.getComponent();
			if(!cbxEraser.isSelected())
			{
				
				lblClick.setBackground(miColor);
			}
			else
			{
				lblClick.setBackground(initialC);
			}
		}
	}
	
	
	int hexa=0, potenciaBase=8;
	final String prefijo="0x";
	String hexaCad;
	
	private void generateCode()
	{
		hexaCad="";
		
		for (int i=1; i<lanels.length;i++)
		{
			hexaCad +=prefijo; 
			
			for (int j=1; j<lanels[i].length; j++)
			{
				if(lanels[i][j].getBackground() == miColor)
					hexa+=potenciaBase;
				
				potenciaBase /= 2;
				
				if(j%4 == 0)
				{
					hexaCad += Integer.toHexString(hexa);
					potenciaBase=8;
					hexa=0;
					
				}
			}
			hexaCad+=",\n";
		}
		
		System.out.println(hexaCad);
	}
	
	public static void main(String[] args) {
		new Analizate();
	}
}
