package backend;

public class DebateSetting{
	private int stage;
	public boolean paused;
	/*
	 Stage 0: Countdown, 5 seconds--5
	 Stage 1: PRO1, 300 seconds--305
	 Stage 2: PRO/CROSS, 180 seconds--485
	 Stage 3: PREP, 120 seconds--605
	 Stage 4: CON1+2, 420 seconds--1025
	 Stage 5: CON/CROSS, 180 seconds--1205
	 Stage 6: PREP, 120 seconds--1325
	 Stage 7: PRO2+3, 240 seconds--1565
	 Stage 8: PREP, 120 seconds--1685
	 Stage 9: CON3+4, 360 seconds--2045
	 Stage 10: PREP, 120 seconds--2165
	 Stage 11: PRO4: 180 seconds--2345
	 */
	private int time = 0;
	private int countdown = 5;
	public DebateSetting(){
		stage = 0;
		paused = true;
	}
	public void jumpUpdate(){
		paused = true;
		switch (stage){
		case 0:
			stage = 1;
			countdown = 300;
			time = 5;
			break;	
		case 1:
			stage = 2;
			countdown = 180;
			time = 305;
			break;
		case 2:
			stage = 3;
			countdown = 120;
			time = 485;
			break;
		case 3:
			stage = 4;
			countdown = 420;
			time = 605;
			break;
		case 4:
			stage = 5;
			countdown = 180;
			time = 1025;
			break;
		case 5:
			stage = 6;
			countdown = 120;
			time = 1205;
			break;
		case 6:
			stage = 7;
			countdown = 240;
			time = 1325;
			break;
		case 7:
			stage = 8;
			countdown = 120;
			time = 1565;
			break;
		case 8:
			stage = 9;
			countdown = 360;
			time = 1685;
			break;
		case 9:
			stage = 10;
			countdown = 120;
			time = 2045;
			break;
		case 10:
			stage = 11;
			countdown = 180;
			time = 2165;
			break;
		case 11:
			stage = 12;
			countdown = 0;
			time = 2345;
			break;
		}
	}
	public void update(){
		if(!paused){
			time++;
			switch (time){
			case 5:
				stage = 1;
				countdown = 300;
				java.awt.Toolkit.getDefaultToolkit().beep();
				break;
			case 305:
				stage = 2;
				countdown = 180;
				java.awt.Toolkit.getDefaultToolkit().beep();
				paused = true;
				break;
			case 485:
				stage = 3;
				countdown = 120;
				java.awt.Toolkit.getDefaultToolkit().beep();
				paused = true;
				break;
			case 605:
				stage = 4;
				countdown = 420;
				java.awt.Toolkit.getDefaultToolkit().beep();
				paused = true;
				break;
			case 1025:
				stage = 5;
				countdown = 180;
				java.awt.Toolkit.getDefaultToolkit().beep();
				paused = true;
				break;
			case 1205:
				stage = 6;
				countdown = 120;
				java.awt.Toolkit.getDefaultToolkit().beep();
				paused = true;
				break;
			case 1325:
				stage = 7;
				countdown = 240;
				java.awt.Toolkit.getDefaultToolkit().beep();
				paused = true;
				break;
			case 1565:
				stage = 8;
				countdown = 120;
				java.awt.Toolkit.getDefaultToolkit().beep();
				paused = true;
				break;
			case 1685:
				stage = 9;
				countdown = 360;
				java.awt.Toolkit.getDefaultToolkit().beep();
				paused = true;
				break;
			case 2045:
				stage = 10;
				countdown = 120;
				java.awt.Toolkit.getDefaultToolkit().beep();
				paused = true;
				break;
			case 2165:
				stage = 11;
				countdown = 180;
				java.awt.Toolkit.getDefaultToolkit().beep();
				paused = true;
				break;
			case 2345:
				stage = 12;
				countdown = 300;
				java.awt.Toolkit.getDefaultToolkit().beep();
				paused = true;
				break;
			}
			countdown--;
		}
	}
	public String getTime(){
		String sTime = "Total Time Elapsed " + Integer.toString(this.time / 60) + ":";
		if((this.time % 60) < 10){
			sTime = sTime + "0" + Integer.toString(((this.time % 60)));
		}else{
			sTime = sTime + Integer.toString(this.time % 60);
		}
		return sTime;
	}
	public String getCountdown(){
		String sTime = Integer.toString(this.countdown / 60) + ":";
		if((this.countdown % 60) < 10){
			sTime = sTime + "0" + Integer.toString(this.countdown % 60);
		}else{
			sTime = sTime + Integer.toString(this.countdown % 60);
		}
		return sTime;
	}
	public String getPrompt(){
		switch (stage){
			case 0:
				return("Get Ready!");
			case 1:
				return("PRO Case");
			case 2:
				return("Crossfire");
			case 3:
				return("PREP TIME");
			case 4:
				return("CON Case + First CON Rebuttal");
			case 5:
				return("Crossfire");
			case 6:
				return("PREP TIME");
			case 7:
				return("First PRO Rebuttal");
			case 8:
				return("PREP TIME");
			case 9:
				return("Second CON Rebuttal");
			case 10:
				return("PREP TIME");
			case 11:
				return("Second PRO Rebuttal");
			default:
				return("ERROR");
		}
	}
	public Boolean getPauseState(){
		return paused;
	}
	public void switchPauseState(){
		paused =! paused;
	}
}
