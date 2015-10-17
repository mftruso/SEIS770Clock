package edu.stthomas.seis770.simpleclock;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class SimpleClock extends JFrame implements ActionListener {
	private int hours;
	private int minutes;
	private int seconds;
	private State myState;
	
	JButton changeModeButton;
	
	/** 
	 * constructor
	 */
	public SimpleClock(){
		Calendar cal = Calendar.getInstance();
		hours = cal.get(Calendar.HOUR_OF_DAY);
		minutes = cal.get(Calendar.MINUTE);
		seconds = cal.get(Calendar.SECOND);
		//Timer timer = new Timer();
		
		
		/*
		JFrame frame = new JFrame("Clock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(600, 200);
		frame.add(new Pane());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		*/
		changeModeButton = new JButton("Change Mode");
		changeModeButton.setBounds(130,100,100, 40);
		changeModeButton.addActionListener(this);  
		
		
		
		//frame.add(changeModeButton);
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
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
		//if hours = 24, go to 0
		//else hours++;
	}
	
	public void decrementHours(){
		
	}
	
	public void incrementMinutes(){
		
	}
	
	public void decrementMinutes(){
		
	}
	
	public void incrementSeconds(){
		
	}
	
	public void decrementSeconds(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(changeModeButton.isSelected()){
			System.out.println("button push");
		}
		
	}
	
	
}
