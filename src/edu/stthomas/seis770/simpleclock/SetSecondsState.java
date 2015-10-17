package edu.stthomas.seis770.simpleclock;

public class SetSecondsState extends State{

	SimpleClock  myClock;
	
	public SetSecondsState(SimpleClock myClock) {
		this.myClock = myClock;
	}
	
	public void increment(){
		myClock.incrementSeconds();
	}
	
	public void decrement(){
		myClock.decrementSeconds();
	}
	
	public void changeMode(){
		myClock.changeState(new DisplayTimeState(myClock));
	}
	
	public void cancel(){
		myClock.changeState(new SetMinutesState(myClock));
	}

}
