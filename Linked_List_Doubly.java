import java.util.Scanner;
class Node{
    Node ladd;
    int data;
    Node radd;
}

class Main{
    public static void main(String args[]){
        Scanner n = new Scanner(System.in);
        DoublyLinkedList l = new DoublyLinkedList();
        int no;
        do{
            System.out.println("------Doubly Linked List------");
            System.out.println("Press 1 to create");
            System.out.println("Press 2 to insert");
            System.out.println("Press 3 to delete");
            System.out.println("Press 4 to display");
            System.out.println("Press 5 to exit");
            no = n.nextInt();
            switch(no){
                case 1 : l.create(); break;
                case 2 : l.insert(); break;
                case 3 : l.delete(); break;
                case 4 : l.display(); break;
                case 5 : break;
                default : System.out.println("Invalid no!!!");
            }
        }
        while(no!=5);
    }
}

class DoublyLinkedList{
    Node start , temp , next , prev , newnode;

    void create(){
        int no ; char ch ;
        Scanner n = new Scanner(System.in);
        System.out.println("Enter a value");
        no = n.nextInt();
        start = new Node();
        start.data = no;
        start.ladd = null;
        start.radd = null;
        temp = start;
        System.out.println("To add more elements press y");
        ch = n.next().charAt(0);
        while(ch == 'y' || ch == 'Y'){
            System.out.println("Enter a value");
            no = n.nextInt();
            newnode = new Node();
            newnode.data = no;
            newnode.ladd = null;
            newnode.radd = null;
            temp.radd = newnode;
            newnode.ladd = temp;
            temp = newnode;
            System.out.println("To add more elements press y");
            ch = n.next().charAt(0);
        }
    }

    void insert(){
        int no , position , count = 0 , i = 1;
        if (start == null){
            System.out.println("No elements , First create a list");
        }
        else{
            Scanner n = new Scanner(System.in);
            System.out.println("Enter a no. to insert");
            no = n.nextInt();
            System.out.println("Enter a position to insert no");
            position = n.nextInt();
            newnode = new Node();
            newnode.data = no;
            newnode.ladd = null;
            newnode.radd = null;
            if(position == 1){
                newnode.radd = start;
                start.ladd = newnode;
                start = start.ladd;
            }
            else{
                temp = start;
                while(temp != null){
                    count ++;
                    temp = temp.radd;
                }
                if(position > count+1){
                    System.out.println("Invalid position, position <= " + (count+1));
                }
                else if(position == count+1){
                    temp = start;
                    while(temp.radd != null){
                        temp = temp.radd;
                    }
                    temp.radd = newnode;
                    newnode.ladd = temp;
                }
                else{
                    next = start;
                    while(i < position){
                        prev = next;
                        next = next.radd;
                        i++;
                    }
                    prev.radd = newnode;
                    newnode.ladd = prev;
                    newnode.radd = next;
                    next.ladd = newnode;
                }
            }
        }
    }

    void delete(){
        int position , count = 0 , i = 1;
        Scanner n = new Scanner(System.in);
        if(start == null){
            System.out.println("No elements to delete, First create list");
        }
        else{
            System.out.println("Enter a position to delete");
            position = n.nextInt();
            if(position == 1){
                temp = start;
                start = start.radd;
                System.out.println("Deleted no is " + temp.data);
                temp = null;
                start.ladd = null;
            }
            else{
                temp = start;
                while(temp != null){
                    count++;
                    temp = temp.radd;
                }
                if(position > count){
                    System.out.println("Invalid position , position <= " + count);
                }
                else if(position == count){
                    next = start;
                    while(next.radd != null){
                        prev = next;
                        next = next.radd;
                    }
                    System.out.println("Deleted no is " + next.data);
                    next = null;
                    prev.radd = null;
                }
                else{
                    next = start;
                    while(i < position){
                        prev = next;
                        next =  next.radd;
                        i++;
                    }
                    temp = next;
                    next = next.radd;
                    System.out.println("Deleted no is " + temp.data);
                    temp = null;
                    prev.radd = next;
                    next.ladd = prev;
                }
            }
        }
    }

    void display(){
        if(start == null){
            System.out.println("No elements to display, First create list");
        }
        else{
            temp = start;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.radd;
            }
            System.out.println();
        }
    }
}