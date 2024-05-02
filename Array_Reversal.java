import java.util.Scanner;

class Test{
	public int[] reverse(int a[]){
		int temp;
		for(int i=0 ; i<=a.length/2; i++){
			temp = a[i];
			a[i] = a[a.length-1-i];
			a[a.length-1-i] = temp;
		}
	return a;
	}
	
	void display(int a[]){
		for(int i : a){
			System.out.print(i + " ");
		}
	}

	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int a[] = new int[size];
		for(int i=0 ; i<size ; i++){
			a[i] = s.nextInt();
		}
		Test t1 = new Test();
		int x[] = new int [size];
		x = t1.reverse(a);
		t1.display(x);		
	}
}

		
			