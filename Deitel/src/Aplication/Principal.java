package Aplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener
{

	private JPanel contentPane;
	public static JComboBox combosMat[];
	private JComboBox comboMAF,comboMBF,comboMAC,comboMBC;
	private JButton btnNewButton;
	public static JPanel panelMA, panelMB, panelMC;
	private JButton btnSumar,btnRestar,btnMultiplicar, btnAlea;
	private boolean estaCreado=false;
	/**
	 * Create the frame.
	 */
	public Principal()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelMA = new JPanel();
		panelMA.setBounds(10, 152, 253, 176);
		contentPane.add(panelMA);
		
		JPanel panel = new JPanel();
		panel.setBounds(78, 0, 663, 141);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matriz A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 78, 49);
		panel.add(lblNewLabel);
		
		JLabel lblMatrizB = new JLabel("Matriz B");
		lblMatrizB.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatrizB.setBounds(0, 41, 78, 49);
		panel.add(lblMatrizB);
		
		comboMAF = new JComboBox();
		comboMAF.setModel(new DefaultComboBoxModel
				(new String[] {"Seleccione las filas", "1", "2", "3", "4", "5"}));
		comboMAF.setBounds(88, 14, 142, 20);
		panel.add(comboMAF);
		
		comboMBF = new JComboBox();
		comboMBF.setModel(new DefaultComboBoxModel
				(new String[] {"Selecciones las filas", "1", "2", "3", "4", "5"}));
		comboMBF.setBounds(88, 55, 142, 20);
		panel.add(comboMBF);
		
		comboMAC = new JComboBox();
		comboMAC.setModel(new DefaultComboBoxModel
				(new String[] {"Selecciones las columnas", "1", "2", "3", "4", "5"}));
		comboMAC.setBounds(233, 14, 181, 20);
		panel.add(comboMAC);
		
		comboMBC = new JComboBox();
		comboMBC.setModel(new DefaultComboBoxModel
				(new String[] {"Selecciones las columnas", "1", "2", "3", "4", "5"}));
		comboMBC.setBounds(233, 55, 181, 20);
		panel.add(comboMBC);
		
		btnNewButton = new JButton("Crear Matriz");
		btnNewButton.setBounds(41, 101, 114, 29);
		panel.add(btnNewButton);
		
		btnSumar = new JButton("Sumar");
		btnSumar.setBounds(451, 14, 89, 34);
		panel.add(btnSumar);
		
		btnRestar = new JButton("Restar");
		btnRestar.setBounds(564, 15, 89, 34);
		panel.add(btnRestar);
		
		btnMultiplicar = new JButton("Multiplicar");
		btnMultiplicar.setBounds(516, 74, 114, 34);
		panel.add(btnMultiplicar);
		
		btnAlea = new JButton("Generacion Aleatoria");
		btnAlea.setBounds(223, 104, 173, 23);
		panel.add(btnAlea);
		
		panelMB = new JPanel();
		panelMB.setBounds(281, 152, 253, 176);
		contentPane.add(panelMB);
		
		panelMC = new JPanel();
		panelMC.setBounds(546, 152, 253, 176);
		contentPane.add(panelMC);
	
		btnNewButton.addActionListener(this);
		btnSumar.addActionListener(this);
		btnRestar.addActionListener(this);
		btnMultiplicar.addActionListener(this);
		btnAlea.addActionListener(this);
		//setActionPerformed();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnNewButton)
			createMz();
		
		else if(estaCreado)
		{
		if (e.getSource()== btnSumar)
		{
			if (!CreateMatriz.sumar())
				JOptionPane.showMessageDialog(this, "No es posible sumar las matrices",
						"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (e.getSource()== btnRestar)
		{
			
			if (!CreateMatriz.restar())
				JOptionPane.showMessageDialog(this, "No es posible restar las matrices",
						"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		else if(e.getSource() == btnMultiplicar)
		{
			if (!CreateMatriz.multiplicar())
				JOptionPane.showMessageDialog(this, "No es posible multiplicar las matrices",
						"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		else 
		{
			int x = Integer.parseInt(
					JOptionPane.showInputDialog(null,"Introduzca un rango","MODO RANDOM",JOptionPane.QUESTION_MESSAGE));
			
			CreateMatriz.generateNumberRandonm(x);
		}
		}
		else
			JOptionPane.showMessageDialog(null, "Aun no se ha creado la matriz","ERROR",
						JOptionPane.WARNING_MESSAGE);
	}

	private void createMz()
	{
		int MAF;
		int MAC;
		int MBF;
		int MBC;
		
		MAF = converAndGetItem(comboMAF);
		MAC = converAndGetItem(comboMAC);
		MBF = converAndGetItem(comboMBF);
		MBC = converAndGetItem(comboMBC);
		
		if(MAF != -1 && MAC != -1 && MBF != -1 && MBC != -1)
		{
			new CreateMatriz(MAF,MAC,MBF,MBC);
			estaCreado=true;
		}
		
		else
		JOptionPane.showMessageDialog(null, "No se han especificado coorectamente las matrices","ADVERTENCIA",
					JOptionPane.WARNING_MESSAGE);
		
	}
	
	private int converAndGetItem(JComboBox combo)
	{
		try
		{
		return Integer.parseInt(combo.getSelectedItem().toString());
		}
		catch (NumberFormatException e){
			return -1;
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
