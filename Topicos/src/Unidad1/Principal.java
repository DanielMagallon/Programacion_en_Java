package Unidad1;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


import javax.swing.*;


public class Principal extends JApplet {
 
 Clipboard portapapeles;
 Transferable datos;
 JTextArea txt;
 JPanel pbotones;
 
 public void init(){
  
  setLayout(new BorderLayout());
  txt=new JTextArea();
  txt.setWrapStyleWord(true);
  txt.setLineWrap(true);
  pbotones=new JPanel();
  JButton copiar=new JButton("Copiar");
  copiar.addActionListener(new ActionListener(){


   @Override
   public void actionPerformed(ActionEvent e) {
    copiarAlPortapapeles();
   }
   
  });
  JButton pegar=new JButton("Pegar");
  pegar.addActionListener(new ActionListener(){


   @Override
   public void actionPerformed(ActionEvent e) {
    obtenerDatosPortapapeles();
   }
   
  });
  
  pbotones.add(copiar);
  pbotones.add(pegar);
  add(new JScrollPane(txt));
  add(pbotones,BorderLayout.SOUTH);
 }
 
 public void obtenerDatosPortapapeles(){
  portapapeles=Toolkit.getDefaultToolkit().getSystemClipboard();
  datos=portapapeles.getContents(null);
  if(datos.isDataFlavorSupported(DataFlavor.stringFlavor)){
   try {
    txt.setText(""+datos.getTransferData(DataFlavor.stringFlavor));
   } catch (UnsupportedFlavorException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }
 }
 
 public void copiarAlPortapapeles(){
  portapapeles=Toolkit.getDefaultToolkit().getSystemClipboard();
  StringSelection texto=new StringSelection(""+txt.getText());
  portapapeles.setContents(texto, texto);
  txt.setText("");
 }
}