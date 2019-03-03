package C12GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListFrame extends JFrame
{
	private JList colorList;
	
	private static final String[] colorNames=
		{"Black","Blue","Cyan","Dark Gray","Gray","Green",
		 "Light Gray","Magenta","Orange","Pink","Red",
		 "White","Yellow"};
	
	private static final Color[] colors=
		{Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
		 Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
		 Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	
	public ListFrame()
	{
		super("List Test");
		setLayout(new FlowLayout());
		
		colorList=new JList(colorNames);
		colorList.setVisibleRowCount(5);
		
		colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		add(new JScrollPane(colorList));
		
		colorList.addListSelectionListener(
				new ListSelectionListener()
				{
					@Override
					public void valueChanged(ListSelectionEvent e)
					{
						getContentPane().setBackground(
								colors[colorList.getSelectedIndex()]);

					}
				});
		addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent e)
			{
				System.out.println("Widt: "+getSize());
				System.out.println("Widt: "+getWidth());
				System.out.println("High_: "+getHeight());
			}
		});
	}
	
}
