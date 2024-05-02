class Test{
	void swap(int a[] , int y, int z){
		int temp = a[y];
		a[y] = a[z];
		a[z] = temp;
	}
	void sort(int a[]){
		int l=0 , r=a.length-1 , m=0;
		while(r>=m){
			if(a[m] == 1){
				m++;
			}
			else if(a[m] == 0){
				swap(a,l,m);
				l++ ; m++;
			}
			else{
				swap(a,m,r);
				r--;
			}
		}
	}
	public static void main(String args[]){
		int a[] = {1,1,2,0,0,1,2,2,1,0};
		Test t1 = new Test();
		t1.sort(a);	
		for(int i=0 ; i<a.length ; i++){
			System.out.print(a[i] + " ");
		}
	}
}

