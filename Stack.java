import java.util.Scanner;
class Test{
	static final int size = 10;
	static int stack[] = new int[size];
	static int top = -1;
	public static void main(String args[]){
		int no;
		Scanner n = new Scanner(System.in);
		do{
			System.out.println("-----------Stack-----------");
			System.out.println("1 to push");
			System.out.println("2 to pop");
			System.out.println("3 to display");
			System.out.println("4 to exit");
			no = n.nextInt();
			switch(no){	
				case 1 : push(); break;
				case 2 : pop(); break;
				case 3 : display(); break;
				case 4 : break;
				default : System.out.println("Invalid no");
			}
		}
		while(no != 4);
	}
	
	public static void push(){
		Scanner n = new Scanner(System.in);
		if(top == size-1){
			System.out.println("Stack Overflow");
		}
		else{
			System.out.println("Enter a value");
			top++;
			stack[top] = n.nextInt();
		}
	}
	
	public static void pop(){
		if(top == -1){
			System.out.println("Stack Underflow");
		}
		else{
			System.out.println("Deleted no is :" + stack[top]);
			top--;
		}
	}

	public static void display(){
		if(top == -1){
			System.out.println("Stack underflow");
		}
		else{
			for(int i=0 ; i<=top ; i++){
				System.out.print(stack[i] + " ");
			}
			System.out.println();
		}
	}
}


			
			
		
	