package C16Recursion;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fractal extends JFrame
{
	private static final int WIDTH = 400;
	private static final int HEIGHT = 480;
	private static final int MIN_LEVEL = 0, MAX_LEVEL= 15;
	
	private JButton changeColor, increaseLevel,decreaseLevel;
	private JLabel levelJLabel;
	private FractalJPanel drawSpace;
	private JPanel mainPanel,controlPanel;
	
	public Fractal()
	{
		super("Fractal");
		
		//drawSpace.repaint();
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		
		changeColor = new JButton("Color");
		controlPanel.add(changeColor);
		changeColor.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Color color = JColorChooser.showDialog(Fractal.this, "Chose a color"
						,Color.BLUE);
				
				if(color==null)
					color = Color.BLUE;
				
				drawSpace.setColor(color);
			}
		});
		
		decreaseLevel=new JButton("Decrease Level");
		controlPanel.add(decreaseLevel);
		decreaseLevel.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int level = drawSpace.getLevel();
				--level;
				
				if(level>= MIN_LEVEL && level <= MAX_LEVEL)
				{
					levelJLabel.setText("Level: "+level);
					drawSpace.setLevel(level);
					repaint();
				}
			}
		});
		
		increaseLevel = new JButton("Increase Level");
		controlPanel.add(increaseLevel);
		increaseLevel.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int level = drawSpace.getLevel();
				++level;
				
				if(level >= MIN_LEVEL && level <= MAX_LEVEL)
				{
					levelJLabel.setText("Level: "+level);
					drawSpace.setLevel(level);
					repaint();
				}
			}
		});
		
		levelJLabel = new JLabel("Level: 0");
		controlPanel.add(levelJLabel);
		drawSpace = new FractalJPanel(0);
		mainPanel = new JPanel();
		mainPanel.add(controlPanel);
		mainPanel.add(drawSpace);
		
		add(mainPanel);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Fractal demo = new Fractal();
		demo.setDefaultCloseOperation(3);
	}
}
