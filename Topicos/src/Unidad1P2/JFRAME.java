package Unidad1P2;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class JFRAME extends JFrame 
{
	private static final long serialVersionUID = 2482645071465852278L;
	
	ImageIcon img;
	Image img2;
	JButton btn1,btn2,btn3;
	JToolBar barraHerr;
	JMenuBar menuBar  = new JMenuBar();
	
	public JFRAME() 
	{
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(600, 600);
//		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Que onda prro");
		
		URL url = getClass().getResource("/Unidad1P2/dalas1.jpg");
		
//		Toolkit tk = getToolkit();
//		img2 = tk.getImage(url);
		
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Arch");
//		menu.setIcon(new ImageIcon(getClass().getResource("/Unidad1/Recursos/im1.jpg")));
		menuBar.add(menu);
		JMenu menu2 = new JMenu("Arch2");
		menuBar.add(menu2);
		
		JMenuItem mI = new JMenuItem("Jalo2");
		//Si ponemos r por si solo, tenemos que teclear la r en minuscula o ayusucla segun correspnda
		mI.setAccelerator(KeyStroke.getKeyStroke('r',InputEvent.CTRL_MASK));
		mI.addActionListener(
				
					(e) -> JOptionPane.showMessageDialog(this, "TEceo jalo2")
				
				);
		
		menu.add(mI);
		
		
		img = new ImageIcon(url);
		img2 = img.getImage();

		
		btn1 = new JButton(
				
				new ImageIcon(getClass().getResource("/Unidad1P2/Cuadro.png"))
				
				) ;
		
		
		btn1.setToolTipText("Este boton dibuja un cuadro papu");
		btn1.setMnemonic('C');
		
		btn2 = new JButton(
				
				new ImageIcon(getClass().getResource("/Unidad1P2/rect.png"))
				
				);
		
		btn2.setToolTipText("Este boton dibuja un rectngulo papu");
		
		btn3 = new JButton(
				
				new ImageIcon(getClass().getResource("/Unidad1P2/recr.png"))
				
				);
		
		btn3.setToolTipText("Este boton dibuja un roundrec papu");
		
		
		barraHerr= new JToolBar("Figuras",JToolBar.VERTICAL);
		barraHerr.add(btn1);
		barraHerr.add(btn2);
		barraHerr.add(btn3);
//		JPanel up= new JPanel();
		
		add("West",barraHerr);
	/*	up.add(btn1);
		up.add(btn2);
		up.add(btn3);*/
		
		setVisible(true);
		
	}
	

	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		//img.paintIcon(this, g, 0, 0);
//		g.drawImage(img2, 0, 0,700 ,300,this);
	}
	
	public static void main(String[] args) 
	{

		SwingUtilities.invokeLater(new Runnable() 
		{
			
			@Override
			public void run() 
			{
				
				new JFRAME();
			}
		});
	}
}

