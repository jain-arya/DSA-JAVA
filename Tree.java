import java.util.*;
class Main{
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
            System.out.println("Press 5 for level");
            System.out.println("Press 6 for total no of nodes");
            System.out.println("Press 7 for height of tree");
            System.out.println("Press 8 to exit");
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
                case 5: level(root); break;
                case 6: System.out.println("Total no of nodes = " + count(root));
                        break;
                case 7: System.out.println("Height of tree is = " + height(root)); break;
                case 8: break;
                default : System.out.println("Invalid no!!!");
            }
        }
        while(n != 8);
    }
    static  Node create(Node p , int no){
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

    static void level(Node p){
        if(p == null){
            return;
        }
        Queue <Node> q = new LinkedList<>();
        q.add(p);
        q.add(null);
        while(!q.isEmpty()){
            Node currnode = q.remove();
            if(currnode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }    
                else{
                    q.add(null);
                }        
            }
            else{
                System.out.print(currnode.data + " ");
                if(currnode.ladd != null){
                    q.add(currnode.ladd);
                }
                if(currnode.radd != null){
                    q.add(currnode.radd);
                }
            }
        }
    }
    
    static int count(Node p){
        if(p == null){
            return 0;
        }
        int l = count(p.ladd);
        int r = count(p.radd);
        return l+r+1;
    }
    
    static int height(Node p){
        if(p == null){
            return 0;
        }
        int l = height(p.ladd);
        int r = height(p.radd);
        int ans = Math.max(l,r);
        return ans+1;
    }
}

class Node{
    Node ladd;
    int data;
    Node radd;
}
    







