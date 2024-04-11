package codesoft.linkedlist;

class Node{
	int data;
	Node next;
	public Node(int data) {
		//System.out.println("Node ctor");
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
	Node head; //Head of the list
	
	//constructor
	public LinkedList() {
		//System.out.println("linked list ctor");
		this.head=null;
	}
	
	//method to add a new node at the end of the linked list
	public void append(int data) {
		//Create a new node to be added with data
		Node newNode = new Node(data);
		
		//if linked list is empty make the newNode as head
		if(head==null) {
			head = newNode;
			return;
		}
		
		//Traverse to the last node
		Node last = head;
		while(last.next!=null) {
			last = last.next;
		}
		
		//Insert the new node at the end
		last.next=newNode;
	}
	
	//Method to display linked list
	public void display() {
		//Create a current node and initialize it to head to traverse the linked list
		Node current = head;
		while(current!=null) {
			System.out.println(current.data+" ");
			current = current.next;
		}
		System.out.println();
	}
	
	//Method to add data at first position
	public void addFirst(int data) {
		//Create a node to be added 
		Node newNode = new Node(data);
		//make the newNode point to head
		newNode.next = head;
		//make the new node as head 
		head = newNode;
		return;
	}
	
	//Method to add data after previous node
	public void addAfterPreviousNode(Node previousNode,int data) {
		//check if previous is null 
		if(previousNode ==null) {
			System.out.println("Previous node can't be null");
		}
		//create a node to be added
		Node newNode = new Node(data);
		//make the newNode point to the node which is pointed by previous node
		newNode.next = previousNode.next;
		//now make the previosNode point to the next node
		previousNode.next=newNode;
		return;
	}
	
	public void delete(int data) {
		//create a current node and initialize to head
		Node current = head;
		//create a prev node to keep track of prev node
		Node prev = null;
		//condtion to check if current is null so that we will stop the changing pointers of current and prev node
		while(current!=null && current.data!=data) {
			prev = current;
			current = current.next;
		}
		
		if(current == null) {
			System.out.println(data+ " not found in the list.");
			return;
		}
		
		if(prev == null) {
			head = current.next;
		}else {
			prev = current.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		//adding elements to the linked list
		l1.append(1);
		l1.append(2);
		l1.append(3);
		l1.append(4);
		l1.append(5);
		
		l1.delete(1);
		l1.display();
		
		//displaying elements of linked list
		//l1.display();
		//addFirst() method
		//l1.addFirst(0);
		//l1.display();
		
		//add after previous node method
//		Node prevNode = l1.head.next;//data at this pt is 0 due to line 81
//		l1.addAfterPreviousNode(prevNode, 5);
//		l1.display();
		
	}
}