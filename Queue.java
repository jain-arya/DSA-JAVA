import java.util.Scanner;
class Test{
	static final int size = 10;
	static int rear = -1;
	static int front = 0;
	static int queue[] = new int [size];
	
	public static void main(String args[]){
		Scanner n = new Scanner(System.in);
		int no;
		do{
			System.out.println("---------Queue---------");
			System.out.println("Enter 1 to insert");
			System.out.println("Enter 2 to delete");
			System.out.println("Enter 3 to display");
			System.out.println("Enter 4 to exit");
			no = n.nextInt();
			switch(no){
				case 1 : insert(); break;
				case 2 : delete(); break;
				case 3 : display(); break;
				case 4 : break;
				default : System.out.println("Invalid number");
			}
		}
		while(no!=4);
	}
		
	public static void insert(){
		Scanner n = new Scanner(System.in);
		if(rear == size-1){
			System.out.println("Queue Overflow");
		}
		else{
			System.out.println("Enter a number");
			rear++;
			queue[rear] = n.nextInt();
		}
	}

	public static void delete(){
		if(front > rear){
			System.out.println("Queue Underflow");
		}
		else{
			System.out.println("Deleted element is:" + queue[front]);
			front++;
		}
	}

	public static void display(){
		if(front > rear){
			System.out.println("Queue Underflow");
		}
		else{
			for(int i=front ; i<=rear ; i++){
				System.out.print(queue[i] + " ");
			}
		}
	}
}

			

