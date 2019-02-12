package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

public class Busquedas extends JDialog implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1570556903857008954L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblBusquedasNegras;
	private JPanel panel_1;
	
	public static JTextArea txtPiezasCubrenJN,txtCasillasPasaJaqueN,txtPiezasDanJaqueN,txtComeJaqueB,
						txtPiezasCubreJB,txtCasillasPasaJB,txtPiezasDanJB,txtComeJaqueN;
	
	public static void setTextArea(JTextArea txtA,String text)
	{
		txtA.setWrapStyleWord(true);
		txtA.setLineWrap(true);
		txtA.setText(text);
	} 
	
	
	/**
	 * Create the dialog.
	 */
	public Busquedas() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 579);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			panel_1 = new JPanel();
			{
				lblBusquedasNegras = new JLabel("Busquedas negras");
			}
			
			JScrollPane scrollPane = new JScrollPane();
			
			JLabel lblPiezasDanJaque = new JLabel("Piezas dan jaque");
			
			JLabel lblCasillasPasaJaque = new JLabel("Casillas pasa jaque");
			
			JScrollPane scrollPane_1 = new JScrollPane();
			
			JLabel lblPiezasCubrenJaque = new JLabel("Piezas cubren Jaque");
			
			JScrollPane scrollPane_2 = new JScrollPane();
			
			JLabel lblPiezasComoenJaque = new JLabel("piezas comoen jaque");
			
			JScrollPane scrollPane_3 = new JScrollPane();
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(5)
						.addComponent(lblBusquedasNegras))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblPiezasDanJaque)
						.addContainerGap(161, Short.MAX_VALUE))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblCasillasPasaJaque)
						.addContainerGap(151, Short.MAX_VALUE))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(19)
						.addComponent(lblPiezasCubrenJaque)
						.addContainerGap(135, Short.MAX_VALUE))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
						.addContainerGap())
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblPiezasComoenJaque)
						.addContainerGap(142, Short.MAX_VALUE))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
						.addGap(20))
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(5)
						.addComponent(lblBusquedasNegras)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblPiezasDanJaque)
						.addGap(7)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblCasillasPasaJaque)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblPiezasCubrenJaque)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblPiezasComoenJaque)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			
			txtComeJaqueN = new JTextArea();
			scrollPane_3.setViewportView(txtComeJaqueN);
			
			 txtPiezasCubrenJN = new JTextArea();
			scrollPane_2.setViewportView(txtPiezasCubrenJN);
			
			txtCasillasPasaJaqueN = new JTextArea();
			scrollPane_1.setViewportView(txtCasillasPasaJaqueN);
			
			 txtPiezasDanJaqueN = new JTextArea();
			scrollPane.setViewportView(txtPiezasDanJaqueN);
			panel_1.setLayout(gl_panel_1);
		}
		
		JPanel panel = new JPanel();
		
		JLabel lblBusquedasBlnacas = new JLabel("Busquedas blnacas");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_1 = new JLabel("Piezas dan jaque");
		
		JLabel label_2 = new JLabel("Casillas pasa jaque");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel label_3 = new JLabel("Piezas cubren Jaque");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblPiezasComenJaque = new JLabel("piezas comen jaque");
		
		JScrollPane scrollPane_4 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblBusquedasBlnacas))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_1)
					.addContainerGap(163, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(9)
								.addComponent(label_3)
								.addPreferredGap(ComponentPlacement.RELATED, 127, GroupLayout.PREFERRED_SIZE))
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblPiezasComenJaque, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 134, GroupLayout.PREFERRED_SIZE))
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
							.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblBusquedasBlnacas)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_2)
					.addGap(11)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPiezasComenJaque)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		txtComeJaqueB = new JTextArea();
		scrollPane_4.setViewportView(txtComeJaqueB);
		
		 txtPiezasCubreJB = new JTextArea();
		scrollPane_2.setViewportView(txtPiezasCubreJB);
		
		 txtCasillasPasaJB = new JTextArea();
		scrollPane_1.setViewportView(txtCasillasPasaJB);
		
		 txtPiezasDanJB = new JTextArea();
		scrollPane.setViewportView(txtPiezasDanJB);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 497, Short.MAX_VALUE)
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("OK"))
		{
			this.dispose();
		}
		
		else 
		{
			this.dispose();
		}
	}
}
