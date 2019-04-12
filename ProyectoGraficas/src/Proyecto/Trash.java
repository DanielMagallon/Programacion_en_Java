package Proyecto;


public class Trash
{
	/*
	 * 			
//			JLabel lblRe = new JLabel("Escalar en x/y g. barras");
//			lblRe.setBounds(810, 15, 170, 30);
//			btRezise = new JButton(getImageIcon("resize.png"));
//			btRezise.setBounds(850, 45, 36, 36);
//			btRezise.addActionListener((a)->
//			{
//				
//				pestanas.getAreaDibujo().escalar(xScale,yScale);
//				
//			});
//			btRezise.setBackground(Color.white);
//			
//			panelCongG.add(lblRe);
//			panelCongG.add(btRezise);
	 * 
	 * 
	MaximizedGraph mx = new MaximizedGraph();
	
	class MaximizedGraph extends JDialog
	{
		JScrollPane sc;
		public MaximizedGraph()
		{
			setBounds((GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds()));
			setModal(true);
			
			sc = new JScrollPane();
			add(sc);
		}
		 
		public MaximizedGraph setGraifca()
		{
			AreaDibujo ad = new AreaDibujo(area.getTypheGraph(),
					area.gr.getFrecuenciasCat(),area.gr.getCategorias());
			ad.setBounds(0, 0, dimension, dimension);
			ad.setPreferredSize(new Dimension(dimension, dimension));
			sc.setViewportView(ad);
			return this;
		}

	}
	 */
//	private void crearButtons()
//	{
//		ImageIcon imgs[] = 
//			{
//					getImageIcon("Images/", "nuevo.png"),
//					new ImageIcon()
//			};
//		
//		JButton[] btnFuncions = new JButton[imgs.length];
//	
//		
//		for(i=0; i<btnFuncions.length; i++)
//		{
//			btnFuncions[i] = new JButton(imgs[i]);
//			btnFuncions[i].addActionListener(actionesSecun[i]);
//			barraHerramientas.add(btnFuncions[i]);
//		}
//		
//	}
	

//	else if(nroRotacion == 2)
//	{
//		nx = y+espacioBarras+LINEA_SALIENTE;
//		g.drawLine(x+anchoEjex,y,x+anchoEjex,y+anchoEjex+LINEA_SALIENTE);//Vert
//		posX3 = x+anchoEjex;
//		g.drawLine(posX3-mayor, y+LINEA_SALIENTE, x+anchoEjex+LINEA_SALIENTE, y+LINEA_SALIENTE);
//		
//		for(i=0; i<disp.length; i++)
//		{
//			g.setColor(colores[i]);
//			g.fillRect(posX3-mayor+(mayor-disp[i]),nx,disp[i],anchoBarras);
//			nx+=espacioBarras+anchoBarras;
//		}
//	}
//	
//	else
//	{
//		g.drawLine(x, interseccion, x+anchoEjex+LINEA_SALIENTE, interseccion);//Hoti
//		g.drawLine(x + anchoEjex, y, x + anchoEjex, y+mayor+LINEA_SALIENTE);
//		nx=x+espacioBarras;
//		
//		for(i=disp.length-1; i>=0; i--)
//			{
//				g.setColor(colores[i]);
//				g.fillRect(nx, (interseccion-disp[i]), anchoBarras,disp[i]);
//				nx+=espacioBarras+anchoBarras;
//			}
//	}
}
