import java.util.ArrayList;

public class matrix {

	public static void printMatrix(ArrayList<ArrayList<Integer>> matrixA){
		for (ArrayList<Integer> row : matrixA) {
			System.out.print("| ");
			for (Integer elem : row) {
				System.out.print(elem + " ");
			}
			System.out.print("|\n");
		}

	}

	
	public static ArrayList<ArrayList<Integer>> matrixAddition(ArrayList<ArrayList<Integer>> matrixA, ArrayList<ArrayList<Integer>> matrixB){
		if((matrixA.size() != matrixB.size()) || (matrixA.get(0).size() != matrixB.get(0).size())){
			System.err.println("Error: Matrix Dimension Mismatch");
		}

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		try{
			for (int i = 0; i < matrixA.size(); i=i+1) {
				ArrayList<Integer> resRow = new ArrayList<Integer>();
				ArrayList<Integer> aRow = matrixA.get(i);
				ArrayList<Integer> bRow = matrixB.get(i);
				for (int j = 0; j < matrixA.get(0).size(); j=j+1) {
					resRow.add(bRow.get(j)+aRow.get(j));
				}
				result.add(resRow);
			}
		}catch (IndexOutOfBoundsException e){
			System.err.println("Error: "+ e.getMessage());

		}
		return result;

	} 

	
	public static ArrayList<ArrayList<Integer>> matrixSubraction(ArrayList<ArrayList<Integer>> matrixA, ArrayList<ArrayList<Integer>> matrixB){
		if((matrixA.size() != matrixB.size()) ){
			System.err.println("Error: Matrix Dimension Mismatch");
			return matrixA;
		}
		if(matrixA.isEmpty() || matrixB.isEmpty() ||  (matrixA.get(0).size() != matrixB.get(0).size())){	
			System.err.println("Error: Matrix Dimension Mismatch");
			return matrixA;
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(matrixA.size()<1 && matrixA.get(0).size()<1){
			System.out.println("MatA m:"+matrixA.size() +"  n:"+matrixA.get(0).size());
			System.out.println("MatA m:"+matrixB.size() +"  n:"+matrixB.get(0).size());
			
			}
		try{
			for (int i = 0; i < matrixA.size(); i++) {
				ArrayList<Integer> resRow = new ArrayList<Integer>();
				ArrayList<Integer> aRow = matrixA.get(i);
				ArrayList<Integer> bRow = matrixB.get(i);
				for (int j = 0; j < matrixA.get(0).size(); j=j+1) {
					resRow.add(aRow.get(j)-bRow.get(j));
				}
				result.add(resRow);
			}
		}catch (IndexOutOfBoundsException e){
			System.err.println("Error: "+ e.getMessage());

		}
		return result;

	} 
	
		
	public static ArrayList<ArrayList<Integer>> matrixMultiplication(ArrayList<ArrayList<Integer>> matrixA,
			ArrayList<ArrayList<Integer>> matrixB)  
			{  
		int size = matrixA.size();
		ArrayList<ArrayList<Integer>> a,b,c,d,e,f,g,h,i,j,k,l,m,n;
		ArrayList<ArrayList<Integer>> s1,s2,s3,s4,s5,s6,s7;
		ArrayList<ArrayList<Integer>> matrixRes;
		
		

		
		if(size>1){
		a = submatrix(matrixA,0,0);
		b = submatrix(matrixA,0,1);  
		c = submatrix(matrixA,1,0);  
		d = submatrix(matrixA,1,1);  
	
		e = submatrix(matrixB,0,0);  
		f = submatrix(matrixB,0,1);  
		g = submatrix(matrixB,1,0);  
		h = submatrix(matrixB,1,1);  


		m =matrixSubraction(f, h);  
		s1 = matrixMultiplication(a,m);      

		m =matrixAddition(a, b);            
		s2 =matrixMultiplication(m,h);  

		m = matrixAddition(c, d);          
		s3 =matrixMultiplication(m,e);  

		m = matrixSubraction(g, e);           
		s4 = matrixMultiplication(d,m);  

		m = matrixAddition(a, d);        
		n = matrixAddition(e, h);           
		s5 = matrixMultiplication(m,n);  

		m = matrixSubraction(b, d);         
		n = matrixAddition(g, h);          
		s6 = matrixMultiplication(m,n);  

		m = matrixSubraction(a, c);  
		n = matrixAddition(e, f);     
		s7 = matrixMultiplication(m,n);  

		i = matrixAddition(s5, s6); 
		i = matrixAddition(s4, i); 
		i = matrixSubraction(i, s2);    
		j = matrixAddition(s1, s2);      
		k = matrixAddition(s3, s4);      
		l = matrixAddition(s5, s1);  
		l = matrixSubraction(l, s7);  
		l = matrixSubraction(l, s3);       
		matrixRes = join(i,j,k,l,size);
		}else{
			matrixRes = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> row = new ArrayList<Integer>();
			row.add(matrixA.get(0).get(0) * matrixB.get(0).get(0));
			matrixRes.add(row);
		}
		return matrixRes;

			}
    
    private static ArrayList<ArrayList<Integer>> submatrix(ArrayList<ArrayList<Integer>> mat,int m,int n)  
    {   
    	int size = mat.size();
    	ArrayList<ArrayList<Integer>> Result = new ArrayList<ArrayList<Integer>>(); 
    	for(int i=0;i<size/2;i=i+1){
    		ArrayList<Integer> row = new ArrayList<Integer>();
    		for(int j=0;j<size/2;j=j+1)  
    			row.add(mat.get((size/2*m)+i).get((size/2*n)+j));
    		Result.add(row);
    	}
    	return Result;
    }
    
    private static ArrayList<ArrayList<Integer>> join(ArrayList<ArrayList<Integer>> a,
    		ArrayList<ArrayList<Integer>> b,
    		ArrayList<ArrayList<Integer>> c,ArrayList<ArrayList<Integer>> d 
    		,int size)  
    {  
    	

    	int i,j;
    	ArrayList<ArrayList<Integer>> Result = new ArrayList<ArrayList<Integer>>(); 
    	for( i=0;i<size/2;i=i+1){
    		ArrayList<Integer> row = new ArrayList<Integer>();
    		for( j=0;j<size/2;j=j+1){  
    			row.add(a.get(i).get(j));
    		}
    		for( j=size/2;j<size;j=j+1){  
    			row.add(b.get(i).get(j-(size/2)));
    		}
    		Result.add(row);
    	}
    	for( i=size/2;i<size;i=i+1){
    		ArrayList<Integer> row = new ArrayList<Integer>();
    		for( j=0;j<size/2;j=j+1){  
    			row.add(c.get(i-(size/2)).get(j));
    		}
    		for( j=size/2;j<size;j=j+1){  
    			row.add(d.get(i-(size/2)).get(j-(size/2)));
    		}
    		Result.add(row);
    	}
   	

   	return Result;  
    }
    

	
}
