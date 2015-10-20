package edu.stthomas.seis770.simpleclock;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple timer to handle timed events
 *
 */
public class SimpleTimer {

	private SimpleClock myClock;
	
	public SimpleTimer(SimpleClock aClock){
		setMyClock(aClock);
		Timer timer = new Timer();
		
		//schedules the task to run immediately and then every second
		timer.schedule(new TimerTickTask(), 0, 1000);
	}

	public SimpleClock getMyClock() {
		return myClock;
	}

	public void setMyClock(SimpleClock myClock) {
		this.myClock = myClock;
	}
	
	class TimerTickTask extends TimerTask {
        public void run() {
            myClock.timerTick();
        }
    }
}
