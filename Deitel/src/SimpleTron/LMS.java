package SimpleTron;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

public class LMS extends JFrame
{

	private JPanel contentPane;
	public static List <Content> principal = new ArrayList<>(); 
	private static JTabbedPane tab;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					LMS frame = new LMS();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LMS()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 384);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("H");
		tglbtnNewToggleButton.setHorizontalAlignment(SwingConstants.LEFT);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
				.addComponent(tab, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(270, Short.MAX_VALUE)
					.addComponent(tglbtnNewToggleButton, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(61))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tab, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(tglbtnNewToggleButton)
					.addContainerGap())
		);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				compile();
			}
		});
		btnNewButton.setIcon(new ImageIcon(LMS.class.getResource("/SimpleTron/Images/compile.png")));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(LMS.class.getResource("/SimpleTron/Images/run.png")));
		toolBar.add(btnNewButton_1);
		contentPane.setLayout(gl_contentPane);
		
		addNewWindow();
		addNewWindow();
	}
	
	private void addNewWindow()
	{
		principal.add(new Content());
		tab.addTab("Pestania "+principal.size(), principal.get(principal.size()-1));
	}
	
	private static void compile()
	{
		String cad=principal.get(tab.getSelectedIndex()).getTextFlujo();
		Intrucciones.Compilar(cad, tab.getSelectedIndex());
	}
	
	private void execute()
	{
		
	}
}
