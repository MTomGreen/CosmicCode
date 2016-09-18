package green.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import green.detector.Detector;
import green.objects.Coincidence;
import green.objects.HitEvent;

public class FileUtils {
	
	public static final String base_dir = new File("").getAbsolutePath();
	
	public static void getEventLogForDetector(Detector d){
		File logFile = new File(base_dir+"/logs/"+d.getName()+".dat");
		if(!logFile.exists()){
			
		}
	}
	
	public static void moveFilesFromDownloads(){
		File in = new File(base_dir+"/data/temp");
		for(File f : in.listFiles()){
			System.out.println(f.getName());
			f.renameTo(new File(base_dir+"/data/"+WebUtils.newFileName+".tsv"));
			f.delete();		}
	}
	
	public static Coincidence getCoincidenceFromDataFile(File file){
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(file));
		}
		catch(Exception E){
			E.printStackTrace();
		}
		
		ArrayList<String> lines = new ArrayList<String>();
		String line = null;
		try{
			while((line = br.readLine()) != null){
				lines.add(line);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		Iterator<String> iter = lines.iterator();
		while(iter.hasNext()){
			if(iter.next().contains("#")){
				iter.remove();
			}
		}
		
		ArrayList<HitEvent> events = new ArrayList<HitEvent>();
		//Convert data into a series of HitEvent ojects.
		for(String line2 : lines){
			HitEvent currentEvent = new HitEvent(line2);
			events.add(currentEvent);
		}
		
		Coincidence c = new Coincidence();
		c.events = events;
		
		
		return c;
	}

}
