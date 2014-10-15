package figglewatts.tools.LSDTextureUtility;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageImplement extends JPanel {
	
	private Image img;
	
	public ImageImplement() {
		this.setLayout(null);
	}
	
	public ImageImplement(Image img) {
		this.img = img;
		recalculateSize();
		setLayout(null);
		this.repaint();
	}
	
	private void recalculateSize() {
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
	}
	
	public void setImg(Image img) {
		this.img = img;
		recalculateSize();
		this.repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}
}
