package com.github.bradylange.ovalgraphics.shapes;

// Import AWT library - colors, graphics
import java.awt.Color;
import java.awt.Graphics;
// Import Swing library - window components
import javax.swing.JComponent;

/**
 * <p>
 * 	Constructs a simple oval shape graphic with the default color of black. 
 * 	Extends {@link JComponent} so it can be considered a graphic component 
 * 	on the application since it receives all of {@link JComponent}'s properties.
 * </p>
 * 
 * @author Brady Lange - <a href = "https://www.linkedin.com/in/brady-lange/" target = "_blank">LinkedIn</a>
 * @version 1.0.0 (03/25/2019)
 * @since 1.0 (03/25/2019)
 */
@SuppressWarnings("serial")
public class Oval extends JComponent
{
	// Instance variables
	/**
	 * Position on the horizontal axis.
	 */
	private int x;
	/**
	 * Position on the vertical axis.
	 */
	private int y;
	/**
	 * Measurement from side to side.
	 */
	private int width;
	/**
	 * Measurement from bottom to top.
	 */
	private int height;
	
// ---------------------------------------------------------------------------------------------------------------------
// 	Default Constructor
// ---------------------------------------------------------------------------------------------------------------------
	/**
	 * Constructs an {@link Oval} object with the boundaries of location ({@link #x}, , {@link #x}) 
	 * and size ({@link #width}, {@link #height}) with the default interior {@link Color} of black.
	 * 
	 * @param x  {@link #x}-coordinate
	 * @param y  {@link #y}-coordinate
	 * @param width  {@link #width}
	 * @param height  {@link #height}
	 */
	public Oval(int x, int y, int width, int height)
	{
		// Instantiate default constructor of parent class - JComponent
		super();
		// Instantiate instance variables with parameter values
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		// Set oval's location and size
		setBounds(this.x, this.y, this.width, this.height);
		// Set default circle oval color
		setBackground(Color.black);
	}

// ---------------------------------------------------------------------------------------------------------------------
//	Paint Method
// ---------------------------------------------------------------------------------------------------------------------	
	/**
	 * Overrides {@link JComponent#paint(Graphics g)} method and
	 * draws an {@link Oval} that is filled with the color of the current background specified. 
	 * 
	 * @param g  Graphics object used to draw
	 */
	@Override
	public void paint(Graphics g)
	{
		// Set oval's interior color
		g.setColor(getBackground());
		// Fill oval's interior with the set color
		g.fillOval(0, 0, getWidth(), getHeight());
		// Paint the current oval graphic 
		paintChildren(g);
	}
}