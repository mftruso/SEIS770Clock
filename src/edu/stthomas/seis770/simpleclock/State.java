package edu.stthomas.seis770.simpleclock;

public abstract class State {
	private SimpleClock myClock;
	
	private void increment(){}
	
	private void decrement(){}
	
	private void changeMode(){}
	
	private void cancel(){}
	
	private void timeTicker(){}

	
	public SimpleClock getMyClock() {
		return myClock;
	}
	public void setMyClock(SimpleClock myClock) {
		this.myClock = myClock;
	}
}
