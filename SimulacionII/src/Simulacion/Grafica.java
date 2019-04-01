package Simulacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Grafica extends JPanel
{
	private static final long serialVersionUID = 8456043879017609254L;

	private int x=70,y=100,lado=1000,incYH=40,incYV=10,interseY=lado+y+incYV,iy,ix;
	public int ejeX=-1,ejeY,divX,divY,pointDivX,pointDivY,i,p,ind=-1;
	public int points[][];
	public Color colores[];
	private int[][] divisores;
	private boolean graphPoints,divide;
	private DivisorEspacio windDiv;
	JList<String> listDiv;
	
	public Grafica()
	{
		setBackground(Color.white);
		setBounds(0, 0, 1500, 1500); 
		setPreferredSize(new Dimension(1500, 1500));
		
		windDiv = new DivisorEspacio();
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.drawLine(x, y, x, lado+y+incYH);
		g.drawLine(x-incYH, interseY, x+lado+incYH, interseY);

		//divide vertical
		int ind=1;
		for(iy=interseY-10; iy>y; iy-=10,ind++)
		{
			
			if(ind%10==0)
				g.drawLine(x-10, iy, x+10, iy);
			
			else
			g.drawLine(x-5, iy, x+5, iy);
		}
		
		ind=1;
		for(ix=x; ix<=1000+x; ix+=10,ind++)
		{
			
			if((ind-1)%10==0)
				g.drawLine(ix,interseY-10,ix,interseY+10);
			
			else g.drawLine(ix,interseY-5,ix,interseY+5);
			
		}
		
		if(graphPoints)
		{
			for(int i=0; i<points.length; i++)
			{
				g.setColor(colores[i]);
				graficar(g,points[i][0], points[i][1]);
			}
		}
			
		if(divide)
		{
			g.setColor(Color.red);

			//Horizontal
			for(i=1,p=interseY-pointDivY; i<divY; i++,p-=pointDivY)
			{
				g.drawLine(x, p, x+lado+incYH, p);
			}
				
			
			//Vertical
			for(i=1,p=x+pointDivX; i<divX; i++,p+=pointDivX)
				g.drawLine(p, interseY, p, y);
		}
	}
	
	public void aplicarDiv()
	{
		divide=true;
		pointDivX = lado/divX;
		pointDivY = lado/divY;
		repaint(); 
	}
	
	public void dividirEspacio()
	{
		windDiv.modelo.clear();
		
		divisores = MathData.getMultiplos(MathData.getSqrtN());
		
		if(divisores.length == 0)
		{
			divisores = new int[][] { {1,(int)MathData.getSqrtN()}};
			
			if(divisores[0][1]==1)
			{
				return;
			}
		}
		
		else if(divisores.length==1 && divisores[0][0]==divisores[0][1])
		{
			divX = divY = divisores[0][0];
			aplicarDiv();
			return;
		}
		
		for(int i=0; i<divisores.length; i++)
		{
			windDiv.addOption(String.format
					("[%d] x [%d]", divisores[i][0],divisores[i][1]));
			
			if(divisores[i][0]!=divisores[i][1])
				windDiv.addOption(String.format
						("[%d] x [%d]", divisores[i][1],divisores[i][0]));
		}
		
			windDiv.setVisible(true);
	}
	
	public void graphicPoints()
	{
		graphPoints = true;
		divide=false;
		repaint();
	}
	
	private void graficar(Graphics g,int px, int py)
	{
		ejeX = x+(10*px);
		ejeY = interseY-(10*py);
		g.fillRect(ejeX-10, ejeY-10, 10, 10);
	}
	
	class DivisorEspacio extends JDialog 
	{
		private static final long serialVersionUID = -7218262596362843238L;
		DefaultListModel<String> modelo;
		JButton ok;
		
		public DivisorEspacio()
		{
			setTitle("Division del plano cartesiano");
			setModal(true);
			setSize(250, 200);
			setLocationRelativeTo(Grafica.this);
			//setLayout(new BorderLayout());
			
			modelo = new DefaultListModel<String>();
			listDiv = new JList<String>(modelo);
			JScrollPane sc = new JScrollPane(listDiv);
			
			JPanel p = new JPanel();
			
			ok = new JButton("Aceptar");
			ok.addActionListener((a)->
			{
				if(ind!=-1)
				{
					aplicarDiv();
					this.dispose();
					ind=-1;
				}
			});
			p.add(ok);
			
			add(p,"South");
			add(sc,"Center");
			
			listDiv.addMouseListener(new Adaptadora());
		}
		
		public void addOption(String op)
		{
			modelo.addElement(op);
		}
		
	}
	
	class Adaptadora extends MouseAdapter
	{
		int dec;
		
		@Override
		public void mouseClicked(MouseEvent e)
		{
			ind = listDiv.getSelectedIndex();
			
			if(ind!=-1)
			{
				if((ind+1)%2==0)
				{
					dec = ind/2+1;
					divY = divisores[ind-dec][1];
					divX = divisores[ind-dec][0];
				}
				else
				{
					dec = ind/2;
					divY = divisores[ind-dec][0];
					divX = divisores[ind-dec][1];
				}
			}
		}
	}
}
