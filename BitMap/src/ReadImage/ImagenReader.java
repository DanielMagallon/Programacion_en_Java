package ReadImage;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.PanelUI;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class ImagenReader extends JFrame {

	Timer timer;
	BufferedImage ioImage;
	Runnable runable;
	Thread hiloSave;

	ArrayList<ImageIcon> editIMage;
	Graphics gr;
	Graphics2D gr2D;
	Border border;
	BasicStroke stroke;

	ImageIcon imagen, auxImage;

	File file;

	String nameIma = "milotic.jpg";
	float grosor;

	private JScrollPane scrollPane;
	private JPanel contentPane,  panel_2;
	private JLabel panelIcon, lblX, lblY;
	private JSpinner spinner;
	private SpinnerListModel modelSpin;
	private JButton btnDrawLine, btnBack;
	private JRadioButton rdbtnV, rdbtnH, rdbtnPropor;
	private JCheckBox chxRellen;
	private JMenuItem mntmBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImagenReader frame = new ImagenReader();
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
	public ImagenReader() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 362);

		//editIMage = new ArrayList<>();
		border = BorderFactory.createLineBorder(Color.black);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		menuBar.add(mnFile);

		JMenuItem mntmNuevo = new JMenuItem("Save");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				saveDefaultImage();
			}
		});

		JMenuItem mntmAbrir = new JMenuItem("Open");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadImage();
			}
		});
		mnFile.add(mntmAbrir);
		mnFile.add(mntmNuevo);
		
		mntmSaveAs = new JMenuItem("Save As");
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				saveImage();
			}
		});
		mntmSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
		mnFile.add(mntmSaveAs);
		
		mntmBack = new JMenuItem("Back");
		mntmBack.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mnFile.add(mntmBack);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		panel_2 = new JPanel();

		JPanel panel_3 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);

		panel.setBorder(border);

		rdbtnV = new JRadioButton("Vertical");
		buttonGroup.add(rdbtnV);

		rdbtnH = new JRadioButton("Horizontal");
		buttonGroup.add(rdbtnH);

		rdbtnPropor = new JRadioButton("Proporcional");
		buttonGroup.add(rdbtnPropor);

		chxRellen = new JCheckBox("Rellenar todo");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(rdbtnH)
								.addComponent(rdbtnV).addComponent(rdbtnPropor).addComponent(chxRellen))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(19).addComponent(rdbtnV).addGap(18)
								.addComponent(rdbtnH).addGap(18).addComponent(rdbtnPropor).addGap(18)
								.addComponent(chxRellen).addGap(58)));
		panel.setLayout(gl_panel);
		panel_1.setBorder(border);

		JLabel lblGrosorLinea = new JLabel("Grosor linea");

		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				setGrosor();
			}
		});

		btnDrawLine = new JButton("Draw");

		btnBack = new JButton("Back");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(
						gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
										.addComponent(lblGrosorLinea).addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 71,
												GroupLayout.PREFERRED_SIZE)
										.addGap(45).addComponent(btnDrawLine).addGap(37).addComponent(btnBack)
										.addContainerGap(113, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(20)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblGrosorLinea)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDrawLine).addComponent(btnBack))
				.addContainerGap(24, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);
		panel_3.setBorder(border);

		JLabel lblNewLabel = new JLabel("X:");

		JLabel lbl2 = new JLabel("Y:");

		lblX = new JLabel("");

		lblY = new JLabel("");
		
		JLabel lblFrom = new JLabel("FROM");
		
		JLabel lblTo = new JLabel("TO");
		
		JLabel label = new JLabel("X:");
		
		JLabel lblY_1 = new JLabel("Y:");
		
		txtFromX = new JTextField();
		txtFromX.setColumns(10);
		
		txtFromY = new JTextField();
		txtFromY.setColumns(10);
		
		txtToX = new JTextField();
		txtToX.setColumns(10);
		
		txtToY = new JTextField();
		txtToY.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl2)
										.addComponent(lblNewLabel))
									.addGap(27)
									.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
										.addComponent(lblY)
										.addComponent(lblX)))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(lblY_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtFromY, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtToY, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel_3.createSequentialGroup()
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtFromX, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(txtToX, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(38)
							.addComponent(lblFrom)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblX))
					.addGap(30)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl2)
						.addComponent(lblY))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFrom)
						.addComponent(lblTo))
					.addGap(18)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(txtFromX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtToX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY_1)
						.addComponent(txtFromY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtToY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		panel_2.setBackground(Color.white);
		
		panel_4 = new JPanel();
		
				 scrollPane = new JScrollPane();
				
						panelIcon = new JLabel("");
						panelIcon.setVerticalAlignment(SwingConstants.TOP);
						scrollPane.setViewportView(panelIcon);
						panelIcon.setHorizontalAlignment(SwingConstants.LEFT);
						panelIcon.setBorder(border);
						GroupLayout gl_panel_2 = new GroupLayout(panel_2);
						gl_panel_2.setHorizontalGroup(
							gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
									.addContainerGap()
									.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
									.addContainerGap())
						);
						gl_panel_2.setVerticalGroup(
							gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addContainerGap()
									.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
									.addContainerGap())
						);
						panel_4.setLayout(new BorderLayout(0, 0));
						panel_4.add(scrollPane);
						panel_2.setLayout(gl_panel_2);
		addEvents();
		initComoponents();
	}

	int x, y, ancesX, ancesY, sizeList;

	private void setGrosor() {
		grosor = Integer.parseInt(spinner.getValue().toString());
		gr2D.setStroke(new BasicStroke(grosor));
	}

	private void generateVertical() {
		if (!chxRellen.isSelected())
			gr2D.drawLine(x, y, x, heightImage);
		else 
		{
			while (x <= widthImage) 
			{
				gr2D.drawLine(x, y, x, heightImage);
				x += ancesX;
				rows+=4;
			}
		}
		panelIcon.repaint();
	}

	private void generateHorizontal() {
		if (!chxRellen.isSelected())
			gr2D.drawLine(x, y, widthImage, y);
		else 
		{
			while(y<=heightImage)
			{
				gr2D.drawLine(x, y, widthImage, y);
				y += ancesY;
			}
		}
		panelIcon.repaint();
	}

	private void generateBoth() {
		if (!chxRellen.isSelected()) 
		{
			gr2D.drawLine(x, y, x, heightImage); // dibuja la vetical
			gr2D.drawLine(0, x, widthImage, x); // dibuja la hrizontal
		} 
		else 
		{
				while(x<=widthImage)
				{
					gr2D.drawLine(x, y, x, heightImage); // dibuja la vetical
					x+=ancesX;
					//gr2D.drawLine(0, x, widthImage, x); // dibuja la hrizontal
				}
				x=ancesX;
				while (x<=heightImage)
				{
					gr2D.drawLine(0, x, widthImage, x); // dibuja la hrizontal
					x+=ancesX;
				}
		}
		panelIcon.repaint();
	}

	private void addEvents() {
		panelIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				ancesX = x = e.getX();
				ancesY = y = e.getY();
				lblX.setText("" + x);
				lblY.setText("" + y);
				if (rdbtnH.isSelected()) {
					generateHorizontal();
				} else if (rdbtnV.isSelected()) {
					generateVertical();
				} else if (rdbtnPropor.isSelected()) {
					generateBoth();
				}
				panelIcon.repaint();
			}
		});

		btnDrawLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnH.isSelected()) {
					generateHorizontal();
				} else if (rdbtnV.isSelected()) {
					generateVertical();
				} else if (rdbtnPropor.isSelected()) {
					generateBoth();
				}
			}
		});

		mntmBack.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				
				try
				{
				ioImage = ImageIO.read(file);
				imagen = new ImageIcon(ioImage);
				gr2D = ioImage.createGraphics();
				gr2D.setColor(Color.green);
				panelIcon.setIcon(imagen);
				}catch (IOException ex){};
			}
		});
	}


	String[] strokeGros = { "1", "2", "3", "4", "5" };
	File defaultFile;
	int rows,columns;
	
	private void initComoponents() {
		chosser = new JFileChooser();
		defaultFile = new File("C:/Users/Daniel/Desktop/PixImg");
		chosser.setCurrentDirectory(defaultFile);
		modelSpin = new SpinnerListModel(strokeGros);
		spinner.setModel(modelSpin);
	}

	JFileChooser chosser;
	int seleccion, widthImage, heightImage;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtFromX, txtFromY, txtToX, txtToY;
	private JMenuItem mntmSaveAs;
	private JPanel panel_4;

	private void loadImage() {
		seleccion = chosser.showOpenDialog(this);

		if (seleccion == JFileChooser.APPROVE_OPTION) {
			file = chosser.getSelectedFile();

			try {
				ioImage = ImageIO.read(file);
				imagen = new ImageIcon(ioImage);
				panelIcon.setIcon(imagen);
				widthImage = imagen.getIconWidth();
				heightImage = imagen.getIconHeight();
				gr2D = ioImage.createGraphics();
				gr2D.setColor(Color.black);
			} catch (IOException ex) {
				System.out.println("Error de escritura");
			}
		}
	}

	private void saveImage() {
		seleccion = chosser.showSaveDialog(this);

		try {
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				file = chosser.getSelectedFile();
				ImageIO.write(ioImage, "jpg", file);
			}

		} catch (IOException ex) {
			System.out.println("Error de escritura");
		}
	}
	
	private void saveDefaultImage()
	{
		try 
		{
				ImageIO.write(ioImage, "jpg", file);
		}
		catch (IOException ex) {}
	}
}
