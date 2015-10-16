package edu.stthomas.seis770.simpleclock;

public class SimpleClock {
	private int hours;
	private int minutes;
	private int seconds;
	private State myState;
	
	/** 
	 * constructor
	 */
	public SimpleClock(){
		//TODO: set the first state
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
}
