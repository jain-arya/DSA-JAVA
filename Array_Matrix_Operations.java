import java.util.Scanner;
class Test{
	public int[][] creation(int row , int column){
		int a[][] = new int[row][column];
		Scanner n = new Scanner(System.in);
		for(int i=0 ; i<row ; i++){
			for(int j=0 ; j<column ; j++){
				 a[i][j] = n.nextInt();
			}
		}
	return a;
	}
	
        public int[][] add(int add[][] , int a[][] , int b[][]){
		for(int i=0 ; i<a.length ; i++){
			for(int j=0 ; j<a[i].length ; j++){
				add[i][j] = a[i][j] + b[i][j];
			}
		}
	return add;
	}
	
	public int[][] mul(int mul[][] , int a[][] , int b[][]){
		int i,j,k;
		for(k=0 ; k<a.length ; k++){
			for(i=0 ; i<a.length ; i++){
				mul[k][i]=0;
				for(j=0 ; j<a.length ; j++){
					mul[k][i] += a[k][j]*b[j][i];
				}
			}
		}
	return mul;
	}
					
	void display(int a[][]){
		for(int i=0 ; i<a.length ; i++){
			for(int j=0 ; j<a[i].length ; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public int[][] transpose(int add[][] , int a[][]){
		for(int i=0 ; i<a.length ; i++){
			for(int j=0 ; j<a[i].length ; j++){
				add[i][j] = a[j][i];
			}
		}
	return add;
	}
	
	public static void main(String args[]){
	Scanner n = new Scanner(System.in);
	int row = n.nextInt();
	int column = n.nextInt();
	Test t1 = new Test();
	int add[][] = new int[row][column];
	int mul[][] = new int [row][column];
       	int x[][] = t1.creation(row,column);
	int y[][] = t1.creation(row,column);
	int z[][] = t1.add(add,x,y);
	int w[][] = t1.transpose(add,x);
	int v[][] = t1.mul(mul,x,y);
	System.out.println("Transpose of two matrix is");
	t1.display(w);
	System.out.println("Addition of two matrix is");
	t1.display(z);
	System.out.println("Multiplication of two matrix is");
	t1.display(v);
	}
}

			
