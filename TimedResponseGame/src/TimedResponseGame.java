import java.util.concurrent.TimeUnit;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * @author Shen Jiang
 * 
 * This program is to Measure the time taken by the user between the clicking of the Start button 
 * and the Stop button.
 * 
 * */

public class TimedResponseGame extends JFrame {
	private long startTime, timeElapsed;
	
	private JButton startButton, stopButton;
	private JLabel info, result;
	
    private static final int HEIGHT = 400;
    private static final int WIDTH = 700;
    
    private StopButtonHandler stopButtonHandler;
    private StartButtonHandler startButtonHandler;
    
    public TimedResponseGame() {
    	info = new JLabel("   Click Start, Wait 3s, Click Stop  ");
    	result = new JLabel();
    	
    	// This section specifies the handlers for the buttons and adds ActionListener
    	startButton = new JButton("Start");
    	startButton.setBackground(Color.GREEN);
    	startButton.setOpaque(true);
    	//startButton.setBorderPainted(false);
    	startButtonHandler = new StartButtonHandler();
    	startButton.addActionListener(startButtonHandler);
    	
    	stopButton = new JButton("Stop");
    	stopButton.setBackground(Color.RED);
    	stopButton.setOpaque(true);
    	//stopButton.setBorderPainted(false);
    	stopButtonHandler = new StopButtonHandler();
    	stopButton.addActionListener(stopButtonHandler);
    	
    	setTitle("TimeResponsedGame");
    	Container pane = getContentPane();
    	pane.setLayout(new GridLayout(2,2));
    	
    	// Add components to the content pane in the order they should appear.
    	pane.add(info);
    	pane.add(result);
    	pane.add(startButton);
    	pane.add(stopButton);
    	
    	setSize(WIDTH, HEIGHT);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private class StartButtonHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		startTime = System.nanoTime();
    	} 	
    }
    
    private class StopButtonHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		timeElapsed = System.nanoTime() - startTime;
    		long millisTimeElapsed = TimeUnit.NANOSECONDS.toMillis(timeElapsed);
    		long timeDiff = millisTimeElapsed - 3000;
    		String output;
    		if (timeDiff <= 100 && timeDiff >= -100)
    			output = "Nice! You were only " + Long.toString(timeDiff) + " milliseconds ";
    		else
    			output = "You were " + Long.toString(timeDiff) + " milliseconds ";
    		output += (timeDiff < 0)? "early." : "later.";
    		result.setText(output);
    	}
    }
    
	public static void main(String[] args) {
		TimedResponseGame trgObj = new TimedResponseGame();
	}
}