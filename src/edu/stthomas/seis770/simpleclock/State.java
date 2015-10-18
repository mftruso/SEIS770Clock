package edu.stthomas.seis770.simpleclock;

public abstract class State {
	private SimpleClock myClock;
	
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
	
	//TODO: should the timer be implemented here instead?
	public void timeTicker(){
		System.out.println("No specified action for timeTicker() in this state.");
	}

	
	public SimpleClock getMyClock() {
		return myClock;
	}
	public void setMyClock(SimpleClock myClock) {
		this.myClock = myClock;
	}
}
