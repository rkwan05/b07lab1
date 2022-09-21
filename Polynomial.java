public class Polynomial {
    double [] coefficients;

    public Polynomial() {
        coefficients = new double[] {0.0};
    }
    
    public Polynomial(double coefficients[]) {
    	this.coefficients = coefficients;
    }
    
    //method
    public Polynomial add(Polynomial p1) {
    	int smallestLen;
    	double largest [];
    	
    	
    	if((p1.coefficients).length < coefficients.length) {
    		smallestLen = (p1.coefficients).length;
    		largest = coefficients;
    	} else {
    		smallestLen = coefficients.length;
    		largest = (p1.coefficients);
    	}

    	Polynomial newCoefficients = new Polynomial();
    	newCoefficients.coefficients = new double[largest.length];
    	    	
    	for (int i = 0; i < largest.length; i++) {
    		if(i >= smallestLen) {
    			newCoefficients.coefficients[i] = largest[i];
    		} else {
    			newCoefficients.coefficients[i] = coefficients[i] + (p1.coefficients)[i];
    		}
    	}
    	return newCoefficients;
    }
    
    public double evaluate(double x) {
    	double result = 0.0;
    	for(int i = coefficients.length-1; i >= 0; i--) {
    		result = result + coefficients[i] * Math.pow(x, i);
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
    
}