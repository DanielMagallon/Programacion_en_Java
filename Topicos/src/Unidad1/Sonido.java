package Unidad1;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.Graphics;
import java.net.URL;

public class Sonido extends Applet
{
	AudioClip audio;
	Button bPlay,bStop,bLoop;
	
	public void init() 
	{
		setSize(600,400);
		URL url = getClass().getResource("/Unidad1/Recursos/photon.wav");
		audio = getAudioClip(url);
		
		bPlay = new Button("Play"); 
		/*{
			@Override
			public void paint(Graphics g) 
			{
				g.fillRect(10, 10, 10, 10);
			}
		};*/
		bStop = new Button("Stop");
		bLoop = new Button("Loop");
		
		
		add(bPlay);
		add(bStop);
		add(bLoop);
		
		bPlay.addActionListener(
					(a) -> audio.play()
				);
		

		bStop.addActionListener(
					(a) -> audio.stop()
				);

		bLoop.addActionListener(
				(a) -> audio.loop()
			);
	}
}
