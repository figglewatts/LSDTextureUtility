package figglewatts.lsdrsdk.LSDTextureUtility;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class LSDTextureUtility extends JFrame {
	
	public List<BufferedImage> loadedTextures = new ArrayList<BufferedImage>();
	
	public int indexOfCurrentTexture = 0;
	public boolean texturesLoaded = false;
	
	public ImageImplement panel;
	
	public boolean[][] textureSlices = new boolean[4][4];
	
	public File bmpDir;
	
	public final int TILE_LENGTH = 64;
	
	private boolean addedPanel = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LSDTextureUtility();
	}
	
	public LSDTextureUtility() {
		this.setSize(400, 450);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		this.setTitle("LSD Texture Utility - By Figglewatts");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createUI();
	}
	
	private void createUI() {
		JButton openButton = new JButton("Open");
		openButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser();
				for(BufferedImage i : loadedTextures) {
					System.out.println(i.getWidth());
				}
			}
		});
		this.add(openButton);
		
		JButton prevButton = new JButton("Previous");
		prevButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (indexOfCurrentTexture > 0) {
					System.out.println("index going down");
					indexOfCurrentTexture--;
					panel.setImg(loadedTextures.get(indexOfCurrentTexture));
				}
			}
		});
		this.add(prevButton);
		
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (indexOfCurrentTexture < loadedTextures.size()-1) {
					System.out.println("index going up");
					indexOfCurrentTexture++;
					panel.setImg(loadedTextures.get(indexOfCurrentTexture));
				}
			}
		});
		this.add(nextButton);
		
		final JTextField exportName = new JTextField(10);
		this.add(exportName);
		
		JButton exportButton = new JButton("Export");
		exportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportImageSection(exportName.getText());
			}
		});
		this.add(exportButton);
		
		JPanel checkBoxPanel = new JPanel();
		checkBoxPanel.setLayout(new GridLayout(4, 4));
		JCheckBox cb1 = new JCheckBox();
		cb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[0][0] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb1);
		
		JCheckBox cb2 = new JCheckBox();
		cb2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[0][1] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb2);
		
		JCheckBox cb3 = new JCheckBox();
		cb3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[0][2] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb3);
		
		JCheckBox cb4 = new JCheckBox();
		cb4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[0][3] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb4);
		
		JCheckBox cb5 = new JCheckBox();
		cb5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[1][0] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb5);
		
		JCheckBox cb6 = new JCheckBox();
		cb6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[1][1] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb6);
		
		JCheckBox cb7 = new JCheckBox();
		cb7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[1][2] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb7);
		
		JCheckBox cb8 = new JCheckBox();
		cb8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[1][3] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb8);
		
		JCheckBox cb9 = new JCheckBox();
		cb9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[2][0] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb9);
		
		JCheckBox cb10 = new JCheckBox();
		cb10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[2][1] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb10);
		
		JCheckBox cb11 = new JCheckBox();
		cb11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[2][2] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb11);
		
		JCheckBox cb12 = new JCheckBox();
		cb12.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[2][3] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb12);
		
		JCheckBox cb13 = new JCheckBox();
		cb13.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[3][0] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb13);
		
		JCheckBox cb14 = new JCheckBox();
		cb14.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[3][1] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb14);
		
		JCheckBox cb15 = new JCheckBox();
		cb15.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[3][2] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb15);
		
		JCheckBox cb16 = new JCheckBox();
		cb16.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textureSlices[3][3] = !(e.getStateChange() != 1);
			}
		});
		checkBoxPanel.add(cb16);
		
		this.add(checkBoxPanel);
		checkBoxPanel.repaint();
		
		JLabel sizeLabel = new JLabel();
		if (texturesLoaded) {
			sizeLabel.setText(loadedTextures.get(indexOfCurrentTexture).getWidth() + ", " + loadedTextures.get(indexOfCurrentTexture).getHeight());
		}
	}
	
	private void fileChooser() {
		JFileChooser openFile = new JFileChooser();
		openFile.setMultiSelectionEnabled(true);
		openFile.showOpenDialog(this);
		bmpDir = openFile.getCurrentDirectory();
		processLoadedTextures(openFile.getSelectedFiles());
		drawTexture();
	}
	
	private void drawTexture() {
		panel = new ImageImplement();
		panel.setImg(loadedTextures.get(indexOfCurrentTexture));
		if (!addedPanel) {
			this.add(panel);
			addedPanel = true;
		}
		panel.repaint();
		panel.revalidate();
	}
	
	private void processLoadedTextures(File[] textures) {
		loadedTextures.clear();
		indexOfCurrentTexture = 0;
		for(File f : textures) {
			try {
				loadedTextures.add(ImageIO.read(f));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		texturesLoaded = true;
	}
	
	private void exportImageSection(String imageName) {
		BufferedImage bImage = loadedTextures.get(indexOfCurrentTexture);
		File theDir = new File(bmpDir.getPath() + "/processed/");
		if (!theDir.exists()) {
			theDir.mkdir();
		}
		File outputFile = new File(theDir.getPath() + "/" + imageName + ".png");
		
		int highestY = 0;
		int highestX = 0;
		int lowestY = 0;
		int lowestX = 0;
		boolean foundLowest = false;
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if (textureSlices[y][x] == true) {
					if (!foundLowest) {
						lowestY = y;
						lowestX = x;
						foundLowest = true;
					}
					highestY = y;
					highestX = x;
				}
			}
		}
		
		int dX = Math.abs(highestX - lowestX)+1;
		int dY = Math.abs(highestY - lowestY)+1;
		int startPosX = 0;
		if (highestX > lowestX) {
			startPosX = lowestX;
		} else {
			startPosX = highestX;
		}
		int startPosY = 0;
		if (highestY > lowestY) {
			startPosY = lowestY;
		} else {
			startPosY = highestY;
		}
		
		int texStartX = startPosX * TILE_LENGTH;
		int texStartY = startPosY * TILE_LENGTH;
		int texWidth = dX * TILE_LENGTH;
		int texHeight = dY * TILE_LENGTH;
		BufferedImage toExport = bImage.getSubimage(texStartX, texStartY, texWidth, texHeight);
		try {
			ImageIO.write(toExport, "png", outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
