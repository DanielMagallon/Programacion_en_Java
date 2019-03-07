package Unidad1P2;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalifiacionesP3 extends JFrame
{
	String arr[]; 
	String cals[];
	Dialog d;
	boolean calificar;
	
	public CalifiacionesP3(String...nombres) 
	{
		arr = nombres;
		cals = new String[arr.length];
		
		d  = new Dialog(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		JPanel up = new JPanel();
		
		{
			JButton btn = new JButton("Calificaciones");
			btn.addActionListener(
					
						(a)->{
							d.setVisible(true);
						}
					
					);
			
			up.add(btn);
			
			add(up,"North");
		}
	}
	
	int x=200,y,index;
	
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		y=200;
		
		for(int i=0; i<arr.length; i++)
		{
			g.drawString(arr[i], x, y);
			y+=30;
		}
		
		if(calificar)
		{
			y=200;
			for(int i=0; i<index; i++)
			{
				g.drawString(cals[i], x+200, y);
				y+=30;
			}
		}
			
	}
	
	public static void main(String[] args) {
		new CalifiacionesP3(
				"Othoniel","Fernando","Gabriel","Bryant","Edgar"
				).setVisible(true);
		
	}
	
	

	class Dialog extends JDialog
	{
		JLabel lblAlu;
		JComboBox<String> cali;
		
		public Dialog(boolean modal) 
		{
			super(CalifiacionesP3.this,modal);
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			setLocationRelativeTo(CalifiacionesP3.this);
			setSize(400, 300);
			
			lblAlu = new JLabel(arr[0]);
			cali = new JComboBox<>();
			
			for(int i=1; i<=100; i++)
			{
				cali.addItem(i+"");
			}
			
			setLayout(new BorderLayout());
			
			JPanel ab = new JPanel();
			
			{
				JButton btnOk = new JButton("Aceptar");
				
				JButton btnCan = new JButton("Cancelar");
				
				ab.add(btnOk);
				ab.add(btnCan);
				
				btnOk.addActionListener(
						
								(a)->
								{
									calificar=true;
									cals[index] = cali.getSelectedItem().toString();
									
									if(index==arr.length-1)
									{
										index++;
										btnOk.setEnabled(false);
										CalifiacionesP3.this.repaint();
										this.dispose();
									}
									
									else
										lblAlu.setText(arr[++index]);
									
									
								}
						
						);
				
				btnCan.addActionListener(
						
						(a)->
						{
							if(index>0)
								calificar=true;
							
							CalifiacionesP3.this.repaint();
							this.dispose();
						}
				
				);
				
				add(ab,"South");
			}
			
			JPanel cen = new JPanel();
			
			{
				cen.add(lblAlu);
				cen.add(cali);
				add(cen,"Center");
			}
		}
		
		@Override
		public void setVisible(boolean b) {
			// TODO Auto-generated method stub
			super.setVisible(b);
			
			if(index<arr.length)
				lblAlu.setText(arr[index]);
		}
	}
}
