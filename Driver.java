import java.io.File;

public class Driver {
		public static void main(String [] args) throws Exception{
//		double arr1 [] = {};
//		Polynomial p1 = new Polynomial();
//		
//		double arr2 [] = {0.0, 1.0, 1.0};
//		Polynomial p2 = new Polynomial(arr2);
//		
//		System.out.println(p1.coefficients[0]);
//		System.out.println(p2.hasRoot(-1.0));
			
//			Polynomial p = new Polynomial(); 
//			System.out.println(p.evaluate(3)); 
			double [] c1 = {7};
			int[] e1 = {5};
			Polynomial p1 = new Polynomial(c1, e1);
			double [] c2 = {1,1,-1};
			int[] e2 = {3,2,1};
			Polynomial p2 = new Polynomial(c2, e2);
			Polynomial s = p1.multiply(p2); 
			
			
			File f = new File("/Users/rkwan/Documents/UTSC/year2/Polynomial.txt");
			//Polynomial pF= new Polynomial(f);
			//System.out.println(pF.add(p2)); 
			p2.saveToFile("/Users/rkwan/Documents/UTSC/year2/Polynomial.txt");

//			System.out.println(p1.add(p2));
//			System.out.println("s(0.1) = " + s.evaluate(0.1)); 
//			if(s.hasRoot(1)) 
//			 System.out.println("1 is a root of s"); 
//			else 
//			 System.out.println("1 is not a root of s"); 
	}
}
