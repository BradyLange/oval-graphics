package com.github.bradylange.ovalgraphics.window;

// Import AWT library - color, event handling
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Import Swing library - window components
import javax.swing.JButton;
import javax.swing.JFrame;
// Import classes
import com.github.bradylange.ovalgraphics.shapes.Oval;

/**
 * <p>
 * 		Displays a specific number of {@link Oval}s as graphics on a window 
 * 		which contains four buttons that will either change one random 
 * 		{@link Oval}'s color or location or change all of the {@link Oval}s 
 * 		colors or locations.
 * </p>
 * <p>
 * 		Implements {@link ActionListener} which allows it to handle events, 
 * 		such as when a button is clicked on the graphic user interface. 
 * </p>
 * <p>
 * 		Depends on:
 * </p>
 * <ul>
 * 		<li>
 * 			{@link Oval}
 * 		</li>
 * </ul>
 * 
 * @author  Brady Lange - <a href = "https://www.linkedin.com/in/brady-lange/"
 * target = "_blank">LinkedIn</a>
 * @version  1.0.0 (03/25/2019)
 * @since  1.0 (03/25/2019)
 */                                                                     																																																																												
public class OvalUpdater implements ActionListener
{
	// Instance variables
	/**
	 * Window shell for the application to be displayed upon.
	 */
	private JFrame window;
	/**
	 * Move one {@link Oval} button.
	 */
	private JButton moveOneBtn;
	/**
	 * Move all {@link Oval}s button.
	 */
	private JButton moveAllBtn;
	/**
	 * Color one {@link Oval} button.
	 */
	private JButton colorOneBtn;
	/**
	 * Color all {@link Oval}s button.
	 */
	private JButton colorAllBtn;
	/**
	 * Collection of colors for the {@link Oval} objects.
	 */
	private Color[] colors;
	/**
	 * Total number of {@link Oval} objects to be displayed as graphics.
	 */
	private final  int numOvals = 20;
	/**
	 * Collection of {@link Oval} objects.
	 */
	private Oval[] ovals;

// ----------------------------------------------------------------------------
//	Default Constructor
// ----------------------------------------------------------------------------
	/**
	 * Constructs a {@link OvalUpdater} object that makes an application 
	 * {@link #window}, adds buttons that change the {@link Oval}'s 
	 * location or color, creates colors, and adds {@link #numOvals} 
	 * random {@link Oval}s.
	 */
	public OvalUpdater()
	{
		makeWindow();
		addButtons();
		makeColors();
		addOvals();
	}
	
// ----------------------------------------------------------------------------
//	Make Window Method
// ----------------------------------------------------------------------------
	/**
	 * Creates the {@link #window} shell of the application.
	 */
	private void makeWindow()
	{
		window = new JFrame();
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Oval Updater");
		window.setLocation(50, 50);
		window.setSize(1000, 600);
		window.setResizable(false);
		window.getContentPane().setBackground(Color.white);
		window.setVisible(true);
		window.repaint();  
	}
	
// ----------------------------------------------------------------------------
//	Add Buttons Method
// ----------------------------------------------------------------------------
	/**
	 * Adds the {@link #moveOneBtn}, {@link #moveAllBtn}, {@link #colorAllBtn}, 
	 * and {@link #colorAllBtn} to the {@link #window}.
	 */
	private void addButtons()
	{
		// Instantiate move one button
		moveOneBtn = new JButton("Move One");
		moveOneBtn.addActionListener(this);
		moveOneBtn.setBounds(window.getWidth() / 4 - 200, 
				             window.getHeight() - 100, 100, 50);
		window.add(moveOneBtn);
		// Instantiate move all button 
		moveAllBtn = new JButton("Move All");
		moveAllBtn.addActionListener(this);
		moveAllBtn.setBounds(window.getWidth() / 4, 
				             window.getHeight() - 100, 100, 50);
		window.add(moveAllBtn);
		// Instantiate color one button
		colorOneBtn = new JButton("Color One");
		colorOneBtn.addActionListener(this);
		colorOneBtn.setBounds(window.getWidth() / 4 + 400, 
				              window.getHeight() - 100, 100, 50);
		window.add(colorOneBtn);
		// Instantiate color all button
		colorAllBtn = new JButton("Color All");
		colorAllBtn.addActionListener(this);
		colorAllBtn.setBounds(window.getWidth() / 4 + 600, 
				              window.getHeight() - 100, 100, 50);
		window.add(colorAllBtn);
	}
	
// ----------------------------------------------------------------------------
//	Add Ovals Method
// ----------------------------------------------------------------------------
	/**
	 * Adds the specified number of {@link Oval}s ({@link #numOvals}) to 
	 * the {@link #window}.
	 */
	private void addOvals()
	{
		ovals = new Oval[numOvals];
		int randWidth;
		int randHeight;
		int randX;
		int randY;
		for (int i = 0; i < ovals.length; i++)
		{
			randWidth = (int) (Math.random() * 100 + 5);
			randHeight = (int) (Math.random() * 100 + 5);
			randX = (int) (Math.random() * (window.getWidth() - randWidth));
			randY = (int) (Math.random() * (window.getHeight() - randHeight));
			ovals[i] = new Oval(randX, randY, randWidth, randHeight);
			window.add(ovals[i]);
		}
	}
	
// ----------------------------------------------------------------------------
//	Move One Method
// ----------------------------------------------------------------------------
	/**
	 * Moves one random {@link Oval} using x and y location coordinate points.
	 */
	private void moveOne()
	{
		int randOval = (int) (Math.random() * numOvals);
		int randX = (int) (Math.random() * 
				          (window.getWidth() - ovals[randOval].getWidth()));
		int randY = (int) (Math.random() * 
				          (window.getHeight() - ovals[randOval].getHeight()));
		ovals[randOval].setLocation(randX , randY);
	}

// ----------------------------------------------------------------------------
//	Move All Method
// ----------------------------------------------------------------------------
	/**
	 * Moves all of the {@link Oval}s to different random x and y coordinate 
	 * locations.
	 */
	private void moveAll()
	{
		int randX;
		int randY;
		int maxWidth = ovals[0].getWidth();
		int maxHeight = ovals[0].getHeight();
		for (int i = 0; i < ovals.length; i++)
		{
			if (ovals[i].getWidth() > maxWidth)
			{
				maxWidth = ovals[i].getWidth();
			}
			if (ovals[i].getHeight() > maxHeight)
			{
				maxHeight = ovals[i].getHeight();
			}
		}
		for (int i = 0; i < ovals.length; i++)
		{
			randX = (int) (Math.random() * (window.getWidth() - maxWidth));
			randY = (int) (Math.random() * (window.getHeight() - maxHeight));
			ovals[i].setLocation(randX , randY);
		}
	}
	
// ----------------------------------------------------------------------------
//	Color One Method
// ----------------------------------------------------------------------------
	/**
	 * Colors one random {@link Oval} using one of the specified 
	 * {@link #colors} randomly.
	 */
	private void colorOne()
	{
		int randOval = (int) (Math.random() * numOvals);
		int randColor = (int) (Math.random() * (colors.length));
		ovals[randOval].setBackground(colors[randColor]);
	}

// ----------------------------------------------------------------------------
//	Color All Method
// ----------------------------------------------------------------------------
	/**
	 * Colors all of the {@link Oval}s using one of the specified 
	 * {@link #colors} randomly.
	 */
	private void colorAll()
	{
		int randColor = (int) (Math.random() * (colors.length));
		for (int i = 0; i < ovals.length; i++)
		{
			ovals[i].setBackground(colors[randColor]);
		}
	}
	
// ----------------------------------------------------------------------------
//	Make Colors Method
// ----------------------------------------------------------------------------
	/**
	 * Instantiates the colors used for the {@link Oval}s.
	 */
	private void makeColors()
	{
		colors = new Color[5];
		colors[0] = Color.red;
		colors[1] = Color.green;
		colors[2] = Color.blue;
		colors[3] = Color.orange;
		colors[4] = Color.yellow;
	}

// ----------------------------------------------------------------------------
//	Action Performed Method
// ----------------------------------------------------------------------------
	/**
	 * Overrides the interface {@link ActionListener}'s method 
	 * {@link #actionPerformed} to specify the actions carried out when 
	 * {@link #moveOneBtn}, {@link #moveAllBtn}, {@link #colorOneBtn}, or 
	 * {@link #colorAllBtn} is clicked. 
	 * 
	 * @param e  Action event 
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == moveOneBtn)
		{
			moveOne();
		}
		else if (e.getSource() == moveAllBtn)
		{
			moveAll();
		}
		else if (e.getSource() == colorOneBtn)
		{
			colorOne();
		}
		else if (e.getSource() == colorAllBtn)
		{
			colorAll();
		}
	}
}