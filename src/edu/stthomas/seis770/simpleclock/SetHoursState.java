package edu.stthomas.seis770.simpleclock;

public class SetHoursState extends State {

	private static volatile SetHoursState instance = null;
	
	public static synchronized SetHoursState getInstance(){
		if(instance == null){
			instance = new SetHoursState();
		}
		return instance;
	}
		
	public SetHoursState(){
	}
	
	public void increment(){
		myClock.incrementHours();
	}
	
	public void decrement(){
		myClock.decrementHours();
	}
	
	public void changeMode(){
		myClock.changeState(SetMinutesState.getInstance());
		myClock.highlightMinutes();
	}
	
	public void cancel(){
		myClock.changeState(DisplayTimeState.getInstance());
		myClock.removeStateButtons();
		myClock.removeHighlighting();
	}
}
