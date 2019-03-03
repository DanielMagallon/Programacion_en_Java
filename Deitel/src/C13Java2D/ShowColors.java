package C13Java2D;

import javax.swing.JFrame;

public class ShowColors 
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Using Colors");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ColorJPanel app = new ColorJPanel();
		frame.add(app);
		frame.setSize(400, 180);
		frame.setVisible(true);
	   System.out.println("ShowColors.main()");
	   
	}
}
