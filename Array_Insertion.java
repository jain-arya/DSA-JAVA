import java.util.Scanner;
class Test{
	void insertion(int index , int value ,int arr[] ,int size){
		int a[] = new int[size+1];
		for(int i=arr.length-1 ; i>=index ; i--){
			a[i+1] = arr[i];
		}
		a[index] = value;
		for(int i=0 ; i<a.length ; i++){
			if(i<index){
				a[i] = arr[i];
			}
			System.out.print(a[i] + " ");
		}
 		
	}

	public static void main(String args[]){
	Scanner n = new Scanner(System.in);
	int size = n.nextInt();
	int index = n.nextInt();
	int value = n.nextInt();
	int arr[] = new int[size];
	int k=0;
	for(int i : arr){
		arr[k] = n.nextInt();
		k++;
	}
	Test t1 = new Test();
	t1.insertion(index,value,arr,size);
	
	}
}
	
