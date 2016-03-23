package bob.research.javaqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class WriteRead {

	private  ArrayBlockingQueue <byte[]>  queue;
	
	private void run() {
		
		queue = new ArrayBlockingQueue <byte[]>(100);
		
		byte writeBytes[] 
		   = "Hello World".getBytes();
		
//		try {
//			queue.put(writeBytes);
//		} catch (InterruptedException e) {
//			System.out.println("Trace 1");
//			e.printStackTrace();
//		}
		
		try {
			byte readBytes[]
			   = queue.poll(10,TimeUnit.MILLISECONDS);
			String showString;
			if (readBytes == null) {
				System.out.println("Timed Out");
			}
			else {
				showString = new String(readBytes);
				System.out.println("Read ("
						+ showString + ")");
			}
		} catch (InterruptedException e) {
			System.out.println("Trace 2");
			e.printStackTrace();
		}
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WriteRead wr = new WriteRead();
		wr.run();
	}

}
