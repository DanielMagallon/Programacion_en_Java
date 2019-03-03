package C3IntruccionesControl1;

import javax.swing.JFrame;

public class PanelDibujo3DPru {
	public static void main(String[] args) {
		PanelDibujo3D panel = new PanelDibujo3D();

		JFrame aplication = new JFrame();

		aplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		aplication.add(panel);
		aplication.setSize(300, 300);
		aplication.setVisible(true);
	}
}
