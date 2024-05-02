import java.util.*;

class Hash<K,V>{
    class Node{
        K key;
        V value;
        Node(K key ,V value){
            this.key = key;
            this.value = value;
        }
    }
    int n , N;
    LinkedList<Node> buckets[];
    Scanner sc = new Scanner(System.in);
    Hash(){
        System.out.println("Enter no of buckets");
        this.N = sc.nextInt();
        this.buckets = new LinkedList[N];
        for(int i=0 ; i<N ; i++){
            this.buckets[i] = new LinkedList<>();
        }
    }

    int hashfunction(K key){
        int bucketindex = key.hashCode();
        return Math.abs(bucketindex) % N;
    }

    int searchinLL(K key , int bucketindex){
        LinkedList<Node> ll = buckets[bucketindex];
        for(int i=0 ; i<ll.size() ; i++){
            if(ll.get(i).key == key){
                return i;
            }
        }
        return -1;
    }

    void rehash(){
        LinkedList <Node> oldbucket[] = buckets;
        buckets = new LinkedList[N*2];
        for(int i=0 ; i<N*2 ; i++){
            buckets[i] = new LinkedList<>();
        }
        for(int i=0 ; i<oldbucket.length ; i++){
            LinkedList<Node> ll = oldbucket[i];
            for(int j=0 ; j<ll.size(); j++){
                Node node = ll.get(j);
                put(node.key , node.value);
            }
        }
    }
    void put(K key , V value){
        int bucketindex = hashfunction(key);
        int dataindex = searchinLL(key , bucketindex);
        if(dataindex == -1){
            buckets[bucketindex].add(new Node(key , value));
            n++;
        }
        else{
            Node node = buckets[bucketindex].get(dataindex);
            node.value = value;
        }
        double lamda = (double)n / N; 
        if(lamda > 2.0){//directely i am giving a value for check;
            rehash();
        }
    }

    V get(K key){
        int bucketindex = hashfunction(key);
        int dataindex = searchinLL(key , bucketindex);
        if(dataindex == -1){
            return null;
        }
        else{
            Node node = buckets[bucketindex].get(dataindex);
            return node.value;
        }
    }

    boolean containKey(K key){
        int bucketindex = hashfunction(key);
        int dataindex = searchinLL(key , bucketindex);
        if(dataindex == -1){
            return false;
        }
        else{
            return true;
        }
    }

    V remove(K key){
        int bucketindex = hashfunction(key);
        int dataindex = searchinLL(key , bucketindex);

        if(dataindex == -1){
            return null;
        }
        else{
            Node node = buckets[bucketindex].remove(dataindex);
            n--;
            return node.value;
        }
    }

    boolean isEmpty(){
        if(n==0){
            return true;
        }
        else{
            return false;
        }
    }

    ArrayList<K> KeySet(){
        ArrayList<K> keys = new ArrayList<>();
        for(int bi = 0 ; bi < buckets.length ; bi++){
            LinkedList<Node> ll = buckets[bi];
            for(int di = 0 ; di < ll.size() ; di++){
                Node node = ll.get(di);
                keys.add(node.key);
            }
        }
        return keys;
    }

    public static void main(String args[]){
        Hash<String , Integer> map = new Hash<>();
        map.put("India",150);
        map.put("US",20);
        map.put("France",60);
        map.put("US",25);
        map.remove("US");
        ArrayList<String> keys = map.KeySet();
        for(int i=0 ; i<keys.size() ; i++){
            System.out.println(keys.get(i) +" "+ map.get(keys.get(i)));
        }
        System.out.println(map.isEmpty());
        System.out.println(map.get("India"));
        System.out.println(map.containKey("US"));
        System.out.println(map.containKey("India"));
    }
}