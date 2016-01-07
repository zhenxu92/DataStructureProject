import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * This program appeared in 
 * "Java GUI Tutorial: Mastering the Basics"
 * October 21, 2013 by Bryan Wilde 
 * https://blog.udemy.com/java-gui-tutorial/
 * 
 * Downloaded and re-formatted by S. Tanimoto
 * for use by students in CSE 373, Winter 2016.
 * Tested using Eclipse "Mars" and Java jre1.8.0_66.
 */

public  class RectangleAreaCalculator extends JFrame
{

	private JLabel lengthLabel, widthLabel, areaLabel;
	private JTextField lengthText, widthText, areaText;
	private JButton calculateButton, exitButton;

	private static final int HEIGHT = 400;
	private static final int WIDTH = 700;

	private CalculateButtonHandler calculateButtonHandler;
	private ExitButtonHandler exitButtonHandler;

	public RectangleAreaCalculator()
	{
		lengthLabel = new JLabel("Please enter the rectangle's length: ");
		widthLabel = new JLabel("Please enter the rectangles's width: ");
		areaLabel = new JLabel("The Area is: ", SwingConstants.RIGHT);

		lengthText = new JTextField(12);
		widthText = new JTextField(12);
		areaText = new JTextField(12);

		//This section specifies the handlers for the buttons and adds an ActionListener.
		calculateButton = new JButton("What's the Area?");
		calculateButtonHandler = new CalculateButtonHandler();
		calculateButton.addActionListener(calculateButtonHandler);
		exitButton = new JButton("Close");
		exitButtonHandler = new ExitButtonHandler();
		exitButton.addActionListener(exitButtonHandler);

		setTitle("Rectangle Area Calculator");
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(4, 2));

		//Grid layout requires that you add components to the content pane in the order they should appear
		pane.add(lengthLabel);
		pane.add(lengthText);
		pane.add(widthLabel);
		pane.add(widthText);
		pane.add(areaLabel);
		pane.add(areaText);
		pane.add(calculateButton);
		pane.add(exitButton);

		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class CalculateButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			double width, length, area;

			length = Double.parseDouble(lengthText.getText());                                 
			width = Double.parseDouble(widthText.getText());
			area = length * width;

			areaText.setText("" + area);
		}
	}

	public class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}

	public static void main(String[] args)
	{
		RectangleAreaCalculator rectObj = new RectangleAreaCalculator();
	}

}