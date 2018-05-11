import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
	private Node head;
	private Node tail;
	private int count;
	private class Node{
		private Node prev;
		private Node next;
		private Item item;
			
		public Node(Item item) 
		{
			this.item = item;
			prev = null;
			next = null;
		}
	}
	
   public Deque()                           // construct an empty deque
   {
	   count = 0;
	   head = null;
	   tail = null;
   }
   public boolean isEmpty()                 // is the deque empty?
   {
	   return (count == 0);
   }
   public int size()                        // return the number of items on the deque
   {
	   return count;
   }
   public void addFirst(Item item)          // add the item to the front
   {
	   if(item == null)
		   throw new IllegalArgumentException();
	   Node node = new Node(item);
	   if(head == null)
	   {
		   head = node;
	   	   tail = node;
	   }
	   else 
	   {
		   head.prev = node;
		   node.next = head;
		   head = node;
	   }			   	   
	   count++;		
   }
   public void addLast(Item item)           // add the item to the end
   {
	   if(item == null)
		   throw new IllegalArgumentException();
	   Node node = new Node(item);
	   if(tail == null)
	   {
		   head = node;
	   	   tail = node;
	   }
	   else 
	   {
		   tail.next = node;
		   node.prev = tail;
		   tail = node;
	   }			   	   
	   count++;
   }
   public Item removeFirst()                // remove and return the item from the front
   {
	   if(isEmpty())
		   throw new NoSuchElementException(); 
	   Item item = head.item;
	   if(count == 1)
	   {
		   head = null;
		   tail = null;
	   }
	   else {
		   head.next.prev = null;
		   head = head.next;
	   }		
	   count--;
	   
	   return item;
   }
   public Item removeLast()                 // remove and return the item from the end
   {
	   if(isEmpty())
		   throw new NoSuchElementException(); 
	   Item item = tail.item;
	   if(head == tail)
	   {
		   head = null;
		   tail = null;
	   }
	   else {
		   tail.prev.next = null;
		   tail = tail.prev;
	   }
	   count--;
	   return item;
   }
   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
   {
	   return new DequeIterator(); 
   }
   
   private class DequeIterator implements Iterator<Item>
   {
	private Node cur = head;
	
	public boolean hasNext() {
		return cur != null;
	}

	public void remove()
	{
		throw new UnsupportedOperationException();
	}
	public Item next() {
		if(!hasNext())
		{
			throw new NoSuchElementException();
		}
		Item item = cur.item;
		cur = cur.next;
		return item;
	}
	   
   }
   
   public static void main(String[] args) 
   {
	   Deque<Integer> d = new Deque();
	   for(int i = 0; i < 10; i++) {
		   d.addFirst(i);	   
	   }
	   for(int j = 0; j < 10; j++)
	   {
		   d.addLast(-j);
	   }
	   int a = d.removeFirst();
	   int b = d.removeLast();
	   System.out.println(a+ "&" + b);
	   
	   for(Integer i : d)
	   {
		   System.out.print(i+"|");
	   }
	   while(true)
	   {
		   System.out.print("\n"+d.removeLast());
	   }
   }// unit testing (optional)
}
//
//Throw a java.lang.IllegalArgumentException if the client calls either addFirst() or addLast() with a null argument.
//Throw a java.util.NoSuchElementException if the client calls either removeFirst() or removeLast when the deque is empty.
//Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
//Throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator.