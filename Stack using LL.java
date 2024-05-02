// Implementing Stack using Linked List
import java.util.Scanner;
class Node{
    int data;
    Node add;
}

class Test{
    public static void main(String args[]){
        Scanner n = new Scanner(System.in);
        int no;
        Stack l = new Stack(); 
        do{
            System.out.println("---Stack using LinkedList---");
            System.out.println("Press 1 to push elements");
            System.out.println("Press 2 to pop elements");
            System.out.println("Press 3 to display elements");
            System.out.println("Press 4 to exit");
            no = n.nextInt();
            switch(no){
                case 1 : l.push() ; break;
                case 2 : l.pop() ; break;
                case 3 : l.display() ; break;
                case 4 : break;
                default : System.out.println("Invalid input");
            }
        }
        while(no!=4);
    }
}

class Stack{
    Node top=null ,start , temp;
    void push(){
        Scanner n = new Scanner(System.in);
        int no;
        System.out.println("Enter no to push");
        no = n.nextInt();
        start = new Node();
        start.data = no;
        start.add = top;
        top = start;
    }

    void pop(){
        if(top == null){
            System.out.println("Stack underflow");
        }
        else{
            System.out.println("Deleted element is "+top.data);
            top = top.add;
        }

    }

    void display(){
        if(top == null){
            System.out.println("Stack underflow");
        }
        else{
            temp = top;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.add;
            }
            System.out.println();
        }
    }
}