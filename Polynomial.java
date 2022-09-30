//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.stream.IntStream;

public class Polynomial {
    double[] coefficients;
    int[] exponents;

    public Polynomial() {
        coefficients = new double[] {0.0};
        exponents = new int[] {0};
    }
    
    public Polynomial(File f){
        List<Double> coefficientsList = new ArrayList<Double>();
        List<Integer> exponentsList = new ArrayList<Integer>();
        
        BufferedReader reader;
        try {

        	reader = new BufferedReader(new FileReader(f));
        	String line = reader.readLine();
        	String split [] = line.split("(?=-)|[+/*]");
    		boolean letter = false;

        	
        	for(int i = 0; i < split.length; i++) {
        		int letterIndex = 1;
        		letter = false;

//        		System.out.println(split[i]);
        		for(int j = 0; j < split[i].length(); j++) {
        			char curr = split[i].charAt(j);
            		
            		if(curr >= 'a'&& curr <= 'z' || curr >='A' && curr <='Z') {
//            			coefficients.add(Integer.parseInt(split[i].substring(0,i)));
//            			System.out.println(coefficients.get(0));
            			letterIndex = j;
//
            			letter = true;
            		}
//            		
        		}
        		//System.out.println(letterIndex);
        		//System.out.println(Integer.parseInt(split[i].substring(0,letterIndex)));

        		if(!letter) {
            		exponentsList.add(0);
            		coefficientsList.add(Double.parseDouble(split[i]));
        		} else {
            		exponentsList.add(Integer.parseInt(split[i].substring(letterIndex+1)));
            		coefficientsList.add(Double.parseDouble(split[i].substring(0,letterIndex)));
        		}
        		
        		coefficients = new double [coefficientsList.size()];
        		exponents = new int [coefficientsList.size()];
        		
        		
        	}

            reader.close();
            
            for(int s = 0; s < coefficientsList.size(); s++) {
    			coefficients[s]=coefficientsList.get(s);
    			exponents[s]=exponentsList.get(s);
//    			System.out.println(coefficients[s]);
    		}

        } catch (IOException e) {
        	
        }
       
        
        //everything after a letter is the exponents until a plus, minus, divide or multiply (ie: operation)
    }
    
    public Polynomial(double coefficients[], int exponents[]) {
    	this.coefficients = coefficients;
    	this.exponents = exponents;
    }
    
    //method
    public Polynomial add(Polynomial p1) {
    	
    	int smallestE [];
    	int largestE [];
    	double largestC [];
    	double smallestC [];
    	
    	
    	if((p1.exponents).length < exponents.length) {
    		smallestE = (p1.exponents);
    		smallestC = p1.coefficients;
    		largestE = exponents;
    		largestC = coefficients;
    	} else {
    		smallestE = exponents;
    		smallestC = coefficients;
    		largestE = (p1.exponents);
    		largestC = p1.coefficients;
    	}
    	
    	
    	Polynomial newP = new Polynomial();
    	newP.coefficients = new double[largestE.length + smallestE.length];
    	newP.exponents = new int[largestE.length + smallestE.length];
//    	
//    	int l = largestE[0];
//    	int s = smallestE[0];
//    	int index = 0;
//    	
//    	
//    	
//    	while(l <= s) {
//    		l = largestE[index];
//    		s = smallestE[index];
//    		
////    		if(largestE[index] == smallestE[index]) {
////    			//add the coefficients together
////    			newP.coefficients[index]=(largestC[index] + smallestC[index]);
////    			newP.exponents[index]=largestE[index]; //since both exponents (smallest and largest are the same)
////    		}
//    		
//    		
//    		
//    		
//    		
//    		
//    		index+=1;
//    	}
    	
    	boolean exit = false;
    	
//    	newP.coefficients = smallestC;
    	
    	for(int c = 0; c < smallestC.length; c++) {
    		newP.coefficients[c] = smallestC[c];
    		newP.exponents[c] = smallestE[c];
    	}
//    	
//    	for(int k = 0; k < newP.coefficients.length; k++) {
//    		System.out.println(newP.coefficients[k]);
//    	}
    	
    	
//    	System.out.println(newP.coefficients.length);
    	
    	int x = 0;
    	
    	
    	for(int i = 0; i < largestE.length; i++) {
    		exit = false;
    		for(int j = 0; j < smallestE.length; j++) {
//        		System.out.println(newP.coefficients[j]);

//    			System.out.println(largestE[i]);
//    			System.out.println(smallestE[i]);
    			if(largestE[i] == smallestE[j]) {
//        			System.out.println("before");
//        			System.out.println(j);
////
    				newP.coefficients[j]+=largestC[i];
//    				System.out.println("after: ");
//    				System.out.println(newP.coefficients[j]);
    				exit = true;
    				break;
    			}
    		}
//    		System.out.println(i);
//    		System.out.println(exit);
    		if(exit==false) { //they went through all the exponents and found no matches
    			//append new exponent to the new array
    			newP.coefficients[smallestC.length + x] = largestC[i];
    			newP.exponents[smallestC.length + x] = largestE[i];
    			x++;
    		}
    		
    	}
    	
    	
    	//PRINTING THE ARRAY
    	for(int k = 0; k < newP.coefficients.length; k++) {
    		System.out.println(newP.coefficients[k]);
//    		System.out.println(newP.exponents[k]);
    	}
    	
    	
    	return newP;
    	
    }
    
    public Polynomial multiply(Polynomial p2) {
    	
    	int smallestE [];
    	int largestE [];
    	double largestC [];
    	double smallestC [];
    	
    	
    	if((p2.exponents).length < exponents.length) {
    		smallestE = (p2.exponents);
    		smallestC = p2.coefficients;
    		largestE = exponents;
    		largestC = coefficients;
    	} else {
    		smallestE = exponents;
    		smallestC = coefficients;
    		largestE = (p2.exponents);
    		largestC = p2.coefficients;
    	}
    	
    	int c = 0;
    	Polynomial newP = new Polynomial();
    	newP.coefficients = new double[largestE.length * smallestE.length];
    	newP.exponents = new int[largestE.length * smallestE.length];

    	
    	for(int i = 0; i < largestE.length; i++) {
    		for(int j = 0; j < smallestE.length; j++) {
    			int toFind = largestE[i]+smallestE[j];

    			if(!IntStream.of(newP.exponents).anyMatch(n -> n == toFind)) {	
	    			newP.exponents[c]=largestE[i]+smallestE[j];
	    			//System.out.println(newP.exponents[c]);
	    			newP.coefficients[c]=largestC[i]*smallestC[j];
	        		c++;
    			} else {
    				//System.out.println(toFind);
    				int firstIndex = 0;
    				while(newP.exponents[firstIndex] != toFind) {
    					firstIndex++;
    				}
    				//System.out.println(newP.coefficients[firstIndex]);

    				newP.coefficients[firstIndex]+= largestC[i]*smallestC[j];
    			}
    		}
    		//System.out.println(newP.exponents[j]);
    	}
    	
    	//PRINTING THE ARRAY
    	for(int k = 0; k < newP.exponents.length; k++) {
    		//System.out.println(newP.coefficients[k]);
    		//System.out.println(newP.exponents[k]);
    	}
    	
    	return newP;
    }
    
    
    public double evaluate(double x) {
    	double result = 0.0;
    	for(int i = coefficients.length-1; i >= 0; i--) {
    		result = result + coefficients[i] * Math.pow(x, exponents[i]);
    	}
    	return result;
    }
    
    public boolean hasRoot(double val) {
    	//root: value of x where the polynomial evaluates to 0
    	if(evaluate(val) == 0) {
    		return true;
    	}
    	return false;
    }
    
    public void saveToFile(String fileName) throws Exception {
    	PrintStream ps = new PrintStream(fileName);
    	String result = "";
    	for(int i = 0; i < coefficients.length; i++) {
    		if(exponents[i]==0) {
    			result += Double.toString(coefficients[i]);
    		} else {
    			if(coefficients[i]>=0.0 && i > 0) {
        			result += "+"+Double.toString(coefficients[i])+"x"+Integer.toString(exponents[i]);
    			} else if (i == 0){
        			result += Double.toString(coefficients[i])+"x"+Integer.toString(exponents[i]);
    			} else if (coefficients[i]<0.0) {
        			result += Double.toString(coefficients[i])+"x"+Integer.toString(exponents[i]);
    			}
    		}
    	}
		ps.println(result);
    }
    
}