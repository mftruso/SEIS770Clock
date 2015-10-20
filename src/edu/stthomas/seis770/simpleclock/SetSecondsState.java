package edu.stthomas.seis770.simpleclock;

public class SetSecondsState extends State{

	
	private static volatile SetSecondsState instance = null;
	
	public static synchronized SetSecondsState getInstance(){
		if(instance == null){
			instance = new SetSecondsState();
		}
		return instance;
	}
	
	public SetSecondsState() {
	}
	
	public void increment(){
		myClock.incrementSeconds();
	}
	
	public void decrement(){
		myClock.decrementSeconds();
	}
	
	public void changeMode(){
		myClock.changeState(DisplayTimeState.getInstance());
		myClock.removeHighlighting();
		myClock.removeStateButtons();
	}
	
	public void cancel(){
		myClock.changeState(SetMinutesState.getInstance());
		myClock.highlightMinutes();
	}

}
