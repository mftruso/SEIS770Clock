package edu.stthomas.seis770.simpleclock;

public class DisplayTimeState extends State{
	private static volatile DisplayTimeState instance = null;
	
	public static synchronized DisplayTimeState getInstance(){
		if(instance == null){
			instance = new DisplayTimeState();
		}
		return instance;
	}
	
	public DisplayTimeState() {
	}
	
	@Override
	public void changeMode(){
		myClock.changeState(SetHoursState.getInstance());
	}
	
	@Override
	public void enter(){
		myClock.removeStateButtons();
		myClock.removeHighlighting();
	}
}
