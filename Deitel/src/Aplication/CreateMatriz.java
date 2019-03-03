package Aplication;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateMatriz implements KeyListener
{
	private static JTextField matrizA[][];
	private static JTextField matrizB[][];
	private static JTextField matrizC[][];
	private static final int SUMAR = 1;
	private static final int RESTAR = 2;
	private static final int MULTIPLICAR = 3;
	static JPanel panels[];
	private static boolean canMultiply=false, canPlusMin;
	private static Random lb = new Random();
	
	public CreateMatriz(int filasMA, int columnasMA, int filasMB, int columnasMB)
	{
		matrizA = new JTextField[filasMA][columnasMA];
		matrizB = new JTextField[filasMB][columnasMB];
		matrizC = new JTextField[filasMA][columnasMB];
		
		panels = new JPanel[]{Principal.panelMA, Principal.panelMB, Principal.panelMC};
		
		panels[0].setLayout(new GridLayout(filasMA,columnasMA,10,10));
		panels[1].setLayout(new GridLayout(filasMB,columnasMB,10,10));
		panels[2].setLayout(new GridLayout(filasMA, columnasMB, 10, 10));
	
		canPlusMin = (filasMA == filasMB) && (columnasMA == columnasMB);
		canMultiply = columnasMA == filasMB;
		
		createTextFieldOnPanel();
		enabledMC();
	}
	
	public static void generateNumberRandonm(int rango)
	{
		for (JTextField[] mA : matrizA)
			for (JTextField mB : mA)
				mB.setText(""+lb.nextInt(rango));
		
		for (JTextField[] mB : matrizB)
			for (JTextField m : mB)
				m.setText(""+lb.nextInt(rango));
	}
	
	private static void enabledMC()
	{
		for (JTextField mcs[] : matrizC)
			for (JTextField mc : mcs)
				mc.setEnabled(false);
		
	}
	
	private void createTextFieldOnPanel()
	{
		for (int i=0; i<panels.length; i++)
		{
			panels[i].removeAll();
			createMPanel(panels[i],(i==0) ? matrizA : (i==1) ? matrizB : matrizC);
			panels[i].repaint();
			panels[i].validate();
		}
	}
	
	private void createMPanel(JPanel p, JTextField matriz[][])
	{
		for (int i=0; i<matriz.length; i++)
		{
			for (int j=0; j<matriz[i].length; j++)
			{
				matriz[i][j] = new JTextField("0");
				matriz[i][j].addKeyListener(this);
				matriz[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				p.add(matriz[i][j]);
			}
			
		}
	}
	
	public static boolean sumar()
	{
		if(canPlusMin)
		{
			getValors(SUMAR);
			return true;
		}
		
		return false;
	}
	
	public static boolean restar()
	{
		if(canPlusMin)
		{
			getValors(RESTAR);
			return true;
		}
		
		return false;
	}
	
	public static boolean multiplicar()
	{
		if(canMultiply)
		{
			getValors(MULTIPLICAR);
			return true;
		}
		
		return false;
	}
	
	private static void getValors(int op)
	{
		if(validarText())
		{
		if(op!=MULTIPLICAR)
		for (int i=0; i<matrizA.length; i++)
			for (int j=0; j<matrizA[i].length; j++)
				matrizC[i][j].setText("" + getOperation(matrizA[i][j], matrizB[i][j], op));
		
		else 
			for (int i=0; i<matrizC.length; i++)
				for (int j=0; j<matrizC[i].length; j++)
					matrizC[i][j].setText(""+getValorFC(i,j));
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "Solo se aceptan numeros enteros","ERROR",
					  JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private static int getValorFC(int fila, int col)
	{
		int result=0;
		
		for (int i=0; i<matrizB.length; i++)
			result += (convert(matrizA[fila][i].getText()) * convert(matrizB[i][col].getText()));
			
		return result;
	}
	
	private static int getOperation(JTextField textMA, JTextField textMB, int operacion)
	{
		if(operacion==SUMAR)
		return convert(textMA.getText()) + convert(textMB.getText());
		
		else 
		return convert(textMA.getText()) - convert(textMB.getText());
	}
	
	private static int convert(String textMat)
	{
		return Integer.parseInt(textMat);
	}
	
	private static boolean validarText()
	{
		boolean isValideNum=true;
		boolean isValidNumMB=true;
		
		for (JTextField[] mats : matrizA)
			for (JTextField mat : mats)
			{
				if(!isNumber(mat.getText()))
				{
					mat.setForeground(Color.RED);
					isValideNum=false;
				}	
				
			}
		
		for (JTextField[] mats : matrizB)
			for (JTextField mat : mats)
			{
				if(!isNumber(mat.getText()))
				{
					mat.setForeground(Color.RED);
					isValidNumMB=false;
				}	
				
			}
			
		return isValideNum && isValidNumMB;
	}
	
	private static boolean isNumber(String text)
	{
		return text.matches("[+|-]?[0-9]+");
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
