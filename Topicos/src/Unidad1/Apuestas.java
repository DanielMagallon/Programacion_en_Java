package Unidad1;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * 
 * @author Yeo
 *	Contenido en github, modificado2
 */
public class Apuestas extends Applet
{
	private static final long serialVersionUID = -1862330924066930967L;
	
	Button btnTirar;
	TextField txtDado1,txtDado2,txtApuesta;
	Label lblSaldo;
	int saldo=50,apuesta;
	PanelApuesta pCentro;
	Image imgs[] = new Image[6];
	Random lb = new Random();
	Checkbox animado;
	
	int a1,a2;
	
	@Override
	public void init() 
	{
		
		setLayout(new BorderLayout());
		setSize(800,600);
				
		animado = new Checkbox("Con animacion");
		animado.setState(true);
		
		pCentro = new PanelApuesta();
		
		Panel pUp = new Panel();
		
		Label lbl1 = new Label("Dado 1: ");
		txtDado1 = new TextField(10);
		txtDado1.setEditable(false);
		
		Label lbl2 = new Label("Dado 2: ");
		txtDado2 = new TextField(10);
		txtDado2.setEditable(false);

		
		pUp.add(lbl1);
		pUp.add(txtDado1);
		pUp.add(lbl2);
		pUp.add(txtDado2);
		
		btnTirar = new Button();
		
		Panel pDown = new Panel();
		pDown.setLayout(new BorderLayout());
		
		Label lblAp = new Label("Apuesta: ");
		txtApuesta = new TextField(10);
		txtApuesta.addActionListener(
				
					(a) -> moverDados()
				
				);
		lblSaldo = new Label("Saldo: $"+saldo);
		Panel panOpc = new Panel();
		panOpc.add(lblAp);
		panOpc.add(txtApuesta);
		
		Panel box = new Panel();
		box.add(animado);
		pDown.add(box,"Center");
		
		pDown.add(panOpc,"West");
		pDown.add(lblSaldo,"East");
		
		
		add(pDown,"South");
		add(pUp,BorderLayout.NORTH);
		add(pCentro,"Center");
		
		crearImagenes();
		
//		System.out.println(
//				
//					Arrays.toString(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames())
//				);
	}
	
	private void crearImagenes()
	{
		for(int i=0; i<imgs.length; i++)
		{
			URL url = getClass().getResource("/Unidad1/Recursos/im"+(i+1)+".jpg");
			
			imgs[i] = getImage(url); 
		}
	}

	
	int x=1;
	Timer timer = new Timer(70, 
			
				(a)->{
					if(x<=10)
					{
						
						a1 =lb.nextInt(6);
						a2 =lb.nextInt(6);
						x++;
						pCentro.repaint();
					}
					else {
						parar();
					}
				}
			
			);
	
	private void moverDados()
	{
		
		try
		{
			apuesta = Integer.parseInt(txtApuesta.getText().trim());
			
			if(animado.getState())
				timer.start();
			
			else {
				a1 =lb.nextInt(6);
				a2 =lb.nextInt(6);
				checar();
				pCentro.repaint();
			}
				
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this, "Debe ingresar un valor en la apuesta",
					"Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void parar()
	{
		timer.stop();
		x=1;
		checar();
	}

	
	private void checar()
	{
		txtDado1.setText("\t"+(a1+1));
		txtDado2.setText("\t"+(a2+1));
		
		
		if(a1+1 == 1 && a2+1 == 1)
		{
			saldo+=apuesta;
			JOptionPane.showMessageDialog(this, "Has ganado","Felicidades!!",JOptionPane.INFORMATION_MESSAGE);				
		}
		else saldo-=apuesta;
		
		lblSaldo.setText("Saldo: $"+saldo);
		
	}
	

	Color color = Color.LIGHT_GRAY;
	@SuppressWarnings("serial")
	class PanelApuesta extends Panel
	{
		
		Font cambria = new Font("Cambria Math",Font.BOLD|Font.ITALIC,38);
		boolean contorno=false;
		
		{
			addMouseListener(new Adapter());
			addKeyListener(new Key());
		}
		
	
		@Override
		public void paint(Graphics g)
		{
			g.drawImage(imgs[a1], 70, 120,this);
			g.drawImage(imgs[a2], 500, 120,this);
			
			//boton
			{
				//Comic Sans MS
				//Corbel
				//Segoe UI Historic,
				g.setFont(cambria);
				g.setColor(color);
				g.fillRect(325, 400, 150, 40);
				g.setColor(Color.black);
				g.drawRect(325, 400, 150, 40);
				g.drawString("Tirar", 350, 435);
				
				if(contorno)
				{
					 Graphics2D g2d=(Graphics2D)g;
					       
					 g2d.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f,
							 new float[]{10}, 0.0f));
					 
					 g2d.drawRect(335, 405, 130 , 32);
					
				}
			}
		}

		int x,y;
		class Adapter extends MouseAdapter
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				x = e.getX();
				
				y = e.getY();
				
				if(x>=325 && x<=475 && y>=400 && y<=450)
				{
					moverDados();
					contorno = true;
				}
				else {
					contorno = false;
					repaint();
				}
			}
		}
		
		class Key extends KeyAdapter{
			
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					if(x>=325 && x<=475 && y>=400 && y<=450)
					{
						moverDados();
					}
				}
			}
		}
	}

	
}
