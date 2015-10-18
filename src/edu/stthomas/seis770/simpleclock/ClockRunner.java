package edu.stthomas.seis770.simpleclock;

public class ClockRunner {
	public static void main(String[] args) {
		try {
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					SimpleClock clock = new SimpleClock();
					clock.createAndShowGUI();
				}
			});
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw e;
		}
	}
}
