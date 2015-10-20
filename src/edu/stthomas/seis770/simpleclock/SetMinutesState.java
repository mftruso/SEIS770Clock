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
	
	@Override
	public void increment(){
		myClock.incrementMinutes();
	}
	
	@Override
	public void decrement(){
		myClock.decrementMinutes();
	}
	
	@Override
	public void changeMode(){
		myClock.changeState(SetSecondsState.getInstance());
	}
	
	@Override
	public void cancel(){
		myClock.changeState(SetHoursState.getInstance());
	}
	
	@Override
	public void enter(){
		myClock.highlightMinutes();
	}
	

}
