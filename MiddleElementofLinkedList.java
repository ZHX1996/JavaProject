
public class MiddleElementofLinkedList{
	public static void main(String args[]){
		LinkedList linkedlist = new LinkedList();
		LinkedList.Node head = linkedlist.head();
		linkedlist.add(new LinkedList.Node("1"));
		linkedlist.add(new LinkedList.Node("3"));
		linkedlist.add(new LinkedList.Node("5"));
		linkedlist.add(new LinkedList.Node("7"));
		// linkedlist.add(new LinkedList.Node("9"));
		
		LinkedList.Node current = head;
		int length = 0;
		LinkedList.Node middle = head;
		
		while (current.next() != null){
			length++;
			if (length%2==0){
				middle = middle.next();
			}
			current = current.next();
		}
		
		if (length%2==1){
			middle = middle.next();
		}
		
		System.out.println(length);
		System.out.println(middle);
	}
}