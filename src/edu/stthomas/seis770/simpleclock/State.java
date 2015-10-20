package edu.stthomas.seis770.simpleclock;

public abstract class State {
	protected SimpleClock myClock;
	
	public void increment(){
		System.out.println("No specified action for increment() in this state.");
	}
	
	public void decrement(){
		System.out.println("No specified action for decrement() in this state.");
	}
	
	public void changeMode(){
		System.out.println("No specified action for changeMode() in this state.");
	}
	
	public void cancel(){
		System.out.println("No specified action for cancel() in this state.");
	}
	
	/**
	 * For every timer tick, the default action is to increment the seconds on the clock
	 */
	public void timeTicker(){
		myClock.incrementSeconds();
	}

	
	public SimpleClock getMyClock() {
		return myClock;
	}
	public void setMyClock(SimpleClock myClock) {
		this.myClock = myClock;
	}
	
	public void enter(){}
	
	public void exit(){}
}
