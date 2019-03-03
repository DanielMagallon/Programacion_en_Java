package C12GUI;

import javax.swing.*;
import javax.swing.table.*;

public class Ejm04_BloquearEdicionJTable extends JFrame
{
	 public Ejm04_BloquearEdicionJTable()
	    {
	 
	        JTable tblEjemplo = new JTable();
	        JScrollPane scpEjemplo= new JScrollPane();
	 
	        //Llenamos el modelo
	        DefaultTableModel dtmEjemplo = new DefaultTableModel(getFilas(),
	                                                             getColumnas());
	 
	        tblEjemplo=new JTable(dtmEjemplo){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	        }}; //return false: Desabilitar edición de celdas.
	 
	        tblEjemplo.setModel(dtmEjemplo);
	        scpEjemplo.add(tblEjemplo);
	        this.add(scpEjemplo);
	        this.setSize(500, 200);
	        scpEjemplo.setViewportView(tblEjemplo);
	 
	    }
	 
	 private Object[][] getFilas()
	    {
	         Object fila[][]=new Object[][] {
	                            {"a1", "b1", "c1", "d1"},
	                            {"a2", "b2", "c2", "d2"},
	                            {"a3", "b3", "c3", "d3"}};
	         return fila;
	    }
	 
	    //Encabezados de la tabla
	    private String[] getColumnas()
	    {
	          String columna[]=new String[]{"A","B","C", "D"};
	          return columna;
	    }
	 
	    public static void main(String args[]) {
	        Ejm04_BloquearEdicionJTable obj = new Ejm04_BloquearEdicionJTable();
	        obj.setVisible(true);
	    }
}
