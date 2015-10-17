package edu.stthomas.seis770.simpleclock;

public class SetMinutesState extends State{

	SimpleClock  myClock;
	
	public SetMinutesState(SimpleClock myClock) {
		this.myClock = myClock;
	}
	
	public void increment(){
		myClock.incrementMinutes();
	}
	
	public void decrement(){
		myClock.decrementMinutes();
	}
	
	
	public void changeMode(){
		myClock.changeState(new SetSecondsState(myClock));
	}
	
	public void cancel(){
		myClock.changeState(new SetHoursState(myClock));
	}

}
