import java.util.Scanner;

class Node{
    Node ladd;
    int data;
    Node radd;
}

class Test{
    public static void main(String args[]){
        Node root = null;
        int n , no;
        do{
            System.out.println();
            System.out.println("---------TREE---------");
            System.out.println("Press 1 to create");
            System.out.println("Press 2 for inorder");
            System.out.println("Press 3 for preorder");
            System.out.println("Press 4 for postorder");
            System.out.println("Press 5 to exit");
            System.out.println("Enter your choice");
            Scanner z = new Scanner(System.in);
            n = z.nextInt();
            switch(n){
                case 1: System.out.println("Enter a value , 0 to exit");
                        no = z.nextInt();
                        while(no != 0){
                            root = create(root , no);
                            System.out.println("Enter new value");
                            no = z.nextInt();
                        }
                        break;
                case 2: inorder(root); break;
                case 3: preorder(root); break;
                case 4: postorder(root); break;
                case 5: break;
                default : System.out.println("Invalid no!!!");
            }
        }
        while(n != 5);
    }
    static  create(Node p , int no){
        if(p == null){
            p = new Node();
            p.ladd = null;
            p.data = no;
            p.radd = null; 
        }
        else{
            if(no < p.data){
                p.ladd = create(p.ladd , no);
            }
            else if(no > p.data){
                p.radd = create(p.radd , no);
            }
            else{
                System.out.println("Duplicate elements are not allowed in BST");
            }
        }
        return p;
    }

    static void inorder(Node p){
        if(p != null){
            inorder(p.ladd);
            System.out.print(p.data + " ");
            inorder(p.radd);
        }
    }

    static void preorder(Node p){
        if(p != null){
            System.out.print(p.data + " ");
            preorder(p.ladd);
            preorder(p.radd);
        }
    }

    static void postorder(Node p){
        if(p != null){
            postorder(p.ladd);
            postorder(p.radd);
            System.out.print(p.data + " ");
        }
    }
}

    








