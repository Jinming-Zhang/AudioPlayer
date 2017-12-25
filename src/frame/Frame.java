package frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import audioPlayer.*;

public class Frame extends JFrame {
	private JButton play;
	public Frame() {
		setLayout(new FlowLayout()); // "super" Frame sets to FlowLayout
		JPanel mainPanel = new JPanel();;
		play = new JButton("play");
		play.addActionListener(new ButtonListener());
		mainPanel.add(play);
		this.getContentPane().add(mainPanel);
		this.setUp();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void setUp() {
		// setup frame size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() * 0.618);
		int height = (int) (screenSize.getHeight() * 0.618);
		this.setSize(width, height);
		// setup frame title
		this.setTitle("Wolfy");
		this.setVisible(true);
	}

	/**
	 * BtnCountListener is a "named inner class" used as ActionListener. This
	 * inner class can access private variables of the outer class.
	 */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			String path = "C:/Users/WolfFurry/Desktop/fiveHour.wav";
			AudioPlayer playmusic = new Music(path);
			JButton ob = ((JButton)evt.getSource());
			playmusic.play();
			while(playmusic.isPlaying()){
				ob.setEnabled(false);System.out.print("playing");
			}
			ob.setEnabled(true);
		}
	}
}
