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
	
	@Override
	public void increment(){
		myClock.incrementHours();
	}
	
	@Override
	public void decrement(){
		myClock.decrementHours();
	}
	
	@Override
	public void changeMode(){
		myClock.changeState(SetMinutesState.getInstance());
	}
	
	@Override
	public void cancel(){
		myClock.changeState(DisplayTimeState.getInstance());
	}
	
	public void enter(){
		myClock.highlightHours();
		myClock.addStateButtons();
	}
}
