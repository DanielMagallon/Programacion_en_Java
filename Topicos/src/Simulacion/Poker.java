package Simulacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import static Simulacion.MathData.valoresXi;

public class Poker extends JDialog
{
	private String[] seedsBydigits;
	
	public JTable[] tablas;
	private DefaultTableModel[] models;
	
	private int i,j;
	
	private LinkedHashMap<Integer, Integer>[] digitos5d,digitos4d,digitos3d;
	
	public int[] frecuenciasCategoria5;
	public int[] frecuenciasCategoria4;
	public int[] frecuenciasCategoria3;
	
	private BigDecimal n; 
	
	public Poker()
	{
		setTitle("Prueba Poker");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		
		
		build();
		
		JPanel centro = new JPanel();
		
		{
			centro.setLayout(new GridLayout(3,1,10,10));
			JScrollPane sc1 = new JScrollPane(tablas[0]);
			JScrollPane sc2 = new JScrollPane(tablas[1]);
			JScrollPane sc3 = new JScrollPane(tablas[2]);
			
			centro.add(sc1);
			centro.add(sc2);
			centro.add(sc3);
			
			add(centro,"Center");
		}
		
		JPanel up = new JPanel();
		
		{
			add(up,"North");
		}
		
		JPanel down = new JPanel();
		
		{
			add(down,"South");
		}
		
	}
	
	public BigDecimal getProbabilty(int decim,int cat)
	{	
		if(decim==5)
		{
			switch(cat)
			{
				case 0:
					return new BigDecimal("0.3024");
					
				case 1:
					return new BigDecimal("0.5040");
					
				case 2:
					return new BigDecimal("0.1080");
					
				case 3:
					return new BigDecimal("0.0090");
					
				case 4:
					return new BigDecimal("0.0720");
					
				case 5:
					return new BigDecimal("0.0045");
					
				default:
					return new BigDecimal(".0001");
			}
		}
		
		else if(decim==4)
		{
			switch(cat)
			{
				case 0:
					return new BigDecimal("0.5040");
					
				case 1:
					return new BigDecimal("0.4320");
					
				case 2:
					return new BigDecimal("0.0270");
					
				case 3:
					return new BigDecimal("0.0360");
					
				default:
					return new BigDecimal(".0100");
			}
		}
		
		else
		{
			switch(cat)
			{
				case 1:
					return new BigDecimal("0.72");
					
				case 2:
					return new BigDecimal("0.27");
					
				default:
					return new BigDecimal(".01");
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void generar()
	{
		digitos5d = new LinkedHashMap[valoresXi.length];
		digitos4d = new LinkedHashMap[valoresXi.length];
		digitos3d = new LinkedHashMap[valoresXi.length];
		n = new BigDecimal(valoresXi.length);
		
		for(i=0; i<valoresXi.length; i++)
		{
			digitos3d[i] = new LinkedHashMap<Integer, Integer>();
			digitos4d[i] = new LinkedHashMap<Integer, Integer>();
			digitos5d[i] = new LinkedHashMap<Integer, Integer>();
		}
		
		seedsBydigits  = new String[valoresXi.length];
		
		StringBuilder num = new StringBuilder();
		
		for(j=0; j<valoresXi.length; j++)
		{
			
			num.append(valoresXi[j]);
			
			while(num.length()>7)
			{
				num.deleteCharAt(num.length()-1);
			}
			
			while(num.length()<7)
			{
				num.append("0");
			}
			
			seedsBydigits[j] = num.toString();
			
			num.setLength(0);
		}
		
		count();
		countCategorias();
		valoresTablas();
		
	}
	
	private void valoresTablas()
	{
		BigDecimal Ei,x2,suma5 = BigDecimal.ZERO,suma4=BigDecimal.ZERO,
				suma3=BigDecimal.ZERO;
		
		for(i=0; i<frecuenciasCategoria5.length; i++)
		{
			if(i<=2)
			{
				Ei = getProbabilty(3, i).multiply(n);
				x2 = Ei.subtract(new BigDecimal(frecuenciasCategoria3[i])).pow(2).divide
						(Ei,5,RoundingMode.HALF_EVEN);
				suma3 = suma3.add(x2);
				models[2].setValueAt(frecuenciasCategoria3[i], i, 1);
				models[2].setValueAt(Ei, i, 2);
				models[2].setValueAt(x2, i, 3);
			}
			
			if(i<=4)
			{
				Ei = getProbabilty(4, i).multiply(n);
				x2 = Ei.subtract(new BigDecimal(frecuenciasCategoria4[i])).pow(2).divide
						(Ei,5,RoundingMode.HALF_EVEN);
				suma4=suma4.add(x2);
				models[1].setValueAt(frecuenciasCategoria4[i], i, 1);
				models[1].setValueAt(Ei, i, 2);
				models[1].setValueAt(x2, i, 3);
			}
			
			Ei = getProbabilty(5, i).multiply(n);
			x2 = Ei.subtract(new BigDecimal(frecuenciasCategoria5[i])).pow(2).divide
					(Ei,5,RoundingMode.HALF_EVEN);
			suma5=suma5.add(x2);
			models[0].setValueAt(frecuenciasCategoria5[i], i, 1);
			models[0].setValueAt(Ei, i, 2);
			models[0].setValueAt(x2, i, 3);
		
		}
		
		models[0].setValueAt(suma5, 7, 3);
		models[1].setValueAt(suma4, 5, 3);
		models[2].setValueAt(suma3, 3, 3);
	}
	
	private void count()
	{
		
		int key;
		
		for(i=0; i<seedsBydigits.length; i++)
		{
			for(j=2; j<seedsBydigits[i].length(); j++)
			{
				key = Integer.parseInt(seedsBydigits[i].charAt(j)+"");
				
				//3d
				if(j<=4)
				{
					if(digitos3d[i].containsKey(key))
					{
						digitos3d[i].replace(key, (digitos3d[i].get(key)+1));
					}
					else digitos3d[i].put(key, 1);

				}
				
				//4d
				if(j<=5)
				{
					if(digitos4d[i].containsKey(key))
					{
						digitos4d[i].replace(key, (digitos4d[i].get(key)+1));
					}
					else digitos4d[i].put(key, 1);

				}
				
				//5d
				if(digitos5d[i].containsKey(key))
				{
					digitos5d[i].replace(key, (digitos5d[i].get(key)+1));
				}
				else digitos5d[i].put(key, 1);
			}
		}
	}
	
	
	
	private void build()
	{
		models = new DefaultTableModel[3];
		tablas = new JTable[3];
		
		frecuenciasCategoria5 = new int[7];
		frecuenciasCategoria4 = new int[5];
		frecuenciasCategoria3 = new int[3];
		
		String reng[][] =
			{
					{"TD","1Par","2Pares","Tercia","Tercia Par","Poker","Quintilla",""},
					{"TD","1Par","2Pares","Tercia","Poker",""},
					{"TD","1Par","Tercia",""},
			};
		
		for(i=0; i<3; i++)
		{
			models[i] = new DefaultTableModel();
			models[i].addColumn("Categoria");
			models[i].addColumn("Oi");
			models[i].addColumn("Ei");
			models[i].addColumn("X²o");
			
			tablas[i] = new JTable(models[i]);
			
			for(j=0; j<reng[i].length; j++)
				models[i].addRow(new Object[] {reng[i][j]});
		}
		
		models[0].setValueAt("Σ:", 7, 2);
		models[1].setValueAt("Σ:", 5, 2);
		models[2].setValueAt("Σ:", 3, 2);		
		
		
	}
	
	
	
	private void countCategorias()
	{
		for(i=0; i<frecuenciasCategoria5.length;i++)
		{
			if(i<=4)
			{
				frecuenciasCategoria4[i]=0;
			}
			
			if(i<=2)
			{
				frecuenciasCategoria3[i]=0;
			}
			
			frecuenciasCategoria5[i] = 0;
		}
		
		for(i=0; i<digitos5d.length; i++)
		{
			switch(digitos5d[i].size())
			{
				 case 5:
					 frecuenciasCategoria5[0]++;
					 break;
					 
				 case 4:
					 frecuenciasCategoria5[1]++;
					 break;
					 
				 case 3:
					 int suma=0;
					 
					 for(Integer k : digitos5d[i].keySet())
					 {
						 if(digitos5d[i].get(k)!=1)
						 {
							 suma+=digitos5d[i].get(k);
						 }
					 }
					 
					 if(suma==4)
						 frecuenciasCategoria5[2]++;
					 
					 else 
						 frecuenciasCategoria5[3]++;
					 
					 break;
					 
				 case 2:
					 
					 suma=0;
					 
					 for(Integer k : digitos5d[i].keySet())
					 {
						 if(digitos5d[i].get(k)!=1)
						 {
							 suma+=digitos5d[i].get(k);
						 }
					 }
					 
					 if(suma==5)
						 frecuenciasCategoria5[4]++;
					 
					 else 
						 frecuenciasCategoria5[5]++;
					 
					 break;
					 
					default:
						frecuenciasCategoria5[6]++;
			}
			
			switch(digitos4d[i].size())
			{
				case 4:
					frecuenciasCategoria4[0]++;
					break;
					
				case 3:
					frecuenciasCategoria4[1]++;
					break;
					
				case 2:
					
					int suma=0;
					 
					 for(Integer k : digitos4d[i].keySet())
					 {
						 if(digitos4d[i].get(k)!=1)
						 {
							 suma+=digitos4d[i].get(k);
						 }
					 }
					
					 if(suma==4)
						 frecuenciasCategoria4[2]++;
					 
					 else frecuenciasCategoria4[3]++;
					 
					break;
					
				
				default:
					frecuenciasCategoria4[4]++;
			}
			
			switch(digitos3d[i].size())
			{
				case 3:
					frecuenciasCategoria3[0]++;
					break;
					
				case 2:
					frecuenciasCategoria3[1]++;
					break;
					
				default:
					frecuenciasCategoria3[2]++;
					
			}
		}
		
	}
}
