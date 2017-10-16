package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Simulator extends TimerTask {

	public static double GenerateTime() {

		Random r = new Random();
		double result = r.nextGaussian() * 30 + 300;

		if (result < 250)
			return 250;
		else if (result > 370)
			return 370;
		else
			return result;

	}

	public static void RaceSimulator()
	{

		
	}

	@Override
	public void run() {
		
		
	}
	
	public static void main() {
		TimerTask task = new  Simulator();
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(task, 0, (long)GenerateTime());
		
		
	}
	
}
