package edu.stthomas.seis770.simpleclock;

public class SetMinutesState extends State{

	private static volatile SetMinutesState instance = null;
	
	public static synchronized SetMinutesState getInstance(){
		if(instance == null){
			instance = new SetMinutesState();
		}
		return instance;
	}
	
	
	public SetMinutesState() {
	}
	
	public void increment(){
		myClock.incrementMinutes();
	}
	
	public void decrement(){
		myClock.decrementMinutes();
	}
	
	
	public void changeMode(){
		myClock.changeState(SetSecondsState.getInstance());
		myClock.highlightSeconds();
	}
	
	public void cancel(){
		myClock.changeState(SetHoursState.getInstance());
		myClock.highlightHours();
	}

}
