package edu.stthomas.seis770.simpleclock;

public class DisplayTimeState extends State{

	SimpleClock  myClock;
	
	public DisplayTimeState(SimpleClock myClock) {
		this.myClock = myClock;
	}
	
	public void changeMode(){
		myClock.changeState(new SetHoursState(myClock));
	}
}
