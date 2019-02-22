package Unidad1P2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Practica1 extends JFrame implements ActionListener
{

	private static final long serialVersionUID = -814223204548267506L;
	
	public ImageIcon mexicoLbl = getImage("mexico.png");
	public ImageIcon euLbl = getImage("eu.png");
	public ImageIcon canadaLbl = getImage("canada.png");
	public ImageIcon unionEurLbl = getImage("unionEur.png");
	public ImageIcon mapaEU = getImage("mapaEU.png");
	public ImageIcon mapaEuropa = getImage("mapaEuropa.png");
	public ImageIcon icono = getImage("icono.png");
	public ImageIcon mapaCanada = getImage("mapaCanada.png");
	public ImageIcon flechaD = getImage("flechad.png");
	public ImageIcon flechaI = getImage("flechai.png");
	
	JButton btnEu,btnCanada,btnUEur;
	JLabel lblMex,lblBandera,moneda,lblBefore,lblNext;
	JTextField txtPesos,txtMoneda;
	Click cl;
	
	public static final float DOLAR = 19.29f,DOLAR_CANADIENSE=14.58F,EURO=21.87F;
	public float valor = DOLAR,conve,total;
	
	KeyLisen kl = new KeyLisen();
	
	public Practica1() 
	{
		setTitle("Casa de cambio");
		setLayout(new BorderLayout());
		
		setSize(600, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(icono.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panelBtns = new JPanel() {
			@Override
			public void paintComponent(Graphics g) 
			{
					super.paintComponent(g);
				  Graphics2D g2d=(Graphics2D)g;
				  g2d.setPaint(new GradientPaint(200, 0, Color.WHITE, getHeight(), getWidth(), Color.BLACK));
				  g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		
		
		{
			btnEu = new JButton("Estados Unidos");
			btnEu.addActionListener(this);
			btnEu.setBackground(Color.white);
			btnEu.setIcon(mapaEU);
			
			btnCanada = new JButton("Canada");
			btnCanada.addActionListener(this);
			btnCanada.setBackground(Color.white);
			btnCanada.setIcon(mapaCanada);

			btnUEur = new JButton("Union Europea");
			btnUEur.addActionListener(this);
			btnUEur.setBackground(Color.white);
			btnUEur.setIcon(mapaEuropa);
			
			panelBtns.add(btnEu);
			panelBtns.add(btnCanada);
			panelBtns.add(btnUEur);
			add(panelBtns,"North");
			
			
			
		}
		
		JPanel panelConv = new JPanel();
		
		{
			panelConv.setLayout(new GridLayout(2,2));
			lblMex = new JLabel(mexicoLbl);
			lblMex.setOpaque(true);
			lblMex.setBackground(Color.green);

			txtPesos = new JTextField();
			JLabel pesos = new JLabel(getHtml("$"),JLabel.CENTER); 
			lblBandera = new JLabel(euLbl);
			lblBandera.setOpaque(true);
			lblBandera.setBackground(Color.yellow);
			txtMoneda = new JTextField();
			
			
			JPanel ptxt = new JPanel();
			
			pesos.setBounds(10,115,50,40);
			ptxt.setBackground(Color.green);
			txtPesos.setBounds(90, 130, 100, 20);
			ptxt.setLayout(null);
			ptxt.add(pesos);
			ptxt.add(txtPesos);
			
			JPanel ptxtM = new JPanel();
			ptxtM.setBackground(Color.yellow);
			moneda = new JLabel(getHtml("$US"),JLabel.LEFT);
			moneda.setBounds(0,115,70,40);
			txtMoneda.setBounds(90, 130, 100, 20);
			ptxtM.setLayout(null);
			ptxtM.add(moneda);
			ptxtM.add(txtMoneda);
			
			panelConv.add(lblMex);
			panelConv.add(ptxt);
			panelConv.add(lblBandera);
			panelConv.add(ptxtM);
			
			txtPesos.addKeyListener(kl);
			txtMoneda.addKeyListener(kl);
			add(panelConv,"Center");
			
			
			{
				JPanel sur = new JPanel();
				sur.setBackground(Color.white);
				sur.add(lblBefore = new JLabel(flechaI));
				sur.add(lblNext = new JLabel(flechaD));
				
				cl = new Click();
				lblBefore.addMouseListener(cl);
				lblNext.addMouseListener(cl);
				
				add(sur,"South");
			}
			
			//System.out.println(Float.parseFloat("5f")); No marca error
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() ==  btnEu)
		{
			lblBandera.setIcon(euLbl);
			valor = DOLAR;
			moneda.setText(getHtml("$US"));
		}
		
		else if(e.getSource() == btnCanada)
		{
			lblBandera.setIcon(canadaLbl);
			valor = DOLAR_CANADIENSE;
			moneda.setText(getHtml("C$"));
		}
		
		else if(e.getSource() == btnUEur)
		{
			lblBandera.setIcon(unionEurLbl);
			valor = EURO;
			moneda.setText(getHtml("€"));
		}
		
		convertirMonedaAPesos(pesosTocado ? txtPesos : txtMoneda);
	}
	
	
	boolean esFlotante(String txt)
	{
		try
		{
			conve = Float.parseFloat(txt);
			
			if(conve<0)
			{
				JOptionPane.showMessageDialog(this, "Los valores deben ser >= 0","Error",JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
			return true;
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this, "Solo datos numericos","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	void convertirMonedaAPesos(JTextField txtRef)
	{
		if(txtRef.getText().equals(""))
			return;
		
		if(esFlotante(txtRef.getText()))
		{
			if(!pesosTocado)
				txtPesos.setText((valor*conve)+"");
			else
				txtMoneda.setText((conve/valor)+"");
		}
		else txtRef.setText(txtRef.getText().substring(0,txtRef.getText().length()-1));
	}
	
	
	String getHtml(String base)
	{
		return "<html> <font size=50 style=Italic>" +base+ "</font> ";
	}
	
	public ImageIcon getImage(String nombre)
	{
		return new ImageIcon(getClass().getResource("/Unidad1P2/"+nombre));
	}
	
	boolean pesosTocado=true; 
	
	class Click extends MouseAdapter
	{
		@Override
		public void mousePressed(MouseEvent e) 
		{
			(( JLabel) e.getComponent()).setBorder(BorderFactory.createLineBorder(Color.black));
		}
		
		@Override
		public void mouseReleased(MouseEvent e) 
		{
			(( JLabel) e.getComponent()).setBorder(null);
		}
	}
	
	class KeyLisen extends KeyAdapter
	{
		@Override
		public void keyReleased(KeyEvent e) 
		{
			if(e.getSource() == txtMoneda)
			{
				pesosTocado=false;
				convertirMonedaAPesos(txtMoneda);
			}
			
			else
			{
				pesosTocado = true;
				convertirMonedaAPesos(txtPesos);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() 
			{
				new Practica1().setVisible(true);
			}
		});
	}
}
