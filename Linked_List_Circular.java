import java.util.Scanner;
class Node{
    int data;
    Node add;
}

class Main{
    public static void main(String args[]){
        LinkedList l = new LinkedList();
        Scanner n = new Scanner(System.in);
        int no;
        do{
            System.out.println("----Circular Linked List-----");
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
                default : System.out.println("Invalid number");
            }
        }
        while(no!=5);
    }
}

class LinkedList{
    Node temp , start , prev , next , newnode;
    void create(){
        int no ; char ch;  
        Scanner n = new Scanner(System.in);
        System.out.println("Enter a value to create list");
        no = n.nextInt();
        start = new Node();
        start.data = no;
        start.add = null;
        temp = start;
        System.out.println("To add more values press y");
        ch = n.next().charAt(0);
        while(ch == 'y' || ch == 'Y'){
            System.out.println("Enter a value");
            no = n.nextInt();
            newnode = new Node();
            newnode.data = no;
            newnode.add = null;
            temp.add = newnode;
            temp = newnode;
            System.out.println("To add more values press y");
            ch = n.next().charAt(0);
        }
	    temp = start;
        while(temp.add != null){
            temp = temp.add;
        }
        temp.add = start;
    }

    void display(){
        if(start == null){
            System.out.println("No value to display,first create list");
        }
        else{
		temp = start;
            do{
           	    System.out.print(temp.data +" ");
            	temp = temp.add;
            }
        	while(temp != start);
        }
	    System.out.println();
    }

    void insert(){
        int no , position , i=1 , count=0;
        Scanner n = new Scanner(System.in);
        if(start == null){
            System.out.println("First create a list");
        }
        else{
            System.out.println("Enter value to insert");
            no = n.nextInt();
            System.out.println("Enter position where you want to insert no");
            position = n.nextInt();
            newnode = new Node();
            newnode.data = no;
            newnode.add = null;
            if(position == 1){
                newnode.add = start;
                temp = start;
                while(temp.add != start){
                    temp = temp.add;
                }
                temp.add = newnode;
                start = newnode;
            }
            else{
                temp = start;
                do{
                    count ++;
                    temp = temp.add;
                }
                while(temp != start);
                if(position > count + 2){
                System.out.println("Invalid position, position <=  " +(count + 2));
                }
                else if(position == count + 2){
                    temp = start;
                    while(temp.add != start){
                        temp = temp.add;
                    }
                    temp.add = newnode;
                    newnode.add = start;
                }
                else{
                    next = start;
                    while(i<position){
                        prev = next;
                        next = next.add;
                        i++;
                    }
                    prev.add = newnode;
                    newnode.add = next;
                }
            }
        }
    }

    void delete(){
        int position , count = 0 , i=1;
        Scanner n = new Scanner(System.in);
        if(start == null){
            System.out.println("No elements to delete, First create List");
        }
        else{
            System.out.println("Enter a position you want to delete");
            position = n.nextInt();
            if(position == 1){
                temp = start;
                while(temp.add != start){
                    temp = temp.add;
                }
                temp.add = start.add;
                temp = start;
		start = start.add;
		temp = null;
            }
            else{
                temp = start;
                do{
                    count ++;
                    temp = temp.add;
                }
                while(temp != start);
                if(position > count){
                    System.out.println("Invalid position , position <= " + count);
                }
                else if(position == count){
                    next = start;
                    while(next.add!= start){
                        prev = next;
                        next = next.add;
                    }
                    prev.add = start;
                    next = null;
                }
                else{
                    next = start;
                    while(i<position){
                        prev = next;
                        next = next.add;
                        i++;
                    }
                    temp = next;
                    next = next.add;
                    prev.add = next;
                    temp = null;
                }
            }
        }
    }
}
