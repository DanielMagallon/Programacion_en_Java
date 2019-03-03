package ImageMoved;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ImageMoved extends JFrame implements MouseMotionListener
{

	private JPanel contentPane;
	Graphics graficos;
	JPanel panelDibujo;
	int x=0,y=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageMoved frame = new ImageMoved();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ImageMoved() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelDibujo = new JPanel();
		contentPane.add(panelDibujo, BorderLayout.CENTER);
		contentPane.addMouseMotionListener(this);
		panelDibujo.paint(getGraphics());
		panelDibujo.getGraphics().fillRect(x, y, 20, 20);
		//System.out.println(graficos);
	}

	
	public void dibujar()
	{
		graficos.fillRect(x, y, 20, 20);
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		graficos.translate(e.getX(), e.getY());
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
