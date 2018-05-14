import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
	public static void main(String[] args)
	{
		int count = Integer.parseInt(args[0]);
		
		RandomizedQueue<String> rQueue = new RandomizedQueue<>();
		
		//StdIn.
		//System.out.println("Standrd input a string.");
		while (!StdIn.isEmpty()) {			
			rQueue.enqueue(StdIn.readString());
		}
		/*
		String[] str = {"a","b","c","d","e","f","g","h","i"};
		for(String s : str)
		{
			rQueue.enqueue(s);	
		}
*/
		for (int i = 0; i < count;i++) {
			StdOut.print(rQueue.dequeue());
		}
		//for(int i = 0; i < count; i++) {
			//System.out.print("\n"+rQueue.dequeue());
		
		//}
	}

}
