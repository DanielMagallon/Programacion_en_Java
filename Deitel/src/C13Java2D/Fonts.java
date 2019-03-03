package C13Java2D;

import javax.swing.JFrame;

public class Fonts
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(2);
		
		FontJPanel panel = new FontJPanel();
		frame.add(panel);
		frame.setSize(420, 150);
		frame.setVisible(true);
	}
}
