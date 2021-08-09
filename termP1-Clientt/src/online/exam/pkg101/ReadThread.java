package online.exam.pkg101;



public class ReadThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;

	public ReadThread(NetworkUtil nc) {
		this.nc = nc;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
	//	System.out.println("READ THREAD");
		try {
			while(true) {
				
			}
		} catch(Exception e) {
			System.out.println (e);                        
		}
	//	System.out.println("READ THREAD");
		nc.closeConnection();
	}
}