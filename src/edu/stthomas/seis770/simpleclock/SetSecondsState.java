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
	
	@Override
	public void increment(){
		myClock.incrementSeconds();
	}
	
	@Override
	public void decrement(){
		myClock.decrementSeconds();
	}
	
	@Override
	public void changeMode(){
		myClock.changeState(DisplayTimeState.getInstance());
	}
	
	@Override
	public void cancel(){
		myClock.changeState(SetMinutesState.getInstance());
	}
	
	@Override
	public void enter(){
		myClock.highlightSeconds();
	}
	
	@Override
	public void timeTicker(){
		//do nothing when in this state
	}

}
