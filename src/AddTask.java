/**
 * AddTask adds number 1 ... limit to the counter, then exits.
 * @author Patiphan Srisook
 *
 */
public class AddTask implements Runnable {

	private Counter counter;
	private int limit;
	
	public AddTask(Counter counter, int limit) {
		this.counter = counter;
		this.limit = limit;
	}

	@Override
	public void run() {
		for(int k=1; k<=limit; k++) {
			counter.add(k);
//			System.out.println("Done "+Thread.currentThread().getName());
		}
		
	}

}
