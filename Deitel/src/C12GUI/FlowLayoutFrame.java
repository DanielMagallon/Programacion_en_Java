package C12GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutFrame extends JFrame
{
	private JButton leftButton;
	private JButton centerButton;
	private JButton rightButton;
	private FlowLayout layout;
	private Container container;
	
	public FlowLayoutFrame()
	{
		super("Flow Layout Demo");
		
		layout=new FlowLayout();
		container=getContentPane();
		setLayout(layout);
		
		leftButton=new JButton("Left");
		add(leftButton);
		leftButton.addActionListener(
				new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				layout.setAlignment(FlowLayout.LEFT);
				
				layout.layoutContainer(container);
				
			}
		});
		
		centerButton=new JButton("Center");
		add(centerButton);
		centerButton.addActionListener(
				new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				layout.setAlignment(FlowLayout.CENTER);
				
				layout.layoutContainer(container);
				
			}
		});
		
		rightButton=new JButton("Right");
		add(rightButton);
		rightButton.addActionListener(
				new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				layout.setAlignment(FlowLayout.RIGHT);
				
				layout.layoutContainer(container);
				
			}
		});
	}
}
