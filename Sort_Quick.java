import java.util.Scanner;
class Test{
	public static void qsort(int a[] , int lower , int upper){
		int i=0;
		if(upper > lower){
			i = split(a,lower,upper);
			qsort(a,lower,i-1);
			qsort(a,i+1,upper);
		}
	}

	public static int split(int a[] , int lower , int upper){
		int p = a[lower];
		int l = lower + 1;
		int r = upper; int temp;
		while(l<=r){
			while(a[l] < p){
				l++;
			}
			while(a[r] > p){
				r--;
			}
			if(l<r){
				temp = a[l];
				a[l] = a[r];
				a[r] = temp;
			}
		}
		temp = a[lower];
		a[lower] = a[r];
		a[r] = temp;
		return r;
	}


	public static void main(String args[]){
		Scanner n = new Scanner(System.in);
		int size = n.nextInt();
		int a[] = new int[size];
		for(int i=0 ; i<size ; i++){
			a[i] = n.nextInt();
		}
		qsort(a,0,11);
		for(int i=0 ; i<size ; i++){
			System.out.print(a[i] + " ");
		}
	}
}

	