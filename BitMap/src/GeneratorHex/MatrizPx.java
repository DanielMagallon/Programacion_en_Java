package GeneratorHex;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;

import static GeneratorHex.Main.*;

import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class MatrizPx extends JPanel  implements Serializable, MouseListener, ActionListener, MouseMotionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5044813238752534387L;
	
	JLabel[][] panelMat;
	Border border, borderN;
	int hexa = 0, potenciaBase = 8, length, columns, rows, iteraciones, contador, sentido,
	contT=1, contR=1, contB=1, contL=1;
	final int TOP=1, RIGHT=2, BOTTOM=3, LEFT=4;
	final String prefijo = "0x";
	String  hexaCad="",hexaSg[];
	JPanel panel;
	transient BorderLayout bL, bLP1;
	ArrayList<JButton> panelList;
	JPanel panel_1;
	JTextArea txtArea;
	JScrollPane scrollTXT;
	//transient Image im;
	//transient Cursor cur;
	//Method process;
	//ArrayList<Method> pro; 
	PaintMoved pai = new PaintMoved();
	
	public void createAlghoritm()
	{
		/*switch (sentido)
		{
			case TOP:
				pro.add(process = (i,j) -> pai.paintTop(i-contT, j));
				//contT++;
				break;
			case RIGHT:
				pro.add(process = (i,j) -> pai.paintRight(i, j+contR));
				//contR++;
				break;
			case BOTTOM:
				pro.add(process = (i,j) -> pai.paintBottom(i+contB, j));
				//contB++;
				break;
			case LEFT:
				pro.add(process = (i,j) -> pai.paintLeft(i, j-contL));
				//contL++;
				break;
		}*/
	}
	
	public MatrizPx(int r, int c, Color borderColor) {
		
		createAlghoritm();
		//pro = new ArrayList<>();
		panelList = new ArrayList<>();
		bL = new BorderLayout();
		bLP1 = new BorderLayout();
		setLayout(bL);
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		borderN = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		
		JSplitPane splitPane = new JSplitPane();
		scrollPane.setViewportView(splitPane);
		
		panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new GridLayout(r+1, c+1));
		
		panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(bLP1);
		
		splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.2);
		splitPane_1.setOneTouchExpandable(true);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_1.add(splitPane_1, BorderLayout.CENTER);
		
		txtArea = new JTextArea();
		scrollTXT = new JScrollPane(txtArea);
		splitPane_1.setLeftComponent(scrollTXT);
		
		panel_2 = new JPanel();
		splitPane_1.setRightComponent(panel_2);
		panel_2.setLayout(new GridLayout(5,5, 3, 3));
		
		rows = r;
		columns= c;
		panelMat = new JLabel[r + 1][c + 1];
		border = BorderFactory.createLineBorder(borderColor);
		paintPixels();
		if(c>16)
		{
			getIterations();
			hexaSg = new String[iteraciones];
			
		}
		reinicate();
	}
	
	public void createCursor(String ruta)
	{
		/*im = Toolkit.getDefaultToolkit().createImage
				("C:\\Users\\Daniel\\Documents\\workspace Mars\\Graficos\\src\\imagenes\\"+ruta+".png");
		cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(10,10),"WILL");
	   panel.setCursor(cur);*/ 
	}
	
	private void reinicate()
	{
		for (int i=0; i<hexaSg.length; i++)
			hexaSg[i]="";
		hexaCad="";
	}
	
	private void getIterations()
	{
		
		if(columns % 32 == 0)
			iteraciones = columns / 32;
		else
			iteraciones = columns / 32+1;
		System.out.println(iteraciones);
		
	}
	int MINIUM, MAXIUM,cont; 
	
	private void generateCode()
	{
		//jHex=1;
		cont=0;
		MINIUM=1;
		MAXIUM=32;
		potenciaBase = 8;
		hexa = 0;
		
		while(cont<iteraciones)
		{
			hexaSg[cont] = hexaSg[cont].concat(prefijo);
			
			for (jHex=MINIUM; jHex<=MAXIUM; jHex++)
			{
				try
				{
				if (panelMat[iFila][jHex].getBackground() == colorHexa)
					hexa += potenciaBase;

				potenciaBase /= 2;

				if (jHex % 4 == 0 || jHex == panelMat[0].length-1) 
				{
					hexaSg[cont] = hexaSg[cont].concat(Integer.toHexString(hexa));
					potenciaBase = 8;
					hexa = 0;

				}
				}catch (ArrayIndexOutOfBoundsException ex){}
			}
			/*MINIUM = MAXIUM+1;
			getMAXIUM();
			generate32Bits();
			hexaSg[cont] = hexaSg[cont].concat(",\n");
			cont++;*/
			newRow();
		}
	}
	
	final int CODE_NORMAL = 0;
	final int CODE_OPPSITE = 1;
	
	
	private void generateOppsiteCode()
	{
		
		MAXIUM = 32;
		MINIUM = 1;
		hexa=0;
		cont=0;
		
		while(cont < iteraciones)
		{
			hexaSg[cont] = hexaSg[cont].concat(prefijo);
			getMaxiumValors();
			
			for (jHex = MAXIUM; jHex >= MINIUM; jHex--)
			{
				if (panelMat[iFila][jHex].getBackground() == colorHexa)
					hexa += potenciaBase;
				
				potenciaBase /= 2;
				contador++;
				
				if(contador == 4 || jHex==MINIUM)
				{
				    hexaSg[cont]= hexaSg[cont].concat(Integer.toHexString(hexa));
					potenciaBase = 8;
					hexa = 0;
					contador=0;
				}
			}
			
			newRow();
		}
	}
	
	public void upColor()
	{
		for (int i=0; i<panelMat.length; i++)
		{
			for (int j=0; j<panelMat[0].length; j++)
			{
				try
				{
					if(panelMat[i][j].getBackground() == colorHexa)
					{
						panelMat[i-1][j].setBackground(colorHexa);
						panelMat[i][j].setBackground(initialC);
					}
				}
				catch (ArrayIndexOutOfBoundsException ex){}
			}
		}
		
	}
	
	public void returnColor()
	{
		for (int i=0; i<panelMat.length; i++)
		{
			for (int j=0; j<panelMat[0].length; j++)
			{
				try
				{
					if(panelMat[i][j].getBackground() == colorHexa)
					{
						panelMat[i][j-1].setBackground(colorHexa);
						panelMat[i][j].setBackground(initialC);
					}
				}
				catch (ArrayIndexOutOfBoundsException ex){}
			}
		}
	}
	
	private void newRow()
	{
		MINIUM = MAXIUM+1;
		getMAXIUM();
		generate32Bits();
		
		if(iFila % 8 == 0)
			hexaSg[cont] = hexaSg[cont].concat(",\n");

		else
			hexaSg[cont] = hexaSg[cont].concat(", ");
		
		cont++;
	}
	
	private void getMaxiumValors()
	{
		if( cont+1 == iteraciones)
		{
			jHex=panelMat[0].length-1;
			
			if(jHex%4 == 0)
			{
				contador=0;
				potenciaBase = 8;
				return;
			}
			
			if( (jHex+1) % 4 == 0)
			{
				contador=1;
				potenciaBase=4;
				return;
			}
			
			if((jHex-2) % 4 == 0)
			{
				contador=2;
				potenciaBase = 2;
				return;
			}
			
			if( (jHex-1) % 4 == 0)
			{
				contador=3;
				potenciaBase=1;
			}
		}
		else
		{
			potenciaBase=8;
			contador=0;
		}
		
	}
	
	private void getMAXIUM()
	{
		if(cont+2 == iteraciones)
		{
			MAXIUM = panelMat[0].length-1;

		}
		else
		{
			MAXIUM = 32 * (cont+2);
		}
	}
	
	public void generate32Bits() {
		length = hexaSg[cont].substring(hexaSg[cont].lastIndexOf("0x") + 2, hexaSg[cont].length()).length();

		while (length != 8) {
			hexaSg[cont] = hexaSg[cont].concat("0");
			length++;
		}
	}

	public void paintPixels() {
		for (int i = 0; i < panelMat.length; i++) {
			for (int j = 0; j < panelMat[i].length; j++) {
				panelMat[i][j] = new JLabel();
				panelMat[i][j].addMouseListener(this);
				panelMat[i][j].addMouseMotionListener(this);
				panelMat[i][j].setOpaque(true);
				panelMat[i][j].setBorder(borderN);
				panelMat[i][j].setName(i+"_"+j);
				panel.add(panelMat[i][j]);
			}
		}

		for (int i = 1; i < panelMat.length; i++) {
			panelMat[i][0].setHorizontalAlignment(0);
			panelMat[i][0].setOpaque(false);
			panelMat[i][0].setText("" + i);
		}

		for (int j = 1; j < panelMat[0].length; j++) {
			panelMat[0][j].setHorizontalAlignment(0);
			panelMat[0][j].setOpaque(false);
			panelMat[0][j].setText("" + j);
		}
		
		Border borderBottom = BorderFactory.createMatteBorder(1, 1, 3, 1, Color.black);
		
		try
		{
		for (int i=4; i<panelMat.length; i+=4)
		{
			for (int j=1; j<panelMat[0].length; j++)
				panelMat[i][j].setBorder(borderBottom);
		}
		}
		catch (ArrayIndexOutOfBoundsException ec){}
		
		Border borderRight = BorderFactory.createMatteBorder(1, 1, 3, 4, Color.black);
		Border borderRightWB = BorderFactory.createMatteBorder(1, 1, 1, 4, Color.black);
		
		try
		{
		for (int i=1; i<panelMat.length; i++)
		{
			for (int j=4; j<panelMat[0].length; j+=4)
			{
				if(i%4==0)
				panelMat[i][j].setBorder(borderRight);
				else
					panelMat[i][j].setBorder(borderRightWB);
			}
		}
		}
		catch (ArrayIndexOutOfBoundsException ec){}
	}

	public void paintBorder(Color color) {
		border = BorderFactory.createLineBorder(color);
		for (int i = 0; i < panelMat.length; i++) {
			for (int j = 0; j < panelMat[i].length; j++) {
				panelMat[i][j].setBorder(border);
			}
		}
	}

	private boolean isClick = true;
	private boolean isEntered = false;
	private boolean isRelleno = false;

	public void setIsClick(boolean isClic) {
		isClick = isClic;
	}

	public boolean isClick() {
		return isClick;
	}

	public void setIsEntered(boolean isEnt) {
		isEntered = isEnt;
	}

	public boolean isEnterd() {
		return isEntered;
	}

	static JLabel lblClick;
	long ini;
	int jHex, iFila;
	boolean hadEntered=false;
	
	public void generateHexa(int caso) {
		//i = System.currentTimeMillis();
		switch (caso)
		{
			case  CODE_NORMAL:
				for (iFila=1; iFila<panelMain.get(getSelectTabIndex()).panelMat.length; iFila++)
				{
					generateCode();
				}
				break;
			case CODE_OPPSITE:
				
				for (iFila=1; iFila<panelMain.get(getSelectTabIndex()).panelMat.length; iFila++)
				{
					generateOppsiteCode();
				}
				break;
		}
		
		for(int i=0; i<hexaSg.length; i++)
			hexaCad=hexaCad.concat((i+1)+".- "+hexaSg[i]+"\n");
		
		txtArea.setText(hexaCad);
		reinicate();
	}
	
	static Color colorHexa, oldColor;
	static int f,c;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		lblClick = (JLabel) e.getComponent();
		oldColor = lblClick.getBackground();
		
		if (isClick()) 
			setColor();
		
		if (isRelleno())
		{
			f=getPosition().toRow();
			c=toColumn();
			//generateAlghritm();
			pai.paintAllC();
			//pro.get(0).method(f,c);
			//process.method(f, c);
		}
	}

	/*private void generateAlghritm()
	{
		pai.fila=f;
		pai.columna=c;
		
		scan:
		{
		while(pai.hasExited==false)
		{
		for (int i=0; i<pro.size(); i++)
		{
			pro.get(i).method(pai.fila, pai.columna);
			if(pai.hasExited)
				break scan;
		}
		}
		}
		pai.hasExited=false;
	}*/
	
	@Override
	public void mouseEntered(MouseEvent e) 
	{
		lblClick = (JLabel) e.getComponent();
		if (isEnterd())
			setColor();
		
	}

	private void setColor()
	{
		lblClick.setBackground(Main.colorPixel);
		if(!existColor())
		{
			
			panelList.add(new JButton());
			panelList.get(panelList.size()-1).addActionListener(this);
			panelList.get(panelList.size()-1).setBorder(border);
			//panelList.get(panelList.size()-1).setOpaque(true);
			panelList.get(panelList.size()-1).setBackground( lblClick.getBackground());
			panel_2.add(panelList.get(panelList.size()-1));
			panel_2.validate();
		}
	}
	
	
	private boolean existColor()
	{
		for (int i=0; i<panelList.size(); i++)
		{
			if(panelList.get(i).getBackground() == lblClick.getBackground())
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void mousePressed(MouseEvent e) 
	{}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	JButton btnColor;
	private JPanel panel_2;
	private JSplitPane splitPane_1;
	
	@Override
	public void actionPerformed(ActionEvent e) {

		btnColor = (JButton)e.getSource();
		colorHexa = btnColor.getBackground();
		Main.btnPixCr.setBackground(colorHexa);
		Main.colorPixel=colorHexa;
	}

	public boolean isRelleno() {
		return isRelleno;
	}

	public void setRelleno(boolean isRelleno) 
	{
		this.isRelleno = isRelleno;
	}
	
	static String fc[];
	
	public MatrizPx getPosition()
	{
		fc = lblClick.getName().split("_");
		return this;
	}
	
	public static int toRow()
	{
	    return Integer.parseInt(fc[0]);
	}
	
	public static int toColumn()
	{
		return Integer.parseInt(fc[1]);
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	
}
