package backend;

import java.util.Timer;
import java.util.TimerTask;
import backend.DebateSetting;

public class DebateTimer{
	public Timer timer;
	public DebateSetting setting = new DebateSetting();
	public DebateTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new callUpdate(), 0, 1000);
	}
	class callUpdate extends TimerTask{
		public void run(){
			setting.update();
			}
		}
}

