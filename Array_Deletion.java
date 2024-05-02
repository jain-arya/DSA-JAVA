import java.util.Scanner;
class Test{
	public int[] array_creation(int v){
		Scanner n = new Scanner(System.in);
		int a[] = new int[v];
		for(int i =0 ; i<v ; i++){
			a[i] = n.nextInt();
		}
	return a;
	}
	
	public int[] array_deletion(int a[] , int index){
		for(int i=index ; i<a.length ; i++){
			a[i] = a[i+1];
		}
	return a;
	}
	
	void display(int a[]){
		for(int i =0 ; i<a.length ; i++){
			System.out.print(a[i]+ " ");
		}
		
	}

	
	public static void main(String args[]){
		Scanner n = new Scanner(System.in);
		int size = n.nextInt();
		int index = n.nextInt();
		int a[] = new int [size];
		Test t1 = new Test();
		t1.display(t1.array_deletion(t1.array_creation(size),index));
	}
}