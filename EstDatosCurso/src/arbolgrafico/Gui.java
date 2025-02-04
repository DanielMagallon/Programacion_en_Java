/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolgrafico;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

/**
 *
 * @author ploks
 */
public class Gui extends javax.swing.JFrame {

    private SimuladorArbolBinario simulador = new SimuladorArbolBinario();

    /**
     * Creates new form Gui
     */
    public Gui() {
        initComponents();
        this.inicializar(false);
        PanelFondo F = new PanelFondo();
        this.add(F, BorderLayout.CENTER);
        this.pack();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/LogoMB.png"));
        setIconImage(icon);

    }

    private void inicializar(boolean enable) {
        this.opciones.setEnabled(enable);
        this.cmdDarHojas.setEnabled(enable);
        this.cmdBuscar.setEnabled(enable);
        this.cmdBuscarPadre.setEnabled(enable);
        this.botonBorrar.setEnabled(enable);
        this.botonPodar.setEnabled(enable);
        this.botonBalance.setEnabled(enable);
        this.botonBMayor.setEnabled(enable);
        this.botonBMenor.setEnabled(enable);
        this.botonCambiar.setEnabled(enable);
        this.botonCambiarValores.setEnabled(enable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        impresion = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        botonInsertar = new javax.swing.JButton();
        opciones = new javax.swing.JComboBox();
        cmdDarHojas = new javax.swing.JButton();
        cmdBuscar = new javax.swing.JButton();
        cmdBuscarPadre = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        botonPodar = new javax.swing.JButton();
        botonBalance = new javax.swing.JButton();
        botonBMayor = new javax.swing.JButton();
        botonBMenor = new javax.swing.JButton();
        botonCambiar = new javax.swing.JButton();
        botonCambiarValores = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCnodos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblChojas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblVmenor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblVmayor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Panel de Pruebas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N
        jPanel2.setOpaque(false);

        jScrollPane1.setOpaque(false);

        impresion.setEditable(false);
        impresion.setColumns(20);
        impresion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        impresion.setRows(5);
        impresion.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados de operaciones"));
        impresion.setOpaque(false);
        jScrollPane1.setViewportView(impresion);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N
        jPanel3.setOpaque(false);

        botonInsertar.setBackground(new java.awt.Color(255, 255, 255));
        botonInsertar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonInsertar.setText("Insertar");
        botonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsertarActionPerformed(evt);
            }
        });

        opciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        opciones.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ORDENAMIENTOS", "InOrden", "PreOrden", "PosOrden", "PorNiveles", "NivelOrdenado" }));
        opciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesActionPerformed(evt);
            }
        });

        cmdDarHojas.setBackground(new java.awt.Color(255, 255, 255));
        cmdDarHojas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdDarHojas.setText("Hojas");
        cmdDarHojas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDarHojasActionPerformed(evt);
            }
        });

        cmdBuscar.setBackground(new java.awt.Color(255, 255, 255));
        cmdBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdBuscar.setText("Buscar");
        cmdBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBuscarActionPerformed(evt);
            }
        });

        cmdBuscarPadre.setBackground(new java.awt.Color(255, 255, 255));
        cmdBuscarPadre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdBuscarPadre.setText("Buscar Padre");
        cmdBuscarPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBuscarPadreActionPerformed(evt);
            }
        });

        botonBorrar.setBackground(new java.awt.Color(255, 255, 255));
        botonBorrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBorrar.setText("Borrar");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonPodar.setBackground(new java.awt.Color(255, 255, 255));
        botonPodar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonPodar.setText("Podar");
        botonPodar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPodarActionPerformed(evt);
            }
        });

        botonBalance.setBackground(new java.awt.Color(255, 255, 255));
        botonBalance.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBalance.setText("Balance");
        botonBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBalanceActionPerformed(evt);
            }
        });

        botonBMayor.setBackground(new java.awt.Color(255, 255, 255));
        botonBMayor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBMayor.setText("Borrar mayor");
        botonBMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBMayorActionPerformed(evt);
            }
        });

        botonBMenor.setBackground(new java.awt.Color(255, 255, 255));
        botonBMenor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBMenor.setText("Borrar menor");
        botonBMenor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBMenorActionPerformed(evt);
            }
        });

        botonCambiar.setBackground(new java.awt.Color(255, 255, 255));
        botonCambiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonCambiar.setText("Cambiar Valores");
        botonCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarActionPerformed(evt);
            }
        });

        botonCambiarValores.setBackground(new java.awt.Color(255, 255, 255));
        botonCambiarValores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonCambiarValores.setText("Rama(s) Mayor");
        botonCambiarValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarValoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(botonInsertar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(cmdDarHojas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdBuscarPadre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonPodar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBalance))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(botonBMayor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBMenor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonCambiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCambiarValores)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonInsertar)
                    .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdDarHojas)
                    .addComponent(cmdBuscar)
                    .addComponent(cmdBuscarPadre)
                    .addComponent(botonBorrar)
                    .addComponent(botonPodar)
                    .addComponent(botonBalance))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBMayor)
                    .addComponent(botonBMenor)
                    .addComponent(botonCambiar)
                    .addComponent(botonCambiarValores))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDesktopPane1.setOpaque(false);

        jInternalFrame2.setIconifiable(true);
        jInternalFrame2.setMaximizable(true);
        jInternalFrame2.setResizable(true);
        jInternalFrame2.setEnabled(false);
        jInternalFrame2.setFocusCycleRoot(false);
        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        jInternalFrame2.setBounds(0, 0, 440, 340);
        jDesktopPane1.add(jInternalFrame2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel4.setOpaque(false);

        jLabel1.setText("Cantidad Nodos");

        lblCnodos.setEditable(false);

        jLabel2.setText("Cantidad Hojas");

        lblChojas.setEditable(false);

        jLabel3.setText("Valor Menor");

        lblVmenor.setEditable(false);

        jLabel4.setText("Valor Mayor");

        lblVmayor.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(lblCnodos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(lblChojas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVmenor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVmayor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCnodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblChojas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVmenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVmayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jDesktopPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                    .addComponent(jDesktopPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInsertarActionPerformed
        try {
            int dato = Integer.parseInt(JOptionPane.showInputDialog("Digite dato entero para insertar:"));
            if (this.simulador.insertar(dato)) {
                JOptionPane.showMessageDialog(null, "El dato fue insertado correctamente", " ...", 1);
                this.inicializar(true);
                
                complementos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el dato", "Intenta de nuevo...", 0);

        }
    }//GEN-LAST:event_botonInsertarActionPerformed

    private void opcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesActionPerformed
        Object opcion = this.opciones.getSelectedItem();
        String recorrido = null;
        if (opcion.equals("InOrden")) {
            recorrido = this.simulador.inOrden();
        }
        if (opcion.equals("PreOrden")) {
            recorrido = this.simulador.preOrden();
        }
        if (opcion.equals("PosOrden")) {
            recorrido = this.simulador.posOrden();
        }
        if (opcion.equals("PorNiveles")) {
            recorrido = this.simulador.imprimirPorNiveles();
        }
        if (opcion.equals("NivelOrdenado")) {
            recorrido = this.simulador.porNivel();
        }
        this.impresion.setText("");
        this.impresion.setText(recorrido);
    }//GEN-LAST:event_opcionesActionPerformed

    private void cmdDarHojasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDarHojasActionPerformed
        String salida = this.simulador.darHojas();
        this.impresion.setText("");
        this.impresion.setText(salida);
    }//GEN-LAST:event_cmdDarHojasActionPerformed

    private void cmdBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBuscarActionPerformed
        int dato_a_buscar = Integer.parseInt(JOptionPane.showInputDialog("Por favor digite un dato a buscar en el arbol:"));
        String salida = this.simulador.esta(dato_a_buscar);
        this.impresion.setText("");
        this.impresion.setText(salida);
    }//GEN-LAST:event_cmdBuscarActionPerformed

    private void cmdBuscarPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBuscarPadreActionPerformed
        int dato_a_buscar = Integer.parseInt(JOptionPane.showInputDialog("Por favor digite un dato para buscarle su Padre: "));
        String salida = this.simulador.darPadre(dato_a_buscar);
        this.impresion.setText("");
        this.impresion.setText(salida);
    }//GEN-LAST:event_cmdBuscarPadreActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        try {
            int dato = Integer.parseInt(JOptionPane.showInputDialog("Digite dato entero para borrar: "));
            this.impresion.setText(this.simulador.borrar(dato));
            
            complementos();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonPodarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPodarActionPerformed
        this.impresion.setText("Las hojas del árbol fueron eliminadas");
        this.simulador.podarArbol();
        
        complementos();
    }//GEN-LAST:event_botonPodarActionPerformed

    private void botonBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBalanceActionPerformed
        this.impresion.setText("");
        this.impresion.setText(simulador.balance());
    }//GEN-LAST:event_botonBalanceActionPerformed

    private void botonBMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBMayorActionPerformed
        try {
            this.impresion.setText("");
            this.impresion.setText(simulador.borrarMayor());
            
            complementos();
        } catch (Exception e) {
            complementos();
        }
    }//GEN-LAST:event_botonBMayorActionPerformed

    private void botonBMenorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBMenorActionPerformed

        try {
            this.impresion.setText("");
            this.impresion.setText(simulador.borrarMenor());           

            complementos();
        } catch (Exception e) {
            
            complementos();
        }
    }//GEN-LAST:event_botonBMenorActionPerformed

    private void botonCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarActionPerformed
        this.simulador.cambiar();
       
        complementos();
    }//GEN-LAST:event_botonCambiarActionPerformed

    public void complementos(){
        this.repintarArbol();
        this.lblCnodos.setText("");
        this.lblCnodos.setText(this.simulador.CantidadNodos());

        this.lblChojas.setText("");
        this.lblChojas.setText(this.simulador.CantidadHojas());

        this.lblVmenor.setText("");
        this.lblVmenor.setText(this.simulador.menorValor());

        this.lblVmayor.setText("");
        this.lblVmayor.setText(this.simulador.mayorValor());
    }
    private void botonCambiarValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarValoresActionPerformed
        String recorrido = null;
        recorrido = this.simulador.ramaMayor();

        this.impresion.setText("");
        this.impresion.setText(recorrido);
    }//GEN-LAST:event_botonCambiarValoresActionPerformed

    private void repintarArbol() {
        this.jDesktopPane1.removeAll();
        Rectangle tamanio = this.jInternalFrame2.getBounds();
        this.jInternalFrame2 = null;
        this.jInternalFrame2 = new JInternalFrame("Representación gráfica", true);
        this.jDesktopPane1.add(this.jInternalFrame2, JLayeredPane.DEFAULT_LAYER);
        this.jInternalFrame2.setVisible(true);
        this.jInternalFrame2.setBounds(tamanio);
        this.jInternalFrame2.setEnabled(false);
        this.jInternalFrame2.add(this.simulador.getDibujo(), BorderLayout.CENTER);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBMayor;
    private javax.swing.JButton botonBMenor;
    private javax.swing.JButton botonBalance;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonCambiar;
    private javax.swing.JButton botonCambiarValores;
    private javax.swing.JButton botonInsertar;
    private javax.swing.JButton botonPodar;
    private javax.swing.JButton cmdBuscar;
    private javax.swing.JButton cmdBuscarPadre;
    private javax.swing.JButton cmdDarHojas;
    private javax.swing.JTextArea impresion;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lblChojas;
    private javax.swing.JTextField lblCnodos;
    private javax.swing.JTextField lblVmayor;
    private javax.swing.JTextField lblVmenor;
    private javax.swing.JComboBox opciones;
    // End of variables declaration//GEN-END:variables
}
