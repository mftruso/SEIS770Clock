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
	
	public void changeMode(){
		myClock.changeState(SetHoursState.getInstance());
		myClock.highlightHours();
		myClock.addStateButtons();
	}
}
