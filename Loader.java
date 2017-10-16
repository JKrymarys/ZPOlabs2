package lab2;

import lab2.Cyclist;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Loader {

	public static List<String> LoadFile() throws MalformedURLException {
		URL url = new URL("http://szgrabowski.kis.p.lodz.pl/zpo17/nazwiska.txt");
		Scanner s;
		List<String> names = new ArrayList<String>();
		List<String> chosenNames = new ArrayList<String>();
		int cyclists = 15;
		
		
		try {
		   s = new Scanner(url.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("An error occured during reading file from URL" + e.getMessage());
			return null;
		}
		
		while(s.hasNextLine())
		{
			names.add(s.nextLine());
		}
		
		Collections.shuffle(names);
		return names.subList(0, cyclists);
	}
	
	public static List<Cyclist> createCyclists() throws MalformedURLException{
		List<Cyclist> cyclists = new ArrayList<Cyclist>();
		List<String> names = LoadFile();
		for(Iterator<String> i = names.iterator(); i.hasNext();)
		{
			cyclists.add(new Cyclist(i.next()));
		}
		return cyclists;
	}
}
