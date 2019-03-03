package JuegosMesa;

import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import C5Metodos.Alcance;

public class Procces implements ValorOfAll
{
	
	public void Move()
	{
		//System.out.println("Meneando Peizas");
		
		if(AjedrezToggle.togNew != AjedrezToggle.toggle)
		{
			//System.out.println("El boton no fue el mismo que el pasado");
			
			if(AjedrezToggle.haEscogido)
			{
				//System.out.println("Ah escoger¡¡");
				if(AjedrezToggle.siPuede && !AjedrezToggle.isTorre)
				{
					//System.out.println("Aqui si puede comer en diagonal");
					siPuedeComerEnDiag();
				}
				
				else if(AjedrezToggle.togNew.getIcon()==null)
				{
					if(!AjedrezToggle.isTorre)
					{
					//System.out.println("Entre al togMew.getIcon()==null");
					whenTogNewEqNull();
					}
				}
				else 
				{
					if(!AjedrezToggle.isTorre)
					{
					//System.out.println("Entre al else de togMew.getIcon()==null");
					AjedrezToggle.togNew.setSelected(true);
					AjedrezToggle.hasIcon=true;
					AjedrezToggle.haEscogido=true;
					return;
					}
				}

				try
				{
				if(AjedrezToggle.peon.isPeonP1() || AjedrezToggle.peon.isPeonP2())
				{
					if(!AjedrezToggle.siPuede && !AjedrezToggle.isTorre)
					{
						// System.out.println("Checo si es peon");
						 AjedrezToggle.peon.walkPeon();
						 setFalseHasIconChosed();
						 return;
					}
				}
				}catch (NullPointerException ex){}
				
				if(AjedrezToggle.isTorre)
				{
					//System.out.println("Es torre");
					
					if(AjedrezToggle.torres.madeMovValidTorre())
					{
						if(AjedrezToggle.togNew.getIcon()!=null)
							WhoAteWho();
						
						AjedrezToggle.togNew.setIcon(AjedrezToggle.toggle.getIcon());
						AjedrezToggle.toggle.setSelected(false);
						AjedrezToggle.toggle.setIcon(null);
						AjedrezToggle.isTurnP1 = !AjedrezToggle.isTurnP1;
					}
					else
					{
						setFalseHasIconChosed();
						/*AjedrezToggle.toggle.setIcon(AjedrezToggle.respTogle.getIcon());
						AjedrezToggle.respTogle.setIcon(null);
						AjedrezToggle.togNew.setSelected(true);
						AjedrezToggle.toggle.setSelected(false);*/
						returnLastState();
						return;
					}
				}
				
				if(AjedrezToggle.isAfil)
				{
					if(AjedrezToggle.alfil.madeMoveValidAlfil())
					{
						showMessage("Moviemnto valido ", "Alfil",1);
						
					}
					else
					{
						//showMessage("Moviemnto no valido ", "Alfil",1);
						setFalseHasIconChosed();
						AjedrezToggle.toggle.setIcon(AjedrezToggle.respTogle.getIcon());
						AjedrezToggle.respTogle.setIcon(null);
						AjedrezToggle.togNew.setSelected(true);
						AjedrezToggle.toggle.setSelected(false);
						//returnLastState();
						return;
					}
				}
				
				setFalseHasIconChosed();
			}
		}
	}
	
	public void siPuedeComerEnDiag()
	{
		if(AjedrezToggle.togNew.getIcon()!=null)
		{
			if(hizoMovimientoValido())
			{
			if(isOfPlayer1(AjedrezToggle.toggle))
			{
				if(AjedrezToggle.isTurnP1)
				{
					if(AjedrezToggle.peon.isPeonP2())
					{
						AjedrezToggle.bancsP1
						[AjedrezToggle.peonesToLeft][0].setIcon(AjedrezToggle.togNew.getIcon());
						AjedrezToggle.peonesToLeft++;
					}
					else
					{
						WichIs.find();
					}
				}
				else
				{
					//showMessage("Lo siento no era tu turno");
					AjedrezToggle.toggle.setSelected(false);
					return;
				}
			}
			else
			{
				
				if(!AjedrezToggle.isTurnP1)
				{
					if(AjedrezToggle.peon.isPeonP1())
					{
					AjedrezToggle.bancsP2[AjedrezToggle.peonesToRight][1].setIcon(AjedrezToggle.togNew.getIcon());
					AjedrezToggle.peonesToRight++;
					}
					else
					{
						WichIs.find();
					}
				}
				else
				{
					//showMessage("Lo siento no era tu truno");
					AjedrezToggle.toggle.setSelected(false);
					return;
				}
			}
			whenTogNewEqNull();
			setFalseHasIconChosed();
			AjedrezToggle.isTurnP1=!AjedrezToggle.isTurnP1;
			return;
			}
			else
			{ 
				AjedrezToggle.toggle.setSelected(false);
				setFalseHasIconChosed();
				return;
			}
		}
		else
		{
			whenTogNewEqNull();
		}

		if(AjedrezToggle.peon.isPeonP1() || AjedrezToggle.peon.isPeonP2())
		{
			AjedrezToggle.peon.walkPeon();
			AjedrezToggle.togNew.setSelected(true);
		}
	}
	
	private void whenTogNewEqNull()
	{
		AjedrezToggle.togNew.setIcon(AjedrezToggle.toggle.getIcon());
		AjedrezToggle.toggle.setSelected(false);
		AjedrezToggle.toggle.setIcon(null);
		AjedrezToggle.newFila = getNewFila();
		AjedrezToggle.newCol = getNewCol();
	}
	
	private void setFalseHasIconChosed()
	{
		AjedrezToggle.hasIcon=false;
		AjedrezToggle.haEscogido=false;
	}
}
