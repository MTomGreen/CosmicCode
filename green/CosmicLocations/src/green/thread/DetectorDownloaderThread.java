package green.thread;

import green.detector.Detector;
import green.util.DetectorUtils;

public class DetectorDownloaderThread extends Thread{
	
	public Detector d;
	
	@Override
	public void run() {
		d.populateData();
		DetectorUtils.incrementLoadProgress();
	}
	
	public DetectorDownloaderThread(Detector d) {
		this.d = d;
	}

}
