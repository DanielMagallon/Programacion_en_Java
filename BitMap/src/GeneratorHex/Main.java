package GeneratorHex;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame implements ActionListener, Serializable
{
	
	PaintMoved pmv;
	private JPanel contentPane;
	private static JTabbedPane tabbedPane;
	public static ArrayList<MatrizPx> panelMain;
	ArrayList<JLabel> lblExist;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmNuevo;
	JComboBox cbRows, cbColumn;
	JButton btnBordeC;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	transient GroupLayout gl_contentPane,gl_panel;
	transient JPanel panel;
	static final Color initialC = new Color(238,238,238);
	int selecction;
	JFileChooser chosser;
	File DEFAULT_FILE, myFile;
    //Image im;
	//Cursor cur;
	public static void main(String[] arg) {
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private void createCursor(String ruta)
	{
		/*im = Toolkit.getDefaultToolkit().createImage
				("C:/Users/Daniel/Desktop/paint.png");
				//("C:\\Users\\Daniel\\Documents\\workspace Mars\\ReaderBits\\src\\imagenes\\"+ruta+".png");
		cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(10,10),"WILL");
	    setCursor(cur);*/ 
	}
	
	public Main() 
	{
		pmv = new PaintMoved();
		chosser = new JFileChooser();
		DEFAULT_FILE = new File("C:/Users/Daniel/Documents/workspace Mars/ReaderBits");
		chosser.setCurrentDirectory(DEFAULT_FILE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 433);
		panelMain = new ArrayList<>();
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmNuevo);
		
		mntmCerrarVentana = new JMenuItem("Cerrar Ventana");
		mntmCerrarVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				close();
			}
		});
		
		mntmAbrir = new JMenuItem("Abrir ");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmAbrir);
		
		mntmGuardarComo = new JMenuItem("Guardar como");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SavePanel();
			}
		});
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
		mnArchivo.add(mntmGuardarComo);
		
		mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);
		mnArchivo.add(mntmCerrarVentana);
		
		mnGenerarHexadecimal = new JMenu("Generar Hexadecimal");
		mnArchivo.add(mnGenerarHexadecimal);
		
		mtmHexa = new JMenuItem("Generar Hexadecimal");
		mnGenerarHexadecimal.add(mtmHexa);
		
		mntmGoh = new JMenuItem("GOH");
		mnGenerarHexadecimal.add(mntmGoh);
		
		JMenu mnNewMenu = new JMenu("Modo Pintura");
		mnArchivo.add(mnNewMenu);
		
		JMenuItem mntmClick = new JMenuItem("Click");
		
		mntmClick.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelMain.get(getSelectTabIndex()).setIsClick(true);
				panelMain.get(getSelectTabIndex()).setIsEntered(false);
			}
		});
		
		mntmClick.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
		mnNewMenu.add(mntmClick);
		
		JMenuItem mntmEntered = new JMenuItem("Entered");
		mntmEntered.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelMain.get(getSelectTabIndex()).setIsClick(false);
				panelMain.get(getSelectTabIndex()).setIsEntered(true);
			}
		});
		mntmEntered.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
		mnNewMenu.add(mntmEntered);
		
		chckbxmntmBorrador = new JCheckBoxMenuItem("Borrador");
		chckbxmntmBorrador.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent arg0) 
			{
				if(arg0.getStateChange() == ItemEvent.SELECTED)
				{
					colorPixel = initialC;
				}
				else
				{
					colorPixel = btnPixCr.getBackground();
				}
			}
		});
		 
		chckbxmntmBorrador.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_MASK));
		mnNewMenu.add(chckbxmntmBorrador);
		
		chckbxmntmRelleno = new JCheckBoxMenuItem("Relleno");
		chckbxmntmRelleno.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
				{
					panelMain.get(getSelectTabIndex()).setRelleno(true);
					//createCursor("paint");
					//panelMain.get(getSelectTabIndex()).createCursor("asterisk");
					//panelMain.get(getSelectTabIndex()).process = (f,c) -> PaintMoved.paintAllC(f, c); 
				}
				else
				{
					panelMain.get(getSelectTabIndex()).setRelleno(false);
					//createCursor(null);
					//
					//panelMain.get(getSelectTabIndex()).createDefaultCursor();
				}
			}
		});
		chckbxmntmRelleno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
		mnNewMenu.add(chckbxmntmRelleno);
		
		mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		mnModoRelleno = new JMenu("Modo Relleno");
		mnEditar.add(mnModoRelleno);
		
		chckbxmntmTodo = new JRadioButtonMenuItem ("Todo");
		mnModoRelleno.add(chckbxmntmTodo);
		buttonGroup.add(chckbxmntmTodo);
		chckbxmntmTodo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
					//panelMain.get(getSelectTabIndex()).createCursor("asterisk");
					//panelMain.get(getSelectTabIndex()).process = (f,c) -> pmv.paintAllC(); 
			}
		});
		//chckbxmntmTodo.setIcon(new ImageIcon(Main.class.getResource("/imagenes/asterisk.png")));
		
		mnDiagonal = new JMenu("Diagonal");
		mnModoRelleno.add(mnDiagonal);
		
		chckbxmntmDiagonalx = new JRadioButtonMenuItem ("Diagonalx4");
		mnDiagonal.add(chckbxmntmDiagonalx);
		buttonGroup.add(chckbxmntmDiagonalx);
		chckbxmntmDiagonalx.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
					//panelMain.get(getSelectTabIndex()).createCursor("diagx4");
					//panelMain.get(getSelectTabIndex()).process = (f,c) -> pmv.paintDiagonal4();
			}
		});
		//chckbxmntmDiagonalx.setIcon(new ImageIcon(Main.class.getResource("/imagenes/diagx4.png")));
		
		chckbxmntmDiagonalDownright = new JRadioButtonMenuItem ("Diagonal DownRight");
		mnDiagonal.add(chckbxmntmDiagonalDownright);
		buttonGroup.add(chckbxmntmDiagonalDownright);
		chckbxmntmDiagonalDownright.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
					//panelMain.get(getSelectTabIndex()).createCursor("diagDownR");
					//panelMain.get(getSelectTabIndex()).process = (f,c) -> pmv.paintDiagonalDR(f+1, c+1);
			}
		});
//		chckbxmntmDiagonalDownright.setIcon(new ImageIcon(Main.class.getResource("/imagenes/diagDownR.png")));
		
		chckbxmntmDiagonalUpleft = new JRadioButtonMenuItem ("Diagonal UpLeft");
		mnDiagonal.add(chckbxmntmDiagonalUpleft);
		buttonGroup.add(chckbxmntmDiagonalUpleft);
		chckbxmntmDiagonalUpleft.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
					//panelMain.get(getSelectTabIndex()).createCursor("diagUpL");
					//panelMain.get(getSelectTabIndex()).process = (f,c) -> pmv.paintDiagonalUL(f-1, c-1);
			}
		});
//		chckbxmntmDiagonalUpleft.setIcon(new ImageIcon(Main.class.getResource("/imagenes/diagUpL.png")));
		
		chckbxmntmNewCheckItem = new JRadioButtonMenuItem ("Diagonal UpRight");
		mnDiagonal.add(chckbxmntmNewCheckItem);
		buttonGroup.add(chckbxmntmNewCheckItem);
		chckbxmntmNewCheckItem.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
					//panelMain.get(getSelectTabIndex()).createCursor("diagUpR");
					//panelMain.get(getSelectTabIndex()).process = (f,c) -> pmv.paintDiagonalUR(f-1, c+1);
			}
		});
//		chckbxmntmNewCheckItem.setIcon(new ImageIcon(Main.class.getResource("/imagenes/diagUpR.png")));
		
		chckbxmntmDiagonalDownleft = new JRadioButtonMenuItem ("Diagonal DownLeft");
		mnDiagonal.add(chckbxmntmDiagonalDownleft);
		buttonGroup.add(chckbxmntmDiagonalDownleft);
		chckbxmntmDiagonalDownleft.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
					//panelMain.get(getSelectTabIndex()).createCursor("diagDownL");
					//panelMain.get(getSelectTabIndex()).process = (f,c) -> pmv.paintDiagonalDL(f+1, c-1);
			}
		});
//		chckbxmntmDiagonalDownleft.setIcon(new ImageIcon(Main.class.getResource("/imagenes/diagDownL.png")));
		
		chckbxmntmDiagonalDownleftupright = new JRadioButtonMenuItem ("Diagonal DownLeft-UpRight");
		mnDiagonal.add(chckbxmntmDiagonalDownleftupright);
		buttonGroup.add(chckbxmntmDiagonalDownleftupright);
		chckbxmntmDiagonalDownleftupright.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
					//panelMain.get(getSelectTabIndex()).createCursor("diagDLUR");
					//panelMain.get(getSelectTabIndex()).process = (f,c) -> 
					//pmv.paintDiagonalDL(f+1, c-1).paintDiagonalUR(f-1, c+1);
			}
		});
//		chckbxmntmDiagonalDownleftupright.setIcon(new ImageIcon(Main.class.getResource("/imagenes/diagDLUR.png")));
		
		chckbxmntmDiagonalUpleftdownright = new JRadioButtonMenuItem ("Diagonal UpLeft-DownRight");
		mnDiagonal.add(chckbxmntmDiagonalUpleftdownright);
		buttonGroup.add(chckbxmntmDiagonalUpleftdownright);
		chckbxmntmDiagonalUpleftdownright.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				//panelMain.get(getSelectTabIndex()).createCursor("diagULDR");
				//panelMain.get(getSelectTabIndex()).process = (f,c) -> 
				//pmv.paintDiagonalUL(f-1, c-1).paintDiagonalDR(f+1, c+1);
			}
		});
//		chckbxmntmDiagonalUpleftdownright.setIcon(new ImageIcon(Main.class.getResource("/imagenes/diagULDR.png")));
		
		mnRecta = new JMenu("Recta");
		mnModoRelleno.add(mnRecta);
		
		rdbtnmntmUp = new JRadioButtonMenuItem("Vertical");
		rdbtnmntmUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//panelMain.get(getSelectTabIndex()).process = (f,c) -> 
				//pmv.paintTop(f-1, c).paintBottom(f+1, c);
			}
		});
		buttonGroup.add(rdbtnmntmUp);
		mnRecta.add(rdbtnmntmUp);
		
		rdbtnmntmDown = new JRadioButtonMenuItem("Horizontal");
		rdbtnmntmDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//panelMain.get(getSelectTabIndex()).process = (f,c) -> 
				//pmv.paintRight(f, c+1).paintLeft(f, c-1);
			}
		});
		buttonGroup.add(rdbtnmntmDown);
		mnRecta.add(rdbtnmntmDown);
		
		rdbtnmntmLeft = new JRadioButtonMenuItem("Left");
		rdbtnmntmLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//panelMain.get(getSelectTabIndex()).process = (f,c) -> 
				//pmv.paintLeft(f, c-1);
			}
		});
		mnRecta.add(rdbtnmntmLeft);
		
		rdbtnmntmRight = new JRadioButtonMenuItem("Right");
		rdbtnmntmRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//panelMain.get(getSelectTabIndex()).process = (f,c) -> 
				//pmv.paintRight(f, c+1);
			}
		});
		buttonGroup.add(rdbtnmntmRight);
		mnRecta.add(rdbtnmntmRight);
		
		rdbtnmntmUpleft = new JRadioButtonMenuItem("Up-Left");
		rdbtnmntmUpleft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//panelMain.get(getSelectTabIndex()).process = (f,c) -> 
				//pmv.paintTop(f-1, c).paintLeft(f, c-1);
			}
		});
		buttonGroup.add(rdbtnmntmUpleft);
		mnRecta.add(rdbtnmntmUpleft);
		
		rdbtnmntmUpright = new JRadioButtonMenuItem("Up-Right");
		rdbtnmntmUpright.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//panelMain.get(getSelectTabIndex()).process = (f,c) -> 
				//pmv.paintTop(f-1, c).paintRight(f, c+1);
			}
		});
		buttonGroup.add(rdbtnmntmUpright);
		mnRecta.add(rdbtnmntmUpright);
		
		rdbtnmntmDownleft = new JRadioButtonMenuItem("Down-Left");
		rdbtnmntmDownleft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//panelMain.get(getSelectTabIndex()).process = (f,c) -> 
				//pmv.paintBottom(f+1, c).paintLeft(f, c-1);
			}
		});
		buttonGroup.add(rdbtnmntmDownleft);
		mnRecta.add(rdbtnmntmDownleft);
		
		rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("Down-Right");
		rdbtnmntmNewRadioItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//panelMain.get(getSelectTabIndex()).process = (f,c) -> 
				//pmv.paintBottom(f+1, c).paintRight(f, c+1);
			}
		});
		buttonGroup.add(rdbtnmntmNewRadioItem);
		mnRecta.add(rdbtnmntmNewRadioItem);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		panel = new JPanel();
		 gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 438, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
		);
		
		
		JLabel lblFilaDePixeles = new JLabel("Alto de Pixeles");
		lblFilaDePixeles.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblAnchoDePixeles = new JLabel("Ancho de Pixeles");
		lblAnchoDePixeles.setHorizontalAlignment(SwingConstants.CENTER);
		
		cbRows = new JComboBox();
		cbColumn = new JComboBox();
		cbColumn.setEditable(true);
		
		JLabel lblColor = new JLabel("Color borde");
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnBordeC = new JButton("");
		btnBordeC.setBackground(Color.BLACK);
		
		lblColorPixel = new JLabel("Color Pixel");
		lblColorPixel.setHorizontalAlignment(SwingConstants.CENTER);
		btnPixCr = new JButton("");
		btnPixCr.setBackground(Color.BLACK);
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				panelMain.get(getSelectTabIndex()).upColor();
			}
		});
		
		txtSentido = new JTextField();
		txtSentido.setColumns(10);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				panelMain.get(getSelectTabIndex()).sentido=Integer.parseInt(txtSentido.getText());
				panelMain.get(getSelectTabIndex()).createAlghoritm();
			}
		});
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.get(getSelectTabIndex()).returnColor();
			}
		});
		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAnchoDePixeles, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblFilaDePixeles, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(cbRows, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbColumn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(26)
							.addComponent(lblColor, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(43)
							.addComponent(btnBordeC, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblColorPixel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(35)
							.addComponent(btnPixCr)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtSentido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnUp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLeft)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAnchoDePixeles)
										.addComponent(cbRows, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblColor, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(12)
											.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(cbColumn, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblFilaDePixeles)))
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnBordeC, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblColorPixel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(btnPixCr, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSentido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton)
								.addComponent(btnUp)
								.addComponent(btnLeft))))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		addItemsCombo();
		Actions();
	}
	DefaultComboBoxModel<Integer> model,model2;
	
	private void addItemsCombo()
	{
		model = new DefaultComboBoxModel<>();
		model2 = new DefaultComboBoxModel<>();
		
		for (int i=16; i<=96; i++)
		{
			model.addElement(i);
			model2.addElement(i);
		}
		cbColumn.setModel(model);
		cbRows.setModel(model2);
		
	}

	private int getSizeList()
	{
		return panelMain.size()-1;
	}
	
	private void addNewWidnow()
	{
		panelMain.add(new MatrizPx
		(getItemCbC(),getItemCbR(),  btnBordeC.getBackground()));
		tabbedPane.add(panelMain.get(getSizeList()), "Pestaña "+ (getSizeList()+1));
	}
	
	private void close()
	{
		tabbedPane.remove(tabbedPane.getSelectedIndex());
		panelMain.remove(tabbedPane.getSelectedIndex()+1);
	}
	
	private int getItemCbR()
	{
		return Integer.parseInt(cbRows.getSelectedItem().toString());
	}
	
	private int getItemCbC()
	{
		return Integer.parseInt(cbColumn.getSelectedItem().toString());
	}

	private void Actions()
	{
		colorPixel = btnPixCr.getBackground();
		mntmNuevo.addActionListener(this);
		btnBordeC.addActionListener(this);
		btnPixCr.addActionListener(this);
		mtmHexa.addActionListener(this);
		mntmGuardar.addActionListener(this);
		mntmAbrir.addActionListener(this);
		mntmGoh.addActionListener(this);
	}
	
	ArrayList<JPanel> panelCR = new ArrayList<>();
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == mntmNuevo)
				addNewWidnow();
		
		else if (e.getSource() == btnBordeC)
		{
			colorBorde = JColorChooser.showDialog(Main.this, "Chose a color", Color.black);
			btnBordeC.setBackground(colorBorde);
			
			panelMain.get(tabbedPane.getSelectedIndex()).paintBorder(colorBorde);
		}
		
		else if (e.getSource() == btnPixCr)
		{
			colorPixel = JColorChooser.showDialog(Main.this, "Chose a color", Color.black);
			btnPixCr.setBackground(colorPixel);
		}
		
		else if (e.getSource() == mtmHexa)
		{
			panelMain.get(tabbedPane.getSelectedIndex()).generateHexa(0);
		}
		else if (e.getSource() == mntmGoh)
		{
			panelMain.get(tabbedPane.getSelectedIndex()).generateHexa(1);
		}
		
		else if (e.getSource() == mntmGuardar)
		{
			saveDefaultPanel();
		}
		
		else if (e.getSource() == mntmAbrir)
		{
			OpenPanel();
		}
	}
	
	private void SavePanel()
	{
		selecction = chosser.showSaveDialog(this);
		
		if(selecction == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				myFile = chosser.getSelectedFile();
				oos = new ObjectOutputStream(new FileOutputStream(myFile));
				maPxAux = panelMain.get(getSelectTabIndex());
				oos.writeObject(maPxAux);
				oos.close();
			}
			catch (IOException io)
			{
				io.printStackTrace();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void saveDefaultPanel()
	{
		if (myFile != null)
		{
			try
			{
				oos = new ObjectOutputStream(new FileOutputStream(myFile));
				maPxAux = panelMain.get(getSelectTabIndex());
				oos.writeObject(maPxAux);
				oos.close();
			}
			catch (IOException io)
			{
				io.printStackTrace();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			SavePanel();
		}
	}
	
	MatrizPx maPxAux;
	
	
	private void OpenPanel()
	{
		selecction = chosser.showOpenDialog(this);

		if (selecction == JFileChooser.APPROVE_OPTION) 
		{
			myFile = chosser.getSelectedFile();
			try
			{
				ois = new ObjectInputStream(new FileInputStream(myFile));
				maPxAux = (MatrizPx)ois.readObject();
				addWindowExist();
			}
			catch (ClassNotFoundException | IOException ex){
				System.err.println("Error"+ex.getMessage());
			}
			
		}
	}
	
	private void addWindowExist()
	{
		panelMain.add(maPxAux);
		tabbedPane.add(panelMain.get(getSizeList()), "Pestaña "+ (getSizeList()+1));
	}
	
	public static int getSelectTabIndex()
	{
		//Empieza desde 0
		return tabbedPane.getSelectedIndex();
	}
	
	 static Color colorBorde, colorPixel;
	private JLabel lblColorPixel;
	transient public static JButton btnPixCr;
	private JMenuItem mtmHexa;
	private JCheckBoxMenuItem chckbxmntmBorrador;
	private JMenuItem mntmCerrarVentana;
	private JMenuItem mntmAbrir;
	 private JMenuItem mntmGuardar;
	 private JCheckBoxMenuItem chckbxmntmRelleno;
	 private JMenu mnModoRelleno;
	 private JRadioButtonMenuItem chckbxmntmTodo, chckbxmntmDiagonalx,chckbxmntmDiagonalDownright,
	 chckbxmntmDiagonalUpleft, chckbxmntmNewCheckItem,chckbxmntmDiagonalDownleft,chckbxmntmDiagonalDownleftupright,
     chckbxmntmDiagonalUpleftdownright;
	 private final ButtonGroup buttonGroup = new ButtonGroup();
	 private JMenu mnEditar;
	 private JMenu mnDiagonal;
	 private JMenu mnRecta;
	 private JRadioButtonMenuItem rdbtnmntmUp;
	 private JRadioButtonMenuItem rdbtnmntmDown;
	 private JRadioButtonMenuItem rdbtnmntmRight;
	 private JRadioButtonMenuItem rdbtnmntmUpleft;
	 private JRadioButtonMenuItem rdbtnmntmUpright;
	 private JRadioButtonMenuItem rdbtnmntmDownleft;
	 private JRadioButtonMenuItem rdbtnmntmNewRadioItem;
	 private JRadioButtonMenuItem rdbtnmntmLeft;
	 private JMenu mnGenerarHexadecimal;
	 private JMenuItem mntmGoh;
	 private JTextField txtSentido;
	 private JButton btnNewButton;
	 private JMenuItem mntmGuardarComo;
}
