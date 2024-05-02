class Test{
	public static void main(String args[]){
		int a[] = {10,30,40,60,80};
		int b[] = {20,50,70,90,100};
		int c[] = new int[a.length+b.length];
		int i=0 , j=0 , k=0;
		while(i<a.length && j<b.length){
			if(a[i] < b[j]){
				c[k] = a[i];
				i++;
			}
			else{
				c[k] = b[j];
				j++;
			}
			k++;
		}
		while(i<a.length){
			c[k] = a[i];
			i++; 
			k++;
		}
		while(j<b.length){
			c[k] = b[j];
			k++;
			j++;
		}
		for(k=0 ; k<c.length ; k++){
			System.out.print(c[k] +" ");
		}
	}
}

