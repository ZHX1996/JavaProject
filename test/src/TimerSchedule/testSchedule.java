package TimerSchedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class testSchedule {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("again");
			}
			
		}, new Date(System.currentTimeMillis() + 1000), 2000);
	}
}
