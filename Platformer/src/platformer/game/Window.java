package platformer.game;

import java.awt.Canvas;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Window extends Canvas{
	private JFrame frame;
	private String caption;
	private int width, height, scale;
	private boolean resizable;
	private BufferedImage icon;
	public Window(String caption, int width, int height, int scale, boolean resizable, BufferedImage icon){
		this.caption = caption;
		this.resizable = resizable;
		this.width = width;
		this.height = height;
		this.scale = scale;
		this.icon = icon;
		this.frame = new JFrame(caption);
		this.frame.setSize((width*scale)+6, (height*scale)+35);
		this.frame.setResizable(resizable);
		this.frame.setIconImage(icon);
		this.frame.setLocationRelativeTo(null);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.add(this);
	}
	public void launchWindow(){
		frame.setVisible(true);
	}
	//sets
	public void setCaption(String caption){
		frame.setTitle(caption);
	}
	//Gets
	public int getScale(){
		return scale;
	}
	public JFrame getFrame(){
		return frame;
	}
	public BufferedImage getIcon(){
		return icon;
	}
}
