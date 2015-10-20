package edu.stthomas.seis770.simpleclock;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class SimpleClock implements ActionListener{
	private int hours;
	private int minutes;
	private int seconds;
	private State myState;
	
	JLabel hoursLabel = new JLabel("Hours", SwingConstants.CENTER);
	JLabel minutesLabel = new JLabel("Minutes", SwingConstants.CENTER);
	JLabel secondsLabel = new JLabel("Seconds", SwingConstants.CENTER);
	JLabel colonLabel1 = new JLabel(":", SwingConstants.CENTER);
	JLabel colonLabel2 = new JLabel(":", SwingConstants.CENTER);
	
	
	private Timer timer;
	
	JFrame frame = new JFrame("Clock");
	
	private static final Font normalFont = new Font("Arial", Font.BOLD, 48);
	private static final Color normalColor = Color.blue;
	private static final Color modifyColor = Color.red;
	private static final Color backgroundColor = Color.BLACK;
	
	JButton changeModeButton;
	JButton incrementButton;
	JButton decrementButton;
	JButton cancelButton;
	
	/** 
	 * constructor
	 */
	public SimpleClock(){
		//initialize the time to the system time
		Calendar cal = Calendar.getInstance();
		hours = cal.get(Calendar.HOUR_OF_DAY);
		minutes = cal.get(Calendar.MINUTE);
		seconds = cal.get(Calendar.SECOND);
		
		//begin creating timed action events
		startTimer();
		
		//initialize label values and look&feel
		hoursLabel.setText(hours+"");
		hoursLabel.setFont(normalFont);
		hoursLabel.setForeground(normalColor);
		hoursLabel.setBackground(backgroundColor);
		hoursLabel.setOpaque(true);
		
		minutesLabel.setText(minutes+"");
		minutesLabel.setFont(normalFont);
		minutesLabel.setForeground(normalColor);
		minutesLabel.setBackground(backgroundColor);
		minutesLabel.setOpaque(true);
		
		secondsLabel.setText(seconds+"");
		secondsLabel.setFont(normalFont);
		secondsLabel.setForeground(normalColor);
		secondsLabel.setBackground(backgroundColor);
		secondsLabel.setOpaque(true);
		
		colonLabel1.setFont(normalFont);
		colonLabel1.setForeground(normalColor);
		colonLabel2.setFont(normalFont);
		colonLabel2.setForeground(normalColor);
		
		//initialize the buttons and add action listners
		changeModeButton = new JButton("Change Mode");
		changeModeButton.addActionListener(this);  
		
		incrementButton = new JButton("+");
		incrementButton.addActionListener(this);
		
		decrementButton = new JButton("-");
		decrementButton.addActionListener(this);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		
		//set the first state to DisplayTime
		myState = DisplayTimeState.getInstance();
		
		//initialize all states and give it this instance of SimpleClock
		DisplayTimeState.getInstance().setMyClock(this);
		SetHoursState.getInstance().setMyClock(this);
		SetMinutesState.getInstance().setMyClock(this);
		SetSecondsState.getInstance().setMyClock(this);
	}

	public int getHours() {
		if(hours == 24){
			hours = 0;
		}
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		//System.out.println("Minutes: " + minutes);
		if(minutes == 60){
			minutes = 0;
			incrementHours();
		}
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		//System.out.println("Seconds: " + seconds);
		if(seconds == 60){
			incrementMinutes();
			seconds = 0;
		} 
		return seconds;
	}

	public void setSeconds(int seconds) {
		//System.out.println("the new second is " + seconds);
		//System.out.println("the old second is " + this.seconds);
		this.seconds = seconds;
	}

	public State getMyState() {
		return myState;
	}

	public void setMyState(State myState) {
		this.myState = myState;
	}

	public void changeState(State aState) {
		myState = aState;
	}
	
	public void incrementHours(){
		hours++;
	}
	
	public void decrementHours(){
		hours--;
	}
	
	public void incrementMinutes(){
		minutes++;
	}
	
	public void decrementMinutes(){
		minutes--;
	}
	
	public void incrementSeconds(){
		seconds++;
	}
	
	public void decrementSeconds(){
		seconds--;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
		if(e.getSource() == timer){
			//while in the SetSeconds state, don't continually update seconds from the timer
			if(!"edu.stthomas.seis770.simpleclock.SetSecondsState".equals(myState.getClass().getName())){
				incrementSeconds();
			}
		} else if(e.getSource() == changeModeButton){			
			myState.changeMode();
			System.out.println("My State: " + myState.getClass().getName());
		} else if(e.getSource() == incrementButton){
			myState.increment();
		} else if(e.getSource() == decrementButton){
			myState.decrement();
		} else if(e.getSource() == cancelButton){
			myState.cancel();
		}
		
		//every time an action occurs, update the time labels
		secondsLabel.setText(String.format("%02d", getSeconds()));
		minutesLabel.setText(String.format("%02d", getMinutes()));
		hoursLabel.setText(String.format("%02d", getHours()));	
		
	}
	
	public void startTimer(){
		if (timer == null) {
	        //delay every 1000 milliseconds 
			timer = new javax.swing.Timer(1000, this);
	         timer.setInitialDelay(0);
	         //start sending action events
	         timer.start();
	      } else if (!timer.isRunning()) {
	         timer.restart();
	      }
	}
	
	public void createAndShowGUI() {
        //set up the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.setSize(2000, 200);
        frame.pack();
        frame.setVisible(true);
    }

	private void addComponentsToPane(Container pane) {
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
	    c.gridx = 0;
	    c.gridy = 0;
	    pane.add(hoursLabel, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
	    c.gridx = 1;
	    c.gridy = 0;
	    pane.add(colonLabel1, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.gridx = 2;
	    c.gridy = 0;
	    pane.add(minutesLabel, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
	    c.gridx = 3;
	    c.gridy = 0;
	    pane.add(colonLabel2, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.gridx = 4;
	    c.gridy = 0;
	    pane.add(secondsLabel, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridx = 0;
	    c.gridy = 1;
	    pane.add(changeModeButton, c);
		
	}

	public void highlightHours() {
		hoursLabel.setForeground(modifyColor);
		minutesLabel.setForeground(normalColor);
		secondsLabel.setForeground(normalColor);
	}
	
	public void highlightMinutes(){
		hoursLabel.setForeground(normalColor);
		minutesLabel.setForeground(modifyColor);
		secondsLabel.setForeground(normalColor);
	}
	
	public void highlightSeconds(){
		hoursLabel.setForeground(normalColor);
		minutesLabel.setForeground(normalColor);
		secondsLabel.setForeground(modifyColor);
	}
	
	public void removeHighlighting(){
		hoursLabel.setForeground(normalColor);
		minutesLabel.setForeground(normalColor);
		secondsLabel.setForeground(normalColor);
	}
	
	//TODO: add other highlight and unhighlight methods here 
	
	/**
	 * in a state of changing the time, show these gui components
	 */
	public void addStateButtons(){
		Container pane = frame.getContentPane();
		GridBagConstraints c = new GridBagConstraints();
		
		//remote changeModeButton from its current position, and re-add in new position
		pane.remove(changeModeButton);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
	    c.gridx = 0;
	    c.gridy = 1;
	    pane.add(incrementButton, c);
	    
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
	    c.gridx = 1;
	    c.gridy = 1;
	    pane.add(decrementButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
	    c.gridy = 1;
	    pane.add(changeModeButton, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
	    c.gridy = 1;
	    pane.add(cancelButton, c);

	}
	
	public void removeStateButtons(){
		Container pane = frame.getContentPane();
		pane.remove(incrementButton);
		pane.remove(decrementButton);
		pane.remove(cancelButton);
	}
	
}
