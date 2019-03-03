package C13Java2D;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowColors2JFrame extends JFrame
{
	private JButton changeColorBoton;
	private Color color = Color.LIGHT_GRAY;
	private JPanel panel;
	
	public ShowColors2JFrame()
	{
		super("Using JColorChoooser");
		
		panel = new JPanel();
		panel.setBackground(color);
		
		changeColorBoton = new JButton("Change Color");
		changeColorBoton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				color = JColorChooser.showDialog(ShowColors2JFrame.this, 
						"Choose a color", color);
				
				if(color==null)
					color=Color.LIGHT_GRAY;
				
				panel.setBackground(color);
			}
		});
		
		add(panel, BorderLayout.CENTER);
		add(changeColorBoton, BorderLayout.SOUTH);
		
		setSize(400,130);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new ShowColors2JFrame();
	}
}
