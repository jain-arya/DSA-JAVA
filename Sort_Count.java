class Test{
	public static void main(String args[]){
		int a[] = {1,3,2,3,4,1,6,4,3};
		int max = a[0];
		for(int i=1 ; i<a.length ; i++){
			if(max < a[i]){
				max = a[i];
			}
		}
		int count[] = new int [max+1];
		for(int i=0 ; i<a.length ; i++){
			count[a[i]]++;
		}
		for(int i=1 ; i<=max ; i++){
			count[i] += count[i-1];
		}
		int output[] = new int[a.length];
		for(int i=output.length-1 ; i>=0 ; i--){
			output[--count[a[i]]] = a[i];
		}
		for(int i=0 ; i<output.length ; i++){
			System.out.print(output[i]+" ");
		}
	}
}
