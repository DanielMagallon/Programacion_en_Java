package C12Evalucacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import C12GUI.BorderlLayoutFrame;

public class NumberGame extends JFrame
{
	private JLabel labelOrder,labelGame;
	private JTextField textNum;
	private JPanel panelOrder,panelGame,panelInput,panelRestart;
	private JButton btnRestart;
	private GridLayout gridLa;
	
	public NumberGame()
	{
	   super("Game Number");
	   
	   panelOrder=new JPanel();
	   gridLa= new GridLayout(3,1,5,5);
	   panelOrder.setLayout(new GridLayout(2,1,2,2));
	   setLayout(gridLa);
	   
	   labelOrder = new JLabel("Write the number you guess: ");
	   
	   
	   textNum=new JTextField(10);
	   
	   panelInput=new JPanel();
	   panelInput.setLayout(new FlowLayout());
	   
	   panelOrder.add(labelOrder);
	   panelInput.add(textNum);
	   panelOrder.add(panelInput);
	   
	   panelGame=new JPanel();
	   panelGame.setLayout(new BorderLayout());
	   
	   labelGame=new JLabel("Come On");
	   labelGame.setOpaque(true);
	   
	   btnRestart=new JButton("Restart Game");
	   panelGame.add(labelGame);
	  
	   panelRestart=new JPanel();
	   panelRestart.setLayout(new FlowLayout());
	   panelRestart.add(btnRestart);
	   
	   add(panelOrder);
	   add(panelGame);
	   add(panelRestart);
	   
	   labelGame.setBackground(Color.BLUE);
	}
}
