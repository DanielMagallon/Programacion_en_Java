package BitMap;

import static BitMap.Main.*;
import static BitMap.MatrizPx.*;

import java.io.Serializable;

public class PaintMoved implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7742311577670735407L;

	int fila,columna;
	boolean hasExited=false;
	
	public void paintAllC()
	{
		paintTopRL(f-1, c);
		paintBottomRL(f+1, c);
		paintRightTB(f, c+1);
		paintLeftTB(f, c-1);
	}
	
	public PaintMoved paintBottomRL(int i, int j)
	{
		try
		{
		if(continued(i, j))
		{
			panelMain.get(getSelectTabIndex()).panelMat[i][j].setBackground(Main.colorPixel);
			paintBottomRL(i-1, j);
			paintRightTB(i, j+1);
			paintLeftTB(i, j-1);
		}
		}catch (ArrayIndexOutOfBoundsException ex){};
		
		return this;
	}
	
	public PaintMoved paintTopRL(int i, int j)
	{
		try
		{
		if(continued(i, j))
		{
			panelMain.get(getSelectTabIndex()).panelMat[i][j].setBackground(Main.colorPixel);
			paintTopRL(i-1, j);
			paintRightTB(i, j+1);
			paintLeftTB(i, j-1);
		}
		}catch (ArrayIndexOutOfBoundsException ex){};
		
		return this;
	}
	
	public PaintMoved paintRightTB(int i, int j)
	{
		try
		{
		if(continued(i, j))
		{
			panelMain.get(getSelectTabIndex()).panelMat[i][j].setBackground(Main.colorPixel);
			paintRightTB(i, j+1);
			paintTopRL(i-1, j);
			paintBottomRL(i+1, j);
		}
		}catch (ArrayIndexOutOfBoundsException ex){};
		
		return this;
	}
	

	public PaintMoved paintLeftTB(int i, int j)
	{
		try
		{
		if(continued(i, j))
		{
			panelMain.get(getSelectTabIndex()).panelMat[i][j].setBackground(Main.colorPixel);
			paintLeftTB(i, j-1);
			paintBottomRL(i+1, j);
			paintTopRL(i-1, j);
			
		}
		}catch (ArrayIndexOutOfBoundsException ex){};
		return this;
	}
	
	public PaintMoved paintTop(int i, int j)
	{
		try
		{
		if(continued(i, j))
		{
			panelMain.get(getSelectTabIndex()).panelMat[i][j].setBackground(Main.colorPixel);
			//paintTop(i-1, j);
		}else hasExited=true;
		}catch (ArrayIndexOutOfBoundsException ex){hasExited=true;};
		fila=i;
		columna=j;
		return this;
	}
	
	public PaintMoved paintBottom(int i, int j)
	{
		try
		{
		if(continued(i, j))
		{
			panelMain.get(getSelectTabIndex()).panelMat[i][j].setBackground(Main.colorPixel);
			//paintBottom(i+1, j);
		} else hasExited=true;
		}catch (ArrayIndexOutOfBoundsException ex){hasExited=true;};
		fila=i;
		columna=j;
		return this;
	}
	
	public PaintMoved paintLeft(int i, int j)
	{
		try
		{
		if(continued(i, j))
		{
			panelMain.get(getSelectTabIndex()).panelMat[i][j].setBackground(Main.colorPixel);
			//paintLeft(i, j-1);
		}
		else hasExited=true;
		}catch (ArrayIndexOutOfBoundsException ex){hasExited=true;};
		fila=i;
		columna=j;
		return this;
	}
	
	public PaintMoved paintRight(int i, int j)
	{
		try
		{
		if(continued(i, j))
		{
			panelMain.get(getSelectTabIndex()).panelMat[i][j].setBackground(Main.colorPixel);
			//paintRight(i, j+1);
		} else hasExited=true;
		}catch (ArrayIndexOutOfBoundsException ex){hasExited=true;};
		fila=i;
		columna=j;
		return this;
	}
	
	private boolean continued(int i, int j)
	{
		return panelMain.get(getSelectTabIndex()).panelMat[i][j].getBackground() == oldColor && 
				panelMain.get(getSelectTabIndex()).panelMat[i][j].getBackground() != Main.colorPixel;
	}
	
	public void paintDiagonal4()
	{
		paintDiagonalUL(f-1, c-1);
		paintDiagonalUR(f-1, c+1);
		paintDiagonalDR(f+1, c+1);
		paintDiagonalDL(f+1, c-1);
	}
	
	public PaintMoved paintDiagonalUL(int i, int j)
	{
		try
		{
		if(continued(i, j))
		{
			panelMain.get(getSelectTabIndex()).panelMat[i][j].setBackground(Main.colorPixel);
			paintDiagonalUL(i-1, j-1);
		}
		}catch (ArrayIndexOutOfBoundsException ex){};
		
		return this;
	}
	
	public PaintMoved paintDiagonalUR(int i, int j)
	{
		try
		{
		if(continued(i, j))
		{
			panelMain.get(getSelectTabIndex()).panelMat[i][j].setBackground(Main.colorPixel);
			paintDiagonalUR(i-1, j+1);
		}
		}catch (ArrayIndexOutOfBoundsException ex){};
		
		return this;
	}
	
	public PaintMoved paintDiagonalDR(int i, int j)
	{
		try
		{
		if(continued(i, j))
		{
			panelMain.get(getSelectTabIndex()).panelMat[i][j].setBackground(Main.colorPixel);
			paintDiagonalDR(i+1, j+1);
		}
		}catch (ArrayIndexOutOfBoundsException ex){};
		
		return this;
	}
	
	public PaintMoved paintDiagonalDL(int i, int j)
	{
		try
		{
		if(continued(i, j))
		{
			panelMain.get(getSelectTabIndex()).panelMat[i][j].setBackground(Main.colorPixel);
			paintDiagonalDL(i+1, j-1);
		}
		}catch (ArrayIndexOutOfBoundsException ex){};
		
		return this;
	}
}
