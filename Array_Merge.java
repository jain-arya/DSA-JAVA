import java.util.Scanner;
class Test{
	
	public int[] creation(int size){
		Scanner n = new Scanner(System.in);
		int a[] = new int[size];
		for(int i=0 ; i<size ; i++){
			a[i] = n.nextInt();
		}
	return a;
	}

	public int[] sort(int a[]){
		int i,j,temp;
		for(i=0 ; i<a.length ; i++){
			for(j=i+1 ; j<a.length ; j++){
				if(a[i] > a[j]){
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	return a;
	}

		
	void display(int a[]){
System.out.println("Merged array is: ");
		for(int i : a){
			System.out.print(i + " ");
		}
	}

        public int[] merge(int a[] , int b[]){
		int i,j,k;
		int arr[] = new int[a.length + b.length];
		for(k=0 , i=0 , j=0 ; i<arr.length-1 ; i++){
			if(a[k] < b[j]){
                        	arr[i] = a[k];		
				k++;
				if(k >= a.length){
					for(i++ ; j<b.length ;j++ , i++){
						arr[i] = b[j];
					}
				}
			}
			else{
				arr[i] = b[j];
				j++;
				if(j >= b.length){
					for(i++ ; k<a.length ; k++ , i++){
						arr[i] = a[k];
					}
				}
			}
		}
	return arr;
	} 

	public static void main(String args[]){
		Scanner n = new Scanner(System.in);
		int size1 = n.nextInt();
		int size2 = n.nextInt();
		int a[] = new int[size1];
		int b[] = new int[size2];
		Test t1 = new Test();
		int x[] = new int [size1];
		x = t1.creation(size1);
                int y[] = new int [size2];
		y = t1.creation(size2);
		a = t1.sort(x);
		b = t1.sort(y);
		x = t1.merge(a,b);
		t1.display(x);
	}
}
/* t1.display(t1.merge(t1.sort(t1.creation(size1)),t1.sort(t1.creation(size2))));
Nesting of calling methods can also be done
*/





  
	
	