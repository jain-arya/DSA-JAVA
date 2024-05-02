import java.util.Scanner;


class Node{
	int data;
	Node next;
}


class Main{
	public static void main(String args[]){
		Scanner n = new Scanner(System.in);
		LinkedList l = new LinkedList();
		int no;
		do{
			System.out.println("-------Linked List-------");
			System.out.println("Press 1 to create");
			System.out.println("Press 2 to insert");
			System.out.println("Press 3 to delete");
			System.out.println("Press 4 to display");
			System.out.println("Press 5 to exit");
			no = n.nextInt();
			switch(no){
				case 1 : l.create() ; break;
				case 2 : l.insert() ; break;
				case 3 : l.delete() ; break;
				case 4 : l.display() ; break;
				case 5 : break;
				default : System.out.println("Not a valid no.");
			}
		}
		while(no!=5);
	}
}


class LinkedList{
	Node start , temp , newNode , prev , next;
	void create(){
		int no ; char ch ; 
		Scanner n = new Scanner(System.in);
		System.out.println("Enter a value");
		no = n.nextInt();
		start = new Node();
		start.data = no;
		start.next = null;
		temp = start;
		System.out.println("To create more nodes press 'y'");
		ch = n.next().charAt(0);
		while(ch == 'y' || ch == 'Y'){
			System.out.println("Enter a value");
			no = n.nextInt(); 
			newNode  = new Node();
			newNode.data = no;
			newNode.next = null;
			temp.next = newNode;
			temp = newNode;
			System.out.println("To create more nodes press 'y'");
			ch = n.next().charAt(0);
		}
	}

	void display(){
		if(start == null){
			System.out.println("No list to print,first create List");
		}
		else{
			temp = start;
			while(temp != null){
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			System.out.println();
		}
	}

	void insert(){
		int no , position , count=0 , i=1;
		if(start == null){
			System.out.println("First create a List");
		}
		else{
			Scanner n = new Scanner(System.in);
			System.out.println("Enter a no to insert");
			no = n.nextInt();
			System.out.println("Enter a position to insert");
			position = n.nextInt();
			newNode = new Node();
			newNode.data = no;
			newNode.next = null;
			if(position == 1){
				newNode.next = start;
				start = newNode;
			}
			else{
				temp = start;
				while(temp != null){
					count++;
					temp = temp.next;
				}
				if(position > count+1){
					System.out.println("Invalid postion , position<=" + (count+1));
				}
				else if(position == count + 1){
					temp = start;
					while(temp.next != null){
						temp = temp.next;
					}
					temp.next = newNode;
				}
				else{
					next = start;
					while(i<position){
						prev = next;
						next = next.next;
						i++;
					}
					prev.next = newNode;
					newNode.next = next;
				}
			}
		}
	}

	void delete(){
		int position , count=0 , i=1;
		Scanner n = new Scanner(System.in);
		if(start == null){
			System.out.println("No values to delete, first create List");
		}
		else{
			System.out.println("Enter a position to delete");
			position = n.nextInt();
			if(position == 1){
				temp = start;
				start = start.next;
				System.out.println("Deleted element is" + temp.data);
				temp = null;
			}
			else {
				temp = start;
				while(temp != null){
					count ++;
					temp = temp.next;
				}
				if(position > count){
					System.out.println("Invalid position, position<=" + count);
				}
				else if(position == count){
					next = start;
					while(next.next != null){
						prev = next;
						next = next.next;
					}
					System.out.println("Deleted element is " + next.data);
					next = null;
					prev.next = null;
				}
				else{
					next = start;
					while(i < position){
						prev = next;
						next = next.next;
						i++;
					}
					temp = next;
					next = next.next;
					System.out.println("Deleted element is " + temp.data);
					temp = null;
					prev.next = next;
				}	
			}
		}
	}
}

				
		
		



					
					 

		

