package SimpleTron;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class Content extends JPanel
{
	public JTextPane flujo,consola;

	/**
	 * Create the panel.
	 */
	public Content()
	{
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		flujo = new JTextPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(flujo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(flujo, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		
		consola = new JTextPane();
		consola.setForeground(Color.RED);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(consola, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(consola, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);

	}
	
	public String getTextFlujo()
	{
		return flujo.getText();
	}
	
	//public static String get
}
