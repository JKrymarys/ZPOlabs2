package lab2;

import javafx.collections.ObservableList;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Simulator extends TimerTask {
	int size = 15;
	
	Handler handler;
    Logger 	LOGGER;
	PriorityQueue<Cyclist> highscoreBoard = new PriorityQueue<>( size);
	PriorityQueue<Cyclist> scores;
	ObservableList<Cyclist> scoresFX;

	List<Cyclist> list;
	
	public Simulator()
	{
		try {
			handler = new FileHandler("cyclists.log");
			LOGGER = Logger.getLogger(Simulator.class.getName());
			LOGGER.addHandler(handler);
			
			list = Loader.createCyclists();
			System.out.println("Created");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error during creation of list " + e.getMessage());
		} catch (SecurityException e) {
			System.out.println("Error during creation of list " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error during creation of list " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static double GenerateTime() {

		Random r = new Random();
		double result = r.nextGaussian() * 30 + 300;

		if (result < 250)
			return 250;
		else if (result > 370)
			return 370;
		else
			return Math.round(result);

	}


	@Override
	public void run() {
		System.out.println("run");
		double score = GenerateTime();
		if(list.size() != 0)
		{
			Cyclist current = list.get(0);
			current.setTime(score);
			System.out.println("Current: " + current.getName() + " time: " + current.getTime());
			highscoreBoard.add(current);
			LOGGER.info( "Cyclist name:" + current.getName() + " time: " + current.getTime());
			showBest();
			//TO DO
//			if(highscoreBoard.size() >3)
//				highscoreBoard.
			list.remove(0);
		}else if(list.size() == 0)
			cancel();
		
			//System.out.println("Highscores: " + "1st: " +  highscoreBoard.element().getName() + "   time: " + highscoreBoard.element().getTime());
			
	}
	
	private void showBest()
	{
		scores = new PriorityQueue<Cyclist>(highscoreBoard);
		int toDisplay = 3;
		int i = 0;
		System.out.println(scores.size());
		while(i<3 && !scores.isEmpty())
		{
			try {
				Cyclist bestTemp = scores.poll();
				
				System.out.println("Highscores: " + (i+1) + ". : " +  bestTemp.getName() + "   time: " + bestTemp.getTime());
				i++;
			}catch(Exception e)
			{
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
	
	public PriorityQueue<Cyclist> getFinished()
	{
		return highscoreBoard;
	}
	
	
}
