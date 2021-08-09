package online.exam.pkg101;

import java.util.*;



public class WriteThreadServer implements Runnable {

	private Thread thr;
	String name;
	public Hashtable<String, NetworkUtil> table;

	public WriteThreadServer(Hashtable<String, NetworkUtil> table,String name) {
		this.table = table;
		this.name = name;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		try {
			Scanner input=new Scanner(System.in);
			while(true) {
				
				}
			
		} catch(Exception e) {
			System.out.println (e);
		}			
	}
}

