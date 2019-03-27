package com.github.bradylange.ovalgraphics.application;

// Import classes
import com.github.bradylange.ovalgraphics.shapes.Oval;
import com.github.bradylange.ovalgraphics.window.OvalUpdater;

/**
 * <p>
 * 		Constructs a graphic user interface which has {@link Oval} graphics on it and allows
 * 		for the {@link Oval}s and allows colors and locations of all or one random {@link Oval} 
 * 		to be updated. Contains the {@link #main} method and "glues" other classes together.
 * </p>
 * <p>
 * 		Depends on:
 * </p>
 * <ul>
 * 		<li>
 * 			{@link OvalUpdater}
 * 		</li>
 * </ul>
 * 
 * @author  Brady Lange - <a href = "https://www.linkedin.com/in/brady-lange/"
 *                                                target = "_blank">LinkedIn</a>
 * @version  1.0.0 (03/25/2019)
 * @since  1.0 (03/25/2019)
 */
public class Driver
{
// -----------------------------------------------------------------------------------------------
// Main Method
// -----------------------------------------------------------------------------------------------
	/**
	 * Instantiates and sets up a {@link OvalUpdater}.
	 * 
	 * @param args  Array of command line arguments to be passed
	 */
	public static void main(String[] args)
	{
		// Instantiate the OvalUpdater object
		@SuppressWarnings("unused")
		OvalUpdater ovalGraphics = new OvalUpdater();
	}
}