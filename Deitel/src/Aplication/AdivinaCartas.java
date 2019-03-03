package Aplication;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AdivinaCartas extends JFrame implements ActionListener
{
	String[] animals = {"dog","elephant","fish","owl"};
	JButton btnAnimals[];
	JPanel panelDraw;
	Random lb = new Random();
	JLabel anAnim;
	final int SIZE;
	public AdivinaCartas()
	{
		SIZE = animals.length;
		setLayout(new BorderLayout());
		panelDraw=new JPanel();
		panelDraw.setLayout(new GridLayout(SIZE/2, SIZE/2, 10, 10));
		btnAnimals = new JButton[SIZE];

		anAnim = new JLabel();
		setTextRandom();
		add(anAnim, BorderLayout.NORTH);
		add(panelDraw, BorderLayout.CENTER);
		addButton();
		setDefaultCloseOperation(2);
		setSize(500,500);
	}
	
	private void addButton()
	{
		for (int i=0; i<animals.length; i++)
		{
			btnAnimals[i] = new JButton();
			btnAnimals[i].setIcon(new ImageIcon(AdivinaCartas.class.getResource
		    ("/Aplication/images/"+animals[i]+".png")));
			btnAnimals[i].addActionListener(this);
			panelDraw.add(btnAnimals[i]);
		}
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new AdivinaCartas().setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String anim="";
		
		if(e.getSource() == btnAnimals[0])
			anim=animals[0];
		
		if (e.getSource()  == btnAnimals[1])
			anim=animals[1];
		
		if (e.getSource()  == btnAnimals[2])
			anim=animals[2];
		
		if (e.getSource()  == btnAnimals[3])
			anim=animals[3];
		
		checkOut(anim);
	}
	
	private void checkOut(String an)
	{
		int num;
		
		String is = (an==anAnim.getText()) ? "This is " : "This isn´t ";
		num = (an==anAnim.getText()) ? 1 : 0;
		
		JOptionPane.showMessageDialog(this, is + startWithVocal(anAnim.getText()), "Mensaje",
				num);
		setTextRandom();
	}
	
	private void setTextRandom()
	{
		anAnim.setText(animals[lb.nextInt(SIZE)]);
	}
	
	private String startWithVocal(String n)
	{
		String vocals[] = {"a","e","i","o","u"};
		
		for (String v : vocals)
			if (n.startsWith(v))
				return "an "+n;
		
		return "a "+n;
	}
}
