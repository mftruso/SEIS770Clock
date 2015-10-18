package edu.stthomas.seis770.simpleclock;

public class SetHoursState extends State {

	SimpleClock  myClock;
		
	public SetHoursState(SimpleClock myClock){
		this.myClock = myClock;
		this.myClock.highlightHours();
		this.myClock.addStateButtons();
	}
	
	public void increment(){
		myClock.incrementHours();
	}
	
	public void decrement(){
		myClock.decrementHours();
	}
	
	public void changeMode(){
		myClock.changeState(new SetMinutesState(myClock));
	}
	
	public void cancel(){
		myClock.changeState(new DisplayTimeState(myClock));
	}
}
