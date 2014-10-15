package figglewatts.tools.LSDTextureUtility;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LSDTextureUtility extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LSDTextureUtility();
	}
	
	public LSDTextureUtility() {
		this.setSize(400, 300);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setTitle("LSD Texture Utility - By Figglewatts");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createUI();
	}
	
	private void createUI() {
		JButton openButton = new JButton("Open");
		openButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser openFile = new JFileChooser();
				openFile.showOpenDialog(null);
			}
		});
		this.add(openButton, BorderLayout.NORTH);
	}

}
